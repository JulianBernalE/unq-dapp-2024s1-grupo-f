package ar.edu.unq.dapp.GrupoF.backenddappapl.model

class UserBuilder : User() {

    fun withName(nameU:String):User{

        this.name = nameU
        return this
    }

    fun withLastName(lastNameU: String): User{

        this.lastName = lastNameU
        return this
    }

    fun withEmail(emailU: String): User{
        this.email = emailU
        return this
    }

    fun withPassword(passwordU: String): User{

        this.password = passwordU
        return this
    }

    fun withAddress(addressU: String): User{

        this.address = addressU
        return this
    }

    fun withCvuMP(cvu: String): User{

        this.cvuMercadoPago = cvu
        return this
    }

    fun builder(): UserBuilder{
        return UserBuilder()
    }
}