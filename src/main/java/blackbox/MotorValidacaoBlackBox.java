package blackbox;

import com.validador.core.domain.Documento;

public class MotorValidacaoBlackBox {

    private final RegraValidacaoFinanceira regra;

    public MotorValidacaoBlackBox(RegraValidacaoFinanceira regra) {
        if (regra == null) {
            throw new IllegalArgumentException("A regra de validação é obrigatória.");
        }
        this.regra = regra;
    }

    public boolean executarFluxo(Documento documento) {
        System.out.println("[Black-box / Log] Motor acionado. Iniciando processamento...");

        boolean isValido = regra.validar(documento);

        System.out.println("[Black-box / Auditoria] Processamento concluído. Status: " + (isValido ? "APROVADO" : "REJEITADO"));
        return isValido;
    }
}