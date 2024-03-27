package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class UserTest{

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
        // Arrange
        val name = "Juan"
        val lastName = "Perez"
        val email = "juan.perez@gmail.com"
        val address = "avenida siempre viva 123"
        val password = "VerySrongPassword123!"
        val cvuMercadoPago = "0123456789012345678901"
        val cryptoAddress = "12345678"

        val user = User(name, lastName, email, address, password, cvuMercadoPago, cryptoAddress)

        // Act & Assert
        assertAll("User attributes",
            { assertEquals(name, user.name) },
            { assertEquals(lastName, user.lastName) },
            { assertEquals(email, user.email) },
            { assertEquals(address, user.address) },
            { assertEquals(password, user.password) },
            { assertEquals(cvuMercadoPago, user.cvuMercadoPago) },
            { assertEquals(cryptoAddress, user.cryptoAddress) }
        )
    }
}