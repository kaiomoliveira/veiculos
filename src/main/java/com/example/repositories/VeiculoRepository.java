package com.example.repositories;

import com.example.domains.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByCpfPropietario(String cpfPropietario);
    Optional<Veiculo> findByNomePropietario(String nomePropietario);
}