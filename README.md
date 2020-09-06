# Greeting-card-system
Server rest api for greeting card system

Deployed on: https://greeting-system.herokuapp.com/swagger-ui.html

    GET /api/greetingCard/catalog - Search card by title or text. Return in json format

    PUT /api/greetingCard/catalog - Put command can save new template. In template you have to wright in place where you want make variable $1  $3.  

    POST /api/greetingCard/catalog/{cardId} - Post operation on specific template by ID will create a greeting card.
    The user should send the missing blanks in the template as arguments. $1, $2, $3 will be replaced by filled blanks.
