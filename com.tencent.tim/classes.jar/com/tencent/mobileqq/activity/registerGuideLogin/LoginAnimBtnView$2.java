package com.tencent.mobileqq.activity.registerGuideLogin;

public class LoginAnimBtnView$2
  implements Runnable
{
  LoginAnimBtnView$2(LoginAnimBtnView paramLoginAnimBtnView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   4: invokestatic 25	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;)Z
    //   7: ifeq +12 -> 19
    //   10: ldc 27
    //   12: iconst_1
    //   13: ldc 29
    //   15: invokestatic 35	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: new 37	com/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter
    //   22: dup
    //   23: new 39	aamr
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 42	aamr:<init>	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2;)V
    //   31: invokespecial 45	com/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter:<init>	(Lcom/tencent/mobileqq/dinifly/OnCompositionLoadedListener;)V
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   39: invokevirtual 49	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:getContext	()Landroid/content/Context;
    //   42: ldc 51
    //   44: invokestatic 57	com/tencent/mobileqq/dinifly/LottieCompositionFactory:fromAsset	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/dinifly/LottieTask;
    //   47: astore_3
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 63	com/tencent/mobileqq/dinifly/LottieTask:addListener	(Lcom/tencent/mobileqq/dinifly/LottieListener;)Lcom/tencent/mobileqq/dinifly/LottieTask;
    //   53: pop
    //   54: aload_0
    //   55: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   58: invokestatic 66	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;)Ljava/lang/Object;
    //   61: astore_1
    //   62: aload_1
    //   63: monitorenter
    //   64: aload_0
    //   65: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   68: aload_3
    //   69: invokestatic 69	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;Lcom/tencent/mobileqq/dinifly/LottieTask;)Lcom/tencent/mobileqq/dinifly/LottieTask;
    //   72: pop
    //   73: aload_0
    //   74: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   77: aload_2
    //   78: invokestatic 72	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;Lcom/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter;)Lcom/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter;
    //   81: pop
    //   82: aload_1
    //   83: monitorexit
    //   84: return
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   95: aconst_null
    //   96: invokestatic 75	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;Lcom/tencent/mobileqq/dinifly/LottieDrawable;)Lcom/tencent/mobileqq/dinifly/LottieDrawable;
    //   99: pop
    //   100: aload_0
    //   101: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   104: invokestatic 66	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;)Ljava/lang/Object;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   114: aconst_null
    //   115: invokestatic 69	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;Lcom/tencent/mobileqq/dinifly/LottieTask;)Lcom/tencent/mobileqq/dinifly/LottieTask;
    //   118: pop
    //   119: aload_0
    //   120: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView$2:this$0	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;
    //   123: aconst_null
    //   124: invokestatic 72	com/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginAnimBtnView;Lcom/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter;)Lcom/tencent/mobileqq/dinifly/LottieComposition$Factory$ListenerAdapter;
    //   127: pop
    //   128: aload_1
    //   129: monitorexit
    //   130: ldc 27
    //   132: iconst_1
    //   133: ldc 77
    //   135: aload_2
    //   136: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: return
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	2
    //   34	44	2	localListenerAdapter	com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter
    //   85	4	2	localObject2	Object
    //   90	46	2	localThrowable	java.lang.Throwable
    //   140	4	2	localObject3	Object
    //   47	22	3	localLottieTask	com.tencent.mobileqq.dinifly.LottieTask
    // Exception table:
    //   from	to	target	type
    //   64	84	85	finally
    //   86	88	85	finally
    //   19	64	90	java/lang/Throwable
    //   88	90	90	java/lang/Throwable
    //   110	130	140	finally
    //   141	143	140	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.2
 * JD-Core Version:    0.7.0.1
 */