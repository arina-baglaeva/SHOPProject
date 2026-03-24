package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String nameOfArticle;
    private final String text;

    public Article(String name, String text) {
        this.nameOfArticle = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название статьи: " + nameOfArticle + ". Текст статьи: " + text;
    }

    @Override
    public String searchTerm() {
        return nameOfArticle + " " + text;
    }

    @Override
    public String getOfTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getOfNameObject() {
        return nameOfArticle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Article other = (Article) obj;
        return Objects.equals(this.nameOfArticle, other.nameOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfArticle);
    }
}
