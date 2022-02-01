package net.openid.appauth;

import android.support.annotation.NonNull;
import android.util.Base64;
import java.util.Collections;
import java.util.Map;

public class ClientSecretBasic
  implements ClientAuthentication
{
  public static final String NAME = "client_secret_basic";
  @NonNull
  private String mClientSecret;
  
  public ClientSecretBasic(@NonNull String paramString)
  {
    this.mClientSecret = ((String)Preconditions.checkNotNull(paramString, "mClientSecret cannot be null"));
  }
  
  public final Map<String, String> getRequestHeaders(String paramString)
  {
    paramString = Base64.encodeToString((paramString + ":" + this.mClientSecret).getBytes(), 2);
    return Collections.singletonMap("Authorization", "Basic " + paramString);
  }
  
  public final Map<String, String> getRequestParameters(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.ClientSecretBasic
 * JD-Core Version:    0.7.0.1
 */