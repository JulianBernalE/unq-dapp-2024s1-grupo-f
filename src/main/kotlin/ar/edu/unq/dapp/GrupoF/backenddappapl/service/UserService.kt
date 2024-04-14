package ar.edu.unq.dapp.GrupoF.backenddappapl.service

import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import ar.edu.unq.dapp.GrupoF.backenddappapl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var repo : UserRepository

    fun createUser(user : User) : User {
        repo.save(user)
        return user
    }
    fun allUsers(): List<User>{
        return repo.findAll()
    }
}