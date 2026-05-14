package blackbox;

import com.validador.core.domain.Documento;

public interface RegraValidacaoFinanceira {
    boolean validar(Documento documento);
}