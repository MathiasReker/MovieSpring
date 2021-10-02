## Installing

### Step 1 - download project:
```
git clone git@github.com:MathiasReker/MovieSpring.git && cd MovieSpring
```

### Step 2 - install database:
```
mysql --local-infile=1 -h 127.0.0.1 -P 3306 -u root -p < ./install/install.sql
```

### Step 3 - set properties:
```
nano ./src/main/resources/application.properties
```

### Step 4 - build:
```
mvn install
```

### Step 5 - run:
```
mvn spring-boot:run
```

## Requirements
```
JDK 17
```

## Testing

```
wget -q -O - localhost:8080
wget -q -O - localhost:8080/getFirst
wget -q -O - localhost:8080/getRandom
wget -q -O - localhost:8080/getTenSortByPopularity
wget -q -O - localhost:8080/howManyWonAnAward
wget -q -O - localhost:8080/comedy
```

## Contributors

* [@MathiasReker](https://github.com/MathiasReker)
