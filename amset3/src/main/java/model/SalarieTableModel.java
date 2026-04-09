/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author c.bories
 */
public class SalarieTableModel extends AbstractTableModel{
    private final String[] nomColonnes = {"id", "Nom", "Prenom", "Fonction","DateNaissance","ServiceId"};
    private List<Salarie> salaries = new ArrayList<Salarie>();
    private SalarieDao salDao;
    
    public SalarieTableModel() throws Exception {
        this.salDao = new SalarieDao();
        this.refresh();

    }

    @Override
    public int getRowCount() {
        return this.salaries.size();
    }

    @Override
    public int getColumnCount() {
      return this.nomColonnes.length;  
    }
    
    @Override
    public String getColumnName(int index){
        return this.nomColonnes[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch (columnIndex){
          case 0:
              return this.salaries.get(rowIndex).getId();
           case 1:
              return this.salaries.get(rowIndex).getNom();
           case 2:
              return this.salaries.get(rowIndex).getPrenom(); 
           case 3:
              return this.salaries.get(rowIndex).getFonction(); 
           case 4:
              return this.salaries.get(rowIndex).getDate(); 
           case 5:
              return this.salaries.get(rowIndex).getServiceId(); 
          default:
              return null;
             
      }
    }
    
    public void addSalarie(String salNom,String salPrenom,String salFonction,Date date,int salIdService){ 
        this.salDao.insertSalarie(salNom, salPrenom, salFonction, date, salIdService);
        this.refresh();
    }
    
    public void modifSalarie(int id,String salNom,String salPrenom,String salFonction,Date date,int salIdService){ 
        this.salDao.updateSalarie(id, salNom, salPrenom, salFonction, date, salIdService);
        this.refresh();
    }
    
    public void supprSalarie(int id) {
        this.salDao.deleteSalarie(id);
        this.refresh();
    }

    private void refresh() {
        this.salaries= this.salDao.getAll();
    }
}
