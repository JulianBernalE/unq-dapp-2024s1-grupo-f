package ar.edu.unq.dapp.GrupoF.backenddappapl.repository

import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository {

    fun registrar();

}