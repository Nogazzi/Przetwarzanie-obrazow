/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spam;

/**
 *
 * @author Nogaz
 */
public class BMPHeader {
    short type;
    int fileSize;
    short reserved0;
    short reserved1;
    int dataOffset;
    
    public BMPHeader(){
        
    }
}
