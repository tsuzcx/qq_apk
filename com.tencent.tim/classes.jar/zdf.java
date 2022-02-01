import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.8;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class zdf
  implements Handler.Callback
{
  private final long KV = 60000L;
  protected aqju X;
  protected arhz a;
  private zdy a;
  private String aMk;
  private String aMl;
  public boolean aRg;
  private String aZT;
  private String aZU;
  private String aZV;
  private final MqqHandler b = new aurf(Looper.getMainLooper(), this);
  public boolean bqN;
  private Runnable eV = new SDKEmotionSettingManager.6(this);
  private Runnable eW = new SDKEmotionSettingManager.7(this);
  private Runnable eX = new SDKEmotionSettingManager.8(this);
  private boolean isTimeOut;
  private Activity mActivity;
  private boolean mIsUploading;
  private String mPkgName;
  private List<Integer> tX;
  private List<String> tY = new ArrayList();
  private List<Uri> tZ = new ArrayList();
  protected aqju x;
  
  public zdf(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " onCreateView ");
    }
    this.mActivity = paramActivity;
  }
  
  private void Fb(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "handleStopUpload totalSize =" + paramInt + ", mCurrentUploadedList = " + this.tX);
    }
    this.b.removeMessages(11);
    cot();
    if (this.tX != null)
    {
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.tX.size()) {
          break;
        }
        k = i;
        if (((Integer)this.tX.get(j)).intValue() == 0) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.20(this, paramInt, k, paramInt - k));
  }
  
  private void K(int paramInt, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "handleFinishUpload addEmotionsResults =" + paramList + ", totalSize =" + paramInt);
    }
    if ((paramInt == 0) || (paramList == null)) {}
    while (paramInt != paramList.size()) {
      return;
    }
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < paramList.size())
    {
      if (((Integer)paramList.get(i)).intValue() == 0) {
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
      }
    }
    String str = x(paramList);
    ThreadManager.getUIHandler().postDelayed(new SDKEmotionSettingManager.21(this, paramInt, j, str, paramList, k), 200L);
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkSuccessCallback:sdk callback= appid=" + paramLong);
        }
        Object localObject = new Intent();
        if (paramBoolean) {
          ((Intent)localObject).putExtra("stay_back_stack", true);
        }
        ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
        if (paramActivity.getIntent() != null) {
          ((Intent)localObject).setPackage(this.mPkgName);
        }
        try
        {
          localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
            return;
          }
        }
        catch (ActivityNotFoundException paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkErrorCallback:sdk callback= appid=" + paramLong);
        }
        Intent localIntent = new Intent();
        if (paramBoolean) {
          localIntent.putExtra("stay_back_stack", true);
        }
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion", Integer.valueOf(-1), str })));
        if (paramActivity.getIntent() != null) {
          localIntent.setPackage(this.mPkgName);
        }
        try
        {
          paramString = PendingIntent.getActivity(paramActivity, 0, localIntent, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", paramString);
            return;
          }
        }
        catch (Exception paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.mActivity.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "showResultDialog is finishing return");
      }
      return;
    }
    if (TextUtils.isEmpty(this.aZT)) {}
    for (String str = acfp.m(2131714083);; str = acfp.m(2131714083) + this.aZT)
    {
      aqju localaqju = aqha.a(this.mActivity, 230);
      localaqju.setTitle(paramString1);
      localaqju.setMessage(paramString2);
      localaqju.setPositiveButton("留在QQ", new zds(this, paramBoolean, paramString3)).setNegativeButton(str, new zdr(this, paramBoolean, paramString3)).show();
      return;
    }
  }
  
  private void by(int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.mActivity == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mActivity.getResources();
    } while (localObject == null);
    String str = "";
    if (paramInt == 0)
    {
      localObject = ((Resources)localObject).getString(2131692372);
      a((String)localObject, str, bool, paramString);
      if (!bool) {
        break label209;
      }
      paramString = "1";
      label61:
      if (!bool) {
        break label216;
      }
    }
    label209:
    label216:
    for (str = "0";; str = "1")
    {
      anot.a(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.aMk, "1", paramString + "", str + "");
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        str = ((Resources)localObject).getString(2131692364);
        localObject = null;
        bool = false;
        break;
      }
      if (paramInt == 1)
      {
        str = ((Resources)localObject).getString(2131692369);
        localObject = null;
        bool = false;
        break;
      }
      str = ((Resources)localObject).getString(2131692367);
      localObject = null;
      bool = false;
      break;
      paramString = "0";
      break label61;
    }
  }
  
  /* Error */
  private void coq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 108	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: getfield 103	zdf:mActivity	Landroid/app/Activity;
    //   13: ldc_w 435
    //   16: invokevirtual 436	android/app/Activity:getString	(I)Ljava/lang/String;
    //   19: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 297	zdf:aZT	Ljava/lang/String;
    //   26: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   37: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +276 -> 316
    //   43: aload_0
    //   44: getfield 103	zdf:mActivity	Landroid/app/Activity;
    //   47: invokevirtual 440	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   50: aload_0
    //   51: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   54: bipush 64
    //   56: invokevirtual 446	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   59: astore 4
    //   61: aload_2
    //   62: astore_1
    //   63: aload 4
    //   65: ifnull +51 -> 116
    //   68: aload 4
    //   70: getfield 452	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   73: astore 4
    //   75: aload_2
    //   76: astore_1
    //   77: aload 4
    //   79: ifnull +37 -> 116
    //   82: aload_2
    //   83: astore_1
    //   84: aload 4
    //   86: arraylength
    //   87: ifle +29 -> 116
    //   90: ldc_w 454
    //   93: invokestatic 460	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   96: astore_1
    //   97: aload_1
    //   98: aload 4
    //   100: iconst_0
    //   101: aaload
    //   102: invokevirtual 466	android/content/pm/Signature:toByteArray	()[B
    //   105: invokevirtual 470	java/security/MessageDigest:update	([B)V
    //   108: aload_1
    //   109: invokevirtual 473	java/security/MessageDigest:digest	()[B
    //   112: invokestatic 479	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   115: astore_1
    //   116: ldc 95
    //   118: iconst_1
    //   119: bipush 8
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc_w 481
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_0
    //   133: getfield 197	zdf:aMk	Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_2
    //   139: ldc_w 483
    //   142: aastore
    //   143: dup
    //   144: iconst_3
    //   145: aload_0
    //   146: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   149: aastore
    //   150: dup
    //   151: iconst_4
    //   152: ldc_w 485
    //   155: aastore
    //   156: dup
    //   157: iconst_5
    //   158: aload_1
    //   159: aastore
    //   160: dup
    //   161: bipush 6
    //   163: ldc_w 487
    //   166: aastore
    //   167: dup
    //   168: bipush 7
    //   170: aload_0
    //   171: getfield 489	zdf:aZU	Ljava/lang/String;
    //   174: aastore
    //   175: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 197	zdf:aMk	Ljava/lang/String;
    //   182: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +20 -> 205
    //   188: aload_0
    //   189: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   192: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne +10 -> 205
    //   198: aload_1
    //   199: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +140 -> 342
    //   205: ldc 95
    //   207: iconst_1
    //   208: bipush 6
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc_w 494
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_0
    //   222: getfield 197	zdf:aMk	Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: ldc_w 496
    //   231: aastore
    //   232: dup
    //   233: iconst_3
    //   234: aload_0
    //   235: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_4
    //   241: ldc_w 498
    //   244: aastore
    //   245: dup
    //   246: iconst_5
    //   247: aload_1
    //   248: aastore
    //   249: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: aload_0
    //   253: getfield 103	zdf:mActivity	Landroid/app/Activity;
    //   256: sipush 230
    //   259: invokestatic 315	aqha:a	(Landroid/content/Context;I)Laqju;
    //   262: astore_1
    //   263: aload_1
    //   264: ldc_w 502
    //   267: invokestatic 310	acfp:m	(I)Ljava/lang/String;
    //   270: invokevirtual 325	aqju:setMessage	(Ljava/lang/CharSequence;)Laqju;
    //   273: pop
    //   274: aload_1
    //   275: ldc_w 503
    //   278: new 505	zdq
    //   281: dup
    //   282: aload_0
    //   283: invokespecial 506	zdq:<init>	(Lzdf;)V
    //   286: invokevirtual 509	aqju:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Laqju;
    //   289: pop
    //   290: aload_1
    //   291: iconst_0
    //   292: invokevirtual 513	aqju:setCancelable	(Z)V
    //   295: aload_1
    //   296: invokevirtual 345	aqju:show	()V
    //   299: return
    //   300: astore_1
    //   301: ldc 95
    //   303: iconst_1
    //   304: ldc_w 515
    //   307: aload_1
    //   308: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload_2
    //   312: astore_1
    //   313: goto -197 -> 116
    //   316: ldc 95
    //   318: iconst_1
    //   319: ldc_w 520
    //   322: invokestatic 522	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_2
    //   326: astore_1
    //   327: goto -211 -> 116
    //   330: astore_1
    //   331: ldc 95
    //   333: iconst_1
    //   334: ldc_w 524
    //   337: aload_1
    //   338: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: return
    //   342: invokestatic 529	tzk:prepare	()V
    //   345: new 531	android/os/Bundle
    //   348: dup
    //   349: invokespecial 532	android/os/Bundle:<init>	()V
    //   352: astore_2
    //   353: aload_2
    //   354: ldc_w 534
    //   357: aload_0
    //   358: getfield 489	zdf:aZU	Ljava/lang/String;
    //   361: invokevirtual 538	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_2
    //   365: ldc_w 540
    //   368: aload_0
    //   369: getfield 253	zdf:mPkgName	Ljava/lang/String;
    //   372: invokevirtual 538	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_2
    //   376: ldc_w 542
    //   379: aload_1
    //   380: invokevirtual 538	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: ldc_w 543
    //   387: invokevirtual 546	zdf:am	(I)V
    //   390: aload_0
    //   391: getfield 70	zdf:b	Lmqq/os/MqqHandler;
    //   394: aload_0
    //   395: getfield 77	zdf:eV	Ljava/lang/Runnable;
    //   398: ldc2_w 547
    //   401: invokevirtual 190	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   404: pop
    //   405: aload_0
    //   406: getfield 103	zdf:mActivity	Landroid/app/Activity;
    //   409: iconst_1
    //   410: aload_0
    //   411: getfield 197	zdf:aMk	Ljava/lang/String;
    //   414: aload_2
    //   415: invokestatic 551	tzk:a	(Landroid/app/Activity;ILjava/lang/String;Landroid/os/Bundle;)Ltzg;
    //   418: ldc_w 553
    //   421: aconst_null
    //   422: new 555	zdt
    //   425: dup
    //   426: aload_0
    //   427: aload_3
    //   428: invokespecial 558	zdt:<init>	(Lzdf;Ljava/lang/String;)V
    //   431: invokevirtual 563	tzg:a	(Ljava/lang/String;Lorg/json/JSONObject;Ltzd;)V
    //   434: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	zdf
    //   62	234	1	localObject1	Object
    //   300	8	1	localException1	Exception
    //   312	15	1	localBundle1	android.os.Bundle
    //   330	50	1	localException2	Exception
    //   1	414	2	localBundle2	android.os.Bundle
    //   32	396	3	str	String
    //   59	40	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	61	300	java/lang/Exception
    //   68	75	300	java/lang/Exception
    //   84	116	300	java/lang/Exception
    //   252	299	330	java/lang/Exception
  }
  
  private void cor()
  {
    boolean bool = ForwardUtils.aL(this.mActivity);
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "setEmotion hasPermission=", Boolean.valueOf(bool) });
    if (!bool)
    {
      aczy.a((AppActivity)this.mActivity, 3, new zdu(this));
      return;
    }
    he(this.tZ);
  }
  
  private void cos()
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction mShareAppId = " + this.aMk + "， mShareOpenId =" + this.aMl);
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.mActivity, Long.valueOf(this.aMk).longValue(), false, "-10");
      handleCancel();
      return;
    }
    if ((TextUtils.isEmpty(this.aMk)) || (TextUtils.isEmpty(this.aMl)))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction find third app not login setEmotion");
      hideProgressDialog();
      cor();
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OpenID localOpenID = localQQAppInterface.a().a(this.aMk);
    if (localOpenID == null)
    {
      am(2131720190);
      this.b.postDelayed(this.eW, 8000L);
      try
      {
        long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        localQQAppInterface.a().a(l, this.aMl, Long.valueOf(this.aMk).longValue(), new zdw(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("SDKEmotionSettingManager", 1, "-->parse uin exception:", localException);
        return;
      }
    }
    if (!this.aMl.equals(localOpenID.openID))
    {
      QLog.i("SDKEmotionSettingManager", 1, "-->preForward--openid doesn't equal current local openid");
      bFG();
      return;
    }
    hideProgressDialog();
    cor();
  }
  
  private void cot()
  {
    ((afhv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).cZD();
  }
  
  private void cov()
  {
    for (;;)
    {
      try
      {
        localPendingIntent = (PendingIntent)this.mActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
        if (localPendingIntent != null) {
          if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "-->finish--send callback using PendingIntent");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        PendingIntent localPendingIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SDKEmotionSettingManager", 2, "qbShowShareResultDialog ", localThrowable);
      }
      try
      {
        localPendingIntent.send();
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        QLog.e("SDKEmotionSettingManager", 2, "failed to send PendingIntent", localCanceledException);
        return;
      }
    }
  }
  
  private void di(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.isTimeOut = false;
    int i = paramArrayList.size();
    Message localMessage = this.b.obtainMessage(11);
    localMessage.arg1 = i;
    this.b.sendMessageDelayed(localMessage, 60000L);
    ((afhv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).a(paramArrayList, new zdp(this, i));
  }
  
  private void g(Activity paramActivity, long paramLong)
  {
    if (paramActivity == null) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "startSdkCancelCallback:sdk callback= appid=" + paramLong);
        }
        Object localObject = new Intent();
        ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
        if (paramActivity.getIntent() != null) {
          ((Intent)localObject).setPackage(this.mPkgName);
        }
        try
        {
          localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
          paramActivity = paramActivity.getIntent();
          if (paramActivity != null)
          {
            paramActivity.removeExtra("sdk_emotion_pending_intent");
            paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
            return;
          }
        }
        catch (ActivityNotFoundException paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
  }
  
  private void handleCancel()
  {
    this.b.removeMessages(11);
    cou();
    this.mActivity.moveTaskToBack(true);
  }
  
  private void he(List<Uri> paramList)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { " openSetEmotion uriList = ", paramList });
    ((afhv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(103)).cYZ();
    this.b.postDelayed(this.eX, 2000L);
    new zdg(this, paramList).execute(new Void[0]);
  }
  
  private void hf(List<Integer> paramList)
  {
    if (this.tX == null) {
      this.tX = new ArrayList();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.tX.clear();
      this.tX.addAll(paramList);
      return;
    }
    this.tX.clear();
  }
  
  private void n(int paramInt, float paramFloat)
  {
    if (this.mActivity.isFinishing()) {}
    while ((this.jdField_a_of_type_Zdy == null) || (!this.jdField_a_of_type_Zdy.isShowing())) {
      return;
    }
    int i = (int)(paramInt * paramFloat);
    int j = (int)(paramFloat * 100.0D);
    String str = String.format(this.mActivity.getResources().getString(2131692368), new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "updateCurrentDisplay displayStr=" + str + " disPlayProgress=" + j + ", currentCount = " + i);
    }
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.19(this, str, j));
  }
  
  private void resetStatus()
  {
    this.aRg = false;
    this.bqN = false;
  }
  
  private String x(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (j == 0) {
        localStringBuilder.append("0_");
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 1) {
          localStringBuilder.append("102_");
        } else if (j == 3) {
          localStringBuilder.append("100_");
        } else if (j == 2) {
          localStringBuilder.append("100_");
        } else {
          localStringBuilder.append("101_");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void x(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "showResultDialog successCount =" + paramInt1 + ", failCount =" + paramInt2);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      break label53;
    }
    label53:
    while ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    String str = "";
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      str = String.format(this.mActivity.getResources().getString(2131692371), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      a(null, str, bool, paramString);
      anot.a(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.aMk, paramInt1 + paramInt2 + "", paramInt1 + "", paramInt2 + "");
      if (paramInt2 <= 0) {
        break;
      }
      anot.a(null, "dc00898", "", "", "0X8009DCC", "0X8009DCC", 0, 0, "" + paramInt2, "", "", "");
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        str = String.format(this.mActivity.getResources().getString(2131692373), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 + paramInt2), Integer.valueOf(paramInt2) });
        bool = false;
      }
      else if ((paramInt1 == 0) && (paramInt2 > 0))
      {
        str = String.format(this.mActivity.getResources().getString(2131692366), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt2) });
        bool = false;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    if (!this.mActivity.isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  protected void bFG()
  {
    if (this.x != null)
    {
      if (!this.x.isShowing()) {
        this.x.show();
      }
      return;
    }
    this.x = aqha.a(this.mActivity, 230);
    this.x.setMessage(acfp.m(2131714084));
    this.x.setTitle(2131693317);
    zdi localzdi = new zdi(this);
    this.x.setNegativeButton(2131721058, localzdi);
    this.x.setPositiveButton(2131720034, localzdi);
    this.x.show();
  }
  
  public void cA(Intent paramIntent)
  {
    this.aZV = paramIntent.getStringExtra("key_from_sdk_set_emotion_uri_list");
    this.tZ = paramIntent.getParcelableArrayListExtra("key_from_sdk_set_emotion_uri");
    this.aZT = paramIntent.getStringExtra("key_from_sdk_set_emotion_appname");
    this.aMk = paramIntent.getStringExtra("key_from_sdk_set_emotion_share_id");
    this.aMl = paramIntent.getStringExtra("key_from_sdk_set_emotion_open_id");
    this.mPkgName = paramIntent.getStringExtra("pkg_name");
    this.aZU = paramIntent.getStringExtra("sdk_version");
    resetStatus();
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " initParam ");
    }
  }
  
  public void caS()
  {
    Intent localIntent = new Intent();
    PendingIntent localPendingIntent = (PendingIntent)this.mActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
    if (localPendingIntent != null)
    {
      QLog.d("SDKEmotionSettingManager", 1, "onBackEvent using PendingIntent");
      localIntent.putExtra("activity_finish_run_pendingIntent", localPendingIntent);
    }
    localIntent.setClass(this.mActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("fragment_id", 1);
    this.mActivity.startActivity(localIntent);
  }
  
  protected void cou()
  {
    cov();
    Intent localIntent = new Intent();
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
  }
  
  protected void dU(String paramString1, String paramString2)
  {
    if (this.X != null) {
      this.X.dismiss();
    }
    this.x = aqha.a(this.mActivity, 230);
    this.x.setMessage(paramString1);
    paramString1 = new zdx(this);
    this.x.setNegativeButton(paramString2, paramString1);
    this.x.setOnKeyListener(new zdh(this));
    this.x.show();
  }
  
  public void dh(ArrayList<String> paramArrayList)
  {
    QLog.i("SDKEmotionSettingManager", 1, "showPreviewDialog list =" + paramArrayList);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog list null error");
      return;
    }
    int i = paramArrayList.size();
    this.jdField_a_of_type_Zdy = new zdy(this.mActivity);
    this.jdField_a_of_type_Zdy.a("收藏为QQ表情");
    this.jdField_a_of_type_Zdy.a(2131721058, new zdj(this));
    this.jdField_a_of_type_Zdy.c(2131692356, new zdk(this, paramArrayList, i));
    this.jdField_a_of_type_Zdy.b(2131692357, new zdl(this, i));
    this.jdField_a_of_type_Zdy.a(paramArrayList, new zdm(this, i, paramArrayList));
    if (i > 1)
    {
      paramArrayList = String.format(this.mActivity.getResources().getString(2131692365), new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_Zdy.b(paramArrayList);
    }
    this.jdField_a_of_type_Zdy.setOnDismissListener(new zdn(this));
    this.jdField_a_of_type_Zdy.setOnKeyListener(new zdo(this, i));
    this.jdField_a_of_type_Zdy.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Zdy.show();
    AbstractGifImage.resumeAll();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    this.isTimeOut = true;
    Fb(paramMessage.arg1);
    return true;
  }
  
  public void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void onDestory()
  {
    this.b.removeMessages(11);
    if (this.jdField_a_of_type_Zdy != null) {
      this.jdField_a_of_type_Zdy.dismiss();
    }
    this.tY.clear();
    this.mIsUploading = false;
    this.isTimeOut = false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Zdy != null) && (this.jdField_a_of_type_Zdy.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, " onNewIntent return error");
      }
      paramIntent = null;
      if (this.tY != null)
      {
        paramIntent = new StringBuilder();
        Iterator localIterator = this.tY.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramIntent.append("104_");
        }
        paramIntent = paramIntent.toString();
      }
      a(this.mActivity, Long.valueOf(this.aMk).longValue(), false, paramIntent);
      cov();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, " onNewIntent start new");
    }
    this.mActivity.setIntent(paramIntent);
    cA(paramIntent);
    start();
  }
  
  public void start()
  {
    coq();
  }
  
  public ArrayList<String> t(List<Uri> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      localArrayList.addAll(paramList);
    }
    while (localArrayList.size() == 0)
    {
      return null;
      if (!TextUtils.isEmpty(this.aZV)) {
        try
        {
          paramList = this.aZV.split(";");
          i = 0;
          while (i < paramList.length)
          {
            localArrayList.add(Uri.parse(paramList[i]));
            i += 1;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (Exception paramList)
        {
          QLog.d("SDKEmotionSettingManager", 1, " openSetEmotion mComingStrUriList parse error!", paramList);
        }
      } else {
        QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion JSONArray currentUris = " + localArrayList);
      }
    }
    paramList = new ArrayList();
    ahwp localahwp = new ahwp(this.mActivity, false, null);
    int i = 0;
    while (i < localArrayList.size())
    {
      String str = localahwp.a((Uri)localArrayList.get(i), false);
      if (!TextUtils.isEmpty(str)) {
        paramList.add(str);
      }
      i += 1;
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdf
 * JD-Core Version:    0.7.0.1
 */