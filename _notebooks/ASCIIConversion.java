import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics2D;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;

public class ASCIIConversion extends ImageBlueprint {
    
    public ASCIIConversion(String name, String ext) {
        super(name, ext);
        this.colorFile = this.outDir + name + "ASCII" + ".txt";
    }

    public ASCIIConversion(String name) {
        super(name);
        this.colorFile = this.outDir + name + "ASCII" + ".txt";
    }

    @Override
    protected void conversion() {
        
        // Controls how big chunks are taken for ASCII characters
        final int XLENGTH = 2;
        final int YLENGTH = 4;

        BufferedImage img = null;
        PrintWriter asciiPrt = null;
        FileWriter asciiWrt = null;
        Color col = null;

        try {
            File file = new File(this.colorFile);
            Files.deleteIfExists(file.toPath()); 
        } catch (IOException e) {
            System.out.println("Delete File error: " + e);
        }

        try {
            asciiPrt = new PrintWriter(asciiWrt = new FileWriter(this.colorFile, true));
        } catch (IOException e) {
            System.out.println("ASCII out file create error: " + e);
        }

        try {
            img = ImageIO.read(new File(this.inFile));
        } catch (IOException e) {
        }

        for (int i = 0; i < img.getHeight(); i += YLENGTH) {
            for (int j = 0; j < img.getWidth(); j += XLENGTH) {

                // colorSum stores total sum of RGB values, counter keeps track of how many are being counted
                // colorSum/counter = average
                // average is taken to get ASCII character
                double colorSum = 0;
                int counter = 0;

                for (int k = 0; k < XLENGTH; k++) {
                    for (int l = 0; l < YLENGTH; l++) {
                        if (k < img.getWidth() && l < img.getHeight()) {
                            counter++;
                            col = new Color(img.getRGB(j + k, i + l));
                            colorSum += (((col.getRed() * 0.30) + (col.getBlue() * 0.59) + (col
                                .getGreen() * 0.11)));
                        }
                    }
                }

                double average = colorSum / counter;
                try {
                    asciiPrt.print(asciiChar(average));
                    asciiPrt.flush();
                    asciiWrt.flush();
                } catch (Exception ex) {
                }

            }
            try {
                asciiPrt.println("");
                asciiPrt.flush();
                asciiWrt.flush();
            } catch (Exception ex) {
            }
        }
    }

    // conversion table, there may be better out there ie https://www.billmongan.com/Ursinus-CS173-Fall2020/Labs/ASCIIArt
    public String asciiChar(double g) {
        String str = " ";
        // if (g >= 224.6) {
        //     str = " ";
        // } else if (g >= 186.6) {
        //     str = "-";
        // } else if (g >= 165.5) {
        //     str = ";";
        // } else if (g >= 143) {
        //     str = "(";
        // } else if (g >= 137.5) {
        //     str = "<";
        // } else if (g >= 127.5) {
        //     str = "L";
        // } else if (g >= 123.1) {
        //     str = "1";
        // } else if (g >= 113.1) {
        //     str = "n";
        // } else if (g >= 102) {
        //     str = "s";
        // } else if (g >= 85.4) {
        //     str = "h";
        // } else if (g >= 75.4) {
        //     str = "4";
        // } else if (g >= 69.8) {
        //     str = "e";
        // } else if (g >= 62.1) {
        //     str = "5";
        // } else if (g >= 51) {
        //     str = "D";
        // } else if (g >= 35.5) {
        //     str = "Q";
        // } else if (g >= 17.8) {
        //     str = "M";
        // } else {
        //     str = "@";
        // }

        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }

        return str;
    }
    
    public static void main(String[] args) {
        ASCIIConversion amogus = new ASCIIConversion("dream", "png");
        amogus.conversion();
    }

}