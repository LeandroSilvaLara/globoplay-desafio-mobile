<h1 align="center">Movie Compose Globoplay Recrutamento </h1>


<p align="center">  
O MovieCompose é um pequeno aplicativo de demonstração baseado em pilhas de tecnologia Android modernas, com foco especial na IU do Jetpack Compose usando a API do Movie DB. Também buscar dados da rede e integrar dados persistentes no banco de dados por meio do padrão de repositório.
</p>
</br>




## Como construir em seu ambiente
Adicione o seu [The Movie DB](https://www.themoviedb.org/)'s API chave em local.properties file.
```xml
tmdb_api_key=YOUR_API_KEY
```

<img src="/previews/preview0.gif" align="right" width="32%"/>

## Pilha de tecnologia e bibliotecas de código aberto
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt for dependency injection.
- JetPack
  - Compose - Um kit de ferramentas moderno para a construção de IU nativa do Android.
  - Lifecycle - descartar dados de observação quando o estado do ciclo de vida muda.
  - ViewModel - Detentor de dados relacionados à IU, ciente do ciclo de vida.
  - Room Persistence - construir banco de dados.
  - App Startup - Fornece uma maneira direta e eficiente de inicializar componentes na inicialização do aplicativo.
- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- Material Design & Animations
- [Accompanist](https://github.com/google/accompanist) -Uma coleção de bibliotecas de extensão para o Jetpack Compose.
- [Landscapist](https://github.com/skydoves/landscapist) - Jetpack Componha a biblioteca de carregamento de imagens com animações de brilho e revelação circular.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construir as APIs REST e dados de rede de paginação.
- [Sandwich](https://github.com/skydoves/Sandwich) - construir uma resposta leve da API http e lidar com as respostas de erro.
- [WhatIf](https://github.com/skydoves/whatif) - verificar objetos anuláveis e coleções vazias com mais fluência.
- [Timber](https://github.com/JakeWharton/timber) - logging.


## Features
 #	Essencial:
 
	- Tela de splash;
	- Listagem dos filmes;
	- Minha lista;
	- Detalhes do filme;
	- Favoritar/Desfavoritar filmes;
	- Layout estruturado;
	- Tratamento de erro.

 #	Ganha mais pontos se tiver:
	  
	- Filtros;
	- Busca;
	- Paginação;
	- Animações;
	- Testes unitários;
	- Testes instrumentados;
	- Testes funcionais;
	- Pipeline Automatizado.
	
 #	Iremos ficar encantados:

	- Play do vídeo.
	
## Exemplos e sugestões

Nossos designers elaboraram algumas sugestões de telas e fluxos para guiar você durante o desenvolvimento, portanto fique à vontade para modificar como você quiser. Para facilitar o processo, existem assets, app icons, ícones e paleta de cores no repositório. Mas se o seu lado designer falar mais alto, pode nos surpreender!

	- Splash
	- Grid de filmes
	- Detalhes
	- Assista Também
	- Adicionar aos favoritos
	- Lista de Favoritos