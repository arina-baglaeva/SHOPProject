package org.skypro.skyshop.searchable;

public class SearchEngine {
    public Searchable[] arrOfAll;
    public SearchEngine(int n){
        arrOfAll= new Searchable[n];
    }
    public Searchable[] search(String s){
        Searchable[] arr=new Searchable[5];
        int c=0;
        for(int i=0; i< arrOfAll.length; i++) {
            if (arrOfAll[i]!=null&& arrOfAll[i].searchTerm().toLowerCase().contains(s.toLowerCase())) {
                arr[c] = arrOfAll[i];
                c++;
            }
            if (c > 4)
                break;
        }
        System.out.println("Поиск по списку: ");
        return arr;
    }
    public void add(Searchable obj){
        boolean f = false;
        for(int i=0; i< arrOfAll.length; i++){
            if(arrOfAll[i]==null){
                arrOfAll[i]=obj;
                f=true;
                break;
            }
        }
        if(f){
            System.out.println("Добавлено в список: "+ obj.getOfNameObject());
        }
        else{
            System.out.println("Нет мест в списке!");
        }
    }
}
