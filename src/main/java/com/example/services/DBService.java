package com.example.services;

import com.example.domains.Veiculo;
import com.example.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void initDB(){
        Veiculo veiculo1 = new Veiculo(null, "Astra", LocalDate.now(),35000.00,"Richard", "785.568.174-89");
        Veiculo veiculo2 = new Veiculo(null, "Gol", LocalDate.now(),45000.00,"Joice", "564.457.789-89");
        Veiculo veiculo3 = new Veiculo(null, "EcoSport", LocalDate.now(),55000.00,"Marcela", "757.582.742-89");

        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);
        veiculoRepository.save(veiculo3);
    }
}