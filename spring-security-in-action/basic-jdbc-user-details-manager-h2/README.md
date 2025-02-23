## Using curl -u

```shell
curl -u matthew:12345 http://localhost:8080/hello
```

## curl -H

```shell
curl -H "Authorization: Basic $(echo -n "matthew:12345" | base64)" localhost:8080/hello
```

## h2-console
http://locahost:8080/h2-console
