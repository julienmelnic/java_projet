//Haithem Boucherara 28710882
//Julien Melnic 21104020
import java.util.ArrayList;
public class Agent2{
    private int posX;
    private int posY;
    private ArrayList<Joyaux> sacJoyaux;
    public Agent2(){
        this.posX=-1;
        this.posY=-1;
        this.sacJoyaux=new ArrayList<Joyaux>();
    }
    
    public void seDeplacer(int xnew,int ynew,Grille g)throws DeplacementIncorrecteException,CoordonneesIncorrectesException,CaseNonPleineException{
        if(!g.sontValides(xnew,ynew))throw new DeplacementIncorrecteException("Deplacement impossible ligne "+xnew+ "n'existe pas,Deplacement impossible colonne "+ynew+" n'existe pas");
        //try{
            Contenu a=g.getCase(xnew,ynew);
        //}catch(CoordonneesIncorrectesException e){
          //  System.out.println(e);
        //}
        if(a instanceof Joyaux){
            sacJoyaux.add((Joyaux)a);
            g.videCase(xnew,ynew);
            System.out.println("l'Agent tombe sur un joyaux");
        }
        else if(a instanceof Gardien){
            sacJoyaux.clear();
            System.out.println("l'Agent tombe sur un gardien et perds les joyaux");
        }

    }
    public void seDeplacer(int xnew , int ynew , int f, Grille g)throws DeplacementIncorrecteException,CoordonneesIncorrectesException,CaseNonPleineException{
        if(!g.sontValides(xnew,ynew))throw new DeplacementIncorrecteException("Deplacement impossible ligne "+xnew+ "n'existe pas,Deplacement impossible colonne "+ynew+" n'existe pas");
        //try{
            Contenu a=g.getCase(xnew,ynew);
        //}catch(CoordonneesIncorrectesException e){
          //  System.out.println(e);
        //}
        if(a instanceof Joyaux){
            sacJoyaux.add((Joyaux)a);
            g.videCase(xnew,ynew);
            System.out.println("l'Agent tombe sur un joyaux");
        }
        else if(a instanceof Gardien){
            if(a.getQuantite()<=f){
                g.videCase(xnew,ynew);
                System.out.println("l'Agent tue le gardien");
            }
            else if(a.getQuantite()>f){
            sacJoyaux.clear();
            System.out.println("l'Agent tombe sur un gardien se bat et perds ses joyaux");
            a.setQuantite(a.getQuantite()-f);
            }
        }
    }
    public int fortune(){
        int sum=0;
        for(Joyaux j :sacJoyaux){
            sum+=j.getQuantite();
        }
        return sum;
    }
    public ArrayList<Joyaux> contenuSac(){
        for(Joyaux j: sacJoyaux){
            System.out.println(j.toString());
        }
        return this.sacJoyaux;
    }
    public String toString(){
        return "L'agent posx= "+this.posX+"; posY= "+this.posY+" fortune="+this.fortune();
    }


}
    