/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Produccion;
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
public class ProduccionFacade extends AbstractFacade<Produccion> {

    @PersistenceContext(unitName = "pruebaSeysProPU")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduccionFacade() {
        super(Produccion.class);
    }
    public List<SelectItem> getItems(){
        List<SelectItem> listaitems = new ArrayList<>();
        List<Produccion> produccionList = new ArrayList<>();
        try{
            query=em.createQuery("select i from Produccion i");
            produccionList = query.getResultList();
            for (Produccion produccion : produccionList) {
                SelectItem selectitem = new SelectItem(produccion.getCodproduccion(), produccion.getCodproduccion().toString());
                listaitems.add(selectitem);
            }
            return listaitems;
        }catch(Exception e){
            System.out.println("Error en el modelo Produccion.Getitems");
            e.printStackTrace();
        }
        return null;
    }
    
}
