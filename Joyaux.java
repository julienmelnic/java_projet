//Haithem Boucherara 28710882
//Julien Melnic 21104020
public class Joyaux extends Contenu{

    public Joyaux(String nom){
        super(nom,(int)(Math.random()*2000 + 1));
    }
    public String toString(){
        return super.toString();
    }
}