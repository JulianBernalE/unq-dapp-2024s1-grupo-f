package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import java.util.*

class BuyIntent {
    val id: Int? = null
    val cryptoAsset: CryptoAsset? = null
    val quantity: Double? = null //cantidad de crypto activo que se quiere comprar.
    val offer: Double? = null //cantidad ofrecida por 1 unidad del crypto activo que se quiere comprar.
    val operationAmmount: Double? = null //cantidad total de dinero que se gasto en la operacion
    val user: User? = null //usuario que publica la intencion de compra.
    val date: Date? = null
}