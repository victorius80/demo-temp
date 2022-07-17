
package VVV_Testi.Kalkulator_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Kalkulator {

    public static void main(String[] args) {
      while(true){
      K1 k = new K1();  
      Scanner scan = new Scanner(System.in);
      System.out.println("Input: ");
      String s = scan.nextLine();
      
      
      Pattern pat = Pattern.compile("(\\+{1}+|\\-|{1}+\\*{1}+|\\/{1}+)");
      Pattern pat2 = Pattern.compile("\\d+");
      Pattern pat3 = Pattern.compile(
  //"((III)|(IV)|V|(VI)|(VII)|(VIII)|(IX)(|X)|L|C|D|M|(II)|I)+|(\\+|\\-|\\*|\\/)"
   //       + "((III)|(IV)|V|(VI)|(VII)|(VIII)|(IX)(|X)|L|C|D|M|(II)|I)+");            
       "(III)+|(IV)+|V+|(VI)+|(VII)+|(VIII)+|(IX)+|(XXX)+|(XX)+|X+|L+|C+|D+|M+|II+|I+|\\+|\\-|\\*|\\/");
      // "(I|V|X|L|C|D|M)+(\\+|\\-|\\*|\\/)(I|V|X|L|C|D|M)+");
      Matcher mat = pat.matcher(s);
      Matcher mat2 = pat2.matcher(s);
      Matcher mat3 = pat3.matcher(s);    

      boolean b4 = s.matches("((III)|(IV)|V|(VI)|(VII)|(VIII)|(IX)|(XXX)|(XX)|X|L|C|D|M|II|I|\\d|\\+|\\-|\\*|\\/){3,}");
      boolean b3 = s.matches("((III)|(IV)|V|(VI)|(VII)|(VIII)|(IX)|(XXX)|(XX)|X|L|C|D|M|II|I|\\+|\\-|\\*|\\/){3,}");
      boolean b2 = s.matches("(\\d|\\+|\\-|\\*|\\/){3,}");
      System.out.println(b2);
      System.out.println(b3);
         
      if((b4==true)&&(b3==false)&&(b2==false)){
          throw new IllegalArgumentException("throws Exception //т.к. используются одновременно разные системы счисления");
      }
      
      if(b3==true){
          b2=true;
      }
      if(b2==false){
           throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");
      }else{b3=true;}
      if(b3==false){
           throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");
      }
      
         String sa1 = "";
         while(mat.find()){            
          System.out.println("Output:");                               
          if(k.c1==mat.group().charAt(0)){
            sa1 += Character.toString(k.c1);  
            k.plus(mat2);
          }
          if(k.c2==mat.group().charAt(0)){
              sa1 += Character.toString(k.c2);
              k.minus(mat2);
          }
          if(k.c3==mat.group().charAt(0)){
              sa1 += Character.toString(k.c3);
              k.umnogenie(mat2);
          }
          if(k.c4==mat.group().charAt(0)){
              sa1 += Character.toString(k.c4);
              k.delenie(mat2);
          }
           if(sa1.length()>1){  
           throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");  
         }          
      }
                 
    k.roma(mat3);
     
      }
      }
    }

class K1{
   char c1 = '+'; char c2 = '-'; char c3 = '*'; char c4 = '/';
  
     void plus(Matcher mat){
       int sum = 0;
       while(mat.find()){
            int i = Integer.parseInt(mat.group());
            sum +=i;
       }
       System.out.println(sum);
   }
   void minus(Matcher mat){
       int sum = 0;
       while(mat.find()){
            int i = Integer.parseInt(mat.group());
            if(sum==0){ sum +=i;}
            else{sum -=i;}
       }
       System.out.println(sum);
   }
   void umnogenie(Matcher mat){
       int sum = 0;
       while(mat.find()){
            int i = Integer.parseInt(mat.group());
            if(sum==0){ sum +=i;}
            else{sum *=i;}
       }
       System.out.println(sum);
   }
   void delenie(Matcher mat){
       int sum = 0;
       while(mat.find()){
            int i = Integer.parseInt(mat.group());
            if(sum==0){ sum +=i;}
            else{sum /=i;}
       }
            System.out.println(sum);
   }
   
   
   void roma(Matcher mat){  
   String s = "0"; String s1 = "I"; String s2 = "II"; String s3 = "III"; String s4 = "IV"; String s5 = "V"; 
   String s6 = "VI"; String s7 = "VII"; String s8 = "VIII"; String s9 = "IX"; String s10 = "X"; 
   String s31 = "XX"; String s32 = "XXX";
   String s11 = "L"; String s12 = "C"; String s13 = "D"; String s14 = "M";  
   String s15 = "+"; String s16 = "-"; String s17 = "*"; String s18 = "/";
   LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
   LinkedHashMap<String, Integer> mp2 = new LinkedHashMap<>();
   mp.put(s,0);
   mp.put(s1,1);
   mp.put(s2,2);
   mp.put(s3,3);
   mp.put(s4,4);
   mp.put(s5,5);
   mp.put(s6,6);
   mp.put(s7,7);
   mp.put(s8,8);
   mp.put(s9,9);
   mp.put(s10,10);
   mp.put(s31,20);
   mp.put(s32,30);
   mp.put(s11,50);
   mp.put(s12,100);
   mp.put(s13,500);
   mp.put(s14,1000);
   mp.put(s15,-3);
   mp.put(s16,-3);
   mp.put(s17,-3);
   mp.put(s18,-3);
   
ArrayList<Integer> al2 = new ArrayList<>();
ArrayList<Integer> al3 = new ArrayList<>();

if(!al2.isEmpty()){
    al2.clear(); 
 }
if(!al3.isEmpty()){
    al3.clear(); 
 }
  
      Integer[] im = {0,1,2,3,4,5,6,7,8,9};
      List li = new ArrayList<>(Arrays.asList(im));
      String s19 = "";
      int i6 = 0;
      while(mat.find()){
          
         if(li.contains(mat.group())){
             throw new IllegalArgumentException("throws Exception //т.к. используются одновременно разные системы счисления");
         }
         
           if((s15.equals(mat.group()))|(s16.equals(mat.group()))|(s17.equals(mat.group()))|(s18.equals(mat.group()))){
           i6=1;
           s19 += mat.group();
            // System.out.print("Значение: " + mp.get(mat.group()) + ", ");
          }
          if(i6==0){        
          al2.add(mp.get(mat.group()));
          }
          if((i6==1)&&((mp.get(mat.group())))!=-3){ 
         //     System.out.print("Значение: " + mp.get(mat.group()) + ", ");
          al3.add(mp.get(mat.group()));
          }
      }
      
   Integer sa1 = 0;
   Integer sa2 = 0;
   for(Integer sa: al2){sa1 +=sa;}
   for(Integer sa: al3){sa2 +=sa;}
//   System.out.println(sa1);
//   System.out.println(sa2);
   
   System.out.println("Output:");
   int i2 = 0;
   int i3 = 0;
   if(s19.equals(s15)){
       for(Integer i:al2){
        i2 +=i;
       }
       for(Integer i:al3){
        i3 +=i; 
       }
      Integer i5 = (i2+i3);
      for(Map.Entry<String, Integer> m: mp.entrySet()){
          if(m.getValue()==i5){
              System.out.println(m.getKey());
          }
      }
     
   }
        if(s19.equals(s16)){
        for(Integer i:al2){
        i2 +=i;
       }
       for(Integer i:al3){
        i3 +=i; 
       }
      Integer i5 = (i2-i3);
      
      if(i5<0){
              throw new IllegalArgumentException("throws Exception //т.к. в римской системе нет отрицательных чисел");
      }
      
      for(Map.Entry<String, Integer> m: mp.entrySet()){
          if(m.getValue()==i5){
              System.out.println(m.getKey());
                       }
   }
      }
      if(s19.equals(s17)){
        for(Integer i:al2){
        i2 +=i;
       }
       for(Integer i:al3){
        i3 +=i; 
       }
      Integer i5 = (i2*i3);
      for(Map.Entry<String, Integer> m: mp.entrySet()){
          if(m.getValue()==i5){
              System.out.println(m.getKey());
          }
   }
      }
     if(s19.equals(s18)){
        for(Integer i:al2){
        i2 +=i;
       }
       for(Integer i:al3){
        i3 +=i; 
       }
      Integer i5 = (i2/i3);
      for(Map.Entry<String, Integer> m: mp.entrySet()){
          if(m.getValue()==i5){
              System.out.println(m.getKey());
          }
   }
     }
   }
}

