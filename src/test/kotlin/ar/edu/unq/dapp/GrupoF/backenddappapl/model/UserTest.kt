package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class UserTest{

    @Test
    fun userWithName(){
        val user: UserBuilder = UserBuilder().builder()
        user.withName("Juan")
        Assertions.assertEquals(user.name, "Juan")

    }
    @Test
    fun userWithLastName(){
        val user: UserBuilder = UserBuilder().builder()
        user.withLastName("Perez")
        Assertions.assertEquals(user.lastName, "Perez")
    }

    @Test
    fun userWithEmailAndPassword(){

        val user: UserBuilder = UserBuilder().builder()
        user.withEmail("juan.perez@gmail.com")
        user.withPassword("VerySrongPassword123!")

        Assertions.assertEquals(user.email, "juan.perez@gmail.com")
        Assertions.assertEquals(user.password, "VerySrongPassword123!")

    }

    @Test
    fun userWithDirection(){

        val user: UserBuilder = UserBuilder().builder()
        user.withAddress("avenida siempre viva 123")
        Assertions.assertEquals(user.address, "avenida siempre viva 123")

    }


    @Test
    fun `test incorrect email`() {
        // Arrange
        val name = "Juan"
        val lastName = "Perez"
        val email = "juan.perez.com" // Incorrect email format
        val address = "avenida siempre viva 123"
        val password = "Password123!"
        val cvuMercadoPago = "0123456789012345678901"
        val cryptoAddress = "12345678"

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            User(name, lastName, email, address, password, cvuMercadoPago, cryptoAddress)
        }
    }

    @Test
    fun `test incorrect password`() {
        // Arrange
        val name = "Juan"
        val lastName = "Perez"
        val email = "juan.perez@gmail.com" // Incorrect email format
        val address = "avenida siempre viva 123"
        val password = "passwordincorrecta"
        val cvuMercadoPago = "0123456789012345678901"
        val cryptoAddress = "12345678"

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            User(name, lastName, email, address, password, cvuMercadoPago, cryptoAddress)
        }
    }

    @Test
    fun `test correct user creation`() {

        val user = User("Juan", "Perez", "juan.perez@gmail.com", "avenida siempre viva 123", "VerySrongPassword123!", "0123456789012345678901", "12345678")

        // Act & Assert
        assertAll("User attributes",
            { assertEquals("Juan", user.name) },
            { assertEquals("Perez", user.lastName) },
            { assertEquals("juan.perez@gmail.com", user.email) },
            { assertEquals("avenida siempre viva 123", user.address) },
            { assertEquals("VerySrongPassword123!", user.password) },
            { assertEquals("0123456789012345678901", user.cvuMercadoPago) },
            { assertEquals("12345678", user.cryptoAddress) }
        )
    }
}