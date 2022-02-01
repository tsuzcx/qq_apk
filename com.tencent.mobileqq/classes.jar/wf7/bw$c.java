package wf7;

import java.lang.reflect.Field;

public class bw$c
{
  private static final String[] gG = { "NETWORK_SELECTION_ENABLED", "NETWORK_SELECTION_TEMPORARY_DISABLED", "NETWORK_SELECTION_PERMANENTLY_DISABLED" };
  public static final String[] gH = { "NETWORK_SELECTION_ENABLE", "NETWORK_SELECTION_DISABLED_BAD_LINK", "NETWORK_SELECTION_DISABLED_ASSOCIATION_REJECTION ", "NETWORK_SELECTION_DISABLED_AUTHENTICATION_FAILURE", "NETWORK_SELECTION_DISABLED_DHCP_FAILURE", "NETWORK_SELECTION_DISABLED_DNS_FAILURE", "NETWORK_SELECTION_DISABLED_WPS_START", "NETWORK_SELECTION_DISABLED_TLS_VERSION", "NETWORK_SELECTION_DISABLED_AUTHENTICATION_NO_CREDENTIALS", "NETWORK_SELECTION_DISABLED_NO_INTERNET", "NETWORK_SELECTION_DISABLED_BY_WIFI_MANAGER", "NETWORK_SELECTION_DISABLED_BY_USER_SWITCH", "NETWORK_SELECTION_DISABLED_BY_WRONG_PASSWORD" };
  
  public static int i(String paramString)
  {
    try
    {
      if (bw.au() == null) {
        bw.c(Class.forName("android.net.wifi.WifiConfiguration$NetworkSelectionStatus"));
      }
      paramString = bw.au().getDeclaredField(paramString);
      paramString.setAccessible(true);
      int i = ((Integer)paramString.get(null)).intValue();
      return i;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bw.c
 * JD-Core Version:    0.7.0.1
 */