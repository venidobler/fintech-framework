package whitebox;

import model.DadosRelatorio;

/**
 * Framework White-box de exportação de relatórios.
 *
 * Extensão por herança + Template Method.
 * O fluxo (chassi) está fixado em {@link #exportar(DadosRelatorio)} e o
 * código do cliente apenas sobrescreve os passos variáveis.
 *
 * Princípio de Hollywood: "Don't call us, we'll call you".
 */
public abstract class ExportadorRelatorioWhiteBox {

    /**
     * Template Method: define o esqueleto do algoritmo de exportação.
     * É {@code final} para garantir que o cliente não altere o fluxo.
     */
    public final void exportar(DadosRelatorio dados) {
        System.out.println("[Framework] Iniciando exportação de '" + dados.titulo() + "'");

        if (dados.linhas() == null || dados.linhas().isEmpty()) {
            System.out.println("[Framework] Sem dados para exportar.");
            return;
        }

        String cabecalho = formatarCabecalho(dados);
        String corpo = formatarCorpo(dados);
        String rodape = formatarRodape(dados);

        salvarArquivo(cabecalho + corpo + rodape);

        System.out.println("[Framework] Exportação concluída.");
    }

    // PASSOS VARIÁVEIS (hooks abstratos que o cliente implementa via herança)
    protected abstract String formatarCabecalho(DadosRelatorio dados);

    protected abstract String formatarCorpo(DadosRelatorio dados);

    protected abstract void salvarArquivo(String conteudo);

    // HOOK opcional (passo com implementação default que pode ser sobrescrito)
    protected String formatarRodape(DadosRelatorio dados) {
        return "\n--- Fim do relatório (" + dados.dataReferencia() + ") ---\n";
    }
}
