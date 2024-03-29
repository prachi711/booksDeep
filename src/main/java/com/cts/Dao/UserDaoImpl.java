package com.cts.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.cts.bean.Login;
import com.cts.bean.User;
public class UserDaoImpl implements UserDao {
  @Autowired
  DataSource dataSource;
  @Autowired
  JdbcTemplate jdbcTemplate;
 
  
  
  
  
  public void register(User user) {
    String sql = "insert into users values(?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getName(), user.getUsername(), user.getPassword(), 
     user.getDOB(), user.getAddress() });
    }
  
  
  
  
  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  }
  





class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setName(rs.getString("Name"));
    user.setUsername(rs.getString("Username"));
    user.setPassword(rs.getString("Password"));
    user.setDOB(rs.getString("DOB"));
    user.setAddress(rs.getString("Address"));
   
    return user;
  }
}
