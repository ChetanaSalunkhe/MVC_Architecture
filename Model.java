package com.example.mvc_designpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    private List<Integer> list;

    //constructor
    public Model(){
        list = new ArrayList<Integer>(3);

        list.add(2);
        list.add(3);
        list.add(5);
    }

    // defining getter and setter functions
    public List<Integer> getList() { return list; }

    public void setList(List<Integer> list) { this.list = list; }

    // function to return appropriate count
    // value at correct index
    public int getValueAtIndex(final int index) throws IndexOutOfBoundsException{ return list.get(index); }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setValueAtIndex(final int index) throws IndexOutOfBoundsException{
        list.set(index,getSquare(list.get(index)));
        setChanged();
        notifyObservers();
    }

    public int getSquare(int val){
        int value = val * val;
        return value;

    }
}
