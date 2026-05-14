package blackbox;

import model.DadosRelatorio;

/**
 * Framework Black-box de exportação de relatórios.
 *
 * Extensão por composição + injeção de dependências (Strategy).
 * O motor é uma "caixa preta" para o cliente: ele só conhece as interfaces
 * {@link FormatoRelatorio} e {@link DestinoRelatorio}.
 *
 * Princípio de Hollywood / IoC: o motor chama as estratégias do cliente.
 */
public class MotorExportacaoBlackBox {

    private final FormatoRelatorio formato;   // Composição (Strategy)
    private final DestinoRelatorio destino;   // Composição (Strategy)

    // Injeção de Dependência via construtor
    public MotorExportacaoBlackBox(FormatoRelatorio formato, DestinoRelatorio destino) {
        if (formato == null || destino == null) {
            throw new IllegalArgumentException("Formato e destino são obrigatórios");
        }
        this.formato = formato;
        this.destino = destino;
    }

    public void exportar(DadosRelatorio dados) {
        System.out.println("[Framework] Iniciando exportação Black-box de '" + dados.titulo() + "'");

        if (dados.linhas() == null || dados.linhas().isEmpty()) {
            System.out.println("[Framework] Sem dados para exportar.");
            return;
        }

        // Inversão de Controle delegada para as interfaces
        String conteudo = formato.formatar(dados);
        String nomeArquivo = montarNomeArquivo(dados);
        destino.gravar(nomeArquivo, conteudo);

        System.out.println("[Framework] Exportação Black-box concluída.");
    }

    private String montarNomeArquivo(DadosRelatorio dados) {
        String base = dados.titulo()
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
        return base + "." + formato.extensao();
    }
}
