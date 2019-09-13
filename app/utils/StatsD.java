//package utils;
//
//import com.timgroup.statsd.NonBlockingStatsDClient;
//import com.timgroup.statsd.StatsDClient;
//import com.typesafe.config.Config;
//
//import javax.inject.Inject;
//
//public class StatsD {
//    private static StatsD ourInstance = new StatsD();
//    private StatsDClient statsd;
//
//    private Config config;
//    @Inject
//    private StatsD(Config config){
//        this.config = config;
//    }
//
//    public static StatsD getInstance() {
//        return ourInstance;
//    }
//
//    private StatsD() {
//        statsd = new NonBlockingStatsDClient(
//                config.getString("play.statsd.datadog.prefix"),
//                config.getString("play.statsd.datadog.addr"),
//                config.getInt("play.statsd.datadog.port"),
//                config.getString("play.statsd.datadog.default_tags"));
//    }
//
//    public StatsDClient getClient(){
//        return statsd;
//    }
//}
