package dataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DBControlMetodist {

//метод возвращает список классов
    public static final List<String> gradeList(List<String> grade) {

        Set set=new TreeSet(grade);
        ArrayList<String> gradeList=new ArrayList<>(set);
        return gradeList;
    }
}