import android.content.BroadcastReceiver;
import com.tencent.mobileqq.jsp.EventApiPlugin;

public class gee
  extends BroadcastReceiver
{
  public gee(EventApiPlugin paramEventApiPlugin) {}
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: ldc 20
    //   11: invokevirtual 26	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -9 -> 7
    //   19: aload_1
    //   20: aload_0
    //   21: getfield 10	gee:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   24: getfield 32	com/tencent/mobileqq/jsp/EventApiPlugin:b	Ljava/lang/String;
    //   27: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifne -23 -> 7
    //   33: aload_2
    //   34: ldc 40
    //   36: invokevirtual 26	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 6
    //   41: aload 6
    //   43: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne -39 -> 7
    //   49: aload_2
    //   50: ldc 48
    //   52: invokevirtual 26	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +136 -> 193
    //   60: new 50	org/json/JSONObject
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 53	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_2
    //   70: ldc 55
    //   72: invokevirtual 59	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   75: astore 7
    //   77: aload 7
    //   79: ifnull -72 -> 7
    //   82: aload_2
    //   83: ldc 61
    //   85: invokevirtual 26	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 8
    //   90: aload 5
    //   92: astore_2
    //   93: aload 8
    //   95: ifnull +13 -> 108
    //   98: new 50	org/json/JSONObject
    //   101: dup
    //   102: aload 8
    //   104: invokespecial 53	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore_2
    //   108: aload_0
    //   109: getfield 10	gee:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   112: getfield 65	com/tencent/mobileqq/jsp/EventApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   115: invokevirtual 70	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/smtt/sdk/WebView;
    //   118: astore 5
    //   120: aload 5
    //   122: ifnull -115 -> 7
    //   125: aload 5
    //   127: invokevirtual 76	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   130: invokestatic 82	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   133: invokevirtual 85	android/net/Uri:getHost	()Ljava/lang/String;
    //   136: astore 5
    //   138: aload 7
    //   140: invokevirtual 91	java/util/ArrayList:size	()I
    //   143: istore 4
    //   145: iconst_0
    //   146: istore_3
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpge -143 -> 7
    //   153: aload 7
    //   155: iload_3
    //   156: invokevirtual 95	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 34	java/lang/String
    //   162: aload 5
    //   164: invokestatic 100	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   167: ifeq +15 -> 182
    //   170: aload_0
    //   171: getfield 10	gee:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   174: aload 6
    //   176: aload_1
    //   177: aload_2
    //   178: invokevirtual 104	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   181: return
    //   182: iload_3
    //   183: iconst_1
    //   184: iadd
    //   185: istore_3
    //   186: goto -39 -> 147
    //   189: astore_1
    //   190: return
    //   191: astore_1
    //   192: return
    //   193: aconst_null
    //   194: astore_1
    //   195: goto -126 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	gee
    //   0	198	1	paramContext	android.content.Context
    //   0	198	2	paramIntent	android.content.Intent
    //   146	40	3	i	int
    //   143	8	4	j	int
    //   1	162	5	localObject	java.lang.Object
    //   39	136	6	str1	java.lang.String
    //   75	79	7	localArrayList	java.util.ArrayList
    //   88	15	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   98	108	189	org/json/JSONException
    //   60	69	191	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gee
 * JD-Core Version:    0.7.0.1
 */