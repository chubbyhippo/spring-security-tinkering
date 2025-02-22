## Using curl -u
```shell
curl -u user:password http://localhost:8080/hello
```
## Convert to base64
```shell
echo -n user:password | base64
```
## curl -H
```shell
curl -H "Authorization: Basic $(echo -n "user:password" | base64)" localhost:8080/hello
```