package pe.net.tci.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.net.tci.test.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findFirst3ByOrderByCreateDateDesc();
}
