package paketDomaci8;

import java.util.Scanner;

public class AproksimatorAlkohola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double tezina, p = 0, ml_pica, SUMA = 0, BodyMass, BAC, r= 0;
		int pol, id_pica, kazneniPoeni=0, zabrana=0;
		String Stanje = "stanje", novcanaKazna = "nula";
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		System.out.println("Unesite vasu tezinu (kg):");
		tezina = sc.nextDouble();
		System.out.println("Unesite vas pol (ako ste musko unesite 1, ako ste zensko unesite 0):");
		pol = sc.nextInt();
                BodyMass = tezina * 1000;
		
		for(; ;) {
			System.out.println("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste pili:");
			id_pica = sc.nextInt();
			if (id_pica == -1) break;
			switch (id_pica) {
			case -1: break;
			case 1:
				p = 50;
				break;
			case 2:
				p = 40;
				break;
			case 3:
				p = 11;
				break;
			case 4:
				p = 4.7;
				break;
			default:
				System.out.println("Greska, zeljeni id nije u bazi podataka. Pokusajte ponovo.");
				break;
			}
			System.out.println("Unesite koliko mililitara(ml) tog pica ste popili: ");
			ml_pica = sc.nextDouble();
			SUMA = SUMA + (ml_pica * p);
		}
		switch (pol) {
		case 0: r=0.68; break;
		case 1: r=0.55; break;
		}
		BAC=(SUMA/(BodyMass*r))*1000;
		System.out.println(BAC);
		BAC/=100;
		System.out.println(BAC);
		if (BAC<=0.20) {
			novcanaKazna = "Bez kazne";
			kazneniPoeni = 0;
			zabrana = 0;
			Stanje = "Dozvoljena alkoholisanost";
		}
		else if (BAC<=0.50) {
			novcanaKazna = "10000";
			kazneniPoeni = 0;
			zabrana = 0;
			Stanje = "Umerena alkoholisanost";
		}
	 else if (BAC<=0.8) {
		novcanaKazna = "10000 - 20000";
		kazneniPoeni = 6;
		zabrana = 3;
		Stanje = "Srednja alkoholisanost";
	}
	 else if (BAC<=1.2) {
		 novcanaKazna = "20000 - 40000";
			kazneniPoeni = 8;
			zabrana = 4;
			Stanje = "Visoka alkoholisanost";
	 }
	 else if (BAC<=1.6) {
		 novcanaKazna = "100000 - 120000";
			kazneniPoeni = 9;
			zabrana = 8;
			Stanje = "Teska alkoholisanost";
	 }
	 else if(BAC<=2.0) {
		 novcanaKazna = "100000 - 120000";
			kazneniPoeni = 14;
			zabrana = 8;
			Stanje = "Visoko teska alkoholisanost";
	 }
	 else if (BAC>2.0) {
		 novcanaKazna = "30 - 60 dana zatvora";
			kazneniPoeni = 15;
			zabrana = 9;
			Stanje = "Potpuna alkoholisanost";
	 }
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("BAC: %.2f",BAC);System.out.print(" - "+Stanje);
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.println("Kazna: "+novcanaKazna+"din");
		System.out.println("Kazneni poeni: "+kazneniPoeni);
		System.out.println("Zabrana voznje: "+zabrana+"meseci");
		
		sc.close();
}
}
