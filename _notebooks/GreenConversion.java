import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.imageio.ImageIO;

public class GreenConversion extends ImageBlueprint {
    public GreenConversion(String name, String ext) {
        super(name, ext);
        this.colorFile = this.outDir + name + "Green" + ".png";
    }

    public GreenConversion(String name) {
        super(name);
        this.colorFile = this.outDir + name + "Green" + ".png";
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
                int rgb = new Color(0, col.getGreen(), 0).getRGB();
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
        GreenConversion amogus = new GreenConversion("amogus", "png");
        amogus.conversion();
    }

}