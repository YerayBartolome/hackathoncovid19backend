package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class chatDAO {

    private final JdbcTemplate jdbcTemplate;

    public chatDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String START_CHAT = "insert into chat (user_mail, user_mail1, request_ID, request_user_mail) values (?, ?, ?, ?)";
    private final String INSERT_MESSAGE = "insert into message (content, chat_user_mail, chat_user_mail1) values (?, ?, ?)";


}
