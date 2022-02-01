package net.openid.appauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import java.util.Set;

public class AuthorizationManagementActivity
  extends Activity
{
  @VisibleForTesting
  static final String KEY_AUTHORIZATION_STARTED = "authStarted";
  @VisibleForTesting
  static final String KEY_AUTH_INTENT = "authIntent";
  @VisibleForTesting
  static final String KEY_AUTH_REQUEST = "authRequest";
  @VisibleForTesting
  static final String KEY_CANCEL_INTENT = "cancelIntent";
  @VisibleForTesting
  static final String KEY_COMPLETE_INTENT = "completeIntent";
  private Intent mAuthIntent;
  private AuthorizationRequest mAuthRequest;
  private boolean mAuthorizationStarted = false;
  private PendingIntent mCancelIntent;
  private Clock mClock = SystemClock.INSTANCE;
  private PendingIntent mCompleteIntent;
  
  private static Intent createBaseIntent(Context paramContext)
  {
    return new Intent(paramContext, AuthorizationManagementActivity.class);
  }
  
  public static Intent createResponseHandlingIntent(Context paramContext, Uri paramUri)
  {
    paramContext = createBaseIntent(paramContext);
    paramContext.setData(paramUri);
    paramContext.addFlags(603979776);
    return paramContext;
  }
  
  public static Intent createStartIntent(Context paramContext, AuthorizationRequest paramAuthorizationRequest, Intent paramIntent, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    paramContext = createBaseIntent(paramContext);
    paramContext.putExtra("authIntent", paramIntent);
    paramContext.putExtra("authRequest", paramAuthorizationRequest.jsonSerializeString());
    paramContext.putExtra("completeIntent", paramPendingIntent1);
    paramContext.putExtra("cancelIntent", paramPendingIntent2);
    return paramContext;
  }
  
  private Intent extractResponseData(Uri paramUri)
  {
    if (paramUri.getQueryParameterNames().contains("error")) {
      return AuthorizationException.fromOAuthRedirect(paramUri).toIntent();
    }
    paramUri = new AuthorizationResponse.Builder(this.mAuthRequest).fromUri(paramUri, this.mClock).build();
    if (((this.mAuthRequest.state == null) && (paramUri.state != null)) || ((this.mAuthRequest.state != null) && (!this.mAuthRequest.state.equals(paramUri.state))))
    {
      Logger.warn("State returned in authorization response (%s) does not match state from request (%s) - discarding response", new Object[] { paramUri.state, this.mAuthRequest.state });
      return AuthorizationException.AuthorizationRequestErrors.STATE_MISMATCH.toIntent();
    }
    return paramUri.toIntent();
  }
  
  /* Error */
  private void extractState(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +17 -> 18
    //   4: ldc 156
    //   6: iconst_0
    //   7: anewarray 137	java/lang/Object
    //   10: invokestatic 143	net/openid/appauth/Logger:warn	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: invokevirtual 159	net/openid/appauth/AuthorizationManagementActivity:finish	()V
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: ldc 12
    //   22: invokevirtual 165	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   25: checkcast 51	android/content/Intent
    //   28: putfield 167	net/openid/appauth/AuthorizationManagementActivity:mAuthIntent	Landroid/content/Intent;
    //   31: aload_0
    //   32: aload_1
    //   33: ldc 8
    //   35: iconst_0
    //   36: invokevirtual 171	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   39: putfield 46	net/openid/appauth/AuthorizationManagementActivity:mAuthorizationStarted	Z
    //   42: aload_1
    //   43: ldc 15
    //   45: aconst_null
    //   46: invokevirtual 175	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +40 -> 91
    //   54: aload_2
    //   55: invokestatic 179	net/openid/appauth/AuthorizationRequest:jsonDeserialize	(Ljava/lang/String;)Lnet/openid/appauth/AuthorizationRequest;
    //   58: astore_2
    //   59: aload_0
    //   60: aload_2
    //   61: putfield 111	net/openid/appauth/AuthorizationManagementActivity:mAuthRequest	Lnet/openid/appauth/AuthorizationRequest;
    //   64: aload_0
    //   65: aload_1
    //   66: ldc 21
    //   68: invokevirtual 165	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   71: checkcast 181	android/app/PendingIntent
    //   74: putfield 183	net/openid/appauth/AuthorizationManagementActivity:mCompleteIntent	Landroid/app/PendingIntent;
    //   77: aload_0
    //   78: aload_1
    //   79: ldc 18
    //   81: invokevirtual 165	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   84: checkcast 181	android/app/PendingIntent
    //   87: putfield 185	net/openid/appauth/AuthorizationManagementActivity:mCancelIntent	Landroid/app/PendingIntent;
    //   90: return
    //   91: aconst_null
    //   92: astore_2
    //   93: goto -34 -> 59
    //   96: astore_1
    //   97: new 187	java/lang/IllegalStateException
    //   100: dup
    //   101: ldc 189
    //   103: aload_1
    //   104: invokespecial 192	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	AuthorizationManagementActivity
    //   0	108	1	paramBundle	Bundle
    //   49	44	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	50	96	org/json/JSONException
    //   54	59	96	org/json/JSONException
    //   59	64	96	org/json/JSONException
  }
  
  private void handleAuthorizationCanceled()
  {
    Logger.debug("Authorization flow canceled by user", new Object[0]);
    if (this.mCancelIntent != null) {
      try
      {
        this.mCancelIntent.send();
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Logger.error("Failed to send cancel intent", new Object[] { localCanceledException });
        return;
      }
    }
    Logger.debug("No cancel intent set - will return to previous activity", new Object[0]);
  }
  
  private void handleAuthorizationComplete()
  {
    Intent localIntent = extractResponseData(getIntent().getData());
    if (localIntent == null)
    {
      Logger.error("Failed to extract OAuth2 response from redirect", new Object[0]);
      return;
    }
    Logger.debug("Authorization complete - invoking completion intent", new Object[0]);
    try
    {
      this.mCompleteIntent.send(this, 0, localIntent);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      Logger.error("Failed to send completion intent", new Object[] { localCanceledException });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      extractState(getIntent().getExtras());
      return;
    }
    extractState(paramBundle);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.mAuthorizationStarted)
    {
      startActivity(this.mAuthIntent);
      this.mAuthorizationStarted = true;
      return;
    }
    if (getIntent().getData() != null) {
      handleAuthorizationComplete();
    }
    for (;;)
    {
      finish();
      return;
      handleAuthorizationCanceled();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("authStarted", this.mAuthorizationStarted);
    paramBundle.putParcelable("authIntent", this.mAuthIntent);
    paramBundle.putString("authRequest", this.mAuthRequest.jsonSerializeString());
    paramBundle.putParcelable("completeIntent", this.mCompleteIntent);
    paramBundle.putParcelable("cancelIntent", this.mCancelIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationManagementActivity
 * JD-Core Version:    0.7.0.1
 */