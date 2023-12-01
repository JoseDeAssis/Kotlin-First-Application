package br.com.jose.ositedejogos.modelo

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return "Jogo(info=$info)"
    }
}
