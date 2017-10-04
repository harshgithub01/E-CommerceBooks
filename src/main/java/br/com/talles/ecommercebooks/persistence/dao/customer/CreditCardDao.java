package br.com.talles.ecommercebooks.persistence.dao.customer;

import br.com.talles.ecommercebooks.domain.Entity;
import br.com.talles.ecommercebooks.domain.customer.CreditCard;
import br.com.talles.ecommercebooks.domain.customer.Customer;
import br.com.talles.ecommercebooks.persistence.dao.AbstractDao;
import br.com.talles.ecommercebooks.persistence.dao.IDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreditCardDao extends AbstractDao {

	@Override
	public List<Entity> select(boolean enabled) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean save(Entity entity) {
		CreditCard creditCard = (CreditCard) entity;
		String sql = "INSERT INTO CreditCards (enabled, number, printedName, securityCode, expirationDate, id_cardCompany, id_customer)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

		// Find the last book register to get its id
		IDao custumerDao = new CustomerDao();
		Customer lastCustomer = (Customer) custumerDao.findLast();
		
		try {
			openConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setBoolean(1, creditCard.isEnabled());
			statement.setString(2, creditCard.getNumber());
			statement.setString(3, creditCard.getPrintedName());
			statement.setString(4, creditCard.getSecurityCode());
			statement.setDate(5, new java.sql.Date(creditCard.getExpirationDate().getTime()));
			
			statement.setLong(6, creditCard.getCardCompany().getId());
			statement.setLong(7, lastCustomer.getId());
						
			statement.execute();
			statement.close();

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(CreditCardDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			closeConnection();
		}
	}

	@Override
	public boolean delete(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Entity find(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean update(Entity entity, String operation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Entity findLast() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
