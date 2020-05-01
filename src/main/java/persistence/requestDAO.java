package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class requestDAO {

    private final JdbcTemplate jdbcTemplate;

    public requestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_REQUEST = "insert into request (title, description, location, demand, user_mail) values (?, ?, ?, ?, ?)";
    private final String INSERT_CATEGORIES = "insert into request_category (title, description, location, demand, user_mail) values (?, ?, ?, ?, ?)";

    private final String FIND_USER = "select * from registered_user where mail = ?";
    private final String UPDATE_USERNAME = "update user set username = ?";
    private final String UPDATE_PASSWORD = "update user set password = ?";

}
