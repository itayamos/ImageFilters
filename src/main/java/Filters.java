import java.awt.*;
import java.awt.image.BufferedImage;
public class Filters{
    private static boolean isSimilarColor(Color color1,Color color2){
        boolean similar=false;
        int redDiff=Math.abs(color1.getRed()-color2.getRed());
        int blueDiff=Math.abs(color1.getBlue()-color2.getBlue());
        int greenDiff=Math.abs(color1.getGreen()-color2.getGreen());
        int totalDiff=redDiff+greenDiff+blueDiff;
        if(totalDiff>50){
            similar=true;
        }
        return similar;
    }
    public static BufferedImage darker(BufferedImage bufferedImage) {
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(
                        lessThanMin(currentRed),
                        lessThanMin(currentGreen),
                        lessThanMin(currentBlue)
                );
                bufferedImage.setRGB(x,y,newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage lighter(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(
                        greaterThanMax(currentRed),
                        greaterThanMax(currentGreen),
                        greaterThanMax(currentBlue)
                );
                bufferedImage.setRGB(x,y,newColor.getRGB());

            }
        }
        return bufferedImage;
    }
    public static BufferedImage grayScale(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                 int grayScale=((getBlue(bufferedImage,x,y)
                        + getRed(bufferedImage,x,y)
                        + getGreen(bufferedImage,x,y))/3);
                Color newColor = new Color(grayScale,grayScale,grayScale);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage negative(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = 255 - getRed(bufferedImage, x, y);
                int currentBlue = 255 - getBlue(bufferedImage, x, y);
                int currentGreen = 255 - getGreen(bufferedImage, x, y);
                Color newColor = new Color(currentRed, currentGreen, currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage contrast(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(lessOrMoreThanMid(currentRed),
                        lessOrMoreThanMid(currentGreen),
                        lessOrMoreThanMid(currentBlue)
                );
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage eliminateR(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(0, currentGreen, currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage eliminateG(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed=getRed(bufferedImage, x, y);
                int currentBlue=getBlue(bufferedImage, x, y);;
                Color newColor=new Color(currentRed,0,currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage eliminateB(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(currentRed, currentGreen, 0);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage RGBtoGBR(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(currentGreen, currentBlue, currentRed);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage RGBtoBRG(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                Color newColor = new Color(currentBlue, currentRed, currentGreen);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static BufferedImage sepia(BufferedImage bufferedImage){
        for (int x=0;x<bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int currentRed = getRed(bufferedImage, x, y);
                int currentBlue = getBlue(bufferedImage, x, y);
                int currentGreen = getGreen(bufferedImage, x, y);
                int outputRed = (int) ((currentRed * 0.4) + (currentGreen * 0.769) + (currentBlue * 0.189));
                int outputGreen = (int) ((currentRed * 0.2) + (currentGreen * 0.4) + (currentBlue * 0.168));
                int outputBlue = (int) ((currentRed * 0.1) + (currentGreen * 0.2) + (currentBlue * 0.131));
                Color newColor = new Color(greaterThanMax(outputRed)
                        , greaterThanMax(outputGreen),
                        greaterThanMax(outputBlue)
                );
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        return bufferedImage;
    }
    public static int getRed(BufferedImage bufferedImage,int x,int y){
        return getCurrentColor(bufferedImage,x,y).getRed();

    }
    public static int getGreen(BufferedImage bufferedImage,int x,int y){
        return getCurrentColor(bufferedImage,x,y).getGreen();

    }
    public static int getBlue(BufferedImage bufferedImage,int x,int y){
        return getCurrentColor(bufferedImage,x,y).getBlue();
    }
    public static Color getCurrentColor(BufferedImage bufferedImage,int x,int y){
        int currentRGB=bufferedImage.getRGB(x,y);
        return new Color(currentRGB);
    }
    public static int greaterThanMax(int param){
        int check=param+50;
        if (check>255){
            check=255;
        }
        return check;
    }
    public static int lessThanMin(int param){
        int check=param-50;
        if (check<0){
            check=0;
        }
        return check;
    }
    public static int lessOrMoreThanMid(int param){
        int check=param;
        if (check<127){
            check=lessThanMin(check);
        }
        else if (check>127){
            check=greaterThanMax(check);
        }
        return check;
    }
    public static BufferedImage showBorders(BufferedImage bufferedImage){
        Color prev=null;
        for (int x=0;x<bufferedImage.getWidth(); x++){
            for (int y=0;y<bufferedImage.getHeight(); y++) {
                Color currentColor=new Color(bufferedImage.getRGB(x,y));
                if (prev!=null && isSimilarColor(prev,currentColor)){
                    bufferedImage.setRGB(x,y,Color.GREEN.getRGB());
                }
                prev=currentColor;
            }
        }
        return bufferedImage;
    }

}
