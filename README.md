# prds
This project is simple micro-service. It uses springboot, java 8, H2 database. swagger api for UI explaining endpoints requirements.
Note: h2 db tables should be initialized by default if not then need to add data in tables manually. Follow below instructions for manually adding the data to dbt tables
1) clean install, springboot:run 
2) navigate to https://localhost/8080/h2-console/
3) Connect to h2 db with default values.
4) Copy all from data.sql file and paste it in the console sql editor.
5) run.
You should be able to access these data from the endpoints.
