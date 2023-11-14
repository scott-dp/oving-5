package oppgave2;

public class Main {
    public static void main(String[] args){
        MinRandom minrandom=new MinRandom();

        
        System.out.println(minrandom.nesteDesimaltall(-1.1,3.2));
        System.out.println(minrandom.nesteHeltall(-10,100));
        System.out.println(minrandom.nesteDesimaltall(-0.1,0.1));
        System.out.println(minrandom.nesteHeltall(-1,5));
        System.out.println(minrandom.nesteDesimaltall(2.0,2.1));
        System.out.println(minrandom.nesteHeltall(-1,0));
        System.out.println("--------------------------------");
            
    }
}
