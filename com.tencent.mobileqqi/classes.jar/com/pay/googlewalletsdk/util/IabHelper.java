package com.pay.googlewalletsdk.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper
{
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
  public static final int IABHELPER_BAD_RESPONSE = -1002;
  public static final int IABHELPER_ERROR_BASE = -1000;
  public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
  public static final int IABHELPER_MISSING_TOKEN = -1007;
  public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
  public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
  public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
  public static final int IABHELPER_UNKNOWN_ERROR = -1008;
  public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
  public static final int IABHELPER_USER_CANCELLED = -1005;
  public static final int IABHELPER_VERIFICATION_FAILED = -1003;
  public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String ITEM_TYPE_SUBS = "subs";
  public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
  public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  boolean mAsyncInProgress = false;
  String mAsyncOperation = "";
  Context mContext;
  boolean mDebugLog = false;
  String mDebugTag = "IabHelper";
  boolean mDisposed = false;
  OnIabPurchaseFinishedListener mPurchaseListener;
  String mPurchasingItemType;
  int mRequestCode;
  IInAppBillingService mService;
  ServiceConnection mServiceConn;
  public boolean mSetupDone = false;
  String mSignatureBase64 = null;
  boolean mSubscriptionsSupported = false;
  
  public IabHelper(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mSignatureBase64 = paramString;
    logDebug("IAB helper created.");
  }
  
  private void checkNotDisposed()
  {
    if (this.mDisposed) {
      throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }
  }
  
  public static String getResponseDesc(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Cancelled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000)
    {
      int i = -1000 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length)) {
        return arrayOfString2[i];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  void checkSetupDone(String paramString)
  {
    if (!this.mSetupDone)
    {
      logError("Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  void consume(Purchase paramPurchase)
    throws IabException
  {
    checkNotDisposed();
    checkSetupDone("consume");
    if (!paramPurchase.mItemType.equals("inapp")) {
      throw new IabException(-1010, "Items of type '" + paramPurchase.mItemType + "' can't be consumed.");
    }
    String str2;
    try
    {
      String str1 = paramPurchase.getToken();
      str2 = paramPurchase.getSku();
      if ((str1 == null) || (str1.equals("")))
      {
        logError("Can't consume " + str2 + ". No token.");
        throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + str2 + " " + paramPurchase);
      }
    }
    catch (RemoteException localRemoteException)
    {
      throw new IabException(-1001, "Remote exception while consuming. PurchaseInfo: " + paramPurchase, localRemoteException);
    }
    logDebug("Consuming sku: " + str2 + ", token: " + localRemoteException);
    int i = this.mService.consumePurchase(3, this.mContext.getPackageName(), localRemoteException);
    if (i == 0)
    {
      logDebug("Successfully consumed sku: " + str2);
      return;
    }
    logDebug("Error consuming consuming sku " + str2 + ". " + getResponseDesc(i));
    throw new IabException(i, "Error consuming sku " + str2);
  }
  
  public void consumeAsync(Purchase paramPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPurchase);
    consumeAsyncInternal(localArrayList, paramOnConsumeFinishedListener, null);
  }
  
  public void consumeAsync(List<Purchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }
  
  void consumeAsyncInternal(final List<Purchase> paramList, final OnConsumeFinishedListener paramOnConsumeFinishedListener, final OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    final Handler localHandler = new Handler();
    flagStartAsync("consume");
    new Thread(new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            IabHelper.this.flagEndAsync();
            if ((!IabHelper.this.mDisposed) && (paramOnConsumeFinishedListener != null)) {
              localHandler.post(new Runnable()
              {
                public void run()
                {
                  this.val$singleListener.onConsumeFinished((Purchase)this.val$purchases.get(0), (IabResult)localArrayList.get(0));
                }
              });
            }
            if ((!IabHelper.this.mDisposed) && (paramOnConsumeMultiFinishedListener != null)) {
              localHandler.post(new Runnable()
              {
                public void run()
                {
                  this.val$multiListener.onConsumeMultiFinished(this.val$purchases, localArrayList);
                }
              });
            }
            return;
          }
          Purchase localPurchase = (Purchase)localIterator.next();
          try
          {
            IabHelper.this.consume(localPurchase);
            localArrayList.add(new IabResult(0, "Successful consume of sku " + localPurchase.getSku()));
          }
          catch (IabException localIabException)
          {
            localArrayList.add(localIabException.getResult());
          }
        }
      }
    }).start();
  }
  
  public void dispose()
  {
    logDebug("Disposing.");
    this.mSetupDone = false;
    if (this.mServiceConn != null)
    {
      logDebug("Unbinding from service.");
      if (this.mContext != null) {
        this.mContext.unbindService(this.mServiceConn);
      }
    }
    this.mDisposed = true;
    this.mContext = null;
    this.mServiceConn = null;
    this.mService = null;
    this.mPurchaseListener = null;
  }
  
  public void enableDebugLogging(boolean paramBoolean)
  {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
  }
  
  public void enableDebugLogging(boolean paramBoolean, String paramString)
  {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
    this.mDebugTag = paramString;
  }
  
  void flagEndAsync()
  {
    logDebug("Ending async operation: " + this.mAsyncOperation);
    this.mAsyncOperation = "";
    this.mAsyncInProgress = false;
  }
  
  void flagStartAsync(String paramString)
  {
    if (this.mAsyncInProgress) {
      throw new IllegalStateException("Can't start async operation (" + paramString + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
    }
    this.mAsyncOperation = paramString;
    this.mAsyncInProgress = true;
    logDebug("Starting async operation: " + paramString);
  }
  
  int getResponseCodeFromBundle(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      logDebug("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    logError("Unexpected type for bundle response code.");
    logError(paramBundle.getClass().getName());
    throw new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  int getResponseCodeFromIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      logError("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    logError("Unexpected type for intent response code.");
    logError(paramIntent.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
  
  /* Error */
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: getfield 417	com/pay/googlewalletsdk/util/IabHelper:mRequestCode	I
    //   5: if_icmpeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: invokespecial 230	com/pay/googlewalletsdk/util/IabHelper:checkNotDisposed	()V
    //   14: aload_0
    //   15: ldc_w 418
    //   18: invokevirtual 233	com/pay/googlewalletsdk/util/IabHelper:checkSetupDone	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 420	com/pay/googlewalletsdk/util/IabHelper:flagEndAsync	()V
    //   25: aload_3
    //   26: ifnonnull +44 -> 70
    //   29: aload_0
    //   30: ldc_w 422
    //   33: invokevirtual 220	com/pay/googlewalletsdk/util/IabHelper:logError	(Ljava/lang/String;)V
    //   36: new 424	com/pay/googlewalletsdk/util/IabResult
    //   39: dup
    //   40: sipush -1002
    //   43: ldc_w 426
    //   46: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   54: ifnull +14 -> 68
    //   57: aload_0
    //   58: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   61: aload_3
    //   62: aconst_null
    //   63: invokeinterface 431 3 0
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 433	com/pay/googlewalletsdk/util/IabHelper:getResponseCodeFromIntent	(Landroid/content/Intent;)I
    //   75: istore_1
    //   76: aload_3
    //   77: ldc 102
    //   79: invokevirtual 437	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 4
    //   84: aload_3
    //   85: ldc 108
    //   87: invokevirtual 437	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 5
    //   92: iload_2
    //   93: iconst_m1
    //   94: if_icmpne +377 -> 471
    //   97: iload_1
    //   98: ifne +373 -> 471
    //   101: aload_0
    //   102: ldc_w 439
    //   105: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: new 193	java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 441
    //   116: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload 4
    //   121: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: new 193	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 443
    //   138: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload 5
    //   143: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: new 193	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 445
    //   160: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_3
    //   164: invokevirtual 405	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   167: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: new 193	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 447
    //   184: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: getfield 449	com/pay/googlewalletsdk/util/IabHelper:mPurchasingItemType	Ljava/lang/String;
    //   191: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: ifnonnull +71 -> 278
    //   210: aload_0
    //   211: ldc_w 451
    //   214: invokevirtual 220	com/pay/googlewalletsdk/util/IabHelper:logError	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: new 193	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 445
    //   225: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_3
    //   229: invokevirtual 405	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   232: invokevirtual 452	android/os/Bundle:toString	()Ljava/lang/String;
    //   235: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   244: new 424	com/pay/googlewalletsdk/util/IabResult
    //   247: dup
    //   248: sipush -1008
    //   251: ldc_w 454
    //   254: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   257: astore_3
    //   258: aload_0
    //   259: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   262: ifnull +14 -> 276
    //   265: aload_0
    //   266: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   269: aload_3
    //   270: aconst_null
    //   271: invokeinterface 431 3 0
    //   276: iconst_1
    //   277: ireturn
    //   278: new 235	com/pay/googlewalletsdk/util/Purchase
    //   281: dup
    //   282: aload_0
    //   283: getfield 449	com/pay/googlewalletsdk/util/IabHelper:mPurchasingItemType	Ljava/lang/String;
    //   286: aload 4
    //   288: aload 5
    //   290: invokespecial 457	com/pay/googlewalletsdk/util/Purchase:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   293: astore_3
    //   294: aload_3
    //   295: invokevirtual 255	com/pay/googlewalletsdk/util/Purchase:getSku	()Ljava/lang/String;
    //   298: astore 6
    //   300: aload_0
    //   301: getfield 155	com/pay/googlewalletsdk/util/IabHelper:mSignatureBase64	Ljava/lang/String;
    //   304: aload 4
    //   306: aload 5
    //   308: invokestatic 463	com/pay/googlewalletsdk/util/Security:verifyPurchase	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   311: ifne +77 -> 388
    //   314: aload_0
    //   315: new 193	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 465
    //   322: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload 6
    //   327: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 220	com/pay/googlewalletsdk/util/IabHelper:logError	(Ljava/lang/String;)V
    //   336: new 424	com/pay/googlewalletsdk/util/IabResult
    //   339: dup
    //   340: sipush -1003
    //   343: new 193	java/lang/StringBuilder
    //   346: dup
    //   347: ldc_w 467
    //   350: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: aload 6
    //   355: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   364: astore 4
    //   366: aload_0
    //   367: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   370: ifnull +302 -> 672
    //   373: aload_0
    //   374: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   377: aload 4
    //   379: aload_3
    //   380: invokeinterface 431 3 0
    //   385: goto +287 -> 672
    //   388: aload_0
    //   389: ldc_w 469
    //   392: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   399: ifnull +24 -> 423
    //   402: aload_0
    //   403: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   406: new 424	com/pay/googlewalletsdk/util/IabResult
    //   409: dup
    //   410: iconst_0
    //   411: ldc_w 471
    //   414: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   417: aload_3
    //   418: invokeinterface 431 3 0
    //   423: iconst_1
    //   424: ireturn
    //   425: astore_3
    //   426: aload_0
    //   427: ldc_w 473
    //   430: invokevirtual 220	com/pay/googlewalletsdk/util/IabHelper:logError	(Ljava/lang/String;)V
    //   433: aload_3
    //   434: invokevirtual 476	org/json/JSONException:printStackTrace	()V
    //   437: new 424	com/pay/googlewalletsdk/util/IabResult
    //   440: dup
    //   441: sipush -1002
    //   444: ldc_w 473
    //   447: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   450: astore_3
    //   451: aload_0
    //   452: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   455: ifnull +14 -> 469
    //   458: aload_0
    //   459: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   462: aload_3
    //   463: aconst_null
    //   464: invokeinterface 431 3 0
    //   469: iconst_1
    //   470: ireturn
    //   471: iload_2
    //   472: iconst_m1
    //   473: if_icmpne +60 -> 533
    //   476: aload_0
    //   477: new 193	java/lang/StringBuilder
    //   480: dup
    //   481: ldc_w 478
    //   484: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: iload_1
    //   488: invokestatic 294	com/pay/googlewalletsdk/util/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   491: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   500: aload_0
    //   501: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   504: ifnull -81 -> 423
    //   507: new 424	com/pay/googlewalletsdk/util/IabResult
    //   510: dup
    //   511: iload_1
    //   512: ldc_w 480
    //   515: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   518: astore_3
    //   519: aload_0
    //   520: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   523: aload_3
    //   524: aconst_null
    //   525: invokeinterface 431 3 0
    //   530: goto -107 -> 423
    //   533: iload_2
    //   534: ifne +62 -> 596
    //   537: aload_0
    //   538: new 193	java/lang/StringBuilder
    //   541: dup
    //   542: ldc_w 482
    //   545: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: iload_1
    //   549: invokestatic 294	com/pay/googlewalletsdk/util/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   552: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokevirtual 169	com/pay/googlewalletsdk/util/IabHelper:logDebug	(Ljava/lang/String;)V
    //   561: new 424	com/pay/googlewalletsdk/util/IabResult
    //   564: dup
    //   565: sipush -1005
    //   568: ldc_w 484
    //   571: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   574: astore_3
    //   575: aload_0
    //   576: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   579: ifnull -156 -> 423
    //   582: aload_0
    //   583: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   586: aload_3
    //   587: aconst_null
    //   588: invokeinterface 431 3 0
    //   593: goto -170 -> 423
    //   596: aload_0
    //   597: new 193	java/lang/StringBuilder
    //   600: dup
    //   601: ldc_w 486
    //   604: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: iload_2
    //   608: invokestatic 488	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   611: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc_w 490
    //   617: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: iload_1
    //   621: invokestatic 294	com/pay/googlewalletsdk/util/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   624: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 220	com/pay/googlewalletsdk/util/IabHelper:logError	(Ljava/lang/String;)V
    //   633: new 424	com/pay/googlewalletsdk/util/IabResult
    //   636: dup
    //   637: sipush -1006
    //   640: ldc_w 492
    //   643: invokespecial 427	com/pay/googlewalletsdk/util/IabResult:<init>	(ILjava/lang/String;)V
    //   646: astore_3
    //   647: aload_0
    //   648: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   651: ifnull -228 -> 423
    //   654: aload_0
    //   655: getfield 345	com/pay/googlewalletsdk/util/IabHelper:mPurchaseListener	Lcom/pay/googlewalletsdk/util/IabHelper$OnIabPurchaseFinishedListener;
    //   658: aload_3
    //   659: aconst_null
    //   660: invokeinterface 431 3 0
    //   665: goto -242 -> 423
    //   668: astore_3
    //   669: goto -243 -> 426
    //   672: iconst_1
    //   673: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	IabHelper
    //   0	674	1	paramInt1	int
    //   0	674	2	paramInt2	int
    //   0	674	3	paramIntent	Intent
    //   82	296	4	localObject	Object
    //   90	217	5	str1	String
    //   298	56	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   278	294	425	org/json/JSONException
    //   294	385	668	org/json/JSONException
    //   388	395	668	org/json/JSONException
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    checkNotDisposed();
    checkSetupDone("launchPurchaseFlow");
    flagStartAsync("launchPurchaseFlow");
    if ((paramString2.equals("subs")) && (!this.mSubscriptionsSupported))
    {
      paramActivity = new IabResult(-1009, "Subscriptions are not available.");
      flagEndAsync();
      if (paramOnIabPurchaseFinishedListener != null) {
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          logDebug("Constructing buy intent for " + paramString1 + ", item type: " + paramString2);
          paramString3 = this.mService.getBuyIntent(3, this.mContext.getPackageName(), paramString1, paramString2, paramString3);
          int i = getResponseCodeFromBundle(paramString3);
          if (i != 0)
          {
            logError("Unable to buy item, Error response: " + getResponseDesc(i));
            flagEndAsync();
            paramActivity = new IabResult(i, "Unable to buy item");
            if (paramOnIabPurchaseFinishedListener == null) {
              continue;
            }
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
          }
        }
        catch (IntentSender.SendIntentException paramActivity)
        {
          logError("SendIntentException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          flagEndAsync();
          paramActivity = new IabResult(-1004, "Failed to send intent.");
          if (paramOnIabPurchaseFinishedListener != null)
          {
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
            return;
            paramString3 = (PendingIntent)paramString3.getParcelable("BUY_INTENT");
            logDebug("Launching buy intent for " + paramString1 + ". Request code: " + paramInt);
            this.mRequestCode = paramInt;
            this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
            this.mPurchasingItemType = paramString2;
            paramActivity.startIntentSenderForResult(paramString3.getIntentSender(), paramInt, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
          }
        }
        catch (RemoteException paramActivity)
        {
          logError("RemoteException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          flagEndAsync();
          paramActivity = new IabResult(-1001, "Remote exception while starting purchase flow");
        }
      }
    } while (paramOnIabPurchaseFinishedListener == null);
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  void logDebug(String paramString)
  {
    if (this.mDebugLog) {
      Log.d(this.mDebugTag, paramString);
    }
  }
  
  void logError(String paramString)
  {
    Log.e(this.mDebugTag, "In-app billing error: " + paramString);
  }
  
  void logWarn(String paramString)
  {
    Log.w(this.mDebugTag, "In-app billing warning: " + paramString);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList)
    throws IabException
  {
    return queryInventory(paramBoolean, paramList, null);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    checkNotDisposed();
    checkSetupDone("queryInventory");
    int i;
    try
    {
      paramList2 = new Inventory();
      i = queryPurchases(paramList2, "inapp");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException paramList1)
    {
      throw new IabException(-1001, "Remote exception while refreshing inventory.", paramList1);
      if (paramBoolean)
      {
        i = querySkuDetails("inapp", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of items).");
        }
      }
    }
    catch (JSONException paramList1)
    {
      throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", paramList1);
    }
    if (this.mSubscriptionsSupported)
    {
      i = queryPurchases(paramList2, "subs");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned subscriptions).");
      }
      if (paramBoolean)
      {
        i = querySkuDetails("subs", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of subscriptions).");
        }
      }
    }
    return paramList2;
  }
  
  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(final boolean paramBoolean, final List<String> paramList, final QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    final Handler localHandler = new Handler();
    checkNotDisposed();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    new Thread(new Runnable()
    {
      public void run()
      {
        final IabResult localIabResult1 = new IabResult(0, "Inventory refresh successful.");
        final Object localObject = null;
        try
        {
          Inventory localInventory = IabHelper.this.queryInventory(paramBoolean, paramList);
          localObject = localInventory;
        }
        catch (IabException localIabException)
        {
          for (;;)
          {
            IabResult localIabResult2 = localIabException.getResult();
          }
        }
        IabHelper.this.flagEndAsync();
        if ((!IabHelper.this.mDisposed) && (paramQueryInventoryFinishedListener != null)) {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              this.val$listener.onQueryInventoryFinished(localIabResult1, localObject);
            }
          });
        }
      }
    }).start();
  }
  
  int queryPurchases(Inventory paramInventory, String paramString)
    throws JSONException, RemoteException
  {
    logDebug("Querying owned items, item type: " + paramString);
    logDebug("Package name: " + this.mContext.getPackageName());
    int i = 0;
    Object localObject1 = null;
    int j;
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      logDebug("Calling getPurchases with continuation token: " + (String)localObject1);
      localObject1 = this.mService.getPurchases(3, this.mContext.getPackageName(), paramString, (String)localObject1);
      j = getResponseCodeFromBundle((Bundle)localObject1);
      logDebug("Owned items response: " + String.valueOf(j));
      if (j != 0)
      {
        logDebug("getPurchases() failed: " + getResponseDesc(j));
        return j;
      }
      if ((!((Bundle)localObject1).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_DATA_SIGNATURE_LIST")))
      {
        logError("Bundle returned from getPurchases() doesn't contain required fields.");
        return -1002;
      }
      localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      int k = 0;
      j = i;
      i = k;
      if (i < localArrayList1.size()) {
        break;
      }
      localObject2 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
      logDebug("Continuation token: " + (String)localObject2);
      localObject1 = localObject2;
      i = j;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    if (j != 0) {}
    for (i = -1003;; i = 0)
    {
      return i;
      String str1 = (String)localArrayList1.get(i);
      Object localObject3 = (String)localArrayList2.get(i);
      String str2 = (String)((ArrayList)localObject2).get(i);
      if (Security.verifyPurchase(this.mSignatureBase64, str1, (String)localObject3))
      {
        logDebug("Sku is owned: " + str2);
        localObject3 = new Purchase(paramString, str1, (String)localObject3);
        if (TextUtils.isEmpty(((Purchase)localObject3).getToken()))
        {
          logWarn("BUG: empty/null token!");
          logDebug("Purchase data: " + str1);
        }
        paramInventory.addPurchase((Purchase)localObject3);
      }
      for (;;)
      {
        i += 1;
        break;
        logWarn("Purchase signature verification **FAILED**. Not adding item.");
        logDebug("   Purchase data: " + str1);
        logDebug("   Signature: " + (String)localObject3);
        j = 1;
      }
    }
  }
  
  int querySkuDetails(String paramString, Inventory paramInventory, List<String> paramList)
    throws RemoteException, JSONException
  {
    logDebug("Querying SKU details.");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(paramInventory.getAllOwnedSkus(paramString));
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {}
    }
    else
    {
      if (((ArrayList)localObject).size() != 0) {
        break label96;
      }
      logDebug("queryPrices: nothing to do because there are no SKUs.");
    }
    for (;;)
    {
      return 0;
      String str = (String)paramList.next();
      if (((ArrayList)localObject).contains(str)) {
        break;
      }
      ((ArrayList)localObject).add(str);
      break;
      label96:
      paramList = new Bundle();
      paramList.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject);
      paramList = this.mService.getSkuDetails(3, this.mContext.getPackageName(), paramString, paramList);
      if (!paramList.containsKey("DETAILS_LIST"))
      {
        int i = getResponseCodeFromBundle(paramList);
        if (i != 0)
        {
          logDebug("getSkuDetails() failed: " + getResponseDesc(i));
          return i;
        }
        logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return -1002;
      }
      paramList = paramList.getStringArrayList("DETAILS_LIST").iterator();
      while (paramList.hasNext())
      {
        localObject = new SkuDetails(paramString, (String)paramList.next());
        logDebug("Got sku details: " + localObject);
        paramInventory.addSkuDetails((SkuDetails)localObject);
      }
    }
  }
  
  public void startSetup(final OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    checkNotDisposed();
    if (this.mSetupDone) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    logDebug("Starting in-app billing setup.");
    this.mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (IabHelper.this.mDisposed) {
          return;
        }
        IabHelper.this.logDebug("Billing service connected.");
        IabHelper.this.mService = IInAppBillingService.Stub.asInterface(paramAnonymousIBinder);
        paramAnonymousComponentName = IabHelper.this.mContext.getPackageName();
        try
        {
          IabHelper.this.logDebug("Checking for in-app billing 3 support.");
          i = IabHelper.this.mService.isBillingSupported(3, paramAnonymousComponentName, "inapp");
          if (i != 0)
          {
            if (paramOnIabSetupFinishedListener != null) {
              paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(i, "Error checking for billing v3 support."));
            }
            IabHelper.this.mSubscriptionsSupported = false;
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          if (paramOnIabSetupFinishedListener != null) {
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1001, "RemoteException while setting up in-app billing."));
          }
          paramAnonymousComponentName.printStackTrace();
          return;
        }
        IabHelper.this.logDebug("In-app billing version 3 supported for " + paramAnonymousComponentName);
        int i = IabHelper.this.mService.isBillingSupported(3, paramAnonymousComponentName, "subs");
        if (i == 0)
        {
          IabHelper.this.logDebug("Subscriptions AVAILABLE.");
          IabHelper.this.mSubscriptionsSupported = true;
        }
        for (;;)
        {
          IabHelper.this.mSetupDone = true;
          if (paramOnIabSetupFinishedListener == null) {
            break;
          }
          paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
          return;
          IabHelper.this.logDebug("Subscriptions NOT AVAILABLE. Response: " + i);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        IabHelper.this.logDebug("Billing service disconnected.");
        IabHelper.this.mService = null;
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    if (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()) {
      this.mContext.bindService(localIntent, this.mServiceConn, 1);
    }
    while (paramOnIabSetupFinishedListener == null) {
      return;
    }
    paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
  }
  
  public boolean subscriptionsSupported()
  {
    checkNotDisposed();
    return this.mSubscriptionsSupported;
  }
  
  public static abstract interface OnConsumeFinishedListener
  {
    public abstract void onConsumeFinished(Purchase paramPurchase, IabResult paramIabResult);
  }
  
  public static abstract interface OnConsumeMultiFinishedListener
  {
    public abstract void onConsumeMultiFinished(List<Purchase> paramList, List<IabResult> paramList1);
  }
  
  public static abstract interface OnIabPurchaseFinishedListener
  {
    public abstract void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase);
  }
  
  public static abstract interface OnIabSetupFinishedListener
  {
    public abstract void onIabSetupFinished(IabResult paramIabResult);
  }
  
  public static abstract interface OnQueryFinishedListener
  {
    public abstract void onQueryFailured(String paramString, int paramInt);
    
    public abstract void onQueryFinished(ArrayList<SkuDetails> paramArrayList);
  }
  
  public static abstract interface QueryInventoryFinishedListener
  {
    public abstract void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.IabHelper
 * JD-Core Version:    0.7.0.1
 */