
> cd deployment
> docker-compose up
> docker-compose down
> docker system prune -a // removes any unused containers 
> docker volume prune // removes any unused volumes 
> docker logs some-mysql
> docker exec -it container_id bash // enter a container

# database dumps
> docker exec mysql_container sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > /some/path/on/your/host/all-databases.sql

# restoring data from dump files
> docker exec -i mysql_container sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < /some/path/on/your/host/all-databases.sql

# connect to mysql
> mysql -h host -u user -p menagerie

> show databases;
> use database_name
