package blackbox;

/**
 * Contrato (interface) responsável por gravar o conteúdo já formatado no
 * destino desejado (disco, S3, e-mail, etc.).
 */
public interface DestinoRelatorio {

    void gravar(String nomeArquivo, String conteudo);
}
