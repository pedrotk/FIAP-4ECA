#Sistemas Distribuídos
1. Conceito
2. Arquiteturas
3. Processos
4. Comunicação
5. Nomeação
6. Sincronização
7. Replicação e Consistência
8. Tolerância a falhas
9. Segurança
10. Sistemas distribuídos baseados em objeto
11. Sistemas distribuídos de Arquivoss
12. Sistemas distribuídos baseado na web
13. Sistemas distribuídos em coordenação

## Conceito
Definição de SD segundo Tanenbaum
    
>Um sistema distribuido é um conjunto de computadores 
>independentes que se apresenta a seus usuários como um
>sistema único e coerente.

Dificuldades :

- Fazer com que diversos elementos dinâmicos colaborem entre si.
- Variedade de elementos
- Variedade de comunicação
- Escalável
- Disponível (SLA)
- Transparência

###Solução : 

- MiddleWare

 ![alt tag](http://s29.postimg.org/nzmgbws53/crop.jpg)

## Objetivos
- Acesso a recursos. Ex: Impressora, computadores, etc.
- Transparência de distribuição
    - Tipos
        - Acesso
        - Localização
        - Migração
        - Relocação
        - Concorrência
        - Falha
    - Grau
        - Latência de tentativa
        - Consistência 
    - Abertura
        - Padronização de solicitação de objetos, funções, tipos e execuções. Basicamente utiliza apenas interface
        - Resultado :
            - Interoperabilidade (Comunicação entre os elementos do SD).
            - Portabilidade (Executar elementos de um sistema A num Sistema B de forma transparente).
            - Modularidade (Componentes pequenos e independentes).

##Prática

- Threads
    - Processos que podem ser executados em paralelo pelo SO.
        - Exemplo
            - Java
                - Interface:   Runnable
                - Classe:   Thread
            - C, C++, Object Pascal, Python, C#

###Exemplo1Thread.java
```
package thread;

import java.util.Date;

public class Exemplo1Thread implements Runnable {

	
	private final String name;
	
	public Exemplo1Thread(String name){
		this.name = name;
	}
	public void run() {
		
		long delta = new Date().getTime();
		System.out.println("Thread id: " + name + " comecou");
		long max = 13000023232l;
		for(long i = 0; i < max; i++){
			
		}
		delta = new Date().getTime() - delta;
		System.out.println("Thread id: " + name + " acabou em: "+ delta);
		// TODO Auto-generated method stub
	}
}
```

###ThreadFactoryExemplo1.java
```
package thread;

public class ThreadFactoryExemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 3;
		for(int i = 1; i <= max; i++){
			String name = String.valueOf(i);
			Exemplo1Thread task = new Exemplo1Thread(name);
			Thread thread = new Thread(task);
		}
	}

}
```

#### Output
    Thread id: 2 comecou
    Thread id: 3 comecou
    Thread id: 1 comecou
    Thread id: 1 acabou em: 3815
    Thread id: 2 acabou em: 3815
    Thread id: 3 acabou em: 3815

#### CPU Usage
![alt tag](http://s30.postimg.org/6lq5qmoap/Untitled.png)

##Escalabilidade

-   Tamanho ( + usuarios + recursos )
-   Geográfico (amplas distâncias entre os usuários e recursos)
-   Administração ( diferente hierárquias administrativa )

##Problemas
-   Serviço centralizados (Único servidor)
-   Dados centralizados ( gargalo de acesso - exemplo. DNS )
-   Algoritimos centralizados ( roteamento )
    1. Nenhuma máquina tem informação completa do estilo do sitema.
    2. Ele toma decisões baseada em informações locais.
    3. Tolerância a falhas de máquina
    4. Não depende de *- PROX_AL -*
- Soluções para capacidade limitada de servidores e rede:
    1. Ocular latência ( processos assíncronos ) 
    2. Distribuição ( distribuição hierárquica ( árvore ) )
    3. Replicação ( Load balance ( Serviço do tipo staless ) e desempenho )
        - Desvantagem : Falta de consistência (Implica em Sincronização)

## Ciladas
### Premissas falsas do desenvolver de um sistema

1. Rede confiável
2. Rede Segura
3. Rede Homongênea
4. Topologia imutável
5. Latência zero
6. Largura de banda infinita
7. Custo de transporte zero
8. Administração centralizada
