/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "pruebaSeysProPU")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public List<SelectItem> getItems(){
        List<SelectItem> lista = new ArrayList<>();
        List<Pedido> pedidoList = new ArrayList<>();
        try{
            query = em.createQuery("select h from Pedido h");
            pedidoList=query.getResultList();
            for (Pedido pedido : pedidoList) {
                SelectItem selectitem = new SelectItem(pedido.getCodpedido(), pedido.getCodpedido().toString());
                lista.add(selectitem);
            }
            return lista;
        }catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }
    
}
