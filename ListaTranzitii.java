import java.util.ArrayList;

public class ListaTranzitii {
    ArrayList<Tranzitie> lista= new ArrayList<Tranzitie>();
    
    void adaugaTranzitie(Tranzitie tr)
    {
       this.lista.add(tr); 
    }
    
    Tranzitie gasesteTranzitie(String stare,char simbol)
    {
        for (int i=0;i<this.lista.size();i++)
        {
            Tranzitie tr= this.lista.get(i);
            if(tr.spuneStInceput().equals(stare)&&tr.spuneSimbol()==simbol)
            {
                return tr;
            }
        }
            return null;
    }

}
