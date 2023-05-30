import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
public class Automat{
    private String st_init;
    private String st_finale[];
    private ListaTranzitii lt = new ListaTranzitii();
    
    Automat(String nume_fis) throws Exception{
        BufferedReader buf = new BufferedReader(new FileReader(nume_fis));
        this.st_init = buf.readLine();
        String st_finale_str = buf.readLine();
        this.st_finale = st_finale_str.split(" ");
        while(true){
            String linie = buf.readLine();
            if(linie == null)
                break;
            else {
                String tbl[] = linie.split(" ");
                Tranzitie tr = new Tranzitie(tbl[0],tbl[1].charAt(0),tbl[2]);
                this.lt.adaugaTranzitie(tr);
            }
        }
        buf.close();
    }
        
    boolean analizaCuvant(String cuvant)
    {
    String stare = st_init;
    for(int i=0;i < cuvant.length();i++)
    {       
        if(lt.gasesteTranzitie(stare, cuvant.charAt(i))==null){
            return false;
        }
        stare=lt.gasesteTranzitie(stare,cuvant.charAt(i)).spuneStSfarsit();
    }
    for (int j = 0; j < st_finale.length; j++) {
        if(stare.equals(st_finale[j])){
            return true;
        }
    }
    return false;
}
 
public void afiseaza()
{
    HashSet<String> hSet = new HashSet<>();
    System.out.println("Starea initiala: " + st_init);
    System.out.print("Stari finale: ");
    for(int i=0;i<st_finale.length;i++)
    {
        System.out.print(st_finale[i] + " ");
    }
    System.out.println();
    
    for(Tranzitie tranzitie:lt.lista)
    {
        hSet.add(tranzitie.spuneStInceput());
        hSet.add(tranzitie.spuneStSfarsit());
        
    }
    for (String string : hSet) {
        System.out.println(string);
    }
}
   
}

