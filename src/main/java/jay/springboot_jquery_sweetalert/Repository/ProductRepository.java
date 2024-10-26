package jay.springboot_jquery_sweetalert.Repository;

import jay.springboot_jquery_sweetalert.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
