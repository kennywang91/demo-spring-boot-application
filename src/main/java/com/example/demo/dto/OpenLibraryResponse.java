package com.example.demo.dto;

import java.util.List;

public class OpenLibraryResponse {
    private List<Doc> docs;

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public static class Doc {
        private String title;
        private List<String> author_name;
        private Integer first_publish_year;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(List<String> author_name) {
            this.author_name = author_name;
        }

        public Integer getFirst_publish_year() {
            return first_publish_year;
        }

        public void setFirst_publish_year(Integer first_publish_year) {
            this.first_publish_year = first_publish_year;
        }
    }
}
