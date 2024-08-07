# WebFlux WebSocket Chat: The Chat Application as a Message Hub

<br>

## Overview
This project is a <strong>sophisticated chat application</strong> built using <strong>Spring WebFlux</strong> and <strong>WebSocket.</strong> 
<mark><strong>It leverages RTopicReactive for real-time message broadcasting</strong></mark> and <mark><strong>RListReactive for persisting chat history.</mark></strong>
The application ensures efficient,non-blocking communication, making it scalable and responsive.
By combining <strong>Reactive Programming</strong> with <strong>WebSocket</strong>, it offers an optimized chat experience, suitable for <strong>high-concurrency environments.</strong>
This setup ensures that <mark>all messages are broadcasted in real-time to all connected clients while maintaining a complete history of conversations.</mark>
  
## Usages
-  WebFlux WebSocket
- Redisson "Redis"

## Architecture of the Project

 ### 1-src folder
   - Configration
   - Service
     
 ### 2-resources folder
   #### 2.1 static
   - chat.html
   
### 2-Maven pom.xml
<br> 
    
```
	<dependencies>
		<dependency>
			<groupId>org.redisson</groupId>
			<artifactId>redisson-spring-boot-starter</artifactId>
			<version>3.16.6</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
 ```

<br>

###### Output :star_struck:

<img width="1396" alt="chat-1" src="https://github.com/user-attachments/assets/10ae0b3f-59f5-4d49-80a7-8fa2949ddce1">

<img width="1159" alt="chat-2" src="https://github.com/user-attachments/assets/11372d2f-5056-4b11-9565-5c9be1007411">

<img width="1270" alt="chat-3" src="https://github.com/user-attachments/assets/1d1ec4dd-2513-4295-9d6e-d1f129641441">

---


### Good Luck <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"> 




