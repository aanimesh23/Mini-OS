import java.io.*;
// import java.nio.file.Files;
// import java.nio.file.Path;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Circle; 
import javafx.scene.Group; 
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text; 
import javafx.event.EventHandler; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.image.ImageView; 
import javafx.scene.shape.Line;

public class Main extends Application
{
    private static final int NUMBER_OF_USERS = 4;
    private static final int NUMBER_OF_DISKS = 2;
    private static final int NUMBER_OF_PRINTERS = 3;

    public static final Disk[] disk = new Disk[NUMBER_OF_DISKS];
    public static final Printer[] printers = new Printer[NUMBER_OF_PRINTERS];
    public static final UserThread users[] = new UserThread[NUMBER_OF_USERS];

    public static final DiskManager disk_manager = new DiskManager(NUMBER_OF_DISKS);
    public static final ResourceManager disk_allocation = new ResourceManager(NUMBER_OF_DISKS);
    public static final ResourceManager printer_allocation = new ResourceManager(NUMBER_OF_PRINTERS);

    static {
        for(int i = 1; i <= disk.length; i++) {
            disk[i-1] = new Disk(15360,i);
        }
        for(int i = 1; i <= printers.length; i++) {
            printers[i-1] = new Printer(i);
        }
        for(int i = 1; i <= users.length; i++) {
            users[i-1] = new UserThread(i);
        }
    }

    public static Circle[] d = new Circle[2];
    public static Rectangle[] u = new Rectangle[4];
    public static Polygon[] p = new Polygon[3];
    public static boolean started = false;
    public static Line[][] data= new Line[4][5];

    public static Line d1tou1 = new Line(210, 175, 450, 90);
    public static Line d1tou2 = new Line(210, 175, 450, 280);
    public static Line d1tou3 = new Line(210, 175, 450, 470);
    public static Line d1tou4 = new Line(210, 175, 450, 660);

    public static Line d2tou1 = new Line(210, 550, 450, 90);
    public static Line d2tou2 = new Line(210, 550, 450, 280);
    public static Line d2tou3 = new Line(210, 550, 450, 470);
    public static Line d2tou4 = new Line(210, 550, 450, 660);

    public static Line p1tou1 = new Line(800, 150, 550, 90);
    public static Line p1tou2 = new Line(800, 150, 550, 280);
    public static Line p1tou3 = new Line(800, 150, 550, 470);
    public static Line p1tou4 = new Line(800, 150, 550, 660);

    public static Line p2tou1 = new Line(800, 350, 550, 90);
    public static Line p2tou2 = new Line(800, 350, 550, 280);
    public static Line p2tou3 = new Line(800, 350, 550, 470);
    public static Line p2tou4 = new Line(800, 350, 550, 660);

    public static Line p3tou1 = new Line(800, 550, 550, 90);
    public static Line p3tou2 = new Line(800, 550, 550, 280);
    public static Line p3tou3 = new Line(800, 550, 550, 470);
    public static Line p3tou4 = new Line(800, 550, 550, 660);

	public static void Main(String[] args) 
	{
        launch(args);
    }



    // GUI IMPLEMENTTION

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try{

            data[0][0] = d1tou1;
            data[1][0] = d1tou2;
            data[2][0] = d1tou3;
            data[3][0] = d1tou4;

            data[0][1] = d2tou1;
            data[1][1] = d2tou2;
            data[2][1] = d2tou3;
            data[3][1] = d2tou4;

            data[0][2] = p1tou1;
            data[1][2] = p1tou2;
            data[2][2] = p1tou3;
            data[3][2] = p1tou4;

            data[0][3] = p2tou1;
            data[1][3] = p2tou2;
            data[2][3] = p2tou3;
            data[3][3] = p2tou4;

            data[0][4] = p3tou1;
            data[1][4] = p3tou2;
            data[2][4] = p3tou3;
            data[3][4] = p3tou4;            

            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    data[i][j].setStroke(Color.WHITE);
                    data[i][j].setStrokeWidth(10);
                    data[i][j].setStrokeLineCap(StrokeLineCap.BUTT);

                    data[i][j].getStrokeDashArray().addAll(10d, 1d, 10d, 1d, 10d);
                    data[i][j].setStrokeDashOffset(10);
                }
            }

        primaryStage.setTitle("141 Operating System");
        Circle disk1 = new Circle();
        Text d1 = new Text();
        Circle disk2 = new Circle();
        Text d2 = new Text();
        d[0] = disk1;
        d[1] = disk2;
        drawDisk(d, d1, d2);
        String temp = System.getProperty("user.dir");
        Image image_christmas = new Image(new FileInputStream(temp + "/resources/christmas.png"));
        ImageView asthetics = new ImageView(image_christmas);
        asthetics.setX(0); 
        asthetics.setY(0);
        asthetics.setFitHeight(5000); 
        asthetics.setFitWidth(500); 
        asthetics.setPreserveRatio(true);

        ImageView asthetics1 = new ImageView(image_christmas);
        asthetics1.setX(500); 
        asthetics1.setY(0);
        asthetics1.setFitHeight(5000); 
        asthetics1.setFitWidth(500); 
        asthetics1.setPreserveRatio(true);



        Image image_disk = new Image(new FileInputStream(temp + "/resources/disk.png"));
        ImageView diskView1 = new ImageView(image_disk);
        diskView1.setX(125); 
        diskView1.setY(140);
        diskView1.setFitHeight(70); 
        diskView1.setFitWidth(70); 
        diskView1.setPreserveRatio(true);

        ImageView diskView2 = new ImageView(image_disk);
        diskView2.setX(125); 
        diskView2.setY(515);
        diskView2.setFitHeight(70); 
        diskView2.setFitWidth(70); 
        diskView2.setPreserveRatio(true);
        
        Rectangle user1 = new Rectangle();
        Text u1 = new Text();
        Rectangle user2 = new Rectangle();
        Text u2 = new Text();
        Rectangle user3 = new Rectangle();
        Text u3 = new Text();
        Rectangle user4 = new Rectangle();
        Text u4 = new Text();
        u[0] = user1;
        u[1] = user2;
        u[2] = user3;
        u[3] = user4;
        Image image_user = new Image(new FileInputStream(temp + "/resources/user3.png"));
        ImageView userView1 = new ImageView(image_user);
        userView1.setX(450); 
        userView1.setY(40);
        userView1.setFitHeight(100); 
        userView1.setFitWidth(100); 
        userView1.setPreserveRatio(true);

        ImageView userView2 = new ImageView(image_user);
        userView2.setX(450); 
        userView2.setY(230);
        userView2.setFitHeight(100); 
        userView2.setFitWidth(100); 
        userView2.setPreserveRatio(true);

        ImageView userView3 = new ImageView(image_user);
        userView3.setX(450); 
        userView3.setY(420);
        userView3.setFitHeight(100); 
        userView3.setFitWidth(100); 
        userView3.setPreserveRatio(true);

        ImageView userView4 = new ImageView(image_user);
        userView4.setX(450); 
        userView4.setY(610);
        userView4.setFitHeight(100); 
        userView4.setFitWidth(100); 
        userView4.setPreserveRatio(true);
        drawUser(u, u1, u2, u3, u4);
        
        Polygon printer1 = new Polygon();
        Polygon printer2 = new Polygon();
        Polygon printer3 = new Polygon();
        Text p1 = new Text();
        Text p2 = new Text();
        Text p3 = new Text();
        p[0] = printer1;
        p[1] = printer2;
        p[2] = printer3;
        Image image_printer = new Image(new FileInputStream(temp + "/resources/printer.png"));
        ImageView printerView1 = new ImageView(image_printer);
        printerView1.setX(800); 
        printerView1.setY(100);
        printerView1.setFitHeight(100); 
        printerView1.setFitWidth(100); 
        printerView1.setPreserveRatio(true);

        ImageView printerView2 = new ImageView(image_printer);
        printerView2.setX(800); 
        printerView2.setY(300);
        printerView2.setFitHeight(100); 
        printerView2.setFitWidth(100); 
        printerView2.setPreserveRatio(true);

        ImageView printerView3 = new ImageView(image_printer);
        printerView3.setX(800); 
        printerView3.setY(500);
        printerView3.setFitHeight(100); 
        printerView3.setFitWidth(100); 
        printerView3.setPreserveRatio(true);

        System.out.println("1010_+excecute ENTER!");
        Button button = new Button();
        button.setText("Start!");
        button.setLayoutX(470);
        button.setLayoutY(820);
        button.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
            if(!started)
            {
                started = true;
                System.out.println("Starting!!");
                button.setText("Stop");
                for(int i = 0; i < users.length; i++) 
                {
                    users[i].start();
                }
            }
            else
            {
                System.exit(0);
            }

         }
      })); 
        drawPrinter(p, p1, p2, p3);
        
        Group root = new Group(disk1, disk2, d1, d2, user1, u1, user2, u2, user3, u3, user4, u4, printer1, printer2, printer3, p1, p2, p3, button, asthetics
            , diskView1, diskView2, asthetics1
            , userView1, userView2, userView3, userView4,
            printerView1, printerView2, printerView3,
            d1tou1, d2tou1, d1tou2, d2tou2, d1tou3, d2tou3, d1tou4, d2tou4,
            p1tou1, p2tou1, p3tou1, 
            p1tou2, p2tou2, p3tou2,
            p1tou3, p2tou3, p3tou3,
            p1tou4, p2tou4, p3tou4);

        Scene scene = new Scene(root, 1000, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
       }
       catch(Exception e)
       {
            e.printStackTrace();
       } 
    }
    void drawPrinter(Polygon[] p, Text pt1, Text pt2, Text pt3)
    {
        p[0].getPoints().addAll(new Double[]{ 
                 800.0, 100.0, 
                 900.0, 100.0,
                 900.0, 200.0,  
                 800.0, 200.0,
              });
        p[0].setFill(Color.GREEN);
        pt1.setText("Printer 1");
        pt1.setX(825); 
        pt1.setY(230);
        
        p[1].getPoints().addAll(new Double[]{ 
                 800.0, 300.0, 
                 900.0, 300.0,
                 900.0, 400.0, 
                 800.0, 400.0, 
              });
        p[1].setFill(Color.GREEN);
        pt2.setText("Printer 2");
        pt2.setX(825); 
        pt2.setY(430);
        
        
        p[2].getPoints().addAll(new Double[]{ 
                 800.0, 500.0, 
                 900.0, 500.0,
                 900.0, 600.0, 
                 800.0, 600.0, 
              });
        p[2].setFill(Color.GREEN);
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
        u[0].setFill(Color.GREEN);
        u1.setText("User 1");
        u1.setX(475); 
        u1.setY(170);
        
        
        u[1].setX(450.0f); 
        u[1].setY(230.0f); 
        u[1].setWidth(100.0f); 
        u[1].setHeight(100.0f);
        u[1].setFill(Color.GREEN);
        u2.setText("User 2");
        u2.setX(475); 
        u2.setY(370);
        
        
        u[2].setX(450.0f); 
        u[2].setY(420.0f); 
        u[2].setWidth(100.0f); 
        u[2].setHeight(100.0f);
        u[2].setFill(Color.GREEN);
        u3.setText("User 3");
        u3.setX(475); 
        u3.setY(550);
        
        
        
        u[3].setX(450.0f); 
        u[3].setY(610.0f); 
        u[3].setWidth(100.0f); 
        u[3].setHeight(100.0f);
        u[3].setFill(Color.GREEN);
        u4.setText("User 4");
        u4.setX(475); 
        u4.setY(740);
    }
    void drawDisk(Circle[] d,Text d1, Text d2)
    {
        d[0].setCenterX(160.0f); 
        d[0].setCenterY(175.0f); 
        d[0].setRadius(50.0f); 
        d[0].setFill(Color.GREEN);
        d1.setText("Disk 1");
        d1.setX(140); 
        d1.setY(250); 
        
        d[1].setCenterX(160.0f); 
        d[1].setCenterY(550.0f); 
        d[1].setRadius(50.0f);
        d[1].setFill(Color.GREEN);
        d2.setText("Disk 2");
        d2.setX(140); 
        d2.setY(635);
    }

}
