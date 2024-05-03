package ar.edu.unq.dapp.GrupoF.backenddappapl.model
import Intent
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.enums.TransactionType
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.regex.*

@Entity
@Table(name = "user_table")
open class User()  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long? = null
    @Column
    open var name: String? = null
    @Column
    open var lastName: String? = null
    @Column (unique = true)
    open var email: String? = null
    @Column
    open var address: String? = null
    @Column
    open var password: String? = null
    @Column
    open var cvuMercadoPago: String? = null
    @Column
    open var cryptoAddress: String? = null
    @Column
    open var point : Int = 0
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    val intents: MutableList<Intent> = mutableListOf()

    constructor(nameU: String, lastNameU: String, emailU: String,  addressU: String , passwordU: String, cvuMP: String, cryptoAddU : String): this(){
        this.name = nameU
        this.lastName = lastNameU
        this.email = emailU
        this.address = addressU
        this.password = passwordU
        this.cvuMercadoPago = cvuMP
        this.cryptoAddress = cryptoAddU

         require(name?.length in 3..30) { "El nombre debe tener entre 3 y 30 caracteres." }
         require(lastName?.length in 3..30) { "El apellido debe tener entre 3 y 30 caracteres." }
         require(isValidEmail(email)) { "El formato del email no es válido." }
         require(address?.length in 10..30) { "La dirección debe tener entre 10 y 30 caracteres." }
         require(isValidPassword(password)) { "La contraseña debe tener al menos 1 minúscula, 1 mayúscula, 1 carácter especial y tener una longitud mínima de 6 caracteres." }
         require(cvuMercadoPago?.length == 22) { "El CVU de MercadoPago debe tener 22 dígitos." }
         require(cryptoAddress?.length == 8) { "La dirección de la billetera de criptoactivos debe tener 8 dígitos." }
    }


    private fun isValidEmail(email: String?): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        val pattern = Pattern.compile(emailRegex)
        return pattern.matcher(email).matches()
    }

    private fun isValidPassword(password: String?): Boolean {
        //a-z contiene al menos 1 minuscula, A-Z al menos 1 mayuscula, !@#$%^&*()=+ caracteres especiales, \\S+\$ que no tenga espacios, {6,} al menos 6 chars
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^*()&+=])(?=\\S+\$).{6,}\$"
        val pattern = Pattern.compile(passwordRegex)
        return pattern.matcher(password).matches()
    }

    fun expressIntent(crypto: CryptoAsset, nominalQuantity: Double, nominalPrice: Double, transactionType: IntentType ): Intent{
        val intent = Intent (
                user = this,
                type = transactionType,
                asset = crypto,
                price = nominalPrice,
                quantity = nominalQuantity,
                date = LocalDateTime.now(),
        )
        this.intents.add(intent)
        return intent
    }



}