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
public class RutaFacade extends AbstractFacade<Ruta> {
    @PersistenceContext(unitName = "JSFAutomaticoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutaFacade() {
        super(Ruta.class);
    }
    
}
