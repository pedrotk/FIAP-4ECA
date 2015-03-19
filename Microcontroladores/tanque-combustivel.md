#Problema
Dado um tanque de combustível com capacidade de 255 litros, com um sensor no fundo dotanque indicando o volume restante de combustível com função linear da pressão: assuma que o sensor representada a capacidadedo tanque como um byte acessado por meio do PORTB. Escreva uma rotina que irá ascender uma lampada conectada em RA0 caso o volume do tanque atinja 20 litros e dispare um alarme(Buzzer ligado em RA1) caso o volume do tanque atinja 5 litros. Ambos os periféricos são ativados em nível lógico 0.

#Solução do Professor
```nasm
INICIO
	BSF STATUS,RPO; //MUDOU PARA O BANCO 1	
	MOVLW 0XFF; 
	MOVWF TRISB; //PORTB CONFIGURADADA COMO ENTRADA
	CLRF TRISA; //PORTA CONFIGURADA COMO SAÍDA
	COMF PORTA; //ALARME DESLIGADO

ALARME
	MOVF PORTB, W;
	ADDLW .-5;
	BTFSS STATUS, C; //SE C = 1 NÃO HOUVE ESTOURO, LOGO O VOLUME É MAIOR OU IGUAL, CASO O VOLUME MENOR QUE 5 LIGA O BUZZER
	BCF PORTA,RA1;
	MOVF PORTB,W;
	ADDLW .-20;
	BTFSS STATUS,C;
	BCF PORTA,RA0;
	GOTO ALARME;
	
END;
```

#Solução do elfo
```nasm
INICIO
	
	BSF STATUS,RPO;
	
	SETF TRISB;
	CLRF TRISA;
	
ALARME

	MOVLW 0X05;
	CPFLST PORTB;
	BCF PORTA,RA1;
	
	MOVLW 0X14;
	CPFLST PORTB;
	BCF PORTA,RA0;
	
	GOTO ALARME;
	
END;
```
