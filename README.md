# VKI_FinalProject
Bu proje, kullanıcının vücut kitle endeksini hesaplamak ve sonuçları Docker'da çalışan bir MySQL veritabanına kaydetmek için Spring Boot kullanılarak geliştirilmiştir.

## Başlarken
İlk olarak, bu projeyi bilgisayarınızda sorunsuz bir şekilde çalıştırmak için aşağıdaki gereksinimleri sahip olduğunuzdan emin olun:

## Gereksinimler
1. Java 20
2. Intelij Idea Ultimate
3. Docker

## Bağımlılıklar
* Spring Data JDBC
* spring Data JPA
* Spring Web
* Spring Boot Devtools
* Mysql Connector J
* Lombok
* Swagger
* Model Mapper

## Kurulum
1. ### Docker Desktop Kurulumu
   [Docker Desktop Download](https://www.docker.com/products/docker-desktop/) Bu linkten Docker Desktop'ı indirin.

2. ### Proje Kurulumu
    1. ```sh
        git clone https://github.com/cdemir7/VKI_FinalProject.git
       ```
   
       İndirdiğiniz klasörü Intelij Idea'da açın.
       


    4.    ```sh
          spring.datasource.url=jdbc:mysql://localhost:3306/VERITABANI_ADI
      
          spring.datasource.username=KULLANICI_ADI
      
          spring.datasource.password=PAROLA
          ```
       

           VERITABANI_ADI, KULLANICI_ADI ve PAROLA değerlerini projedeki
      ```sh
      src/main/resources/application.properties
      ```
      yolundaki application.properties dosyasında değiştirin.

    6. Veritabanında, application.properties dosyasındaki isimle aynı olacak şekilde veritabanı oluşturun.

    7. Intelij Idea'dan projeyi çalıştırın.


3. ## Kullanım
    1. ```sh
       http://localhost:8080/swagger-ui/index.html#/
       ```
       web tarayıcısında yukarıdaki URL'i açın. Burada CRUD işlemlerini gerçekleştirebilirisiniz.

