package blackbox;

import com.validador.core.domain.Documento;
import com.validador.core.domain.ValidadorDocumento;
import com.validador.core.domain.ResultadoValidacao;

public class RegraPixBlackBox implements RegraValidacaoFinanceira {

    @Override
    public boolean validar(Documento documento) {
        System.out.println("[Cliente] Aplicando validação de chave PIX via Strategy no Black-box...");

        // Chamando o motor construído no Repo 1
        ValidadorDocumento motorCore = new ValidadorDocumento();
        ResultadoValidacao resultado = motorCore.validar(documento);

        System.out.println("[Cliente] Detalhe: " + resultado.mensagem());
        return resultado.valido();
    }
}