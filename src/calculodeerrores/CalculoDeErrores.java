package calculodeerrores;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.*;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
public class CalculoDeErrores {
    public CalculoDeErrores() {
    }
    public static void main(String args[]) {
    
    Scanner snc = new Scanner(System.in);
    double vA=0, vV=0;
    int opcion, numeroT=0, numeroR=0;
    System.out.println ("ESCRIBA EL VALOR APROXIMADO");
    
    vA=snc.nextDouble();
    System.out.println ("Escriba Valor Verdadero ");
    vV=snc.nextDouble();
    System.out.println ("Usted desea hacer un: ");
    System.out.println (" 		1.-Truncamiento  ");
    System.out.println (" 		2.-Redondeo		");
    System.out.println ("		3.-No deseo ninguna Opcion");
   	opcion= snc.nextInt();
    if(opcion==1){
    	double errorAbsoT=0, errorRelaT=0;
    	System.out.println ("Acuantos numeros desea Trucar");
    	numeroT=snc.nextInt();
    	errorAbsoT= TDecimal(numeroT,ErrorAbso(vA,vV));
    	errorRelaT= TDecimal(numeroT,ErrorRela(ErrorAbso(vA,vV),vV));
    	System.out.println ("Error Absoluto = "+errorAbsoT);
    	System.out.println ("Error Relativo = "+errorRelaT);
    }
    else if(opcion==2){
    	double errorAbsoR, errorRelaR;
    	System.out.println ("Acuantos numeros desea Redondear");
    	numeroR=snc.nextInt();
    	errorAbsoR= RDecimal(numeroR,ErrorAbso(vA,vV));
    	errorRelaR= RDecimal(numeroR,ErrorRela(ErrorAbso(vA,vV),vV));
    	System.out.println ("Error Absoluto = "+errorAbsoR);
    	System.out.println ("Error Relativo = "+errorRelaR);
    }
    else{
    System.out.println ("Error Absoluto = "+ErrorAbso(vA,vV));
    System.out.println ("Error Relativo = "+ErrorRela(ErrorAbso(vA,vV),vV));
    }
}
//metodo para calcular el error absoluto
  static double ErrorAbso(double va, double vv){
  	double errorA=0;
  	errorA=vv-va;
  	return errorA;
  		
  }
  //metodo para calcular el valor Relativo
  static double ErrorRela(double err, double vv){
  	double errorR=0;
  	errorR= err/vv;
  	return errorR;
  		
  }
  //metodo para Truncamiento de los resultados 
  static double TDecimal(int Numero, double Decimal){
  		BigDecimal formatNumber = new BigDecimal(Decimal);
		formatNumber = formatNumber.setScale(Numero, RoundingMode.DOWN);
		return formatNumber.doubleValue();
  }
  //metodo para Redondeo de los Resultados
  static double RDecimal(int Numero, double Decimal){
  		 BigDecimal redondeo = new  BigDecimal(Decimal).setScale(Numero,RoundingMode.HALF_EVEN);
  		 return redondeo.doubleValue();
  }
}