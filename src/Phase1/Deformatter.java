/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phase1;



/**
 *
 * @author Ghaith
 */
public class Deformatter {

    public static String deformate(String xml) {
        boolean NL = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xml.length(); i++) {
            char c = xml.charAt(i);
            if (c == '\n') {
                NL = true;
                continue;
            }
            if (NL && (c == ' ' || c == '\t')) {
                continue;
            }
            sb.append(c);
            NL = false;
        }
        return sb.toString();
    }
}