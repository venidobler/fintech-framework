package whitebox;

import com.validador.core.domain.Documento;

public abstract class ValidadorFinanceiroWhiteBox {

    public final boolean executarFluxoValidacao(Documento documento) {
        System.out.println("[White-box / Log] Iniciando processamento do documento...");

        boolean isValido = validarRegraEspecifica(documento);

        System.out.println("[White-box / Auditoria] Validação finalizada. Status: " + (isValido ? "APROVADO" : "REJEITADO"));
        return isValido;
    }

    protected abstract boolean validarRegraEspecifica(Documento documento);
}