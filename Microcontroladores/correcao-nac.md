

#Questões 
1. Um Determinado Sensor após habilitado somente completa o envio da informação solicitada após 250ms de seu acionamento. Implemente uma sub-rotina que efetue o acionameto do sensor, aguarde a informação ser recebida e sinalize o recebimento da informação acionando o LED ligado ao microcontraldor de acordo com o circuito abaixo. Considere o clock eexterno igual a 4MHz. **Comente as linhas mais importantes de seu programa.**
2. Qual o valor dos registradores LATA, LATB e W após a execução do trecho de programa abaixo


#####Resposta questão 1

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

#####Resposta questão 2

| Instrução | LATA  | LATB  | W |
| ------------- |:-------------:| :-----:| ---:|
|MOVLW 0XFF|0|não sei|não sei|
|MOVWF TRISB|0|não sei|não sei|
|MOVLW .20|0|não sei|não sei|
|MOVWF LATB|0|não sei|não sei|
|XORWF LATA,1|20|não sei|não sei|
|NOP|20|não sei|não sei|
|DECFSZ LATB,0|20|não sei|não sei|
|INCF LATA,1|21|não sei|não sei|
|FIM GOTO FIM|21|não sei|não sei|
