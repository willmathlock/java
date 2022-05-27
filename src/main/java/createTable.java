import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class createTable {
    public static void main (String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Client-PU");

        entityManagerFactory.close();
    }
}
