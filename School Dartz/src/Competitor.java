public class Competitor {
    private String name;
    private String school;
    public int points[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int pointSum(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    public void print(int arr[]){
        System.out.println("Име: "+getName()+"\tУчилище: "+getSchool());
        for(int i=0; i<arr.length;i++){
            System.out.print("\tТочки за задача "+i+": "+arr[i]+"\t");
        }
        System.out.println("Сума: "+pointSum(arr));
    }


}