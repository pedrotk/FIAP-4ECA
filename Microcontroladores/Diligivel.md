# Circuito
Ver no Circuit Maker

# Programa

```Arduino
#include<Servo.h>

int trigger = 2;
int sensorLateral = 4;
int sensorFrente = 7;
int sensorVertical = 8;
int motorEsq = 3;
int motorDir = 11;
Servo asa;

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
  return tempo / 58;
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
  asa.attach(9);
  asa.write(90);
}

void ajustarAltura(int alvo){
  int dist = medirDistancia(sensorVertical);
  while(dist != alvo){
    if(dist < alvo)
     asa.write(0);
    else
     asa.write(180);
    dist = medirDistancia(sensorVertical);
  }
  asa.write(90);
}

void loop() {
  
}
```
