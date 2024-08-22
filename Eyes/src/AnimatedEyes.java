import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AnimatedEyes extends JPanel  {
    public static void main(String[] args) {
        //creating the frame
        JFrame frame= new JFrame("EYES");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(false);
        AnimatedEyes panel= new AnimatedEyes();
        frame.add(panel);
        frame.setVisible(true);
    }
    
    //The points of the eyes
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point mousePosition;// Position of the cursor as you move


    public AnimatedEyes(){
        //Setting the cordinates of the Eyes
        p1= new Point(170,200);//cordinate of the Left EyePupil
        p2= new Point(300,200);//Cordinate of the Right EyePupil
        p3= new Point(120,150);//Cordinate of the Left EyeLid
        p4= new Point(250,150);// Cordinates of the Right EyeLid
        this.setBackground(Color.GRAY);//Setting the Color of the Panel
        

        
    }
    // Drawing the panel 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    //Adding a mouse Listener to listen to the cursor movement in the Panel
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
                mousePosition=e.getPoint();
                repaint();
            }
        });
        //Moving the Eyepupil up when the Cursor is above the Eyelid
        if (mousePosition.y<150){
            EyeUp(g);
        }
        //Moving the EyePupil Down when the cursor moves below the Eyelid
       else if (mousePosition.y>275){
            EyeDown(g);

        }
        // Eyepupil Stayes in the middle when the  cursor is between the Eyelid
        else{
            EyeCenter(g);
        }
    
    }
    public void EyeCenter(Graphics g){
        
        
        g.setColor(Color.BLACK);
        g.fillRoundRect(p1.x, p1.y, 30, 30, 30, 30);
        g.setColor(Color.BLACK);
        g.fillRoundRect(p2.x, p2.y, 30, 30, 30, 30);
        g.drawRoundRect(p3.x,p3.y,130,130,130,130);
        g.drawRoundRect(p4.x,p4.y,130,130,130,130);
    }

    public void EyeDown(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRoundRect(p1.x, 245, 30, 30, 30, 30);
        g.setColor(Color.BLACK);
        g.fillRoundRect(p2.x, 245, 30, 30, 30, 30);
        g.drawRoundRect(p3.x,p3.y,130,130,130,130);
        g.drawRoundRect(p4.x,p4.y,130,130,130,130);
    }

    public void EyeUp(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRoundRect(p1.x, 155, 30, 30, 30, 30);
        g.setColor(Color.BLACK);
        g.fillRoundRect(p2.x, 155, 30, 30, 30, 30);
        g.drawRoundRect(p3.x,p3.y,130,130,130,130);
        g.drawRoundRect(p4.x,p4.y,130,130,130,130);
    }
    
  
    
}
