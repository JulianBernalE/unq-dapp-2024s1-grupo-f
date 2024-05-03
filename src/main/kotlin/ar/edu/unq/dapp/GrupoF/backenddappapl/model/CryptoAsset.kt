package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import ar.edu.unq.dapp.GrupoF.backenddappapl.model.enums.CryptoSymbol
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cryptoassets")
class CryptoAsset (
    @Id
    val name: CryptoSymbol? = null,
    val currentValue: Double? = null

)