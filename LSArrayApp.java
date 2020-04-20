
/**
 * @author Tshilidzi
 * 27/02/2020
 * reads in data from the file and then creates an Array
 */

import java.io.*;
import java.util.Scanner;

public class LSArrayApp {
    private int count = 0; // Gives you the number of times comparing operations were done
    private LoadShedding[] array = new LoadShedding[2976]; // Creates an empty array of LoadShedding objects
    private Scanner input = null;

    /**
     * Read in the data and you get the area of a specific period
     */
    public LSArrayApp() {
        /*
         * Read in the data and print out all the objects in the array
         * and also is a constructor
         */
        try {
            input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println(0);
        }
        LoadShedding data;
        // the following while loop breaks up each line into period and area to create
        // loadshedding objects
        // and then adds the objects to the array
        int i = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            int space = line.indexOf(" ");
            String period = line.substring(0, space); // to get the period
            String area = line.substring(space, line.length()); // to get the area
            data = new LoadShedding(period, area);
            array[i] = data;
            i++;
        }
        input.close();
        this.printAllAreas();
    }

    /**
     * Read in the data and you get the area of a specific period
     * 
     * @param stage the stage of the load shedding
     * @param date  the date at which the loadshedding is going to happen
     * @param time  the time at which it is going to start
     */
    public LSArrayApp(String stage, String date, String time) {
        // String p = stage+"_"+date+"_"+time; //combines stage,date and startTime to
        // make period
        try {
            input = new Scanner(new FileInputStream(
                    "C:\\Users\\Tshilidzi Mphelo\\Pictures\\dowload\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println(0);
        }
        LoadShedding data;

        int i = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            int space = line.indexOf(" ");
            String period = line.substring(0, space);
            String area = line.substring(space, line.length());
            data = new LoadShedding(period, area);
            array[i] = data;
            i++;
        }
        input.close();
        this.printAreas(stage, date, time);
    }

    /**
     * akes stage, date and startTime
     * uses a for loop to search through the array for the loadshedding with the
     * same period
     * the loop terminates once this is found
     * 
     * @param stage
     * @param date
     * @param startTime
     */
    public void printAreas(String stage, String date, String startTime) {

        String string = stage + "_" + date + "_" + startTime;
        for (int j = 0; j < 2976; j++) {
            if (string.equals(array[j].getPeriod())) {
                int space = array[j].toString().indexOf(" ");
                String strin = array[j].toString();
                System.out.println(strin.substring(space));
                break;
            }
            count++;
        }
    }

    /**
     * prints out the entire array
     */
    public void printAllAreas() {
        for (int k = 0; k < 2976; k++) {
            System.out.println(array[k].toString());
        }
    }

    /**
     * Returns count
     * 
     * @return size of count
     */

    public int getCount() {
        return count;
    }
}
