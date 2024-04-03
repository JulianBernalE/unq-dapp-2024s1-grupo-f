package ar.edu.unq.dapp.GrupoF.backenddappapl.repository

import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User,Long>{

}