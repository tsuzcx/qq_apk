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
public class rou
{
  private ByteOrder d = ByteOrder.nativeOrder();
  private int mSampleRate;
  
  /* Error */
  private boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
    throws IOException
  {
    // Byte code:
    //   0: new 34	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 35	android/media/MediaExtractor:<init>	()V
    //   7: astore 20
    //   9: new 37	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 43	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   17: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 21
    //   22: aload 20
    //   24: aload_1
    //   25: getfield 43	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   28: invokevirtual 49	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   31: aload 20
    //   33: invokevirtual 53	android/media/MediaExtractor:getTrackCount	()I
    //   36: istore 9
    //   38: aconst_null
    //   39: astore 19
    //   41: iconst_0
    //   42: istore 8
    //   44: iload 8
    //   46: iload 9
    //   48: if_icmpge +920 -> 968
    //   51: aload 20
    //   53: iload 8
    //   55: invokevirtual 57	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   58: astore 19
    //   60: aload 19
    //   62: ldc 59
    //   64: invokevirtual 65	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: ldc 67
    //   69: invokevirtual 73	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq +102 -> 174
    //   75: aload 20
    //   77: iload 8
    //   79: invokevirtual 77	android/media/MediaExtractor:selectTrack	(I)V
    //   82: iload 8
    //   84: iload 9
    //   86: if_icmpeq +8 -> 94
    //   89: aload 19
    //   91: ifnonnull +92 -> 183
    //   94: ldc 79
    //   96: iconst_1
    //   97: new 81	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   104: ldc 84
    //   106: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 21
    //   111: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 101	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 20
    //   122: invokevirtual 104	android/media/MediaExtractor:release	()V
    //   125: aload 5
    //   127: iconst_0
    //   128: putfield 110	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:hasAudioTrack	Z
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_1
    //   134: ldc 79
    //   136: iconst_1
    //   137: new 81	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   144: ldc 112
    //   146: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 21
    //   151: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_1
    //   158: invokestatic 115	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload 20
    //   163: invokevirtual 104	android/media/MediaExtractor:release	()V
    //   166: aload 5
    //   168: iconst_0
    //   169: putfield 110	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:hasAudioTrack	Z
    //   172: iconst_0
    //   173: ireturn
    //   174: iload 8
    //   176: iconst_1
    //   177: iadd
    //   178: istore 8
    //   180: goto -136 -> 44
    //   183: aload 19
    //   185: invokestatic 118	rou:d	(Landroid/media/MediaFormat;)V
    //   188: iload_2
    //   189: ifle +15 -> 204
    //   192: aload 20
    //   194: iload_2
    //   195: i2l
    //   196: ldc2_w 119
    //   199: lmul
    //   200: iconst_2
    //   201: invokevirtual 124	android/media/MediaExtractor:seekTo	(JI)V
    //   204: aload 19
    //   206: ldc 126
    //   208: invokevirtual 130	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   211: lstore 13
    //   213: iload_3
    //   214: i2f
    //   215: aload_1
    //   216: getfield 134	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
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
    //   257: ifne +704 -> 961
    //   260: aload 19
    //   262: aload_1
    //   263: getfield 43	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   266: invokestatic 139	ron:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   269: istore 11
    //   271: aload_0
    //   272: aload 19
    //   274: invokestatic 142	ron:a	(Landroid/media/MediaFormat;)I
    //   277: putfield 144	rou:mSampleRate	I
    //   280: aload 5
    //   282: aload_0
    //   283: getfield 144	rou:mSampleRate	I
    //   286: putfield 145	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSampleRate	I
    //   289: aload 19
    //   291: ldc 59
    //   293: invokevirtual 65	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: invokestatic 151	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   299: astore 21
    //   301: aload 21
    //   303: aload 19
    //   305: aconst_null
    //   306: aconst_null
    //   307: iconst_0
    //   308: invokevirtual 155	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   311: aload 21
    //   313: invokevirtual 158	android/media/MediaCodec:start	()V
    //   316: new 160	android/media/MediaCodec$BufferInfo
    //   319: dup
    //   320: invokespecial 161	android/media/MediaCodec$BufferInfo:<init>	()V
    //   323: astore 5
    //   325: aconst_null
    //   326: astore_1
    //   327: new 163	java/io/BufferedOutputStream
    //   330: dup
    //   331: new 165	java/io/FileOutputStream
    //   334: dup
    //   335: aload 4
    //   337: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   340: invokespecial 169	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   343: astore 4
    //   345: iconst_2
    //   346: invokestatic 175	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   349: aload_0
    //   350: getfield 23	rou:d	Ljava/nio/ByteOrder;
    //   353: invokevirtual 179	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   356: astore 19
    //   358: aload 19
    //   360: invokevirtual 183	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   363: astore 22
    //   365: iconst_0
    //   366: istore_2
    //   367: aconst_null
    //   368: astore_1
    //   369: aload 21
    //   371: ldc2_w 184
    //   374: invokevirtual 189	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   377: istore 12
    //   379: iload 12
    //   381: iflt +224 -> 605
    //   384: aload 21
    //   386: invokevirtual 193	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   389: iload 12
    //   391: aaload
    //   392: astore 23
    //   394: aload 23
    //   396: invokevirtual 197	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   399: pop
    //   400: aload 20
    //   402: aload 23
    //   404: iconst_0
    //   405: invokevirtual 201	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   408: istore 9
    //   410: aload 20
    //   412: invokevirtual 205	android/media/MediaExtractor:getSampleTime	()J
    //   415: lstore 17
    //   417: iconst_0
    //   418: istore 10
    //   420: iload 9
    //   422: iflt +549 -> 971
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
    //   462: goto +509 -> 971
    //   465: aload 21
    //   467: iload 12
    //   469: iconst_0
    //   470: iload_3
    //   471: lload 15
    //   473: iload 8
    //   475: invokevirtual 209	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   478: aload 20
    //   480: invokevirtual 213	android/media/MediaExtractor:advance	()Z
    //   483: pop
    //   484: aload 21
    //   486: aload 5
    //   488: ldc2_w 184
    //   491: invokevirtual 217	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   494: istore 10
    //   496: iload 10
    //   498: iflt +457 -> 955
    //   501: aload 5
    //   503: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   506: ifle +446 -> 952
    //   509: aload_1
    //   510: ifnonnull +180 -> 690
    //   513: aload 5
    //   515: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   518: invokestatic 175	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 223	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   526: pop
    //   527: aload 21
    //   529: invokevirtual 226	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   532: iload 10
    //   534: aaload
    //   535: aload_1
    //   536: invokevirtual 230	java/nio/ByteBuffer:array	()[B
    //   539: iconst_0
    //   540: aload 5
    //   542: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   545: invokevirtual 234	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   548: pop
    //   549: aload_1
    //   550: aload_0
    //   551: getfield 23	rou:d	Ljava/nio/ByteOrder;
    //   554: invokevirtual 179	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   557: invokevirtual 183	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   560: astore 23
    //   562: iconst_0
    //   563: istore_3
    //   564: iload_3
    //   565: aload 5
    //   567: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   570: if_icmpge +192 -> 762
    //   573: iconst_0
    //   574: istore 9
    //   576: iconst_0
    //   577: istore 8
    //   579: iload 8
    //   581: iload 11
    //   583: if_icmpge +131 -> 714
    //   586: iload 9
    //   588: aload 23
    //   590: invokevirtual 239	java/nio/ShortBuffer:get	()S
    //   593: iadd
    //   594: istore 9
    //   596: iload 8
    //   598: iconst_1
    //   599: iadd
    //   600: istore 8
    //   602: goto -23 -> 579
    //   605: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq -124 -> 484
    //   611: ldc 79
    //   613: iconst_2
    //   614: new 81	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   621: ldc 244
    //   623: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: iload 12
    //   628: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc 249
    //   633: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: goto -158 -> 484
    //   645: astore 5
    //   647: aload 4
    //   649: astore_1
    //   650: aload 5
    //   652: astore 4
    //   654: ldc 79
    //   656: iconst_2
    //   657: aload 4
    //   659: invokevirtual 252	java/lang/Throwable:toString	()Ljava/lang/String;
    //   662: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload_1
    //   666: ifnull +7 -> 673
    //   669: aload_1
    //   670: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   673: aload 20
    //   675: invokevirtual 104	android/media/MediaExtractor:release	()V
    //   678: aload 21
    //   680: invokevirtual 261	android/media/MediaCodec:stop	()V
    //   683: aload 21
    //   685: invokevirtual 262	android/media/MediaCodec:release	()V
    //   688: iconst_0
    //   689: ireturn
    //   690: aload_1
    //   691: invokevirtual 265	java/nio/ByteBuffer:capacity	()I
    //   694: aload 5
    //   696: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   699: if_icmpge +250 -> 949
    //   702: aload 5
    //   704: getfield 220	android/media/MediaCodec$BufferInfo:size	I
    //   707: invokestatic 175	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   710: astore_1
    //   711: goto -189 -> 522
    //   714: iload 9
    //   716: iload 11
    //   718: idiv
    //   719: istore 8
    //   721: aload 22
    //   723: invokevirtual 266	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   726: pop
    //   727: aload 22
    //   729: iload 8
    //   731: i2s
    //   732: invokevirtual 270	java/nio/ShortBuffer:put	(S)Ljava/nio/ShortBuffer;
    //   735: pop
    //   736: aload 22
    //   738: invokevirtual 266	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   741: pop
    //   742: aload 4
    //   744: aload 19
    //   746: invokevirtual 230	java/nio/ByteBuffer:array	()[B
    //   749: invokevirtual 274	java/io/BufferedOutputStream:write	([B)V
    //   752: iload 11
    //   754: iconst_2
    //   755: imul
    //   756: iload_3
    //   757: iadd
    //   758: istore_3
    //   759: goto -195 -> 564
    //   762: aload 5
    //   764: getfield 277	android/media/MediaCodec$BufferInfo:flags	I
    //   767: iconst_4
    //   768: iand
    //   769: ifeq +189 -> 958
    //   772: iconst_1
    //   773: istore_2
    //   774: aload 21
    //   776: invokevirtual 226	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   779: iload 10
    //   781: aaload
    //   782: invokevirtual 197	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   785: pop
    //   786: aload 21
    //   788: iload 10
    //   790: iconst_0
    //   791: invokevirtual 281	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   794: iload_2
    //   795: ifeq +30 -> 825
    //   798: aload 4
    //   800: ifnull +8 -> 808
    //   803: aload 4
    //   805: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   808: aload 20
    //   810: invokevirtual 104	android/media/MediaExtractor:release	()V
    //   813: aload 21
    //   815: invokevirtual 261	android/media/MediaCodec:stop	()V
    //   818: aload 21
    //   820: invokevirtual 262	android/media/MediaCodec:release	()V
    //   823: iconst_1
    //   824: ireturn
    //   825: goto -456 -> 369
    //   828: astore_1
    //   829: aload_1
    //   830: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   833: goto -25 -> 808
    //   836: astore_1
    //   837: ldc 79
    //   839: iconst_1
    //   840: ldc_w 286
    //   843: aload_1
    //   844: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   847: goto -39 -> 808
    //   850: astore_1
    //   851: aload_1
    //   852: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   855: goto -182 -> 673
    //   858: astore_1
    //   859: ldc 79
    //   861: iconst_1
    //   862: ldc_w 286
    //   865: aload_1
    //   866: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   869: goto -196 -> 673
    //   872: astore_1
    //   873: aconst_null
    //   874: astore 4
    //   876: aload 4
    //   878: ifnull +8 -> 886
    //   881: aload 4
    //   883: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   886: aload 20
    //   888: invokevirtual 104	android/media/MediaExtractor:release	()V
    //   891: aload 21
    //   893: invokevirtual 261	android/media/MediaCodec:stop	()V
    //   896: aload 21
    //   898: invokevirtual 262	android/media/MediaCodec:release	()V
    //   901: aload_1
    //   902: athrow
    //   903: astore 4
    //   905: aload 4
    //   907: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   910: goto -24 -> 886
    //   913: astore 4
    //   915: ldc 79
    //   917: iconst_1
    //   918: ldc_w 286
    //   921: aload 4
    //   923: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   926: goto -40 -> 886
    //   929: astore_1
    //   930: goto -54 -> 876
    //   933: astore 5
    //   935: aload_1
    //   936: astore 4
    //   938: aload 5
    //   940: astore_1
    //   941: goto -65 -> 876
    //   944: astore 4
    //   946: goto -292 -> 654
    //   949: goto -427 -> 522
    //   952: goto -178 -> 774
    //   955: goto -161 -> 794
    //   958: goto -184 -> 774
    //   961: lload 15
    //   963: lstore 13
    //   965: goto -705 -> 260
    //   968: goto -886 -> 82
    //   971: iconst_4
    //   972: istore 8
    //   974: iconst_0
    //   975: istore_3
    //   976: ldc2_w 289
    //   979: lstore 15
    //   981: goto -516 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	this	rou
    //   0	984	1	paramLocalMediaInfo	LocalMediaInfo
    //   0	984	2	paramInt1	int
    //   0	984	3	paramInt2	int
    //   0	984	4	paramString	String
    //   0	984	5	paramSlideItemInfo	SlideItemInfo
    //   232	13	6	f1	float
    //   221	14	7	f2	float
    //   42	931	8	i	int
    //   36	683	9	j	int
    //   418	371	10	k	int
    //   269	487	11	m	int
    //   377	250	12	n	int
    //   211	753	13	l1	long
    //   251	729	15	l2	long
    //   415	40	17	l3	long
    //   39	706	19	localObject1	Object
    //   7	880	20	localMediaExtractor	MediaExtractor
    //   20	877	21	localObject2	Object
    //   363	374	22	localShortBuffer	java.nio.ShortBuffer
    //   392	197	23	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	133	java/io/IOException
    //   345	365	645	java/lang/Throwable
    //   369	379	645	java/lang/Throwable
    //   384	417	645	java/lang/Throwable
    //   465	484	645	java/lang/Throwable
    //   484	496	645	java/lang/Throwable
    //   501	509	645	java/lang/Throwable
    //   513	522	645	java/lang/Throwable
    //   522	562	645	java/lang/Throwable
    //   564	573	645	java/lang/Throwable
    //   586	596	645	java/lang/Throwable
    //   605	642	645	java/lang/Throwable
    //   690	711	645	java/lang/Throwable
    //   714	752	645	java/lang/Throwable
    //   762	772	645	java/lang/Throwable
    //   774	794	645	java/lang/Throwable
    //   803	808	828	java/io/IOException
    //   803	808	836	java/lang/StackOverflowError
    //   669	673	850	java/io/IOException
    //   669	673	858	java/lang/StackOverflowError
    //   327	345	872	finally
    //   881	886	903	java/io/IOException
    //   881	886	913	java/lang/StackOverflowError
    //   345	365	929	finally
    //   369	379	929	finally
    //   384	417	929	finally
    //   465	484	929	finally
    //   484	496	929	finally
    //   501	509	929	finally
    //   513	522	929	finally
    //   522	562	929	finally
    //   564	573	929	finally
    //   586	596	929	finally
    //   605	642	929	finally
    //   690	711	929	finally
    //   714	752	929	finally
    //   762	772	929	finally
    //   774	794	929	finally
    //   654	665	933	finally
    //   327	345	944	java/lang/Throwable
  }
  
  private void b(String paramString, SlideItemInfo paramSlideItemInfo)
    throws IOException
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
          paramSlideItemInfo.hasAudioTrack = false;
          return;
        }
      }
      catch (IOException paramString)
      {
        QLog.w("ExtractPCMFromFile", 1, "setDataSource exception: " + localFile, paramString);
        localMediaExtractor.release();
        paramSlideItemInfo.hasAudioTrack = false;
        return;
      }
      i += 1;
    }
    paramString.getInteger("channel-count");
    this.mSampleRate = ron.a(paramString);
    paramSlideItemInfo.mSampleRate = this.mSampleRate;
    localMediaExtractor.release();
  }
  
  /* Error */
  public static void by(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 79
    //   10: iconst_2
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 307
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aconst_null
    //   35: astore 8
    //   37: aconst_null
    //   38: astore 7
    //   40: aload 8
    //   42: astore 6
    //   44: bipush 88
    //   46: newarray byte
    //   48: astore 9
    //   50: iconst_0
    //   51: istore_2
    //   52: aload 8
    //   54: astore 6
    //   56: iload_2
    //   57: aload 9
    //   59: arraylength
    //   60: if_icmpge +15 -> 75
    //   63: aload 9
    //   65: iload_2
    //   66: iconst_m1
    //   67: bastore
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: goto -20 -> 52
    //   75: aload 8
    //   77: astore 6
    //   79: new 163	java/io/BufferedOutputStream
    //   82: dup
    //   83: new 165	java/io/FileOutputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   91: invokespecial 169	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   94: astore_0
    //   95: lconst_0
    //   96: lstore 4
    //   98: lload 4
    //   100: iload_1
    //   101: i2l
    //   102: lcmp
    //   103: ifge +18 -> 121
    //   106: aload_0
    //   107: aload 9
    //   109: invokevirtual 274	java/io/BufferedOutputStream:write	([B)V
    //   112: lload 4
    //   114: lconst_1
    //   115: ladd
    //   116: lstore 4
    //   118: goto -20 -> 98
    //   121: aload 9
    //   123: arraylength
    //   124: iload_1
    //   125: imul
    //   126: istore_2
    //   127: ldc_w 308
    //   130: iload_1
    //   131: i2f
    //   132: fmul
    //   133: f2i
    //   134: iconst_2
    //   135: idiv
    //   136: iconst_2
    //   137: imul
    //   138: iload_2
    //   139: iadd
    //   140: istore_1
    //   141: iload_1
    //   142: sipush 2048
    //   145: iload_1
    //   146: sipush 2048
    //   149: irem
    //   150: isub
    //   151: iadd
    //   152: iload_2
    //   153: isub
    //   154: istore_2
    //   155: iload_2
    //   156: ifle +22 -> 178
    //   159: iload_3
    //   160: istore_1
    //   161: iload_1
    //   162: iload_2
    //   163: if_icmpge +15 -> 178
    //   166: aload_0
    //   167: iconst_m1
    //   168: invokevirtual 310	java/io/BufferedOutputStream:write	(I)V
    //   171: iload_1
    //   172: iconst_1
    //   173: iadd
    //   174: istore_1
    //   175: goto -14 -> 161
    //   178: aload_0
    //   179: invokevirtual 313	java/io/BufferedOutputStream:flush	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   190: return
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   196: return
    //   197: astore 6
    //   199: aload 7
    //   201: astore_0
    //   202: aload 6
    //   204: astore 7
    //   206: aload_0
    //   207: astore 6
    //   209: ldc 79
    //   211: iconst_1
    //   212: aload 7
    //   214: invokevirtual 314	java/lang/Exception:toString	()Ljava/lang/String;
    //   217: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: ifnull -31 -> 190
    //   224: aload_0
    //   225: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   234: return
    //   235: astore_0
    //   236: aload 6
    //   238: ifnull +8 -> 246
    //   241: aload 6
    //   243: invokevirtual 258	java/io/BufferedOutputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: astore 6
    //   250: aload 6
    //   252: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   255: goto -9 -> 246
    //   258: astore 7
    //   260: aload_0
    //   261: astore 6
    //   263: aload 7
    //   265: astore_0
    //   266: goto -30 -> 236
    //   269: astore 7
    //   271: goto -65 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramString	String
    //   0	274	1	paramInt	int
    //   51	113	2	i	int
    //   1	159	3	j	int
    //   96	21	4	l	long
    //   42	36	6	localObject1	Object
    //   197	6	6	localException1	Exception
    //   207	35	6	str1	String
    //   248	3	6	localIOException	IOException
    //   261	1	6	str2	String
    //   38	175	7	localObject2	Object
    //   258	6	7	localObject3	Object
    //   269	1	7	localException2	Exception
    //   35	41	8	localObject4	Object
    //   48	74	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   186	190	191	java/io/IOException
    //   44	50	197	java/lang/Exception
    //   56	63	197	java/lang/Exception
    //   79	95	197	java/lang/Exception
    //   224	228	229	java/io/IOException
    //   44	50	235	finally
    //   56	63	235	finally
    //   79	95	235	finally
    //   209	220	235	finally
    //   241	246	248	java/io/IOException
    //   106	112	258	finally
    //   121	141	258	finally
    //   166	171	258	finally
    //   178	182	258	finally
    //   106	112	269	java/lang/Exception
    //   121	141	269	java/lang/Exception
    //   166	171	269	java/lang/Exception
    //   178	182	269	java/lang/Exception
  }
  
  public static void d(MediaFormat paramMediaFormat)
  {
    int i = paramMediaFormat.getInteger("max-input-size");
    if ((i <= 0) || (i > 134217728))
    {
      QLog.e("ExtractPCMFromFile", 1, "fixACodec22885421: ", new Exception("max-input-size overflow ! " + i + " > " + 134217728));
      paramMediaFormat.setInteger("max-input-size", 134217728);
    }
  }
  
  public void a(String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.hasAudioTrack = true;
      b(paramString, paramSlideItemInfo);
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("ExtractPCMFromFile", 2, "Exception : getMetaDataFromFile ERROR");
    }
  }
  
  public boolean b(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.hasAudioTrack = true;
      boolean bool = a(paramLocalMediaInfo, paramInt1, paramInt2, paramString, paramSlideItemInfo);
      return bool;
    }
    catch (IOException paramLocalMediaInfo)
    {
      QLog.e("ExtractPCMFromFile", 2, "Exception : getPCMFromFile ERROR");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rou
 * JD-Core Version:    0.7.0.1
 */