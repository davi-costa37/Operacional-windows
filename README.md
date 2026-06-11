🛠️ Process Killer & Manager (Java)
Um controlador em Java multiplataforma desenvolvido para gerenciar processos do sistema operacional. 
Ele identifica automaticamente se o ambiente é Windows ou Linux/macOS e adapta os comandos nativos para listar ou encerrar processos de forma forçada.

Métodos Disponíveis
private String os(): Detecta o S.O. em execução através da propriedade os.name.

public void listaProcessos(): Captura e exibe no console todos os processos que estão rodando na máquina em tempo real.

public void mataPid(String pid): Encerra um processo específico utilizando o seu número de identificação (PID).

public void mataNome(String nome): Encerra um ou mais processos localizados pelo nome do executável (ex: notepad.exe ou firefox).

🛠️ Requisitos e Tecnologias
Linguagem: Java (JDK 8 ou superior)

APIs Utilizadas: java.io e java.lang.Process (nativas do ecossistema Java).

Compatibilidade: Windows e distribuições baseadas em Unix (Linux/macOS).

COMO USAR:
import controller.KillController;

public class Main {
    public static void main(String[] args) {
        KillController gerenciador = new KillController();

        // 1. Listar todos os processos da máquina
        gerenciador.listaProcessos();

        // 2. Encerrar um processo pelo PID (exemplo: PID 1234)
        gerenciador.mataPid("1234");

        // 3. Encerrar um processo pelo nome
        gerenciador.mataNome("notepad.exe"); 
    }
}
📄 Licença
Este projeto está sob a licença MIT.
