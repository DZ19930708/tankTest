
public class TankFrame {
    public static void main(String[] args) throws InterruptedException {
        TankStart f  = new TankStart();


        while (true){
            Thread.sleep(20);
            f.repaint();
        }


    }
}
