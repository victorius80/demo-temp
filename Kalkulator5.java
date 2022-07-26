
package VVV_Testi.Kalkulator_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kalkulator5 {

   public static void main(String[] args) throws Exception {
   while(true){    
   Scanner scan = new Scanner(System.in);
   System.out.println("Input: ");
   String s = scan.nextLine();
   try{
   Main m = new Main(s);
   }
   catch(ExRes0_Roma ex){
       System.out.println(ex.getMessage());
   }
   catch(ExMenshe1Bolshe10 ex){
       System.out.println(ex.getMessage());
   }
   catch(OtrChis ex){
       System.out.println(ex.getMessage());
   }
   catch(StrMatV ex){
       System.out.println(ex.getMessage());
   }
   catch(DvaOper ex){
       System.out.println(ex.getMessage());
   }
   catch(RaznSistSchisl ex){
       System.out.println(ex.getMessage());
   }
   catch(Menshe1Bolshe10 ex){
       System.out.println(ex.getMessage());
   }
   catch(Menshe1Bolshe10R ex){
       System.out.println(ex.getMessage());
   }
   catch(Celoe ex){
       System.out.println(ex.getMessage());
   }
   finally{
       System.out.println("Подсчёт окончен !");
   }
    }
    }
}

class Main{
    
    public Main(String s) throws Exception{
  //   System.out.println(s);   
     System.out.println(calc(s));
             }
    
    public static String calc(String input) throws Exception{
       char c1 = '+'; char c2 = '-'; char c3 = '*'; char c4 = '/';
      
       int i = 0;
       String s1 = "";
       String s2 = "";
       String s3 = "";
       for(char c: input.toCharArray()){
         if(c==c1||c==c2||c==c3||c==c4){
         s2 += Character.toString(c);
         i = 1;
          }
         if(i==0){
         s1 += Character.toString(c);
         }
         if(i!=0&&c!=c1&&c!=c2&&c!=c3&&c!=c4){  
         s3 += Character.toString(c);
         }
         }
        
       if((s1.length()<1)||(s3.length()<1)){
           throw new StrMatV("throws Exception //т.к. строка не является математической операцией");
       }
       
       if(s1.matches("\\d+")&&s3.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")){
           throw new RaznSistSchisl("throws Exception //т.к. используются одновременно разные системы счисления");
       }
       if (s3.matches("\\d+")&&s1.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")){
           throw new RaznSistSchisl("throws Exception //т.к. используются одновременно разные системы счисления");
       }
       
       if(s2.length()>1){
           throw new DvaOper("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
       }
       
        int i1 = 0;
        int i2 = 0;
        
        if(s1.matches("\\d+")&&s3.matches("\\d+")){
        i1 = Integer.parseInt(s1);
        i2 = Integer.parseInt(s3);
        if(((i1<1)|(i2>10))|((i2<1)|(i1>10))){
           throw new Menshe1Bolshe10("throws Exception // Необходимо ввести число не меньше 1 и не больше 10 для получения результата !"); 
        }
        }
         
        if((s1.matches("\\D+"))&&(s3.matches("\\D+"))){
        if(s1.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")&&
                s3.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")){
           Roma r1 = Roma.valueOf(s1);
           Roma r2 = Roma.valueOf(s3);
           i1 = Integer.parseInt(r1.getS());
           i2 = Integer.parseInt(r2.getS());
           if(((i1<1)|(i2>10))|((i2<1)|(i1>10))){         
           throw new Menshe1Bolshe10R("throws Exception // Необходимо ввести число не меньше I и не больше X для получения результата !"); 
        }           
        }else{
          throw new Menshe1Bolshe10R("throws Exception // Необходимо ввести число не меньше I и не больше X для получения результата !");  
        }
        }
               
        char ci = s2.charAt(0);
        
        if(ci==c1){i=i1+i2;}
        if(ci==c2){i=i1-i2;}
        if(ci==c3){i=i1*i2;}
        if(ci==c4){i=i1/i2;}
       
        String ss = Integer.toString(i);
        if(s1.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")&&
                s3.matches("(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+")){
         if((i1<i2)&&(c2==s2.charAt(0))){
                 throw new OtrChis("throws Exception // В римской системе нет отридцательных чисел !");
             }
         if((((i1<i2)&&(c4==s2.charAt(0))))||(((i1%=i2)!=0)&&(c4==s2.charAt(0)))){
             throw new Celoe("throws Exception // В результате деления получилось дробное число !");
         }
         
            Roma[] r3 = Roma.values();
         for(Roma r5:r3){
             if((r5.getS()).equals(ss)){    
               ss = r5.toString();
             if(Integer.parseInt(r5.getS())==0){
                 throw new ExRes0_Roma("throws Exception // В римских числах результат вычисления не может быть 0, или меньше 0 !");
             }
             }
         }
        }
            
        if(i<0){
            throw new ExMenshe1Bolshe10("throws Exception // Результат не может быть меньше 0 (отридцательным числом)");
        }
        return "Output: \n" + ss ;
    }
}

enum Roma{
O("0"), I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10"),
 XI("11"), XII("12"), XIII("13"),XIV("14"), XV("15"), XVI("16"), XVII("17"), XVIII("18"), XIX("19"),
 XX("20"), XXI("20"), XXII("22"), XXIII("23"), XXIV("24"), XXV("25"), XXVI("26"), XXVII("27"), 
 XXVIII("28"), XXIX("29"), XXX("30"), XXXI("31"), XXXII("32"), XXXIII("33"), XXXIV("34"), XXXV("35"),
 XXXVI("36"), XXXVII("37"), XXXVIII("38"), XXXIX("39"), XL("40"), XLI("41"), XLII("42"), XLIII("43"),
 XLIV("44"), XLV("45"), XLVI("46"), XLVII("47"), XLVIII("48"), XLIX("49"), L("50"), LI("51"), LII("52"), 
 LIII("53"), LIV("54"), LV("55"), LVI("56"), LVII("57"), LVIII("58"), LIX("59"), LX("60"), LXI("61"),
 LXII("62"), LXIII("63"), LXIV("64"), LXV("65"), LXVI("66"), LXVII("67"), LXVIII("68"), LXIX("69"),
 LXX("70"), LXXI("71"), LXXII("72"), LXXIII("73"), LXXIV("74"), LXXV("75"), LXXVI("76"), LXXVII("77"),
 LXXVIII("78"), LXXIX("79"), LXXX("80"), LXXXI("81"), LXXXII("82"), LXXXIII("83"), LXXXIV("84"),
 LXXXV("85"), LXXXVI("86"), LXXXVII("87"), LXXXVIII("88"), LXXXIX("89"), XC("90"), XCI("91"), XCII("92"),
 XCIII("93"), XCIV("94"), XCV("95"), XCVI("96"), XCVII("97"), XCVIII("98"), XCIX("99"), C("100"), D("500"), M("1000");
 
 private String s;
 
 private Roma(String s){
     this.s = s;
}
 
 public String getS(){
     return this.s;
 }
 
}

class ExMenshe1Bolshe10 extends Exception{
    ExMenshe1Bolshe10(String mes){
        super(mes);
    }
 }
class ExRes0_Roma extends Exception{
    ExRes0_Roma(String mes){
        super(mes);
    }
}
class OtrChis extends Exception{
    OtrChis(String mes){
        super(mes);
    }
}
class StrMatV extends Exception{
    StrMatV(String mes){
        super(mes);
    }
}
class DvaOper extends Exception{
     DvaOper(String mes){
        super(mes);
    }
}
class RaznSistSchisl extends Exception{
    RaznSistSchisl(String mes){
        super(mes);
    }
}
class Menshe1Bolshe10 extends Exception{
    Menshe1Bolshe10(String mes){
        super(mes);
    }
}
class Menshe1Bolshe10R extends Exception{
    Menshe1Bolshe10R(String mes){
        super(mes);
    }
}
class Celoe extends Exception{
    Celoe(String mes){
        super(mes);
    }
}