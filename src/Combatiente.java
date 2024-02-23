
public abstract class Combatiente {

	public enum Decision {
		COOPERAR,
		TRAICIONAR
	}
	
	public String name = "";
	public int puntos;
	public int gano;
	public Decision decision;

	public abstract Decision comienza();
	
	public abstract Decision mover(Decision resultadoAnterior);
}

