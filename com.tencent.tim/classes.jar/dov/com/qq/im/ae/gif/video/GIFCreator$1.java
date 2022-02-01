package dov.com.qq.im.ae.gif.video;

import axfn;
import axfn.a;

public class GIFCreator$1
  implements Runnable
{
  public GIFCreator$1(axfn paramaxfn, axfn.a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   3: iconst_4
    //   4: ldc 31
    //   6: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   13: invokestatic 41	axfn:a	(Laxfn;)Ldov/com/qq/im/video/GifEncoder;
    //   16: sipush 320
    //   19: sipush 320
    //   22: aload_0
    //   23: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   26: invokestatic 44	axfn:a	(Laxfn;)Ljava/lang/String;
    //   29: invokevirtual 50	dov/com/qq/im/video/GifEncoder:U	(IILjava/lang/String;)V
    //   32: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   35: lstore_3
    //   36: aload_0
    //   37: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   40: invokestatic 59	axfn:a	(Laxfn;)Ljava/util/List;
    //   43: invokeinterface 65 1 0
    //   48: astore 5
    //   50: aload 5
    //   52: invokeinterface 71 1 0
    //   57: ifeq +402 -> 459
    //   60: aload 5
    //   62: invokeinterface 75 1 0
    //   67: checkcast 77	java/lang/String
    //   70: astore 6
    //   72: aload 6
    //   74: sipush 320
    //   77: sipush 320
    //   80: iconst_0
    //   81: invokestatic 82	awtg:d	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull +121 -> 209
    //   91: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   94: iconst_4
    //   95: ldc 84
    //   97: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   104: invokestatic 41	axfn:a	(Laxfn;)Ldov/com/qq/im/video/GifEncoder;
    //   107: aload 7
    //   109: bipush 55
    //   111: invokevirtual 87	dov/com/qq/im/video/GifEncoder:a	(Landroid/graphics/Bitmap;I)Z
    //   114: pop
    //   115: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   118: iconst_4
    //   119: ldc 89
    //   121: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload 7
    //   126: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   129: goto -79 -> 50
    //   132: astore 5
    //   134: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   137: iconst_4
    //   138: new 96	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   145: ldc 99
    //   147: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   154: invokestatic 44	axfn:a	(Laxfn;)Ljava/lang/String;
    //   157: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 105
    //   162: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 108	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   170: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:b	Laxfn$a;
    //   183: ifnull +12 -> 195
    //   186: aload_0
    //   187: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:b	Laxfn$a;
    //   190: invokeinterface 116 1 0
    //   195: aload_0
    //   196: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   199: invokestatic 119	axfn:a	(Laxfn;)Landroid/os/Handler;
    //   202: invokevirtual 125	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   205: invokevirtual 130	android/os/Looper:quit	()V
    //   208: return
    //   209: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   212: iconst_4
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc 132
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload 6
    //   226: aastore
    //   227: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: iconst_0
    //   231: istore_1
    //   232: aload_0
    //   233: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   236: invokestatic 41	axfn:a	(Laxfn;)Ldov/com/qq/im/video/GifEncoder;
    //   239: invokevirtual 138	dov/com/qq/im/video/GifEncoder:close	()V
    //   242: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   245: iconst_4
    //   246: new 96	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   253: ldc 140
    //   255: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   261: lload_3
    //   262: lsub
    //   263: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   276: invokestatic 145	axfn:b	(Laxfn;)Ljava/lang/String;
    //   279: invokestatic 151	ahbj:deleteFile	(Ljava/lang/String;)Z
    //   282: pop
    //   283: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   286: lstore_3
    //   287: aload_0
    //   288: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   291: invokestatic 44	axfn:a	(Laxfn;)Ljava/lang/String;
    //   294: aload_0
    //   295: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   298: invokestatic 145	axfn:b	(Laxfn;)Ljava/lang/String;
    //   301: bipush 30
    //   303: invokestatic 157	com/tencent/common/GifUtil:compressGif	(Ljava/lang/String;Ljava/lang/String;I)I
    //   306: istore_2
    //   307: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   310: iconst_4
    //   311: new 96	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   318: ldc 159
    //   320: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   326: lload_3
    //   327: lsub
    //   328: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   340: iconst_4
    //   341: new 96	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   348: ldc 161
    //   350: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: iload_2
    //   364: ifgt +5 -> 369
    //   367: iconst_0
    //   368: istore_1
    //   369: aload_0
    //   370: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   373: invokestatic 44	axfn:a	(Laxfn;)Ljava/lang/String;
    //   376: invokestatic 151	ahbj:deleteFile	(Ljava/lang/String;)Z
    //   379: pop
    //   380: invokestatic 29	axfn:access$000	()Ljava/lang/String;
    //   383: iconst_4
    //   384: iconst_2
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: ldc 166
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload_0
    //   396: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   399: invokestatic 145	axfn:b	(Laxfn;)Ljava/lang/String;
    //   402: aastore
    //   403: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   406: aload_0
    //   407: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:b	Laxfn$a;
    //   410: ifnull +23 -> 433
    //   413: iload_1
    //   414: ifeq +33 -> 447
    //   417: aload_0
    //   418: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:b	Laxfn$a;
    //   421: aload_0
    //   422: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   425: invokestatic 145	axfn:b	(Laxfn;)Ljava/lang/String;
    //   428: invokeinterface 170 2 0
    //   433: aload_0
    //   434: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Laxfn;
    //   437: invokestatic 119	axfn:a	(Laxfn;)Landroid/os/Handler;
    //   440: invokevirtual 125	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   443: invokevirtual 130	android/os/Looper:quit	()V
    //   446: return
    //   447: aload_0
    //   448: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:b	Laxfn$a;
    //   451: invokeinterface 116 1 0
    //   456: goto -23 -> 433
    //   459: iconst_1
    //   460: istore_1
    //   461: goto -229 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	1
    //   231	230	1	i	int
    //   306	58	2	j	int
    //   35	292	3	l	long
    //   48	13	5	localIterator	java.util.Iterator
    //   132	34	5	localFileNotFoundException	java.io.FileNotFoundException
    //   70	155	6	str	java.lang.String
    //   84	41	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	32	132	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.GIFCreator.1
 * JD-Core Version:    0.7.0.1
 */