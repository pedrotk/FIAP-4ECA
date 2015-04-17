# Quadro branco

##Teste de mesa
- Fazer a simulação do trecho do programa anterior
- Mostrar passo a passo o conteúdo do **W, PC, 20H e FlagZ**

| PC | Instrução | w | 20H | Fz | Ciclos
| :-------: | :----: | :---: | :---: | :---: | :---: |
| 000h | movlw .3   |  x	|   x   |   0   |   1   |
| 001h	| movwf 0x20	|   3   |   x   |   0   |   1   |
| 002h	| decfsz 0x20,1 |   3   |   3   |   0   |   1   |
| 003h	| goto 0x002	|   3   |   2   |   0   |   2   |
| 002h	| decfsz 0x20,1	|   3   |   2   |   0   |   1   |
| 003h	| goto 0x002	|   3   |   2   |   0   |   2   |
| 002h	| decfsz 0x20,1	|   3   |   1   |   0   |   2   |
| 004h	| goto 0x004	|   3   |   0   |   0   |   2   |

####aguardando foto do resto

## Port A e Port B
![](http://s11.postimg.org/ipfu1nv8j/Port_A_e_Port_B.png)

## Comparadores
- Modo digital ( comparadores digital )

![](http://s11.postimg.org/y9n7s75cz/Comparadors.png)

### Modo Digital
- Comparadores Desligados

![](http://s11.postimg.org/qo4fn16ab/Untitled_Diagram_5.png)
