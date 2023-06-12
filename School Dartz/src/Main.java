import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int Point(double x, double y) {
        double d = Math.hypot(x, y);
        if (d > 10) {
            return 0;
        } else if (d <= 10 && d > 5) {
            return 1;
        } else if (d <= 5 && d > 2.5) {
            return 5;
        } else if (d <= 2.5) {
            return 10;
        }
        return 0;
    }

    public static void Sort(Competitor[] comp) {
        Competitor temp;
        for (int i = 0; i < comp.length-1; i++) {
            for (int j = 0; j < comp.length-i-1; j++) {
                if (comp[j].pointSum(comp[j].points) < comp[j+1].pointSum(comp[j+1].points)) {
                    temp = comp[j];
                    comp[j] = comp[j + 1];
                    comp[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < comp.length; i++) {
            comp[i].print(comp[i].points);
        }
    }

    public static void sortSchools(School arr[]){
        School temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j].points < arr[j+1].points) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) arr[i].print();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.println("Брой състезатели: ");
            n = input.nextInt();
        } while (n < 1);
        Competitor comp[] = new Competitor[n];
        ArrayList<String> sNames = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            comp[i] = new Competitor();
            System.out.println("Въведете име за състезател "+(i+1));
            comp[i].setName(input.next());
            System.out.println("Въведете училище ");
            comp[i].setSchool(input.next());
            sNames.add(comp[i].getSchool());
            System.out.println("Брой опити ");
            int m = input.nextInt();
            comp[i].points = new int[m];
            for (int j = 0; j < m; j++) {
                System.out.println("Въведете х" + j);
                double x = input.nextDouble();
                System.out.println("Въведете у" + j);
                double y = input.nextDouble();

                comp[i].points[j] = Point(x, y);
            }
        }
        //Remove repeating names
        for(int i=0;i<sNames.size();i++){
            for(int j=i+1;j<sNames.size();j++){
               if(sNames.get(i).equals(sNames.get(j))){
                    sNames.remove(j);
                }
            }
        }

        School schools[] = new School[sNames.size()];
        for(int i=0; i<schools.length;i++){
            int sum=0;
            schools[i]= new School();
            schools[i].name = sNames.get(i);
            for(int j=0;j<comp.length;j++){
                if(comp[j].getSchool().equals(schools[i].name)){
                    sum += comp[j].pointSum(comp[j].points);
                }
                schools[i].points = sum;
            }
        }
        System.out.println("Всички съзтезатели");
        for (int i = 0; i < n; i++) {
            comp[i].print(comp[i].points);
            System.out.println(" ");
        }

        System.out.println("\nСъзтезателите сортирани ");
        Sort(comp);
        System.out.println("\nУчилищата сортирани");
        sortSchools(schools);
    }
}