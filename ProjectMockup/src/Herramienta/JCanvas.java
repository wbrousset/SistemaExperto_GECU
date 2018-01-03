package Herramienta;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCanvas extends JComponent implements MouseListener, MouseMotionListener {
    
    //figura que se pintara en el canvas
    private String figura = "Cuadrado";
    
    private ArrayList<Cuadrado> c = new ArrayList<Cuadrado>();
    
    private int x,y;
    private int x1,y1,x2,y2,w,h;
    //variable boolean para activar la accion de pintado
    private boolean draw = false;
    
    /** Constructor de clase */
    JCanvas(Dimension d)
    {
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        addMouseListener( this ); 
    	addMouseMotionListener( this ); 
    }
    
    /**
     * Asigna la figura que se dibujara en el canvas
     * @param String figura
     */
    public void selectFigura(String figura)
    {
        this.figura = figura;
    }
    
    public static Graphics g;
    
    public void paint(Graphics g) {        
        super.paint( g );
        //pinta las coordenadas del mouse y la figura seleccionada
        //g.drawString( "X,Y: [" + x + "," + y + "] - Figura: " + figura, 10, 20 );
        
        if(draw)//Si modo dibujo esta activado
        {
            //obtiene ancho y alto
            int width = this.x1 - this.x2;
            int height = this.y1 - this.y2;
            w = Math.abs( width );
            h = Math.abs( height );
            x = width < 0 ? x1 : x2;            
            y = height < 0 ? y1 : y2;
            if(figura.equals("Cuadrado"))
               g.drawRect( x, y , w, h );  
            else if(figura.equals("Texto"))
               activeTool = TEXT_TOOL;
        }        
       drawCuadrado(g);
       //drawCirculo(g);
    }

    /**
     * Pinta todos los cuadrados dibujados por el usuario
     * @param Graphics g
     */
    private void drawCuadrado(Graphics g)
    {
         for(int i=0; i< c.size(); i++)
        {
            Cuadrado tmp = c.get(i);
            g.drawRect( tmp.getX(), tmp.getY() , tmp.getW(), tmp.getH() );            
        }
    }    
    
    private JPanel gui;
    private BufferedImage canvasImage;
    private RenderingHints renderingHints;
    private Color color = Color.BLACK;
    
    private Stroke stroke = new BasicStroke(
            3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,1.7f);
    
    public void text(Point point) {
        String text = JOptionPane.showInputDialog(gui, "Ingrese Texto", "Text");
        if (text!=null) {
            g = this.canvasImage.createGraphics();
            //g.setRenderingHints(renderingHints);
            g.setColor(this.color);
            //g.setStroke(stroke);*/
            int n = 0;
            g.drawString(text,point.x,point.y);
            g.dispose();
           // this.imageLabel.repaint();
           
        }
    }
    
    /**
     * Pinta todos los triangulos dibujados por el usuario
     * @param Graphics g
     */

    @Override
    public void mouseClicked(MouseEvent e) {}

    private int activeTool;
    
    public static final int TEXT_TOOL = 2;
    
    @Override
    public void mousePressed(MouseEvent e) {
        draw = true;//activa la accion de dibujo
        x1 = e.getX();
        y1 = e.getY();  
        x2=x1;
        y2=y1;
        
        if (activeTool==JCanvas.TEXT_TOOL) {
                // TODO
                text(e.getPoint());
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        draw = false;//desactiva la accion de dibujo
        
        if(figura.equals("Cuadrado"))
            c.add( new Cuadrado(x,y, w, h) );             
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {        
        x2 = e.getX();
        y2 = e.getY();     
        x = e.getX();
        y = e.getY();       
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();        
        repaint();
    }

    
}//end:JCanvas
