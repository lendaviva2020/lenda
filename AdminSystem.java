import java.util.*;
import java.io.*;

public class AdminSystem {
    private static List<Admin> admins = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static Admin loggedAdmin = null;

    public static void main(String[] args) throws IOException {
        // Dados de exemplo
        admins.add(new Admin("1", "admin@exemplo.com", "1234", true));
        products.add(new Product("p1", "Camiseta", 49.99, "Vestuário"));
        products.add(new Product("p2", "Celular", 999.99, "Eletrônicos"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema Admin ===");
        while (true) {
            if (loggedAdmin == null) {
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                login(email, senha);
            } else {
                System.out.println("\n1) Listar produtos\n2) Adicionar produto\n3) Exportar CSV\n4) Logout\n5) Sair");
                String op = scanner.nextLine();
                if ("1".equals(op)) {
                    listarProdutos();
                } else if ("2".equals(op)) {
                    adicionarProduto(scanner);
                } else if ("3".equals(op)) {
                    exportarCSV();
                } else if ("4".equals(op)) {
                    loggedAdmin = null;
                    System.out.println("Logout realizado.");
                } else if ("5".equals(op)) {
                    System.out.println("Saindo...");
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void login(String email, String senha) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.checkPassword(senha)) {
                loggedAdmin = admin;
                System.out.println("Login OK! Bem-vindo " + admin.getEmail());
                return;
            }
        }
        System.out.println("Login inválido.");
    }

    private static void listarProdutos() {
        System.out.println("Produtos:");
        for (Product p : products) {
            System.out.printf("ID: %s, Nome: %s, Preço: R$ %.2f, Categoria: %s\n",
                    p.getId(), p.getName(), p.getPrice(), p.getCategory());
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        String id = "p" + (products.size() + 1);
        products.add(new Product(id, nome, preco, categoria));
        System.out.println("Produto adicionado.");
    }

    private static void exportarCSV() throws IOException {
        String arquivo = "produtos.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.println("id,nome,preco,categoria");
            for (Product p : products) {
                pw.println(p.toCSV());
            }
        }
        System.out.println("Exportado para " + arquivo);
    }
}