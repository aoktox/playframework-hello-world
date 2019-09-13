package controllers;

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
//    private Config config;

//    @Inject
//    private HomeController(Config config){
//        this.config = config;
//    }

    public Result index(){
        return ok(views.html.hello.render(inetAddress.getHostAddress(), inetAddress.getHostName()));
        // return ok(views.html.index.render());
    }

    public Result getIP() {
        return ok(this.inetAddress.getHostAddress());
    }

    public Result getHostname(){
        return ok(this.inetAddress.getHostName());
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }
}
