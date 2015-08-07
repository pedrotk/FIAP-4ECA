# Circuito
Ver no Circuit Maker

# Programa

```Arduino
int trigger = 2;
int sensor1 = 4;
int sensor2 = 7;
int sensor3 = 8;

void ligarSensores(){
  digitalWrite(trigger, LOW);
  delay(2);
  digitalWrite(trigger, HIGH);
  delayMicroseconds(12);
}

int medirDistancia(int sensor){
  int tempo;
  ligarSensores;
  tempo = pulseIn(sensor, HIGH, sizeof(int));
  return tempo / 29 / 2;
}

void setup() {
  pinMode(trigger, OUTPUT);
  pinMode(sensor1, INPUT);
  pinMode(sensor2, INPUT);
  pinMode(sensor3, INPUT);
}

void loop() {
  
}
```
