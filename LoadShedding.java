// Tshilidzi Mphelo
// 26/02/2020
// LoadShedding class

public class LoadShedding {

    // LoadShedding class is going to store each line from the file as period and
    // area
    private String period; // i.e. period = stage+"_"+date+"_"+startTime
    private String area;

    /**
     * argument constructor for the loadshedding object
     * 
     * @param p this is the period of the loadshedding object
     * @param a this is the area of the loadshedding object
     */
    public LoadShedding(String p, String a) {
        // argument constructor for the loadshedding object
        this.period = p;
        this.area = a;
    }

    /**
     * returns the period of the loadshedding object
     */
    public String getPeriod() {
        // returns the period of the loadshedding object
        return period;
    }

    /**
     * returns the areas of the loadshedding object
     */
    public String getArea() {
        // returns the area of the loadshedding object
        return area;
    }

    /**
     * compares loadshedding objects to see if the are equal or not
     * this is done by comparing the periods and areas
     * returns 0 if they are equal, 1 if the calling object is greater than given
     * load shedding object
     * and -1 if the calling object is less than the given object
     * 
     * @param other this has to be another loadsheddin object
     */
    public int compareTo(LoadShedding other) {
        String p1 = this.period;
        String p2 = other.getPeriod();

        if (p1.substring(0, 1).compareTo(p2.substring(0, 1)) > 0) {
            return 1;
        } else if (p1.substring(0, 1).compareTo(p2.substring(0, 1)) < 0) {
            return -1;
        } else {
            p1 = p1.substring(2); // updating p1 and p2 to compare the dates
            p2 = p2.substring(2);

            if (p1.substring(0, p1.indexOf("_")).compareTo(p2.substring(0, p2.indexOf("_"))) > 0) {
                return 1;
            } else if (p1.substring(0, p1.indexOf("_")).compareTo(p2.substring(0, p2.indexOf("_"))) < 0) {
                return -1;
            } else {
                p1 = p1.substring(p1.indexOf("_") + 1); // updating p1 and p2 to compare the startTimes
                p2 = p2.substring(p2.indexOf("_") + 1);

                if (p1.compareTo(p2) > 0) {
                    return 1;
                } else if (p1.compareTo(p2) < 0) {
                    return -1;
                }
                return 0;
            }

        }
    }

    /**
     * gives you a string version of loadshedding
     * 
     * @return the loadSHedding object
     */
    public String toString() {
        // gives you a string version of loadshedding
        return period + area;
    }
}
