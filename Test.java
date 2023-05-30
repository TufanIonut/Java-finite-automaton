
public class Test{
    public static void main(String[] args) throws Exception {
        String cuvant= "aabba";
        
        //Scanner sc= new Scanner(System.in);
        //cuvant= sc.nextLine();
        Automat auto = new Automat("D:\\Proiect\\automat.txt");
        System.out.println(auto.analizaCuvant(cuvant));
        auto.afiseaza();
       // sc.close();
        
    }
}
