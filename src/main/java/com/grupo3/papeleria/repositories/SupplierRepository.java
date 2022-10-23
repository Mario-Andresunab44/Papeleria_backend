package Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.papeleriamibarrio.backend.Entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    
    public Optional<Supplier> findByName(String name);
    public static boolean existsByName(String name) {
        return false;
    }
}
