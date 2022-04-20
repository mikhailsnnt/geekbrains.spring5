package ru.geekbrains;

import ru.geekbrains.config.HibernateUtils;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Stream.of(
                new Product("Cola", 100),
                new Product("Baikal", 150),
                new Product("Kvass", 100)
        ).forEach(productRepository::saveOrUpdate);
        System.out.println("All: " + productRepository.findAll());
        Product byId = productRepository.findById(2);
        System.out.printf("Product with id %d: %s\n", 2, byId);
        boolean deletedSuccessfully = productRepository.deleteById(2);
        System.out.printf("Delete by id %d: %s\n", 2, deletedSuccessfully);
        System.out.println("All: " + productRepository.findAll());
        HibernateUtils.closeSessionFactory();
    }
}
