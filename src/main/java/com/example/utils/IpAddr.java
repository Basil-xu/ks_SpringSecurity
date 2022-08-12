package com.example.utils;

import javax.servlet.http.HttpServletRequest;

public class IpAddr {
    /***
     *
     * @param request
     * @return ipAddr
     * @throws Exception
     */
    public static String getIpAddr(HttpServletRequest request) throws Exception {
        String ipAddr = request.getHeader("x-forwarded-for");
        if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
            ipAddr = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
            ipAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
            ipAddr = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
            ipAddr = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
            ipAddr = request.getRemoteAddr();
        }
        if (ipAddr.equals("0:0:0:0:0:0:0:1")) {
            ipAddr = "127.0.0.1";
            // "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
        }
        return ipAddr;
    }
}
