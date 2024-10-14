package persistence.sql.ddl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryGeneratorTest {
    @Test
    void create() {
        final QueryGenerator queryGenerator = new QueryGenerator();
        assertEquals(expected(), queryGenerator.create(Person.class));
    }

    @Test
    void drop() {
        final QueryGenerator queryGenerator = new QueryGenerator();
        assertEquals("DROP TABLE IF EXISTS USERS CASCADE;", queryGenerator.drop(Person.class));
    }

    private String expected() {
        return """
                CREATE TABLE USERS (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nick_name VARCHAR(255),
                    old INTEGER,
                    email VARCHAR(255) NOT NULL);""";
    }
}
