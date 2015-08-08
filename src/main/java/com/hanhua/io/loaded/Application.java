package com.hanhua.io.loaded;

import java.net.UnknownHostException;

import org.apache.catalina.connector.Connector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author lewis 启动项目入口
 */
@SpringBootApplication
public class Application {

	private static Log log = LogFactory.getLog(Application.class);

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			public void customize(ConfigurableEmbeddedServletContainer container) {
				TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
				tomcat.addConnectorCustomizers(new TomcatConnectorCustomizer() {
					public void customize(Connector connector) {
						connector.setPort(8081);
						container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
						container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
					}
				});
			};
		};
	}

	public static void main(String[] args) throws UnknownHostException {
		log.info("开始启动服务器。。。。。。。。。。。。。");
		SpringApplication app = new SpringApplication(Application.class);
		Environment env = app.run(args).getEnvironment();
		System.out.println(env);
		log.info("服务器已经启动。。。。。。。。。。。。。");
	}
}
