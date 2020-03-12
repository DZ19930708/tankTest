import contants.SettingDir;

import java.awt.*;

/**
 * 子弹发射类
 */
public class BulletDTO {


    private int x,y;

    private static final int SPEED = 10;

    private static final int width = 5,height = 5;

    //设置子弹消失
    boolean bulletRemove = false;

    SettingDir sd;

    TankStart ts;

    public BulletDTO(int x, int y, SettingDir sd,TankStart ts) {
        this.x = x;
        this.y = y;
        this.sd = sd;
        this.ts = ts;
    }

    public void paint(Graphics g) {
        if (bulletRemove){
            ts.bList.remove(this);
        }
        //子弹起始位置和大小
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
        g.setColor(c);
        move();
    }


    private void move() {

        switch (sd) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }


        if (x<0||y<0||x>TankStart.GAME_WIDTH||y>TankStart.GAME_HEIGHT){
            bulletRemove =true;
        }

    }
}
