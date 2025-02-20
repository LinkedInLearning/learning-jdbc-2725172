package com.loogibot.lil.data.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import javax.xml.crypto.Data;

import com.loogibot.lil.data.entity.Service;
import com.loogibot.lil.data.util.DatabaseUtils;

public class ServiceDao implements Dao<Service, UUID>  {
  private static final Logger LOGGER = Logger.getLogger(ServiceDao.class.getName());
  private static final String GET_ALL = "select service_id, name, price from wisdom.services";

  @Override
  public List<Service> getAll() {
    // TODO Auto-generated method stub
    List<Service> services = new ArrayList<>();
    Connection connection = DatabaseUtils.getConnection();
    
    try(Statement statement = connection.createStatement()){
      // make sure its not beans.Statement, use sql.Statement
      ResultSet rs = statement.executeQuery(GET_ALL);
      services = this.processResultSet(rs);
    } catch (SQLException e) {
      // TODO: handle exception
      DatabaseUtils.handleSqlException("ServiceDao.getAll", e, LOGGER);
    }
    return services;
  }

  @Override
  public Service create(Service entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public Optional<Service> getOne(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
  }

  @Override
  public Service update(Service entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  private List<Service> processResultSet(ResultSet rs) throws SQLException{
    List<Service> services = new ArrayList<>();
    while(rs.next()){
      Service service = new Service();
      service.setServiceId((UUID)rs.getObject("service_id"));
      service.setName(rs.getString("name"));
      service.setPrice(rs.getBigDecimal("price"));
      services.add(service);
    }
    return services;
  }

}
