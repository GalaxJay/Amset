/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;




/**
 *
 * @author c.bories
 */
public class ServiceComboBoxModel implements ComboBoxModel{
    
    private List<Service> services = new ArrayList<Service>();
    private Object selectedItem;
    private int selecteItemId;
    
    private ServiceDao serviceDao;
    
    public ServiceComboBoxModel(){
        this.serviceDao = new ServiceDao();
        this.refresh();
    }
    
    
    
    public void refresh() {
        this.services = serviceDao.getAll();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem=anItem;
        
    }

    @Override
    public Object getSelectedItem() {
       return this.selectedItem;
    }

    @Override
    public int getSize() {
       return this.services.size();
    }

    @Override
    public Service getElementAt(int index) {
        return this.services.get(index);
    }


    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
       
    }
    
    
    
}
