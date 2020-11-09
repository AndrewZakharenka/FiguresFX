package com.teachmeskills.figuresfx.customExceptions;

public class IsEmptyArrayListException extends Exception{
    public IsEmptyArrayListException() {
        super("В массиве отсутствуют фигуры!");
    }
}
