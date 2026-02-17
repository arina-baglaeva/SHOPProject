package org.skypro.skyshop.searchable;

import java.util.*;

public class SearchEngine {
    public List<Searchable> arrOfAll;

    public SearchEngine() {
        arrOfAll = new LinkedList<>();
    }

    public TreeMap<String, Searchable> search(String s) {
        TreeMap<String, Searchable> arr = new TreeMap<>();
        for (Searchable searchable : arrOfAll) {
            if (searchable != null && searchable.searchTerm().toLowerCase().contains(s.toLowerCase())) {
                arr.put(searchable.getOfNameObject(), searchable);
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
        int[] counts = new int[arrOfAll.size()];
        int ind = 0;
        int count = 0;
        int mx = 0;
        for (int i = 0; i < arrOfAll.size(); i++) {
            if (arrOfAll.get(i) != null) {
                int ind_s = arrOfAll.get(i).searchTerm().indexOf(s, ind);
                while (ind_s != -1) {
                    count++;
                    ind = ind_s + s.length();
                    ind_s = arrOfAll.get(i).searchTerm().indexOf(s, ind);
                }
                counts[i] = count;
                if (count > counts[mx]) mx = i;
                count = 0;
            }
        }
        if (counts[mx] == 0) {
            throw new BestResultNotFound("Для запроса: " + s + " - не нашлось подходящей статьи.");
        }
        return arrOfAll.get(mx);

    }
}
