# Paradoja del cumpleaños

Establece que de un conjunto de 23 personas, hay una probabilidad del 50,7% de que al menos dos personas de ellas cumplan años el mismo día. Para 57 o más personas la probabilidad es mayor del 99,666%. Más sobre el problema: [Wikipedia](https://es.wikipedia.org/wiki/Paradoja_del_cumplea%C3%B1os)

Representacion grafica para valores 23 cumpleaños (50,7%) y 41 (90,3%)

![](https://i.imgur.com/GowSXED.gif)

## Algoritmo en java utilizando Streams  
Generamos numeros al azar desde 1 hasta 365

```java 
Random random = new Random();
random.ints(23, 1, 365); // genera 23 numeros random (devuelve stream)
```
En ```duplicados``` guardamos todos los valores duplicados que se han generado random. Este enfoque declarativo nos permite evitar ciclos for.
```java
 List<Integer> duplicados = random.ints(23, 1, 365)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
```