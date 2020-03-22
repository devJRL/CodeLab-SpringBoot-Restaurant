# EatGo REST API

### Environment

- Server Port : **8080**
- [**HTTPie**](https://httpie.org/#installation)

## Restaurant

> **READ** : List of Restaurants  
> `http GET localhost:8080/restaurants`

> **CREATE** : Add a Restaurant  
> `http POST localhost:8080/restaurants restaurantName={value} restaurantAddress={value}`

> **PATCH** : Edit a Restaurant
> `http PATCH localhost:8080/restaurants restaurantName={value} restaurantAddress={value}`

```bash
# READ
http GET localhost:8080/restaurants

# CREATE
http POST localhost:8080/restaurants restaurantName=BabZip restaurantAddress=Seoul
http POST localhost:8080/restaurants restaurantName=PastaZip restaurantAddress=Dockdo

# PATCH
http PATCH localhost:8080/restaurants/1 restaurantName=ChickenZip restaurantAddress=Busan
```