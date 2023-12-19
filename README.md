Steps to set up and run the project:

-> After installing docker, run this command to run Redis container:
docker run -it --rm --name your_name -p 6379:6379 redis

-> Script to run the project on a linux machine is named run_script:

# Make the script executable:
chmod +x run_script.sh

 # Run it 
./run_application.sh
