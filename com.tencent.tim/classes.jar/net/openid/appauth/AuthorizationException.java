package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AuthorizationException
  extends Exception
{
  public static final String EXTRA_EXCEPTION = "net.openid.appauth.AuthorizationException";
  private static final int HASH_MULTIPLIER = 31;
  @VisibleForTesting
  static final String KEY_CODE = "code";
  @VisibleForTesting
  static final String KEY_ERROR = "error";
  @VisibleForTesting
  static final String KEY_ERROR_DESCRIPTION = "errorDescription";
  @VisibleForTesting
  static final String KEY_ERROR_URI = "errorUri";
  @VisibleForTesting
  static final String KEY_TYPE = "type";
  public static final String PARAM_ERROR = "error";
  public static final String PARAM_ERROR_DESCRIPTION = "error_description";
  public static final String PARAM_ERROR_URI = "error_uri";
  public static final int TYPE_GENERAL_ERROR = 0;
  public static final int TYPE_OAUTH_AUTHORIZATION_ERROR = 1;
  public static final int TYPE_OAUTH_REGISTRATION_ERROR = 4;
  public static final int TYPE_OAUTH_TOKEN_ERROR = 2;
  public static final int TYPE_RESOURCE_SERVER_AUTHORIZATION_ERROR = 3;
  public final int code;
  @Nullable
  public final String error;
  @Nullable
  public final String errorDescription;
  @Nullable
  public final Uri errorUri;
  public final int type;
  
  public AuthorizationException(int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Uri paramUri, @Nullable Throwable paramThrowable)
  {
    super(paramString2, paramThrowable);
    this.type = paramInt1;
    this.code = paramInt2;
    this.error = paramString1;
    this.errorDescription = paramString2;
    this.errorUri = paramUri;
  }
  
  private static AuthorizationException authEx(int paramInt, @Nullable String paramString)
  {
    return new AuthorizationException(1, paramInt, paramString, null, null, null);
  }
  
  private static Map<String, AuthorizationException> exceptionMapByString(AuthorizationException... paramVarArgs)
  {
    int j = 0;
    if (paramVarArgs != null) {}
    ArrayMap localArrayMap;
    for (int i = paramVarArgs.length;; i = 0)
    {
      localArrayMap = new ArrayMap(i);
      if (paramVarArgs == null) {
        break;
      }
      int k = paramVarArgs.length;
      i = j;
      while (i < k)
      {
        AuthorizationException localAuthorizationException = paramVarArgs[i];
        if (localAuthorizationException.error != null) {
          localArrayMap.put(localAuthorizationException.error, localAuthorizationException);
        }
        i += 1;
      }
    }
    return Collections.unmodifiableMap(localArrayMap);
  }
  
  @Nullable
  public static AuthorizationException fromIntent(Intent paramIntent)
  {
    Preconditions.checkNotNull(paramIntent);
    if (!paramIntent.hasExtra("net.openid.appauth.AuthorizationException")) {
      return null;
    }
    try
    {
      paramIntent = fromJson(paramIntent.getStringExtra("net.openid.appauth.AuthorizationException"));
      return paramIntent;
    }
    catch (JSONException paramIntent)
    {
      throw new IllegalArgumentException("Intent contains malformed exception data", paramIntent);
    }
  }
  
  public static AuthorizationException fromJson(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr cannot be null or empty");
    return fromJson(new JSONObject(paramString));
  }
  
  public static AuthorizationException fromJson(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json cannot be null");
    return new AuthorizationException(paramJSONObject.getInt("type"), paramJSONObject.getInt("code"), JsonUtil.getStringIfDefined(paramJSONObject, "error"), JsonUtil.getStringIfDefined(paramJSONObject, "errorDescription"), JsonUtil.getUriIfDefined(paramJSONObject, "errorUri"), null);
  }
  
  public static AuthorizationException fromOAuthRedirect(@NonNull Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("error");
    Object localObject = paramUri.getQueryParameter("error_description");
    String str2 = paramUri.getQueryParameter("error_uri");
    AuthorizationException localAuthorizationException = AuthorizationRequestErrors.byString(str1);
    int i = localAuthorizationException.type;
    int j = localAuthorizationException.code;
    if (localObject != null)
    {
      paramUri = (Uri)localObject;
      if (str2 == null) {
        break label83;
      }
    }
    label83:
    for (localObject = Uri.parse(str2);; localObject = localAuthorizationException.errorUri)
    {
      return new AuthorizationException(i, j, str1, paramUri, (Uri)localObject, null);
      paramUri = localAuthorizationException.errorDescription;
      break;
    }
  }
  
  public static AuthorizationException fromOAuthTemplate(@NonNull AuthorizationException paramAuthorizationException, @Nullable String paramString1, @Nullable String paramString2, @Nullable Uri paramUri)
  {
    int i = paramAuthorizationException.type;
    int j = paramAuthorizationException.code;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        break label48;
      }
      label20:
      if (paramUri == null) {
        break label56;
      }
    }
    for (;;)
    {
      return new AuthorizationException(i, j, paramString1, paramString2, paramUri, null);
      paramString1 = paramAuthorizationException.error;
      break;
      label48:
      paramString2 = paramAuthorizationException.errorDescription;
      break label20;
      label56:
      paramUri = paramAuthorizationException.errorUri;
    }
  }
  
  public static AuthorizationException fromTemplate(@NonNull AuthorizationException paramAuthorizationException, @Nullable Throwable paramThrowable)
  {
    return new AuthorizationException(paramAuthorizationException.type, paramAuthorizationException.code, paramAuthorizationException.error, paramAuthorizationException.errorDescription, paramAuthorizationException.errorUri, paramThrowable);
  }
  
  private static AuthorizationException generalEx(int paramInt, @Nullable String paramString)
  {
    return new AuthorizationException(0, paramInt, null, paramString, null, null);
  }
  
  private static AuthorizationException registrationEx(int paramInt, @Nullable String paramString)
  {
    return new AuthorizationException(4, paramInt, paramString, null, null, null);
  }
  
  private static AuthorizationException tokenEx(int paramInt, @Nullable String paramString)
  {
    return new AuthorizationException(2, paramInt, paramString, null, null, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof AuthorizationException))) {
        return false;
      }
      paramObject = (AuthorizationException)paramObject;
    } while ((this.type == paramObject.type) && (this.code == paramObject.code));
    return false;
  }
  
  public int hashCode()
  {
    return (this.type + 31) * 31 + this.code;
  }
  
  @NonNull
  public Intent toIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("net.openid.appauth.AuthorizationException", toJsonString());
    return localIntent;
  }
  
  @NonNull
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "type", this.type);
    JsonUtil.put(localJSONObject, "code", this.code);
    JsonUtil.putIfNotNull(localJSONObject, "error", this.error);
    JsonUtil.putIfNotNull(localJSONObject, "errorDescription", this.errorDescription);
    JsonUtil.putIfNotNull(localJSONObject, "errorUri", this.errorUri);
    return localJSONObject;
  }
  
  @NonNull
  public String toJsonString()
  {
    return toJson().toString();
  }
  
  public String toString()
  {
    return "AuthorizationException: " + toJsonString();
  }
  
  public static final class AuthorizationRequestErrors
  {
    public static final AuthorizationException ACCESS_DENIED;
    public static final AuthorizationException CLIENT_ERROR = AuthorizationException.authEx(1007, null);
    public static final AuthorizationException INVALID_REQUEST = AuthorizationException.authEx(1000, "invalid_request");
    public static final AuthorizationException INVALID_SCOPE;
    public static final AuthorizationException OTHER = AuthorizationException.authEx(1008, null);
    public static final AuthorizationException SERVER_ERROR;
    public static final AuthorizationException STATE_MISMATCH = AuthorizationException.generalEx(9, "Response state param did not match request state");
    private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(new AuthorizationException[] { INVALID_REQUEST, UNAUTHORIZED_CLIENT, ACCESS_DENIED, UNSUPPORTED_RESPONSE_TYPE, INVALID_SCOPE, SERVER_ERROR, TEMPORARILY_UNAVAILABLE, CLIENT_ERROR, OTHER });
    public static final AuthorizationException TEMPORARILY_UNAVAILABLE;
    public static final AuthorizationException UNAUTHORIZED_CLIENT = AuthorizationException.authEx(1001, "unauthorized_client");
    public static final AuthorizationException UNSUPPORTED_RESPONSE_TYPE;
    
    static
    {
      ACCESS_DENIED = AuthorizationException.authEx(1002, "access_denied");
      UNSUPPORTED_RESPONSE_TYPE = AuthorizationException.authEx(1003, "unsupported_response_type");
      INVALID_SCOPE = AuthorizationException.authEx(1004, "invalid_scope");
      SERVER_ERROR = AuthorizationException.authEx(1005, "server_error");
      TEMPORARILY_UNAVAILABLE = AuthorizationException.authEx(1006, "temporarily_unavailable");
    }
    
    @NonNull
    public static AuthorizationException byString(String paramString)
    {
      paramString = (AuthorizationException)STRING_TO_EXCEPTION.get(paramString);
      if (paramString != null) {
        return paramString;
      }
      return OTHER;
    }
  }
  
  public static final class GeneralErrors
  {
    public static final AuthorizationException INVALID_DISCOVERY_DOCUMENT = AuthorizationException.generalEx(0, "Invalid discovery document");
    public static final AuthorizationException INVALID_REGISTRATION_RESPONSE = AuthorizationException.generalEx(7, "Invalid registration response");
    public static final AuthorizationException JSON_DESERIALIZATION_ERROR;
    public static final AuthorizationException NETWORK_ERROR;
    public static final AuthorizationException PROGRAM_CANCELED_AUTH_FLOW;
    public static final AuthorizationException SERVER_ERROR;
    public static final AuthorizationException TOKEN_RESPONSE_CONSTRUCTION_ERROR;
    public static final AuthorizationException USER_CANCELED_AUTH_FLOW = AuthorizationException.generalEx(1, "User cancelled flow");
    
    static
    {
      PROGRAM_CANCELED_AUTH_FLOW = AuthorizationException.generalEx(2, "Flow cancelled programmatically");
      NETWORK_ERROR = AuthorizationException.generalEx(3, "Network error");
      SERVER_ERROR = AuthorizationException.generalEx(4, "Server error");
      JSON_DESERIALIZATION_ERROR = AuthorizationException.generalEx(5, "JSON deserialization error");
      TOKEN_RESPONSE_CONSTRUCTION_ERROR = AuthorizationException.generalEx(6, "Token response construction error");
    }
  }
  
  public static final class RegistrationRequestErrors
  {
    public static final AuthorizationException CLIENT_ERROR = AuthorizationException.registrationEx(4003, null);
    public static final AuthorizationException INVALID_CLIENT_METADATA;
    public static final AuthorizationException INVALID_REDIRECT_URI;
    public static final AuthorizationException INVALID_REQUEST = AuthorizationException.registrationEx(4000, "invalid_request");
    public static final AuthorizationException OTHER = AuthorizationException.registrationEx(4004, null);
    private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(new AuthorizationException[] { INVALID_REQUEST, INVALID_REDIRECT_URI, INVALID_CLIENT_METADATA, CLIENT_ERROR, OTHER });
    
    static
    {
      INVALID_REDIRECT_URI = AuthorizationException.registrationEx(4001, "invalid_redirect_uri");
      INVALID_CLIENT_METADATA = AuthorizationException.registrationEx(4002, "invalid_client_metadata");
    }
    
    public static AuthorizationException byString(String paramString)
    {
      paramString = (AuthorizationException)STRING_TO_EXCEPTION.get(paramString);
      if (paramString != null) {
        return paramString;
      }
      return OTHER;
    }
  }
  
  public static final class TokenRequestErrors
  {
    public static final AuthorizationException CLIENT_ERROR = AuthorizationException.tokenEx(2006, null);
    public static final AuthorizationException INVALID_CLIENT;
    public static final AuthorizationException INVALID_GRANT;
    public static final AuthorizationException INVALID_REQUEST = AuthorizationException.tokenEx(2000, "invalid_request");
    public static final AuthorizationException INVALID_SCOPE;
    public static final AuthorizationException OTHER = AuthorizationException.tokenEx(2007, null);
    private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(new AuthorizationException[] { INVALID_REQUEST, INVALID_CLIENT, INVALID_GRANT, UNAUTHORIZED_CLIENT, UNSUPPORTED_GRANT_TYPE, INVALID_SCOPE, CLIENT_ERROR, OTHER });
    public static final AuthorizationException UNAUTHORIZED_CLIENT;
    public static final AuthorizationException UNSUPPORTED_GRANT_TYPE;
    
    static
    {
      INVALID_CLIENT = AuthorizationException.tokenEx(2001, "invalid_client");
      INVALID_GRANT = AuthorizationException.tokenEx(2002, "invalid_grant");
      UNAUTHORIZED_CLIENT = AuthorizationException.tokenEx(2003, "unauthorized_client");
      UNSUPPORTED_GRANT_TYPE = AuthorizationException.tokenEx(2004, "unsupported_grant_type");
      INVALID_SCOPE = AuthorizationException.tokenEx(2005, "invalid_scope");
    }
    
    public static AuthorizationException byString(String paramString)
    {
      paramString = (AuthorizationException)STRING_TO_EXCEPTION.get(paramString);
      if (paramString != null) {
        return paramString;
      }
      return OTHER;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationException
 * JD-Core Version:    0.7.0.1
 */