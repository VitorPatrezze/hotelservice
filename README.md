# Hotel Service
Hotel Service is a API REST project developed for the Trivago interviewing process.

## Running the service

Running the command below on the root folder of the project will create the containers for both the 
application and the PostgreSQL Database.

```bash
# For Mac
run_app.sh

# For Windows
run_app.bat
```
I needed to use `.sh` and `.bash` to guarantee that the project would run 
successfully even without running the `gradle build` method first (to create the `.jar` file).
## Usage
Below are some cURLs used to test and debbug the application, 
but feel free to take a look at the OpenAPI documentation at http://localhost:8080/swagger-ui/index.html

#### Get all items
```agsl
curl --location --request GET 'http://localhost:8080/items'
```

#### Get item by id
```agsl
curl --location --request GET 'http://localhost:8080/items/{id}'
```

#### Get item using city filter
```agsl
curl --location --request GET 'http://localhost:8080/items?city=São Paulo'
```

#### Update item
```agsl
curl --location --request PUT 'http://localhost:8080/items' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name":"Test Hostel",
    "rating": 3,
    "category": "hostel",
    "location":{
        "city": "Campinas",
        "state": "SP",
        "country": "Brazil",
        "zipCode": "12345",
        "address": "ABC street"
    },
    "imagePath": "https://cdn.pixabay.com/photo/2016/10/18/09/02/hotel-1749602_1280.jpg",
    "reputation": 900,
    "price": 15,
    "availability": 7
}'
```

#### Create new item
```agsl
curl --location --request POST 'http://localhost:8080/items' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Test Hotel",
    "rating": 3,
    "category": "hotel",
    "location":{
        "city": "São Paulo",
        "state": "SP",
        "country": "Brazil",
        "zipCode": "12345",
        "address": "ABC Street"
    },
    "imagePath": "https://cdn.pixabay.com/photo/2016/10/18/09/02/hotel-1749602_1280.jpg",
    "reputation": 700,
    "reputationBadge": "green",
    "price": 13,
    "availability": 3
}'
```

#### Book accommodation
```agsl
curl --location --request POST 'http://localhost:8080/items/{id}/book/{amount}'
```

#### Delete Item
```agsl
curl --location --request DELETE 'http://localhost:8080/items/1'
```

## Improvements to be made
Here's a list of improvements to be made in the project:
 - Unit and component tests, this would be the top priority
 - More filters to query items such as state, price, rating, availability and reputation.
 - Receipt table to keep booking receipts.
 - Endpoints to cancel accommodation bookings.
 - Endpoint to check receipts.
 - Cache to improve response time of the server.

There are many more improvements to be made in this application, and they could be 
refined according to the expectations of the clients.