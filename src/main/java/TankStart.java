import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankStart extends Frame {

    int x = 200;

    int y = 200;

    public TankStart() {
        //设置可视化
        setVisible(true);
        //设置大小
        setSize(800, 800);
        //设置为 窗口可调整大小
        setResizable(true);
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

    @Override
    public void paint(Graphics g) {
        //构建运动小方块，初始化大小为20*20 初始化位置为 X，Y
        g.fillRect(x, y, 30, 30);
    }


    //创建一个监听类 监听键盘的按下和释放
    class MyTankListener extends KeyAdapter {
        //键盘按下时事件
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
//                    System.out.println(x--);
                    x--;
                    break;
                case KeyEvent.VK_RIGHT:
                    x++;
                    break;
                case KeyEvent.VK_UP:
//                    System.out.println(y--);
                    y--;
                    break;
                case KeyEvent.VK_DOWN:
                    y++;
                    break;
                default:
                    break;
            }

        }

        //键盘放开时事件
        @Override
        public void keyReleased(KeyEvent e) {
//            super.keyReleased(e);
        }
    }

}

