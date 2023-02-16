# Inventario Droguería
* Se crea este proyecto con el fin de cumplir los requisitos
que se plantean en la prueba técnica.

# [GitHub Pages](https://github.com/CpuJP/inventario-Drogueria).

## Requerimientos Funcionales
* Se deben poder crear, consultar, actualizar y eliminar los medicamentos.
* filtrar los medicamentos y que se muestre una tabla paginada con
  los resultados.
* Dado el resultado cada fila de medicamento debe tener una columna con la opción
  para vender, editar y eliminar. 
* Si se desea vender se debe mostrar una ventana modal donde solicite la cantidad y
  posteriormente nos indique el valor a pagar de acuerdo con esa cantidad. 
* En el momento que se confirme la venta se debe actualizar el inventario y registrar
  la venta con la siguiente información:
  * Fecha y hora 
  * Medicamento 
  * Cantidad 
  * Valor unitario y valor total 
* Las ventas se pueden consultar y filtrar de acuerdo con un rango de fechas.

## Requerimientos NO Funcionales
* El backend de la aplicación debe estar construido en java 17 con spring boot, basado en
arquitectura de microservicios.
* El front de la aplicación debe estar construido en angular con uso de prime faces. 
* Se valora adicionales pruebas unitarias de front y back, cobertura de código, el uso de la
herramienta sonarlink para el análisis de código estático y que la base de datos se
encuentre en Oracle.