
import control.MainControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author c.perrat
 */
public class Amset3 {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                MainView view = new MainView();
               
                
                try {
                    MainControl mainControl = new MainControl(view);
                } catch (Exception ex) {
                    Logger.getLogger(Amset3.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                view.setVisible(true);
            }
        });
    }
}
