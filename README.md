# Loja Backend Administrativo em Java (Spring Boot)

## Endpoints REST

- `/api/products` CRUD de produtos
- `/api/users` CRUD de usuários/admin
- `/api/auth/login` Autenticação (JWT)
- `/api/export/products/csv` Exportar produtos em CSV

## Como rodar

1. Instale Java 17+ e Maven.
2. Rode:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse `http://localhost:8080/h2-console` para ver o banco H2 em memória.

## Exemplos de uso

- **Login:**  
  POST `/api/auth/login`  
  ```json
  {
    "email": "admin@exemplo.com",
    "password": "1234"
  }
  ```
- **Listar produtos:**  
  GET `/api/products`
- **Exportar produtos:**  
  GET `/api/export/products/csv`

---

Pronto para expansão: adicione vendas, relatórios, permissões, etc.