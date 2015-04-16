#Interrupção / Timer0

![image](http://s12.postimg.org/wivi617m5/16_04_desenho.png)

![image](http://s12.postimg.org/q6gcw74jx/Desenho_2.png)

| PS2 | PS1 | PS0 | TRM0  | WDT   |
|-----|-----|-----|-------|-------|
| 0   | 0   | 0   | 1:2   | 1:1   |
| 0   | 0   | 1   | 1:4   | 1:2   |
| 0   | 1   | 0   | 1:8   | 1:4   |
| 0   | 1   | 1   | 1:16  | 1:8   |
| 1   | 0   | 0   | 1:32  | 1:16  |
| 1   | 0   | 1   | 1:64  | 1:32  |
| 1   | 1   | 0   | 1:128 | 1:64  |
| 1   | 1   | 1   | 1:256 | 1:128 |

![ímage](http://s17.postimg.org/81ddj9xb3/Untitled_Diagram_2.png)

![image](http://s17.postimg.org/mylukaajj/Untitled_Diagram_1.png)

> Qual o tempo **Máximo** que o TMR0 pode contar? (4MHz)

```
256 * 256 * 1µs = 65.536 µs
```
