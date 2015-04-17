# Resumo da aula

##Links
- MicroChip ([link] [1])
- Datasheet ([link] [2])

##Programas
- MPLAB® X ([link] [3], [download] [4])



##Exercicio 1
Elaborar um firmware com as seguintes características:
- Botão RB3 pressionado = LED D0 Aceso
- Botão RB3 pressionado = LED D0 Apagado
- Botão RB4 Pressionado = LED D1 Apagado
- Botão RB4 Liberado = LED D1 Aceso

```assembly
#include <P18F452.inc>

        ORG     0x00        
        GOTO    INICIO
        ORG     0x04
        RETFIE

INICIO  BSF TRISB,RB3
        BSF TRISB,RB4
		BCF TRISD,RD0
   		BCF TRISD,RD1

        BSF PORTD,RD1
        BCF PORTD,RD0

BOTAO	BTFSS PORTB,RB3
        CALL  DELAY
        BTFSS PORTB,RB3
        GOTO  BOTAO
        BCF   PORTD,RD0

		BTFSC PORTB,RB4
        CALL  DELAY
        BTFSC PORTB,RB4
        GOTO  BOTAO1
        BCF   PORTD,RD1

BOTAO1	BTFSS PORTB,RB4
        CALL  DELAY
        BTFSS PORTB,RB4
        GOTO  BOTAO
        BSF   PORTD,RD1
		
		BTFSC PORTB,RB3
        CALL  DELAY
        BTFSC PORTB,RB3
        GOTO  BOTAO
        BSF   PORTD,RD0

	    GOTO  BOTAO

DELAY   MOVLW .100
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

INICIO
```


[1]:http://www.microchip.com
[2]:http://ww1.microchip.com/downloads/en/DeviceDoc/39564c.pdf
[3]:http://www.microchip.com/pagehandler/en-us/family/mplabx/
[4]:http://ww1.microchip.com/downloads/en/DeviceDoc/MPLAB_IDE_8_50.zip
