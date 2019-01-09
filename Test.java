/************************
 * Author: Wang Wei
 * From: TJU
 * My Github Website:
 *************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Test {
    public static void main(String[] args) {
        System.out.println("Game begin!!");
        MyGame game_1 = new MyGame();
    }
}


/*
 * Game Class
 * :游戏主逻辑
 * */
class MyGame {
    // music
    //    public int[] music_list= new int[]{1, 1, 2, 2, 3, 3,2,3,4,1,2,3,3,4,2,2,2,3,1,3,3,4, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
    public int[] music_list= new int[]{0,0,0,0,1,4,2,3,2,2,1,2,4,2,2,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,1,0,4,2,3,2,2,1,2,4,2,3,2,2,1,2,4,2,2,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,1,0,4,2,3,2,2,1,2,0,4,2,2,0,2,0,2,2,4,2,3,2,2,1,2,4,2,2,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,1,0,4,2,3,2,2,1,2,0,4,2,2,0,2,0,2,2,4,2,3,2,2,1,2,4,2,2,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,1,0,4,2,3,2,2,1,2,0,4,2,2,0,2,0,2,2,4,2,3,2,2,1,2,4,2,2,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,1,0,4,2,3,2,2,1,2,0,4,2,2,0,2,0,2,2,0,4,2,2,0,2,0,2,2,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,2,0,2,2,0,0,0,0,1,0,4,2,3,2,0,2,1,2,0,4,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    //    public int[] music_list= new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    public int block_x_num;//block number
    public int block_y_num;
    public String[][] blockBuf;
    public int step_offset;
    public int block_height;
    public int music_step;
    public boolean[] music_list_record;
    public int[] music_list_tem;
    public boolean[] music_list_record_tem;
    public int speed;
    public int speed_plus_interval;
    public int speed_plus_interval_count;

    public  MyGame() {
        /*Variables Init--------------------------------------------------------------------*/
        speed=20;//initial speed
        speed_plus_interval=5;//每隔几个方块就加速一次
        speed_plus_interval_count=0;//当前经过了几个方块
        block_x_num=4;//横向方块数量
        block_y_num=10;//纵向方块数量
        step_offset=0;//当前帧步偏移
        block_height=10;//方块的小点个数
        music_step=0;//当前节奏数记录
        music_list_record=new boolean[music_list.length];//记录哪些音节被按过了，用于选择是否显示
        music_list_tem = new int[block_y_num];//当前界面内的几个方块
        music_list_record_tem = new boolean[block_y_num];//当前界面内的几个方块记录是否按过

        /*Init-----------------------------------------------------------------------------*/
        System.out.println("Init Start ...");
        MyFrame dc=new MyFrame(block_x_num,block_y_num);//widow frame init
        blockBuf = new String[block_x_num][block_y_num];//store every pixel's color
        //init music_list_record
        for(int index=0;index<music_list_record.length;index++){
            if(music_list[index]==0){
                music_list_record[index]=true; }
            else {
                music_list_record[index]=false;}}
        //init blockBuf
        blockBuf = toBlockBuf(music_step);//把当前的音符转化成对应的方块位置
        System.out.println("Init Successfully !!!");

        while(true) {
            /*Main-------------------------------------------------------------------------*/
            try {
                Thread.currentThread();// new thread
                Thread.sleep(1000/speed);// delay recording the speed

                //main
                //从总节奏里提取当前帧用到的几个节奏点
                for(int index = 0;index<block_y_num;index++){music_list_tem[index]=music_list[music_step+index];}
                for(int index = 0;index<block_y_num;index++){music_list_record_tem[index]=music_list_record[music_step+index];}

                //找到最低的方块，然后判断是否有按键触发，进行记录，播放音乐
                for(int index=0;index<block_y_num;index++){
                    //skip the one that is trickled or 0
                    if(music_list_record_tem[index]==true){continue;}
                    if(music_list_tem[index]==0){continue;}
                    else{
                        //this is the lowest block
                        if(dc.keyReleasedBuf[music_list_tem[index]]==true){
                            //if touched, record to temporary record list
                            music_list_record_tem[index]=true;
                            new RunnableDemo("for_music").start();//play music once
                        }
                        break;
                    }
                }

                //检测完按键后标志还原
                for(int index=0;index<dc.keyReleasedBuf.length;index++) {dc.keyReleasedBuf[index]=false;}

                //把temporary list 里面的记录导入到总的里面
                for(int index=0;index<block_y_num;index++){
                    music_list_record[music_step+index]=music_list_record_tem[index];
                }

                //显示
                blockBuf=toBlockBuf(music_step);//根据目前节奏谱、节奏记录、步数、偏移，准备进行绘图
                dc.refresh(blockBuf,step_offset);//向dc对象传入参数，用来显示
                dc.repaint();

                //记录偏移，判断是否要载入下一个方块
                if(step_offset>block_height-2){
                    music_step++;
                    step_offset=-1;
                    blockBuf=toBlockBuf(music_step);
                    //increase speed
                    speed_plus_interval_count++;
                    if(speed_plus_interval_count>speed_plus_interval){
                        speed_plus_interval_count=0;
                        speed+=1;
                    }

                }
                step_offset++;

                /*Main-----------------------------------------------------------------------------*/
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public String[][] toBlockBuf(int music_step_in){
        //not pass out
        String[][] temBlockBuf = new String[block_x_num][block_y_num];
        if( (music_step_in+block_y_num)<music_list.length ){
            //creat tem list and record for this round
            for(int index = 0;index<block_y_num;index++){music_list_tem[index]=music_list[music_step_in+index];}
            for(int index = 0;index<block_y_num;index++){music_list_record_tem[index]=music_list_record[music_step_in+index];}
            //index 0-block_y_num, refresh every raw depend on number in list
            for(int y_index =0;y_index<block_y_num;y_index++){
                for(int x_index=0;x_index<block_x_num;x_index++){
                    if(x_index+1==music_list_tem[block_y_num-y_index-1]){
                        //give color to move blocks depend on record list
                        if(music_list_record_tem[block_y_num-y_index-1]==true){
                            temBlockBuf[x_index][y_index]="WHITE";
                        }
                        else {temBlockBuf[x_index][y_index]="BLACK";}
                    }
                    else{temBlockBuf[x_index][y_index]="WHITE";}
                }
            }
        }
        return temBlockBuf;
    }
}


/*
 * Screen Class
 * :用于显示，生成刷新图形界面
 * */
class MyFrame extends JFrame implements KeyListener {
    Dimension deviceScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int block_width,block_height,block_x_num,block_y_num;
    private int  pixel_x_num;
    private int pixel_y_num;
    private int pixel_width;
    private int pixel_height;
    private int stride;
    public String[][] pixelBuf;
    public String[][] blockBuf;
    public String[][] show_pixelBuf;
    public boolean[] keyReleasedBuf;

    public MyFrame(int block_x_num_in,int block_y_num_in) {
        /*Variables-----------------------------------------------------------------------------*/
        block_width=10;//block size
        block_height=10;
        block_x_num=block_x_num_in;//block number
        block_y_num=block_y_num_in;
        pixel_width=5;//pixle size
        pixel_height=5;
        pixel_x_num=block_x_num*block_width;//pixel number
        pixel_y_num=block_y_num*block_height;
        stride=6;//格长
        pixelBuf = new String[pixel_x_num][pixel_y_num];//store every pixel's color
        show_pixelBuf = new String[pixel_x_num][(block_y_num-1)*pixel_height];
        blockBuf = new String[block_x_num][block_y_num];//store every pixel's color
        keyReleasedBuf = new boolean[10];
        //init blockBuf
        for (int x_index = 0; x_index < block_x_num; x_index++) {
            for (int y_index = 0; y_index < block_y_num; y_index++) {
                blockBuf[x_index][y_index]="GRAY";
            }
        }
        //init pixelBuf
        refresh(blockBuf,0);
        //init keyRealseBuf
        for(int index=0;index<10;index++){keyReleasedBuf[index]=false;}

        /*Init-----------------------------------------------------------------------------*/
        setTitle("my Frame");//set title
        System.out.println("screen size : "+deviceScreenSize.width+" x "+deviceScreenSize.height);//print screen size
        setSize(pixel_x_num*stride,pixel_y_num*stride+3);//set size
        setLocation((deviceScreenSize.width-pixel_x_num*stride)/2,(deviceScreenSize.height-pixel_y_num*stride)/2);//set Location

        /*for main-----------------------------------------------------------------------------*/
        setContentPane(new CanvasPanel());//调用自定义的面板，设置窗体面板为绘图面板对象
        addKeyListener(this);

        /*Init-----------------------------------------------------------------------------*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);//close operation
        setResizable(true);//resizable
        setVisible(true);//show
    }

    /*更新pixel缓存------------------------------------------------------------------------*/
    public void refresh(){
        for (int x_index = 0; x_index < block_x_num; x_index++) {
            for (int y_index = 0; y_index < block_y_num; y_index++) {
                for(int pixel_x_index=x_index*block_width;pixel_x_index<(x_index+1)*block_width;pixel_x_index++){
                    for(int pixel_y_index=y_index*block_width;pixel_y_index<(y_index+1)*block_width;pixel_y_index++){
                        pixelBuf[pixel_x_index][pixel_y_index]=blockBuf[x_index][y_index];
                    }
                }
            }
        }
    }
    public void refresh(String[][] blockBuf_in,int step) {
        int pixel_x_real, pixel_y_real;
        this.blockBuf = blockBuf_in;
        for (int x_index = 0; x_index < block_x_num; x_index++) {
            for (int y_index = 0; y_index < block_y_num; y_index++) {
                for (int pixel_x_index = x_index * block_width; pixel_x_index < (x_index + 1) * block_width; pixel_x_index++) {
                    for (int pixel_y_index = y_index * block_width; pixel_y_index < (y_index + 1) * block_width; pixel_y_index++) {
                        pixel_y_real = pixel_y_index + step;
                        pixel_y_real = pixel_y_real % pixel_y_num;
                        pixelBuf[pixel_x_index][pixel_y_real] = blockBuf[x_index][y_index];
                    }
                }
            }
        }
        // rewrite top banner to gray
        for (int x_index = 0; x_index < pixel_x_num; x_index++){
            for (int y_index = 0; y_index < block_height; y_index++){
                if((x_index+y_index)%2==0){pixelBuf[x_index][y_index]="WHITE";}
                else if((x_index+y_index)%2==1){pixelBuf[x_index][y_index]="BLACK";}
            }
        }
    }

    /*按键处理，更新keyReleasedBuf----------------------------------------------------------*/
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode>47 && keyCode<=58){
            keyReleasedBuf[keyCode-48]=true;
            System.out.println(keyCode-48);
        }
    }
    public void keyTyped(KeyEvent e){ }
    public void keyPressed(KeyEvent e){ }

    /*Paint Canvas 自动调用绘图-------------------------------------------------------------*/
    class CanvasPanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;//强制类型转换位Graphics2D类型
            Shape[][] shapes = new Shape[pixel_x_num][pixel_y_num];
            for(int x_index=0;x_index<pixel_x_num;x_index++){
                for(int y_index=0;y_index<pixel_y_num;y_index++){
                    shapes[x_index][y_index] = new Rectangle2D.Double(x_index * stride, y_index * stride, pixel_width, pixel_height);
                    g.setColor(convertColor(pixelBuf[x_index][y_index]));
                    g2.fill(shapes[x_index][y_index]);
                }
            }
        }
    }

    /*Color表-----------------------------------------------------------------------------*/
    public Color convertColor(String color_str){
        if (color_str.equals("GRAY")){return new Color(199, 200, 202);}
        else if (color_str.equals("DARKBLUE")){return new Color(4, 124, 255);}
        else if (color_str.equals("BLUE")){return new Color(54, 166, 255);}
        else if (color_str.equals("RED")){return new Color(255, 15, 0);}
        else if (color_str.equals("WHITE")){return new Color(255, 255, 255, 255);}
        else if (color_str.equals("BLACK")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("1")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("2")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("3")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("4")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("5")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("6")){return new Color(0, 0, 0, 255);}
        else if (color_str.equals("7")){return new Color(0, 0, 0, 255);}
        else {return new Color(251, 253, 255);}
    }
}


/*
 * DemoPlay Class
 * :play方法播放一个音节
 * */
class MySound {

    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLine_info = null;
    private AudioInputStream audioInputStream = null;
//    String path="/Users/Waybaba/Code/Java_project/src/demo/source/";
//    String path="/Users/Waybaba/Code/Java_project/src/demo/super_mario_music/";
    String path="./super_mario_music/";
    private File[] files;
    static int music_count = 0;

    public MySound() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        int int_random;
        while(true){
            int_random=(int)(Math.random()*10);
            if (int_random>0 && int_random<30){break;}
        }
        music_count++;
        if(music_count>70){music_count=0;}
        File file_all = new File(path);		//获取其file对象
        files = file_all.listFiles();
        String new_path = path+music_count+".wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(path+music_count+".wav"));//input stream
        audioFormat = audioInputStream.getFormat();//music format
        dataLine_info = new DataLine.Info(SourceDataLine.class,audioFormat);//好像是一个唯一代表名
        sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLine_info);//convert into a music style
    }

    public void play() throws IOException, LineUnavailableException{
        byte[] b = new byte[1024];
        int len = 0;
        sourceDataLine.open(audioFormat, 1024);
        sourceDataLine.start();
        while ((len = audioInputStream.read(b)) > 0){
            sourceDataLine.write(b, 0, len);
        }
        audioInputStream.close();
        sourceDataLine.drain();
        sourceDataLine.close();
    }


}


/*
 * Thread Class
 * :多线程，start方法实例化音乐播放对象，并播放一个音节
 * */
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try{
            new MySound().play();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void start () {
        System.out.println("\nStarting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}