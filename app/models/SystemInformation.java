package models;

public class SystemInformation {
    private String hosname, ip_address;
    private long heapSize, heapMaxSize, heapFreeSize, ramSize;
    private int cpu_core;

    public SystemInformation(){}

    public SystemInformation(String hosname, String ip_address, long heapSize, long heapMaxSize, long heapFreeSize, long ramSize, int cpu_core) {
        this.hosname = hosname;
        this.ip_address = ip_address;
        this.heapSize = heapSize;
        this.heapMaxSize = heapMaxSize;
        this.heapFreeSize = heapFreeSize;
        this.ramSize = ramSize;
        this.cpu_core = cpu_core;
    }

    public String getHosname() {
        return hosname;
    }

    public SystemInformation setHosname(String hosname) {
        this.hosname = hosname;
        return this;
    }

    public String getIp_address() {
        return ip_address;
    }

    public SystemInformation setIp_address(String ip_address) {
        this.ip_address = ip_address;
        return this;
    }

    public long getHeapSize() {
        return heapSize;
    }

    public SystemInformation setHeapSize(long heapSize) {
        this.heapSize = heapSize;
        return this;
    }

    public long getHeapMaxSize() {
        return heapMaxSize;
    }

    public SystemInformation setHeapMaxSize(long heapMaxSize) {
        this.heapMaxSize = heapMaxSize;
        return this;
    }

    public long getHeapFreeSize() {
        return heapFreeSize;
    }

    public SystemInformation setHeapFreeSize(long heapFreeSize) {
        this.heapFreeSize = heapFreeSize;
        return this;
    }

    public long getRamSize() {
        return ramSize;
    }

    public SystemInformation setRamSize(long ramSize) {
        this.ramSize = ramSize;
        return this;
    }

    public int getCpu_core() {
        return cpu_core;
    }

    public SystemInformation setCpu_core(int cpu_core) {
        this.cpu_core = cpu_core;
        return this;
    }

    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }
}
