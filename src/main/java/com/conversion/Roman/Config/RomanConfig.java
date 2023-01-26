package com.conversion.Roman.Config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class RomanConfig {

	@Bean
	public Docket postsNumberToRomanApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPathsForRomanNumerals()).build();
	}
	@Bean
	public Docket postsRomanToNumericApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPathsForNumber()).build();
	}

	private com.google.common.base.Predicate<String> postPathsForRomanNumerals() {
		return or(regex("/numerictoroman.*"), regex("/numerictoroman.*"));
	}
	private com.google.common.base.Predicate<String> postPathsForNumber() {
		return or(regex("/romantonumeric.*"), regex("/romantonumeric.*"));
	}

	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RomanNumerals API")
				.description("RomanNumerals API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.contact("sandeep.mohanty6@gmail.com").license("RomanNumerals")
				.licenseUrl("sandeep.mohanty6@gmail.com").version("1.0").build();
	}
}
