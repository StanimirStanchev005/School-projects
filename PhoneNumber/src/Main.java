import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static boolean validate(String phoneNumber){
        Pattern pattern = Pattern.compile("^((\\+|00)359|0)?8[7-9][2-9]\\d{6}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void menu(){
        System.out.println("1.Add pair");
        System.out.println("2.Delete pair by name");
        System.out.println("3.Search phone by name");
        System.out.println("4.Print all");
        System.out.println("5.Exit");
        
    }
    public static void addPair(ArrayList<Pair> arr){
        Pair obj = new Pair();
        System.out.println("Input name");
        obj.name = input.next();
        System.out.println("Input phone number");
        obj.phone=input.next();
        boolean isValid = validate(obj.phone);
        if(isValid){
        arr.add(obj);
        }else
            System.out.println("Invalid phone number!");

    }
    public static void deletePair(ArrayList<Pair> arr){
        System.out.println("Enter name to delete");
        String name = input.next();
        for (int i=0;i<arr.size();i++) {
            if(arr.get(i).name.equals(name)) {
                arr.remove(i);
            }
        }
    }
    public static void searchName(ArrayList<Pair> arr){
        System.out.println("Enter name to search");
        String name = input.next();
        for (Pair i: arr ) {
            if(i.name.equals(name)) {
                System.out.println(i.name+" "+i.phone);
            }
        }
    }
    public static void printAll(ArrayList<Pair> arr){
        System.out.println("Enter name to delete");
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j).name.compareTo(arr.get(j+1).name) > 0) {
                    Pair temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
        for (Pair i: arr ) {
            System.out.println(i.name+" "+i.phone);
        }

    }
    public static void main(String[] args) throws IOException {


        ArrayList<Pair> pairs = new ArrayList<>();


        int ans;
        do{
            menu();
            ans=input.nextInt();
            switch (ans){
                case 1:
                    addPair(pairs);
                    break;
                case 2:
                    deletePair(pairs);
                    break;
                case 3:
                    searchName(pairs);
                    break;
                case 4:
                    printAll(pairs);
                    break;
            }
        }while(ans != 5);


            Path path = Paths.get("C:\\Users\\NotchBG\\IdeaProjects\\PhoneNumber\\output.txt");
            String text = "";
            for (Pair obj : pairs) {
                text += obj.name+" "+obj.phone+"\n";
            }
        System.out.println(text);
        Files.writeString(path,text, StandardCharsets.UTF_8 );

    }
}