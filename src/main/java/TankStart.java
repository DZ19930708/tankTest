import contants.SettingDir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankStart extends Frame {

    static int GAME_WIDTH = 800;
    static int GAME_HEIGHT = 600;
    int tank1x = 200;
    int tank1y = 570;

    TankDTO player1Tank = new TankDTO(tank1x,tank1y,SettingDir.UP,this);
    List<BulletDTO> bList = new ArrayList<BulletDTO>();
//    TankDTO player2Tank = new TankDTO(210,210,SettingDir.RIGHT);

    public TankStart() {
        //设置可视化
        setVisible(true);
        //设置大小
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //设置为 窗口不可调整大小
        setResizable(false);
        //设置 标题
        setTitle("坦克大战");
        //调用父类的 键盘监听方法,传入自己继承于入参类的子类
        this.addKeyListener(new MyTankListener());
        //调用父类方法关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    //设置一张图片
    Image offScreenImage = null;

    /**
     * 双缓冲原理
     * 重写update方法
     * repaint的时候会先调用update方法 然后update方法会调用paint方法
     * 解释：
     * 屏幕刷新过快，会产生闪烁现象，为了去除这种现象
     * 就可以定义一张背景大小的图然后将所有元素定义在这张图上后，一起展示
     * @param g
     */
    @Override
    public void update(Graphics g) {
        //如果为空
        if (offScreenImage == null){
            //则创建一张和背景一样大小的图
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        //然后获取系统的画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        //给这张背景大小的图设置为黑色
        gOffScreen.setColor(Color.BLACK);
        //重新绘制背景
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        //增加颜色
        gOffScreen.setColor(c);
        //绘制坦克等其他元素
        paint(gOffScreen);
        //最后把整体的图片一起加载进来
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:"+bList.size(),10,60);
        g.setColor(c);
        //构建玩家1坦克
        player1Tank.paint(g);
        for (int i =0;i<bList.size();i++){
            bList.get(i).paint(g);
        }
    }


    //创建一个监听类 监听键盘的按下和释放
    class MyTankListener extends KeyAdapter {

        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        //键盘按下时事件
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    player1Tank.fire();
                    break;
                default:
                    break;
            }

            setDirectionForTank();
        }


        //键盘放开时事件
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                default:
                    break;
            }


            setDirectionForTank();
        }

        /**
         * 设置坦克行走方向
         */
        private void setDirectionForTank() {
            if (!bl&&!br&&!bu&&!bd) {
                player1Tank.setMoving(false);
            }else {
                player1Tank.setMoving(true);
                if (bl) player1Tank.setSd(SettingDir.LEFT);
                if (br) player1Tank.setSd(SettingDir.RIGHT);
                if (bu) player1Tank.setSd(SettingDir.UP);
                if (bd) player1Tank.setSd(SettingDir.DOWN);
            }

        }
    }

}

