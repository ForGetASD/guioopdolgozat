package gui.oop.pkg1.dolgozat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class GUIOOP1Dolgozat {

    public static void main(String[] args) {
        new GUIOOP1Dolgozat();
    }
    
    private static final int GOMB_DB = 10;
    JFrame frame = new JFrame();
    private JButton[] gombok;
    
    public GUIOOP1Dolgozat(){
        form();
    }
    
    private void form(){
        frame = new JFrame("GUI- OOP 1. dolgozat");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-205, kep.height/2-175, 410, 350);
        
        gombok();
        frame.setJMenuBar(menuIni());
        kinezetIni();
        frame.setVisible(true);
    }
    
    private JMenuBar menuIni(){
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuPrg = new JMenu("Program");
        mnuPrg.setMnemonic(KeyEvent.VK_P);
        JMenu mnuJtk = new JMenu("Játék elrendezése");
        mnuJtk.setMnemonic(KeyEvent.VK_J);
        menuBar.add(mnuPrg);
        menuBar.add(mnuJtk);
        
        JMenuItem mnuPrgUjra = new JMenuItem("Újra");
        mnuPrg.add(mnuPrgUjra);
        
        mnuPrg.addSeparator();
        
        JMenuItem mnuPrgKilep = new JMenuItem("Kilépés");
        mnuPrg.add(mnuPrgKilep);
        
        JMenuItem mnuJtkViz = new JMenuItem("Vízszintes");
        mnuJtk.add(mnuJtkViz);
        
        mnuJtk.addSeparator();
        
        JMenuItem mnuJtkFugg = new JMenuItem("Függöleges");
        mnuJtk.add(mnuJtkFugg);
        
        return menuBar;
    }
    
    private void kinezetIni(){
        LayoutManager lymGrid = new GridLayout(1, 2); 
        frame.setLayout(lymGrid);
        
        JTabbedPane pnlTab = pnlTabIni();
        
        frame.getContentPane().add(pnlTab);
    }
    
    private JTabbedPane pnlTabIni(){
        JPanel pnlBej = new JPanel();
        JPanel pnlJat = new JPanel();
        
        JTabbedPane pnlTab = new JTabbedPane();
        
        JPanel pnlPin = pnlPinIni();
        JPanel pnlBea = pnlBeaIni();
        
        pnlBej.add(pnlPin);
        pnlBej.add(pnlBea);
        
        
        pnlTab.addTab("Bejelentkezés", pnlBej);
        pnlTab.addTab("Játék", pnlJat);
        return pnlTab;
    }
    
    private JPanel pnlPinIni(){
        LayoutManager lymPin = new GridLayout(4, 3);
        JPanel pnlPin = new JPanel(lymPin);
        pnlPin.setBorder(new TitledBorder("Pin kód"));
        
        for (JButton g : gombok) {
            pnlPin.add(g);
        }
        
        return pnlPin;
    }
    
    private JPanel pnlBeaIni(){
        LayoutManager lymBea = new GridLayout(3, 4);
        JPanel pnlBea = new JPanel(lymBea);
        pnlBea.setBorder(new TitledBorder("Beállítás"));
        
        JCheckBox jcbKev = new JCheckBox("kever");
        JLabel lblText = new JLabel("kód: ");
        JTextField jtfKod = new JTextField();
        
        pnlBea.add(jcbKev);
        pnlBea.add(lblText);
        pnlBea.add(jtfKod);
        
        return pnlBea;
    }
    
    private void gombok(){
        gombok = new JButton[GOMB_DB];
        
        JButton gomb1 = new JButton("1");
        gombok[0] = gomb1;
        JButton gomb2 = new JButton("2");
        gombok[1] = gomb2;
        JButton gomb3 = new JButton("3");
        gombok[2] = gomb3;
        JButton gomb4 = new JButton("4");
        gombok[3] = gomb4;
        JButton gomb5 = new JButton("5");
        gombok[4] = gomb5;
        JButton gomb6 = new JButton("6");
        gombok[5] = gomb6;
        JButton gomb7 = new JButton("7");
        gombok[6] = gomb7;
        JButton gomb8 = new JButton("8");
        gombok[7] = gomb8;
        JButton gomb9 = new JButton("9");
        gombok[8] = gomb9;
        JButton gomb0 = new JButton("0");
        gombok[9] = gomb0;
    }
}
