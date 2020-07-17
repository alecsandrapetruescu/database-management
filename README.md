## 
Application with Spring Boot, Spring JDBC, Hibernate, Mysql running in a Docker container

#### Prerequisites
- [Docker](https://www.docker.com/). Build and push images [install guide](https://docs.docker.com/install/)

###### docker commands
```
> cd deployment // folder for docker-compose.yml

> docker-compose up

> docker-compose down

> docker system prune -a // removes any unused containers 

> docker volume prune // removes any unused volumes 

> docker logs container_id // preivew container logs

> docker exec -it container_id bash // enter a container
```

###### generate a database dump
```
> docker exec mysql_container sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > /path/on/your/host/all-databases.sql
```
###### restoring data from dump files
```
> docker exec -i mysql_container sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < /path/on/your/host/all-databases.sql
```
#### connect to mysql
```
> mysql -h host -u user -p password

> show databases;

> use database_name
```