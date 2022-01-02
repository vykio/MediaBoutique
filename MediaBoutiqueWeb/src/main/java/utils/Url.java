package utils;

import javax.servlet.http.HttpServletRequest;

public class Url {

    public static String getRoute(HttpServletRequest request)
    {
        return request.getRequestURI().replace(request.getContextPath() + "/", "");
    }

}
