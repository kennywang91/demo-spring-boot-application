package com.example.demo.services;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.OpenLibraryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExternalBookService {
    private final WebClient webClient;

    public ExternalBookService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://openlibrary.org").build();
    }

    public List<BookDto> searchBooks(String query) {
        Mono<OpenLibraryResponse> responseMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search.json")
                        .queryParam("q", query)
                        .build())
                .retrieve()
                .bodyToMono(OpenLibraryResponse.class);

        OpenLibraryResponse response = responseMono.block();

        if (response == null || response.getDocs() == null) {
            return List.of();
        }

        return response.getDocs().stream()
                .map(doc -> new BookDto(
                        doc.getTitle(),
                        doc.getAuthor_name() != null && !doc.getAuthor_name().isEmpty()
                                ? doc.getAuthor_name().get(0) : "Unknown",
                        doc.getFirst_publish_year()
                ))
                .collect(Collectors.toList());
    }
}
