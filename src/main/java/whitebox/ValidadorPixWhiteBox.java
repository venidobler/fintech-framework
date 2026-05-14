package whitebox;

import com.validador.core.domain.Documento;
import com.validador.core.domain.ValidadorDocumento;
import com.validador.core.domain.ResultadoValidacao;

public class ValidadorPixWhiteBox extends ValidadorFinanceiroWhiteBox {

    @Override
    protected boolean validarRegraEspecifica(Documento documento) {
        System.out.println("[Cliente] Executando regras específicas para transação PIX no White-box...");

        // Chamando o motor construído no Repo 1
        ValidadorDocumento motorCore = new ValidadorDocumento();
        ResultadoValidacao resultado = motorCore.validar(documento);

        System.out.println("[Cliente] Detalhe: " + resultado.mensagem());
        return resultado.valido();
    }
}