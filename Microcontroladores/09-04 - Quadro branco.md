#Ponteiro de dados

##Exemplo

- Colocar o valor 33h em 20 endereços de memória começando do 20h

###Método tradicional

```assembly
MOVLW 0x33
MOVWF 0x20
MOVWF 0x21
```

###Utilizando FSR e INDF

```assembly
MOVLW   .20
MOVWF   conta
MOVLW   0x20
MOVWF   FSR
MOVLW   0X33
MOVWF   INDF
INCF    FSR,F   ;LOOP
DECFSZ  CONTA,F
GOTO    LOOP
GOTO    FIM     ;FIM
```

## Exercício

1.  Colocar o valor F0h em 10 endereços de memória a partir do endereço 20h e colocar o valor 0Fh nos 10 endereços subsequentes. Ao final o led conectado a RB2 deverá piscar a cada 100ms. (Deve-se utilizar o par de registradores (FSR e INDF).
