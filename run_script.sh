# Command to run Redis container
docker run -it --rm --name your_name -p 6379:6379 redis

git clone https://github.com/Rediana11/swisscom-task/tree/master
cd swisscom-task

# Build the Spring Boot application
./mvnw clean package

# Run the application
java -jar -Dspring.profiles.active=dev /path/to/swisscom-task.jar
