# RECIPE API
This is a server app to help you manage your ingredients and recipes and make the best use of what you have :)

The API creates your own session when you call
* /new
This will return a session ID you need to use to interact with the API

Example:
* /738123/recipes#GET  (returns all recipes and their basic information)
* /738123/recipes/pasta-carbonara#GET (returns details for pasta carbonara recipe)
* /738123/suggest-recipe#POST  (returns recipes and their basic information based on ingredients you have)
* /738123/my-ingredients#POST (updates your available ingredients)