import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class NumeroFeliz {

	
	public static int[] digitosNumero(int iNumero){
	

		String x = Integer.toString(iNumero);
		int[] iNumeros = new int[x.length()];
		

		int iDigito = 0;
		while (iNumero>0){
			iNumeros[iDigito] = iNumero%10;
            iNumero = iNumero/10;  
            iDigito++;
		}
		
		return iNumeros;
		
	}
	
	public static void main(String[] args) {
		
		int iNumero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero cualquiera, entre el 1 y el 998"));
		Set<Integer> iCalculados = new HashSet<Integer>();
		boolean bRepetido = false;
	
		
		int[] iNumeros = digitosNumero(iNumero);
		System.out.println("Calculando si el numero " + iNumero + " es un numero feliz");
		System.out.println("\n");
		
		int iSuma = 0;
		
		while ((iSuma!=1) && !(bRepetido)){		
			iSuma = 0;		
			for (int x=0;x<iNumeros.length;x++)
				iSuma += Math.pow(iNumeros[x],2);				
			iNumeros = digitosNumero(iSuma);
			
			System.out.println(iSuma);
			

			if (iCalculados.contains(new Integer(iSuma)))
				bRepetido = true;				
			else
				iCalculados.add(new Integer(iSuma));			
		}

		System.out.println("\n");
		
		if (bRepetido)
			System.out.println(iNumero + " NO es un numero feliz");
		else
			System.out.println(iNumero + " SI es un numero feliz");
	}

}