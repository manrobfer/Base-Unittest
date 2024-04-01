package br.com.unittests.unittest.daos;

import br.com.unittests.unittest.dto.ClerkDTO;
import br.com.unittests.unittest.model.Clerk;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClerkDao {

   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ClerkDao() throws ParseException {
    }

    public List<Clerk> getAll() {
        return clerks;
    };

    public Clerk findOneByName(String name){
        System.out.println("No teste passou no dao com o name " + name);
        Optional<Clerk> funcionario;
        funcionario = Optional.of(clerks.stream()
                .filter(func -> func.getName().equalsIgnoreCase(name))
                .findFirst()
                .get());

        return funcionario.get();
    }

    public List<Clerk> findAllByName(ClerkDTO dto) {
           List<Clerk> encontrados = clerks.stream()
                                    .filter(clerk -> clerk.getName().contains(dto.getName()))
                                    .collect(Collectors.toList());
           return encontrados;
    }

    private List<Clerk> clerks = Arrays.asList(
                        new Clerk(1,"TesteUm",25, new Date(),1200),
                        new Clerk(2,"TesteDois",15, new Date(),2000),
                        new Clerk(3,"TesteTres",21, new Date(),2100),
                        new Clerk(4,"TesteQuatro",26, new Date(),2200),
                        new Clerk(5,"TesteCinco",31, new Date(),3200),
                        new Clerk(6,"Manoel",31, new Date(),3200)

    );


    public Clerk findByName() {
          return clerks.stream().findFirst().get();
    }
}
