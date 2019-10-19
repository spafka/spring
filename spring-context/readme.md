applicationContext refesh // 重新构建bean
   org.springframework.context.annotation.ConfigurationClassParser.doProcessConfigurationClass // 扫描bean
     org.springframework.beans.factory.support.AbstractBeanFactory.getBean(java.lang.String) //初始化bean
       org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance // 反射构造bean 
         org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement.inject // 如果需要注入就注入