package com.tencent.mobileqq.activity.qwallet;

public final class TopayManager$1
  implements Runnable
{
  public TopayManager$1(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 28
    //   2: astore_1
    //   3: invokestatic 34	aagd:getQQAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +8 -> 16
    //   11: aload_2
    //   12: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   15: astore_1
    //   16: new 42	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   23: getstatic 49	aagi:bcU	Ljava/lang/String;
    //   26: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 15	com/tencent/mobileqq/activity/qwallet/TopayManager$1:val$businessType	I
    //   43: iconst_1
    //   44: if_icmpne +61 -> 105
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 17	com/tencent/mobileqq/activity/qwallet/TopayManager$1:cfJ	I
    //   53: ifle +52 -> 105
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 17	com/tencent/mobileqq/activity/qwallet/TopayManager$1:cfJ	I
    //   62: iconst_3
    //   63: if_icmpge +42 -> 105
    //   66: new 42	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   73: aload_2
    //   74: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 58
    //   79: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 15	com/tencent/mobileqq/activity/qwallet/TopayManager$1:val$businessType	I
    //   86: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: ldc 58
    //   91: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 17	com/tencent/mobileqq/activity/qwallet/TopayManager$1:cfJ	I
    //   98: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: new 63	java/io/File
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 70	java/io/File:exists	()Z
    //   116: ifeq +81 -> 197
    //   119: aload_1
    //   120: invokestatic 76	aqhq:readFile	(Ljava/lang/String;)[B
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +72 -> 197
    //   128: aload_1
    //   129: arraylength
    //   130: ifle +67 -> 197
    //   133: new 78	com/qq/taf/jce/JceInputStream
    //   136: dup
    //   137: aload_1
    //   138: invokespecial 81	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   141: astore_2
    //   142: aload_2
    //   143: ldc 83
    //   145: invokevirtual 87	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   148: pop
    //   149: new 89	Wallet/PfaFriendRsp
    //   152: dup
    //   153: invokespecial 90	Wallet/PfaFriendRsp:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: aload_2
    //   159: invokevirtual 94	Wallet/PfaFriendRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   162: iconst_0
    //   163: putstatic 99	zzn:cfI	I
    //   166: getstatic 103	zzn:mHandler	Landroid/os/Handler;
    //   169: new 105	com/tencent/mobileqq/activity/qwallet/TopayManager$1$1
    //   172: dup
    //   173: aload_0
    //   174: aload_1
    //   175: invokespecial 108	com/tencent/mobileqq/activity/qwallet/TopayManager$1$1:<init>	(Lcom/tencent/mobileqq/activity/qwallet/TopayManager$1;LWallet/PfaFriendRsp;)V
    //   178: invokevirtual 114	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   181: pop
    //   182: return
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_2
    //   187: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   190: goto -28 -> 162
    //   193: astore_2
    //   194: goto -8 -> 186
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -37 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	1
    //   2	197	1	localObject1	Object
    //   6	153	2	localObject2	Object
    //   183	4	2	localException1	java.lang.Exception
    //   193	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	16	183	java/lang/Exception
    //   16	37	183	java/lang/Exception
    //   39	47	183	java/lang/Exception
    //   49	56	183	java/lang/Exception
    //   58	105	183	java/lang/Exception
    //   105	124	183	java/lang/Exception
    //   128	157	183	java/lang/Exception
    //   157	162	193	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.1
 * JD-Core Version:    0.7.0.1
 */