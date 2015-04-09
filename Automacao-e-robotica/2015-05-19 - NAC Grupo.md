#NAC Grupo

## Data de entrega 19/05/2015


| Pontuação 	| Enregas 	| Critério 	|
|-----------	|-----------------------------------------------------------------	|-------------------------------------------------------------------------------------------------------------	|
| 6 Pontos 	| Demonstração do funcionamento do programa no simulador 	| Será avaliado se o programa funciona corretamente, obedecendo a todas as especificações. 	|
| 4 Pontos 	| **Documentação contendo**: Programa Ladder,Tabelas de variáveis. 	| Organização das rotinas, Comentários no programa, Clareza das lógicas, Identificação de todas as variáveis. 	|

##Objetivo/Planta

Desenvolver um programa em Ladder para controlar a planta de envase (Silo Simulator) do software Logixpro.

![Simulador](http://s11.postimg.org/n6zxwivlv/Untitled.png)

##Tabela de IO’s (entradas e saídas)
### I:1
| Endereço 	| Símbolo 	| Descrição 	|
|:--------:	|:------------:	|:-------------------------------------:	|
| I:1/00 	| START 	| Botão Start - Partida (Normal Aberto) 	|
| I:1/01 	| STOP 	| Botão Stop - Parada (Normal Fechado) 	|
| I:1/02 	|  	|  	|
| I:1/03 	| PROX SENSOR 	| Sensorde presença de caixa 	|
| I:1/04 	| LEVEL SENSOR 	| Sensor de nível máximo 	|
| I:1/05 	| A 	| Chave seletora em A(Nomal Aberto) 	|
| I:1/06 	| B 	| Chave seletora em B(Nomal Aberto) 	|
| I:1/07 	| C 	| Chave seletora em C (Nomal Aberto) 	|

### I:2
| Endereço 	| Símbolo 	| Descrição 	|
|----------	|----------------	|-------------------------	|
| O:2/00 	| MOTOR 	| Ligar motor da esteira 	|
| O:2/01 	| SOLENOID VALVE 	| Abre bico de envase 	|
| O:2/02 	| RUN 	| Lânpada RUN (Em ciclo) 	|
| O:2/03 	| FILL 	| Lâmpada FILL (Enchendo) 	|
| O:2/04 	| FULL 	| Lâmpada FULL (Cheio) 	|

##Descrição do funcionamento

O sistema inicia o ciclo automático quando o botão “start” for pressionado, executando duas grandes rotinas:
1. Rotina de transporte e posicionamento das caixas através da esteira;
2. Rotina de envase do produto na caixa através do bico dosador.

Enquanto o sistema permanecer no estado “em ciclo”, a lâmpada “RUN” deve ficar acesa indicando este estado.

Quando o botão “stop” for pressionado, o sistema deve sair do estado “em ciclo”.
* Caso o botão for pressionado durante uma dosagem, essa deve ser finalizada normalmente e só então o sistema sai do estado “em ciclo”. Neste caso, a lâmpada “RUN” deve entrar em um estado de intermitência, indicando a condição de parando. 

##Rotina de transporte
Essa rotina posiciona as caixas para o envase, parando a esteira quando a caixa for detectada pelo sensor de presença de caixas e voltando ao movimento quando o processo de envase for finalizado.
* Caso a chave seletora esteja na posição C, o processo de dosagem deve ser ignorado e portando as caixas não precisam ser posicionadas. Assim, a esteira deve ficar sempre ligada enquanto o sistema permanecer “em ciclo”.

##Rotina de envase
Essa rotina inicia sempre que uma caixa for corretamente posicionada, executando o enchimento da caixa através do bico dosador e respeitando as seguintes condições:

* Caso a chave seletora esteja na posição A, a caixa deve encher até o nível máximo;
* Caso a chave seletora esteja na posição B, a caixa deve encher por um tempo pré-determinado ou até o nível máximo.

Enquanto o bico dosador estiver aberto, ou melhor, enquanto a válvula de dosagem estiver energizada, a lâmpada “FILL” deve permanecer acesa.
Quando acabar a dosagem, por tempo ou pelo nível, a lâmpada “FULL” deve acender, permanecendo acesa até que a caixa saía da posição de dosagem. 
