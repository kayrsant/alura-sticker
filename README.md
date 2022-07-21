<h1 align="center">alura-stickers</h1>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white">
</p>

Este projeto foi realizado durante a imersão java da Alura, onde foi implementada uma aplicação java que consome a API IMDB.

## ✅ Resultados

# 📝 Aula 1 
<p align="center">
<img src="https://i.imgur.com/vXEkp6I.png">
</p>

# 📝 Aula 2
<p align="center">Saída no console:</p>
<p align="center">
<img src="https://i.imgur.com/ZOUyKa5.png">
</p>
<p align="center">Imagem gerada:</p>
<p align="center">
<img src="https://i.imgur.com/rZxGWz2.png">
</p>

# 📝 Aula 3
<p align="center">Escolha de qual API gerar sticker:</p>
<p align="center">
<img src="https://i.imgur.com/Ooqyi3l.png">
</p>
<p align="center">Nova Saída no Console da NASA:</p>
<p align="center">
<img src="https://i.imgur.com/92pv60I.png">
</p>
<p align="center">Imagem gerada pela API da NASA:</p>
<p align="center">
<img src="https://i.imgur.com/Z44LSRY.png">
</p>

## 📝 Aula 1

<p>Construção de uma aplicação do zero para consumir a API do IMDb (e alternativas pois a do IMDb caiu) e exibir os filmes mais populares, destacando seus pôsteres e visualizando sua classificação. Tudo isso sem usar nenhuma biblioteca externa!
</p>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge">
</p>

# 🎯 Desafios

  - [x] Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.
  - [x] Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!
  - [ ] Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente
  - [ ] Mudar o JsonParser para usar uma biblioteca de parsing de JSON como Jackson ou GSON
  - [ ] Desafio supremo: criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.

## 📝 Aula 2

<p>Nesta segunda aula vamos criar um gerador de figurinhas explorando outras bibliotecas nativas do Java, para que possamos enviar por Whatsapp os nossos filmes preferidos!
</p>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge">
</p>

# 🎯 Desafios

  - [x] Ler a documentação da classe abstrata InputStream.
  - [x] Centralizar o texto na figurinha.
  - [x] Fazer um pacote no Whatsapp e/ou Telegram com as suas próprias figurinhas!
  - [x] Criar diretório de saída das imagens, se ainda não existir.
  - [x] Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.
  - [x] Colocar uma imagem de você (ou alguma aleatória 😜) que está fazendo esse curso sorrindo, fazendo joinha!
  - [ ] Colocar contorno (outline) no texto da imagem.
  - [ ] Tratar as imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés dos thumbnails. Opções: pegar a URL da imagem e remover o trecho mostrado durante a aula ou consumir o endpoint de posters da API do IMDB (mais trabalhoso), tratando o JSON retornado.
  - [ ] Fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.
  - [ ] Desafio supremo: usar alguma biblioteca de manipulação de imagens como OpenCV pra extrair imagem principal e contorná-la.

## 📝 Aula 3

<p>Chegou o momento de pegarmos os filmes do IMDb e gerar figurinhas com os pôsteres, aproveitando para melhorar nosso código com as refatorações necessárias para torná-lo mais flexível e fácil de entender.</p>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge">
</p>

# 🎯 Desafios

 - [ ] Transformar a classe que representa os conteúdos em um Record, disponível a partir do Java 16
 - [ ] Criar as suas próprias exceções e usá-las na classe que implementa o cliente HTTP
 - [ ] Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra
 - [ ] Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado
 - [ ] Desafio supremo: consumir outras APIs que contém imagens, como a da Marvel, que é bem diferente. Repositório com APIs públicas: clique aqui.