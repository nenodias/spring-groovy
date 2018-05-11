
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

RowMapper callback = [
    mapRow: { ResultSet rs, int rowNum ->
        return ['id' : rs.getInt('id'), 'name' : rs.getString('name'), 'email' : rs.getString('email')]
    }
] as RowMapper
lista = jdbc.query('SELECT * FROM users', callback)