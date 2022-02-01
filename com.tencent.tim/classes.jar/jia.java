import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.GetRedBag.1;
import com.tencent.av.ui.redbag.GetRedBag.2;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class jia
  extends jhy
{
  public String Si;
  public String Sj;
  public jil b;
  public WeakReference<jia.a> bP;
  ResultReceiver mResultReceiver = null;
  public Runnable mRunnable = null;
  
  jia(jht paramjht)
  {
    super(paramjht);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("receiver", paramResultReceiver);
    e(paramQQAppInterface.getApp(), paramBundle);
  }
  
  static int d(String paramString1, String paramString2, String paramString3)
  {
    if (("0".equals(paramString2)) && (("0".equals(paramString3)) || ("1".equals(paramString3))))
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0"))) {
        return 7;
      }
      return 0;
    }
    if (("66231409".equals(paramString2)) || (("0".equals(paramString2)) && ("5".equals(paramString3)))) {
      return 8;
    }
    if (("66231411".equals(paramString2)) || ("66231412".equals(paramString2))) {
      return 5;
    }
    if (("0".equals(paramString2)) && ("7".equals(paramString3))) {
      return 6;
    }
    return 9;
  }
  
  /* Error */
  private boolean d(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: getfield 84	jia:TAG	Ljava/lang/String;
    //   7: astore 6
    //   9: new 86	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   16: ldc 91
    //   18: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 100
    //   27: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 7
    //   32: aload_2
    //   33: ifnull +577 -> 610
    //   36: iconst_1
    //   37: istore 5
    //   39: aload 6
    //   41: iconst_1
    //   42: aload 7
    //   44: iload 5
    //   46: invokevirtual 103	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 105
    //   51: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 115	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_2
    //   61: ifnull +704 -> 765
    //   64: ldc 116
    //   66: invokestatic 122	acfp:m	(I)Ljava/lang/String;
    //   69: aload_2
    //   70: invokestatic 128	com/tencent/mobileqq/utils/AudioHelper:I	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   73: aload_2
    //   74: ldc 130
    //   76: invokevirtual 134	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_2
    //   80: ldc 136
    //   82: astore 6
    //   84: ldc 138
    //   86: astore 9
    //   88: aload_2
    //   89: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +550 -> 642
    //   95: new 140	org/json/JSONObject
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore 7
    //   105: new 86	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   112: ldc 138
    //   114: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 7
    //   119: ldc 145
    //   121: sipush -9999
    //   124: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   127: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore_2
    //   134: aload 7
    //   136: ldc 151
    //   138: ldc 153
    //   140: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 11
    //   145: aload 7
    //   147: ldc 159
    //   149: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +596 -> 755
    //   162: new 140	org/json/JSONObject
    //   165: dup
    //   166: aload 6
    //   168: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   171: astore 8
    //   173: aload 8
    //   175: ldc 163
    //   177: ldc 165
    //   179: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 9
    //   184: aload_0
    //   185: aload 8
    //   187: ldc 167
    //   189: aconst_null
    //   190: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: putfield 169	jia:Si	Ljava/lang/String;
    //   196: aload_0
    //   197: aload 8
    //   199: ldc 171
    //   201: aconst_null
    //   202: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: putfield 173	jia:Sj	Ljava/lang/String;
    //   208: aload 8
    //   210: ldc 175
    //   212: ldc 177
    //   214: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 7
    //   219: aload 8
    //   221: ldc 179
    //   223: aconst_null
    //   224: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 10
    //   229: aload 7
    //   231: astore 8
    //   233: aload 10
    //   235: astore 7
    //   237: aload 7
    //   239: astore 10
    //   241: aload 6
    //   243: astore 7
    //   245: aload_2
    //   246: astore 6
    //   248: aload 8
    //   250: astore_2
    //   251: aload 11
    //   253: astore 8
    //   255: aload_2
    //   256: astore 13
    //   258: aload 9
    //   260: astore 12
    //   262: aload 6
    //   264: astore 11
    //   266: iconst_5
    //   267: invokestatic 183	com/tencent/mobileqq/utils/AudioHelper:jY	(I)I
    //   270: iconst_1
    //   271: if_icmpne +122 -> 393
    //   274: aload_0
    //   275: invokevirtual 186	jia:a	()Ljht;
    //   278: astore 14
    //   280: aload_2
    //   281: astore 13
    //   283: aload 9
    //   285: astore 12
    //   287: aload 6
    //   289: astore 11
    //   291: aload 14
    //   293: ifnull +100 -> 393
    //   296: aload_2
    //   297: astore 13
    //   299: aload 9
    //   301: astore 12
    //   303: aload 6
    //   305: astore 11
    //   307: aload 14
    //   309: getfield 191	jht:a	Ljht$b;
    //   312: ifnull +81 -> 393
    //   315: aload_2
    //   316: astore 13
    //   318: aload 9
    //   320: astore 12
    //   322: aload 6
    //   324: astore 11
    //   326: aload 14
    //   328: getfield 191	jht:a	Ljht$b;
    //   331: getfield 197	jht$b:Zt	Z
    //   334: ifeq +59 -> 393
    //   337: aload_2
    //   338: astore 13
    //   340: aload 9
    //   342: astore 12
    //   344: aload 6
    //   346: astore 11
    //   348: aload 14
    //   350: getfield 191	jht:a	Ljht$b;
    //   353: getfield 200	jht$b:RZ	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 202	jia:b	Ljil;
    //   360: getfield 207	jil:Sn	Ljava/lang/String;
    //   363: invokestatic 210	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   366: ifeq +27 -> 393
    //   369: ldc 212
    //   371: astore 13
    //   373: aload 14
    //   375: getfield 191	jht:a	Ljht$b;
    //   378: getfield 215	jht$b:Sa	Ljava/lang/String;
    //   381: astore 11
    //   383: aload 14
    //   385: getfield 191	jht:a	Ljht$b;
    //   388: getfield 218	jht$b:Sb	Ljava/lang/String;
    //   391: astore 12
    //   393: aload 13
    //   395: aload 11
    //   397: aload 12
    //   399: invokestatic 220	jia:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   402: istore_3
    //   403: aload_0
    //   404: getfield 202	jia:b	Ljil;
    //   407: aload 13
    //   409: putfield 223	jil:St	Ljava/lang/String;
    //   412: aload_0
    //   413: getfield 202	jia:b	Ljil;
    //   416: aload 8
    //   418: putfield 226	jil:Ss	Ljava/lang/String;
    //   421: aload_0
    //   422: getfield 202	jia:b	Ljil;
    //   425: aload 10
    //   427: putfield 229	jil:Sr	Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 202	jia:b	Ljil;
    //   434: aload 11
    //   436: putfield 232	jil:Sp	Ljava/lang/String;
    //   439: aload_0
    //   440: getfield 202	jia:b	Ljil;
    //   443: aload 12
    //   445: putfield 235	jil:Sq	Ljava/lang/String;
    //   448: aload_0
    //   449: getfield 84	jia:TAG	Ljava/lang/String;
    //   452: iconst_1
    //   453: new 86	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   460: ldc 237
    //   462: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 11
    //   467: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 239
    //   472: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 8
    //   477: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc 241
    //   482: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 12
    //   487: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc 243
    //   492: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: getfield 169	jia:Si	Ljava/lang/String;
    //   499: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc 245
    //   504: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: getfield 173	jia:Sj	Ljava/lang/String;
    //   511: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc 247
    //   516: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 13
    //   521: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 249
    //   526: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload 10
    //   531: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc 251
    //   536: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: iload_3
    //   540: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc 253
    //   545: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 7
    //   550: invokestatic 257	com/tencent/mobileqq/utils/AudioHelper:s	(Ljava/lang/Object;)Ljava/lang/String;
    //   553: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc 105
    //   558: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 115	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: iload_3
    //   568: istore 4
    //   570: iload_1
    //   571: bipush 253
    //   573: if_icmpne +15 -> 588
    //   576: iload_3
    //   577: istore 4
    //   579: iload_3
    //   580: iconst_3
    //   581: if_icmpne +7 -> 588
    //   584: bipush 10
    //   586: istore 4
    //   588: aload_0
    //   589: getfield 202	jia:b	Ljil;
    //   592: iload 4
    //   594: putfield 260	jil:aAj	I
    //   597: aload_0
    //   598: invokevirtual 263	jia:awA	()V
    //   601: aload_0
    //   602: getfield 202	jia:b	Ljil;
    //   605: invokestatic 268	jij:e	(Ljil;)V
    //   608: iconst_1
    //   609: ireturn
    //   610: iconst_0
    //   611: istore 5
    //   613: goto -574 -> 39
    //   616: astore 8
    //   618: aconst_null
    //   619: astore 7
    //   621: ldc 138
    //   623: astore 9
    //   625: ldc 177
    //   627: astore_2
    //   628: aload 8
    //   630: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   633: astore 8
    //   635: aload 12
    //   637: astore 10
    //   639: goto -384 -> 255
    //   642: aconst_null
    //   643: astore 7
    //   645: ldc_w 273
    //   648: astore 8
    //   650: ldc 138
    //   652: astore 9
    //   654: ldc 177
    //   656: astore_2
    //   657: aload 12
    //   659: astore 10
    //   661: goto -406 -> 255
    //   664: astore 8
    //   666: aload_2
    //   667: astore 6
    //   669: aconst_null
    //   670: astore 7
    //   672: ldc 177
    //   674: astore_2
    //   675: ldc 138
    //   677: astore 9
    //   679: goto -51 -> 628
    //   682: astore 8
    //   684: aload_2
    //   685: astore 7
    //   687: aload 6
    //   689: astore 10
    //   691: ldc 177
    //   693: astore_2
    //   694: ldc 138
    //   696: astore 9
    //   698: aload 7
    //   700: astore 6
    //   702: aload 10
    //   704: astore 7
    //   706: goto -78 -> 628
    //   709: astore 8
    //   711: aload_2
    //   712: astore 7
    //   714: aload 6
    //   716: astore 10
    //   718: ldc 177
    //   720: astore_2
    //   721: aload 7
    //   723: astore 6
    //   725: aload 10
    //   727: astore 7
    //   729: goto -101 -> 628
    //   732: astore 8
    //   734: aload_2
    //   735: astore 10
    //   737: aload 6
    //   739: astore 11
    //   741: aload 7
    //   743: astore_2
    //   744: aload 10
    //   746: astore 6
    //   748: aload 11
    //   750: astore 7
    //   752: goto -124 -> 628
    //   755: ldc 177
    //   757: astore 8
    //   759: aconst_null
    //   760: astore 7
    //   762: goto -525 -> 237
    //   765: iconst_3
    //   766: istore_3
    //   767: goto -200 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	jia
    //   0	770	1	paramInt	int
    //   0	770	2	paramBundle	Bundle
    //   402	365	3	i	int
    //   568	25	4	j	int
    //   37	575	5	bool	boolean
    //   7	740	6	localObject1	Object
    //   30	731	7	localObject2	Object
    //   171	305	8	localObject3	Object
    //   616	13	8	localException1	Exception
    //   633	16	8	str1	String
    //   664	1	8	localException2	Exception
    //   682	1	8	localException3	Exception
    //   709	1	8	localException4	Exception
    //   732	1	8	localException5	Exception
    //   757	1	8	str2	String
    //   86	611	9	str3	String
    //   227	518	10	localObject4	Object
    //   143	606	11	localObject5	Object
    //   1	657	12	localObject6	Object
    //   256	264	13	localObject7	Object
    //   278	106	14	localjht	jht
    // Exception table:
    //   from	to	target	type
    //   95	134	616	java/lang/Exception
    //   134	154	664	java/lang/Exception
    //   154	184	682	java/lang/Exception
    //   184	219	709	java/lang/Exception
    //   219	229	732	java/lang/Exception
  }
  
  private static void e(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, PayBridgeActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", 5);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity begin");
    paramContext.startActivity(localIntent);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity end");
  }
  
  public void D(int paramInt, long paramLong)
  {
    if (this.mRunnable != null)
    {
      QLog.w(this.TAG, 1, "getRedBag，超时逻辑已启动, resultCode[" + paramInt + "]");
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("getRedBag，启动超时逻辑, resultCode[").append(paramInt).append("], mApp[");
    if (this.mApp != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.mApp == null) {
        break;
      }
      this.mRunnable = new GetRedBag.2(this, paramInt);
      this.mApp.getHandler().postDelayed(this.mRunnable, paramLong);
      return;
    }
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, jil paramjil, WeakReference<jia.a> paramWeakReference)
  {
    this.b = paramjil;
    if (paramVideoAppInterface == null)
    {
      QLog.w(this.TAG, 1, "GetRedBag, app为空");
      return false;
    }
    long l = jik.b(paramVideoAppInterface);
    if (l == 0L)
    {
      QLog.w(this.TAG, 1, "GetRedBag, userId为空");
      paramjil.aAj = 2;
      return false;
    }
    if (this.mResultReceiver == null) {
      this.mResultReceiver = new GetRedBag.1(this, this.mApp.getHandler());
    }
    String str = a(paramVideoAppInterface);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("listid", paramjil.Sn);
      localJSONObject2.put("authkey", paramjil.So);
      localJSONObject2.put("name", str);
      localJSONObject2.put("channel", "16384");
      localJSONObject2.put("silence_grap", "1");
      localJSONObject2.put("grouptype", "0");
      localJSONObject2.put("groupid", "" + l);
      localJSONObject1.put("userId", l);
      localJSONObject1.put("viewTag", "graphb");
      localJSONObject1.put("app_info", "appid#0|bargainor_id#0|channel#bqredpacket");
      localJSONObject1.put("come_from", 2);
      localJSONObject1.put("extra_data", localJSONObject2);
      this.bP = paramWeakReference;
      paramWeakReference = new Bundle();
      paramWeakReference.putString("json", localJSONObject1.toString());
      paramWeakReference.putString("callbackSn", "0");
      if ((paramAVActivity != null) && (paramAVActivity.lV() != -1) && (paramAVActivity.lV() != 5))
      {
        paramWeakReference.putParcelable("receiver", this.mResultReceiver);
        e(paramAVActivity, paramWeakReference);
        QLog.w(this.TAG, 1, "GetRedBag, userName[" + str + "], userId[" + l + "], redPocketId[" + paramjil.Sn + "], json[" + AudioHelper.s(localJSONObject1) + "], Activity[" + paramAVActivity + "]");
        paramjil.aAj = 1;
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        QLog.w(this.TAG, 1, "发通知到主进程抢红包");
        paramVideoAppInterface.a(2, 0, 0, paramWeakReference, this.mResultReceiver);
        D(-3, 20000L);
      }
    }
  }
  
  void awA()
  {
    awz();
    if (this.bP != null)
    {
      jia.a locala = (jia.a)this.bP.get();
      if (locala != null) {
        locala.a(this);
      }
      this.bP = null;
    }
    if (this.b.aAj == 0) {}
    for (boolean bool = true;; bool = false)
    {
      irm.c(bool, this.b.Sp, this.b.Sq);
      return;
    }
  }
  
  void awz()
  {
    if ((this.mRunnable != null) && (this.mApp != null))
    {
      this.mApp.getHandler().removeCallbacks(this.mRunnable);
      QLog.w(this.TAG, 1, "getRedBag, removeDelayRunnable");
      this.mRunnable = null;
    }
  }
  
  public void cancel(String paramString)
  {
    QLog.w(this.TAG, 1, "GetRedBag, cancel[" + paramString + "]");
    this.b.aAj = 4;
    awA();
  }
  
  static abstract interface a
  {
    public abstract void a(jia paramjia);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jia
 * JD-Core Version:    0.7.0.1
 */