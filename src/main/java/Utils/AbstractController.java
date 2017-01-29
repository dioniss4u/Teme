package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * Created by dioni on 1/25/2017.
 */
public abstract class AbstractController {
    public static Logger logger = LoggerFactory.getLogger(AbstractController.class);
    public static Connection conn = (Connection) DBConnection.getConnection();

}