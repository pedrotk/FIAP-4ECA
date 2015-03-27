#Quadro Branco

## Exercicios

1. Implementar um contador em anel módulo 10. O botão ligado a RA4 incrementa o contador, o resultado é mostrado no PORTB de forma binaria.

```assembly
#include <p16f628a.inc>

CONTA	EQU		0x20
		ORG		0x00		
		GOTO	INICIO
		ORG		0x04
		RETFIE

INICIO	MOVLW	0x20
		MOVWF	STATUS
		MOVLW	B'00010000'
		MOVWF	TRISA
		CLRF	TRISB
		MOVLW	0x07
		MOVWF	CMCON
		CLRF	CONTA
		CLRF	PORTB
		MOVLW	.9
		MOVWF	CONTA
		
BOTAO	BTFSC	PORTA,4
		CALL	DELAY
		BTFSC	PORTA,4
		GOTO	BOTAO
		INCF	PORTB,F
		
PRESO	BTFSS	PORTA,4
		GOTO	PRESO
		DECFSZ	CONTA,F
		GOTO	BOTAO
		MOVLW	.9
		MOVWF	CONTA
		CLRF	PORTB
		GOTO	BOTAO

DELAY	MOVLW .100
		MOVWF 0X21
			LOOP2:
				MOVLW .250
				MOVWF 0X20F
			LOOP1:
				NOP
				DECFSZ 0X20F
				GOTO LOOP1
				DECFSZ 0X21,F
				GOTO LOOP2
		RETURN
END
```