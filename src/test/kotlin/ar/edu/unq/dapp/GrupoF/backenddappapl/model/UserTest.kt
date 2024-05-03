package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import ar.edu.unq.dapp.GrupoF.backenddappapl.model.enums.CryptoSymbol
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.enums.IntentType
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
    fun userWithCvuMercadoPago(){

        val user: UserBuilder = UserBuilder().builder()
        user.withCvuMP("0123456789012345678901")
        Assertions.assertEquals(user.cvuMercadoPago, "0123456789012345678901")

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

    @Test
    fun `test express buy intention` () {
        // Arrange
        val user = User() // Crear un usuario
        val crypto = CryptoAsset(name = CryptoSymbol.BTCUSDT, currentValue = 45000.0)
        val nominalQuantity = 1.5 // Cantidad nominal
        val nominalPrice = 45000.0 // Precio nominal
        val transactionType = IntentType.BUY // Tipo de transacción

        // Act
        val intent = user.expressIntent(crypto, nominalQuantity, nominalPrice, transactionType)

        // Assert
        assertNotNull(intent) // Asegurar que la intención no sea nula
        assertEquals(user, intent.user) // Asegurar que la intención esté asociada con el usuario correcto
        assertEquals(crypto, intent.asset) // Asegurar que el activo criptográfico sea el correcto
        assertEquals(nominalQuantity, intent.quantity) // Asegurar que la cantidad nominal sea la correcta
        assertEquals(nominalPrice, intent.price) // Asegurar que el precio nominal sea el correcto
        assertEquals(transactionType, intent.type) // Asegurar que el tipo de transacción sea el correcto
        assertNotNull(intent.date) // Asegurar que la fecha y hora de la intención no sea nula

    }
}
