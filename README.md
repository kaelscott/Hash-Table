# Projeto de Tabelas Hash com Java

Este projeto implementa e compara duas tabelas hash em Java, utilizando diferentes funções hash e tratamento de colisões com sondagem linear.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:
- **HashTable**: Classe abstrata que define a estrutura de uma tabela hash genérica.
- **HashTable1**: Implementação da tabela hash com uma função hash simples.
- **HashTable2**: Implementação da tabela hash com uma função hash de dispersão polinomial.
- **HashComparison**: Classe principal que executa os testes e exibe os resultados no console.

## Objetivo

Comparar a eficiência das duas funções hash em termos de:
- Número de colisões
- Tempo de inserção e busca
- Distribuição das chaves na tabela

## Resultados

### Número de Colisões

- **HashTable1**: `<total_de_colisoes_tabela1>`
- **HashTable2**: `<total_de_colisoes_tabela2>`

### Tempos de Inserção

- **HashTable1**: `<tempo_insercao_tabela1> ns`
- **HashTable2**: `<tempo_insercao_tabela2> ns`

### Tempos de Busca

- **HashTable1**: `<tempo_busca_tabela1> ns`
- **HashTable2**: `<tempo_busca_tabela2> ns`

### Distribuição das Chaves

#### HashTable1
- Posição 0: `<chaves_na_posicao_0>`
- Posição 1: `<chaves_na_posicao_1>`
- ...
- Posição N: `<chaves_na_posicao_n>`

#### HashTable2
- Posição 0: `<chaves_na_posicao_0>`
- Posição 1: `<chaves_na_posicao_1>`
- ...
- Posição N: `<chaves_na_posicao_n>`

---

> **Observação**: Os valores `<...>` devem ser substituídos pelos resultados gerados no console após a execução do programa.

## Instruções para Execução

1. Certifique-se de que todos os arquivos `.java` estejam no mesmo diretório.
2. Compile os arquivos com o comando:
   ```bash
   javac *.java
