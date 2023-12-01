package br.com.jose.ositedejogos.modelo

class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = null
    override fun toString(): String {
        return "Meu jogo:\n" +
                "titulo: $titulo,\n" +
                "capa: $capa,\n" +
                "descricao: $descricao"
    }

}