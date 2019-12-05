package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.management.OperatingSystemMXBean;
import models.SystemInformation;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeController extends Controller {
    private InetAddress inetAddress;
    private SystemInformation information;

    {
        try {
            inetAddress = InetAddress.getLocalHost();
            // Get current size of heap in bytes

            long ramSize = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();

            int core_num = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();

            information = new SystemInformation()
                    .setHosname(inetAddress.getHostName())
                    .setIp_address(inetAddress.getHostAddress())
                    .setCpu_core(core_num)
                    .setRamSize(ramSize);

            refreshInfo();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public Result index() {
        refreshInfo();
        return ok(views.html.hello.render(information));
    }

    public Result whoami() {
        refreshInfo();
        return ok(Json.toJson(information));
    }

    public Result getIP() {
        return ok(information.getIp_address());
    }

    public Result getHostname() {
        return ok(information.getHosname());
    }

    public Result getHost() {
        return ok(inetAddress.toString());
    }

    public Result startOOM(){
        Logger.error("Starting...");
        int heavy_number = Integer.MAX_VALUE/200;
        List<long[]> list = new LinkedList<>();
        while (true) {
            list.add(new long[heavy_number]); // an arbitrary number
            try {
                Logger.warn("Pause 5s");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshInfo(){
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        information.setHeapFreeSize(heapFreeSize)
                .setHeapMaxSize(heapMaxSize)
                .setHeapSize(heapSize);
    }
}
