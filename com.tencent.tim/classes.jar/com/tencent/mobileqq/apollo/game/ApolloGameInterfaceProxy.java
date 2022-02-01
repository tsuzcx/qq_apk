package com.tencent.mobileqq.apollo.game;

import abkj;
import able;
import ablh;
import abli;
import ablj;
import abll;
import abll.a;
import ablp;
import ablq;
import ablv;
import abmt;
import aboi;
import abos;
import aboz;
import abpc;
import abpt;
import abpu;
import abxt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import aqhs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class ApolloGameInterfaceProxy
  implements ablv
{
  private Pattern V;
  private ablq jdField_a_of_type_Ablq;
  private abpt jdField_a_of_type_Abpt = new ablh(this);
  private WebGameFakeView jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private boolean bDD;
  private String bgP;
  private int mGameId;
  private int mTaskId;
  
  public ApolloGameInterfaceProxy(ablq paramablq, String paramString)
  {
    this.jdField_a_of_type_Ablq = paramablq;
    try
    {
      this.mGameId = Integer.parseInt(paramString);
      cCH();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "[ApolloGameInterfaceProxy] " + this.mGameId + " " + this.bgP);
      }
      return;
    }
    catch (Throwable paramablq)
    {
      for (;;)
      {
        this.mGameId = 0;
        this.bgP = paramString;
      }
    }
  }
  
  /* Error */
  private void BK(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +380 -> 384
    //   7: new 90	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 92	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc 94
    //   21: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: new 90	org/json/JSONObject
    //   28: dup
    //   29: aload_3
    //   30: invokespecial 92	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 94
    //   37: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: istore_2
    //   44: iload_2
    //   45: ifne +333 -> 378
    //   48: aload_1
    //   49: ldc 94
    //   51: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: aload_3
    //   60: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +321 -> 384
    //   66: aload_0
    //   67: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   70: ifnull +314 -> 384
    //   73: aload_0
    //   74: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   77: getfield 106	com/tencent/mobileqq/apollo/game/WebGameFakeView:mContext	Landroid/content/Context;
    //   80: ifnull +304 -> 384
    //   83: aload_3
    //   84: ldc 108
    //   86: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +160 -> 249
    //   92: new 57	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   99: aload_3
    //   100: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 115
    //   105: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_3
    //   112: new 117	android/content/Intent
    //   115: dup
    //   116: invokespecial 118	android/content/Intent:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: ldc 94
    //   125: aload_3
    //   126: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: aload 4
    //   132: ldc 94
    //   134: aload_3
    //   135: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   138: pop
    //   139: aload 4
    //   141: ldc 124
    //   143: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   146: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   149: pop
    //   150: aload_0
    //   151: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   154: invokevirtual 137	com/tencent/mobileqq/apollo/game/WebGameFakeView:l	()Landroid/os/Bundle;
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull +205 -> 364
    //   162: aload_3
    //   163: ldc 139
    //   165: invokevirtual 145	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull +185 -> 355
    //   173: aload_3
    //   174: instanceof 147
    //   177: ifeq +178 -> 355
    //   180: aload_3
    //   181: checkcast 147	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam
    //   184: getfield 150	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:mGameType	I
    //   187: iconst_3
    //   188: if_icmpne +84 -> 272
    //   191: aload 4
    //   193: getstatic 155	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   196: aload_1
    //   197: getstatic 155	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   200: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   206: pop
    //   207: aload 4
    //   209: getstatic 158	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:TITLE	Ljava/lang/String;
    //   212: aload_1
    //   213: getstatic 158	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:TITLE	Ljava/lang/String;
    //   216: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   222: pop
    //   223: aload 4
    //   225: getstatic 161	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   228: aload_1
    //   229: getstatic 161	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   232: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_0
    //   240: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   243: aload 4
    //   245: invokevirtual 165	com/tencent/mobileqq/apollo/game/WebGameFakeView:db	(Landroid/content/Intent;)V
    //   248: return
    //   249: new 57	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   256: aload_3
    //   257: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 167
    //   262: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore_3
    //   269: goto -157 -> 112
    //   272: aload 4
    //   274: ldc 169
    //   276: ldc 171
    //   278: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   281: pop
    //   282: aload 4
    //   284: aload_0
    //   285: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   288: getfield 106	com/tencent/mobileqq/apollo/game/WebGameFakeView:mContext	Landroid/content/Context;
    //   291: ldc 173
    //   293: invokevirtual 177	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   296: pop
    //   297: aload 4
    //   299: ldc 178
    //   301: invokevirtual 182	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   304: pop
    //   305: aload_0
    //   306: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   309: getfield 106	com/tencent/mobileqq/apollo/game/WebGameFakeView:mContext	Landroid/content/Context;
    //   312: instanceof 184
    //   315: ifeq +69 -> 384
    //   318: aload_0
    //   319: getfield 100	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   322: getfield 106	com/tencent/mobileqq/apollo/game/WebGameFakeView:mContext	Landroid/content/Context;
    //   325: checkcast 184	android/app/Activity
    //   328: aload 4
    //   330: sipush 999
    //   333: invokevirtual 188	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   336: return
    //   337: astore_1
    //   338: ldc 55
    //   340: iconst_1
    //   341: aload_1
    //   342: iconst_1
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: ldc 190
    //   350: aastore
    //   351: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   354: return
    //   355: ldc 55
    //   357: iconst_1
    //   358: ldc 196
    //   360: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: return
    //   364: ldc 55
    //   366: iconst_1
    //   367: ldc 200
    //   369: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: return
    //   373: astore 4
    //   375: goto +14 -> 389
    //   378: aload 4
    //   380: astore_1
    //   381: goto -322 -> 59
    //   384: return
    //   385: astore_1
    //   386: aload 4
    //   388: astore_1
    //   389: goto -330 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	ApolloGameInterfaceProxy
    //   0	392	1	paramString	String
    //   43	2	2	bool	boolean
    //   24	245	3	localObject1	Object
    //   15	314	4	localObject2	Object
    //   373	14	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	25	337	java/lang/Throwable
    //   59	112	337	java/lang/Throwable
    //   112	158	337	java/lang/Throwable
    //   162	169	337	java/lang/Throwable
    //   173	248	337	java/lang/Throwable
    //   249	269	337	java/lang/Throwable
    //   272	336	337	java/lang/Throwable
    //   355	363	337	java/lang/Throwable
    //   364	372	337	java/lang/Throwable
    //   48	56	373	java/lang/Throwable
    //   25	44	385	java/lang/Throwable
  }
  
  private void BL(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = new JSONObject(paramString).optString("url");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString)))
        {
          QLog.e("ApolloGameInterfaceProxy", 1, "[openWebViewWithoutUrl] ill url " + paramString);
          return;
        }
        if (paramString.contains("?"))
        {
          paramString = paramString + "&apollo_bk=1";
          int i = this.mTaskId;
          Intent localIntent = new Intent();
          localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          localIntent.putExtra("extra_key_weburl", paramString);
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.addFlags(65536);
          localIntent.putExtra("game_busid", "Android.H5");
          localIntent.putExtra("extra_key_gameid", this.mGameId);
          localIntent.putExtra("extra_key_taskid", i);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.mContext == null)) {
            break;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.l().getSerializable("game_init");
          if ((paramString == null) || (!(paramString instanceof CmGameStartChecker.StartCheckParam))) {
            break;
          }
          paramString = (CmGameStartChecker.StartCheckParam)paramString;
          localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.mContext, ApolloFloatActivity.class);
          localIntent.putExtra("extra_key_entratation", paramString.viewMode + 1);
          if (!(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.mContext instanceof Activity)) {
            break;
          }
          ((Activity)this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.mContext).startActivityForResult(localIntent, 999);
          paramString = new JSONObject();
          paramString.put("taskId", i);
          ep("cs.openWebViewWithoutUrl.local", paramString.toString());
          this.mTaskId += 1;
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[] { "[send]" });
        return;
      }
      paramString = paramString + "?apollo_bk=1";
    }
  }
  
  private void BM(String paramString)
  {
    abos localabos = abmt.a(this.mGameId);
    if ((localabos != null) && (!TextUtils.isEmpty(paramString)))
    {
      abxt.b(this.mGameId, paramString, localabos.q());
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[shareGameInARK] can not find launcher for " + this.mGameId);
  }
  
  private void BN(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      abos localabos = abmt.a(this.mGameId);
      if (localabos != null) {
        localabos.CA(paramString);
      }
    }
  }
  
  private void BO(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("cmd");
      localObject = ablp.aF(((JSONObject)localObject).optString("data"), String.valueOf(this.mGameId));
      abpu localabpu = abmt.a();
      if ((localabpu != null) && (!TextUtils.isEmpty(paramString)) && (jr(str))) {
        localabpu.ex(str, (String)localObject);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void BP(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("url", new JSONObject(paramString).optString("url"));
      localIntent.putExtra("isFullScreen", true);
      able.a().cZ(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void BQ(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      String str = new JSONObject(paramString).optString("url");
      paramString = str;
      if (!TextUtils.isEmpty(str))
      {
        paramString = str;
        if (!str.startsWith("http://"))
        {
          paramString = str;
          if (!str.startsWith("https://"))
          {
            paramString = str;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              abll.a locala = abll.a().a(str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.getGameId()));
              paramString = str;
              if (locala != null) {
                paramString = locala.rb();
              }
            }
          }
        }
      }
      if (paramString.contains("?")) {}
      for (paramString = paramString + "&apollo_bk=1";; paramString = paramString + "?apollo_bk=1")
      {
        localIntent.putExtra("url", paramString);
        able.a().a(localIntent, ApolloWebViewFragment.class);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void BR(String paramString)
  {
    for (;;)
    {
      try
      {
        new JSONObject(paramString).optString("business");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInterfaceProxy", 2, "[sendMessageToGame] " + paramString);
        }
        el("sc.web_callback_game.local", paramString);
        abos localabos = abmt.b();
        if (localabos != null)
        {
          i = localabos.getGameId();
          if (i > 0)
          {
            localabos = abmt.a(i);
            if (localabos == null) {
              break;
            }
            localabos.BR(paramString);
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameInterfaceProxy", 2, "[sendMessageToGame] no running game");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[] { "[send]" });
        return;
      }
      int i = 0;
    }
  }
  
  public static String a(int paramInt1, int paramInt2, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (paramCmGameInitParams.extInfoFromSvr == null)) {
      return null;
    }
    String str1 = paramInt1 + ";" + (paramInt1 + paramInt2);
    String str2 = paramCmGameInitParams.extInfoFromSvr;
    paramCmGameInitParams = new JSONObject();
    try
    {
      Object localObject2 = new JSONObject(new JSONObject(str2).optString("certInfo"));
      Object localObject1 = new JSONObject(((JSONObject)localObject2).optString("credentials"));
      str2 = ((JSONObject)localObject1).optString("tmpSecretId");
      Object localObject3 = ((JSONObject)localObject1).optString("tmpSecretKey");
      localObject1 = ((JSONObject)localObject1).optString("sessionToken");
      String str3 = ((JSONObject)localObject2).optString("upLoadPrefUrl");
      localObject2 = ((JSONObject)localObject2).optString("downLoadPrefUrl");
      localObject3 = new SecretKeySpec(((String)localObject3).getBytes(), "HmacSHA1");
      Object localObject4 = Mac.getInstance("HmacSHA1");
      ((Mac)localObject4).init((Key)localObject3);
      localObject3 = ((Mac)localObject4).doFinal(str1.getBytes());
      localObject4 = new StringBuilder();
      paramInt2 = localObject3.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((StringBuilder)localObject4).append(aqhs.byte2HexStr(localObject3[paramInt1]));
        paramInt1 += 1;
      }
      localObject3 = ((StringBuilder)localObject4).toString().toLowerCase();
      paramCmGameInitParams.put("tmpSecretId", str2);
      paramCmGameInitParams.put("sessionToken", localObject1);
      paramCmGameInitParams.put("upLoadPrefUrl", str3);
      paramCmGameInitParams.put("downloadUrl", localObject2);
      paramCmGameInitParams.put("signature", localObject3);
      paramCmGameInitParams.put("signTime", str1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, localThrowable, new Object[0]);
      }
    }
    return paramCmGameInitParams.toString();
  }
  
  private void ej(String paramString1, String paramString2)
  {
    if ("cs.make_room_min.local".equals(paramString2)) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        cCI();
      }
    }
    for (;;)
    {
      return;
      if ("cs.close_room.local".equals(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.destroy(true);
        }
      }
      else
      {
        if ("cs.share_game_in_ark.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ablq != null) {
            this.jdField_a_of_type_Ablq.cCP();
          }
          BM(paramString1);
          return;
        }
        if ("cs.game_shell_share_callback.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ablq != null) {
            this.jdField_a_of_type_Ablq.cCP();
          }
          BN(paramString1);
          return;
        }
        if ("cs.share_game_result.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ablq != null) {
            this.jdField_a_of_type_Ablq.cCP();
          }
          if (!TextUtils.isEmpty(paramString1)) {
            shareToQQ(paramString1);
          }
        }
        else
        {
          if ("cs.openWebView.local".equals(paramString2))
          {
            BK(paramString1);
            return;
          }
          if ("cs.openWebViewWithoutUrl.local".equals(paramString2))
          {
            BL(paramString1);
            return;
          }
          if ("cs.openNativeWebView.local".equals(paramString2))
          {
            BQ(paramString1);
            return;
          }
          if ("cs.gameBack.local".equals(paramString2))
          {
            BP(paramString1);
            return;
          }
          if ("cs.ssoMessage.local".equals(paramString2))
          {
            BO(paramString1);
            return;
          }
          if ("cs.get_userInfo.local".equals(paramString2))
          {
            try
            {
              paramString2 = new JSONObject(paramString1);
              if (paramString2.optInt("nickname") == 1)
              {
                BS(paramString1);
                return;
              }
            }
            catch (Throwable paramString1)
            {
              QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
              return;
            }
            if (paramString2.optInt("avatar") == 1) {
              BT(paramString1);
            }
          }
          else
          {
            if ("cs.on_get_open_key.local".equals(paramString2)) {
              try
              {
                abli localabli = new abli(this);
                Bundle localBundle = new Bundle();
                localBundle.putString("cmd", paramString2);
                localBundle.putString("reqData", paramString1);
                localBundle.putBoolean("async", true);
                localBundle.putInt("gameId", this.mGameId);
                QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, localabli);
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("sc.web_callback_game.local".equals(paramString2))
            {
              if ((paramString1 != null) && (paramString1.length() < 502)) {
                try
                {
                  new JSONObject(paramString1);
                  BR(paramString1);
                  return;
                }
                catch (Throwable paramString1)
                {
                  QLog.e("ApolloGameInterfaceProxy", 1, "[callNormalInterface] invalid");
                  return;
                }
              }
              QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
              return;
            }
            if ("cs.get_file_data.local".equals(paramString2)) {
              try
              {
                ep("cs.get_file_data.local", iu(new JSONObject(paramString1).optString("path")));
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("cs.fetch_cloud_signature.local".equals(paramString2)) {
              try
              {
                paramString1 = new JSONObject(paramString1);
                ep("cs.fetch_cloud_signature.local", a(paramString1.optInt("now"), paramString1.optInt("delta"), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("cs.closeWebview.local".equals(paramString2)) {
              try
              {
                int i = new JSONObject(paramString1).optInt("taskId");
                paramString1 = abmt.a(this.mGameId);
                if (paramString1 != null)
                {
                  paramString1.HD(i);
                  return;
                }
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
          }
        }
      }
    }
    if ("cs.create_xy.local".equals(paramString2))
    {
      aboi.a("cs.create_xy.local", paramString1, false, null, this.mGameId);
      return;
    }
    if ("cs.get_state_info.local".equals(paramString2))
    {
      em(paramString2, paramString1);
      return;
    }
    eo(paramString2, paramString1);
  }
  
  private void ek(String paramString1, String paramString2)
  {
    if ((!"sc.web_callback_game.local".equals(paramString2)) || ((paramString1 != null) && (paramString1.length() < 502))) {
      try
      {
        new JSONObject(paramString1);
        BR(paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, "[callNormalInterface] invalid");
        return;
      }
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
  }
  
  private void em(String paramString1, String paramString2)
  {
    w(0, paramString1, abmt.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
  }
  
  private void ep(String paramString1, String paramString2)
  {
    w(0, paramString1, paramString2);
  }
  
  private boolean jr(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (this.V == null)
        {
          Object localObject = abmt.a();
          if (localObject != null)
          {
            localObject = ((aboz)localObject).df(this.mGameId);
            if (QLog.isColorLevel()) {
              QLog.w("ApolloGameInterfaceProxy", 1, "isValidSsoCmd cmd:" + paramString + ", rule: " + (String)localObject);
            }
            this.V = Pattern.compile((String)localObject);
          }
        }
      } while (this.V == null);
      bool2 = this.V.matcher(paramString).matches();
      bool1 = bool2;
    } while (bool2);
    QLog.w("ApolloGameInterfaceProxy", 1, "ssoCmdRule,fail to match sso cmd, cmd:" + paramString + ", gameId: " + this.mGameId);
    return bool2;
  }
  
  @JavascriptInterface
  public static void log(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      abkj localabkj = abmt.a();
      if ((paramInt2 < 0) || (paramInt1 > 0))
      {
        paramString1 = ApolloUtil.iZ(paramString1);
        paramString2 = ApolloUtil.iZ(paramString2);
        paramString3 = ApolloUtil.iZ(paramString3);
        QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localabkj != null) {
          localabkj.b("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localabkj != null)
        {
          localabkj.b("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, "[printNativeLog]", paramString1);
    }
  }
  
  private void shareToQQ(String paramString) {}
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_Ablq != null))
    {
      this.jdField_a_of_type_Ablq.y(paramInt, paramString1, paramString2);
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[callbackJS] fail for " + paramString1);
  }
  
  public void BS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString)) {
        bL(1, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public void BT(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString)) {
        bL(2, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public void NF()
  {
    ep("sc.game_shell_close.local", "{}");
    Object localObject = abmt.a(this.mGameId);
    if (localObject != null)
    {
      localObject = ((abos)localObject).q();
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void aP(Object paramObject)
  {
    boolean bool2 = false;
    if (this.mGameId > 0)
    {
      if ((paramObject != null) && ((paramObject instanceof CmGameInitParams))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = ((CmGameInitParams)paramObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a();
      }
      if ((paramObject instanceof ablq)) {
        this.bDD = true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) && (this.bDD)) {
        ep("sc.init_global_var.local", abmt.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("[onCheckFinish] gameId ").append(this.mGameId).append(" # ");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
          break label174;
        }
      }
      label174:
      for (boolean bool1 = true;; bool1 = false)
      {
        localStringBuilder = localStringBuilder.append(bool1).append(" # ");
        bool1 = bool2;
        if (paramObject == null) {
          bool1 = true;
        }
        QLog.e("ApolloGameInterfaceProxy", 1, bool1);
        return;
      }
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[onCheckFinish] gameId 0");
  }
  
  public void bL(int paramInt, String paramString)
  {
    if (this.mGameId == 0) {}
    abpc localabpc;
    do
    {
      return;
      localabpc = abmt.a(this.mGameId);
    } while (localabpc == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localabpc.a(2, localArrayList, null, 10, 0L, false, "", "", new ablj(this, paramInt, paramString));
  }
  
  public void cCH()
  {
    if (this.mGameId != 0)
    {
      localabos = abmt.a(this.mGameId);
      if (localabos != null)
      {
        localObject = localabos.q();
        if ((localObject != null) && ((localObject instanceof ApolloGameActivity)))
        {
          localObject = (ApolloGameActivity)localObject;
          if (!((ApolloGameActivity)localObject).isFinishing())
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView = ((ApolloGameActivity)localObject).a();
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(this);
              localObject = abmt.getAppInterface();
              if ((localObject != null) && (this.jdField_a_of_type_Abpt != null)) {
                ((AppInterface)localObject).addObserver(this.jdField_a_of_type_Abpt);
              }
              localabos.b(this);
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      abos localabos;
      Object localObject;
      return;
      QLog.e("ApolloGameInterfaceProxy", 1, "[bindGameView] cann not bindGameView");
      return;
    }
    QLog.d("ApolloGameInterfaceProxy", 2, "[bindGameView] " + this.mGameId);
  }
  
  public void cCI()
  {
    ep("sc.game_shell_pack_up.local", "{}");
    abos localabos = abmt.a(this.mGameId);
    if (localabos != null) {
      localabos.caS();
    }
  }
  
  public void cCJ()
  {
    ep("sc.game_shell_share.local", "{}");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.mContext != null))
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.l();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getSerializable("game_init");
          if ((localObject1 != null) && ((localObject1 instanceof CmGameStartChecker.StartCheckParam)))
          {
            Object localObject2 = (CmGameStartChecker.StartCheckParam)localObject1;
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("gameId", String.valueOf(((CmGameStartChecker.StartCheckParam)localObject2).gameId));
            ((JSONObject)localObject1).put("isSelectFriend", 1);
            localObject2 = abmt.a(this.mGameId);
            if (localObject2 != null) {
              ((abos)localObject2).Cz(((JSONObject)localObject1).toString());
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, localThrowable, new Object[] { "[shareGame]" });
    }
  }
  
  public void cCK() {}
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView = null;
    this.jdField_a_of_type_Ablq = null;
    this.mGameId = 0;
    AppInterface localAppInterface = abmt.getAppInterface();
    if ((localAppInterface != null) && (this.jdField_a_of_type_Abpt != null)) {
      localAppInterface.removeObserver(this.jdField_a_of_type_Abpt);
    }
  }
  
  public void el(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = ApolloGamePlugin.wm;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (WeakReference)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            localObject2 = (ApolloGamePlugin)((WeakReference)localObject2).get();
            if (localObject2 != null) {
              ((ApolloGamePlugin)localObject2).eq(paramString1, paramString2);
            }
          }
        }
      }
    }
  }
  
  public void en(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInterfaceProxy", 2, new Object[] { "onNotify, cmd:", paramString1 });
    }
    ep(paramString1, paramString2);
  }
  
  public void eo(String paramString1, String paramString2)
  {
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.requestData(this.mGameId, paramString1, paramString2, false, false);
      return;
    }
    QLog.d("ApolloGameInterfaceProxy", 1, "[onRequestMessage] no cmd handler");
  }
  
  public void exeJsOnEngine(String paramString) {}
  
  public String getRealPath(String paramString)
  {
    String str = null;
    if ((paramString == "") || (paramString == null) || (paramString.endsWith(".js"))) {
      return null;
    }
    if (paramString.startsWith("GameSandBox")) {
      str = "sandbox";
    }
    return ablp.b(paramString, this.mGameId, str, false);
  }
  
  public long getRenderThreadId()
  {
    return this.mGameId;
  }
  
  public long getRuntimeState()
  {
    return this.mGameId;
  }
  
  public boolean isJsRuntime()
  {
    return false;
  }
  
  /* Error */
  public String iu(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 835	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 837	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 838	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 841	java/io/File:exists	()Z
    //   33: ifeq -15 -> 18
    //   36: aload_3
    //   37: invokevirtual 841	java/io/File:exists	()Z
    //   40: ifeq +44 -> 84
    //   43: new 843	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 844	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 849	java/io/InputStream:available	()I
    //   61: newarray byte
    //   63: astore 4
    //   65: aload_3
    //   66: astore_1
    //   67: aload 4
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 853	java/io/InputStream:read	([B)I
    //   76: pop
    //   77: aload_3
    //   78: invokevirtual 856	java/io/InputStream:close	()V
    //   81: aload 4
    //   83: astore_2
    //   84: new 110	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokestatic 861	ajnj:encode	([B)[B
    //   92: invokespecial 864	java/lang/String:<init>	([B)V
    //   95: areturn
    //   96: astore_1
    //   97: ldc 55
    //   99: iconst_1
    //   100: aload_1
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   108: aload 4
    //   110: astore_2
    //   111: goto -27 -> 84
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload 5
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: ldc 55
    //   125: iconst_1
    //   126: aload 4
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: invokevirtual 856	java/io/InputStream:close	()V
    //   139: goto -55 -> 84
    //   142: astore_1
    //   143: ldc 55
    //   145: iconst_1
    //   146: aload_1
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: goto -70 -> 84
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 856	java/io/InputStream:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: ldc 55
    //   169: iconst_1
    //   170: aload_1
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   178: goto -14 -> 164
    //   181: astore_2
    //   182: goto -22 -> 160
    //   185: astore 4
    //   187: goto -66 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ApolloGameInterfaceProxy
    //   0	190	1	paramString	String
    //   7	114	2	localObject1	Object
    //   157	8	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   28	108	3	localObject4	Object
    //   4	105	4	arrayOfByte	byte[]
    //   114	13	4	localThrowable1	Throwable
    //   185	1	4	localThrowable2	Throwable
    //   1	118	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   77	81	96	java/lang/Throwable
    //   43	52	114	java/lang/Throwable
    //   135	139	142	java/lang/Throwable
    //   43	52	157	finally
    //   160	164	166	java/lang/Throwable
    //   57	65	181	finally
    //   70	77	181	finally
    //   123	135	181	finally
    //   57	65	185	java/lang/Throwable
    //   70	77	185	java/lang/Throwable
  }
  
  public void onBackground()
  {
    ep("sc.game_enter_background.local", "{}");
  }
  
  public void onForeground()
  {
    ep("sc.game_enter_foreground.local", "{}");
    ep("sc.game_maximize.local", "{}");
  }
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    ThreadManagerV2.executeOnSubThread(paramIApolloRunnableTask);
  }
  
  @JavascriptInterface
  public void send(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, paramString1 + " " + paramString2 + " " + this.mGameId);
      }
      if (this.mGameId <= 0) {
        break label68;
      }
      ej(paramString1, paramString2);
    }
    label68:
    do
    {
      return;
      if (!TextUtils.isEmpty(this.bgP))
      {
        ek(paramString1, paramString2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameInterfaceProxy", 2, "[send] invalid request for " + paramString2 + " " + paramString1);
  }
  
  public void v(int paramInt, String paramString1, String paramString2)
  {
    w(paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */