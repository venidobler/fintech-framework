package blackbox;

import model.DadosRelatorio;

/**
 * Contrato (interface) que o cliente implementa para plugar um novo formato
 * no motor Black-box de exportação. Equivalente ao papel de
 * {@code DocumentoValidatorStrategy} no validador-core.
 */
public interface FormatoRelatorio {

    /**
     * Converte os dados do relatório em uma representação textual no formato
     * desejado (PDF, CSV, JSON, etc.).
     */
    String formatar(DadosRelatorio dados);

    /**
     * Extensão do arquivo gerado (ex.: "pdf", "csv").
     */
    String extensao();
}
