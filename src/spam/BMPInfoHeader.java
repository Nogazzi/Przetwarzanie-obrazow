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
public class BMPInfoHeader {
    int hdrSize;
    int width;
    int height;
    short planes;
    short depth;
    int compression;
    int bmpDataSize;
    int hResolution;
    int vResolution;
    int nColors;
    int nImportantClors;
    
    public BMPInfoHeader(){
        
    }
}
