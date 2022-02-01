package net.openid.appauth;

import java.util.Map;

public abstract interface ClientAuthentication
{
  public abstract Map<String, String> getRequestHeaders(String paramString);
  
  public abstract Map<String, String> getRequestParameters(String paramString);
  
  public static class UnsupportedAuthenticationMethod
    extends Exception
  {
    private String mAuthMethod;
    
    public UnsupportedAuthenticationMethod(String paramString)
    {
      super();
      this.mAuthMethod = paramString;
    }
    
    public String getUnsupportedAuthenticationMethod()
    {
      return this.mAuthMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.ClientAuthentication
 * JD-Core Version:    0.7.0.1
 */