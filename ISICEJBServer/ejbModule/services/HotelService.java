package services;

import java.util.List;

import dao.hotel.IDaoRemote;
import dao.hotel.IDaoLocale;
import entities.Hotel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless(name = "nada")
public class HotelService implements IDaoRemote<Hotel>, IDaoLocale<Hotel>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Hotel create(Hotel o) {
		em.persist(o);
		return o;
	}

	@Override
	public boolean delete(Hotel o) {
		em.remove(em.contains(o) ? o : em.merge(o));
		return true;
	}
	@Override
	public Hotel update(Hotel o) {
	
		  return em.merge(o);
	}

	@Override
	public Hotel findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> findAll() {
		Query query = em.createQuery("select v from Hotel v");
		return query.getResultList();
	}

}
