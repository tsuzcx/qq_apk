package com.tencent.mobileqq.vaswebviewplugin;

public class QQAioBackgroundPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "background";
  
  public QQAioBackgroundPlugin()
  {
    super("background");
  }
  
  /* Error */
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|chatUin", method="getCurBackground")
  public void getCurBackground(String paramString, java.lang.Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 26	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 28	org/json/JSONObject:<init>	()V
    //   9: astore 4
    //   11: new 26	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 28	org/json/JSONObject:<init>	()V
    //   18: astore 5
    //   20: aload 4
    //   22: ldc 30
    //   24: aload 5
    //   26: invokevirtual 34	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: getfield 38	com/tencent/mobileqq/vaswebviewplugin/QQAioBackgroundPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   34: invokevirtual 44	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   37: aload_0
    //   38: getfield 38	com/tencent/mobileqq/vaswebviewplugin/QQAioBackgroundPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   41: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   44: invokevirtual 54	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   47: aload_2
    //   48: invokestatic 60	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokestatic 66	com/tencent/mobileqq/model/ChatBackgroundManager:g	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 7
    //   56: ldc 68
    //   58: aload 7
    //   60: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +48 -> 111
    //   66: aload 4
    //   68: ldc 74
    //   70: iconst_0
    //   71: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 5
    //   77: ldc 79
    //   79: iconst_0
    //   80: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 5
    //   86: ldc 81
    //   88: iconst_0
    //   89: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   92: pop
    //   93: aload_0
    //   94: aload_1
    //   95: iconst_1
    //   96: anewarray 56	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload 4
    //   103: invokevirtual 84	org/json/JSONObject:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: invokespecial 88	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   110: return
    //   111: aload 7
    //   113: invokestatic 92	com/tencent/mobileqq/model/ChatBackgroundManager:lS	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 6
    //   118: aload_3
    //   119: astore_2
    //   120: new 94	java/io/File
    //   123: dup
    //   124: aload 7
    //   126: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: invokevirtual 99	java/io/File:exists	()Z
    //   132: ifeq +26 -> 158
    //   135: new 101	android/graphics/BitmapFactory$Options
    //   138: dup
    //   139: invokespecial 102	android/graphics/BitmapFactory$Options:<init>	()V
    //   142: aload 7
    //   144: sipush 200
    //   147: invokestatic 107	aqhu:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   150: astore_2
    //   151: aload 7
    //   153: aload_2
    //   154: invokestatic 113	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnonnull +28 -> 187
    //   162: aload 4
    //   164: ldc 74
    //   166: sipush 1002
    //   169: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   172: pop
    //   173: goto -80 -> 93
    //   176: astore_2
    //   177: aload_0
    //   178: aload_1
    //   179: aload_2
    //   180: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokespecial 120	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: return
    //   187: new 122	java/io/ByteArrayOutputStream
    //   190: dup
    //   191: invokespecial 123	java/io/ByteArrayOutputStream:<init>	()V
    //   194: astore_3
    //   195: aload_2
    //   196: getstatic 129	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 100
    //   201: aload_3
    //   202: invokevirtual 135	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   205: pop
    //   206: aload_3
    //   207: invokevirtual 139	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   210: iconst_2
    //   211: invokestatic 145	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   214: astore 7
    //   216: aload 4
    //   218: ldc 74
    //   220: iconst_0
    //   221: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 5
    //   227: ldc 147
    //   229: new 149	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   236: ldc 152
    //   238: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 7
    //   243: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 34	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 5
    //   255: ldc 79
    //   257: aload_2
    //   258: invokevirtual 161	android/graphics/Bitmap:getWidth	()I
    //   261: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload 5
    //   267: ldc 81
    //   269: aload 6
    //   271: invokevirtual 34	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   274: pop
    //   275: aload_3
    //   276: invokevirtual 164	java/io/ByteArrayOutputStream:close	()V
    //   279: goto -186 -> 93
    //   282: astore_2
    //   283: aload_3
    //   284: astore_2
    //   285: goto -127 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	QQAioBackgroundPlugin
    //   0	288	1	paramString	String
    //   0	288	2	paramObject	java.lang.Object
    //   1	283	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   9	208	4	localJSONObject1	org.json.JSONObject
    //   18	248	5	localJSONObject2	org.json.JSONObject
    //   116	154	6	str1	String
    //   54	188	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	93	176	java/lang/Exception
    //   93	110	176	java/lang/Exception
    //   111	118	176	java/lang/Exception
    //   120	151	176	java/lang/Exception
    //   151	158	176	java/lang/Exception
    //   162	173	176	java/lang/Exception
    //   187	279	176	java/lang/Exception
    //   151	158	282	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin
 * JD-Core Version:    0.7.0.1
 */