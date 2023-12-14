# Smart Price Detector
Lombok, Model Mapper, GSON and H2 database used to build this project. Created bash script to help users/developers.
To run the application, you just need to run `./project-dev code-run`.
Here is an example to test API while running
```sh
curl --location --request GET 'http://localhost:8080/0.0.1/test' \
--header 'Content-Type: application/json' \
--data '{
    "date": "2020-06-15T21:00:00Z",
    "product_id": 35455,
    "brand_id": 1
}'
```
Use `./project-dev test-coverage-report` command to run unit tests. That command will run all unit tests and will give you an visual output which indicates how many percentage of tests are covered.
To build JAR file `./project-dev build-jar`
