import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.1;

public class astl
  implements MiniAppCmdInterface
{
  public astl(AdProxyImpl.1 param1) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +28 -> 33
    //   8: aload_0
    //   9: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   12: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   22: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   25: iconst_0
    //   26: aload_2
    //   27: invokeinterface 31 3 0
    //   32: return
    //   33: new 33	org/json/JSONObject
    //   36: dup
    //   37: invokespecial 34	org/json/JSONObject:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: ldc 36
    //   45: invokevirtual 40	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 42	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   51: astore 5
    //   53: aload_2
    //   54: ldc 44
    //   56: invokevirtual 48	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   59: istore_3
    //   60: aload_2
    //   61: ldc 50
    //   63: invokevirtual 54	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload 5
    //   69: getfield 58	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 6
    //   77: ldc 65
    //   79: iconst_1
    //   80: new 67	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   87: ldc 70
    //   89: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 79
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 81
    //   107: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 6
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 4
    //   123: ldc 44
    //   125: iload_3
    //   126: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload 4
    //   132: ldc 50
    //   134: aload_2
    //   135: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 4
    //   141: ldc 36
    //   143: aload 6
    //   145: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 4
    //   151: ldc 99
    //   153: aload 5
    //   155: getfield 102	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdTemplateJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   158: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   161: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iload_3
    //   166: ifne +158 -> 324
    //   169: aload 6
    //   171: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +150 -> 324
    //   177: aload_0
    //   178: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   181: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   184: ifnull +18 -> 202
    //   187: aload_0
    //   188: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   191: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   194: iconst_1
    //   195: aload 4
    //   197: invokeinterface 31 3 0
    //   202: aload 5
    //   204: ifnull -172 -> 32
    //   207: aload 5
    //   209: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   212: ifnull -180 -> 32
    //   215: aload 5
    //   217: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   220: invokevirtual 118	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   223: ifle -191 -> 32
    //   226: aload 5
    //   228: getfield 122	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   231: invokevirtual 127	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   234: ldc2_w 128
    //   237: lcmp
    //   238: ifne -206 -> 32
    //   241: iconst_0
    //   242: istore_3
    //   243: iload_3
    //   244: aload 5
    //   246: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   249: invokevirtual 118	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   252: if_icmpge -220 -> 32
    //   255: aload 5
    //   257: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   260: iload_3
    //   261: invokevirtual 132	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   264: checkcast 134	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   267: invokestatic 140	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   270: invokestatic 145	asvo:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   273: invokestatic 151	com/tencent/mobileqq/minigame/gpkg/GpkgManager:preloadGpkgByConfig	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)V
    //   276: iload_3
    //   277: iconst_1
    //   278: iadd
    //   279: istore_3
    //   280: goto -37 -> 243
    //   283: astore_2
    //   284: ldc 65
    //   286: iconst_1
    //   287: ldc 153
    //   289: aload_2
    //   290: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: return
    //   294: astore_2
    //   295: aload_2
    //   296: invokevirtual 160	org/json/JSONException:printStackTrace	()V
    //   299: aload_0
    //   300: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   303: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   306: ifnull -274 -> 32
    //   309: aload_0
    //   310: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   313: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   316: iconst_0
    //   317: aconst_null
    //   318: invokeinterface 31 3 0
    //   323: return
    //   324: aload_0
    //   325: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   328: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   331: ifnull -299 -> 32
    //   334: aload_0
    //   335: getfield 12	astl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   338: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   341: iconst_0
    //   342: aload 4
    //   344: invokeinterface 31 3 0
    //   349: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	astl
    //   0	350	1	paramBoolean	boolean
    //   0	350	2	paramJSONObject	org.json.JSONObject
    //   59	221	3	i	int
    //   40	303	4	localJSONObject	org.json.JSONObject
    //   51	205	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   75	95	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   207	241	283	java/lang/Throwable
    //   243	276	283	java/lang/Throwable
    //   42	165	294	org/json/JSONException
    //   169	202	294	org/json/JSONException
    //   207	241	294	org/json/JSONException
    //   243	276	294	org/json/JSONException
    //   284	293	294	org/json/JSONException
    //   324	349	294	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astl
 * JD-Core Version:    0.7.0.1
 */