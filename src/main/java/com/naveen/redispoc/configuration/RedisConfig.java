package com.naveen.redispoc.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.jcache.config.JCacheConfigurer;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig extends JCacheConfigurerSupport implements JCacheConfigurer {
	
	@Override
	public CacheErrorHandler errorHandler()
	{
		return new CacheErrorHandler() {
			
			@Override
			public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
				// TODO Auto-generated method stub-
				
			}
			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleCacheClearError(RuntimeException exception, Cache cache) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
