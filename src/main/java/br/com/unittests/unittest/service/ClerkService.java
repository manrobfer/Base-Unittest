package br.com.unittests.unittest.service;

import br.com.unittests.unittest.daos.ClerkDao;
import br.com.unittests.unittest.dto.ClerkDTO;
import br.com.unittests.unittest.exceptions.ServiceException;
import br.com.unittests.unittest.model.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class ClerkService {
    @Autowired
    ClerkDao clerkDao;

    public List<Clerk> getAll(){
        return clerkDao.getAll();
    }

    public Clerk getByNome(String nome) {
        try {
            notNull(nome, "Nome é obrigatório");
            return clerkDao.findOneByName(nome);
        } catch (Exception e) {
            throw new ServiceException(String.format("Possível erro de digitação ao localizar nome %s ", nome));
        }
      }
      public List<Clerk> getAllByName(ClerkDTO dto){
            return clerkDao.findAllByName(dto);
     }

    public Clerk findByName() {
        return clerkDao.findByName();
    }
}