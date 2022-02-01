import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;

@TargetApi(16)
public class ypf
{
  private int jdField_a_of_type_Int;
  private ByteOrder jdField_a_of_type_JavaNioByteOrder = ByteOrder.nativeOrder();
  
  public static void a(MediaFormat paramMediaFormat)
  {
    int i = paramMediaFormat.getInteger("max-input-size");
    if ((i <= 0) || (i > 134217728))
    {
      QLog.e("ExtractPCMFromFile", 1, "fixACodec22885421: ", new Exception("max-input-size overflow ! " + i + " > " + 134217728));
      paramMediaFormat.setInteger("max-input-size", 134217728);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 35
    //   10: iconst_2
    //   11: new 41	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   18: ldc 78
    //   20: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 8
    //   36: aconst_null
    //   37: astore 7
    //   39: aload 8
    //   41: astore 6
    //   43: bipush 88
    //   45: newarray byte
    //   47: astore 9
    //   49: iconst_0
    //   50: istore_2
    //   51: aload 8
    //   53: astore 6
    //   55: iload_2
    //   56: aload 9
    //   58: arraylength
    //   59: if_icmpge +15 -> 74
    //   62: aload 9
    //   64: iload_2
    //   65: iconst_m1
    //   66: bastore
    //   67: iload_2
    //   68: iconst_1
    //   69: iadd
    //   70: istore_2
    //   71: goto -20 -> 51
    //   74: aload 8
    //   76: astore 6
    //   78: new 84	java/io/BufferedOutputStream
    //   81: dup
    //   82: new 86	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   93: astore_0
    //   94: lconst_0
    //   95: lstore 4
    //   97: lload 4
    //   99: iload_1
    //   100: i2l
    //   101: lcmp
    //   102: ifge +18 -> 120
    //   105: aload_0
    //   106: aload 9
    //   108: invokevirtual 94	java/io/BufferedOutputStream:write	([B)V
    //   111: lload 4
    //   113: lconst_1
    //   114: ladd
    //   115: lstore 4
    //   117: goto -20 -> 97
    //   120: aload 9
    //   122: arraylength
    //   123: iload_1
    //   124: imul
    //   125: istore_2
    //   126: ldc 95
    //   128: iload_1
    //   129: i2f
    //   130: fmul
    //   131: f2i
    //   132: iconst_2
    //   133: idiv
    //   134: iconst_2
    //   135: imul
    //   136: iload_2
    //   137: iadd
    //   138: istore_1
    //   139: iload_1
    //   140: sipush 2048
    //   143: iload_1
    //   144: sipush 2048
    //   147: irem
    //   148: isub
    //   149: iadd
    //   150: iload_2
    //   151: isub
    //   152: istore_2
    //   153: iload_2
    //   154: ifle +22 -> 176
    //   157: iload_3
    //   158: istore_1
    //   159: iload_1
    //   160: iload_2
    //   161: if_icmpge +15 -> 176
    //   164: aload_0
    //   165: iconst_m1
    //   166: invokevirtual 98	java/io/BufferedOutputStream:write	(I)V
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -14 -> 159
    //   176: aload_0
    //   177: invokevirtual 101	java/io/BufferedOutputStream:flush	()V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   188: return
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   194: return
    //   195: astore 6
    //   197: aload 7
    //   199: astore_0
    //   200: aload 6
    //   202: astore 7
    //   204: aload_0
    //   205: astore 6
    //   207: ldc 35
    //   209: iconst_1
    //   210: aload 7
    //   212: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
    //   215: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: ifnull -31 -> 188
    //   222: aload_0
    //   223: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   232: return
    //   233: astore_0
    //   234: aload 6
    //   236: ifnull +8 -> 244
    //   239: aload 6
    //   241: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore 6
    //   248: aload 6
    //   250: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   253: goto -9 -> 244
    //   256: astore 7
    //   258: aload_0
    //   259: astore 6
    //   261: aload 7
    //   263: astore_0
    //   264: goto -30 -> 234
    //   267: astore 7
    //   269: goto -65 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramString	String
    //   0	272	1	paramInt	int
    //   50	112	2	i	int
    //   1	157	3	j	int
    //   95	21	4	l	long
    //   41	36	6	localObject1	Object
    //   195	6	6	localException1	Exception
    //   205	35	6	str1	String
    //   246	3	6	localIOException	IOException
    //   259	1	6	str2	String
    //   37	174	7	localObject2	Object
    //   256	6	7	localObject3	Object
    //   267	1	7	localException2	Exception
    //   34	41	8	localObject4	Object
    //   47	74	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   184	188	189	java/io/IOException
    //   43	49	195	java/lang/Exception
    //   55	62	195	java/lang/Exception
    //   78	94	195	java/lang/Exception
    //   222	226	227	java/io/IOException
    //   43	49	233	finally
    //   55	62	233	finally
    //   78	94	233	finally
    //   207	218	233	finally
    //   239	244	246	java/io/IOException
    //   105	111	256	finally
    //   120	139	256	finally
    //   164	169	256	finally
    //   176	180	256	finally
    //   105	111	267	java/lang/Exception
    //   120	139	267	java/lang/Exception
    //   164	169	267	java/lang/Exception
    //   176	180	267	java/lang/Exception
  }
  
  private void b(String paramString, SlideItemInfo paramSlideItemInfo)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    Object localObject = null;
    File localFile = new File(paramString);
    for (;;)
    {
      int i;
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int j = localMediaExtractor.getTrackCount();
        i = 0;
        paramString = localObject;
        if (i < j)
        {
          paramString = localMediaExtractor.getTrackFormat(i);
          if (paramString.getString("mime").startsWith("audio/")) {
            localMediaExtractor.selectTrack(i);
          }
        }
        else
        {
          if ((i != j) && (paramString != null)) {
            break;
          }
          QLog.w("ExtractPCMFromFile", 1, "No audio track found in " + localFile);
          localMediaExtractor.release();
          paramSlideItemInfo.a = false;
          return;
        }
      }
      catch (IOException paramString)
      {
        QLog.w("ExtractPCMFromFile", 1, "setDataSource exception: " + localFile, paramString);
        localMediaExtractor.release();
        paramSlideItemInfo.a = false;
        return;
      }
      i += 1;
    }
    paramString.getInteger("channel-count");
    this.jdField_a_of_type_Int = yot.a(paramString);
    paramSlideItemInfo.c = this.jdField_a_of_type_Int;
    localMediaExtractor.release();
  }
  
  /* Error */
  private boolean b(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: new 114	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 115	android/media/MediaExtractor:<init>	()V
    //   7: astore 20
    //   9: new 117	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   17: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 21
    //   22: aload 20
    //   24: aload_1
    //   25: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   28: invokevirtual 121	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   31: aload 20
    //   33: invokevirtual 125	android/media/MediaExtractor:getTrackCount	()I
    //   36: istore 9
    //   38: aconst_null
    //   39: astore 19
    //   41: iconst_0
    //   42: istore 8
    //   44: iload 8
    //   46: iload 9
    //   48: if_icmpge +922 -> 970
    //   51: aload 20
    //   53: iload 8
    //   55: invokevirtual 129	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   58: astore 19
    //   60: aload 19
    //   62: ldc 131
    //   64: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: ldc 137
    //   69: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq +102 -> 174
    //   75: aload 20
    //   77: iload 8
    //   79: invokevirtual 146	android/media/MediaExtractor:selectTrack	(I)V
    //   82: iload 8
    //   84: iload 9
    //   86: if_icmpeq +8 -> 94
    //   89: aload 19
    //   91: ifnonnull +92 -> 183
    //   94: ldc 35
    //   96: iconst_1
    //   97: new 41	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   104: ldc 148
    //   106: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 21
    //   111: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: invokevirtual 157	android/media/MediaExtractor:release	()V
    //   125: aload 5
    //   127: iconst_0
    //   128: putfield 162	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Z
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_1
    //   134: ldc 35
    //   136: iconst_1
    //   137: new 41	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   144: ldc 191
    //   146: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 21
    //   151: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_1
    //   158: invokestatic 166	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload 20
    //   163: invokevirtual 157	android/media/MediaExtractor:release	()V
    //   166: aload 5
    //   168: iconst_0
    //   169: putfield 162	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Z
    //   172: iconst_0
    //   173: ireturn
    //   174: iload 8
    //   176: iconst_1
    //   177: iadd
    //   178: istore 8
    //   180: goto -136 -> 44
    //   183: aload 19
    //   185: invokestatic 193	ypf:a	(Landroid/media/MediaFormat;)V
    //   188: iload_2
    //   189: ifle +15 -> 204
    //   192: aload 20
    //   194: iload_2
    //   195: i2l
    //   196: ldc2_w 194
    //   199: lmul
    //   200: iconst_2
    //   201: invokevirtual 199	android/media/MediaExtractor:seekTo	(JI)V
    //   204: aload 19
    //   206: ldc 201
    //   208: invokevirtual 205	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   211: lstore 13
    //   213: iload_3
    //   214: i2f
    //   215: aload_1
    //   216: getfield 209	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   219: l2f
    //   220: fdiv
    //   221: fstore 7
    //   223: fload 7
    //   225: fconst_0
    //   226: fcmpl
    //   227: ifeq +14 -> 241
    //   230: fload 7
    //   232: fstore 6
    //   234: fload 7
    //   236: fconst_1
    //   237: fcmpl
    //   238: ifle +6 -> 244
    //   241: fconst_1
    //   242: fstore 6
    //   244: fload 6
    //   246: lload 13
    //   248: l2f
    //   249: fmul
    //   250: f2l
    //   251: lstore 15
    //   253: lload 15
    //   255: lconst_0
    //   256: lcmp
    //   257: ifne +706 -> 963
    //   260: aload 19
    //   262: aload_1
    //   263: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   266: invokestatic 212	yot:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   269: istore 11
    //   271: aload_0
    //   272: aload 19
    //   274: invokestatic 173	yot:a	(Landroid/media/MediaFormat;)I
    //   277: putfield 175	ypf:jdField_a_of_type_Int	I
    //   280: aload 5
    //   282: aload_0
    //   283: getfield 175	ypf:jdField_a_of_type_Int	I
    //   286: putfield 178	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:c	I
    //   289: aload 19
    //   291: ldc 131
    //   293: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: invokestatic 218	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   299: astore 21
    //   301: aload 21
    //   303: aload 19
    //   305: aconst_null
    //   306: aconst_null
    //   307: iconst_0
    //   308: invokevirtual 222	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   311: aload 21
    //   313: invokevirtual 225	android/media/MediaCodec:start	()V
    //   316: new 227	android/media/MediaCodec$BufferInfo
    //   319: dup
    //   320: invokespecial 228	android/media/MediaCodec$BufferInfo:<init>	()V
    //   323: astore 5
    //   325: aconst_null
    //   326: astore_1
    //   327: new 84	java/io/BufferedOutputStream
    //   330: dup
    //   331: new 86	java/io/FileOutputStream
    //   334: dup
    //   335: aload 4
    //   337: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   340: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   343: astore 4
    //   345: iconst_2
    //   346: invokestatic 234	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   349: aload_0
    //   350: getfield 22	ypf:jdField_a_of_type_JavaNioByteOrder	Ljava/nio/ByteOrder;
    //   353: invokevirtual 238	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   356: astore 19
    //   358: aload 19
    //   360: invokevirtual 242	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   363: astore 22
    //   365: iconst_0
    //   366: istore_2
    //   367: aconst_null
    //   368: astore_1
    //   369: aload 21
    //   371: ldc2_w 243
    //   374: invokevirtual 248	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   377: istore 12
    //   379: iload 12
    //   381: iflt +224 -> 605
    //   384: aload 21
    //   386: invokevirtual 252	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   389: iload 12
    //   391: aaload
    //   392: astore 23
    //   394: aload 23
    //   396: invokevirtual 256	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   399: pop
    //   400: aload 20
    //   402: aload 23
    //   404: iconst_0
    //   405: invokevirtual 260	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   408: istore 9
    //   410: aload 20
    //   412: invokevirtual 264	android/media/MediaExtractor:getSampleTime	()J
    //   415: lstore 17
    //   417: iconst_0
    //   418: istore 10
    //   420: iload 9
    //   422: iflt +551 -> 973
    //   425: iload 9
    //   427: istore_3
    //   428: lload 17
    //   430: lstore 15
    //   432: iload 10
    //   434: istore 8
    //   436: lload 13
    //   438: lconst_0
    //   439: lcmp
    //   440: ifle +25 -> 465
    //   443: iload 9
    //   445: istore_3
    //   446: lload 17
    //   448: lstore 15
    //   450: iload 10
    //   452: istore 8
    //   454: lload 17
    //   456: lload 13
    //   458: lcmp
    //   459: iflt +6 -> 465
    //   462: goto +511 -> 973
    //   465: aload 21
    //   467: iload 12
    //   469: iconst_0
    //   470: iload_3
    //   471: lload 15
    //   473: iload 8
    //   475: invokevirtual 268	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   478: aload 20
    //   480: invokevirtual 271	android/media/MediaExtractor:advance	()Z
    //   483: pop
    //   484: aload 21
    //   486: aload 5
    //   488: ldc2_w 243
    //   491: invokevirtual 275	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   494: istore 10
    //   496: iload 10
    //   498: iflt +459 -> 957
    //   501: aload 5
    //   503: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   506: ifle +448 -> 954
    //   509: aload_1
    //   510: ifnonnull +182 -> 692
    //   513: aload 5
    //   515: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   518: invokestatic 234	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 281	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   526: pop
    //   527: aload 21
    //   529: invokevirtual 284	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   532: iload 10
    //   534: aaload
    //   535: aload_1
    //   536: invokevirtual 288	java/nio/ByteBuffer:array	()[B
    //   539: iconst_0
    //   540: aload 5
    //   542: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   545: invokevirtual 292	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   548: pop
    //   549: aload_1
    //   550: aload_0
    //   551: getfield 22	ypf:jdField_a_of_type_JavaNioByteOrder	Ljava/nio/ByteOrder;
    //   554: invokevirtual 238	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   557: invokevirtual 242	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   560: astore 23
    //   562: iconst_0
    //   563: istore_3
    //   564: iload_3
    //   565: aload 5
    //   567: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   570: if_icmpge +194 -> 764
    //   573: iconst_0
    //   574: istore 9
    //   576: iconst_0
    //   577: istore 8
    //   579: iload 8
    //   581: iload 11
    //   583: if_icmpge +133 -> 716
    //   586: iload 9
    //   588: aload 23
    //   590: invokevirtual 297	java/nio/ShortBuffer:get	()S
    //   593: iadd
    //   594: istore 9
    //   596: iload 8
    //   598: iconst_1
    //   599: iadd
    //   600: istore 8
    //   602: goto -23 -> 579
    //   605: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq -124 -> 484
    //   611: ldc 35
    //   613: iconst_2
    //   614: new 41	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 299
    //   624: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: iload 12
    //   629: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 301
    //   635: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: goto -160 -> 484
    //   647: astore 5
    //   649: aload 4
    //   651: astore_1
    //   652: aload 5
    //   654: astore 4
    //   656: ldc 35
    //   658: iconst_2
    //   659: aload 4
    //   661: invokevirtual 302	java/lang/Throwable:toString	()Ljava/lang/String;
    //   664: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: aload_1
    //   668: ifnull +7 -> 675
    //   671: aload_1
    //   672: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   675: aload 20
    //   677: invokevirtual 157	android/media/MediaExtractor:release	()V
    //   680: aload 21
    //   682: invokevirtual 305	android/media/MediaCodec:stop	()V
    //   685: aload 21
    //   687: invokevirtual 306	android/media/MediaCodec:release	()V
    //   690: iconst_0
    //   691: ireturn
    //   692: aload_1
    //   693: invokevirtual 309	java/nio/ByteBuffer:capacity	()I
    //   696: aload 5
    //   698: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   701: if_icmpge +250 -> 951
    //   704: aload 5
    //   706: getfield 278	android/media/MediaCodec$BufferInfo:size	I
    //   709: invokestatic 234	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   712: astore_1
    //   713: goto -191 -> 522
    //   716: iload 9
    //   718: iload 11
    //   720: idiv
    //   721: istore 8
    //   723: aload 22
    //   725: invokevirtual 310	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   728: pop
    //   729: aload 22
    //   731: iload 8
    //   733: i2s
    //   734: invokevirtual 314	java/nio/ShortBuffer:put	(S)Ljava/nio/ShortBuffer;
    //   737: pop
    //   738: aload 22
    //   740: invokevirtual 310	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   743: pop
    //   744: aload 4
    //   746: aload 19
    //   748: invokevirtual 288	java/nio/ByteBuffer:array	()[B
    //   751: invokevirtual 94	java/io/BufferedOutputStream:write	([B)V
    //   754: iload 11
    //   756: iconst_2
    //   757: imul
    //   758: iload_3
    //   759: iadd
    //   760: istore_3
    //   761: goto -197 -> 564
    //   764: aload 5
    //   766: getfield 317	android/media/MediaCodec$BufferInfo:flags	I
    //   769: iconst_4
    //   770: iand
    //   771: ifeq +189 -> 960
    //   774: iconst_1
    //   775: istore_2
    //   776: aload 21
    //   778: invokevirtual 284	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   781: iload 10
    //   783: aaload
    //   784: invokevirtual 256	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   787: pop
    //   788: aload 21
    //   790: iload 10
    //   792: iconst_0
    //   793: invokevirtual 321	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   796: iload_2
    //   797: ifeq +30 -> 827
    //   800: aload 4
    //   802: ifnull +8 -> 810
    //   805: aload 4
    //   807: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   810: aload 20
    //   812: invokevirtual 157	android/media/MediaExtractor:release	()V
    //   815: aload 21
    //   817: invokevirtual 305	android/media/MediaCodec:stop	()V
    //   820: aload 21
    //   822: invokevirtual 306	android/media/MediaCodec:release	()V
    //   825: iconst_1
    //   826: ireturn
    //   827: goto -458 -> 369
    //   830: astore_1
    //   831: aload_1
    //   832: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   835: goto -25 -> 810
    //   838: astore_1
    //   839: ldc 35
    //   841: iconst_1
    //   842: ldc_w 323
    //   845: aload_1
    //   846: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   849: goto -39 -> 810
    //   852: astore_1
    //   853: aload_1
    //   854: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   857: goto -182 -> 675
    //   860: astore_1
    //   861: ldc 35
    //   863: iconst_1
    //   864: ldc_w 323
    //   867: aload_1
    //   868: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   871: goto -196 -> 675
    //   874: astore_1
    //   875: aconst_null
    //   876: astore 4
    //   878: aload 4
    //   880: ifnull +8 -> 888
    //   883: aload 4
    //   885: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   888: aload 20
    //   890: invokevirtual 157	android/media/MediaExtractor:release	()V
    //   893: aload 21
    //   895: invokevirtual 305	android/media/MediaCodec:stop	()V
    //   898: aload 21
    //   900: invokevirtual 306	android/media/MediaCodec:release	()V
    //   903: aload_1
    //   904: athrow
    //   905: astore 4
    //   907: aload 4
    //   909: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   912: goto -24 -> 888
    //   915: astore 4
    //   917: ldc 35
    //   919: iconst_1
    //   920: ldc_w 323
    //   923: aload 4
    //   925: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   928: goto -40 -> 888
    //   931: astore_1
    //   932: goto -54 -> 878
    //   935: astore 5
    //   937: aload_1
    //   938: astore 4
    //   940: aload 5
    //   942: astore_1
    //   943: goto -65 -> 878
    //   946: astore 4
    //   948: goto -292 -> 656
    //   951: goto -429 -> 522
    //   954: goto -178 -> 776
    //   957: goto -161 -> 796
    //   960: goto -184 -> 776
    //   963: lload 15
    //   965: lstore 13
    //   967: goto -707 -> 260
    //   970: goto -888 -> 82
    //   973: iconst_4
    //   974: istore 8
    //   976: iconst_0
    //   977: istore_3
    //   978: ldc2_w 326
    //   981: lstore 15
    //   983: goto -518 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	986	0	this	ypf
    //   0	986	1	paramLocalMediaInfo	LocalMediaInfo
    //   0	986	2	paramInt1	int
    //   0	986	3	paramInt2	int
    //   0	986	4	paramString	String
    //   0	986	5	paramSlideItemInfo	SlideItemInfo
    //   232	13	6	f1	float
    //   221	14	7	f2	float
    //   42	933	8	i	int
    //   36	685	9	j	int
    //   418	373	10	k	int
    //   269	489	11	m	int
    //   377	251	12	n	int
    //   211	755	13	l1	long
    //   251	731	15	l2	long
    //   415	40	17	l3	long
    //   39	708	19	localObject1	Object
    //   7	882	20	localMediaExtractor	MediaExtractor
    //   20	879	21	localObject2	Object
    //   363	376	22	localShortBuffer	java.nio.ShortBuffer
    //   392	197	23	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	133	java/io/IOException
    //   345	365	647	java/lang/Throwable
    //   369	379	647	java/lang/Throwable
    //   384	417	647	java/lang/Throwable
    //   465	484	647	java/lang/Throwable
    //   484	496	647	java/lang/Throwable
    //   501	509	647	java/lang/Throwable
    //   513	522	647	java/lang/Throwable
    //   522	562	647	java/lang/Throwable
    //   564	573	647	java/lang/Throwable
    //   586	596	647	java/lang/Throwable
    //   605	644	647	java/lang/Throwable
    //   692	713	647	java/lang/Throwable
    //   716	754	647	java/lang/Throwable
    //   764	774	647	java/lang/Throwable
    //   776	796	647	java/lang/Throwable
    //   805	810	830	java/io/IOException
    //   805	810	838	java/lang/StackOverflowError
    //   671	675	852	java/io/IOException
    //   671	675	860	java/lang/StackOverflowError
    //   327	345	874	finally
    //   883	888	905	java/io/IOException
    //   883	888	915	java/lang/StackOverflowError
    //   345	365	931	finally
    //   369	379	931	finally
    //   384	417	931	finally
    //   465	484	931	finally
    //   484	496	931	finally
    //   501	509	931	finally
    //   513	522	931	finally
    //   522	562	931	finally
    //   564	573	931	finally
    //   586	596	931	finally
    //   605	644	931	finally
    //   692	713	931	finally
    //   716	754	931	finally
    //   764	774	931	finally
    //   776	796	931	finally
    //   656	667	935	finally
    //   327	345	946	java/lang/Throwable
  }
  
  public void a(String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.a = true;
      b(paramString, paramSlideItemInfo);
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("ExtractPCMFromFile", 2, "Exception : getMetaDataFromFile ERROR");
    }
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.a = true;
      boolean bool = b(paramLocalMediaInfo, paramInt1, paramInt2, paramString, paramSlideItemInfo);
      return bool;
    }
    catch (IOException paramLocalMediaInfo)
    {
      QLog.e("ExtractPCMFromFile", 2, "Exception : getPCMFromFile ERROR");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypf
 * JD-Core Version:    0.7.0.1
 */