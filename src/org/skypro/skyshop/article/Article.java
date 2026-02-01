package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    private final String nameOfArticle;
    private final String text;
    public Article(String name, String text){
        this.nameOfArticle =name;
        this.text=text;
    }
    @Override
    public String toString(){
        return "Название статьи: "+ nameOfArticle +". Текст статьи: "+ text;
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
}
