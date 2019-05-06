FROM java:8-jre-alpine
ADD rrhh-backend*jar /opt/
EXPOSE 8080
RUN apk --update add fontconfig ttf-dejavu
CMD java -jar /opt/rrhh-backend*jar