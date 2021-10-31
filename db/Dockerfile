FROM mysql/mysql-server:8.0.26

MAINTAINER lihaifeng(li7hai26@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./dataflux.sql /docker-entrypoint-initdb.d