# Biskot
Biskot is a REST-API-based application responsible for managing the cart of an e-commerce website.

## 🔥 Your mission, should you choose to accept it, is to

* Implement the endpoints specified in the [cart.yaml](contract/cart.yaml) file api contract.
* Include the development best practices you consider appropriate for this exercise.

## 📝 Expected output example

To give you an idea of what is the expected result from each endpoint looks like, below some examples:

> #### action: POST /carts
> response http code: `201` <br>
> response header: `Location: http://localhost:8080/carts/a918b705-0639-4eb4-a17e-bffb2f2b3e4a`

> #### action: GET /carts/{cartId}
> response http code: 200
>
> response body:
>```json
>{
>  "id": 1,
>  "products": [
>    {
>      "id": 1,
>      "label": "Déodorant Spray 200ml Ice Dive ADIDAS",
>      "quantity": 1,
>      "unit_price": 2.00,
>      "line_price": 2.00
>    }
>  ],
>  "totalPrice": 6.00
>}
>```    

> #### action: PUT /carts/{cartId}/products
> response http code: 200
> request body:
> ```json
> {
>    "id": 1,
>    "quantity": 2
>  }
>```

## 📌 Additional considerations
- Biskot has a dependency with an external service allowing you to retrieve products information. A mock server is
  configured in [ProductMockServer](src/main/java/com/biskot/cart/mock/ProductMockServer.java) and products can be
  retrieved at: http://localhost:9001/products/{productId} (productId values range from 1 to 4)
- This project has been spun up with Java 21 and Spring-Boot 3, feel free to downgrade to any versions you're
  more comfortable with
- You can leverage springdoc openapi to visualize and test the api by reaching to http://localhost:8080/swagger-ui.html
- There is a Maven plugin configured to generate Java code from the API specification, use it judiciously
