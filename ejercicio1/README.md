#Ejercicio1

1.- Hacer una clase Calculadora de números naturales (enteros >=0) que ofrezca los siguientes métodos:
- sumar(int a, int b) : int
- restar(int a, int b) : int
- multiplicar(int a, int b) : int
- dividir(int a, int b) : int

Manejar las posibles excepciones que puedan existir con clases personalizadas e implementar su prueba correspondiente.

```
Calculadora calc = new Calculadora();
int a = calc.sumar(8, 10);
int b = calc.restar(20, a);
int c = calc.restar(2, 2);
int d = calc.dividir(a, c);
```

2.- Implementar la prueba unitaria y DAO para persistir con JPA objetos del tipo Todo (titulo, descripción, fecha y estatus). 
- Realizar implementación dummy
- Utilizar bases de datos en memoria
