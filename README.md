# AdivinaElNumero

**Primera parte**:  
La App genera un número aleatorio que debe cumplir estas dos premisas:  
1. Esté entre 1023 y 9876 ambos extremos incluidos.  
2. No contenga dígitos repetidos.  

El Jugador ingresa un número de cuatro dígitos y el sistema verifica si cumple con las condiciones que debe cumplir el numero generado por el sistema (que esté entre 1023 y 9876
y que no contenga dígitos repetidos). De no cumplir se le avisará al jugador.
De ser un número válido, el sistema informará al jugador:  
Número que ingresó, Cantidad de dígitos BIEN y cantidad de dígitos REGULARES  
Un dígito está BIEN cuando coincide también en la posición del número creado al azar.  
Un dígito está REGULAR cuando, formando parte del número generado al azar, no coincide en la posición.
Ejemplo (Número generado al azar: 1234 – oculto para el jugador)  
Jugador ingresa 9130 Sistema responde 1Bien y 1 Regular  
Jugador ingresa 3190 Sistema responde 2 Regulares  
Jugador ingresa 4130 Sistema responde 1 Bien y 2 Regulares  
Jugador ingresa 1034 Sistema responde 3 Bien  
Jugador ingresa 9920 Sistema Responde “Número inválido – No puede haber dígitos  
repetidos”  
Jugador ingresa 1234 Sistema responde CORRECTO en 4 intentos (el intento inválido no se cuenta).
La lista con los números que ingresa el jugador y la respuesta debe estar siempre visible.  

**Entrega 27 de setiembre**
