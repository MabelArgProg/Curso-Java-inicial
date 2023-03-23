package clase5;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje{

	private float tope;
	
	public DescuentoPorcentajeConTope(float tope) {
		super(0);
		this.tope = tope;
	}

	public float getTope() {
		return this.tope;
	}

	public void setTope(float nuevoValor) {
		this.tope = nuevoValor;
	}
	
	@Override
	public void setValorDesc(float valor) {
		if(valor>this.tope) {
			super.setValorDesc(0);
			System.out.println("Este valor supera al tope permitido");
		}else {
			super.setValorDesc(valor);
		}
	}

}
