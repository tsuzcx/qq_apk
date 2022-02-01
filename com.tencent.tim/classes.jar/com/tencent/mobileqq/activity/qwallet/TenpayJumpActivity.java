package com.tencent.mobileqq.activity.qwallet;

import aagd;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anpc;
import aqcv;
import aqgv;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayJumpActivity
  extends BaseActivity
{
  private String bbM;
  private String bbN;
  private String bbO;
  private String bbP;
  private int bdj;
  private String mAppInfo;
  private Context mContext;
  private String mSource;
  private String mUin;
  private String mUrl;
  private String np;
  
  private void openTenpayView(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.mUin);
      localJSONObject.put("viewTag", paramString1);
      localJSONObject.put("comeForm", this.bdj);
      localJSONObject.put("appInfo", this.mAppInfo);
      localJSONObject.put("extra_data", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString1)
    {
      v(-1, null);
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      v(-1, null);
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    paramString5.append(6);
    paramString5.append("|");
    paramString5.append(aqcv.gP());
    paramString5.append("|");
    if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      paramString5.append(paramString3);
      paramString5.append(".");
      paramString5.append(paramString4);
    }
    paramString5.append("|");
    paramString5.append(paramInt2);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.mAppInfo)) {
      paramString5.append(this.mAppInfo.replace("|", ","));
    }
    paramString5.append("|");
    anpc.a(BaseApplication.getContext()).i(this.app, paramString5.toString());
  }
  
  public int aj(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299627);
      float f = paramContext.getResources().getDisplayMetrics().density;
      return i - (int)(f * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  protected void ctc()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject2 = Uri.parse(this.mUrl);
      Object localObject1 = ((Uri)localObject2).getQueryParameter("dy");
      String str1 = ((Uri)localObject2).getQueryParameter("su");
      String str2 = ((Uri)localObject2).getQueryParameter("u");
      localObject2 = URLDecoder.decode(((Uri)localObject2).getQueryParameter("ac"));
      localJSONObject.put("auth_code", localObject2);
      if ("1".equals(localObject1))
      {
        if (this.mUin.equals(str2))
        {
          e(acfp.m(2131715237));
          finish();
          return;
        }
        if (!this.mUin.equals(str1))
        {
          e(acfp.m(2131715238));
          finish();
          return;
        }
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("*")) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length());
        }
        localJSONObject.put("tokenId", localObject1);
        localJSONObject.put("dy", "1");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", localJSONObject.toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        PayBridgeActivity.a(this, 9, (Bundle)localObject1);
        aagd.a(this.app, this.mUin, this.bdj, this.mAppInfo, 1L, 0, "scanTransferLimmitQR", "", "");
        return;
      }
      openTenpayView("verifyqrcode", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.mContext = this;
    for (;;)
    {
      try
      {
        this.mUin = this.app.getCurrentAccountUin();
        this.bbM = this.app.getCurrentNickname();
        this.bbN = "2";
        this.bdj = getIntent().getIntExtra("come_from", 5);
        this.np = getIntent().getStringExtra("callbackSn");
        this.mAppInfo = getIntent().getStringExtra("app_info");
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.mUrl = paramBundle.optString("url");
        this.bbO = paramBundle.optString("uin");
        this.bbP = paramBundle.optString("name");
        String str = paramBundle.optString("url");
        int i = str.indexOf("&f=");
        paramBundle = str;
        if (i > 0)
        {
          str = str.substring(i + 3);
          i = str.indexOf('&');
          paramBundle = str;
          if (i > 0) {
            paramBundle = str.substring(0, i);
          }
        }
        if (!"wallet".equals(paramBundle)) {
          continue;
        }
        this.mSource = "1";
        paramBundle = aqgv.D(this.app, this.bbO);
        if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.bbO))) {
          this.bbP = paramBundle;
        }
        ctc();
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      a(this.mUin, 128, "scan.qrcode.loading", "", "", this.bdj, "");
      return true;
      if ("apw".equals(paramBundle)) {
        this.mSource = "2";
      }
    }
  }
  
  public void e(CharSequence paramCharSequence)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramCharSequence, 0).show(aj(this.mContext));
    }
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: ldc_w 364
    //   4: if_icmpne +66 -> 70
    //   7: new 289	android/content/Intent
    //   10: dup
    //   11: invokespecial 365	android/content/Intent:<init>	()V
    //   14: astore 5
    //   16: aload 5
    //   18: ldc 237
    //   20: aload_0
    //   21: getfield 298	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:np	Ljava/lang/String;
    //   24: invokevirtual 369	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   27: pop
    //   28: aload 5
    //   30: ldc_w 371
    //   33: iconst_5
    //   34: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   37: pop
    //   38: aload_3
    //   39: ifnull +19 -> 58
    //   42: aload 5
    //   44: ldc_w 376
    //   47: aload_3
    //   48: ldc_w 376
    //   51: invokevirtual 296	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 369	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   57: pop
    //   58: aload_0
    //   59: iconst_m1
    //   60: aload 5
    //   62: invokevirtual 380	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:setResult	(ILandroid/content/Intent;)V
    //   65: aload_0
    //   66: invokevirtual 210	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   69: return
    //   70: aload_3
    //   71: ifnull -2 -> 69
    //   74: iload_2
    //   75: iconst_m1
    //   76: if_icmpne -7 -> 69
    //   79: aload_3
    //   80: ldc_w 376
    //   83: invokevirtual 296	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnull +154 -> 242
    //   91: aload_3
    //   92: invokevirtual 221	java/lang/String:length	()I
    //   95: ifle +147 -> 242
    //   98: new 31	org/json/JSONObject
    //   101: dup
    //   102: aload_3
    //   103: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +147 -> 255
    //   111: aload_3
    //   112: ldc_w 382
    //   115: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: pop
    //   119: aload_3
    //   120: ldc_w 384
    //   123: iconst_m1
    //   124: invokevirtual 387	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   127: istore 4
    //   129: aload_3
    //   130: ldc_w 389
    //   133: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_3
    //   137: iload 4
    //   139: istore_2
    //   140: aload_3
    //   141: ifnull +114 -> 255
    //   144: iload 4
    //   146: istore_2
    //   147: aload_3
    //   148: invokevirtual 221	java/lang/String:length	()I
    //   151: ifle +104 -> 255
    //   154: new 31	org/json/JSONObject
    //   157: dup
    //   158: aload_3
    //   159: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   162: astore_3
    //   163: iload 4
    //   165: istore_2
    //   166: iload_2
    //   167: ifne +378 -> 545
    //   170: aload_3
    //   171: ifnull +374 -> 545
    //   174: iload_1
    //   175: tableswitch	default:+17 -> 192, 5:+18->193
    //   193: aload_3
    //   194: ldc_w 391
    //   197: invokevirtual 393	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   200: pop
    //   201: aload_3
    //   202: ldc_w 395
    //   205: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 6
    //   210: aload_0
    //   211: getfield 312	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bbO	Ljava/lang/String;
    //   214: aload 6
    //   216: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifne +41 -> 260
    //   222: aload_0
    //   223: ldc_w 396
    //   226: invokestatic 203	acfp:m	(I)Ljava/lang/String;
    //   229: invokevirtual 207	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:e	(Ljava/lang/CharSequence;)V
    //   232: aload_0
    //   233: invokevirtual 210	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   236: return
    //   237: astore_3
    //   238: aload_3
    //   239: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   242: aconst_null
    //   243: astore_3
    //   244: goto -137 -> 107
    //   247: astore_3
    //   248: aload_3
    //   249: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   252: iload 4
    //   254: istore_2
    //   255: aconst_null
    //   256: astore_3
    //   257: goto -91 -> 166
    //   260: aload_3
    //   261: ldc_w 398
    //   264: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 7
    //   269: aload_3
    //   270: ldc_w 400
    //   273: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: pop
    //   277: aload_0
    //   278: aload_3
    //   279: ldc_w 402
    //   282: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: ldc_w 404
    //   288: ldc_w 406
    //   291: invokevirtual 410	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   294: astore 8
    //   296: aload_3
    //   297: ldc_w 412
    //   300: invokevirtual 308	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: astore_3
    //   304: aload_0
    //   305: getfield 131	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   308: aload_0
    //   309: getfield 312	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bbO	Ljava/lang/String;
    //   312: invokestatic 336	aqgv:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 5
    //   317: aload 5
    //   319: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   322: ifne +239 -> 561
    //   325: aload 5
    //   327: aload_0
    //   328: getfield 312	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bbO	Ljava/lang/String;
    //   331: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   334: ifne +227 -> 561
    //   337: aload 5
    //   339: astore_3
    //   340: aload_3
    //   341: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne +17 -> 361
    //   347: aload_3
    //   348: astore 5
    //   350: aload_3
    //   351: aload_0
    //   352: getfield 312	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bbO	Ljava/lang/String;
    //   355: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   358: ifeq +9 -> 367
    //   361: aload_0
    //   362: getfield 316	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bbP	Ljava/lang/String;
    //   365: astore 5
    //   367: new 289	android/content/Intent
    //   370: dup
    //   371: invokespecial 365	android/content/Intent:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: ldc_w 287
    //   379: aload_0
    //   380: getfield 46	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:bdj	I
    //   383: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   386: pop
    //   387: new 31	org/json/JSONObject
    //   390: dup
    //   391: invokespecial 32	org/json/JSONObject:<init>	()V
    //   394: astore 9
    //   396: aload 9
    //   398: ldc_w 414
    //   401: aload 6
    //   403: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload 9
    //   409: ldc_w 416
    //   412: aload 5
    //   414: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 9
    //   420: ldc_w 398
    //   423: aload 7
    //   425: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload 9
    //   431: ldc_w 418
    //   434: ldc 244
    //   436: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   439: pop
    //   440: aload 9
    //   442: ldc_w 420
    //   445: aload_0
    //   446: getfield 330	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:mSource	Ljava/lang/String;
    //   449: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   452: pop
    //   453: aload 9
    //   455: ldc_w 422
    //   458: aload 8
    //   460: ldc_w 424
    //   463: invokestatic 427	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   466: invokevirtual 40	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload_3
    //   471: ldc 55
    //   473: aload 9
    //   475: invokevirtual 59	org/json/JSONObject:toString	()Ljava/lang/String;
    //   478: invokevirtual 369	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   481: pop
    //   482: aload_3
    //   483: ldc_w 300
    //   486: aload_0
    //   487: getfield 53	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:mAppInfo	Ljava/lang/String;
    //   490: invokevirtual 369	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   493: pop
    //   494: aload_3
    //   495: ldc 237
    //   497: aload_0
    //   498: getfield 298	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:np	Ljava/lang/String;
    //   501: invokevirtual 369	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   504: pop
    //   505: aload_3
    //   506: ldc_w 429
    //   509: iconst_1
    //   510: invokevirtual 432	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   513: pop
    //   514: aload_3
    //   515: aload_0
    //   516: getfield 267	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:mContext	Landroid/content/Context;
    //   519: ldc_w 434
    //   522: invokevirtual 438	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   525: pop
    //   526: aload_0
    //   527: aload_3
    //   528: ldc_w 364
    //   531: invokevirtual 442	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   534: return
    //   535: astore 5
    //   537: aload 5
    //   539: invokevirtual 443	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   542: goto -72 -> 470
    //   545: aload_0
    //   546: iconst_m1
    //   547: aconst_null
    //   548: invokevirtual 71	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:v	(ILandroid/os/Bundle;)V
    //   551: aload_0
    //   552: invokevirtual 210	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   555: return
    //   556: astore 5
    //   558: goto -88 -> 470
    //   561: goto -221 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	TenpayJumpActivity
    //   0	564	1	paramInt1	int
    //   0	564	2	paramInt2	int
    //   0	564	3	paramIntent	Intent
    //   127	126	4	i	int
    //   14	399	5	localObject	Object
    //   535	3	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   556	1	5	localJSONException	JSONException
    //   208	194	6	str1	String
    //   267	157	7	str2	String
    //   294	165	8	str3	String
    //   394	80	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   98	107	237	java/lang/Exception
    //   154	163	247	java/lang/Exception
    //   396	470	535	java/io/UnsupportedEncodingException
    //   396	470	556	org/json/JSONException
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void v(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label29:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.np);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  public String w(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1))) {}
    int i;
    int k;
    do
    {
      return "";
      i = paramString1.indexOf(paramString2);
      k = paramString2.length() + i;
      int j = paramString1.indexOf(paramString3, k);
      i = j;
      if (j == -1) {
        i = paramString1.length();
      }
    } while ((k == -1) || (k >= paramString1.length()) || (i == -1));
    return paramString1.substring(k, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity
 * JD-Core Version:    0.7.0.1
 */