#Instruções

##movwf

- movwf f (file)
	- ( w -> f )
		- Código : 00 0000 1FFF FFFF
		- Ciclos: 1 (Gasta 4x o Clock).
	- Se o clock for de 4Mhz o PIC Demora 1us.

####Exemplo

- movwf 0x20
		- Pega o conteúdo do *w* e armazena no *END*
	- Supondo:

![](http://s23.postimg.org/t0an2nzpn/Desenho_sem_t_tulo_1.png)

##movf f,d
- movf f,d
	- (f -> d)
		- f = Endereço da RAM onde esta o dado
		- d = Destino do dado { 0 -> w l 1 -> f ( próprio END.)
	-  Código: 00 1000 dfff ffff

####Exemplo

-	movf 0x21, 0
	-	Move o conteúdo do END. 21 para o w

![](http://s18.postimg.org/n66zzvnyh/w33h.png )

##movlw k

- movlw k
	- ( k -> w )
	- Código 11 00xx kkkk kkkk
	-  Exemplo
		-  movlw 0x10
![](http://s7.postimg.org/a798mf3vf/curved_pipe.png)


## Memória RAM

![](http://s14.postimg.org/lv2gjjigx/memoria_ram.png)
