import ar.edu.unq.dapp.GrupoF.backenddappapl.model.CryptoAsset
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.IntentType
import ar.edu.unq.dapp.GrupoF.backenddappapl.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.regex.*

@Entity
data class Intent(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val user: User,

    val type: IntentType,

    @Enumerated(EnumType.STRING)
    val asset: CryptoAsset,

    val price: Double,
    val quantity: Double,

    val date: LocalDateTime,
)