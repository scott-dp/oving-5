import java.util.Scanner;
public class Fraction{
    int teller;
    int nevner=1;
    Fraction result;
    public Fraction(int teller, int nevner){
        if(nevner==0){
            throw new IllegalArgumentException();
        }
        this.teller=teller;
        this.nevner=nevner;
    }
    public Fraction(int teller){
        this.teller=teller;
    }
    public int getTeller(){
        return teller;
    }
    public int getNevner(){
        return nevner;
    }
    public String getResult(){
        return this.result.getTeller()+"/"+this.result.getNevner();
    }
    public String toString(){
        return this.getTeller()+"/"+this.getNevner();
    }

    public static Fraction[] lagFellesNevner(Fraction f1, Fraction f2){
        Fraction brok1=new Fraction(f1.getTeller()*f2.getNevner(),f1.getNevner()*f2.getNevner());
        Fraction brok2=new Fraction(f2.getTeller()*f1.getNevner(),f2.getNevner()*f1.getNevner());
        Fraction[] fellesBrok={brok1,brok2};//brok1 er this og brok2 er en annen brok
        return fellesBrok;
    }

    public void summer(Fraction anotherFraction){
        Fraction[] brokMedFellesnevner=lagFellesNevner(this, anotherFraction);

        Fraction b1=brokMedFellesnevner[0];
        Fraction b2=brokMedFellesnevner[1];

        result=new Fraction(b1.getTeller()+b2.getTeller(),b1.getNevner());
    }

    public void subtraher(Fraction anotherFraction){
        Fraction[] brokMedFellesnevner=lagFellesNevner(this, anotherFraction);

        Fraction b1=brokMedFellesnevner[0];
        Fraction b2=brokMedFellesnevner[1];

        result=new Fraction(b1.getTeller()-b2.getTeller(),b1.getNevner());
    }
    public void multipliser(Fraction anotherFraction){
        int nyTeller=this.getTeller()*anotherFraction.getTeller();
        int nyNevner=this.getNevner()*anotherFraction.getNevner();

        result=new Fraction(nyTeller,nyNevner);
    }

    public void divider(Fraction anotherFraction){
        Fraction flippedFraction=new Fraction(anotherFraction.getNevner(),anotherFraction.getTeller());
        this.multipliser(flippedFraction);
    }

    public static void main(String[] args){
        //create an instance of class fraction
        Fraction broek=new Fraction(2);
        System.out.println("Brøk 1 er: "+broek.toString());

        Fraction frac2=new Fraction(3,4);
        System.out.println("Brøk 2 er: "+frac2.toString());

        String[] valg={"summer","subtraher","multipliser","divider"};
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Skriv inn hva du vil gjøre");

            for(int i = 0;i<valg.length;i++){
                System.out.println(i+1+":"+valg[i]);
            }
            System.out.println("5:Avslutt");

            int valgtOperasjon=sc.nextInt();

            if(valgtOperasjon==5){
                System.out.println("Avslutter...");
                break;
            }

            switch(valgtOperasjon){
                case 1:
                    broek.summer(frac2);
                    break;
                case 2:
                    broek.subtraher(frac2);
                    break;
                case 3:
                    broek.multipliser(frac2);
                    break;
                case 4:
                    broek.divider(frac2);
                    break;
                default:
                    System.out.println("Du valgte ikke et tall mellom 1 og 5");
            }
            System.out.println("Resultat: "+broek.getResult());   
        }
        sc.close();
    }
}