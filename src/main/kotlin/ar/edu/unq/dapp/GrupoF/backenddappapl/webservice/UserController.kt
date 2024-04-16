package ar.edu.unq.dapp.GrupoF.backenddappapl.webservice

import ar.edu.unq.dapp.GrupoF.backenddappapl.dto.UserDTO
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import ar.edu.unq.dapp.GrupoF.backenddappapl.request.UserRequest
import ar.edu.unq.dapp.GrupoF.backenddappapl.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class UserController {

    @Autowired
    lateinit var service : UserService

    @PostMapping("/register")
    fun saveUser(@RequestBody userRequest : UserRequest) : ResponseEntity<UserDTO> {
        val user = User(userRequest.name,userRequest.lastName,userRequest.email,userRequest.address,userRequest.password,userRequest.cvuMercadoPago,userRequest.cryptoAddress)
        service.createUser(user)
        val userDTO = UserDTO(user.name!!,user.point)
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

    @GetMapping("/users")
    fun getUsers() : List<User>{
        return service.allUsers()
    }

}