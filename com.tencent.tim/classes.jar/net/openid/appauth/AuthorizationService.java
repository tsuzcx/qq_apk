package net.openid.appauth;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.openid.appauth.browser.BrowserDescriptor;
import net.openid.appauth.browser.BrowserSelector;
import net.openid.appauth.connectivity.ConnectionBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationService
{
  @Nullable
  private final BrowserDescriptor mBrowser;
  @NonNull
  private final AppAuthConfiguration mClientConfiguration;
  @VisibleForTesting
  Context mContext;
  @NonNull
  private final CustomTabManager mCustomTabManager;
  private boolean mDisposed = false;
  
  public AuthorizationService(@NonNull Context paramContext)
  {
    this(paramContext, AppAuthConfiguration.DEFAULT);
  }
  
  public AuthorizationService(@NonNull Context paramContext, @NonNull AppAuthConfiguration paramAppAuthConfiguration)
  {
    this(paramContext, paramAppAuthConfiguration, BrowserSelector.select(paramContext, paramAppAuthConfiguration.getBrowserMatcher()), new CustomTabManager(paramContext));
  }
  
  @VisibleForTesting
  AuthorizationService(@NonNull Context paramContext, @NonNull AppAuthConfiguration paramAppAuthConfiguration, @Nullable BrowserDescriptor paramBrowserDescriptor, @NonNull CustomTabManager paramCustomTabManager)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
    this.mClientConfiguration = paramAppAuthConfiguration;
    this.mCustomTabManager = paramCustomTabManager;
    this.mBrowser = paramBrowserDescriptor;
    if ((paramBrowserDescriptor != null) && (paramBrowserDescriptor.useCustomTab.booleanValue())) {
      this.mCustomTabManager.bind(paramBrowserDescriptor.packageName);
    }
  }
  
  private void checkNotDisposed()
  {
    if (this.mDisposed) {
      throw new IllegalStateException("Service has been disposed and rendered inoperable");
    }
  }
  
  public CustomTabsIntent.Builder createCustomTabsIntentBuilder()
  {
    checkNotDisposed();
    return this.mCustomTabManager.createCustomTabsIntentBuilder();
  }
  
  public void dispose()
  {
    if (this.mDisposed) {
      return;
    }
    this.mCustomTabManager.unbind();
    this.mDisposed = true;
  }
  
  public void performAuthorizationRequest(@NonNull AuthorizationRequest paramAuthorizationRequest, @NonNull PendingIntent paramPendingIntent)
  {
    performAuthorizationRequest(paramAuthorizationRequest, paramPendingIntent, null, createCustomTabsIntentBuilder().build());
  }
  
  public void performAuthorizationRequest(@NonNull AuthorizationRequest paramAuthorizationRequest, @NonNull PendingIntent paramPendingIntent1, @NonNull PendingIntent paramPendingIntent2)
  {
    performAuthorizationRequest(paramAuthorizationRequest, paramPendingIntent1, paramPendingIntent2, createCustomTabsIntentBuilder().build());
  }
  
  public void performAuthorizationRequest(@NonNull AuthorizationRequest paramAuthorizationRequest, @NonNull PendingIntent paramPendingIntent1, @Nullable PendingIntent paramPendingIntent2, @NonNull CustomTabsIntent paramCustomTabsIntent)
  {
    checkNotDisposed();
    if (this.mBrowser == null) {
      throw new ActivityNotFoundException();
    }
    Uri localUri = paramAuthorizationRequest.toUri();
    if (this.mBrowser.useCustomTab.booleanValue()) {}
    for (paramCustomTabsIntent = paramCustomTabsIntent.intent;; paramCustomTabsIntent = new Intent("android.intent.action.VIEW"))
    {
      paramCustomTabsIntent.setPackage(this.mBrowser.packageName);
      paramCustomTabsIntent.setData(localUri);
      Logger.debug("Using %s as browser for auth, custom tab = %s", new Object[] { paramCustomTabsIntent.getPackage(), this.mBrowser.useCustomTab.toString() });
      paramCustomTabsIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 0);
      paramCustomTabsIntent.addFlags(1073741824);
      Logger.debug("Initiating authorization request to %s", new Object[] { paramAuthorizationRequest.configuration.authorizationEndpoint });
      this.mContext.startActivity(AuthorizationManagementActivity.createStartIntent(this.mContext, paramAuthorizationRequest, paramCustomTabsIntent, paramPendingIntent1, paramPendingIntent2));
      return;
    }
  }
  
  public void performAuthorizationRequest(@NonNull AuthorizationRequest paramAuthorizationRequest, @NonNull PendingIntent paramPendingIntent, @NonNull CustomTabsIntent paramCustomTabsIntent)
  {
    performAuthorizationRequest(paramAuthorizationRequest, paramPendingIntent, null, paramCustomTabsIntent);
  }
  
  public void performRegistrationRequest(@NonNull RegistrationRequest paramRegistrationRequest, @NonNull RegistrationResponseCallback paramRegistrationResponseCallback)
  {
    checkNotDisposed();
    Logger.debug("Initiating dynamic client registration %s", new Object[] { paramRegistrationRequest.configuration.registrationEndpoint.toString() });
    new RegistrationRequestTask(paramRegistrationRequest, paramRegistrationResponseCallback).execute(new Void[0]);
  }
  
  public void performTokenRequest(@NonNull TokenRequest paramTokenRequest, @NonNull TokenResponseCallback paramTokenResponseCallback)
  {
    checkNotDisposed();
    Logger.debug("Initiating code exchange request to %s", new Object[] { paramTokenRequest.configuration.tokenEndpoint });
    new TokenRequestTask(paramTokenRequest, NoClientAuthentication.INSTANCE, paramTokenResponseCallback).execute(new Void[0]);
  }
  
  public void performTokenRequest(@NonNull TokenRequest paramTokenRequest, @NonNull ClientAuthentication paramClientAuthentication, @NonNull TokenResponseCallback paramTokenResponseCallback)
  {
    checkNotDisposed();
    Logger.debug("Initiating code exchange request to %s", new Object[] { paramTokenRequest.configuration.tokenEndpoint });
    new TokenRequestTask(paramTokenRequest, paramClientAuthentication, paramTokenResponseCallback).execute(new Void[0]);
  }
  
  class RegistrationRequestTask
    extends AsyncTask<Void, Void, JSONObject>
  {
    private AuthorizationService.RegistrationResponseCallback mCallback;
    private AuthorizationException mException;
    private RegistrationRequest mRequest;
    
    RegistrationRequestTask(RegistrationRequest paramRegistrationRequest, AuthorizationService.RegistrationResponseCallback paramRegistrationResponseCallback)
    {
      this.mRequest = paramRegistrationRequest;
      this.mCallback = paramRegistrationResponseCallback;
    }
    
    /* Error */
    protected JSONObject doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_0
      //   3: getfield 25	net/openid/appauth/AuthorizationService$RegistrationRequestTask:mRequest	Lnet/openid/appauth/RegistrationRequest;
      //   6: invokevirtual 45	net/openid/appauth/RegistrationRequest:toJsonString	()Ljava/lang/String;
      //   9: astore_1
      //   10: aload_0
      //   11: getfield 20	net/openid/appauth/AuthorizationService$RegistrationRequestTask:this$0	Lnet/openid/appauth/AuthorizationService;
      //   14: invokestatic 49	net/openid/appauth/AuthorizationService:access$000	(Lnet/openid/appauth/AuthorizationService;)Lnet/openid/appauth/AppAuthConfiguration;
      //   17: invokevirtual 55	net/openid/appauth/AppAuthConfiguration:getConnectionBuilder	()Lnet/openid/appauth/connectivity/ConnectionBuilder;
      //   20: aload_0
      //   21: getfield 25	net/openid/appauth/AuthorizationService$RegistrationRequestTask:mRequest	Lnet/openid/appauth/RegistrationRequest;
      //   24: getfield 59	net/openid/appauth/RegistrationRequest:configuration	Lnet/openid/appauth/AuthorizationServiceConfiguration;
      //   27: getfield 65	net/openid/appauth/AuthorizationServiceConfiguration:registrationEndpoint	Landroid/net/Uri;
      //   30: invokeinterface 71 2 0
      //   35: astore_3
      //   36: aload_3
      //   37: ldc 73
      //   39: invokevirtual 79	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   42: aload_3
      //   43: iconst_1
      //   44: invokevirtual 83	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   47: aload_3
      //   48: ldc 85
      //   50: aload_1
      //   51: invokevirtual 91	java/lang/String:length	()I
      //   54: invokestatic 95	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   57: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   60: new 101	java/io/OutputStreamWriter
      //   63: dup
      //   64: aload_3
      //   65: invokevirtual 105	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   68: invokespecial 108	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   71: astore 4
      //   73: aload 4
      //   75: aload_1
      //   76: invokevirtual 111	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
      //   79: aload 4
      //   81: invokevirtual 114	java/io/OutputStreamWriter:flush	()V
      //   84: aload_3
      //   85: invokevirtual 118	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   88: astore_1
      //   89: aload_1
      //   90: astore_2
      //   91: aload_2
      //   92: astore_1
      //   93: new 120	org/json/JSONObject
      //   96: dup
      //   97: aload_2
      //   98: invokestatic 126	net/openid/appauth/Utils:readInputStream	(Ljava/io/InputStream;)Ljava/lang/String;
      //   101: invokespecial 128	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   104: astore_3
      //   105: aload_2
      //   106: invokestatic 132	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   109: aload_3
      //   110: areturn
      //   111: astore_3
      //   112: aconst_null
      //   113: astore_2
      //   114: aload_2
      //   115: astore_1
      //   116: aload_3
      //   117: ldc 134
      //   119: iconst_0
      //   120: anewarray 136	java/lang/Object
      //   123: invokestatic 142	net/openid/appauth/Logger:debugWithStack	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   126: aload_2
      //   127: astore_1
      //   128: aload_0
      //   129: getstatic 147	net/openid/appauth/AuthorizationException$GeneralErrors:NETWORK_ERROR	Lnet/openid/appauth/AuthorizationException;
      //   132: aload_3
      //   133: invokestatic 153	net/openid/appauth/AuthorizationException:fromTemplate	(Lnet/openid/appauth/AuthorizationException;Ljava/lang/Throwable;)Lnet/openid/appauth/AuthorizationException;
      //   136: putfield 155	net/openid/appauth/AuthorizationService$RegistrationRequestTask:mException	Lnet/openid/appauth/AuthorizationException;
      //   139: aload_2
      //   140: invokestatic 132	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   143: aconst_null
      //   144: areturn
      //   145: astore_3
      //   146: aconst_null
      //   147: astore_2
      //   148: aload_2
      //   149: astore_1
      //   150: aload_3
      //   151: ldc 134
      //   153: iconst_0
      //   154: anewarray 136	java/lang/Object
      //   157: invokestatic 142	net/openid/appauth/Logger:debugWithStack	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   160: aload_2
      //   161: astore_1
      //   162: aload_0
      //   163: getstatic 158	net/openid/appauth/AuthorizationException$GeneralErrors:JSON_DESERIALIZATION_ERROR	Lnet/openid/appauth/AuthorizationException;
      //   166: aload_3
      //   167: invokestatic 153	net/openid/appauth/AuthorizationException:fromTemplate	(Lnet/openid/appauth/AuthorizationException;Ljava/lang/Throwable;)Lnet/openid/appauth/AuthorizationException;
      //   170: putfield 155	net/openid/appauth/AuthorizationService$RegistrationRequestTask:mException	Lnet/openid/appauth/AuthorizationException;
      //   173: aload_2
      //   174: invokestatic 132	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   177: goto -34 -> 143
      //   180: astore_1
      //   181: aload_2
      //   182: invokestatic 132	net/openid/appauth/Utils:closeQuietly	(Ljava/io/InputStream;)V
      //   185: aload_1
      //   186: athrow
      //   187: astore_3
      //   188: aload_1
      //   189: astore_2
      //   190: aload_3
      //   191: astore_1
      //   192: goto -11 -> 181
      //   195: astore_3
      //   196: goto -48 -> 148
      //   199: astore_3
      //   200: goto -86 -> 114
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	203	0	this	RegistrationRequestTask
      //   0	203	1	paramVarArgs	Void[]
      //   1	189	2	arrayOfVoid	Void[]
      //   35	75	3	localObject1	Object
      //   111	22	3	localIOException1	IOException
      //   145	22	3	localJSONException1	JSONException
      //   187	4	3	localObject2	Object
      //   195	1	3	localJSONException2	JSONException
      //   199	1	3	localIOException2	IOException
      //   71	9	4	localOutputStreamWriter	OutputStreamWriter
      // Exception table:
      //   from	to	target	type
      //   10	89	111	java/io/IOException
      //   10	89	145	org/json/JSONException
      //   10	89	180	finally
      //   93	105	187	finally
      //   116	126	187	finally
      //   128	139	187	finally
      //   150	160	187	finally
      //   162	173	187	finally
      //   93	105	195	org/json/JSONException
      //   93	105	199	java/io/IOException
    }
    
    protected void onPostExecute(JSONObject paramJSONObject)
    {
      if (this.mException != null)
      {
        this.mCallback.onRegistrationRequestCompleted(null, this.mException);
        return;
      }
      if (paramJSONObject.has("error")) {
        try
        {
          String str = paramJSONObject.getString("error");
          paramJSONObject = AuthorizationException.fromOAuthTemplate(AuthorizationException.RegistrationRequestErrors.byString(str), str, paramJSONObject.getString("error_description"), UriUtil.parseUriIfAvailable(paramJSONObject.getString("error_uri")));
          this.mCallback.onRegistrationRequestCompleted(null, paramJSONObject);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, paramJSONObject);
          }
        }
      }
      try
      {
        paramJSONObject = new RegistrationResponse.Builder(this.mRequest).fromResponseJson(paramJSONObject).build();
        Logger.debug("Dynamic registration with %s completed", new Object[] { this.mRequest.configuration.registrationEndpoint });
        this.mCallback.onRegistrationRequestCompleted(paramJSONObject, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        this.mCallback.onRegistrationRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, paramJSONObject));
        return;
      }
      catch (RegistrationResponse.MissingArgumentException paramJSONObject)
      {
        Logger.errorWithStack(paramJSONObject, "Malformed registration response", new Object[0]);
        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_REGISTRATION_RESPONSE, paramJSONObject);
      }
    }
  }
  
  public static abstract interface RegistrationResponseCallback
  {
    public abstract void onRegistrationRequestCompleted(@Nullable RegistrationResponse paramRegistrationResponse, @Nullable AuthorizationException paramAuthorizationException);
  }
  
  class TokenRequestTask
    extends AsyncTask<Void, Void, JSONObject>
  {
    private AuthorizationService.TokenResponseCallback mCallback;
    private ClientAuthentication mClientAuthentication;
    private AuthorizationException mException;
    private TokenRequest mRequest;
    
    TokenRequestTask(TokenRequest paramTokenRequest, @NonNull ClientAuthentication paramClientAuthentication, AuthorizationService.TokenResponseCallback paramTokenResponseCallback)
    {
      this.mRequest = paramTokenRequest;
      this.mCallback = paramTokenResponseCallback;
      this.mClientAuthentication = paramClientAuthentication;
    }
    
    protected JSONObject doInBackground(Void... paramVarArgs)
    {
      localObject1 = null;
      try
      {
        paramVarArgs = AuthorizationService.this.mClientConfiguration.getConnectionBuilder().openConnection(this.mRequest.configuration.tokenEndpoint);
        paramVarArgs.setRequestMethod("POST");
        paramVarArgs.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        paramVarArgs.setDoOutput(true);
        Object localObject2 = this.mClientAuthentication.getRequestHeaders(this.mRequest.clientId);
        Object localObject5;
        if (localObject2 != null)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject2).next();
            paramVarArgs.setRequestProperty((String)((Map.Entry)localObject5).getKey(), (String)((Map.Entry)localObject5).getValue());
          }
        }
        Object localObject3;
        for (;;) {}
      }
      catch (IOException localIOException1)
      {
        localObject1 = null;
        paramVarArgs = (Void[])localObject1;
        try
        {
          Logger.debugWithStack(localIOException1, "Failed to complete exchange request", new Object[0]);
          paramVarArgs = (Void[])localObject1;
          this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, localIOException1);
          return null;
        }
        finally
        {
          for (;;)
          {
            localObject1 = paramVarArgs;
            paramVarArgs = localObject4;
          }
        }
        localObject3 = this.mRequest.getRequestParameters();
        localObject5 = this.mClientAuthentication.getRequestParameters(this.mRequest.clientId);
        if (localObject5 != null) {
          ((Map)localObject3).putAll((Map)localObject5);
        }
        localObject3 = UriUtil.formUrlEncode((Map)localObject3);
        paramVarArgs.setRequestProperty("Content-Length", String.valueOf(((String)localObject3).length()));
        localObject5 = new OutputStreamWriter(paramVarArgs.getOutputStream());
        ((OutputStreamWriter)localObject5).write((String)localObject3);
        ((OutputStreamWriter)localObject5).flush();
        paramVarArgs = paramVarArgs.getInputStream();
        localObject1 = paramVarArgs;
        paramVarArgs = (Void[])localObject1;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1 = localJSONException1;
          localObject1 = null;
          paramVarArgs = (Void[])localObject1;
          Logger.debugWithStack(localJSONException1, "Failed to complete exchange request", new Object[0]);
          paramVarArgs = (Void[])localObject1;
          this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, localJSONException1);
          Utils.closeQuietly((InputStream)localObject1);
        }
      }
      finally
      {
        Utils.closeQuietly((InputStream)localObject1);
      }
    }
    
    protected void onPostExecute(JSONObject paramJSONObject)
    {
      if (this.mException != null)
      {
        this.mCallback.onTokenRequestCompleted(null, this.mException);
        return;
      }
      if (paramJSONObject.has("error")) {
        try
        {
          String str = paramJSONObject.getString("error");
          paramJSONObject = AuthorizationException.fromOAuthTemplate(AuthorizationException.TokenRequestErrors.byString(str), str, paramJSONObject.getString("error_description"), UriUtil.parseUriIfAvailable(paramJSONObject.getString("error_uri")));
          this.mCallback.onTokenRequestCompleted(null, paramJSONObject);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, paramJSONObject);
          }
        }
      }
      try
      {
        paramJSONObject = new TokenResponse.Builder(this.mRequest).fromResponseJson(paramJSONObject).build();
        Logger.debug("Token exchange with %s completed", new Object[] { this.mRequest.configuration.tokenEndpoint });
        this.mCallback.onTokenRequestCompleted(paramJSONObject, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, paramJSONObject));
      }
    }
  }
  
  public static abstract interface TokenResponseCallback
  {
    public abstract void onTokenRequestCompleted(@Nullable TokenResponse paramTokenResponse, @Nullable AuthorizationException paramAuthorizationException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationService
 * JD-Core Version:    0.7.0.1
 */