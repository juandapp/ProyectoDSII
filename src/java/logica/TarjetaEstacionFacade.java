/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JUANPAULO
 */
@Stateless
public class TarjetaEstacionFacade extends AbstractFacade<TarjetaEstacion> {
    @PersistenceContext(unitName = "JSFAutomaticoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetaEstacionFacade() {
        super(TarjetaEstacion.class);
    }
    
}
