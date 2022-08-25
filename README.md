# code-test-v1

How to :
1. preparation database
    1. `create database alami_db_test`
    2. `create user ari_user with encrypted password 'ari_password';`
    3. `grant all privileges on database alami_db_test to ari_user;`
    
2. run both DDL & DML scripts on `/src/test/resources/InitData.sql`
3. run application with `mvn spring-boot:run`
4. postman  `ALAMI-CODE-TEST.postman_collection.json`