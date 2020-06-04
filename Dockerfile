FROM mongo:3.4
COPY mongo-init.js /docker-entrypoint-initdb.d/