## Using curl -u

```shell
curl -u mathew:12345 http://localhost:8080/hello
```

## curl -H

```shell
curl -H "Authorization: Basic $(echo -n "matthew:12345" | base64)" localhost:8080/hello
```