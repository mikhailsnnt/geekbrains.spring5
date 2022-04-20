package ru.geekbrains.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.geekbrains.config.HibernateUtils;
import ru.geekbrains.model.Product;

import java.util.List;

public class ProductRepository {


    public Product findById(long id) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        transaction.commit();
        return product;
    }

    public List<Product> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = session.createQuery("select p from Product p", Product.class).list();
        transaction.commit();
        return products;
    }

    public boolean deleteById(long id) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        int res = session.createQuery("delete Product where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        return res > 0;
    }

    public void saveOrUpdate(Product product){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
    }
}
