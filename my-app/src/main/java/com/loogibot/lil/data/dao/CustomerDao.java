package com.loogibot.lil.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import com.loogibot.lil.data.entity.Customer;
import com.loogibot.lil.data.util.DatabaseUtils;

public class CustomerDao implements Dao<Customer, UUID> {

  private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
  private static final String GET_ALL = "select customer_id, name wisdom.services";
  private static final String GET_BY_ID = "select customer_id, name from wisdom.services where customer_id = ?";
  private static final String CREATE = "insert into wisdom.services (customer_id, name) values (?,?)";
  private static final String UPDATE = "update wisdom.services set name = ?, where customer_id = ?";
  private static final String DELETE = "delete from wisdom.services where customer_id = ?";

  @Override
  public List<Customer> getAll() {
    List<Customer> customers = new ArrayList<>();
    Connection connection = DatabaseUtils.getConnection();
    try (Statement statement = connection.createStatement()) {
      ResultSet rs = statement.executeQuery(GET_ALL);
      customers = this.processResultSet(rs);
    } catch (SQLException e) {
      DatabaseUtils.handleSqlException("CustomerDao.getAll", e, LOGGER);
    }
    return customers;
  }

  @Override
  public Customer create(Customer entity) {
    UUID customerId = UUID.randomUUID();
    Connection connection = DatabaseUtils.getConnection();
    try {
      connection.setAutoCommit(false);
      PreparedStatement statement = connection.prepareStatement(CREATE);
      statement.setObject(1, customerId);
      statement.setString(2, entity.getFirst_name());
      statement.setString(3, entity.getLast_name());
      statement.setString(4, entity.getEmail());
      statement.setString(5, entity.getPhone());
      statement.execute();
      connection.commit();
      statement.close();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException sqle) {
        DatabaseUtils.handleSqlException("CustomerDao.create.rollback", sqle, LOGGER);
      }
      DatabaseUtils.handleSqlException("CustomerDao.create", e, LOGGER);
    }
    Optional<Customer> customer = this.getOne(customerId);
    if (!customer.isPresent()) {
      return null;
    }
    return customer.get();
  }

  @Override
  public Optional<Customer> getOne(UUID id) {
    try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(GET_BY_ID)) {
      statement.setObject(1, id);
      ResultSet rs = statement.executeQuery();
      List<Customer> customers = this.processResultSet(rs);
      if (customers.isEmpty()) {
        return Optional.empty();
      }
      return Optional.of(customers.get(0));
    } catch (SQLException e) {
      // TODO: handle exception
      DatabaseUtils.handleSqlException("CustomerDao.getOne", e, LOGGER);
    }
    return Optional.empty();
  }

  @Override
  public Customer update(Customer entity) {
    Connection connection = DatabaseUtils.getConnection();
    try {
      connection.setAutoCommit(false);
      PreparedStatement statement = connection.prepareStatement(UPDATE);
      statement.setObject(1, entity.getCustomerId());
      statement.setString(2, entity.getFirst_name());
      statement.setString(3, entity.getLast_name());
      statement.setString(4, entity.getEmail());
      statement.setString(5, entity.getPhone());
      statement.execute();
      connection.commit();
      statement.close();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException sqle) {
        DatabaseUtils.handleSqlException("CustomerDao.update.rollback", sqle, LOGGER);
      }
      DatabaseUtils.handleSqlException("CustomerDao.update", e, LOGGER);
    }
    return this.getOne(entity.getCustomerId()).get();
  }

  @Override
  public void delete(UUID id) {
    Connection connection = DatabaseUtils.getConnection();

    try {
      connection.setAutoCommit(false);
      PreparedStatement statement = connection.prepareStatement(DELETE);
      statement.setObject(1, id);
      statement.execute();
      connection.commit();
      statement.close();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException sqle) {
        DatabaseUtils.handleSqlException("CustomerDao.delete.rollback", sqle, LOGGER);
      }
      DatabaseUtils.handleSqlException("CustomerDao.delete", e, LOGGER);
    }
  }

    private List<Customer> processResultSet(ResultSet rs) throws SQLException {
    List<Customer> customers = new ArrayList<>();
    while (rs.next()) {
      Customer customer = new Customer();
      customer.setCustomerId((UUID) rs.getObject("service_id"));
      customer.setFirst_name(rs.getString("first_name"));
      customer.setLast_name(rs.getString("last_name"));
      customer.setEmail(rs.getString("email"));
      customer.setPhone(rs.getString("phone"));
      customers.add(customer);
    }
    return customers;
  }
}
