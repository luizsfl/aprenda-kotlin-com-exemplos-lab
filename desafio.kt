// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL}
enum class Categoria {CURSO, Live, DESAFIOPROJETO, DESAFIOCURSO}

data class Usuario(val name:String,val codigo:String)

data class Topicos(val nome:String,val conteudos: List<ConteudoEducacional>){
    fun nivelConteudo(categoria: Categoria):List<ConteudoEducacional>{
        return this.conteudos.filter { it.categoria == categoria}
    }
}
data class ConteudoEducacional(val nome: String, val duracao: Int = 60,val nivel: Nivel,val categoria: Categoria)

data class Formacao(val nome: String, val topicos: List<Topicos>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { usuario->
            inscritos.add(usuario)
        }
    }

    fun imprimeTopicos(){
        this.topicos.forEachIndexed { index, topico ->
            println("Topico ${index+1} : ${topico.nome}    ${topico.conteudos.size} atividades ")
        }
    }

    fun imprimeGrade(){
        this.topicos.forEachIndexed { index, topico ->
            println("Topico ${index+1} : ${topico.nome}")

            topico.conteudos.forEach{ conteudo->
                println("   --> ${conteudo.nome}")
            }
        }
    }
    fun nivelTopico(categoria: Categoria):List<ConteudoEducacional>{
        val conteudoNivel = mutableListOf<ConteudoEducacional>()

        this.topicos.forEach{
            conteudoNivel.addAll(it.nivelConteudo(categoria))
        }
        return conteudoNivel
    }
}

fun main() {

    val listTopicos = criaTopicos()

    val formacaoSantanderKotlin = Formacao(nome="Santander Bootcamp 2023 -  Mobile Android com Kotlin",topicos=listTopicos)
    val usuario1 = Usuario("Pedro","1")
    val usuario2 = Usuario("Carlos","2")
    formacaoSantanderKotlin.matricular(usuario1,usuario2)

    println("Formação: ${formacaoSantanderKotlin.nome}")
    println("Quantidade de inscritos: ${formacaoSantanderKotlin.inscritos.size}")
    println("Curso: ${formacaoSantanderKotlin.nivelTopico(Categoria.CURSO).size}")
    println("Desafio de projeto: ${formacaoSantanderKotlin.nivelTopico(Categoria.DESAFIOPROJETO).size}")
    println("Desafio de código: ${formacaoSantanderKotlin.nivelTopico(Categoria.DESAFIOCURSO).size}")
    println("Live: ${formacaoSantanderKotlin.nivelTopico(Categoria.Live).size}")
    println("\nTopicos do curso:")
    formacaoSantanderKotlin.imprimeTopicos()
    println("\nMatérias do curso:")
    formacaoSantanderKotlin.imprimeGrade()
}

private fun criaTopicos():List<Topicos>{
    val listTopicos = mutableListOf<Topicos>()

    listTopicos.add(criaOmborard( nome="Prepare-se para a jornada (Onborardin)"))
    listTopicos.add(princDesenvSoft( nome="Princípios de Desenvolvimento de Software"))
    listTopicos.add(conhecendLingKotlin( nome="Conhecendo a linguagem de programação kotlin"))
    listTopicos.add(primDesafio( nome="Resolvendo seus primeiros desafios de código"))
    listTopicos.add(introDevKotlin( nome="Introdução ao desenvolvimento movile com kotlin"))
    listTopicos.add(praticAbstra( nome="Praticando suas abstrações no dominio bancario"))
    listTopicos.add(ganhaPrdoJatpack( nome="Ganhando produtividade com Android jatpack"))

    return listTopicos
}
private fun criaOmborard(nome: String) :Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Bootcamps DIO: Educação Gratuita e Empregabilidade Juntas!", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Aula inaugural - Santander BootCamps 2023", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.Live))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}

private fun ganhaPrdoJatpack(nome: String) :Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Visão Geral Sobre o Android Jetpack", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Explorando Componentes do Material Design em Apps Android", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Gerenciando o Fluxo de Navegação de Apps Android", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Ciclo de Vida Android ViewModel, LiveData e Coroutines", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Simplificando a Persistência de Dados no Android com Room", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Programação em Segundo Plano no Android com WorkManager", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Injeção de Dependências no Android com Hilt", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Interfaces de Usuário Dinâmicas no Android com Jetpack Compose", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Explore o Android Jetpack Para Não Perder Nenhum Jogo do Brasil na Copa", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.DESAFIOPROJETO))
    listaConteudo.add(ConteudoEducacional(nome="Avalie este Bootcamp", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}


private fun praticAbstra(nome: String) :Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Abrindo Contas", nivel = Nivel.DIFICIL, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Herança Bancária", nivel = Nivel.DIFICIL, duracao = 120, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Cofres Seguros", nivel = Nivel.DIFICIL, duracao = 120, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Reunião de Acionistas", nivel = Nivel.DIFICIL, duracao = 120, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: A Última Transação", nivel = Nivel.DIFICIL, duracao = 120, categoria = Categoria.DESAFIOCURSO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}

private fun princDesenvSoft(nome:String):Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Organizando seus Estudos com os Roadmaps DIO e o Notion", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Versionamento de Código com Git e GitHub", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios de Projetos: Crie Um Portfólio Vencedor", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Contribuindo em um Projeto Open Source no GitHub", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOPROJETO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}

private fun primDesafio(nome:String):Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Desafios de Código: Aperfeiçoe Sua Lógica e Pensamento Computacional", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Equilibrando Saldo", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Organizando Seus Ativos", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Condicionalmente Rico", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: Juros Compostos", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOCURSO))
    listaConteudo.add(ConteudoEducacional(nome="Desafios Kotlin: O Grande Depósito", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOCURSO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}

private fun conhecendLingKotlin(nome:String):Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Conhecendo o Kotlin e Sua Documentação Oficial", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Introdução Prática à Linguagem de Programação Kotlin", nivel = Nivel.BASICO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Estruturas de Controle de Fluxo e Coleções em Kotlin", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Orientação a Objetos e Tipos de Classes na Prática com Kotlin", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="O Poder das Funções em Kotlin", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Tratamento de Exceções em Kotlin", nivel = Nivel.BASICO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", nivel = Nivel.BASICO, categoria = Categoria.DESAFIOPROJETO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}

private fun introDevKotlin(nome: String) :Topicos{
    val listaConteudo = mutableListOf<ConteudoEducacional>()
    listaConteudo.add(ConteudoEducacional(nome="Visão Geral do Mercado de Desenvolvimento Mobile", nivel = Nivel.INTERMEDIARIO, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Instalando e Configurando o Android Studio", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Entendendo a Estrutura e Depurando Apps Android", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Criando um App Android com Suporte a Vários Idiomas", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.DESAFIOPROJETO))
    listaConteudo.add(ConteudoEducacional(nome="Princípios de Interface de Usuário e Layouts Android", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Manipulando Entradas do Usuário em Apps Android", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Fundamentos de Multiscreen em Apps Android", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Noções Básicas de Rede em Apps Android com Kotlin", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Armazenamento de Dados Essencial em Apps Android com Kotlin", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.CURSO))
    listaConteudo.add(ConteudoEducacional(nome="Criando um App Android para Compartilhar seu Portfólio de Projetos", nivel = Nivel.INTERMEDIARIO, duracao = 120, categoria = Categoria.DESAFIOPROJETO))

    val topico = Topicos(nome=nome,listaConteudo)

    return topico
}
