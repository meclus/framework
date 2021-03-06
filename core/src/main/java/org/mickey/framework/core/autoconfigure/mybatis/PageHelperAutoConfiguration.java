package org.mickey.framework.core.autoconfigure.mybatis;

import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mickey.framework.core.mybatis.interceptor.ChainedInterceptor;
import org.mickey.framework.core.mybatis.interceptor.NamedWrapperInterceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
@Slf4j
@Configuration
@ConditionalOnBean(SqlSessionFactory.class)
@EnableConfigurationProperties(PageHelperProperties.class)
@AutoConfigureAfter(MybatisAutoConfiguration.class)
//@AutoConfigureBefore(ChainedMybatisInterceptorConfiguration.class)
public class PageHelperAutoConfiguration implements EnvironmentAware {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @Autowired
    private PageHelperProperties pageHelperProperties;

//    private RelaxedPropertyResolver resolver;
    private Environment environment;

    @Resource
    private ChainedInterceptor chainedInterceptor;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
//        resolver = new RelaxedPropertyResolver(environment, "pagehelper.");
    }

    @PostConstruct
    public void addPageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
//        Properties properties = pageHelperProperties.getProperties();
//        Map<String, Object> subProperties = resolver.getSubProperties("");
//        for (String key : subProperties.keySet()) {
//            if (!properties.containsKey(key)) {
//                properties.setProperty(key, resolver.getProperty(key));
//            }
//        }
//        DbInspectorProperties dbInspectorProperties = Binder.get(environment)
//                .bind(SystemConstant.FRAMEWORK_NS + SystemConstant.DOT + "db-inspector", DbInspectorProperties.class)
//                .orElseCreate(DbInspectorProperties.class);
        pageHelperProperties = Binder.get(environment)
                .bind("pagehelper", PageHelperProperties.class)
                .orElseCreate(PageHelperProperties.class);

        interceptor.setProperties(pageHelperProperties.getProperties());
        chainedInterceptor.addInterceptor(ChainedInterceptor.PAGE_HELPER_ORDER, new NamedWrapperInterceptor("page-helper", interceptor));
//		for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
//			sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
//		}
    }

}

