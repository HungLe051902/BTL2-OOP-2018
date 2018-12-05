
package project_management;
import java.util.Comparator;
public class Date implements Comparable<Date> {
    int day,month,year;

    public Date() {
        day = month = year = 0;
    }
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString(){
        if (day==month&&month==year){
            return "";
        }
        else {
            String q=Integer.toString(day),w=Integer.toString(month),e=Integer.toString(year);
            if (day<10){
                q = "0"+q;
            }
            if (month<10){
                w = "0"+w;
            }
            if (year < 1000){
                e = "0"+e;
            }
            return q+"/"+w+"/"+e;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.day;
        hash = 47 * hash + this.month;
        hash = 47 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Date o) {
        if (year>o.year){
            return 1;
        }
        else if (year<o.year){
            return -1;
        }
        else {
            if (month>o.month){
                return 1;
            }
            else if (month<o.month){
                return -1;
            }
            else {
                if (day>o.day){
                    return 1;
                }
                else if (day<o.day){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
   

    
    
}
