package ar.edu.unq.dapp.GrupoF.backenddappapl.webservice

import ar.edu.unq.dapp.GrupoF.backenddappapl.dto.UserDTO
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import ar.edu.unq.dapp.GrupoF.backenddappapl.request.UserRequest
import ar.edu.unq.dapp.GrupoF.backenddappapl.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@RestController
class UserController {

    @Autowired
    lateinit var service : UserService

    @GetMapping("/greeting")
    fun greeting(@RequestParam(name = "name", required = false, defaultValue = "World") name: String?, model: Model): String? {
        model.addAttribute("name", name)
        return "greeting"
    }

    @GetMapping("/")
    fun holaMundo(): String{
        return "Hola Mundo"
    }

    @PostMapping("/register")
    fun saveUser(@RequestBody userRequest : UserRequest) : ResponseEntity<UserDTO> {
        val user = User(userRequest.name,userRequest.lastName,userRequest.email,userRequest.address,userRequest.password,userRequest.cvuMercadoPago,userRequest.cryptoAddress)
        service.createUser(user)
        val userDTO = UserDTO(user.name!!,user.point)
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

}