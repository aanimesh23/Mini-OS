import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Circle; 
import javafx.scene.Group; 
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text; 
import javafx.scene.paint.Color;

public class GUI extends Application {

	public void l(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("141 Operating System");
		Circle disk1 = new Circle();
		Text d1 = new Text();
		Circle disk2 = new Circle();
		Text d2 = new Text();
		Circle[] d = {disk1, disk2};
		drawDisk(d, d1, d2);
		
		
		
		Rectangle user1 = new Rectangle();
		Text u1 = new Text();
		Rectangle user2 = new Rectangle();
		Text u2 = new Text();
		Rectangle user3 = new Rectangle();
		Text u3 = new Text();
		Rectangle user4 = new Rectangle();
		Text u4 = new Text();
		Rectangle[] u = {user1, user2, user3, user4};
		
		drawUser(u, u1, u2, u3, u4);
		
		Polygon printer1 = new Polygon();
		Polygon printer2 = new Polygon();
		Polygon printer3 = new Polygon();
		Text p1 = new Text();
		Text p2 = new Text();
		Text p3 = new Text();
		Polygon[] p = {printer1, printer2, printer3};
		
		Button button = new Button();
		button.setText("Start!");
		button.setLayoutX(470);
		button.setLayoutY(820);
		
		drawPrinter(p, p1, p2, p3);
		
		Group root = new Group(disk1, disk2, d1, d2, user1, u1, user2, u2, user3, u3, user4, u4, printer1, printer2, printer3, p1, p2, p3, button);

		Scene scene = new Scene(root, 1000, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	void drawPrinter(Polygon[] p, Text pt1, Text pt2, Text pt3)
	{
		p[0].getPoints().addAll(new Double[]{ 
		         800.0, 100.0, 
		         900.0, 150.0, 
		         800.0, 200.0, 
		      });
		p[0].setFill(Color.RED);
	    pt1.setText("Printer 1");
		pt1.setX(825); 
      	pt1.setY(230);
      	
		p[1].getPoints().addAll(new Double[]{ 
		         800.0, 300.0, 
		         900.0, 350.0, 
		         800.0, 400.0, 
		      });
		p[1].setFill(Color.RED);
	    pt2.setText("Printer 2");
		pt2.setX(825); 
      	pt2.setY(430);
      	
      	
		p[2].getPoints().addAll(new Double[]{ 
		         800.0, 500.0, 
		         900.0, 550.0, 
		         800.0, 600.0, 
		      });
		p[2].setFill(Color.RED);
	    pt3.setText("Printer 3");
		pt3.setX(825); 
      	pt3.setY(630);
		
	}
	
	void drawUser(Rectangle[] u, Text u1, Text u2, Text u3, Text u4)
	{
		u[0].setX(450.0f); 
		u[0].setY(40.0f); 
		u[0].setWidth(100.0f); 
		u[0].setHeight(100.0f); 
		u[0].setFill(Color.RED);
	    u1.setText("User 1");
		u1.setX(475); 
      	u1.setY(170);
      	
	    
      	u[1].setX(450.0f); 
      	u[1].setY(230.0f); 
      	u[1].setWidth(100.0f); 
      	u[1].setHeight(100.0f);
      	u[1].setFill(Color.RED);
	    u2.setText("User 2");
		u2.setX(475); 
      	u2.setY(370);
	    
	    
      	u[2].setX(450.0f); 
      	u[2].setY(420.0f); 
      	u[2].setWidth(100.0f); 
      	u[2].setHeight(100.0f);
      	u[2].setFill(Color.RED);
	    u3.setText("User 3");
		u3.setX(475); 
      	u3.setY(550);
      	
      	
	    
      	u[3].setX(450.0f); 
      	u[3].setY(610.0f); 
      	u[3].setWidth(100.0f); 
      	u[3].setHeight(100.0f);
      	u[3].setFill(Color.RED);
	    u4.setText("User 4");
		u4.setX(475); 
      	u4.setY(740);
	}
	void drawDisk(Circle[] d,Text d1, Text d2)
	{
		d[0].setCenterX(160.0f); 
      	d[0].setCenterY(175.0f); 
      	d[0].setRadius(50.0f); 
      	d[0].setFill(Color.RED);
		d1.setText("Disk 1");
		d1.setX(140); 
      	d1.setY(250); 
      	
      	d[1].setCenterX(160.0f); 
      	d[1].setCenterY(550.0f); 
      	d[1].setRadius(50.0f);
      	d[1].setFill(Color.RED);
      	d2.setText("Disk 2");
		d2.setX(140); 
      	d2.setY(635);
	}

}