
# API RESTful Estacionamento

Baseado em um exercicio encontrado desenvolvi uma leitura dele com Spring e Hibernate.

O sistema tem como casos de uso basicos 5 atividades, entre elas:
- Registrar a entrada de um veiculo
- Registrar a saida de um veiculo.
- Registrar um veiculo oficial
- Registrar um veiculo residente
- Começar o mês

 ``` 
    {
        "id": 3,
        "moment": "2024-10-09T03:36:23.366855Z",
        "placa": "OIU6506",
        "saida": {
            "id": 3,
            "moment": "2024-10-09T03:42:45.496793Z"
        },
        "hours": 0,
        "total": 0.0
    }
``` 

### Registrar a entrada

    1. O empregado registra um a entrada de um veiculo e informa a placa do veiculo.
    2. A aplicação deve registrar a hora da entrada. 

| Dado | Tipo | Obs. |
|---|---|---|
| id | Long | Gerado |
| moment | Instanst | Hora de saida do veiculo |
| placa | String | Placa do veiculo |
| hours | Integer | Total de horas entre entrada e saida |
| total | Double | Valor das horas |
| saida | Saida | Chave estrangeira para a saida |

```
{
    "id": 3,
    "moment": "2024-10-09T03:42:45.496793Z"
}
```

### Registrar a saida

    1. O empregado registra a saida do veículo.
    1. O sistema então registra hora de saida, bem como as horas que durou e o valor a ser pago.

| Dado | Tipo | Obs. |
|---|---|---|
| id | Long | Gerado |
| moment | Instant | Hora de saida do veiculo |

```
{
    "id": 1,
    "placa": "AEH9493",
    "comandas": []
}
```
### Registrar Oficial

    1. O empregado registra um veículo como oficial e cadastra sua placa.
    2. Veiculos oficiais não pagam pelo serviço, mas geram entradas e saida para controle.

| Dado | Tipo | Obs. |
|---|---|---|
| id | Long | Gerado |
| placa | String | Placa do veículo |
| comandas | List<Entrada> | Lista de entradas do veículo |

```
{
    "id": 2,
    "placa": "OIU6506",
    "comandas": []
}
```
### Registrar Residente

    1. O empregado registra um veículo como residente e cadastra sua placa.
    2. Veiculos residentes possuem um coleção de entradas que devem ser pagas ao fim do mês.

| Dado | Tipo | Obs. |
|---|---|---|
| id | Long | Gerado |
| placa | String | Placa do veículo |
| comandas | List<Entrada> | Lista de entradas do veículo |

```
{
    "id": 1,
    "placa": "GUT4037",
    "tempoTotal": 0,
    "totalPagar": 0.0,
    "comandas": []
}
```


### Começar o mês

    1. Executa a deleção das entradas registradas para veículos oficiais e residentes.

