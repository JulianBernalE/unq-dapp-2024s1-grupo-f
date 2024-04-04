package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import java.util.*

class SellIntent {
    val id: Int? = null
    val cryptoAsset: CryptoAsset? = null
    val quantity: Double? = null //cantidad de crypto activo que se quiere vender.
    val offer: Double? = null //cantidad demandada por 1 unidad del crypto activo que se quiere vender.
    val operationAmmount: Double? = null //cantidad total de dinero que se obtuvo en la operacion
    val user: User? = null //usuario que publica la intencion de venta.
    val date: Date? = null
}