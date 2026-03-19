
import control.MainControl;
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
               
                
                MainControl mainControl = new MainControl(view);
                
                view.setVisible(true);
            }
        });
    }
}
