package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by sovarugby on 13.01.17.
 */
public class Frame extends JPanel implements ActionListener{

    public static int scale = 32;
    public static int width = 20;
    public static int height = 20;
    public static int counter = 0;
    Food food = new Food();

    Snake snake = new Snake(10, 10, 9, 10);

    Timer timer = new Timer(100,this);

    public Frame(){
        timer.start();
        addKeyListener( new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics graphics){
        graphics.setColor(new Color(5,50,10));
        graphics.fillRect(0,0, width*scale,height*scale);




        for (int i = 0; i < snake.length ; i++) {
            graphics.setColor(new Color(10,10,100));
            graphics.fillRect(snake.snakeX[i]*scale,snake.snakeY[i]*scale,scale,scale);

        }

        graphics.setColor(new Color(100, 10 , 0));
        graphics.fillRect(food.foodX*scale,food.foodY*scale,scale,scale);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("snake OMNOMNOMNOM");
        frame.setSize(width*scale, (height+1)*scale);
        frame.setLocationRelativeTo(null);

        frame.add(new Frame());

        JPanel panel = new JPanel();
        JTextField text = new JTextField(10);
        text.setText(""+counter);
        panel.add(text);

        panel.setBackground(new Color(100,100,100));

        frame.add(panel,BorderLayout.PAGE_END);

        frame.setVisible(true);




    }


    public void actionPerformed(ActionEvent e) {
        snake.move();

        for (int i = 1; i <snake.length ; i++) {
            if((snake.snakeX[i]==food.foodX)&(snake.snakeY[i]==food.foodY))
            { food.setRandomFood();}
        }


        if((snake.snakeX[0]==food.foodX)&(snake.snakeY[0]==food.foodY)) {
            food.setRandomFood();
            snake.length++;
            counter++;

        }
        repaint();
    }

    public class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent){
            int key = keyEvent.getKeyCode();


            if((key ==keyEvent.VK_RIGHT)&snake.direction!=2) snake.direction=0;
            if((key ==keyEvent.VK_DOWN)&snake.direction!=3) snake.direction=1;
            if((key ==keyEvent.VK_LEFT)&snake.direction!=0) snake.direction=2;
            if((key ==keyEvent.VK_UP)&snake.direction!=1) snake.direction=3;

        }

    }
}
