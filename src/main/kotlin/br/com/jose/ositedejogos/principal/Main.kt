package br.com.jose.ositedejogos.principal

import br.com.jose.ositedejogos.modelo.Jogo
import br.com.jose.ositedejogos.servicos.ConsumoApi
import java.util.*

fun main() {
    val teclado = Scanner(System.`in`)
    println("Informe o valor do ID a ser buscado:")
    val idValue = teclado.nextLine()


    var meuJogo: Jogo? = null
    val resultado = runCatching {
        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(idValue)
        meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo não encontrado!")
    }
    resultado.onSuccess {
        println("Você gostaria de adicionar uma descrição ao jogo? S/N")
        val opcao = teclado.nextLine()

        if(opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = teclado.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }
}