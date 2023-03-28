/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phase1;

/**
 *
 * @author SHEREF ZEDAN
 */
import java.util.ArrayList;
import java.util.Scanner;


public class JSON_Converter {


    public static StringBuilder converter(XMLChecker xml){

            Tree tree = new Tree(xml);
            tree.TreeReady();
            return tree.Print();

    }
   



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
         String v= Deformatter.deformate(s);
         System.out.print(v);
         XMLChecker xml=new XMLChecker(v);
         converter(xml);
        

    }
}