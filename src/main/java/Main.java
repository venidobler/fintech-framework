import blackbox.MotorValidacaoBlackBox;
import blackbox.RegraPixBlackBox;
import whitebox.ValidadorFinanceiroWhiteBox;
import whitebox.ValidadorPixWhiteBox;
import com.validador.core.domain.Documento;
import com.validador.core.domain.Cpf;

public class Main {
    public static void main(String[] args) {
        // Agora estamos usando a classe real do Repositório 1!
        Documento documentoReal = new Cpf("11144477735");

        System.out.println("=== TESTE WHITE-BOX (Herança/Template Method) ===");
        ValidadorFinanceiroWhiteBox validadorWhite = new ValidadorPixWhiteBox();
        validadorWhite.executarFluxoValidacao(documentoReal);

        System.out.println("\n=== TESTE BLACK-BOX (Composição/Strategy) ===");
        MotorValidacaoBlackBox motorBlack = new MotorValidacaoBlackBox(new RegraPixBlackBox());
        motorBlack.executarFluxo(documentoReal);
    }
}