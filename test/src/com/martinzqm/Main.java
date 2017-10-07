package com.martinzqm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d}, %s",
                index, obj.toString()));
    }

    public static void demoString() {
        String str = "hello nowcoder";
        print(1, str.indexOf('e'));
        print(2, str.charAt(6));
        print(3, str.codePointAt(1));
        print(4, str.compareTo("hello nowcoder"));
        print(5, str.compareTo("hello pwocoder"));
        print(6, str.compareToIgnoreCase("Hello Nowcoder"));
        print(7, str.concat("!!!"));
        print(8, str.contains("hello"));
        print(9, str.endsWith("xowcoder"));
        print(10, str.startsWith("hello"));
        print(11, str.lastIndexOf('o'));
        print(12, str.toUpperCase());
        print(13, str.replace('o', 'a'));
        print(14, str.replaceAll("o|l", "a"));
        print(15, str.replaceAll("hello", "hi"));
    }

    public static  void demoList() {
        List<String> strList = new ArrayList<String>();
        List<String> strList1 = new LinkedList<String>();
        Vector<String> vector = new Vector<>();
        for (int i = 0; i < 4; i++) {
            strList.add(String.valueOf(i));
        }
        print(1, strList);
        List<String> strListB = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            strListB.add(String.valueOf(i*i));
        }
        strList.addAll(strListB);
        print(2, strList);
        strList.remove(0);
        print(3, strList);
        strList.remove(String.valueOf(1));
        print(4, strList);
        print(5, strList.get(1));

        Collections.sort(strList);
        print(6, strList);
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(7, strList);
        Collections.reverse(strList);
        print(8, strList);

        int[] array = new int[]{1, 2, 3};
        print(9, array[1]);
    }

    public static void demoSet() {
        Set<String> strSet = new HashSet<String>();
        for (int i = 0; i < 3; i++) {
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
        }
        print(1, strSet);
        strSet.remove("1");
        print(2, strSet);
        print(3, strSet.contains("4"));
        strSet.addAll(Arrays.asList(new String[]{"A", "B", "C"}));
        print(4, strSet);

        for (String value : strSet) {
            print(5, value);
        }
    }

    public static void demoKeyValue() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        print(1, map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + ":" + entry.getValue());
        }
        print(3, map.keySet());
        print(4, map.values());
        print(5, map.containsKey("2"));
        print(6, map.get("1"));
        map.replace("1", "A");
        print(7, map);
    }

    public static void demoException() {
        try {
            print(1, "hello");
            int a = 2;
          //a = a / 0;
            String b = null;
            b.indexOf('a');

        } catch (NullPointerException npe) {
            print(3, "NPE");
        } catch (Exception e) {
            print(4, "Exception");
        } finally {
            print(2, "finally");
            //做清理工作
        }
    }

    public static void demoCommon() {
        Random random = new Random();
        random.setSeed(1);
        for (int i = 0; i < 4; ++i) {
            print(1, random.nextInt(100));
            print(2, random.nextDouble());
        }
        List<Integer> array = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        print(3, array);
        Collections.shuffle(array);
        print(4, array);

        Date date = new Date();
        print(5, date);
        print(6, date.getTime());
        DateFormat df = new SimpleDateFormat("HH:mm:ss yyy/MM/dd");
        print(7, df.format(date));
        print(8, DateFormat.getDateInstance(DateFormat.FULL).format(date));


        print(9, UUID.randomUUID());
        print(10, Math.max(1, 2));
        print(11, Math.ceil(2.5));
        print(12, Math.floor(2.5));
        print(13, Math.log(2.71));  //e
    }

    public static void demoClass(){
        Talking animal = new Animal("dog", 25);
        animal.say();
        animal = new Human("martin", 15, "china");
        animal.say();
    }

    public static void main(String[] args) {
        //demoString();
        //demoList();
        //demoSet();
        //demoKeyValue();
        //demoException();
        //demoCommon();
        //demoClass();
        System.out.println(" ".length());
    }
}
