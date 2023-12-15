package pe.net.tci.test.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.net.tci.test.entities.Empresa;
import pe.net.tci.test.repositories.EmpresaRepository;

@RestController
@RequestMapping("empresas")
@AllArgsConstructor
public class EmpresaController {
    EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> list() {
        // O si prefiere:
        // PageRequest pageRequest = PageRequest.of(0, 3,
        // TypedSort.sort(Empresa.class).by(Empresa::getCreateDate).descending());
        // return empresaRepository.findAll(pageRequest).getContent();

        return empresaRepository.findFirst3ByOrderByCreateDateDesc();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa register(@RequestBody @Valid Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
