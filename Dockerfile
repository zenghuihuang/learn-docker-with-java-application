FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Cell.java
RUN javac Player.java
RUN javac Boardgame.java
RUN javac SnakesAndLadderController.java
CMD ["java", "SnakesAndLadderController"]