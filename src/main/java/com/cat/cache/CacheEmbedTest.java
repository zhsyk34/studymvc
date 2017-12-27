//package com.cat.cache;
//
//import org.ehcache.Cache;
//import org.ehcache.CacheManager;
//import org.ehcache.config.builders.CacheManagerBuilder;
//import org.springframework.cache.annotation.Caching;
//
//import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
//import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
//import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;
//
//public class CacheEmbedTest {
//
//    public static void main(String[] args) {
//        String alias = "preConfigured";
//
//        CacheManagerBuilder<CacheManager> builder = newCacheManagerBuilder();
//
//        CacheManager cacheManager = builder.withCache(alias, newCacheConfigurationBuilder(Long.class, String.class, heap(10)))
//                .build();
//
//        //build(true);
//        cacheManager.init();
//
//        Cache<Long, String> cache = cacheManager.getCache(alias, Long.class, String.class);
//
//        Cache<Long, String> myCache = cacheManager.createCache("myCache", newCacheConfigurationBuilder(Long.class, String.class, heap(10)));
//
//        myCache.put(1L, "da one!");
//        String value = myCache.get(1L);
//        System.err.println(value);
//
//        cache.put(2L, "abc");
//        cache.forEach(entry -> System.err.println(entry.getKey() + ":" + entry.getValue()));
//
//        cacheManager.removeCache(alias);
//
//        cacheManager.close();
//
//        try (CacheManager manager = newCacheManagerBuilder()
//                .withCache("preConfigured", newCacheConfigurationBuilder(Long.class, String.class, heap(10)))
//                .build(true)) {
//
//            // Same code as before [...]
//        }
//    }
//
////    private void test2() {
////        CachingProvider provider = Caching.getCachingProvider();
////        CacheManager cacheManager = provider.getCacheManager();
////        MutableConfiguration<Long, String> configuration =
////                new MutableConfiguration<Long, String>()
////                        .setTypes(Long.class, String.class)
////                        .setStoreByValue(false)
////                        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
////        Cache<Long, String> cache = cacheManager.createCache("jCache", configuration);
////        cache.put(1L, "one");
////        String value = cache.get(1L);
////    }
//}
