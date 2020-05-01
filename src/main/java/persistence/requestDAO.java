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
    private final String INSERT_CATEGORY = "insert into request_category (request_id, request_mail, category_name) values (?, ?, ?)";
    private final String INACTIVE_REQUEST = "update request set active = '0'";


}
