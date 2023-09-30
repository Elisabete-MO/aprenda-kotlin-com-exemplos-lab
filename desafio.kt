enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String) {
    override fun toString(): String {
    return nome
	}
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    companion object {
        private val conteudos = mutableListOf<ConteudoEducacional>()

        fun adicionarConteudo(conteudo: ConteudoEducacional) {
            conteudos.add(conteudo)
            println("Conteudo ${conteudo.nome} registrado com sucesso")
        }

        fun listarConteudos() {
            println("Conteudos registrados:")
            printAll(conteudos)
        }
    }    
}

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional>) {
        companion object {
        private val formacoes = mutableListOf<Formacao>()

        fun adicionarFormacao(formacao: Formacao) {
            formacoes.add(formacao)
            println("Formação ${formacao.nome} registrado com sucesso")
        }

        fun listarFormacoes() {
            println("Formações registradas:")
            printAll(formacoes)
        }
    }
}

data class Matricula(val aluno: Usuario) {
    companion object {
        private val inscritos = mutableListOf<Matricula>()

        fun matricular(matricula: Matricula) {
            inscritos.add(matricula)
            println("Aluno ${matricula.aluno.nome} matriculado com sucesso")
        }

        fun listarInscritos() {
            println("Alunos matriculados:")
            printAll(inscritos)
        }
    }
        override fun toString(): String {
        return aluno.nome
    }
}

fun <T> printAll(data: List<T>){
    for (e in data) {
        println(e)
    }
}

fun main() {
    
    val matricula1 = Matricula(Usuario("Renato"))
    Matricula.matricular(matricula1)

    val matricula2 = Matricula(Usuario("Vanessa"))
    Matricula.matricular(matricula2)

    Matricula.listarInscritos()
    
    val conteudo1 = ConteudoEducacional("Matemática I", 90)
    ConteudoEducacional.adicionarConteudo(conteudo1)
    
    val conteudo2 = ConteudoEducacional("História")
    ConteudoEducacional.adicionarConteudo(conteudo2)
    
    val conteudo3 = ConteudoEducacional("Matemática II", 90)
    ConteudoEducacional.adicionarConteudo(conteudo3)
    
    ConteudoEducacional.listarConteudos()

    val formacao = Formacao("Ensino Médio", Nivel.BASICO, mutableListOf(conteudo1, conteudo2, conteudo3))
    Formacao.adicionarFormacao(formacao)
    val formacao1 = Formacao("História", Nivel.DIFICIL, mutableListOf(conteudo2))
    Formacao.adicionarFormacao(formacao1)
    Formacao.listarFormacoes()

}
