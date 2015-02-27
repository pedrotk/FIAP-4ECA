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

### Status

![](http://s27.postimg.org/mlaz0dinn/STATUS.png)

| IRP	| Banco
| :------- | ----:
| 0 | 0 e 1
| 1 | 2 e 3

| RP1 | RP0 | Banco |
| :------- | :---- | :---: |
| 0 | 0|  0	|
| 0	| 1	|  1	|
| 1	| 0	|  2	|
| 1	| 1	|	3	|

#Intruções (Continuação)
## decf f,d

- Código : 00 0011 dfff ffff
- Ciclos : 1
- Flag : Z

### Exemplo 1

```
decf 0x20,1
```
![](http://s12.postimg.org/tb3ad2oi5/image.png)


### Exemplo 2

```
decf 0x20,0
```
![](http://s1.postimg.org/rc2k6hnjj/fz01.png)
