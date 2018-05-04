package top.macaulish.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.macaulish.orm.MonitorInfoEntity;


@Component
public class MonitorDao {

    @Autowired
    private HibernateTemplate hibernate;

    @Transactional
    public void addMonitorInfo(MonitorInfoEntity monitorInfo){
        hibernate.save(monitorInfo);
    }
}
