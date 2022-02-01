package com.tencent.qqmini.sdk.launcher;

class AppRuntimeLoaderManager$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppRuntimeLoaderManager$1(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  /* Error */
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 24	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter$MiniAppStateMessage:appRuntimeLoader	Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: ldc 26
    //   14: new 28	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   21: ldc 31
    //   23: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   40: aload_1
    //   41: invokestatic 54	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$000	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;Lcom/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter$MiniAppStateMessage;)V
    //   44: aload_0
    //   45: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   48: astore_2
    //   49: aload_2
    //   50: monitorenter
    //   51: aload_1
    //   52: getfield 24	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter$MiniAppStateMessage:appRuntimeLoader	Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   55: aload_0
    //   56: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   59: invokestatic 58	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   62: if_acmpne +62 -> 124
    //   65: aload_0
    //   66: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   69: invokestatic 58	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   72: invokevirtual 64	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:getStatus	()I
    //   75: iconst_4
    //   76: if_icmpeq +17 -> 93
    //   79: aload_0
    //   80: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   83: invokestatic 58	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   86: invokevirtual 64	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:getStatus	()I
    //   89: iconst_5
    //   90: if_icmpne +26 -> 116
    //   93: aload_0
    //   94: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   97: aconst_null
    //   98: invokestatic 68	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$102	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   101: pop
    //   102: aload_0
    //   103: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   106: aload_0
    //   107: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   110: invokestatic 72	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$200	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Landroid/os/Bundle;
    //   113: invokevirtual 76	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:preloadRuntime	(Landroid/os/Bundle;)V
    //   116: aload_2
    //   117: monitorexit
    //   118: return
    //   119: astore_1
    //   120: aload_2
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: aload_1
    //   125: getfield 24	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter$MiniAppStateMessage:appRuntimeLoader	Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   128: aload_0
    //   129: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   132: invokestatic 79	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$300	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   135: if_acmpne -19 -> 116
    //   138: aload_0
    //   139: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   142: invokestatic 79	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$300	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   145: invokevirtual 64	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:getStatus	()I
    //   148: iconst_5
    //   149: if_icmpeq +11 -> 160
    //   152: aload_1
    //   153: getfield 83	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter$MiniAppStateMessage:what	I
    //   156: iconst_4
    //   157: if_icmpne -41 -> 116
    //   160: aload_0
    //   161: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   164: aconst_null
    //   165: invokestatic 86	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$302	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;)Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;
    //   168: pop
    //   169: aload_0
    //   170: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   173: aload_0
    //   174: getfield 10	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;
    //   177: invokestatic 72	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:access$200	(Lcom/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager;)Landroid/os/Bundle;
    //   180: invokevirtual 76	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:preloadRuntime	(Landroid/os/Bundle;)V
    //   183: goto -67 -> 116
    //   186: astore_1
    //   187: ldc 26
    //   189: ldc 88
    //   191: aload_1
    //   192: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -79 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	1
    //   0	198	1	paramMiniAppStateMessage	AppRuntimeEventCenter.MiniAppStateMessage
    // Exception table:
    //   from	to	target	type
    //   51	93	119	finally
    //   93	116	119	finally
    //   116	118	119	finally
    //   120	122	119	finally
    //   124	160	119	finally
    //   160	183	119	finally
    //   187	195	119	finally
    //   51	93	186	java/lang/Throwable
    //   93	116	186	java/lang/Throwable
    //   124	160	186	java/lang/Throwable
    //   160	183	186	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */