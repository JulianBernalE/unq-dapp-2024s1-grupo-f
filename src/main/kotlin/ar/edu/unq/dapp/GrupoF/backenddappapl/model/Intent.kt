import ar.edu.unq.dapp.GrupoF.backenddappapl.model.CryptoAsset
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.IntentType
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.enums.TransactionStatus
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Intent(

    @ManyToOne
    val user: User,

    val type: IntentType,

    @Enumerated(EnumType.STRING)
    val asset: CryptoAsset,

    val price: Double,

    val quantity: Double,



    val date: LocalDateTime,
)
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}