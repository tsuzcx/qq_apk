package cooperation.qwallet.open;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.security.MessageDigest;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class OpenPayActivity
  extends BaseActivity
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public int exH = -1;
  public int exI = -1;
  public int exJ = -1;
  private int mPayType = -1;
  public long mReportSeq;
  protected Bundle r;
  
  private static String J(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      localStringBuilder.append(':');
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  private void ee(Bundle paramBundle)
  {
    switch (this.exI)
    {
    default: 
      return;
    }
    ef(paramBundle);
  }
  
  private void ef(Bundle paramBundle)
  {
    String str9 = paramBundle.getString("appId");
    String str11 = paramBundle.getString("nonce");
    long l = paramBundle.getLong("timeStamp");
    String str12 = paramBundle.getString("sig");
    String str13 = paramBundle.getString("sigType");
    String str4 = paramBundle.getString("tokenId");
    String str14 = paramBundle.getString("pubAcc");
    String str10 = paramBundle.getString("bargainorId");
    Object localObject3 = paramBundle.getString("qVersion");
    String str5 = paramBundle.getString("packageName");
    String str6 = paramBundle.getString("callbackScheme");
    String str7 = this.app.getCurrentAccountUin();
    String str8 = this.app.getCurrentNickname();
    if ((TextUtils.isEmpty(str11)) || (TextUtils.isEmpty(str12)) || (TextUtils.isEmpty(str13)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str9)) || (TextUtils.isEmpty(str10)))
    {
      paramBundle = "ai:" + str9 + " bi:" + str10 + " ti:" + str4 + " ne:" + str11 + " sg:" + str12 + " st:" + str13;
      ap(-1007, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay Parameters error:" + paramBundle);
      }
    }
    do
    {
      return;
      if ((this.exH != 2) || ((!TextUtils.isEmpty(str5)) && ((this.exJ != 1) || (!TextUtils.isEmpty(str6))))) {
        break;
      }
      ap(-1009, "Parameters error.", null);
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay -1009");
    return;
    try
    {
      localObject1 = getPackageManager().getPackageInfo(str5, 64);
      str1 = ((PackageInfo)localObject1).versionName;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        JSONObject localJSONObject;
        label558:
        String str1 = "";
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay Exception");
        }
        String str2 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((PackageInfo)localObject1).signatures;
        localObject2 = MessageDigest.getInstance("SHA1");
        ((MessageDigest)localObject2).reset();
        ((MessageDigest)localObject2).update(localObject1[0].toByteArray());
        localObject1 = J(((MessageDigest)localObject2).digest());
      }
      catch (Exception localException2)
      {
        break label985;
        String str3 = "";
        break;
      }
      try
      {
        localObject2 = (TicketManager)this.app.getManager(2);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((TicketManager)localObject2).getSkey(str7);
        localJSONObject = new JSONObject();
        localJSONObject.put("appId", str9);
        localJSONObject.put("nonce", str11);
        localJSONObject.put("timeStamp", l);
        localJSONObject.put("bargainorId", str10);
        localJSONObject.put("pubAcc", str14);
        localJSONObject.put("sigType", str13);
        localJSONObject.put("sig", str12);
        localJSONObject.put("uin", str7);
        localJSONObject.put("qqVer", localObject3);
        localJSONObject.put("sKey", localObject2);
        localJSONObject.put("pkgName", str5);
        localJSONObject.put("appVer", str1);
        localJSONObject.put("pkgSha1Sig", localObject1);
        localObject2 = localJSONObject.toString();
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        str3 = "";
        break label558;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("ai=").append(str9);
    ((StringBuilder)localObject3).append("&ue=").append(str11);
    ((StringBuilder)localObject3).append("&ts=").append(l);
    ((StringBuilder)localObject3).append("&sg=").append(str12);
    ((StringBuilder)localObject3).append("&st=").append(str13);
    ((StringBuilder)localObject3).append("&ti=").append(str4);
    ((StringBuilder)localObject3).append("&pa=").append(str14);
    ((StringBuilder)localObject3).append("&bi=").append(str10);
    ((StringBuilder)localObject3).append("&pn=").append(str5);
    ((StringBuilder)localObject3).append("&afp=").append((String)localObject1);
    ((StringBuilder)localObject3).append("&av=").append(str1);
    VACDReportUtil.b(this.mReportSeq, null, "loadPluginStart", ((StringBuilder)localObject3).toString(), 0, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletLoadPlugin", 4, "loadPluginStart time=" + SystemClock.elapsedRealtime());
    }
    paramBundle = paramBundle.getString("callbackSn");
    str1 = "appid#" + str9 + "|bargainor_id#" + str10 + "|channel#thirdpartapp";
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("callbackSn", paramBundle);
    ((Bundle)localObject1).putString("tokenId", str4);
    ((Bundle)localObject1).putString("userId", str7);
    ((Bundle)localObject1).putString("userName", str8);
    ((Bundle)localObject1).putInt("comeForm", 4);
    ((Bundle)localObject1).putString("appInfo", str1);
    ((Bundle)localObject1).putInt("sdkChannel", 1);
    ((Bundle)localObject1).putString("sdkData", (String)localObject2);
    ((Bundle)localObject1).putString("packageName", str5);
    ((Bundle)localObject1).putString("callbackScheme", str6);
    ((Bundle)localObject1).putInt("appPayType", this.exJ);
    ((Bundle)localObject1).putInt("PayInvokerId", 9);
    ((Bundle)localObject1).putInt("payparmas_paytype", 4);
    ((Bundle)localObject1).putLong("vacreport_key_seq", this.mReportSeq);
    QWalletPayBridge.launchForeground(this, this.app, (Bundle)localObject1);
    finish();
  }
  
  /* Error */
  private void eg(Bundle paramBundle)
  {
    // Byte code:
    //   0: new 353	avow
    //   3: dup
    //   4: invokespecial 354	avow:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: iconst_1
    //   12: putfield 357	avow:exK	I
    //   15: aload 5
    //   17: ldc_w 359
    //   20: putfield 362	avow:apiName	Ljava/lang/String;
    //   23: aload 5
    //   25: aload_1
    //   26: ldc_w 297
    //   29: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 365	avow:cMq	Ljava/lang/String;
    //   35: aload 5
    //   37: aload_1
    //   38: ldc_w 367
    //   41: invokevirtual 371	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   44: putfield 373	avow:retCode	I
    //   47: aload 5
    //   49: aload_1
    //   50: ldc_w 375
    //   53: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 377	avow:retMsg	Ljava/lang/String;
    //   59: aload 5
    //   61: ldc 67
    //   63: putfield 380	avow:openId	Ljava/lang/String;
    //   66: aload 5
    //   68: invokevirtual 383	avow:isSuccess	()Z
    //   71: ifeq +75 -> 146
    //   74: aload 5
    //   76: aload_1
    //   77: ldc_w 385
    //   80: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: putfield 388	avow:cMv	Ljava/lang/String;
    //   86: aload 5
    //   88: aload_1
    //   89: ldc_w 390
    //   92: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: putfield 393	avow:cMw	Ljava/lang/String;
    //   98: aload 5
    //   100: aload_1
    //   101: ldc_w 395
    //   104: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 398	avow:cMx	Ljava/lang/String;
    //   110: aload 5
    //   112: aload_1
    //   113: ldc_w 400
    //   116: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 403	avow:cMy	Ljava/lang/String;
    //   122: aload 5
    //   124: aload_1
    //   125: ldc_w 405
    //   128: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 408	avow:cMz	Ljava/lang/String;
    //   134: aload 5
    //   136: aload_1
    //   137: ldc_w 410
    //   140: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 413	avow:cMA	Ljava/lang/String;
    //   146: aload_0
    //   147: getfield 415	cooperation/qwallet/open/OpenPayActivity:r	Landroid/os/Bundle;
    //   150: ldc 104
    //   152: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_0
    //   157: getfield 415	cooperation/qwallet/open/OpenPayActivity:r	Landroid/os/Bundle;
    //   160: ldc 106
    //   162: invokevirtual 82	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_3
    //   166: aload_2
    //   167: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +10 -> 180
    //   173: aload_3
    //   174: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifeq +24 -> 201
    //   180: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +13 -> 196
    //   186: ldc_w 417
    //   189: iconst_2
    //   190: ldc_w 419
    //   193: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokespecial 420	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   200: return
    //   201: new 422	android/content/Intent
    //   204: dup
    //   205: invokespecial 423	android/content/Intent:<init>	()V
    //   208: astore 4
    //   210: aload_0
    //   211: getfield 47	cooperation/qwallet/open/OpenPayActivity:exJ	I
    //   214: iconst_2
    //   215: if_icmpne +124 -> 339
    //   218: aload 5
    //   220: invokevirtual 426	avow:toJson	()Ljava/lang/String;
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +105 -> 333
    //   231: new 428	java/lang/String
    //   234: dup
    //   235: aload_1
    //   236: invokevirtual 431	java/lang/String:getBytes	()[B
    //   239: iconst_0
    //   240: invokestatic 437	aqgo:encode	([BI)[B
    //   243: invokespecial 439	java/lang/String:<init>	([B)V
    //   246: astore_1
    //   247: aload 4
    //   249: ldc_w 441
    //   252: invokevirtual 445	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   255: pop
    //   256: aload 4
    //   258: new 50	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   265: aload_3
    //   266: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 447
    //   272: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 453	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   285: invokevirtual 457	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   288: pop
    //   289: aload 4
    //   291: aload_2
    //   292: invokevirtual 460	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   295: pop
    //   296: aload 4
    //   298: ldc_w 461
    //   301: invokevirtual 465	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   304: pop
    //   305: aload 4
    //   307: ldc_w 467
    //   310: ldc_w 469
    //   313: invokevirtual 473	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   316: pop
    //   317: aload_0
    //   318: aload 4
    //   320: invokespecial 477	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   323: aload_0
    //   324: invokespecial 420	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   327: return
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 348	java/lang/Exception:printStackTrace	()V
    //   333: ldc 67
    //   335: astore_1
    //   336: goto -89 -> 247
    //   339: new 78	android/os/Bundle
    //   342: dup
    //   343: invokespecial 304	android/os/Bundle:<init>	()V
    //   346: astore_1
    //   347: aload 5
    //   349: aload_1
    //   350: invokevirtual 480	avow:toBundle	(Landroid/os/Bundle;)V
    //   353: aload 4
    //   355: ldc_w 441
    //   358: invokevirtual 445	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   361: pop
    //   362: aload 4
    //   364: new 50	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   371: aload_3
    //   372: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 482
    //   378: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 453	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   387: invokevirtual 457	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   390: pop
    //   391: aload 4
    //   393: aload_2
    //   394: invokevirtual 460	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   397: pop
    //   398: aload 4
    //   400: ldc_w 461
    //   403: invokevirtual 465	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   406: pop
    //   407: aload 4
    //   409: aload_1
    //   410: invokevirtual 486	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   413: pop
    //   414: aload 4
    //   416: ldc_w 467
    //   419: ldc_w 469
    //   422: invokevirtual 473	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   425: pop
    //   426: goto -109 -> 317
    //   429: astore_1
    //   430: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +36 -> 469
    //   436: ldc_w 417
    //   439: iconst_2
    //   440: new 50	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 488
    //   450: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 491	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -143 -> 323
    //   469: invokestatic 282	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   472: ifeq -149 -> 323
    //   475: aload_1
    //   476: invokevirtual 348	java/lang/Exception:printStackTrace	()V
    //   479: goto -156 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	OpenPayActivity
    //   0	482	1	paramBundle	Bundle
    //   155	239	2	str1	String
    //   165	207	3	str2	String
    //   208	207	4	localIntent	Intent
    //   7	341	5	localavow	avow
    // Exception table:
    //   from	to	target	type
    //   231	247	328	java/lang/Exception
    //   317	323	429	java/lang/Exception
  }
  
  protected void ap(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = this.r.getString("callbackSn");
    }
    paramString2 = new Bundle();
    paramString2.putInt("retCode", paramInt);
    paramString2.putString("retMsg", paramString1);
    paramString2.putString("callbackSn", str);
    switch (this.exH)
    {
    default: 
      super.finish();
      return;
    }
    eg(paramString2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doOnCreate");
    }
    paramBundle = super.getIntent().getExtras();
    if ((this.app == null) || (paramBundle == null))
    {
      ap(-1001, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate app == null || bundle == null");
      }
      return true;
    }
    this.r = paramBundle;
    this.mPayType = paramBundle.getInt("extra.key.pay.type");
    this.exH = paramBundle.getInt("extra.key.pay.from", -1);
    this.exI = paramBundle.getInt("extra.key.pay.platform", -1);
    this.exJ = paramBundle.getInt("extra.key.app.type", -1);
    this.mReportSeq = paramBundle.getLong("vacreport_key_seq", 0L);
    switch (this.mPayType)
    {
    default: 
      ap(-1002, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate mPayType error");
      }
      break;
    }
    while (BaseApplicationImpl.appStartTime > 0L)
    {
      Log.d("AutoMonitor", "actStartPay, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
      return true;
      ee(paramBundle);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.open.OpenPayActivity
 * JD-Core Version:    0.7.0.1
 */