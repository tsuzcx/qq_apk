import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class rqu
{
  public static boolean R(List<SlideItemInfo> paramList)
  {
    return true;
  }
  
  public static boolean S(List<SlideItemInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if ((localSlideItemInfo.mediaType == 1) && (localSlideItemInfo.hasAudioTrack) && (!b(localSlideItemInfo))) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(int paramInt1, int paramInt2, rqu.a parama1, rqu.a parama2)
  {
    if (!c(paramInt1, paramInt2, parama1, parama2)) {
      return b(paramInt1, paramInt2, parama1, parama2);
    }
    return true;
  }
  
  /* Error */
  private static boolean b(int paramInt1, int paramInt2, rqu.a parama1, rqu.a parama2)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 54	rqu$a:size	I
    //   4: aload_2
    //   5: getfield 57	rqu$a:offset	I
    //   8: isub
    //   9: istore 4
    //   11: new 59	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_2
    //   16: getfield 63	rqu$a:data	[B
    //   19: aload_2
    //   20: getfield 57	rqu$a:offset	I
    //   23: aload_2
    //   24: getfield 54	rqu$a:size	I
    //   27: invokespecial 67	java/io/ByteArrayInputStream:<init>	([BII)V
    //   30: astore 9
    //   32: new 69	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 72	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore_2
    //   40: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   43: lstore 5
    //   45: new 80	rqz
    //   48: dup
    //   49: aload 9
    //   51: aload_2
    //   52: iload_0
    //   53: iload_1
    //   54: iconst_2
    //   55: iconst_2
    //   56: iconst_1
    //   57: iload 4
    //   59: dconst_0
    //   60: iconst_0
    //   61: iconst_1
    //   62: invokespecial 83	rqz:<init>	(Ljava/io/InputStream;Ljava/io/OutputStream;IIIIIIDIZ)V
    //   65: pop
    //   66: iload 4
    //   68: i2f
    //   69: fconst_1
    //   70: fmul
    //   71: iload_0
    //   72: i2f
    //   73: fdiv
    //   74: iload_1
    //   75: i2f
    //   76: fmul
    //   77: f2i
    //   78: istore_0
    //   79: aload_3
    //   80: iconst_0
    //   81: putfield 57	rqu$a:offset	I
    //   84: aload_3
    //   85: aload_2
    //   86: invokevirtual 87	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: putfield 63	rqu$a:data	[B
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 90	java/io/ByteArrayOutputStream:size	()I
    //   97: putfield 54	rqu$a:size	I
    //   100: aload_3
    //   101: getfield 63	rqu$a:data	[B
    //   104: arraylength
    //   105: aload_3
    //   106: getfield 54	rqu$a:size	I
    //   109: if_icmpeq +29 -> 138
    //   112: new 92	java/lang/RuntimeException
    //   115: dup
    //   116: ldc 94
    //   118: invokespecial 97	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   127: aload 9
    //   129: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   132: aload_2
    //   133: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   141: lstore 7
    //   143: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +63 -> 209
    //   149: ldc 111
    //   151: iconst_2
    //   152: new 113	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   159: ldc 116
    //   161: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload_0
    //   165: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc 125
    //   170: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_3
    //   174: getfield 54	rqu$a:size	I
    //   177: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 127
    //   182: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: lload 7
    //   187: lload 5
    //   189: lsub
    //   190: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc 132
    //   195: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload 4
    //   200: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload 9
    //   211: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   214: aload_2
    //   215: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   218: iconst_1
    //   219: ireturn
    //   220: astore_2
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_3
    //   224: aload 9
    //   226: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   229: aload_2
    //   230: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   233: aload_3
    //   234: athrow
    //   235: astore_3
    //   236: goto -22 -> 214
    //   239: astore_3
    //   240: goto -108 -> 132
    //   243: astore_2
    //   244: goto -108 -> 136
    //   247: astore 9
    //   249: goto -20 -> 229
    //   252: astore_2
    //   253: goto -20 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramInt1	int
    //   0	256	1	paramInt2	int
    //   0	256	2	parama1	rqu.a
    //   0	256	3	parama2	rqu.a
    //   9	190	4	i	int
    //   43	145	5	l1	long
    //   141	45	7	l2	long
    //   30	195	9	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   247	1	9	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	122	122	java/io/IOException
    //   138	209	122	java/io/IOException
    //   214	218	220	java/io/IOException
    //   40	122	223	finally
    //   123	127	223	finally
    //   138	209	223	finally
    //   209	214	235	java/io/IOException
    //   127	132	239	java/io/IOException
    //   132	136	243	java/io/IOException
    //   224	229	247	java/io/IOException
    //   229	233	252	java/io/IOException
  }
  
  /* Error */
  private static boolean b(SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifgt +18 -> 24
    //   9: aload_0
    //   10: getfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +9 -> 24
    //   18: iconst_1
    //   19: istore 13
    //   21: iload 13
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   28: aload_0
    //   29: getfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   32: lcmp
    //   33: ifge +5 -> 38
    //   36: iconst_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   42: aload_0
    //   43: getfield 152	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mDuration	J
    //   46: lcmp
    //   47: ifle +11 -> 58
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 152	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mDuration	J
    //   55: putfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   58: aload_0
    //   59: getfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifgt +8 -> 72
    //   67: aload_0
    //   68: lconst_0
    //   69: putfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   72: aload_0
    //   73: getfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   76: lconst_0
    //   77: lcmp
    //   78: ifne +26 -> 104
    //   81: aload_0
    //   82: getfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   85: aload_0
    //   86: getfield 152	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mDuration	J
    //   89: lcmp
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   97: ldc 156
    //   99: if_icmpne +5 -> 104
    //   102: iconst_1
    //   103: ireturn
    //   104: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +43 -> 150
    //   110: ldc 111
    //   112: iconst_2
    //   113: new 113	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   120: ldc 158
    //   122: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   129: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 160
    //   134: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 39	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:hasAudioTrack	Z
    //   141: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 39	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:hasAudioTrack	Z
    //   154: ifne +9 -> 163
    //   157: aload_0
    //   158: ldc 156
    //   160: putfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   163: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +43 -> 209
    //   169: ldc 111
    //   171: iconst_2
    //   172: new 113	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   179: ldc 165
    //   181: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   188: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc 160
    //   193: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 39	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:hasAudioTrack	Z
    //   200: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   203: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 146	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   213: l2f
    //   214: fconst_1
    //   215: fmul
    //   216: aload_0
    //   217: getfield 152	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mDuration	J
    //   220: l2f
    //   221: fdiv
    //   222: fstore_2
    //   223: aload_0
    //   224: getfield 149	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   227: l2f
    //   228: fconst_1
    //   229: fmul
    //   230: aload_0
    //   231: getfield 152	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mDuration	J
    //   234: l2f
    //   235: fdiv
    //   236: fstore_1
    //   237: new 113	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 169	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:aBp	Ljava/lang/String;
    //   248: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 171
    //   253: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 18
    //   261: aload 18
    //   263: invokestatic 177	ahbj:isFileExists	(Ljava/lang/String;)Z
    //   266: ifeq +9 -> 275
    //   269: aload 18
    //   271: invokestatic 180	ahbj:deleteFile	(Ljava/lang/String;)Z
    //   274: pop
    //   275: new 182	java/io/File
    //   278: dup
    //   279: aload_0
    //   280: getfield 169	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:aBp	Ljava/lang/String;
    //   283: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore 14
    //   288: aload 14
    //   290: invokevirtual 186	java/io/File:length	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: ldc2_w 187
    //   300: lrem
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq +35 -> 338
    //   306: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +29 -> 338
    //   312: ldc 111
    //   314: iconst_2
    //   315: new 113	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   322: ldc 190
    //   324: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: lload 7
    //   329: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 193	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: fload_2
    //   339: lload 7
    //   341: l2f
    //   342: fmul
    //   343: f2l
    //   344: lstore 5
    //   346: lload 7
    //   348: l2f
    //   349: fload_1
    //   350: fmul
    //   351: f2l
    //   352: lstore 9
    //   354: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +49 -> 406
    //   360: ldc 111
    //   362: iconst_2
    //   363: new 113	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   370: ldc 195
    //   372: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 5
    //   377: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc 197
    //   382: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload 9
    //   387: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: ldc 199
    //   392: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: lload 7
    //   397: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: lload 5
    //   408: lload 5
    //   410: sipush 2048
    //   413: i2l
    //   414: lrem
    //   415: lsub
    //   416: lstore 5
    //   418: lload 9
    //   420: sipush 2048
    //   423: i2l
    //   424: lload 9
    //   426: sipush 2048
    //   429: i2l
    //   430: lrem
    //   431: lsub
    //   432: ladd
    //   433: lstore 9
    //   435: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +49 -> 487
    //   441: ldc 111
    //   443: iconst_2
    //   444: new 113	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   451: ldc 201
    //   453: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: lload 5
    //   458: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   461: ldc 197
    //   463: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: lload 9
    //   468: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: ldc 199
    //   473: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 7
    //   478: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: lload 5
    //   489: lconst_0
    //   490: lcmp
    //   491: ifgt +509 -> 1000
    //   494: lconst_0
    //   495: lstore 5
    //   497: lload 9
    //   499: lload 7
    //   501: lcmp
    //   502: iflt +491 -> 993
    //   505: lload 7
    //   507: lload 5
    //   509: lsub
    //   510: lstore 9
    //   512: lconst_0
    //   513: lstore 7
    //   515: sipush 2048
    //   518: newarray byte
    //   520: astore 19
    //   522: new 6	rqu$a
    //   525: dup
    //   526: aconst_null
    //   527: invokespecial 204	rqu$a:<init>	(Lrqv;)V
    //   530: astore 17
    //   532: new 6	rqu$a
    //   535: dup
    //   536: aconst_null
    //   537: invokespecial 204	rqu$a:<init>	(Lrqv;)V
    //   540: astore 16
    //   542: ldc 205
    //   544: aload_0
    //   545: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   548: i2f
    //   549: fdiv
    //   550: invokestatic 211	java/lang/Math:round	(F)I
    //   553: sipush 2048
    //   556: imul
    //   557: istore_3
    //   558: aload 16
    //   560: iconst_0
    //   561: putfield 57	rqu$a:offset	I
    //   564: aload 16
    //   566: iload_3
    //   567: newarray byte
    //   569: putfield 63	rqu$a:data	[B
    //   572: aload 16
    //   574: iload_3
    //   575: putfield 54	rqu$a:size	I
    //   578: new 213	java/io/FileInputStream
    //   581: dup
    //   582: aload 14
    //   584: invokespecial 216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   587: astore 15
    //   589: aload 15
    //   591: lload 5
    //   593: invokevirtual 220	java/io/FileInputStream:skip	(J)J
    //   596: lstore 11
    //   598: lload 11
    //   600: lload 5
    //   602: lcmp
    //   603: ifeq +31 -> 634
    //   606: iconst_0
    //   607: istore 13
    //   609: aload 15
    //   611: ifnull +8 -> 619
    //   614: aload 15
    //   616: invokevirtual 221	java/io/FileInputStream:close	()V
    //   619: iconst_0
    //   620: ifeq -599 -> 21
    //   623: new 223	java/lang/NullPointerException
    //   626: dup
    //   627: invokespecial 224	java/lang/NullPointerException:<init>	()V
    //   630: athrow
    //   631: astore_0
    //   632: iconst_0
    //   633: ireturn
    //   634: new 226	java/io/FileOutputStream
    //   637: dup
    //   638: aload 18
    //   640: invokespecial 227	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   643: astore 14
    //   645: lload 7
    //   647: lstore 5
    //   649: lload 5
    //   651: lload 9
    //   653: lcmp
    //   654: ifge +226 -> 880
    //   657: aload 15
    //   659: aload 19
    //   661: invokevirtual 231	java/io/FileInputStream:read	([B)I
    //   664: istore_3
    //   665: iload_3
    //   666: ifle -17 -> 649
    //   669: lload 9
    //   671: lload 5
    //   673: lsub
    //   674: l2i
    //   675: istore 4
    //   677: iload_3
    //   678: iload 4
    //   680: if_icmpge +106 -> 786
    //   683: aload_0
    //   684: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   687: ldc 156
    //   689: if_icmpeq +51 -> 740
    //   692: aload 17
    //   694: aload 19
    //   696: iconst_0
    //   697: iload_3
    //   698: invokevirtual 234	rqu$a:j	([BII)V
    //   701: aload_0
    //   702: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   705: ldc 156
    //   707: aload 17
    //   709: aload 16
    //   711: invokestatic 236	rqu:a	(IILrqu$a;Lrqu$a;)Z
    //   714: ifeq +289 -> 1003
    //   717: aload 14
    //   719: aload 16
    //   721: getfield 63	rqu$a:data	[B
    //   724: aload 16
    //   726: getfield 57	rqu$a:offset	I
    //   729: aload 16
    //   731: getfield 54	rqu$a:size	I
    //   734: invokevirtual 239	java/io/FileOutputStream:write	([BII)V
    //   737: goto +266 -> 1003
    //   740: aload 14
    //   742: aload 19
    //   744: iconst_0
    //   745: iload_3
    //   746: invokevirtual 239	java/io/FileOutputStream:write	([BII)V
    //   749: goto +254 -> 1003
    //   752: astore 16
    //   754: aload 15
    //   756: astore_0
    //   757: aload 16
    //   759: astore 15
    //   761: aload 15
    //   763: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   766: aload_0
    //   767: ifnull +7 -> 774
    //   770: aload_0
    //   771: invokevirtual 221	java/io/FileInputStream:close	()V
    //   774: aload 14
    //   776: ifnull +8 -> 784
    //   779: aload 14
    //   781: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   784: iconst_0
    //   785: ireturn
    //   786: aload_0
    //   787: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   790: ldc 156
    //   792: if_icmpeq +75 -> 867
    //   795: aload 17
    //   797: aload 19
    //   799: iconst_0
    //   800: iload 4
    //   802: invokevirtual 234	rqu$a:j	([BII)V
    //   805: aload_0
    //   806: getfield 155	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   809: ldc 156
    //   811: aload 17
    //   813: aload 16
    //   815: invokestatic 236	rqu:a	(IILrqu$a;Lrqu$a;)Z
    //   818: ifeq +185 -> 1003
    //   821: aload 14
    //   823: aload 16
    //   825: getfield 63	rqu$a:data	[B
    //   828: aload 16
    //   830: getfield 57	rqu$a:offset	I
    //   833: aload 16
    //   835: getfield 54	rqu$a:size	I
    //   838: invokevirtual 239	java/io/FileOutputStream:write	([BII)V
    //   841: goto +162 -> 1003
    //   844: astore_0
    //   845: aload 15
    //   847: ifnull +8 -> 855
    //   850: aload 15
    //   852: invokevirtual 221	java/io/FileInputStream:close	()V
    //   855: aload 14
    //   857: ifnull +8 -> 865
    //   860: aload 14
    //   862: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   865: aload_0
    //   866: athrow
    //   867: aload 14
    //   869: aload 19
    //   871: iconst_0
    //   872: iload 4
    //   874: invokevirtual 239	java/io/FileOutputStream:write	([BII)V
    //   877: goto +126 -> 1003
    //   880: aload_0
    //   881: aload 18
    //   883: putfield 169	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:aBp	Ljava/lang/String;
    //   886: iconst_1
    //   887: istore 13
    //   889: aload 15
    //   891: ifnull +8 -> 899
    //   894: aload 15
    //   896: invokevirtual 221	java/io/FileInputStream:close	()V
    //   899: aload 14
    //   901: ifnull -880 -> 21
    //   904: aload 14
    //   906: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   909: iconst_1
    //   910: ireturn
    //   911: astore_0
    //   912: iconst_1
    //   913: ireturn
    //   914: astore_0
    //   915: goto -296 -> 619
    //   918: astore_0
    //   919: goto -20 -> 899
    //   922: astore_0
    //   923: goto -149 -> 774
    //   926: astore_0
    //   927: goto -143 -> 784
    //   930: astore 15
    //   932: goto -77 -> 855
    //   935: astore 14
    //   937: goto -72 -> 865
    //   940: astore_0
    //   941: aconst_null
    //   942: astore 15
    //   944: aconst_null
    //   945: astore 14
    //   947: goto -102 -> 845
    //   950: astore_0
    //   951: aconst_null
    //   952: astore 14
    //   954: goto -109 -> 845
    //   957: astore 16
    //   959: aload_0
    //   960: astore 15
    //   962: aload 16
    //   964: astore_0
    //   965: goto -120 -> 845
    //   968: astore 15
    //   970: aconst_null
    //   971: astore_0
    //   972: aconst_null
    //   973: astore 14
    //   975: goto -214 -> 761
    //   978: astore 16
    //   980: aconst_null
    //   981: astore 14
    //   983: aload 15
    //   985: astore_0
    //   986: aload 16
    //   988: astore 15
    //   990: goto -229 -> 761
    //   993: lload 9
    //   995: lstore 7
    //   997: goto -492 -> 505
    //   1000: goto -503 -> 497
    //   1003: lload 5
    //   1005: iload_3
    //   1006: i2l
    //   1007: ladd
    //   1008: lstore 5
    //   1010: goto -361 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1013	0	paramSlideItemInfo	SlideItemInfo
    //   236	114	1	f1	float
    //   222	117	2	f2	float
    //   557	449	3	i	int
    //   675	198	4	j	int
    //   344	665	5	l1	long
    //   293	703	7	l2	long
    //   352	642	9	l3	long
    //   596	3	11	l4	long
    //   19	869	13	bool	boolean
    //   286	619	14	localObject1	Object
    //   935	1	14	localIOException1	java.io.IOException
    //   945	37	14	localObject2	Object
    //   587	308	15	localObject3	Object
    //   930	1	15	localIOException2	java.io.IOException
    //   942	19	15	localSlideItemInfo	SlideItemInfo
    //   968	16	15	localException1	java.lang.Exception
    //   988	1	15	localException2	java.lang.Exception
    //   540	190	16	locala1	rqu.a
    //   752	82	16	localException3	java.lang.Exception
    //   957	6	16	localObject4	Object
    //   978	9	16	localException4	java.lang.Exception
    //   530	282	17	locala2	rqu.a
    //   259	623	18	str	java.lang.String
    //   520	350	19	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   623	631	631	java/io/IOException
    //   657	665	752	java/lang/Exception
    //   683	737	752	java/lang/Exception
    //   740	749	752	java/lang/Exception
    //   786	841	752	java/lang/Exception
    //   867	877	752	java/lang/Exception
    //   880	886	752	java/lang/Exception
    //   657	665	844	finally
    //   683	737	844	finally
    //   740	749	844	finally
    //   786	841	844	finally
    //   867	877	844	finally
    //   880	886	844	finally
    //   904	909	911	java/io/IOException
    //   614	619	914	java/io/IOException
    //   894	899	918	java/io/IOException
    //   770	774	922	java/io/IOException
    //   779	784	926	java/io/IOException
    //   850	855	930	java/io/IOException
    //   860	865	935	java/io/IOException
    //   578	589	940	finally
    //   589	598	950	finally
    //   634	645	950	finally
    //   761	766	957	finally
    //   578	589	968	java/lang/Exception
    //   589	598	978	java/lang/Exception
    //   634	645	978	java/lang/Exception
  }
  
  private static boolean c(int paramInt1, int paramInt2, rqu.a parama1, rqu.a parama2)
  {
    if (d(paramInt1, paramInt2, parama1, parama2)) {
      return true;
    }
    try
    {
      int i = parama1.size - parama1.offset;
      int j = (int)(i * 1.0F / paramInt1 * paramInt2);
      long l1 = System.currentTimeMillis();
      paramInt1 = AudioResample.nativeResample(paramInt1, paramInt2, parama1.data, parama1.size, parama2.data, parama2.data.length, -1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convertAudioDataQuick:  sizeOut=" + paramInt1 + " cost: " + (l2 - l1) + " ms quickChunkSize:" + j + " result:" + paramInt1 * 2 + " inChunkLength:" + i);
      }
      if (paramInt1 > 0)
      {
        parama2.offset = 0;
        parama2.size = (paramInt1 * 2);
        return true;
      }
    }
    catch (UnsatisfiedLinkError parama1)
    {
      parama1.printStackTrace();
    }
    return false;
  }
  
  private static boolean d(int paramInt1, int paramInt2, rqu.a parama1, rqu.a parama2)
  {
    if ((paramInt1 == 48000) && (paramInt2 == 44100))
    {
      float f = (paramInt1 - paramInt2) * 1.0F / paramInt1;
      int k = parama1.size - parama1.offset;
      int m = k / 2;
      int n = (int)(f * m);
      int i1 = (m - n) / n;
      long l1 = System.currentTimeMillis();
      paramInt2 = 0;
      paramInt1 = 0;
      int j = 0;
      int i = 0;
      if (paramInt2 < m)
      {
        if ((paramInt1 != i1) || (i >= n))
        {
          parama2.data[(j * 2)] = parama1.data[(paramInt2 * 2)];
          parama2.data[(j * 2 + 1)] = parama1.data[(paramInt2 * 2 + 1)];
          j += 1;
          paramInt1 += 1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          paramInt1 = 0;
          i += 1;
        }
      }
      long l2 = System.currentTimeMillis();
      parama2.offset = 0;
      parama2.size = (j * 2);
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convert48KTo441KB:  k=" + j + " cost: " + (l2 - l1) + " ms diff:" + n + " remain:" + (m - n) + " inChunkLength:" + k);
      }
      return true;
    }
    return false;
  }
  
  static class a
  {
    public byte[] data;
    public int offset;
    public int size;
    
    public void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.data = paramArrayOfByte;
      this.offset = paramInt1;
      this.size = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqu
 * JD-Core Version:    0.7.0.1
 */