import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Panel extends JPanel implements ActionListener {
    private JButton darker;
    private JButton lighter;
    private JButton grayscale;
    private JButton negative;
    private JButton contrast;
    private JButton eliminateR;
    private JButton eliminateG;
    private JButton eliminateB;
    private JButton RGBtoGBR;
    private JButton RGBtoBRG;
    private JButton sepia;
    private JButton showBorders;
    private JTextField textField;
    private JButton submit;
    private JLabel pic1;
    private JLabel pic2;
    private JButton New;
    public static final int Button_Height=40;
    public static final int Button_Width=250;
    public static final int Button_Margin=50;
    public static final int Pics_Width=Main.W/3;
    public static final int Pic2_X=Pics_Width*2-20;
    public static final int Pics_Height=Main.H;
    public static final int STARTING_POINT=0;
    public static final int MARGIN=20;
    public static final String filter_1="darker";
    public static final String filter_2="lighter";
    public static final String filter_3="grayscale";
    public static final String filter_4="negative";
    public static final String filter_5="contrast";
    public static final String filter_6="eliminateR";
    public static final String filter_7="eliminateG";
    public static final String filter_8="eliminateB";
    public static final String filter_9="RGBtoGBR";
    public static final String filter_10="RGBtoBRG";
    public static final String filter_11="sepia";
    public static final String filter_12="show borders";
    public static final String SUBMIT="submit";
    public static final String RENEW="new(restart)";
    public Panel(int x,int y, int width, int height) {
        int w=width/3;
        int X=w+MARGIN;
        this.setBounds(STARTING_POINT,STARTING_POINT,width,height);
        this.setLayout(null);
        darker =new JButton(filter_1);
        darker.setBounds(X,0,Button_Width,Button_Height);
        darker.addActionListener(this);
        this.add(darker);

        lighter =new JButton(filter_2);
        lighter.setBounds(X,Button_Margin,Button_Width,Button_Height);
        lighter.addActionListener(this);
        this.add(lighter);

        grayscale =new JButton(filter_3);
        grayscale.setBounds(X,Button_Margin*2,Button_Width,Button_Height);
        grayscale.addActionListener(this);
        this.add(grayscale);

        negative =new JButton(filter_4);
        negative.setBounds(X,Button_Margin*3,Button_Width,Button_Height);
        negative.addActionListener(this);
        this.add(negative);

        contrast =new JButton(filter_5);
        contrast.setBounds(X,Button_Margin*4,Button_Width,Button_Height);
        contrast.addActionListener(this);
        this.add(contrast);

        eliminateR =new JButton(filter_6);
        eliminateR.setBounds(X,Button_Margin*5,Button_Width,Button_Height);
        eliminateR.addActionListener(this);
        this.add(eliminateR);

        eliminateG =new JButton(filter_7);
        eliminateG.setBounds(X,Button_Margin*6,Button_Width,Button_Height);
        eliminateG.addActionListener(this);
        this.add(eliminateG);

        eliminateB =new JButton(filter_8);
        eliminateB.setBounds(X,Button_Margin*7,Button_Width,Button_Height);
        eliminateB.addActionListener(this);
        this.add(eliminateB);

        RGBtoGBR =new JButton(filter_9);
        RGBtoGBR.setBounds(X,Button_Margin*8,Button_Width,Button_Height);
        RGBtoGBR.addActionListener(this);
        this.add(RGBtoGBR);

        RGBtoBRG =new JButton(filter_10);
        RGBtoBRG.setBounds(X,Button_Margin*9,Button_Width,Button_Height);
        RGBtoBRG.addActionListener(this);
        this.add(RGBtoBRG);

        sepia =new JButton(filter_11);
        sepia.setBounds(X,Button_Margin*10,Button_Width,Button_Height);
        sepia.addActionListener(this);
        this.add(sepia);

        showBorders=new JButton(filter_12);
        showBorders.setBounds(X,Button_Margin*11,Button_Width,Button_Height);
        showBorders.addActionListener(this);
        this.add(showBorders);

        textField=new JTextField();
        textField.setBounds(X,Button_Margin*12,Button_Width/2,Button_Height);
        this.add(textField);

        submit=new JButton(SUBMIT);
        submit.setBounds(X+Button_Width/2,Button_Margin*12,Button_Width/2,Button_Height);
        submit.addActionListener(this);
        this.add(submit);

        New=new JButton(RENEW);
        New.setBounds(X,Button_Margin*13,Button_Width,Button_Height);
        New.addActionListener(this);
        this.add(New);


        pic1 = new JLabel();
        pic1.setBounds(STARTING_POINT, STARTING_POINT, Pics_Width, Pics_Height);
        this.add(pic1);

        pic2 = new JLabel();
        pic2.setBounds(Pic2_X,STARTING_POINT,Pics_Width, Pics_Height);
        this.add(pic2);
    }
    public static int adjustSize(BufferedImage bufferedImage,int width){
        int a=bufferedImage.getHeight();
        int b=bufferedImage.getWidth();
        double c=1;
        if (a!=0&&b!=0){
            c=(double)a/b;
        }
        int d=(int) (width*c);
        return d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            URL url= new URL(textField.getText());
            if(e.getSource()== darker){
                if(validation(textField.getText())) {
                    filter1(url);
                }
            }if(e.getSource()== lighter){
                if(validation(textField.getText())) {
                    filter2(url);
                }
            }if(e.getSource()== grayscale){
                if(validation(textField.getText())) {
                    filter3(url);
                }
            }if(e.getSource()== negative){
                if(validation(textField.getText())) {
                    filter4(url);
                }
            }if(e.getSource()== contrast){
                if(validation(textField.getText())) {
                    filter5(url);
                }
            }if(e.getSource()== eliminateR){
                if(validation(textField.getText())) {
                    filter6(url);
                }
            }if(e.getSource()== eliminateG){
                if(validation(textField.getText())) {
                    filter7(url);
                }
            }if(e.getSource()== eliminateB){
                if(validation(textField.getText())) {
                    filter8(url);
                }
            }if(e.getSource()== RGBtoGBR){
                if(validation(textField.getText())) {
                    filter9(url);
                }
            }if(e.getSource()== RGBtoBRG){
                if(validation(textField.getText())) {
                    filter10(url);
                }
            }if(e.getSource()== sepia){
                if(validation(textField.getText())) {
                    filter11(url);
                }
            }if(e.getSource()==showBorders){
                if(validation(textField.getText())) {
                    filter12(url);
                }
            }if(e.getSource()==submit){
                textField.setEditable(false);
                submit.setEnabled(false);
                if(validation(textField.getText())) {
                    createImage1(url);
                }
            }if (e.getSource()==New){
                textField.setText("");
                textField.setEditable(true);
                submit.setEnabled(true);
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }
    public void createImage1(URL url){

        BufferedImage bufferedImage1 = null;
        try {
            bufferedImage1 = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage1!=null) {
            ImageIcon image1 = new ImageIcon(bufferedImage1.getScaledInstance(Pics_Width, adjustSize(bufferedImage1, Pics_Width), Image.SCALE_SMOOTH));
            pic1.setIcon(image1);
        }

    }
    public void filter1(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.darker(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter2(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.lighter(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter3(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.grayScale(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter4(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.negative(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter5(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.contrast(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter6(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.eliminateR(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter7(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.eliminateG(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter8(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.eliminateB(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter9(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.RGBtoGBR(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter10(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.RGBtoBRG(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter11(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.sepia(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public void filter12(URL url){
        BufferedImage bufferedImage2=null;
        try {
            bufferedImage2 = Filters.showBorders(ImageIO.read(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bufferedImage2!=null) {
            ImageIcon image2 = new ImageIcon(bufferedImage2.getScaledInstance(Pics_Width, adjustSize(bufferedImage2, Pics_Width), Image.SCALE_SMOOTH));
            pic2.setIcon(image2);
        }
    }
    public boolean validation(String url){
        boolean flag=false;
        if (!submit.isEnabled()&&!url.equals("")){
         if (isValid(url)){
             flag=true;
         }
        }
        return flag;
    }
    public boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
