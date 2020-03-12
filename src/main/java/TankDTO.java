import contants.SettingDir;

import java.awt.*;

public class TankDTO {

    private int x = 200;

    private int y = 200;

    private static final int SPEED = 5;

    SettingDir sd = SettingDir.LEFT;

    private TankStart ts = null;

    private boolean moving = false;

    public TankDTO(int x, int y, SettingDir sd,TankStart ts) {
        this.x = x;
        this.y = y;
        this.sd = sd;
        this.ts = ts;
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public SettingDir getSd() {
        return sd;
    }

    public void setSd(SettingDir sd) {
        this.sd = sd;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 30, 30);
        g.setColor(c);
        move();
    }

    private void move() {
        if (!moving) return;
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

    }


    public void fire() {
        ts.bList.add(new BulletDTO(this.x+15,this.y+15,this.sd,this.ts));
    }
}
