package com.tencent.mobileqq.app;

import acgn;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

public class IndividualRedPacketManager$4
  implements Runnable
{
  public IndividualRedPacketManager$4(acgn paramacgn, String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 6
    //   7: getstatic 40	acgn:cwb	I
    //   10: istore_1
    //   11: aload_0
    //   12: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   15: invokevirtual 44	acgn:a	()Laqqf;
    //   18: aload_0
    //   19: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   22: iconst_1
    //   23: invokevirtual 49	aqqf:a	(Ljava/lang/String;Z)Laqqf$e;
    //   26: astore 4
    //   28: aload_0
    //   29: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   32: aload_0
    //   33: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   40: bipush 6
    //   42: invokevirtual 53	acgn:k	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   51: getfield 57	acgn:cC	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   54: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   57: ifeq +288 -> 345
    //   60: invokestatic 67	acgn:access$000	()Ljava/lang/String;
    //   63: iconst_2
    //   64: new 69	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   71: ldc 72
    //   73: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   80: getfield 57	acgn:cC	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   83: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   86: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   89: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: ldc 90
    //   97: astore 4
    //   99: aconst_null
    //   100: astore 5
    //   102: aload 5
    //   104: ifnull +40 -> 144
    //   107: new 92	java/io/ByteArrayOutputStream
    //   110: dup
    //   111: invokespecial 93	java/io/ByteArrayOutputStream:<init>	()V
    //   114: astore 4
    //   116: aload 5
    //   118: getstatic 99	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   121: bipush 100
    //   123: aload 4
    //   125: invokevirtual 105	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   128: pop
    //   129: aload 4
    //   131: invokevirtual 109	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   134: iconst_2
    //   135: invokestatic 115	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   138: astore 4
    //   140: getstatic 118	acgn:cwa	I
    //   143: istore_1
    //   144: new 120	android/os/Bundle
    //   147: dup
    //   148: invokespecial 121	android/os/Bundle:<init>	()V
    //   151: astore 7
    //   153: aload 7
    //   155: ldc 123
    //   157: aload_0
    //   158: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   161: invokevirtual 127	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 7
    //   166: ldc 129
    //   168: aload_0
    //   169: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   172: invokevirtual 127	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 7
    //   177: ldc 131
    //   179: iload_1
    //   180: invokevirtual 135	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   183: aload 7
    //   185: ldc 137
    //   187: aload 4
    //   189: invokevirtual 127	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 25	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$reqbundle	Landroid/os/Bundle;
    //   196: ldc 139
    //   198: aload 7
    //   200: invokevirtual 143	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   203: aload_0
    //   204: getfield 27	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$service	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   207: aload_0
    //   208: getfield 25	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$reqbundle	Landroid/os/Bundle;
    //   211: invokevirtual 149	com/tencent/mobileqq/emosm/web/MessengerService:cp	(Landroid/os/Bundle;)V
    //   214: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +42 -> 259
    //   220: invokestatic 67	acgn:access$000	()Ljava/lang/String;
    //   223: iconst_2
    //   224: new 69	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   231: ldc 154
    //   233: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload_1
    //   237: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc 159
    //   242: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 4
    //   247: invokevirtual 165	java/lang/String:length	()I
    //   250: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload 6
    //   261: ifnull +38 -> 299
    //   264: aload 6
    //   266: getfield 174	acgn$a:eK	Landroid/graphics/Bitmap;
    //   269: ifnull +30 -> 299
    //   272: aload 6
    //   274: getfield 178	acgn$a:bHS	Z
    //   277: ifne +22 -> 299
    //   280: aload_0
    //   281: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   284: aload 6
    //   286: getfield 174	acgn$a:eK	Landroid/graphics/Bitmap;
    //   289: ldc 90
    //   291: aload_0
    //   292: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   295: iconst_5
    //   296: invokevirtual 181	acgn:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   299: aload 6
    //   301: ifnull +43 -> 344
    //   304: aload 6
    //   306: getfield 174	acgn$a:eK	Landroid/graphics/Bitmap;
    //   309: ifnull +35 -> 344
    //   312: aload 5
    //   314: ifnull +30 -> 344
    //   317: aload 6
    //   319: getfield 184	acgn$a:bHT	Z
    //   322: ifeq +307 -> 629
    //   325: aload_0
    //   326: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   329: aload 5
    //   331: aload_0
    //   332: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   335: aload_0
    //   336: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   339: bipush 12
    //   341: invokevirtual 181	acgn:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   344: return
    //   345: aload 5
    //   347: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne +140 -> 490
    //   353: new 192	java/io/File
    //   356: dup
    //   357: aload 5
    //   359: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 4
    //   364: new 197	java/io/FileInputStream
    //   367: dup
    //   368: aload 4
    //   370: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   373: astore 5
    //   375: aload 4
    //   377: invokevirtual 203	java/io/File:length	()J
    //   380: l2i
    //   381: newarray byte
    //   383: astore 4
    //   385: iload_2
    //   386: aload 4
    //   388: arraylength
    //   389: if_icmpge +28 -> 417
    //   392: aload 5
    //   394: aload 4
    //   396: iload_2
    //   397: aload 4
    //   399: arraylength
    //   400: iload_2
    //   401: isub
    //   402: invokevirtual 207	java/io/FileInputStream:read	([BII)I
    //   405: istore_3
    //   406: iload_3
    //   407: iflt +10 -> 417
    //   410: iload_2
    //   411: iload_3
    //   412: iadd
    //   413: istore_2
    //   414: goto -29 -> 385
    //   417: aload 4
    //   419: iconst_2
    //   420: invokestatic 115	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   423: astore 4
    //   425: getstatic 118	acgn:cwa	I
    //   428: istore_2
    //   429: aload 5
    //   431: invokevirtual 210	java/io/FileInputStream:close	()V
    //   434: iload_2
    //   435: istore_1
    //   436: aconst_null
    //   437: astore 5
    //   439: goto -337 -> 102
    //   442: astore 5
    //   444: ldc 90
    //   446: astore 4
    //   448: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +33 -> 484
    //   454: invokestatic 67	acgn:access$000	()Ljava/lang/String;
    //   457: iconst_2
    //   458: new 69	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   465: ldc 212
    //   467: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload 5
    //   472: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   475: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: aconst_null
    //   485: astore 5
    //   487: goto -385 -> 102
    //   490: aload 4
    //   492: ifnull +126 -> 618
    //   495: new 192	java/io/File
    //   498: dup
    //   499: aload_0
    //   500: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   503: ldc 90
    //   505: iconst_2
    //   506: aload 4
    //   508: getfield 220	aqqf$e:version	I
    //   511: aload 4
    //   513: getfield 223	aqqf$e:type	I
    //   516: invokestatic 227	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   519: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   522: invokevirtual 230	java/io/File:exists	()Z
    //   525: ifeq +82 -> 607
    //   528: aload_0
    //   529: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   532: aload_0
    //   533: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   536: bipush 6
    //   538: invokevirtual 233	acgn:a	(Ljava/lang/String;I)Lacgn$a;
    //   541: astore 5
    //   543: aload_0
    //   544: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   547: aload 5
    //   549: aload_0
    //   550: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   553: aload_0
    //   554: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   557: bipush 6
    //   559: invokestatic 236	acgn:a	(Lacgn;Lacgn$a;Ljava/lang/String;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   562: astore 4
    //   564: iload_3
    //   565: istore_2
    //   566: iload_2
    //   567: ifeq +21 -> 588
    //   570: aload_0
    //   571: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   574: invokevirtual 44	acgn:a	()Laqqf;
    //   577: ldc2_w 237
    //   580: aload_0
    //   581: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   584: aconst_null
    //   585: invokevirtual 242	aqqf:v	(JLjava/lang/String;Ljava/lang/String;)V
    //   588: aload 4
    //   590: astore 7
    //   592: ldc 90
    //   594: astore 4
    //   596: aload 5
    //   598: astore 6
    //   600: aload 7
    //   602: astore 5
    //   604: goto -502 -> 102
    //   607: iconst_1
    //   608: istore_2
    //   609: aconst_null
    //   610: astore 4
    //   612: aconst_null
    //   613: astore 5
    //   615: goto -49 -> 566
    //   618: iconst_1
    //   619: istore_2
    //   620: aconst_null
    //   621: astore 5
    //   623: aconst_null
    //   624: astore 4
    //   626: goto -60 -> 566
    //   629: aload_0
    //   630: getfield 19	com/tencent/mobileqq/app/IndividualRedPacketManager$4:this$0	Lacgn;
    //   633: aload 5
    //   635: aload_0
    //   636: getfield 21	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$templateId	Ljava/lang/String;
    //   639: aload_0
    //   640: getfield 23	com/tencent/mobileqq/app/IndividualRedPacketManager$4:val$content	Ljava/lang/String;
    //   643: bipush 6
    //   645: invokevirtual 181	acgn:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   648: return
    //   649: astore 5
    //   651: goto -203 -> 448
    //   654: astore 5
    //   656: iload_2
    //   657: istore_1
    //   658: goto -210 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	4
    //   10	648	1	i	int
    //   3	654	2	j	int
    //   1	564	3	k	int
    //   26	599	4	localObject1	Object
    //   45	393	5	localObject2	Object
    //   442	29	5	localIOException1	java.io.IOException
    //   485	149	5	localObject3	Object
    //   649	1	5	localIOException2	java.io.IOException
    //   654	1	5	localIOException3	java.io.IOException
    //   5	594	6	localObject4	Object
    //   151	450	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   353	385	442	java/io/IOException
    //   385	406	442	java/io/IOException
    //   417	425	442	java/io/IOException
    //   425	429	649	java/io/IOException
    //   429	434	654	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.4
 * JD-Core Version:    0.7.0.1
 */