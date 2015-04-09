#1 
Um Determinado Sensor após habilitado somente completa o envio da informação solicitada após 250ms de seu acionamento. Implemente uma sub-rotina que efetue o acionameto do sensor, aguarde a informação ser recebida e sinalize o recebimento da informação acionando o LED ligado ao microcontraldor de acordo com o circuito abaixo. Considere o clock eexterno igual a 4MHz.
Comente as linhas mais importantes de seu programa.
```assembly
#INCLUDE <P16F628A.INC>

ORG 0X00
GOTO INICIO
ORG 0X04
GOTO RETFIE

BSF STATUS,RP0
BSF TRISB,RB2
BCF TRISB,RB0

INICIO
	BCF TRISB,RB1
	BTFSS PORTB,RB1
	CALL DELAY
	BCF PORTB,RB0
	BCF PORTB,RB2
	GOTO INICIO

DELAY
    MOVLW .250
    MOVWF 0X20
        LOOP2:
            MOVLW .250
            MOVWF 0X21
        LOOP1:
            NOP
            DECFSZ 0X20,F
            GOTO LOOP1
            DECFSZ 0X21,F
            GOTO LOOP2
    RETURN
	
END
```
