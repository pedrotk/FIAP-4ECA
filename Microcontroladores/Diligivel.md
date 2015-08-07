# Circuito
Ver no Circuit Maker

# Programa

```Arduino
int trigger = 2;
int sensorLateral = 4;
int sensorFrente = 7;
int sensorVertical = 8;
int motorEsq = 10;
int motorDir = 11;

void ligarSensores(){
  digitalWrite(trigger, LOW);
  delay(2);
  digitalWrite(trigger, HIGH);
  delay(105);
}

int medirDistancia(int sensor){
  int tempo;
  ligarSensores;
  tempo = pulseIn(sensor, HIGH, sizeof(int));
  return tempo / 29 / 2;
}

void virarEsq(){
  analogWrite(motorEsq, 255);
  analogWrite(motorDir, 127);
}

void virarDir(){
  analogWrite(motorEsq, 127);
  analogWrite(motorDir, 255);
}

void setup() {
  pinMode(trigger, OUTPUT);
  pinMode(sensorLateral, INPUT);
  pinMode(sensorFrente, INPUT);
  pinMode(sensorVertical, INPUT);
  pinMode(motorEsq, OUTPUT);
  pinMode(motorDir, OUTPUT);
}

void loop() {
  
}
```
