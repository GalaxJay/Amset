/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import view.SalarieView;

/**
 *
 * @author c.perrat
 */
public class SalarieControl implements PropertyChangeListener {
    
    private SalarieView salarieView;

    public SalarieControl(SalarieView view) {
        this.salarieView = view;
        
        this.salarieView.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
    
}
