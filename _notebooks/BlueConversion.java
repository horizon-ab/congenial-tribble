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

public class BlueConversion extends ImageBlueprint {
    public BlueConversion(String name, String ext) {
        super(name, ext);
        this.colorFile = this.outDir + name + "Blue" + ".png";
    }

    public BlueConversion(String name) {
        super(name);
        this.colorFile = this.outDir + name + "Blue" + ".png";
    }

    @Override
    protected void conversion() {
        BufferedImage img = null;
        PrintWriter colorPrt = null;
        FileWriter colorWrt = null;
        
        
        // Just deletes file if already exists in tmp
        try {
            File file = new File(this.colorFile);
            Files.deleteIfExists(file.toPath()); 
        } catch (IOException e) {
            System.out.println("Delete File error: " + e);
        }

        // try {
        //     colorPrt = new PrintWriter(colorWrt = new FileWriter(this.colorFile, true));
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        try {
            img = ImageIO.read(new File(this.inFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Color col = new Color(img.getRGB(j, i));
                int rgb = new Color(0, 0, col.getBlue()).getRGB();
                img.setRGB(j, i, rgb);

            }
        }
        // System.out.println("for loop done");

        try {
            ImageIO.write(img, "png", new File(this.colorFile) );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }

    public static void main(String[] args) {
        BlueConversion nicandrohan = new BlueConversion("nicandrohan", "png");
        nicandrohan.conversion();
    }

}