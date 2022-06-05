# Este es el juego Dominó

###### Está creado en Java, es nuestro proyecto final de tercer semestre de ingeniería de sistemas (Programación 2)

Es un juego que tendrá una interfaz gráfica en la que el jugador tendrá la posibilidad de jugar contra la máquina, la cual jugará a ganar.

------------
### Vista Previa

------------

### Reglas del Juego

El dominó es un juego en el cual se tienen 28 fichas con diferentes combinaciones, desde el 0 hasta el 6, creando fichas con un valor por cada lado, teniendo, por ejemplo, fichas de 6 | 6, 0 | 1 o 2 | 3. El juego es simple, así como sus reglas. De esas 28 fichas, se reparten 7 a cada jugador - suele jugarse de entre dos a cuatro jugadores. En este caso será un jugador contra la máquina, la cuál jugará a ganar.

El primero que tenga la combinación de 6 | 6 empieza, ya, en caso de que ningún jugador lo haga, se va bajando en combinaciones iguales, es decir, 5 | 5, 4 | 4..., y, en caso de que ninguno tenga alguna de ellas, se comienza bajando por la mayor suma de cada parte de la pieza, por ejemplo, 6 | 5, 6 | 4...

Cada jugador debe ver si tiene una ficha en la cual alguna de sus partes case en una ficha extrema del juego (las que solo tienen una sola unión); en caso de que lo tenga, deberá oprimir el número respectivo a la posición de la ficha en su baraja.

El juego acaba cuando alguno de los jugadores se quede sin fichas o ninguno se quede con movimientos disponibles, en momento del último caso, se ve qué jugador tiene la menor sumatoria de puntos y este será el ganador.

------------
