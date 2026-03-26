/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author c.perrat
 */
public class ServiceTableModel extends AbstractTableModel {
    
    private final String[] nomColonnes = {"id","Nom","Administratif"};
    
    private List<Service> services = new ArrayList<Service>();
    
    private ServiceDao serviceDao;

    public ServiceTableModel() {
        this.serviceDao = new ServiceDao();
        this.refresh();
    }
    
    public void refresh() {
        this.services = serviceDao.getAll();
    }

    @Override
    public int getRowCount() {
        return services.size();
    }

    @Override
    public int getColumnCount() {
        return this.nomColonnes.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return this.nomColonnes[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return this.services.get(rowIndex).getId();
            case 1 :
                return this.services.get(rowIndex).getNom();
            case 2 :
                return this.services.get(rowIndex).isAdministratif();
            default :
                return null;
        }
    }
    
}
