package net.openid.appauth;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class ClientSecretPost
  implements ClientAuthentication
{
  public static final String NAME = "client_secret_post";
  static final String PARAM_CLIENT_ID = "client_id";
  static final String PARAM_CLIENT_SECRET = "client_secret";
  @NonNull
  private String mClientSecret;
  
  public ClientSecretPost(@NonNull String paramString)
  {
    this.mClientSecret = ((String)Preconditions.checkNotNull(paramString, "clientSecret cannot be null"));
  }
  
  public final Map<String, String> getRequestHeaders(String paramString)
  {
    return null;
  }
  
  public final Map<String, String> getRequestParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_id", paramString);
    localHashMap.put("client_secret", this.mClientSecret);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.ClientSecretPost
 * JD-Core Version:    0.7.0.1
 */