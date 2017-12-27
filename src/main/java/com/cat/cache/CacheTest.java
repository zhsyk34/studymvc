//package com.cat.cache;
//
//import java.net.URL;
//
//public class CacheTest {
//
//    public static void main(String[] args) {
//        URL url = CacheTest.class.getResource("/ehcache.xml");
//        Configuration xmlConfig = new XmlConfiguration(url);
//        CacheManager manager = CacheManagerBuilder.newCacheManager(xmlConfig);
//        manager.init();
//
//        Cache<String, String> cache = manager.getCache("foo", String.class, String.class);
//        System.out.println(cache);
//
//        cache.put("a", "1");
//        System.out.println(cache.get("a"));
//
////        CacheManagerBuilder<PersistentCacheManager> clusteredCacheManagerBuilder =
////                CacheManagerBuilder.newCacheManagerBuilder()
////                        .with(ClusteringServiceConfigurationBuilder.cluster(URI.create("terracotta://localhost:9510/my-application"))
////                                .autoCreate());
////        PersistentCacheManager cacheManager = clusteredCacheManagerBuilder.build(true);
////
////        cacheManager.close();
//    }
//}
