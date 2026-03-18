package org.skypro.skyshop.searchable;

public interface Searchable {
    String searchTerm();

    String getOfTypeContent();

    String getName();

    default String getStringRepresentation() {
        return "Название: " + getName() + " Тип: " + getOfTypeContent();
    }

}
