package com.example.i18n;

import org.junit.Test;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author DeYou
 * @date 2023/4/4
 */
public class I18nTest {

	@Test
	public void testMessageSource(){
		ResourceBundleMessageSource rbs = new ResourceBundleMessageSource();
		rbs.setBasename("i18n/message");
		rbs.setDefaultEncoding("UTF-8");
		rbs.setDefaultLocale( Locale.CHINA);
		String hello = rbs.getMessage("hello", new Object[]{"tom"}, Locale.CHINA);
		System.out.println(hello);
	}
}