package DoubleNumericIntegrate.Utility;

import DoubleNumericIntegrate.Utility.terminal.TerminalInterface;

import java.util.Stack;

public class UCMutableArray {
    private Object[] content;
    private int capacity;
    private int pointerMin;
    private int pointerMax;

    private void alterArray() {
        int newCapacity = this.capacity;
        Object[] newArray = new Object[newCapacity];
        int alterArrayPointerMax = this.content.length;
        if (this.capacity < alterArrayPointerMax) {
            alterArrayPointerMax = this.capacity;
        }
        System.arraycopy(this.content, 0, newArray, 0, alterArrayPointerMax);
        this.content = newArray;
    }

    private void onUpdate() {
        if (this.length() == this.capacity) {
            this.capacity += 10;
            this.alterArray();
        } else if (this.length() < this.capacity - 11) {
            this.capacity -= 10;
            this.alterArray();
        }
    }

    public UCMutableArray() {
        this.pointerMin = 0;
        this.pointerMax = -1;//in order to make sure 1st object to be update correctly.
        this.content = new Object[10];
        this.capacity = 10;
    }

    public int length() {
        return (this.pointerMax - this.pointerMin + 1);
    }

    public Object getObjectAtPointer(int pointer) throws Exception {
        if (this.pointerMin <= pointer && pointer <= this.pointerMax) {
            return this.content[pointer];
        } else {
            throw new Exception("index out of range");
        }
    }

    public void appendObject(Object object) {
        this.pointerMax++;
        this.content[this.pointerMax] = object;
        this.onUpdate();
    }

    public void dropObjectAtPointer(int pointer) throws Exception {
        if (this.pointerMin <= pointer && pointer <= this.pointerMax) {
            this.pointerMax--;
            for (int irritationPointer = pointer; irritationPointer < pointerMax+1; irritationPointer++) {
                this.content[irritationPointer]=this.content[irritationPointer+1];
                this.content[irritationPointer+1]=null;
            }
        } else {
            throw new Exception("index out of range");
        }
        this.onUpdate();
    }

    public void dropAllObjects(){
        this.pointerMin = 0;
        this.pointerMax = -1;
        this.content = new Object[10];
        this.capacity = 10;
    }

    public Stack getContentAsStack(){
        Stack result = new Stack();
        for (int pointer=0;pointer<length();pointer++) {
            Object obj = content[pointer];
            //noinspection unchecked
            result.push(obj);
        }
        return result;
    }
    
    public Object[] getContentAsArray(){
        Object[] arr = new Object[length()];
        for (int i = 0; i < length(); i++) {
            try{
                arr[i]=this.getObjectAtPointer(i);
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        result.append("\nUCMutableArray{");
        for (Object objectAtPointer:getContentAsArray()) {
            result.append("\t");
            result.append(objectAtPointer.toString());
            result.append("\n");
        }
        result.append("}\n");
        return result.toString();
    }

    public String toStringParagraph() {
        StringBuilder result= new StringBuilder();
        for (Object objectAtPointer:getContentAsArray()) {
            result.append(objectAtPointer.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public String toStringParagraphWithPrefixAndPostfix(String prefix,String postfix) {
        StringBuilder result= new StringBuilder();
        for (Object objectAtPointer:getContentAsArray()) {
            result.append(prefix);
            result.append(objectAtPointer.toString());
            result.append(postfix);
            result.append("\n");
        }
        return result.toString();
    }

    public int indexOfObject(Object object) throws Exception{
        for (int pointer = 0; pointer < length(); pointer++) {
            if (this.getContentAsArray()[pointer].equals(object)){
                return pointer;
            }
        }
        throw new Exception("Object Not Found!");
    }

    public boolean contains(Object object){
        for (int pointer = 0;pointer<length();pointer++) {
            Object objectAtPointer = null;
            try {
                objectAtPointer = getObjectAtPointer(pointer);
            } catch (Exception exception){
                TerminalInterface.printErrorInf(exception);
            }
            if (objectAtPointer!=null) {
                if (objectAtPointer.equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }
}
