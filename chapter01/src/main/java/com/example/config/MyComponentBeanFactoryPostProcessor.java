package com.example.config;

import com.example.annotation.MyComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@Component
public class MyComponentBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider( false );
		scanner.addIncludeFilter( new AnnotationTypeFilter( MyComponent.class) );
		for (BeanDefinition beanDefinition  : scanner.findCandidateComponents( "com.example" )) {
			((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(beanDefinition.getBeanClassName(),
					BeanDefinitionBuilder.genericBeanDefinition(beanDefinition.getBeanClassName()).getBeanDefinition());
		}

	}
}