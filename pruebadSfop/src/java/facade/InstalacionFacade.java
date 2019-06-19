/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Instalacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hachi
 */
@Stateless
public class InstalacionFacade extends AbstractFacade<Instalacion> {

    @PersistenceContext(unitName = "pruebaSeysProPU")
    private EntityManager em;
    private Query query;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstalacionFacade() {
        super(Instalacion.class);
    } 

    public List<SelectItem> getItems() {
        List<SelectItem> listaitems = new ArrayList<>();
        List<Instalacion> instalacionList = new ArrayList<>();
        try{
            query = em.createQuery("select i from Instalacion i");
            instalacionList = query.getResultList();
            for (Instalacion instalacion : instalacionList) {
                SelectItem selectitem = new SelectItem(instalacion.getCodinstalacion(), instalacion.getCodinstalacion().toString());
                listaitems.add(selectitem);
            }
            return listaitems;
        } catch (Exception e) {
            System.out.println("Error en el model InstalcionFacade.Getitems");
            e.printStackTrace();
        }
        return null;
    }
    

}
