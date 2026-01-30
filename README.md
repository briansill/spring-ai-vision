# SPRING AI LEARNING - Image Processing

### Purpose

Learn Java Spring AI and how to make API calls to OpenAI programmatically

### Goal
Create an API that can accept a Question and an Image.  Take this request, programmatically call OpenAI to answer the question about the image provide. Return results to caller.

### Dependencies
You will need to sign-up for an API key for OpenAI.  This is set when the servcie is launched using an environment variable `OPENAI_API_KEY`

### Potential Use Cases
Catalogue your photos
  1. Stand up this API.
  2. Create a separate program to sweep your "Pictures" folders
  3. Call the API with the question "Describe what you see in this image".
  4. Store results in a database table with description and image and you know have a searchable Database of your photos.

### Retrospective on learning activity
Base64 encoded string provided a nice way to handle images in json.  It will be up to the Frontend dev to convert image to json.
Thanks to Spring Framework Guru - John Thompson for the great course "Spring AI: Beginner to Guru"

### Deployment on ECR



