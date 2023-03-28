/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phase1;

/**
 *
 * @author Ghaith
 */
public class Compressor {

    public static String compress(String s) {
        s = Deformatter.deformate(s);
        StringBinaryConverter SBC = new StringBinaryConverter(s);
        BinaryStringConverter BSC = new BinaryStringConverter();
        BurrowsWheeler.transform(SBC, BSC);
        SBC = new StringBinaryConverter(BSC);
        BSC = new BinaryStringConverter();
        MoveToFront.encode(SBC, BSC);
        SBC = new StringBinaryConverter(BSC);
        BSC = new BinaryStringConverter();
        Huffman.compress(SBC, BSC);
        return BSC.toString();
    }

    public static String expand(String s) {
        StringBinaryConverter SBC = new StringBinaryConverter(s);
        BinaryStringConverter BSC = new BinaryStringConverter();
        Huffman.expand(SBC, BSC);
        SBC = new StringBinaryConverter(BSC);
        BSC = new BinaryStringConverter();
        MoveToFront.decode(SBC, BSC);
        SBC = new StringBinaryConverter(BSC);
        BSC = new BinaryStringConverter();
        BurrowsWheeler.inverseTransform(SBC, BSC);
        return Formatter.format(BSC.toString());
    }

    public static void main(String[] args) {

        String xml = "<users>\n"
                + "                       <user>\n"
                + "                           <id>1</id>\n"
                + "                           <name>Ahmed Ali</name>\n"
                + "                           <posts>\n"
                + "                               <post>\n"
                + "                                   <body>\n"
                + "                                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
                + "                                   </body>\n"
                + "                                   <topics>\n"
                + "                                       <topic>\n"
                + "                                           economy\n"
                + "                                       </topic>\n"
                + "                                       <topic>\n"
                + "                                           finance\n"
                + "                                       </topic>\n"
                + "                                   </topics>\n"
                + "                               </post>\n"
                + "                               <post>\n"
                + "                                   <body>\n"
                + "                                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
                + "                                   </body>\n"
                + "                                   <topics>\n"
                + "                                       <topic>\n"
                + "                                           solar_energy\n"
                + "                                       </topic>\n"
                + "                                   </topics>\n"
                + "                               </post>\n"
                + "                           </posts>\n"
                + "                           <followers>\n"
                + "                               <follower>\n"
                + "                                   <id>2</id>\n"
                + "                               </follower>\n"
                + "                               <follower>\n"
                + "                                   <id>3</id>\n"
                + "                               </follower>\n"
                + "                           </followers>\n"
                + "                       </user>\n"
                + "                       <user>\n"
                + "                           <id>2</id>\n"
                + "                           <name>Yasser Ahmed</name>\n"
                + "                           <posts>\n"
                + "                               <post>\n"
                + "                                   <body>\n"
                + "                                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
                + "                                   </body>\n"
                + "                                   <topics>\n"
                + "                                       <topic>\n"
                + "                                           education\n"
                + "                                       </topic>\n"
                + "                                   </topics>\n"
                + "                               </post>\n"
                + "                           </posts>\n"
                + "                           <followers>\n"
                + "                               <follower>\n"
                + "                                   <id>1</id>\n"
                + "                               </follower>\n"
                + "                           </followers>\n"
                + "                       </user>\n"
                + "                       <user>\n"
                + "                           <id>3</id>\n"
                + "                           <name>Mohamed Sherif</name>\n"
                + "                           <posts>\n"
                + "                               <post>\n"
                + "                                   <body>\n"
                + "                                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
                + "                                   </body>\n"
                + "                                   <topics>\n"
                + "                                       <topic>\n"
                + "                                           sports\n"
                + "                                       </topic>\n"
                + "                                   </topics>\n"
                + "                               </post>\n"
                + "                           </posts>\n"
                + "                           <followers>\n"
                + "                               <follower>\n"
                + "                                   <id>1</id>\n"
                + "                               </follower>\n"
                + "                           </followers>\n"
                + "                       </user>\n"
                + "                   </users>";
        System.out.println("input size: " + xml.length());

        String com = compress(xml);
        System.out.println("compressed File size:" + com.length());

        String exp = expand(com);
        System.out.println("expanded File size:" + exp.length());
        System.out.println("expanded File: \n--------------------------------------------------------------------\n-------------------------------------------------------");
        System.out.println(exp);

    }

}
