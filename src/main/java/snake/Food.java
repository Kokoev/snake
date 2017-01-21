package snake;

/**
 * Created by sovarugby on 19.01.17.
 */
public class Food {
    public int foodX=(int) (Math.random()*Frame.width);
    public int foodY=(int) (Math.random()*Frame.height);

    public void setRandomFood(){

        foodX = (int) (Math.random()*Frame.width);
        foodY = (int) (Math.random()*Frame.height);
    }
}
