package com.tencent.mobileqq.jsp;

import java.util.concurrent.atomic.AtomicBoolean;

class MediaApiPlugin$3
  implements Runnable
{
  MediaApiPlugin$3(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 38	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 39	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: invokestatic 45	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$3:val$imagePath	Ljava/lang/String;
    //   16: invokestatic 51	aqhq:readFile	(Ljava/lang/String;)[B
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   24: aload_3
    //   25: invokevirtual 57	com/tencent/mobileqq/jsp/MediaApiPlugin:u	([B)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_1
    //   30: ldc 59
    //   32: iconst_0
    //   33: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   36: pop
    //   37: aload_1
    //   38: ldc 65
    //   40: aload_2
    //   41: ldc 66
    //   43: invokevirtual 72	android/content/Context:getString	(I)Ljava/lang/String;
    //   46: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_1
    //   51: ldc 77
    //   53: aload_3
    //   54: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_0
    //   59: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$3:bOi	Ljava/lang/String;
    //   62: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +129 -> 194
    //   68: aload_0
    //   69: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$3:dk	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   72: iconst_0
    //   73: iconst_1
    //   74: invokevirtual 89	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   77: ifeq +117 -> 194
    //   80: aload_0
    //   81: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   84: aload_0
    //   85: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$3:bOi	Ljava/lang/String;
    //   88: iconst_1
    //   89: anewarray 91	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 99	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   102: return
    //   103: astore_3
    //   104: aload_1
    //   105: ldc 59
    //   107: iconst_1
    //   108: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_1
    //   113: ldc 65
    //   115: aload_2
    //   116: ldc 100
    //   118: invokevirtual 72	android/content/Context:getString	(I)Ljava/lang/String;
    //   121: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: goto -67 -> 58
    //   128: astore_2
    //   129: goto -71 -> 58
    //   132: astore_3
    //   133: aload_1
    //   134: ldc 59
    //   136: iconst_2
    //   137: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload_1
    //   142: ldc 65
    //   144: aload_2
    //   145: ldc 101
    //   147: invokevirtual 72	android/content/Context:getString	(I)Ljava/lang/String;
    //   150: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: goto -96 -> 58
    //   157: astore_2
    //   158: goto -100 -> 58
    //   161: astore_2
    //   162: getstatic 104	com/tencent/mobileqq/jsp/MediaApiPlugin:TAG	Ljava/lang/String;
    //   165: iconst_2
    //   166: new 106	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   173: ldc 109
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_2
    //   179: invokestatic 119	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: goto -133 -> 58
    //   194: aload_0
    //   195: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   198: ldc 126
    //   200: iconst_0
    //   201: aload_1
    //   202: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
    //   205: invokevirtual 129	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: astore_2
    //   210: goto -152 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	3
    //   7	195	1	localJSONObject	org.json.JSONObject
    //   11	105	2	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   128	17	2	localJSONException1	org.json.JSONException
    //   157	1	2	localJSONException2	org.json.JSONException
    //   161	18	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   209	1	2	localJSONException3	org.json.JSONException
    //   19	35	3	localObject	Object
    //   103	1	3	localIOException	java.io.IOException
    //   132	1	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   12	29	103	java/io/IOException
    //   29	58	103	java/io/IOException
    //   104	125	128	org/json/JSONException
    //   12	29	132	java/lang/IllegalArgumentException
    //   29	58	132	java/lang/IllegalArgumentException
    //   133	154	157	org/json/JSONException
    //   12	29	161	java/lang/OutOfMemoryError
    //   29	58	161	java/lang/OutOfMemoryError
    //   29	58	209	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */