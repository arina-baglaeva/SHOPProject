package org.skypro.skyshop.searchable;

public interface Searchable {
    String searchTerm();

    String getOfTypeContent();

    String getOfNameObject();

    default String getStringRepresentation() {
        return "Имя: " + getOfNameObject() + " Тип: " + getOfTypeContent();
    }
}
