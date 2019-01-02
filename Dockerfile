FROM ubuntu:16.04

RUN apt-get -qq -y update && \
    apt-get -qq -y install openjdk-8-jdk maven gradle curl && \
    rm -rf /var/cache/apt /var/lib/apt/lists/*

ADD src /bus_challenge/src
ADD data /bus_challenge/data
ADD service.sh /bus_challenge/service.sh
ADD pom.xml /bus_challenge/pom.xml
WORKDIR bus_challenge
RUN ./service.sh dev_build
CMD ["/bus_challenge/service.sh", "dev_run", "--route_data.path=/bus_challenge/data/example"]