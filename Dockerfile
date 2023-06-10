FROM mysql:5.7

# Env vars
ENV MYSQL_USER=letmein
ENV MYSQL_PASSWORD=letmein
ENV MYSQL_DATABASE=campuslib
ENV MYSQL_ROOT_PASSWORD=root

# Exposing the port
EXPOSE 3306