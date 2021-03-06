package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGamePayFragment
  extends PublicBaseFragment
{
  public static final String MINI_EVENT_NAME = "mini_event_name";
  public static final String MINI_EVENT_SEQ = "mini_event_seq";
  public static final String MINI_RESPONSE_STR = "mini_response_str";
  public static final int PAY_CHANNEL_WECHAT = 8;
  public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
  public static final String TAG = "PayJsPlugin_in_MiniGamePayFragment";
  AppInterface app;
  PayResultRecevicer payRecevicer;
  
  private void handleNativeResponse(String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_response_str", paramString2);
    localIntent.putExtra("mini_event_name", paramString1);
    localIntent.putExtra("mini_event_seq", paramInt);
    paramString1 = getActivity();
    if (paramString1 != null)
    {
      paramString1.setResult(-1, localIntent);
      paramString1.finish();
    }
  }
  
  public void invokeMidasConsume(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt5, int paramInt6)
  {
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", acfp.m(2131708415));
        if (paramString1 != null) {
          paramString1 = paramString1.toString();
        }
        while (paramString1 != null)
        {
          handleNativeResponse(paramString3, paramString1, paramInt5);
          return;
          paramString1 = "";
          continue;
          MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramStCommonExt, new MiniGamePayFragment.2(this, paramString3, paramInt5));
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramString1);
        return;
      }
    }
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt3 + " payChannel:" + paramInt4);
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", 1000);
        paramString1.put("errMsg", acfp.m(2131708420));
        paramString1 = paramString1.toString();
        if (paramString1 != null) {
          handleNativeResponse(paramString3, paramString1, paramInt2);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt3, paramStCommonExt, new MiniGamePayFragment.1(this, paramString3, paramInt2, paramString2, paramString1, paramInt1, paramInt4, paramStCommonExt, paramInt3));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "MiniGamePayFragment onCreateView");
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.payRecevicer = new PayResultRecevicer(new Handler(Looper.getMainLooper()));
      this.app = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      int i = PayBridgeActivity.newPay(this.app, getActivity(), this.payRecevicer, 6, paramLayoutInflater).getInt("retCode", -1);
      int j = paramLayoutInflater.getInt("mini_event_seq", -1);
      paramViewGroup = paramLayoutInflater.getString("mini_event_name");
      if (i != 0)
      {
        paramLayoutInflater = ApiUtil.wrapCallbackFail(paramViewGroup, null);
        if (paramLayoutInflater == null) {
          break label139;
        }
        paramLayoutInflater = paramLayoutInflater.toString();
        if (paramLayoutInflater != null) {
          handleNativeResponse(paramViewGroup, paramLayoutInflater, j);
        }
      }
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, null);
      return null;
      label139:
      paramLayoutInflater = "";
      break;
      paramLayoutInflater = getActivity();
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater.setResult(0, null);
        paramLayoutInflater.finish();
      }
    }
  }
  
  class PayResultRecevicer
    extends ResultReceiver
  {
    public PayResultRecevicer(Handler paramHandler)
    {
      super();
    }
    
    /* Error */
    private void handlePayResult(int paramInt, Bundle paramBundle, String paramString)
    {
      // Byte code:
      //   0: aload_2
      //   1: ldc 27
      //   3: invokevirtual 33	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   6: astore 18
      //   8: aload_2
      //   9: ldc 35
      //   11: invokevirtual 33	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   14: astore 19
      //   16: aconst_null
      //   17: astore 14
      //   19: aconst_null
      //   20: astore 16
      //   22: aconst_null
      //   23: astore 15
      //   25: aconst_null
      //   26: astore 17
      //   28: iconst_m1
      //   29: istore 10
      //   31: iconst_m1
      //   32: istore 9
      //   34: iconst_m1
      //   35: istore 8
      //   37: iconst_0
      //   38: istore 12
      //   40: iconst_m1
      //   41: istore 11
      //   43: aload 16
      //   45: astore_2
      //   46: aload 17
      //   48: astore 13
      //   50: iload 8
      //   52: istore 4
      //   54: iload 10
      //   56: istore 5
      //   58: iload 9
      //   60: istore 6
      //   62: iload 11
      //   64: istore_1
      //   65: iload 12
      //   67: istore 7
      //   69: aload 19
      //   71: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   74: ifne +290 -> 364
      //   77: aload 19
      //   79: invokestatic 47	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
      //   82: ifeq +497 -> 579
      //   85: aload 14
      //   87: astore_2
      //   88: aload 15
      //   90: astore 13
      //   92: iload 8
      //   94: istore 4
      //   96: iload 10
      //   98: istore 5
      //   100: iload 9
      //   102: istore 6
      //   104: iload 11
      //   106: istore_1
      //   107: new 49	org/json/JSONObject
      //   110: dup
      //   111: aload 19
      //   113: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   116: astore 16
      //   118: aload 14
      //   120: astore_2
      //   121: aload 15
      //   123: astore 13
      //   125: iload 8
      //   127: istore 4
      //   129: iload 10
      //   131: istore 5
      //   133: iload 9
      //   135: istore 6
      //   137: iload 11
      //   139: istore_1
      //   140: aload 16
      //   142: ldc 54
      //   144: iconst_m1
      //   145: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   148: istore 11
      //   150: aload 14
      //   152: astore_2
      //   153: aload 15
      //   155: astore 13
      //   157: iload 8
      //   159: istore 4
      //   161: iload 10
      //   163: istore 5
      //   165: iload 9
      //   167: istore 6
      //   169: iload 11
      //   171: istore_1
      //   172: aload 16
      //   174: ldc 60
      //   176: aconst_null
      //   177: invokevirtual 64	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   180: astore 14
      //   182: aload 14
      //   184: astore_2
      //   185: aload 15
      //   187: astore 13
      //   189: iload 8
      //   191: istore 4
      //   193: iload 10
      //   195: istore 5
      //   197: iload 9
      //   199: istore 6
      //   201: iload 11
      //   203: istore_1
      //   204: aload 16
      //   206: ldc 66
      //   208: aconst_null
      //   209: invokevirtual 64	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   212: astore 15
      //   214: aload 14
      //   216: astore_2
      //   217: aload 15
      //   219: astore 13
      //   221: iload 8
      //   223: istore 4
      //   225: iload 10
      //   227: istore 5
      //   229: iload 9
      //   231: istore 6
      //   233: iload 11
      //   235: istore_1
      //   236: aload 16
      //   238: ldc 68
      //   240: iconst_m1
      //   241: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   244: istore 10
      //   246: aload 14
      //   248: astore_2
      //   249: aload 15
      //   251: astore 13
      //   253: iload 8
      //   255: istore 4
      //   257: iload 10
      //   259: istore 5
      //   261: iload 9
      //   263: istore 6
      //   265: iload 11
      //   267: istore_1
      //   268: aload 16
      //   270: ldc 70
      //   272: iconst_m1
      //   273: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   276: istore 9
      //   278: aload 14
      //   280: astore_2
      //   281: aload 15
      //   283: astore 13
      //   285: iload 8
      //   287: istore 4
      //   289: iload 10
      //   291: istore 5
      //   293: iload 9
      //   295: istore 6
      //   297: iload 11
      //   299: istore_1
      //   300: aload 16
      //   302: ldc 72
      //   304: iconst_m1
      //   305: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   308: istore 8
      //   310: aload 14
      //   312: astore_2
      //   313: aload 15
      //   315: astore 13
      //   317: iload 8
      //   319: istore 4
      //   321: iload 10
      //   323: istore 5
      //   325: iload 9
      //   327: istore 6
      //   329: iload 11
      //   331: istore_1
      //   332: aload 16
      //   334: ldc 74
      //   336: iconst_0
      //   337: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   340: istore 7
      //   342: iload 11
      //   344: istore_1
      //   345: iload 9
      //   347: istore 6
      //   349: iload 10
      //   351: istore 5
      //   353: iload 8
      //   355: istore 4
      //   357: aload 15
      //   359: astore 13
      //   361: aload 14
      //   363: astore_2
      //   364: ldc 76
      //   366: iconst_1
      //   367: new 78	java/lang/StringBuilder
      //   370: dup
      //   371: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   374: ldc 83
      //   376: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   379: iload_1
      //   380: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   383: ldc 92
      //   385: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   388: aload 19
      //   390: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   393: ldc 94
      //   395: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   398: aload 18
      //   400: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   403: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   406: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   409: new 49	org/json/JSONObject
      //   412: dup
      //   413: invokespecial 105	org/json/JSONObject:<init>	()V
      //   416: astore 14
      //   418: new 49	org/json/JSONObject
      //   421: dup
      //   422: aload 18
      //   424: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   427: astore 15
      //   429: iconst_m1
      //   430: istore 8
      //   432: aload 15
      //   434: ifnull +30 -> 464
      //   437: aload 15
      //   439: ldc 107
      //   441: iconst_m1
      //   442: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   445: istore 8
      //   447: aload 15
      //   449: ldc 109
      //   451: iconst_m1
      //   452: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   455: pop
      //   456: aload 15
      //   458: ldc 111
      //   460: invokevirtual 115	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   463: pop
      //   464: aload 14
      //   466: ldc 107
      //   468: iload 8
      //   470: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   473: pop
      //   474: aload 15
      //   476: ldc 121
      //   478: iconst_m1
      //   479: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   482: bipush 8
      //   484: if_icmpne +168 -> 652
      //   487: iconst_2
      //   488: istore 9
      //   490: iload 8
      //   492: ifne +340 -> 832
      //   495: aload_2
      //   496: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   499: ifne +159 -> 658
      //   502: aload 13
      //   504: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   507: ifne +151 -> 658
      //   510: iload 4
      //   512: iconst_m1
      //   513: if_icmpeq +145 -> 658
      //   516: iload 6
      //   518: iconst_m1
      //   519: if_icmpeq +139 -> 658
      //   522: iload 5
      //   524: iconst_m1
      //   525: if_icmpeq +133 -> 658
      //   528: iload 9
      //   530: iconst_m1
      //   531: if_icmpeq +127 -> 658
      //   534: aload_0
      //   535: getfield 13	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
      //   538: aload_2
      //   539: aload 13
      //   541: iload 4
      //   543: iload 5
      //   545: iload 6
      //   547: iload 9
      //   549: aconst_null
      //   550: aload_3
      //   551: iload_1
      //   552: iload 7
      //   554: invokevirtual 125	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:invokeMidasConsume	(Ljava/lang/String;Ljava/lang/String;IIIILNS_COMM/COMM$StCommonExt;Ljava/lang/String;II)V
      //   557: return
      //   558: astore 14
      //   560: ldc 76
      //   562: iconst_1
      //   563: aload 14
      //   565: iconst_0
      //   566: anewarray 127	java/lang/Object
      //   569: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   572: iload 12
      //   574: istore 7
      //   576: goto -212 -> 364
      //   579: aload 19
      //   581: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   584: istore_1
      //   585: aload 16
      //   587: astore_2
      //   588: aload 17
      //   590: astore 13
      //   592: iload 8
      //   594: istore 4
      //   596: iload 10
      //   598: istore 5
      //   600: iload 9
      //   602: istore 6
      //   604: iload 12
      //   606: istore 7
      //   608: goto -244 -> 364
      //   611: astore_2
      //   612: ldc 76
      //   614: iconst_1
      //   615: aload_2
      //   616: iconst_0
      //   617: anewarray 127	java/lang/Object
      //   620: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   623: aload 16
      //   625: astore_2
      //   626: aload 17
      //   628: astore 13
      //   630: iload 8
      //   632: istore 4
      //   634: iload 10
      //   636: istore 5
      //   638: iload 9
      //   640: istore 6
      //   642: iload 11
      //   644: istore_1
      //   645: iload 12
      //   647: istore 7
      //   649: goto -285 -> 364
      //   652: iconst_3
      //   653: istore 9
      //   655: goto -165 -> 490
      //   658: aload_3
      //   659: aload 15
      //   661: invokestatic 143	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
      //   664: astore_2
      //   665: aload_2
      //   666: ldc 107
      //   668: bipush 252
      //   670: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   673: pop
      //   674: aload_2
      //   675: ifnull +151 -> 826
      //   678: aload_2
      //   679: invokevirtual 144	org/json/JSONObject:toString	()Ljava/lang/String;
      //   682: astore_2
      //   683: aload_2
      //   684: ifnull -127 -> 557
      //   687: ldc 76
      //   689: iconst_1
      //   690: new 78	java/lang/StringBuilder
      //   693: dup
      //   694: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   697: ldc 146
      //   699: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   702: aload_3
      //   703: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   706: ldc 148
      //   708: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   711: aload_2
      //   712: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   715: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   718: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   721: aload_0
      //   722: getfield 13	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
      //   725: aload_3
      //   726: aload_2
      //   727: iload_1
      //   728: invokestatic 152	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:access$000	(Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;Ljava/lang/String;Ljava/lang/String;I)V
      //   731: return
      //   732: astore_2
      //   733: ldc 76
      //   735: iconst_1
      //   736: aload_2
      //   737: iconst_0
      //   738: anewarray 127	java/lang/Object
      //   741: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   744: aload_3
      //   745: aconst_null
      //   746: invokestatic 143	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
      //   749: astore_2
      //   750: aload_2
      //   751: ldc 107
      //   753: bipush 253
      //   755: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   758: pop
      //   759: aload_2
      //   760: ifnull +102 -> 862
      //   763: aload_2
      //   764: invokevirtual 144	org/json/JSONObject:toString	()Ljava/lang/String;
      //   767: astore_2
      //   768: aload_2
      //   769: ifnull -212 -> 557
      //   772: ldc 76
      //   774: iconst_1
      //   775: new 78	java/lang/StringBuilder
      //   778: dup
      //   779: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   782: ldc 146
      //   784: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   787: aload_3
      //   788: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   791: ldc 148
      //   793: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   796: aload_2
      //   797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   800: ldc 154
      //   802: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   805: iload_1
      //   806: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   809: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   812: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   815: aload_0
      //   816: getfield 13	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
      //   819: aload_3
      //   820: aload_2
      //   821: iload_1
      //   822: invokestatic 152	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:access$000	(Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;Ljava/lang/String;Ljava/lang/String;I)V
      //   825: return
      //   826: ldc 156
      //   828: astore_2
      //   829: goto -146 -> 683
      //   832: aload_0
      //   833: getfield 13	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
      //   836: aload 13
      //   838: aload_2
      //   839: iload 4
      //   841: aconst_null
      //   842: aload_3
      //   843: iload_1
      //   844: iload 7
      //   846: iload 9
      //   848: invokevirtual 160	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:invokeMidasQuery	(Ljava/lang/String;Ljava/lang/String;ILNS_COMM/COMM$StCommonExt;Ljava/lang/String;III)V
      //   851: return
      //   852: astore 13
      //   854: aload 13
      //   856: invokevirtual 163	org/json/JSONException:printStackTrace	()V
      //   859: goto -100 -> 759
      //   862: ldc 156
      //   864: astore_2
      //   865: goto -97 -> 768
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	868	0	this	PayResultRecevicer
      //   0	868	1	paramInt	int
      //   0	868	2	paramBundle	Bundle
      //   0	868	3	paramString	String
      //   52	788	4	i	int
      //   56	581	5	j	int
      //   60	581	6	k	int
      //   67	778	7	m	int
      //   35	596	8	n	int
      //   32	815	9	i1	int
      //   29	606	10	i2	int
      //   41	602	11	i3	int
      //   38	608	12	i4	int
      //   48	789	13	localObject1	java.lang.Object
      //   852	3	13	localJSONException1	JSONException
      //   17	448	14	localObject2	java.lang.Object
      //   558	6	14	localJSONException2	JSONException
      //   23	637	15	localObject3	java.lang.Object
      //   20	604	16	localJSONObject	JSONObject
      //   26	601	17	localObject4	java.lang.Object
      //   6	417	18	str1	String
      //   14	566	19	str2	String
      // Exception table:
      //   from	to	target	type
      //   107	118	558	org/json/JSONException
      //   140	150	558	org/json/JSONException
      //   172	182	558	org/json/JSONException
      //   204	214	558	org/json/JSONException
      //   236	246	558	org/json/JSONException
      //   268	278	558	org/json/JSONException
      //   300	310	558	org/json/JSONException
      //   332	342	558	org/json/JSONException
      //   579	585	611	java/lang/NumberFormatException
      //   418	429	732	java/lang/Throwable
      //   437	464	732	java/lang/Throwable
      //   464	487	732	java/lang/Throwable
      //   495	510	732	java/lang/Throwable
      //   534	557	732	java/lang/Throwable
      //   658	674	732	java/lang/Throwable
      //   678	683	732	java/lang/Throwable
      //   687	731	732	java/lang/Throwable
      //   832	851	732	java/lang/Throwable
      //   750	759	852	org/json/JSONException
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
      switch (paramInt)
      {
      default: 
        return;
      }
      handlePayResult(paramInt, paramBundle, "requestMidasPayment");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment
 * JD-Core Version:    0.7.0.1
 */