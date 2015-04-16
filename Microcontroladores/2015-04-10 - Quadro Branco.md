![imagem](http://s24.postimg.org/641y0z2yt/Desenho_sem_t_tulo.png)

#E²PROM
Implementar um programa que grave o número 7 no END  01h da memória E²PROM

```assembly
#include<p16f6182a.inc>
ORG 0X00
GOTO INICIO
ORG 0X04
RETFIE
INICIO      BSF     STATUS,RP0
            MOVLW   0X01
            MOVWF   EEADR
            MOVLW   .7
            MOVWF   EEDATA
            BCF     INTCON, GIE; DESLIGA TODAS AS INTERRUPÇÕES
            BCF     EECON1,WPEN; HABILITA A ESCRITA NA EEPRON
            MOVLW   0X55;
            MOVWF   EECDNZ; PROCEDIMENTO OBRIGATÓRIO }4MHZ DE CLOCK
            MOVWW   0XAA;
            MOVWF   EECONZ;
            BSF     EECON1,WR;COMEÇA A ESCREVER O VALOR NA E²PROM
            
TESTA       BTFSC   EECON1,WR; WR É RESETADO POR HARDWARE }TESTA SERÁ RODADO POR 10ms
            GOTO    TESTA
            BSF     INTCON,GIE
            BCF     STATUS,RPW
```

- Ler os endereços 0 e 1 da E²PROM os valores lidos deveram ser colocados nas variáveis **NUM0** e **NUM1** da memória flash.

```assembly
#include    <P16F628A.INC>  
CBLOCK      0X20
NUM0
NUM1
ENDC
ORG         0x00
GOTO        INICIO
ORG         0x04
RETFIE
INICIO      BSF         STATUS,RP0
            MOVLW       .0
            MOVWF       EEADR
            CALL        LE_EEPROM
            MOVWF       NUM0
            BSF         STATUS,RP0
            MOVLW       .1
            MOVWF       EEADR
            CALL        LE_EEPROM
            MOVWF       NUM1
FIM         GOTO        FIM
LE_EEPROM   BSF         STATUS,RP0
            BSF         EECON1,RD ; Prepara Leitura
            MOVF        EEDATA,W
            BCF         STATUS,RP0
            RETURN
            END
```

#Exercício
- Acrescentar ao programa "*contador em anel módulo 10*" uma rotina que grave na E²PROM o valor da contagem e uma rotina que recupere esse valor caso o **pic** seja resetado

##Resposta Aluno

```assembly
#include<PIC6F28A.INC>

CBLOCK 0X20
NUM
CONTA
ENDC

    ORG 0X00
    GOTO 0X00
    GOTO INICIO
    ORG 0X04
    RETFIE
    
    BSF STATUS,RP0
    MOVLW B'00010000'
    MOVWF TRISA
    CLRF TRISB
    MOVLW .7
    MOVWF CMCON
    
INCIO MOVLW .0
      MOVWF EEADR
      CALL LER_EEPROM
      MOVWF CONTA
      MOVWFPORTB
      BCF STATUS,RP0

BOTAO BTFSC PORTA,RA4
      CALL DELAY
      BTFSC PORTA,RA4
      GOTO BOTAO
      INCF PORTB,F
      MOVLW PORTB
      CALL INSERIR_EEPROM
      
PRESO BTFSS PORTA,RA4
      GOTO  PRESO
      DECFSZ CONTA,F
      GOTO BOTAO
      MOVLW .9
      MOVWF CONTA
      CLRF TRISB
      GOTO BOTAO
      
LER_EEPROM BSF STATUS,RP0
           BSF EECON,RD
           MOVF EEDATA,0
           BCF STATUS,RP0
           RETURN
           
INSERIR_EEPROM BCF INTCON_GIE
               BSF EECON1,WREN
               MOVLW 0X55
               MOVWF EECON2
               MOVLW 0XAA
               MOVWF EECOM2
               BSF EECON1,WR
TESTA BTFSC EECON1,WR
      GOTO TESTA
      BSF INTCON,GIE
      BCF STATUS,RP0
```
