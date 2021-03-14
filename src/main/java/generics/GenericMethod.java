package generics;

import java.util.List;

public class GenericMethod {
    public static List arrayToList(Object array[], List<Object> list) {
        for(Object element : array) {
            list.add(element);    
        }

        return list;
    }
}