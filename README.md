# 🏗️ Repositório 2: fintech-framework

# Grupo 04
- Gustavo Dechotti
- Kelvin de Jesus
- Natan Kainak
- Venícius Dobler
- Vitor parente

Este repositório representa o **Mini-Framework** de validação financeira da Fintech. Ele aplica o **Princípio de Hollywood ("Don't call us, we'll call you")** para ditar o fluxo de execução, permitindo que diferentes regras de negócio sejam acopladas à esteira principal.

## 🎯 Objetivo
Demonstrar a aplicação prática de Inversão de Controle (IoC) através de arquiteturas **White-box** e **Black-box**, integrando o componente de domínio `validator-core` (Repositório 1).

## 🚀 Estrutura do Framework

### 1. Módulo White-box (Herança)
Implementado no pacote `whitebox`, utiliza o padrão **Template Method**.
- **Classe Base:** `ValidadorFinanceiroWhiteBox` define o esqueleto do algoritmo.
- **Extensão:** O cliente estende a classe e implementa os métodos "gancho" (hooks) para definir o comportamento específico (ex: `ValidadorPixWhiteBox`).

### 2. Módulo Black-box (Composição)
Implementado no pacote `blackbox`, utiliza os padrões **Strategy e Factory**.
- **Motor:** `MotorValidacaoBlackBox` é agnóstico às implementações concretas.
- **Contratos:** Baseado na interface `RegraValidacaoFinanceira`.
- **Injeção:** As dependências (regras específicas) são injetadas via construtor.

## 🛡️ Defesa Arquitetural

### 1. A Diferença Prática: Biblioteca vs Framework
Ao construir a **biblioteca (validator-core)**, focamos em fornecer ferramentas que o desenvolvedor decide *quando* e *como* chamar. O controle do fluxo de execução permanece com o código do usuário.
Já no **Framework (fintech-framework)**, nós criamos o "chassi" da aplicação. O framework é quem detém o controle do fluxo e chama o código do desenvolvedor nos pontos de extensão pré-definidos.

### 2. Acoplamento: Por que a indústria prefere Black-box?
A indústria moderna (como o ecossistema Spring) prefere a abordagem **Black-box (Composição)** pelos seguintes motivos:
- **Flexibilidade:** Permite trocar comportamentos em tempo de execução sem alterar a hierarquia de classes.
- **Testabilidade:** Facilita a criação de Mocks e stubs para testes unitários.
- **Evita a Fragilidade:** Na White-box (Herança), mudanças na classe pai podem causar efeitos colaterais inesperados em todas as subclasses. A Composição favorece o princípio "Favor composition over inheritance".

### 3. Inversão de Controle (IoC) na Prática

#### No White-box (Herança):
A IoC ocorre quando o método `final` da classe pai chama os métodos abstratos que serão implementados pelo cliente:
```java
// Arquivo: ValidadorFinanceiroWhiteBox.java
public final boolean executarFluxoValidacao(Documento doc) {
    // ...
    boolean isValido = validarRegraEspecifica(doc); // <--- IoC: Framework chamando o código do cliente
    // ...
}
```

#### No Black-box (Composição):
A IoC ocorre quando o motor delega a execução para as interfaces injetadas, sem saber qual a implementação concreta:
```java
// Arquivo: MotorValidacaoBlackBox.java
public boolean executarFluxo(Documento doc) {
    // ...
    boolean isValido = regra.validar(doc); // <--- IoC: Framework delegando para a estratégia
    // ...
}
```

## 🛠️ Como Executar
Este projeto depende do `validator-core`. Certifique-se de ter rodado `mvn install` no Repositório 1 antes de compilar este.

```bash
mvn clean compile
```

## 📄 Licença
Este projeto é para fins acadêmicos na disciplina de Reuso e Refatoração.
