/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import model.SalarieTableModel;
import model.ServiceComboBoxModel;
import view.SalarieView;

/**
 *
 * @author c.perrat
 */
public class SalarieControl implements PropertyChangeListener {

    private SalarieView salarieView;
    private SalarieTableModel salarieTableModel;
    private ServiceComboBoxModel serviceComboBoxModel;

    public SalarieControl(SalarieView view) throws Exception {
        this.salarieView = view;
        this.salarieView.addPropertyChangeListener(this);
        this.salarieTableModel = new SalarieTableModel();
        this.serviceComboBoxModel = new ServiceComboBoxModel();
        this.salarieView.setSalarieTableModel(this.salarieTableModel);
        this.salarieView.setSalarieComboBoxModel(serviceComboBoxModel);
        this.salarieView.hideSalarieIdColumn();
        
    

    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "openAjoutSalarie":
                this.salarieView.openAjoutSal();
                break;
            case "valideAjoutSalarie":
                this.salarieTableModel.addSalarie(this.salarieView.getSalNom(),this.salarieView.getSalPrenom(),this.salarieView.getSalFonction(),java.sql.Date.valueOf(this.salarieView.getSalDate()),this.salarieView.getSalServiceId());
                break;
        }
    }
}

    

