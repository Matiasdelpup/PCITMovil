//@Author Matias Del Pup

package classes;

public class ClaseHijaConsulta extends ClaseP
{
	@Override
	public void Transferencias() 
	{
		System.out.println("*********************************");
		System.out.println("Tu saldo actual es: " + getPlata());
		System.out.println("*********************************");
	}
	
}
