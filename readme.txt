
## 🐳 Step-by-Step: Run Kafka with Docker & Test Spring Boot Projects

### ✅ **Step 1: Start Kafka and Zookeeper with Docker**

In your terminal, run:

```bash
docker network create kafka-net

docker run -d --name zookeeper --network kafka-net -p 2181:2181 zookeeper

docker run -d --name kafka --network kafka-net -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 wurstmeister/kafka
```

⏱️ Wait a few seconds for containers to be up.

---

### ✅ **Step 2: Verify Kafka is Running**

Run this to list topics (no need to create manually if auto-creation is on):

```bash
docker exec -it kafka bash
cd /opt/kafka_*/bin
./kafka-topics.sh --bootstrap-server localhost:9092 --list
```

You can also create the topic manually if needed:

```bash
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic demo_topic
```

Then exit:

```bash
exit
```

---

### ✅ **Step 3: Run Spring Boot Apps**

You now have Kafka running. Run both Spring Boot projects In Terminal:

Open two terminals:

**1 for Producer:**

```bash
cd producer
mvn spring-boot:run
```

**2 for Consumer:**

```bash
cd consumer
mvn spring-boot:run
```

#### 🛠 Or, in STS/IntelliJ:

Just import both projects and click **Run** on `ProducerApplication` and `ConsumerApplication`.

---

### ✅ **Step 4: Send Message to Kafka**

Now use **curl** or **Postman**:

```bash
curl -X POST "http://localhost:8080/kafka/publish?message=HelloFromDocker"
```

---

### ✅ **Step 5: See the Output in Consumer Console**

You should see:

```
Consumed message: HelloFromDocker
```

---

## 🧹 Optional: Stop Docker Containers

```bash
docker stop kafka zookeeper
docker rm kafka zookeeper
docker network rm kafka-net
```

---

