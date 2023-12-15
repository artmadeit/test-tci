## Notas:

- A que se refiere el atributo estado en Empresa?, estoy suponiendo que es usado para soft-delete, lo he renombrado a isDeleted.
- se agrego createDate (fecha de creación) con el fin de cumplir la funcionalidad: realizar un servicio rest que devuelva una lista con los 3 últimos registros de empresas
- no agregue capa de servicios y dtos, es el ejemplo tan chiquito, que considere no usarlo.
- hay un paquete auth, agregue ese paquete donde esta todo lo relacionado a autenticacion con jwt

## API

En la raiz del proyecto se encuentra un archivo postman. Aunque se pudo agregar swagger, pongo a los curl.

Crear usuario

```bash
curl --location 'http://localhost:8080/auth/signup' \
--header 'Content-Type: application/json' \
--data '{
    "name": "arthur",
    "password": "unpass"
}'
```

Logueo

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "name": "arthur",
    "password": "unpass"
}'
```

=> Devuelve un Bearer token

Obtener empresas

```bash
curl --location 'http://localhost:8080/empresas' \
--header 'Authorization: Bearer {{token}}'
```

Registrar empresa

```bash
curl --location 'http://localhost:8080/empresas' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer {{token}}' \
--data '{
    "ruc": "10736464476",
    "razonSocial": "arthur",
    "direccion": "calle ramon cerdeira 175"
}'
```
