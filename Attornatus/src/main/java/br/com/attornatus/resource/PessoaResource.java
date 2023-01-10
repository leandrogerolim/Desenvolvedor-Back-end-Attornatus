package br.com.attornatus.resource;
import br.com.attornatus.repository.PessoaRepository;
import br.com.attornatus.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping (value = "/Attornatus/pessoa")

public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public List<Pessoa> listarTodoasPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa listarPessoaId(@PathVariable(value = "id") long id) {
        return pessoaRepository.findById(id);
    }

    @PostMapping("/pessoa/")
    public Pessoa salvarNovaPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    public String deletaNovaPessoa(@PathVariable long id) {
        pessoaRepository.delete(listarPessoaId(id));
        return "Pessoa selecionada foi apagada com sucesso";

    }
    @PutMapping("/pessoa/{id}")
    public Pessoa editarPessoa(@RequestBody Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }
}




















