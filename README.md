# pelicula-catalogo_micro-servicio
Eureka Client |  MicroServicio que permite obtener los datos de una pelicula, junto a los rating de cada uno de ellas vista por el usuario


| Eureka Clients                   | -> | Eureka Server | <- |   Eureka Clients             |
|:--------------------------------:|----|---------------|----|------------------------------|
|  pelicula-catalogo_micro-servicio| -> |               | <- |  rating-data_micro-servicio  |
|                                  |    |               |    |  pelicula-info_micro-servicio|
|                                  |    |               |    |                              |
