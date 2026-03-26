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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.salaries.get(rowIndex).getId();
    }

    private void refresh() {
        this.salDao.getAll();
    }
}
