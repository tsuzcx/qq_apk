import android.os.Handler.Callback;

class iks
  implements Handler.Callback
{
  iks(ikr paramikr) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 28
    //   8: iconst_2
    //   9: new 30	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   16: ldc 33
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: getfield 43	android/os/Message:what	I
    //   25: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: getfield 43	android/os/Message:what	I
    //   38: tableswitch	default:+18 -> 56, 1:+20->58
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 12	iks:this$0	Likr;
    //   62: bipush 36
    //   64: lconst_1
    //   65: invokevirtual 60	ikr:r	(IJ)V
    //   68: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   71: invokestatic 72	ivv:isAppOnForeground	(Landroid/content/Context;)Z
    //   74: istore 5
    //   76: aload_0
    //   77: getfield 12	iks:this$0	Likr;
    //   80: astore 9
    //   82: iload 5
    //   84: ifeq +271 -> 355
    //   87: lconst_1
    //   88: lstore 7
    //   90: aload 9
    //   92: bipush 23
    //   94: lload 7
    //   96: invokevirtual 60	ikr:r	(IJ)V
    //   99: iconst_1
    //   100: istore 4
    //   102: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   105: invokestatic 78	accy:ay	(Landroid/content/Context;)Ljava/lang/String;
    //   108: astore 9
    //   110: iload 4
    //   112: istore_3
    //   113: aload 9
    //   115: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +22 -> 140
    //   121: aload 9
    //   123: ldc 86
    //   125: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: istore 6
    //   130: iload 4
    //   132: istore_3
    //   133: iload 6
    //   135: ifeq +5 -> 140
    //   138: iconst_0
    //   139: istore_3
    //   140: aload_0
    //   141: getfield 12	iks:this$0	Likr;
    //   144: astore_1
    //   145: iload_3
    //   146: ifeq +255 -> 401
    //   149: lconst_1
    //   150: lstore 7
    //   152: aload_1
    //   153: bipush 28
    //   155: lload 7
    //   157: invokevirtual 60	ikr:r	(IJ)V
    //   160: aload_0
    //   161: getfield 12	iks:this$0	Likr;
    //   164: getfield 95	ikr:aoh	I
    //   167: istore_2
    //   168: aload_0
    //   169: getfield 12	iks:this$0	Likr;
    //   172: bipush 37
    //   174: iload_2
    //   175: i2l
    //   176: invokevirtual 60	ikr:r	(IJ)V
    //   179: aload_0
    //   180: getfield 12	iks:this$0	Likr;
    //   183: invokestatic 99	ikr:a	(Likr;)Lcom/tencent/av/app/VideoAppInterface;
    //   186: invokevirtual 105	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   189: ifnull +23 -> 212
    //   192: aload_0
    //   193: getfield 12	iks:this$0	Likr;
    //   196: invokestatic 107	ikr:b	(Likr;)Lcom/tencent/av/app/VideoAppInterface;
    //   199: invokevirtual 105	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   202: ldc 109
    //   204: iload_2
    //   205: invokestatic 113	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   208: invokevirtual 118	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   211: pop
    //   212: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   215: invokestatic 121	com/tencent/av/VideoController:isScreenOn	(Landroid/content/Context;)Z
    //   218: istore 4
    //   220: aload_0
    //   221: getfield 12	iks:this$0	Likr;
    //   224: astore_1
    //   225: iload 4
    //   227: ifeq +180 -> 407
    //   230: lconst_1
    //   231: lstore 7
    //   233: aload_1
    //   234: bipush 39
    //   236: lload 7
    //   238: invokevirtual 60	ikr:r	(IJ)V
    //   241: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   244: invokestatic 124	ivv:ad	(Landroid/content/Context;)Z
    //   247: istore 4
    //   249: aload_0
    //   250: getfield 12	iks:this$0	Likr;
    //   253: astore_1
    //   254: iload 4
    //   256: ifeq +157 -> 413
    //   259: lconst_1
    //   260: lstore 7
    //   262: aload_1
    //   263: bipush 40
    //   265: lload 7
    //   267: invokevirtual 60	ikr:r	(IJ)V
    //   270: aload_0
    //   271: getfield 12	iks:this$0	Likr;
    //   274: invokevirtual 127	ikr:anB	()V
    //   277: invokestatic 132	jgu:a	()Ljgu;
    //   280: getfield 135	jgu:azk	I
    //   283: istore_2
    //   284: ldc 28
    //   286: iconst_1
    //   287: new 30	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   294: ldc 137
    //   296: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 9
    //   301: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 139
    //   306: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload 5
    //   311: invokevirtual 142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   314: ldc 144
    //   316: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload_3
    //   320: invokevirtual 142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   323: ldc 146
    //   325: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload_2
    //   329: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 12	iks:this$0	Likr;
    //   342: getfield 150	ikr:handler	Landroid/os/Handler;
    //   345: iconst_1
    //   346: iload_2
    //   347: i2l
    //   348: invokevirtual 156	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   351: pop
    //   352: goto -296 -> 56
    //   355: lconst_0
    //   356: lstore 7
    //   358: goto -268 -> 90
    //   361: astore 10
    //   363: aconst_null
    //   364: astore 9
    //   366: ldc 28
    //   368: iconst_1
    //   369: new 30	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   376: ldc 158
    //   378: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: getfield 43	android/os/Message:what	I
    //   385: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: aload 10
    //   393: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   396: iconst_0
    //   397: istore_3
    //   398: goto -258 -> 140
    //   401: lconst_0
    //   402: lstore 7
    //   404: goto -252 -> 152
    //   407: lconst_0
    //   408: lstore 7
    //   410: goto -177 -> 233
    //   413: lconst_0
    //   414: lstore 7
    //   416: goto -154 -> 262
    //   419: astore 10
    //   421: goto -55 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	iks
    //   0	424	1	paramMessage	android.os.Message
    //   167	180	2	i	int
    //   112	286	3	bool1	boolean
    //   100	155	4	bool2	boolean
    //   74	236	5	bool3	boolean
    //   128	6	6	bool4	boolean
    //   88	327	7	l	long
    //   80	285	9	localObject	Object
    //   361	31	10	localException1	java.lang.Exception
    //   419	1	10	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   102	110	361	java/lang/Exception
    //   113	130	419	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iks
 * JD-Core Version:    0.7.0.1
 */