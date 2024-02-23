import java.util.Random;

public class Combate {

	Random rand;

	
	public Combate(){
		
		rand = new Random(System.nanoTime());
	}
	
	public void pelea() {
		
		Combatiente peleador1 = new Jerry();
		Combatiente peleador2 = new Tom();
		
		int totalPeleas = rand.nextInt(20, 200);
		
		System.out.println("Pelearan "+peleador1.name+" y "+peleador2.name+ " un total de "+totalPeleas+" rounds");
		System.out.println("--------------");
		System.out.println("COMIENZA: ");
		
		Combatiente.Decision decisionPeleador1 = peleador1.comienza();
		Combatiente.Decision decisionPeleador2 = peleador2.comienza();
		
		System.out.println(peleador1.name +" decide : " + decisionPeleador1);
		System.out.println(peleador2.name +" decide : " + decisionPeleador2);
		
		for(int p=0;p<totalPeleas;p++) {
			try {			        
				System.out.println("turno: "+(p+1) +" de "+totalPeleas+ " ---------------------------------------------------------------------"+(p+1) +" de "+totalPeleas);
								
				decisionPeleador1 = peleador1.mover(decisionPeleador2);
				decisionPeleador2 = peleador2.mover(decisionPeleador1);
				
				Thread.sleep(100);				
				
				calcularPuntos(peleador1,peleador2);				
				
				System.out.println("* "+peleador1.name +"\t\t\t\t\t decide : " + peleador1.decision + "\t gano "+peleador1.gano+"   \t total "+ peleador1.puntos+ " * ");
				System.out.println("- "+peleador2.name +"\t\t\t\t\t decide : " + peleador2.decision+ "\t gano "+peleador2.gano+"   \t total "+ peleador2.puntos+ " - ");
				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		resultadoFinal(peleador1, peleador2);
	}

	private void resultadoFinal(Combatiente peleador1, Combatiente peleador2) {
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------");
		if(peleador1.puntos < peleador2.puntos)
			System.out.println("\t\t\t\t\t"+peleador2.name +" gana con " + peleador2.puntos+" !!!");
		
		if(peleador2.puntos < peleador1.puntos)
			System.out.println("\t\t\t\t\t"+peleador1.name +" gana con " + peleador1.puntos+" !!!");
		
		if(peleador1.puntos == peleador2.puntos)
			System.out.println("\t\t\t\t\t-----* SE INVALIDA POR EMPATE !!! *-----");
		
		System.out.println("--------------------------------------------------------------------------------------------");
	}	

	public void calcularPuntos(Combatiente comb1, Combatiente comb2 ) {
		
		if(comb1.decision == Combatiente.Decision.COOPERAR && comb2.decision == Combatiente.Decision.COOPERAR ){
			comb1.gano = 3;
			comb2.gano = 3;
			comb1.puntos += 3;
			comb2.puntos += 3;
		}
		
		if(comb1.decision == Combatiente.Decision.COOPERAR && comb2.decision == Combatiente.Decision.TRAICIONAR){
			comb1.gano = 0;
			comb2.gano = 5;
			comb1.puntos += 0;
			comb2.puntos += 5;
		}
		
		if(comb1.decision == Combatiente.Decision.TRAICIONAR && comb2.decision == Combatiente.Decision.COOPERAR){
			comb1.gano = 5;
			comb2.gano = 0;
			comb1.puntos += 5;
			comb2.puntos += 0;
		}
		
		if(comb1.decision == Combatiente.Decision.TRAICIONAR && comb2.decision == Combatiente.Decision.TRAICIONAR ){
			comb1.gano = 1;
			comb2.gano = 1;
			comb1.puntos += 1;
			comb2.puntos += 1;
		}
	}
}