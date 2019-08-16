# 分布式ID
```$xslt
        <dependency>
            <groupId>com.github.ddphin</groupId>
            <artifactId>ddphin-id-spring-boot-starter</artifactId>            
            <version>1.0.0</version>
        </dependency>
```
## 功能
`ddphin-id`基于雪花算法和环境变量，提供一个分布式id生成功能

## 使用
- 设置环境变量
   - DATA_CENTER_ID
   - WORKER_ID
   <br> 建议使用docker或者k8s或者zookeeper进行动态设置，下面给出一个docker的简单列子
   ```$xslt
   docker run -d --name ${appName} -p ${appPort}:8080 \
          -v ${appHome}/logs:/logs \
          -v /etc/localtime:/etc/localtime \
          -e DATA_CENTER_ID=${DATA_CENTER_ID} \
          -e WORKER_ID=${WORKER_ID} \
          ${imageName}:${imageTag}

   ```
- 继承`IDWorkerAware`
  <br>继承`IDWorkerAware`获得四个分布式ID生成方法：
  - `long nextId()`：
  - `String nextIdWtihTimestampPrefix(String pattern, int digits, int radix)`
  - `String nextIdWtihCustomizedPrefix(String prefix, int digits, int radix)`
  - `String nextIdWtihCustomizedPrefix(long prefix, int prefixRadix, int prefixDigits, int digits, int radix)`
     - pattern: 时间前缀的格式，如：yyyyMMdd
     - digits: 除去前缀，ID的位数
     - radix： ID的进制
     - prefixRadix： 前缀的进制
     - prefixDigits： 前缀的位数
   <br>
   <br>一般，不同类的entity之间可以id相同，同类的entity之间id不能相同
   <br>每个继承IDWorkerAware的类都将使用一个独立的ID生成器获取ID

## 举例
[请查看 ddphin-id-spring-boot-samples](https://github.com/ddphin/ddphin-id-spring-boot/tree/master/ddphin-id-spring-boot-samples)   