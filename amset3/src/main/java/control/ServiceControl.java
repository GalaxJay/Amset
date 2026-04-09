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
    private ServiceTableModel srvTableModel;
    private int idSelected;

    public ServiceControl(ServiceView view) {
        this.serviceView = view;
        this.serviceView.addPropertyChangeListener(this);

        this.srvTableModel = new ServiceTableModel();
        this.serviceView.setServiceTableModel(this.srvTableModel);
        this.serviceView.hideColumn();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "AjoutService":
                this.serviceView.clearDialog();
                this.serviceView.openDialogueEditSrv("ajout");
                break;
            case "validAjoutService":
                this.srvTableModel.addService(this.serviceView.getSrvName(), this.serviceView.getSrvIsAdmini());
                break;
            case "ModifService":
                String[] value = this.serviceView.getSelectedServiceRow();
                idSelected = Integer.parseInt(value[0]);
                this.serviceView.setModifName(value[1]);
                this.serviceView.setModifIsAdmini(Integer.parseInt(value[2]));
                this.serviceView.openDialogueEditSrv("modif");
                break;
            case "validModifService":
                this.srvTableModel.modifService(idSelected, this.serviceView.getSrvName(), this.serviceView.getSrvIsAdmini());
                break;
            case "SupprService":
                this.serviceView.openSupprDialog();
                break;
            case "validSupprService":
                this.srvTableModel.supprService(this.serviceView.getSelectedId());
                break;
        }
    }
}
