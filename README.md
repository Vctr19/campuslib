# campuslib
#### web-app gestor de livros de uma biblioteca escolar
### Como inicializar o projeto
#### 1 - Com o docker instalado na máquina, execute o comando a seguir para criar uma imagem Docker com base no Dockerfile:
```bash
docker build -t campuslib_db .
```
#### 2 - Após a conclusão da construção da imagem, você pode executar o contêiner com base nessa imagem usando o seguinte comando:
```bash
docker run -p 3306:3306 --name campuslib_db campuslib_db
```