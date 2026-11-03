# Castle

## Create DB

```sh
docker --context docker-on-tower compose --file remote-ansible.yml run --rm --build create-db
```

## Setup App

```sh
docker --context docker-on-tower compose --file remote-ansible.yml run --rm --build setup-app
```
