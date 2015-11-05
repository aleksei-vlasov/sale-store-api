package com.solidsystems.avlasov.backend.beans.data.manager.impl;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;
import com.solidsystems.avlasov.backend.beans.data.manager.ProductDataManager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Vlasov on 02.11.15.
 */

@Repository("productDataManager")
@Transactional
public class ProductDataManagerImpl implements ProductDataManager {

    @Autowired
    private SessionFactory sessionFactory;

    public Product read(Long id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public Long save(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        if(entity.getId() == null)
            return (Long) session.save(entity);
        session.update(entity);
        return entity.getId();
    }

    public void delete(Product entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Product> list() {
        Query query = sessionFactory.getCurrentSession().createQuery(HQL_GET_OBJECT_LIST);
        query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Product> list = query.list();
        if(list == null)
            return new ArrayList<Product>();
        return list;
    }

    public String echoService() {
        return "echo!!!";
    }

}
