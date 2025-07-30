# Corrida de Cavalos com Threads (Java Swing)

![Java](https://img.shields.io/badge/Java-11%2B-blue.svg)
![GUI](https://img.shields.io/badge/GUI-Java%20Swing-orange.svg)
![Concurrency](https://img.shields.io/badge/Concurrency-Java%20Threads-red.svg)

## 📖 Descrição

Este projeto é uma simulação simples de uma corrida de cavalos com interface gráfica, desenvolvida em Java utilizando a biblioteca Swing. O principal objetivo é demonstrar o uso de **múltiplas threads** para simular o movimento independente de cada cavalo, enquanto a interface gráfica é atualizada de forma assíncrona para proporcionar uma experiência fluida.

Cada cavalo corre em sua própria thread, avançando aleatoriamente até cruzar a linha de chegada. O primeiro cavalo a atingir o final da pista é declarado o vencedor.

## ✨ Funcionalidades Principais

*   **Simulação de Corrida:** Simula uma corrida entre múltiplos cavalos.
*   **Interface Gráfica:** Utiliza Java Swing para exibir a pista, os cavalos e o progresso da corrida.
*   **Multithreading:** Cada cavalo é executado em uma thread separada, demonstrando concorrência em Java.
*   **Movimento Aleatório:** O avanço de cada cavalo é determinado por um valor aleatório, tornando cada corrida única.
*   **Declaração de Vencedor:** Identifica e anuncia o primeiro cavalo a cruzar a linha de chegada.

## 🛠️ Tecnologias Utilizadas

*   **Linguagem:** Java (versão 11 ou superior)
*   **Interface Gráfica:** Java Swing
*   **Concorrência:** Java Threads, `volatile` e `synchronized` para controle de estado.

## 🚀 Como Executar

1.  **Clone o repositório** (ou baixe os arquivos `Cavalo.java`, `CorridaCavalosSwing.java` e `PainelCorrida.java`).
2.  **Compile os arquivos Java** usando um compilador Java (JDK 11+):
    ```bash
    javac Cavalo.java PainelCorrida.java CorridaCavalosSwing.java
    ```
3.  **Execute o programa principal**:
    ```bash
    java CorridaCavalosSwing
    ```

Uma janela com a simulação da corrida será aberta. O vencedor será anunciado em uma caixa de diálogo ao final da corrida.

## 📝 Notas

*   O projeto utiliza `SwingUtilities.invokeLater` para garantir que as atualizações da interface gráfica sejam feitas na Thread de Despacho de Eventos (EDT), evitando problemas de concorrência na UI.
*   A variável `corridaTerminou` é `volatile` para garantir visibilidade entre as threads.

## 👩‍💻 Autor

Kananda Winter
