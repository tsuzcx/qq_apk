import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.util.QZLog;

public class awgw
  extends awfr
{
  private volatile boolean auZ;
  BroadcastReceiver mReceiver = new awgx(this);
  
  private void eDB()
  {
    try
    {
      if (this.auZ)
      {
        QZLog.i("QzoneWanbaJsPlugin", "removeBroadcast");
        Activity localActivity = this.f.mRuntime.getActivity();
        try
        {
          localActivity.unregisterReceiver(this.mReceiver);
          this.auZ = false;
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QZLog.e("QzoneWanbaJsPlugin", "unregisterReceiver error ", localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("QzoneWanbaJsPlugin", "removeBroadcast error", localException2);
    }
  }
  
  private void registerBroadcast()
  {
    if (this.auZ) {}
    for (;;)
    {
      return;
      try
      {
        QZLog.i("QzoneWanbaJsPlugin", "registerBroadcast");
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("QZONE.ACTION_NOTIFY_ADV_PLAY");
        Activity localActivity = this.f.mRuntime.getActivity();
        boolean bool = this.auZ;
        if (bool) {
          continue;
        }
        try
        {
          localActivity.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
          this.auZ = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("QzoneWanbaJsPlugin", "regist receiver error:", localException1);
          return;
        }
        return;
      }
      catch (Exception localException2)
      {
        QZLog.e("QzoneWanbaJsPlugin", "registerBroadcast error", localException2);
      }
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 92
    //   5: aload_3
    //   6: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: ldc 100
    //   16: aload 4
    //   18: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq -9 -> 12
    //   24: aload 5
    //   26: arraylength
    //   27: iconst_1
    //   28: if_icmpge +12 -> 40
    //   31: ldc 27
    //   33: ldc 102
    //   35: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: iconst_1
    //   39: ireturn
    //   40: aload 5
    //   42: iconst_0
    //   43: aaload
    //   44: astore_3
    //   45: new 106	org/json/JSONObject
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 108	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 110
    //   57: invokevirtual 114	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +33 -> 98
    //   68: ldc 27
    //   70: ldc 122
    //   72: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload_2
    //   78: invokevirtual 125	org/json/JSONException:printStackTrace	()V
    //   81: aload 6
    //   83: astore_2
    //   84: goto -23 -> 61
    //   87: astore_1
    //   88: ldc 27
    //   90: ldc 127
    //   92: aload_1
    //   93: invokestatic 63	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: iconst_1
    //   97: ireturn
    //   98: ldc 27
    //   100: new 129	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   107: ldc 132
    //   109: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 35	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: invokespecial 145	awgw:registerBroadcast	()V
    //   126: aload_0
    //   127: getfield 39	awgw:f	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   130: getfield 45	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   133: invokevirtual 51	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   136: aload_3
    //   137: invokestatic 151	avpw:Y	(Landroid/app/Activity;Ljava/lang/String;)V
    //   140: goto -44 -> 96
    //   143: astore_2
    //   144: goto -67 -> 77
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -73 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	awgw
    //   0	153	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	153	2	paramString1	java.lang.String
    //   0	153	3	paramString2	java.lang.String
    //   0	153	4	paramString3	java.lang.String
    //   0	153	5	paramVarArgs	java.lang.String[]
    //   1	81	6	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	38	87	java/lang/Exception
    //   45	54	87	java/lang/Exception
    //   54	61	87	java/lang/Exception
    //   61	75	87	java/lang/Exception
    //   77	81	87	java/lang/Exception
    //   98	140	87	java/lang/Exception
    //   54	61	143	org/json/JSONException
    //   45	54	147	org/json/JSONException
  }
  
  public void onDestroy()
  {
    eDB();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgw
 * JD-Core Version:    0.7.0.1
 */