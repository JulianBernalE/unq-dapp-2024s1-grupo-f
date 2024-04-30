package ar.edu.unq.dapp.GrupoF.backenddappapl.model

import java.time.LocalDateTime


class Operation {

    val id :Int? = null;
    val cryptoAsset :CryptoAsset? = null;


    val transactionType :TransactionType? = null;
    val transactionStatus :TransactionStatus? = null;

    val cryptoAmmount :Double? = null;
    val cryptoPriceOffer :Double? = null;
    val operationAmmount : Double? = null;

    val cryptoAddress :String? = null;
    val cvuMercadoPago :String? = null;

    val dateAndTime :LocalDateTime? = null;


}
