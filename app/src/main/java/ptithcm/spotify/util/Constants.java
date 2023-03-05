package ptithcm.spotify.util;

public class Constants {
    public static final String ApiURL = "http://13.213.66.32:8080/api/v1";
    public static final String ApiLoginURL = "/authen/login";
    public static final String ApiRegisterURL = "/accounts/register";
    public static String getLoginEndpoint() {
        return ApiURL + ApiLoginURL;
    }
    public static String getRegisterEndpoint() {
        return ApiURL + ApiRegisterURL;
    }
}
