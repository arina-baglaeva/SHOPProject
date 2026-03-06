package org.skypro.skyshop.searchable;

import java.util.*;

public class SearchEngine {
    public HashSet<Searchable> arrOfAll;

    public SearchEngine() {
        arrOfAll = new HashSet<>();
    }

    public TreeSet<Searchable> search(String s) {
        TreeSet<Searchable> arr = new TreeSet<>(new SortedBySize());
        for (Searchable searchable : arrOfAll) {
            if (searchable != null && searchable.searchTerm().toLowerCase().contains(s.toLowerCase())) {
                arr.add(searchable);
            }
        }
        System.out.println("Поиск по списку: ");
        return arr;
    }

    public void add(Searchable obj) {
        arrOfAll.add(obj);
        System.out.println("Добавлено в список: " + obj.getOfNameObject());
    }

    public Searchable findBestMatch(String s) throws BestResultNotFound {

        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable i : arrOfAll) {
            if (i != null) {
                int count = 0;
                int ind = 0;
                int ind_s = i.searchTerm().toLowerCase().indexOf(s, ind);
                while (ind_s != -1) {
                    count++;
                    ind = ind_s + s.length();
                    ind_s = i.searchTerm().toLowerCase().indexOf(s, ind);
                }
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = i;
                }
            }
        }
        if (maxCount == 0) {
            throw new BestResultNotFound("Для запроса: " + s + " - не нашлось подходящей статьи.");
        }
        return bestMatch;
    }

    private static class SortedBySize implements Comparator<Searchable> {

        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.compare(o2.getOfNameObject().length(), o1.getOfNameObject().length());
            if (lengthCompare == 0) {
                return o1.getOfNameObject().compareTo(o2.getOfNameObject());
            }
            return lengthCompare;

        }
    }
}
