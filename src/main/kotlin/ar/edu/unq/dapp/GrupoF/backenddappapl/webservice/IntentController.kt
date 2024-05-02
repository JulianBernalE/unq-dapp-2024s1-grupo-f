package ar.edu.unq.dapp.GrupoF.backenddappapl.webservice

import Intent
import ar.edu.unq.dapp.GrupoF.backenddappapl.repository.IntentRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/intents")
class IntentController(private val intentRepository: IntentRepository) {

    @PostMapping
    fun createIntent(@RequestBody intent: Intent): ResponseEntity<Intent> {
        val createdIntent = intentRepository.save(intent)
        return ResponseEntity.created(URI.create("/intents/${createdIntent.id}")).body(createdIntent)
    }

    @GetMapping("/{id}")
    fun getIntent(@PathVariable id: Long): ResponseEntity<Intent> {
        val intent = intentRepository.findById(id)
        return if (intent.isPresent) {
            ResponseEntity.ok(intent.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}