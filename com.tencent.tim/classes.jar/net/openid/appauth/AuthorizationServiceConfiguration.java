package net.openid.appauth;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationServiceConfiguration
{
  private static final String KEY_AUTHORIZATION_ENDPOINT = "authorizationEndpoint";
  private static final String KEY_DISCOVERY_DOC = "discoveryDoc";
  private static final String KEY_REGISTRATION_ENDPOINT = "registrationEndpoint";
  private static final String KEY_TOKEN_ENDPOINT = "tokenEndpoint";
  public static final String OPENID_CONFIGURATION_RESOURCE = "openid-configuration";
  public static final String WELL_KNOWN_PATH = ".well-known";
  @NonNull
  public final Uri authorizationEndpoint;
  @Nullable
  public final AuthorizationServiceDiscovery discoveryDoc;
  @Nullable
  public final Uri registrationEndpoint;
  @NonNull
  public final Uri tokenEndpoint;
  
  public AuthorizationServiceConfiguration(@NonNull Uri paramUri1, @NonNull Uri paramUri2, @Nullable Uri paramUri3)
  {
    this.authorizationEndpoint = ((Uri)Preconditions.checkNotNull(paramUri1));
    this.tokenEndpoint = ((Uri)Preconditions.checkNotNull(paramUri2));
    this.registrationEndpoint = paramUri3;
    this.discoveryDoc = null;
  }
  
  public AuthorizationServiceConfiguration(@NonNull AuthorizationServiceDiscovery paramAuthorizationServiceDiscovery)
  {
    Preconditions.checkNotNull(paramAuthorizationServiceDiscovery, "docJson cannot be null");
    this.discoveryDoc = paramAuthorizationServiceDiscovery;
    this.authorizationEndpoint = paramAuthorizationServiceDiscovery.getAuthorizationEndpoint();
    this.tokenEndpoint = paramAuthorizationServiceDiscovery.getTokenEndpoint();
    this.registrationEndpoint = paramAuthorizationServiceDiscovery.getRegistrationEndpoint();
  }
  
  static Uri buildConfigurationUriFromIssuer(Uri paramUri)
  {
    return paramUri.buildUpon().appendPath(".well-known").appendPath("openid-configuration").build();
  }
  
  public static void fetchFromIssuer(@NonNull Uri paramUri, @NonNull RetrieveConfigurationCallback paramRetrieveConfigurationCallback)
  {
    fetchFromUrl(buildConfigurationUriFromIssuer(paramUri), paramRetrieveConfigurationCallback);
  }
  
  public static void fetchFromUrl(@NonNull Uri paramUri, @NonNull RetrieveConfigurationCallback paramRetrieveConfigurationCallback)
  {
    fetchFromUrl(paramUri, paramRetrieveConfigurationCallback, DefaultConnectionBuilder.INSTANCE);
  }
  
  public static void fetchFromUrl(@NonNull Uri paramUri, @NonNull RetrieveConfigurationCallback paramRetrieveConfigurationCallback, @NonNull ConnectionBuilder paramConnectionBuilder)
  {
    Preconditions.checkNotNull(paramUri, "openIDConnectDiscoveryUri cannot be null");
    Preconditions.checkNotNull(paramRetrieveConfigurationCallback, "callback cannot be null");
    Preconditions.checkNotNull(paramConnectionBuilder, "connectionBuilder must not be null");
    new ConfigurationRetrievalAsyncTask(paramUri, paramConnectionBuilder, paramRetrieveConfigurationCallback).execute(new Void[0]);
  }
  
  public static AuthorizationServiceConfiguration fromJson(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramString, "json cannot be null");
    return fromJson(new JSONObject(paramString));
  }
  
  @NonNull
  public static AuthorizationServiceConfiguration fromJson(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json object cannot be null");
    if (paramJSONObject.has("discoveryDoc")) {
      try
      {
        paramJSONObject = new AuthorizationServiceConfiguration(new AuthorizationServiceDiscovery(paramJSONObject.optJSONObject("discoveryDoc")));
        return paramJSONObject;
      }
      catch (AuthorizationServiceDiscovery.MissingArgumentException paramJSONObject)
      {
        throw new JSONException("Missing required field in discovery doc: " + paramJSONObject.getMissingField());
      }
    }
    Preconditions.checkArgument(paramJSONObject.has("authorizationEndpoint"), "missing authorizationEndpoint");
    Preconditions.checkArgument(paramJSONObject.has("tokenEndpoint"), "missing tokenEndpoint");
    return new AuthorizationServiceConfiguration(JsonUtil.getUri(paramJSONObject, "authorizationEndpoint"), JsonUtil.getUri(paramJSONObject, "tokenEndpoint"), JsonUtil.getUriIfDefined(paramJSONObject, "registrationEndpoint"));
  }
  
  @NonNull
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "authorizationEndpoint", this.authorizationEndpoint.toString());
    JsonUtil.put(localJSONObject, "tokenEndpoint", this.tokenEndpoint.toString());
    if (this.registrationEndpoint != null) {
      JsonUtil.put(localJSONObject, "registrationEndpoint", this.registrationEndpoint.toString());
    }
    if (this.discoveryDoc != null) {
      JsonUtil.put(localJSONObject, "discoveryDoc", this.discoveryDoc.docJson);
    }
    return localJSONObject;
  }
  
  public String toJsonString()
  {
    return toJson().toString();
  }
  
  static class ConfigurationRetrievalAsyncTask
    extends AsyncTask<Void, Void, AuthorizationServiceConfiguration>
  {
    private AuthorizationServiceConfiguration.RetrieveConfigurationCallback mCallback;
    private ConnectionBuilder mConnectionBuilder;
    private AuthorizationException mException;
    private Uri mUri;
    
    ConfigurationRetrievalAsyncTask(Uri paramUri, ConnectionBuilder paramConnectionBuilder, AuthorizationServiceConfiguration.RetrieveConfigurationCallback paramRetrieveConfigurationCallback)
    {
      this.mUri = paramUri;
      this.mConnectionBuilder = paramConnectionBuilder;
      this.mCallback = paramRetrieveConfigurationCallback;
      this.mException = null;
    }
    
    /* Error */
    protected AuthorizationServiceConfiguration doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 25	net/openid/appauth/AuthorizationServiceConfiguration$ConfigurationRetrievalAsyncTask:mConnectionBuilder	Lnet/openid/appauth/connectivity/ConnectionBuilder;
      //   4: aload_0
      //   5: getfield 23	net/openid/appauth/AuthorizationServiceConfiguration$ConfigurationRetrievalAsyncTask:mUri	Landroid/net/Uri;
      //   8: invokeinterface 49 2 0
      //   13: astore_1
      //   14: aload_1
      //   15: ldc 51
      //   17: invokevirtual 57	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: iconst_1
      //   22: invokevirtual 61	java/net/HttpURLConnection:setDoInput	(Z)V
      //   25: aload_1
      //   26: invokevirtual 64	java/net/HttpURLConnection:connect	()V
      //   29: aload_1
      //   30: invokevirtual 68	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   33: astore_2
      //   34: aload_2
      //   35: astore_1
      //   36: new 7	net/openid/appauth/AuthorizationServiceConfiguration
      //   39: dup
      //   40: new 70	net/openid/appauth/AuthorizationServiceDiscovery
      //   43: dup
      //   44: new 72	org/json/JSONObject
      //   47: dup
      //   48: aload_2
      //   49: invokestatic 78	net/openid/appauth/Utils:readInputStream	(Ljava/io/InputStream;)Ljava/lang/String;
      //   52: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   55: invokespecial 83	net/openid/appauth/AuthorizationServiceDiscovery:<init>	(Lorg/json/JSONObject;)V
      //   58: invokespecial 86	net/openid/appauth/AuthorizationServiceConfiguration:<init>	(Lnet/openid/appauth/AuthorizationServiceDiscovery;)V
      //   61: astore_3
      //   62: aload_2
      //   63: invokestatic 90	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   66: aload_3
      //   67: areturn
      //   68: astore_3
      //   69: aconst_null
      //   70: astore_2
      //   71: aload_2
      //   72: astore_1
      //   73: aload_3
      //   74: ldc 92
      //   76: iconst_0
      //   77: anewarray 94	java/lang/Object
      //   80: invokestatic 100	net/openid/appauth/Logger:errorWithStack	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   83: aload_2
      //   84: astore_1
      //   85: aload_0
      //   86: getstatic 105	net/openid/appauth/AuthorizationException$GeneralErrors:NETWORK_ERROR	Lnet/openid/appauth/AuthorizationException;
      //   89: aload_3
      //   90: invokestatic 111	net/openid/appauth/AuthorizationException:fromTemplate	(Lnet/openid/appauth/AuthorizationException;Ljava/lang/Throwable;)Lnet/openid/appauth/AuthorizationException;
      //   93: putfield 29	net/openid/appauth/AuthorizationServiceConfiguration$ConfigurationRetrievalAsyncTask:mException	Lnet/openid/appauth/AuthorizationException;
      //   96: aload_2
      //   97: invokestatic 90	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   100: aconst_null
      //   101: areturn
      //   102: astore_3
      //   103: aconst_null
      //   104: astore_2
      //   105: aload_2
      //   106: astore_1
      //   107: aload_3
      //   108: ldc 113
      //   110: iconst_0
      //   111: anewarray 94	java/lang/Object
      //   114: invokestatic 100	net/openid/appauth/Logger:errorWithStack	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   117: aload_2
      //   118: astore_1
      //   119: aload_0
      //   120: getstatic 116	net/openid/appauth/AuthorizationException$GeneralErrors:JSON_DESERIALIZATION_ERROR	Lnet/openid/appauth/AuthorizationException;
      //   123: aload_3
      //   124: invokestatic 111	net/openid/appauth/AuthorizationException:fromTemplate	(Lnet/openid/appauth/AuthorizationException;Ljava/lang/Throwable;)Lnet/openid/appauth/AuthorizationException;
      //   127: putfield 29	net/openid/appauth/AuthorizationServiceConfiguration$ConfigurationRetrievalAsyncTask:mException	Lnet/openid/appauth/AuthorizationException;
      //   130: aload_2
      //   131: invokestatic 90	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   134: goto -34 -> 100
      //   137: astore_3
      //   138: aconst_null
      //   139: astore_2
      //   140: aload_2
      //   141: astore_1
      //   142: aload_3
      //   143: ldc 118
      //   145: iconst_0
      //   146: anewarray 94	java/lang/Object
      //   149: invokestatic 100	net/openid/appauth/Logger:errorWithStack	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   152: aload_2
      //   153: astore_1
      //   154: aload_0
      //   155: getstatic 121	net/openid/appauth/AuthorizationException$GeneralErrors:INVALID_DISCOVERY_DOCUMENT	Lnet/openid/appauth/AuthorizationException;
      //   158: aload_3
      //   159: invokestatic 111	net/openid/appauth/AuthorizationException:fromTemplate	(Lnet/openid/appauth/AuthorizationException;Ljava/lang/Throwable;)Lnet/openid/appauth/AuthorizationException;
      //   162: putfield 29	net/openid/appauth/AuthorizationServiceConfiguration$ConfigurationRetrievalAsyncTask:mException	Lnet/openid/appauth/AuthorizationException;
      //   165: aload_2
      //   166: invokestatic 90	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   169: goto -69 -> 100
      //   172: astore_2
      //   173: aconst_null
      //   174: astore_1
      //   175: aload_1
      //   176: invokestatic 90	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   179: aload_2
      //   180: athrow
      //   181: astore_2
      //   182: goto -7 -> 175
      //   185: astore_3
      //   186: goto -46 -> 140
      //   189: astore_3
      //   190: goto -85 -> 105
      //   193: astore_3
      //   194: goto -123 -> 71
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	ConfigurationRetrievalAsyncTask
      //   0	197	1	paramVarArgs	Void[]
      //   33	133	2	localInputStream	java.io.InputStream
      //   172	8	2	localObject1	Object
      //   181	1	2	localObject2	Object
      //   61	6	3	localAuthorizationServiceConfiguration	AuthorizationServiceConfiguration
      //   68	22	3	localIOException1	java.io.IOException
      //   102	22	3	localJSONException1	JSONException
      //   137	22	3	localMissingArgumentException1	AuthorizationServiceDiscovery.MissingArgumentException
      //   185	1	3	localMissingArgumentException2	AuthorizationServiceDiscovery.MissingArgumentException
      //   189	1	3	localJSONException2	JSONException
      //   193	1	3	localIOException2	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   0	34	68	java/io/IOException
      //   0	34	102	org/json/JSONException
      //   0	34	137	net/openid/appauth/AuthorizationServiceDiscovery$MissingArgumentException
      //   0	34	172	finally
      //   36	62	181	finally
      //   73	83	181	finally
      //   85	96	181	finally
      //   107	117	181	finally
      //   119	130	181	finally
      //   142	152	181	finally
      //   154	165	181	finally
      //   36	62	185	net/openid/appauth/AuthorizationServiceDiscovery$MissingArgumentException
      //   36	62	189	org/json/JSONException
      //   36	62	193	java/io/IOException
    }
    
    protected void onPostExecute(AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration)
    {
      if (this.mException != null)
      {
        this.mCallback.onFetchConfigurationCompleted(null, this.mException);
        return;
      }
      this.mCallback.onFetchConfigurationCompleted(paramAuthorizationServiceConfiguration, null);
    }
  }
  
  public static abstract interface RetrieveConfigurationCallback
  {
    public abstract void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @Nullable AuthorizationException paramAuthorizationException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationServiceConfiguration
 * JD-Core Version:    0.7.0.1
 */