package net.openid.appauth;

import java.util.Map;

public class NoClientAuthentication
  implements ClientAuthentication
{
  public static final NoClientAuthentication INSTANCE = new NoClientAuthentication();
  public static final String NAME = "none";
  
  public Map<String, String> getRequestHeaders(String paramString)
  {
    return null;
  }
  
  public Map<String, String> getRequestParameters(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.NoClientAuthentication
 * JD-Core Version:    0.7.0.1
 */