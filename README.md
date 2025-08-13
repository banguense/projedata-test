# projedata-test

## Descrição

Este é um projeto simples em Java para gerenciar uma lista de funcionários. Ele realiza as seguintes operações:
- Insere uma lista inicial de funcionários.
- Remove um funcionário da lista.
- Aumenta o salário de todos os funcionários em 10%.
- Agrupa os funcionários por função.
- Lista os funcionários que fazem aniversário nos meses 10 e 12.
- Encontra o funcionário com a maior idade.
- Lista os funcionários em ordem alfabética.
- Calcula e exibe o total dos salários.
- Calcula quantos salários mínimos cada funcionário ganha.

## Versão do Java

Java 21

## Como Executar o Projeto

Para executar a classe principal, utilize o Maven Wrapper.

Primeiro, dê permissão de execução para o script do wrapper.

**No Linux/macOS:**
```bash
chmod +x mvnw
```

**No Windows (usando PowerShell):**
```powershell
# Se a execução de scripts estiver restringida, você pode precisar executar este comando:
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope Process
```
O `mvnw.cmd` já deve funcionar no Prompt de Comando (CMD) sem passos adicionais.

Depois de conceder a permissão, execute o projeto com o seguinte comando:

```bash
./mvnw compile exec:java
```

## Como Buildar o Projeto

```bash
./mvnw clean package
```

## Como Executar os Testes

Para rodar os testes unitários, utilize o comando:

```bash
./mvnw test
```