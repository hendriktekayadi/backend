package dev.factory.dao;

import dev.factory.model.Product;
import dev.factory.model.SalesOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    public Product findOne(Long productId) {
        Session session = sessionFactory.getCurrentSession();
        return (Product)session.load(Product.class, productId);
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    public Product findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        return (Product)session.createQuery("from Product where code = :code")
                .setParameter("code", code)
                .uniqueResult();
    }

    public void delete(Product product)   {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

}
