/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import view.ServiceView;
import model.ServiceTableModel;

/**
 *
 * @author c.perrat
 */
public class ServiceControl implements PropertyChangeListener {

    private ServiceView serviceView;
    
    private ServiceTableModel serTableModel;
    
    public ServiceControl(ServiceView view) {
        this.serviceView = view;
        
        this.serviceView.addPropertyChangeListener(this);
        
        this.serTableModel = new ServiceTableModel();
        
        this.serviceView.setServiceTableModel(this.serTableModel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
}
