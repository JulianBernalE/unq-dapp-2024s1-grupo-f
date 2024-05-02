package ar.edu.unq.dapp.GrupoF.backenddappapl.repository

import Intent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IntentRepository : JpaRepository<Intent, Long>