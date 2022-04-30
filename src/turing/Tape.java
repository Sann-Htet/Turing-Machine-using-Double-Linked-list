package turing;
/**
 * This class represents the tape in class TuringMachine
 * and created using Cell class
 * add the operations
 */
public class Tape {
    /*Create an instance variable for a Cell to show and use the current cell*/
    public Cell currentCell;

    /*Default constructor to create new current cell*/
    public Tape(){
        this.currentCell = new Cell();
        currentCell.content = ' ';
        currentCell.next = null;
        currentCell.prev = null;
    }

    /**
     * get the current cell location
     * @return return the reference of current cell
     */
    public Cell getCurrentCell(){
        return currentCell;
    }

    /**
     * Getter method to get the content of the current cell
     * @return return the character in the current cell
     */
    public char getContent(){
        return currentCell.content;
    }

    /**
     * Setter method for this class to set the current cell content
     * @param ch set the character to the currentCell's content
     */
    public void setContent(char ch){
        currentCell.content = ch;
    }

    /**
     * move the current cell to the left
     */
    public void moveLeft(){
        /*Create a new cell, if no cell exists and move to the left*/
        if (currentCell.prev == null){
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = currentCell;
            newCell.prev = null;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;
    }

    /**
     * move the current cell to the right
     */
    public void moveRight(){
        /*Create a new cell if no cell exists
        in the right of the current cell*/
        if (currentCell.next == null){
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = currentCell;
            newCell.next = null;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    /**
     * get the character in each cell from left to right
     * and combine all the characters
     * @return return String which combined all the characters in each cell
     */
    public String getTapeContents(){
        Cell pointer = currentCell;
        while(pointer.prev != null){
            pointer = pointer.prev;
        }
        StringBuilder contents = new StringBuilder();
        while(pointer != null){
                contents.append(pointer.content);
                pointer = pointer.next;
        }
        /*Return the contents of the tape*/
        return contents.toString();
    }
}