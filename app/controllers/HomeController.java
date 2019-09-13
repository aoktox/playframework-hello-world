package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HomeController extends Controller {
    private InetAddress inetAddress;

    {
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public Result index(String format){
        if (!"json".equalsIgnoreCase(format))
            return ok(views.html.hello.render(inetAddress.getHostAddress(), inetAddress.getHostName()));
        else
            return ok(Json.toJson(this.inetAddress.toString()));
    }

    public Result getIP() {
        return ok(this.inetAddress.getHostAddress());
    }

    public Result getHostname(){
        return ok(this.inetAddress.getHostName());
    }
}
