import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class assp
  extends BaseJsPlugin
{
  private assp.a a;
  
  /* Error */
  @com.tencent.qqmini.sdk.annotation.JsEvent({"checkin_invokeGYCamera"})
  public void checkinInvokeGYCamera(com.tencent.qqmini.sdk.launcher.core.model.RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: new 39	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 45	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   8: invokespecial 48	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 21	assp:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   16: invokeinterface 54 1 0
    //   21: ifnull +294 -> 315
    //   24: aload_0
    //   25: getfield 56	assp:a	Lassp$a;
    //   28: ifnull +19 -> 47
    //   31: aload_0
    //   32: getfield 21	assp:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   35: invokeinterface 54 1 0
    //   40: aload_0
    //   41: getfield 56	assp:a	Lassp$a;
    //   44: invokevirtual 62	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   47: aload_3
    //   48: ldc 64
    //   50: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   53: astore 6
    //   55: new 70	android/os/Bundle
    //   58: dup
    //   59: invokespecial 71	android/os/Bundle:<init>	()V
    //   62: astore 5
    //   64: aload 6
    //   66: ifnonnull +28 -> 94
    //   69: ldc 73
    //   71: iconst_1
    //   72: ldc 75
    //   74: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual 85	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   81: pop
    //   82: return
    //   83: astore_1
    //   84: ldc 73
    //   86: iconst_1
    //   87: ldc 87
    //   89: aload_1
    //   90: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: return
    //   94: ldc 73
    //   96: iconst_1
    //   97: new 92	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   104: ldc 95
    //   106: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 6
    //   111: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   114: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 108
    //   125: astore_3
    //   126: getstatic 113	axcg:a	Laxcg;
    //   129: invokevirtual 117	axcg:getId	()I
    //   132: istore_2
    //   133: ldc 108
    //   135: astore 4
    //   137: aload 6
    //   139: ldc 119
    //   141: invokevirtual 123	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   144: ifeq +11 -> 155
    //   147: aload 6
    //   149: ldc 119
    //   151: invokevirtual 127	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: aload 6
    //   157: ldc 129
    //   159: invokevirtual 123	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   162: ifeq +17 -> 179
    //   165: aload 6
    //   167: ldc 129
    //   169: invokevirtual 127	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 132	axcg:a	(Ljava/lang/String;)Laxcg;
    //   175: invokevirtual 117	axcg:getId	()I
    //   178: istore_2
    //   179: aload 6
    //   181: ldc 134
    //   183: invokevirtual 123	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   186: ifeq +12 -> 198
    //   189: aload 6
    //   191: ldc 134
    //   193: invokevirtual 127	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 4
    //   198: aload 5
    //   200: ldc 136
    //   202: iload_2
    //   203: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   206: aload 5
    //   208: ldc 134
    //   210: aload 4
    //   212: invokevirtual 143	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 21	assp:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   219: invokeinterface 54 1 0
    //   224: ldc 145
    //   226: iconst_0
    //   227: invokevirtual 149	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   230: invokeinterface 155 1 0
    //   235: ldc 157
    //   237: aload_3
    //   238: invokeinterface 162 3 0
    //   243: invokeinterface 165 1 0
    //   248: invokestatic 171	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   251: ldc 173
    //   253: ldc 175
    //   255: aload 5
    //   257: aconst_null
    //   258: invokevirtual 179	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   261: aload_1
    //   262: invokevirtual 182	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   265: pop
    //   266: aload_0
    //   267: getfield 21	assp:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   270: invokeinterface 54 1 0
    //   275: astore_1
    //   276: new 6	assp$a
    //   279: dup
    //   280: aload_0
    //   281: aconst_null
    //   282: invokespecial 185	assp$a:<init>	(Lassp;Lassq;)V
    //   285: astore_3
    //   286: aload_0
    //   287: aload_3
    //   288: putfield 56	assp:a	Lassp$a;
    //   291: aload_1
    //   292: aload_3
    //   293: new 187	android/content/IntentFilter
    //   296: dup
    //   297: ldc 189
    //   299: invokespecial 190	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   302: invokevirtual 194	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   305: pop
    //   306: return
    //   307: astore_3
    //   308: aload_3
    //   309: invokevirtual 197	org/json/JSONException:printStackTrace	()V
    //   312: goto -64 -> 248
    //   315: ldc 73
    //   317: iconst_1
    //   318: ldc 199
    //   320: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: return
    //   324: astore 4
    //   326: goto -279 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	assp
    //   0	329	1	paramRequestEvent	com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    //   132	71	2	i	int
    //   11	282	3	localObject	java.lang.Object
    //   307	2	3	localJSONException	JSONException
    //   135	76	4	str	String
    //   324	1	4	localThrowable	Throwable
    //   62	194	5	localBundle	android.os.Bundle
    //   53	137	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	12	83	org/json/JSONException
    //   69	82	307	org/json/JSONException
    //   94	123	307	org/json/JSONException
    //   126	133	307	org/json/JSONException
    //   137	155	307	org/json/JSONException
    //   155	179	307	org/json/JSONException
    //   179	198	307	org/json/JSONException
    //   198	248	307	org/json/JSONException
    //   31	47	324	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    if ((this.mMiniAppContext.getContext() != null) && (this.a != null)) {}
    try
    {
      this.mMiniAppContext.getContext().unregisterReceiver(this.a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (assp.a(assp.this).getContext() == null) {
        return;
      }
      paramContext = new JSONObject();
      for (;;)
      {
        try
        {
          String str1 = paramIntent.getStringExtra("file_path");
          String str2 = paramIntent.getStringExtra("video_thumb_path");
          long l = paramIntent.getLongExtra("video_duration", 0L);
          boolean bool = paramIntent.getBooleanExtra("is_video", false);
          paramContext.put("filePath", ((IMiniAppFileManager)assp.b(assp.this).getManager(IMiniAppFileManager.class)).getWxFilePath(str1));
          if (!bool) {
            continue;
          }
          i = 1;
          paramContext.put("isVideo", i);
          if (bool)
          {
            paramContext.put("videoDuration", (l + 999L) / 1000L);
            paramContext.put("cover", ((IMiniAppFileManager)assp.c(assp.this).getManager(IMiniAppFileManager.class)).getWxFilePath(str2));
          }
        }
        catch (JSONException paramIntent)
        {
          int i;
          paramIntent.printStackTrace();
          continue;
        }
        QLog.e("LaunchCameraPlugin", 1, "data: " + paramContext);
        assp.a(assp.this, "custom_event_checkin_onCameraInfoEvent", paramContext.toString());
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assp
 * JD-Core Version:    0.7.0.1
 */