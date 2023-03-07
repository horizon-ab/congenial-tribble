import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.imageio.ImageIO;

public class GrayConversion extends ImageBlueprint {
    public GrayConversion(String name, String ext) {
        super(name, ext);
        this.colorFile = this.outDir + name + "Gray" + ".png";
    }

    public GrayConversion(String name) {
        super(name);
        this.colorFile = this.outDir + name + "Gray" + ".png";
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
                //Color col = new Color(img.getRGB(j, i));
                //int rgb = new Color((int)(0.299 * col.getRed()), (int)(0.114 * col.getGreen()), (int)(0.587 * col.getBlue())).getRGB();
                int rgb = img.getRGB(j, i);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                // Normalize and gamma correct:
                float rr = (float) Math.pow(r / 255.0, 2.2);
                float gg = (float) Math.pow(g / 255.0, 2.2);
                float bb = (float) Math.pow(b / 255.0, 2.2);

                // Calculate luminance:
                float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                // Gamma compand and rescale to byte range:
                int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
                img.setRGB(j, i, gray);


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
        GrayConversion amogus = new GrayConversion("amogus", "png");
        amogus.conversion();
    }

}