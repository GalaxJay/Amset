/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int idSelected;
    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date parsedUtilDate=null;
    java.sql.Date sqltDate = null;

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
                this.salarieView.setSalarieNom("");
                this.salarieView.setSalariePrenom("");
                this.salarieView.setSalarieFonction("");
                this.salarieView.setSalarieDateNaissance("AAAA-MM-DD");
                this.salarieView.setSelectedService(this.serviceComboBoxModel.getElementAt(0));
                this.salarieView.openAjoutSal();
                break;
            case "openModifSalarie":
                String[] value = this.salarieView.getSelectedSalarieRow();
                idSelected = Integer.parseInt(value[0]);
                this.salarieView.setSalarieNom(value[1]);
                this.salarieView.setSalariePrenom(value[2]);
                this.salarieView.setSalarieFonction(value[3]);
                this.salarieView.setSalarieDateNaissance(value[4]);
                this.salarieView.setSelectedService(this.serviceComboBoxModel.getService(Integer.parseInt(value[5])));
                this.salarieView.openModifSal();
                break;
            case "openSupprSalarie":
                this.salarieView.openSupprDialog();
                break;
            case "validAjoutSalarie": 
                try {
                    parsedUtilDate = formater.parse(this.salarieView.getSalDate());
                } catch (ParseException ex) {
                    Logger.getLogger(SalarieControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                sqltDate= new java.sql.Date(parsedUtilDate.getTime());
                              
                this.salarieTableModel.addSalarie(this.salarieView.getSalNom(),this.salarieView.getSalPrenom(),this.salarieView.getSalFonction(),sqltDate,this.serviceComboBoxModel.getElementAt(this.salarieView.getSalServiceIndex()).getId());
                break;
            case "validModifSalarie":
                try {
                    parsedUtilDate = formater.parse(this.salarieView.getSalDate());
                } catch (ParseException ex) {
                    Logger.getLogger(SalarieControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());
                
                this.salarieTableModel.modifSalarie(idSelected,this.salarieView.getSalNom() , this.salarieView.getSalPrenom(), this.salarieView.getSalFonction(), sqltDate, this.serviceComboBoxModel.getElementAt(this.salarieView.getSalServiceIndex()).getId());
                break;
            case "validSupprSalarie":
                this.salarieTableModel.supprSalarie(this.salarieView.getSelectedId());
                break;
            
        }
    }
}

    

