package gui.oop.pkg1.dolgozat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    private JFrame frame = new JFrame();
    private JButton gomb1, gomb2, gomb3, gomb4, gomb5, gomb6, gomb7, gomb8, gomb9, gomb0;
    private JButton[] gombok;
    private JTextField jtfKod;
    private String kod = "";
    private JCheckBox jcbKev;
    private JPanel pnlPin;
    private JLabel lblText;

    public GUIOOP1Dolgozat(){
        form();
    }
    
    private void form(){
        frame = new JFrame("GUI- OOP 1. dolgozat");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new FormWindowAdapter());
        
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-205, kep.height/2-175, 410, 350);
        
        
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
        mnuPrgUjra.addActionListener(new MnuUjraListener());
        mnuPrg.add(mnuPrgUjra);
        
        mnuPrg.addSeparator();
        
        JMenuItem mnuPrgKilep = new JMenuItem("Kilépés");
        mnuPrgKilep.addActionListener(new MnuKilepListener());
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
        
        pnlPin = pnlPinIni();
        JPanel pnlBea = pnlBeaIni();
        
        pnlBej.add(pnlPin);
        pnlBej.add(pnlBea);
        
        
        pnlTab.addTab("Bejelentkezés", pnlBej);
        pnlTab.addTab("Játék", pnlJat);
        return pnlTab;
    }
    
    private JPanel pnlPinIni(){
        LayoutManager lymPin = new GridLayout(4, 3);
        pnlPin = new JPanel(lymPin);
        pnlPin.setBorder(new TitledBorder("Pin kód"));
        gombok();
        
        return pnlPin;
    }
    
    private JPanel pnlBeaIni(){
        LayoutManager lymBea = new GridLayout(3, 4);
        JPanel pnlBea = new JPanel(lymBea);
        pnlBea.setBorder(new TitledBorder("Beállítás"));
        
        jcbKev = new JCheckBox("kever");
        jcbKev.addActionListener(new kever());
        lblText = new JLabel("kód: ");
        jtfKod = new JTextField();
        
        pnlBea.add(jcbKev);
        pnlBea.add(lblText);
        pnlBea.add(jtfKod);
        
        return pnlBea;
    }
    
    private void gombok(){
        gombok = new JButton[GOMB_DB];

        
        gomb1 = new JButton("1");
        gombok[0] = gomb1;
        gomb2 = new JButton("2");
        gombok[1] = gomb2;
        gomb3 = new JButton("3");
        gombok[2] = gomb3;
        gomb4 = new JButton("4");
        gombok[3] = gomb4;
        gomb5 = new JButton("5");
        gombok[4] = gomb5;
        gomb6 = new JButton("6");
        gombok[5] = gomb6;
        gomb7 = new JButton("7");
        gombok[6] = gomb7;
        gomb8 = new JButton("8");
        gombok[7] = gomb8;
        gomb9 = new JButton("9");
        gombok[8] = gomb9;
        gomb0 = new JButton("0");
        gombok[9] = gomb0;
        for (JButton g : gombok) {
            g.addActionListener(new btnAction());
        }   
        gombBerak();
        frame.validate();
    }
    
    class btnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton gomb = (JButton)e.getSource();
            String felirat = gomb.getActionCommand();
            gomb.setBackground(Color.CYAN);
            kod += felirat;
            jtfKod.setText(kod);
            System.out.println(kod);
            
        }
        
    }
    class FormWindowAdapter extends WindowAdapter{
        //névtelen belső osztállyal használható (ld. előző megoldás), lambdával nem
        @Override
        public void windowClosing(WindowEvent e) {
            //ALT + INSERT
            super.windowClosing(e);
            kilepes();
        }
        
    }
    private void kilepes(){
        int valasz = JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
        if(valasz == JOptionPane.YES_OPTION){
            System.exit(valasz);
        }
    }
    
    class kever implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){ 
            
            if (jcbKev.isSelected()) {
                //System.out.println("Kiválasztva");
                List<Integer> szamok = new ArrayList<>();
                for (int i = 0; i < GOMB_DB; i++) {
                    szamok.add(i);
                }
                
                Collections.shuffle(szamok);
                gombok[szamok.get(0)] = gomb1;
                gombok[szamok.get(1)] = gomb2;
                gombok[szamok.get(2)] = gomb3;
                gombok[szamok.get(3)] = gomb4;
                gombok[szamok.get(4)] = gomb5;
                gombok[szamok.get(5)] = gomb6;
                gombok[szamok.get(6)] = gomb7;
                gombok[szamok.get(7)] = gomb8;
                gombok[szamok.get(8)] = gomb9;
                gombok[szamok.get(9)] = gomb0;
                //System.out.println(szamok.get(0));
                gombBerak();
                
                frame.validate();
            }else if(!(jcbKev.isSelected())){
                for (JButton g : gombok) {
                    pnlPin.remove(g);
                }
                gombok();
            }
        } 
    }
    class MnuKilepListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            kilepes();
        }
        
    }
    
    class MnuUjraListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ujJatek();
        }
        
    }
    
    private void ujJatek(){
        jtfKod.setText("");
        pnlPin.removeAll();
        gombok();
        jcbKev.setSelected(false);
        frame.validate();
    }
    
    private void gombBerak(){
         for (JButton g : gombok) {
            pnlPin.add(g);
        }
    }
}
