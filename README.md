1] How did I run the code ?

   - I used Spring Boot for the application.  
   - The project can be run on an IDE like Eclipse with Maven support.  
   - Steps to run:  
     - Clone the repository using git clone command.
     - Open the project in your preferred IDE.  
     - Configure the database connection in the application.properties file (e.g., MySQL).    
     - Run the application using the SpringBootApplication class.
     - 
---------------------------------------------------------------------------

2] How did I run the machine test ?  

   - The application was tested using Postman for API testing.  
   - CRUD operations were performed on Category and Product endpoints to verify functionality.  
   - Test cases included adding, updating, deleting, and fetching entities with relational data.


To implement pagination in a REST API, you can use query parameters to specify the page and size. Here's how the Postman URL for a paginated request might look:

Example URL for Pagination:

http://localhost:8080/api/category?page=0&size=10

Explanation:
page: The page number (zero-based index). For the first page, use page=0.
size: The number of items per page. For 10 items per page, use size=10.



1) Category CRUD operation.

Below are the APIs required to be developed :


1 ]  http://localhost:8080/api/categories           GET all the categories

2 ] http://localhost:8080/api/categories            POST - create a new category

3 ] http://localhost:8080/api/categories/{id}       GET category by Id

4 ] http://localhost:8080/api/categories/{id}       PUT - update category by id

5 ] http://localhost:8080/api/categories/{id}       DELETE - Delete category by id

JSON to Add Category:


{
  "categoryName": "Electronics"
}

----------------------------------------------------------------------------------------------------------------------------------------------
2) Product CRUD operation.

Below are the APIs required to be developed :


1 ]  http://localhost:8080/api/products           GET all the products

2 ]  http://localhost:8080/api/products           POST - create a new product

3 ]  http://localhost:8080/api/products/{id}      GET product by Id

4 ]  http://localhost:8080/api/products/{id}      PUT - update product by id

5 ]  http://localhost:8080/api/products/{id}      DELETE - Delete product by id



JSON to Add Product:

{
  "productName": "ABC",
  "productPrice": 1200,
  "category": {
    "categoryId": 1
  }
}

----------------------------------------------------------------------------------------------------

3 ] Database Design:
  
   - The database consists of two tables:  
     1. Category
        - categoryId (Primary Key)  
        - categoryName
 
     2. Product  
        - productId (Primary Key)  
        - productName  
        - productPrice  
        - categoryId (Foreign Key referencing Category) 
 
   - Relationship:  
     - One-to-Many between Category and Product (a category can have multiple products).
    
------------------------------------------------------------------------------------------------------
