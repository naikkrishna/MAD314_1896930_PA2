package com.example.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Listrepository {
    //SINGLETON PATTERN
    private static Listrepository instance = null;
    private List<student> datas = new ArrayList<>();
//private constructor
    //class is type and factor
    //create object of a type

    private Listrepository() {
       student items = new student();
        items.uname = "krishna";
        items.uid= 12;
        items.upassword = "abc";

        this.datas.add(items);
    }

    //static access via class
    public static Listrepository getInstance() {
        if (instance == null) {
            instance = new Listrepository();
        }
        return instance;
    }

    public void addstudent( student items) {
        this.datas.add(items);
    }

    public List<student> getstudent() {
        return this.datas;
    }
}

