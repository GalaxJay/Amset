/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import model.SalarieTableModel;
import view.SalarieView;

/**
 *
 * @author c.perrat
 */
public class SalarieControl implements PropertyChangeListener {
    
    private SalarieView salarieView;
    private SalarieTableModel salarieTableModel;

    public SalarieControl(SalarieView view) throws Exception {
        this.salarieView = view;
        this.salarieView.addPropertyChangeListener(this);
        this.salarieTableModel = new SalarieTableModel();
        this.salarieView.setSalarieTableModel(this.salarieTableModel);
        this.salarieView.hideSalarieIdColumn();
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
    
}
