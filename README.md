# gedid 
Generate distributed and orderly id generate thread safety system.

# How to use?

- Step 1: init GedidLoader

```java
GedidLoader loader = GedidLoader.init(GedidConfig.defaultConfig());
```

- Step2: follow business with name

```java
Gedid user = loader.follow("user");
```

- Step3: get business id

```java
long id = user.next();
```