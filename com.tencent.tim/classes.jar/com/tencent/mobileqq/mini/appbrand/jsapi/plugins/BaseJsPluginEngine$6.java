package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;

class BaseJsPluginEngine$6
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$6(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: ifeq +102 -> 106
    //   7: aload_2
    //   8: ldc 35
    //   10: invokevirtual 41	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 43
    //   17: invokevirtual 47	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_3
    //   22: ldc 49
    //   24: invokevirtual 47	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 17	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine$6:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   33: getfield 55	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:uiHandler	Landroid/os/Handler;
    //   36: new 57	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine$6$1
    //   39: dup
    //   40: aload_0
    //   41: aload 4
    //   43: aload_2
    //   44: invokespecial 60	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine$6$1:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine$6;Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokevirtual 66	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   50: pop
    //   51: return
    //   52: astore 5
    //   54: aconst_null
    //   55: astore_3
    //   56: aload 6
    //   58: astore 4
    //   60: aload_3
    //   61: astore_2
    //   62: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq -36 -> 29
    //   68: ldc 74
    //   70: iconst_2
    //   71: new 76	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   78: ldc 79
    //   80: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 5
    //   85: invokestatic 89	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload 6
    //   99: astore 4
    //   101: aload_3
    //   102: astore_2
    //   103: goto -74 -> 29
    //   106: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +11 -> 120
    //   112: ldc 74
    //   114: iconst_2
    //   115: ldc 79
    //   117: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aconst_null
    //   121: astore_2
    //   122: aload 6
    //   124: astore 4
    //   126: goto -97 -> 29
    //   129: astore 5
    //   131: aload_2
    //   132: astore_3
    //   133: goto -77 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	6
    //   0	136	1	paramBoolean	boolean
    //   0	136	2	paramJSONObject	org.json.JSONObject
    //   13	120	3	localJSONObject	org.json.JSONObject
    //   27	98	4	localObject1	Object
    //   52	32	5	localThrowable1	java.lang.Throwable
    //   129	1	5	localThrowable2	java.lang.Throwable
    //   1	122	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	52	java/lang/Throwable
    //   21	29	129	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.6
 * JD-Core Version:    0.7.0.1
 */