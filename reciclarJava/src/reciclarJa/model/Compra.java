package reciclarJa.model;

public class Compra {
	
	private Material material;
	private float peso;

	public Compra(Material material, float peso) {
		this.material = material;
		this.peso = peso;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float valorCompra() {
		float valor;
		valor = peso * material.getPreco();
		return valor;
	}
	public void ver() {
		System.out.println("O valor da compra é de : " + this.valorCompra());
	}
}
