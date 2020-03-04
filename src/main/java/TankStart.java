import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankStart {
    public static void main(String[] args) {
        Frame f = new Frame("坦克大战");
        //可视化
        f.setVisible(true);
        //设置大小
        f.setSize(800,800);
        //可调整大小的
        f.setResizable(true);
        //
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
