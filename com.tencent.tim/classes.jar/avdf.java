import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class avdf
  extends VasWebviewJsPlugin
{
  Activity browserActivity = null;
  BrowserAppInterface browserAppInterface = null;
  Context context = null;
  
  public avdf()
  {
    this.mPluginNameSpace = "comicFavor";
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: ldc 43
    //   8: iconst_2
    //   9: new 45	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   16: ldc 48
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 54
    //   27: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 56
    //   36: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 4
    //   41: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +20 -> 74
    //   57: ldc 22
    //   59: aload_3
    //   60: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +11 -> 74
    //   66: aload 4
    //   68: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +5 -> 76
    //   74: iconst_0
    //   75: ireturn
    //   76: new 78	org/json/JSONObject
    //   79: dup
    //   80: aload 5
    //   82: iconst_0
    //   83: aaload
    //   84: invokespecial 81	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull -15 -> 74
    //   92: aload_2
    //   93: ldc 83
    //   95: invokevirtual 87	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: ldc 89
    //   101: aload 4
    //   103: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +66 -> 172
    //   109: aload_0
    //   110: ldc 91
    //   112: aload_1
    //   113: aload_0
    //   114: getfield 95	avdf:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   117: getfield 101	com/tencent/mobileqq/emosm/Client$b:key	I
    //   120: aconst_null
    //   121: invokestatic 107	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   124: iconst_0
    //   125: iconst_1
    //   126: invokespecial 111	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_1
    //   132: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +28 -> 163
    //   138: ldc 43
    //   140: iconst_2
    //   141: new 45	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   148: ldc 113
    //   150: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aconst_null
    //   154: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 119	org/json/JSONException:printStackTrace	()V
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -81 -> 88
    //   172: ldc 121
    //   174: aload 4
    //   176: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +270 -> 449
    //   182: new 78	org/json/JSONObject
    //   185: dup
    //   186: invokespecial 122	org/json/JSONObject:<init>	()V
    //   189: astore_3
    //   190: aload_0
    //   191: getfield 20	avdf:browserActivity	Landroid/app/Activity;
    //   194: invokestatic 128	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
    //   197: ifne +39 -> 236
    //   200: aload_3
    //   201: ldc 130
    //   203: bipush 254
    //   205: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_3
    //   210: ldc 136
    //   212: ldc 138
    //   214: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload_0
    //   219: aload_1
    //   220: iconst_1
    //   221: anewarray 72	java/lang/String
    //   224: dup
    //   225: iconst_0
    //   226: aload_3
    //   227: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokespecial 146	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   234: iconst_1
    //   235: ireturn
    //   236: ldc 148
    //   238: invokestatic 153	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   241: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +39 -> 283
    //   247: aload_3
    //   248: ldc 130
    //   250: bipush 253
    //   252: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_3
    //   257: ldc 136
    //   259: ldc 155
    //   261: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_0
    //   266: aload_1
    //   267: iconst_1
    //   268: anewarray 72	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload_3
    //   274: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   277: aastore
    //   278: invokespecial 146	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   281: iconst_1
    //   282: ireturn
    //   283: aload_2
    //   284: ldc 157
    //   286: invokevirtual 161	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   289: astore_2
    //   290: aload_2
    //   291: ifnull +10 -> 301
    //   294: aload_2
    //   295: invokevirtual 167	org/json/JSONArray:length	()I
    //   298: ifne +39 -> 337
    //   301: aload_3
    //   302: ldc 130
    //   304: bipush 252
    //   306: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload_3
    //   311: ldc 136
    //   313: ldc 169
    //   315: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload_0
    //   320: aload_1
    //   321: iconst_1
    //   322: anewarray 72	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload_3
    //   328: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokespecial 146	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   335: iconst_1
    //   336: ireturn
    //   337: new 171	android/os/Bundle
    //   340: dup
    //   341: invokespecial 172	android/os/Bundle:<init>	()V
    //   344: astore_3
    //   345: aload_3
    //   346: ldc 174
    //   348: aload_2
    //   349: invokevirtual 175	org/json/JSONArray:toString	()Ljava/lang/String;
    //   352: invokevirtual 179	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_0
    //   356: ldc 181
    //   358: aload_1
    //   359: aload_0
    //   360: getfield 95	avdf:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   363: getfield 101	com/tencent/mobileqq/emosm/Client$b:key	I
    //   366: aload_3
    //   367: invokestatic 107	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   370: iconst_0
    //   371: iconst_1
    //   372: invokespecial 111	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   375: goto -246 -> 129
    //   378: astore_3
    //   379: aload_1
    //   380: astore_2
    //   381: aload_3
    //   382: astore_1
    //   383: new 78	org/json/JSONObject
    //   386: dup
    //   387: invokespecial 122	org/json/JSONObject:<init>	()V
    //   390: astore_3
    //   391: aload_3
    //   392: ldc 130
    //   394: iconst_m1
    //   395: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload_3
    //   400: ldc 136
    //   402: aload_1
    //   403: invokevirtual 184	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   406: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload_0
    //   411: aload_2
    //   412: iconst_1
    //   413: anewarray 72	java/lang/String
    //   416: dup
    //   417: iconst_0
    //   418: aload_3
    //   419: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokevirtual 185	avdf:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: goto -297 -> 129
    //   429: astore_2
    //   430: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -304 -> 129
    //   436: ldc 43
    //   438: iconst_2
    //   439: aload_1
    //   440: invokevirtual 184	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   443: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto -317 -> 129
    //   449: ldc 190
    //   451: aload 4
    //   453: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifeq -327 -> 129
    //   459: aload_0
    //   460: ldc 192
    //   462: aload_1
    //   463: aload_0
    //   464: getfield 95	avdf:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   467: getfield 101	com/tencent/mobileqq/emosm/Client$b:key	I
    //   470: aconst_null
    //   471: invokestatic 107	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   474: iconst_0
    //   475: iconst_1
    //   476: invokespecial 111	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   479: goto -350 -> 129
    //   482: astore_1
    //   483: aconst_null
    //   484: astore_2
    //   485: goto -102 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	avdf
    //   0	488	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	488	2	paramString1	String
    //   0	488	3	paramString2	String
    //   0	488	4	paramString3	String
    //   0	488	5	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   76	88	131	org/json/JSONException
    //   99	129	378	java/lang/Throwable
    //   172	234	378	java/lang/Throwable
    //   236	281	378	java/lang/Throwable
    //   283	290	378	java/lang/Throwable
    //   294	301	378	java/lang/Throwable
    //   301	335	378	java/lang/Throwable
    //   337	375	378	java/lang/Throwable
    //   449	479	378	java/lang/Throwable
    //   383	426	429	java/lang/Exception
    //   92	99	482	java/lang/Throwable
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.browserAppInterface = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.browserActivity = this.mRuntime.getActivity();
    this.context = this.mRuntime.getActivity().getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.context = null;
    this.browserActivity = null;
    this.browserAppInterface = null;
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      try
      {
        if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
          return;
        }
        String str1 = paramBundle.getString("cmd");
        String str2 = paramBundle.getString("callbackid");
        String str3 = paramBundle.getString("result");
        if (QLog.isColorLevel()) {
          QLog.e("VipComicEmoticonJsPlugin", 2, "onResponse,callback=" + str2 + ",cmd=" + str1 + ",result=" + str3);
        }
        if (str1 == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        if (("ipc_comic_emoticon_add_info".equals(str1)) || ("ipc_comic_emoticon_query_info".equals(str1)) || ("ipc_sync_fav_emoticon".equals(str1)))
        {
          if (TextUtils.isEmpty(str3))
          {
            localJSONObject.put("code", -5);
            localJSONObject.put("message", "invalid data, response data is null");
            super.callJs(str2, new String[] { localJSONObject.toString() });
            return;
          }
          super.callJs(str2, new String[] { str3 });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      super.onResponse(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdf
 * JD-Core Version:    0.7.0.1
 */