package br.com.jose.ositedejogos.modelo

import kotlin.random.Random

data class User(var nome: String, var email: String) {
    private var dataNascimento: String? = null
    private var nickName: String? = null
        set(value) {
            field = value
            if(userID.isNullOrBlank())
                criarIdInterno()
        }
    var userID: String? = null
        private set
    constructor(nome: String, email: String, dataNascimento: String, nickName: String): this(nome, email) {
        this.nickName = nickName
        this.dataNascimento = dataNascimento
        criarIdInterno()
    }

    init {
        if(nome.isNullOrBlank())
            throw java.lang.IllegalArgumentException("Nome está em branco")
        this.email = validarEmail()
    }

    fun criarIdInterno() {
        val numRand = Random.nextInt(10000)
        val tag = String.format("%04d", numRand)
        userID = "$nome#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }

    }

    override fun toString(): String {
        return "User(nome='$nome', email='$email', dataNascimento=$dataNascimento, nickName=$nickName, userID=$userID)"
    }


}
