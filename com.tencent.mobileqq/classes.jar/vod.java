import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class vod
{
  private static boolean a(int paramInt1, int paramInt2, vof paramvof1, vof paramvof2)
  {
    if (!c(paramInt1, paramInt2, paramvof1, paramvof2)) {
      return b(paramInt1, paramInt2, paramvof1, paramvof2);
    }
    return true;
  }
  
  /* Error */
  private static boolean a(SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifgt +18 -> 24
    //   9: aload_0
    //   10: getfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: iload 5
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   28: aload_0
    //   29: getfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   32: lcmp
    //   33: ifge +5 -> 38
    //   36: iconst_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   42: aload_0
    //   43: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   46: lcmp
    //   47: ifle +11 -> 58
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   55: putfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   58: aload_0
    //   59: getfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifgt +8 -> 72
    //   67: aload_0
    //   68: lconst_0
    //   69: putfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   72: aload_0
    //   73: getfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   76: lconst_0
    //   77: lcmp
    //   78: ifne +26 -> 104
    //   81: aload_0
    //   82: getfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   85: aload_0
    //   86: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   89: lcmp
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   97: ldc 31
    //   99: if_icmpne +5 -> 104
    //   102: iconst_1
    //   103: ireturn
    //   104: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +43 -> 150
    //   110: ldc 39
    //   112: iconst_2
    //   113: new 41	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   120: ldc 47
    //   122: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   129: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 56
    //   134: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   154: ifne +9 -> 163
    //   157: aload_0
    //   158: ldc 31
    //   160: putfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   163: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +43 -> 209
    //   169: ldc 39
    //   171: iconst_2
    //   172: new 41	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   179: ldc 72
    //   181: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   188: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc 56
    //   193: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   200: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   203: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 23	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   213: l2f
    //   214: fconst_1
    //   215: fmul
    //   216: aload_0
    //   217: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   220: l2f
    //   221: fdiv
    //   222: fstore_2
    //   223: aload_0
    //   224: getfield 25	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   227: l2f
    //   228: fconst_1
    //   229: fmul
    //   230: aload_0
    //   231: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   234: l2f
    //   235: fdiv
    //   236: fstore_1
    //   237: new 41	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 76	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   248: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 78
    //   253: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 17
    //   261: aload 17
    //   263: invokestatic 83	apdh:a	(Ljava/lang/String;)Z
    //   266: ifeq +9 -> 275
    //   269: aload 17
    //   271: invokestatic 85	apdh:c	(Ljava/lang/String;)Z
    //   274: pop
    //   275: new 87	java/io/File
    //   278: dup
    //   279: aload_0
    //   280: getfield 76	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   283: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore 14
    //   288: aload 14
    //   290: invokevirtual 94	java/io/File:length	()J
    //   293: lstore 8
    //   295: lload 8
    //   297: ldc2_w 95
    //   300: lrem
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq +35 -> 338
    //   306: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +29 -> 338
    //   312: ldc 39
    //   314: iconst_2
    //   315: new 41	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   322: ldc 98
    //   324: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: lload 8
    //   329: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 104	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: fload_2
    //   339: lload 8
    //   341: l2f
    //   342: fmul
    //   343: f2l
    //   344: lstore 6
    //   346: lload 8
    //   348: l2f
    //   349: fload_1
    //   350: fmul
    //   351: f2l
    //   352: lstore 10
    //   354: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +49 -> 406
    //   360: ldc 39
    //   362: iconst_2
    //   363: new 41	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   370: ldc 106
    //   372: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 6
    //   377: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc 108
    //   382: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload 10
    //   387: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: ldc 110
    //   392: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: lload 8
    //   397: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: lload 6
    //   408: lload 6
    //   410: sipush 2048
    //   413: i2l
    //   414: lrem
    //   415: lsub
    //   416: lstore 6
    //   418: lload 10
    //   420: sipush 2048
    //   423: i2l
    //   424: lload 10
    //   426: sipush 2048
    //   429: i2l
    //   430: lrem
    //   431: lsub
    //   432: ladd
    //   433: lstore 10
    //   435: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +49 -> 487
    //   441: ldc 39
    //   443: iconst_2
    //   444: new 41	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   451: ldc 112
    //   453: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: lload 6
    //   458: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   461: ldc 108
    //   463: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: lload 10
    //   468: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: ldc 110
    //   473: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 8
    //   478: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: lload 6
    //   489: lconst_0
    //   490: lcmp
    //   491: ifgt +509 -> 1000
    //   494: lconst_0
    //   495: lstore 6
    //   497: lload 10
    //   499: lload 8
    //   501: lcmp
    //   502: iflt +491 -> 993
    //   505: lload 8
    //   507: lload 6
    //   509: lsub
    //   510: lstore 10
    //   512: lconst_0
    //   513: lstore 8
    //   515: sipush 2048
    //   518: newarray byte
    //   520: astore 19
    //   522: new 114	vof
    //   525: dup
    //   526: aconst_null
    //   527: invokespecial 117	vof:<init>	(Lvoe;)V
    //   530: astore 18
    //   532: new 114	vof
    //   535: dup
    //   536: aconst_null
    //   537: invokespecial 117	vof:<init>	(Lvoe;)V
    //   540: astore 16
    //   542: ldc 118
    //   544: aload_0
    //   545: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   548: i2f
    //   549: fdiv
    //   550: invokestatic 124	java/lang/Math:round	(F)I
    //   553: sipush 2048
    //   556: imul
    //   557: istore_3
    //   558: aload 16
    //   560: iconst_0
    //   561: putfield 126	vof:jdField_a_of_type_Int	I
    //   564: aload 16
    //   566: iload_3
    //   567: newarray byte
    //   569: putfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   572: aload 16
    //   574: iload_3
    //   575: putfield 131	vof:jdField_b_of_type_Int	I
    //   578: new 133	java/io/FileInputStream
    //   581: dup
    //   582: aload 14
    //   584: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   587: astore 15
    //   589: aload 15
    //   591: lload 6
    //   593: invokevirtual 140	java/io/FileInputStream:skip	(J)J
    //   596: lstore 12
    //   598: lload 12
    //   600: lload 6
    //   602: lcmp
    //   603: ifeq +31 -> 634
    //   606: iconst_0
    //   607: istore 5
    //   609: aload 15
    //   611: ifnull +8 -> 619
    //   614: aload 15
    //   616: invokevirtual 143	java/io/FileInputStream:close	()V
    //   619: iconst_0
    //   620: ifeq -599 -> 21
    //   623: new 145	java/lang/NullPointerException
    //   626: dup
    //   627: invokespecial 146	java/lang/NullPointerException:<init>	()V
    //   630: athrow
    //   631: astore_0
    //   632: iconst_0
    //   633: ireturn
    //   634: new 148	java/io/FileOutputStream
    //   637: dup
    //   638: aload 17
    //   640: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   643: astore 14
    //   645: lload 8
    //   647: lstore 6
    //   649: lload 6
    //   651: lload 10
    //   653: lcmp
    //   654: ifge +226 -> 880
    //   657: aload 15
    //   659: aload 19
    //   661: invokevirtual 153	java/io/FileInputStream:read	([B)I
    //   664: istore_3
    //   665: iload_3
    //   666: ifle -17 -> 649
    //   669: lload 10
    //   671: lload 6
    //   673: lsub
    //   674: l2i
    //   675: istore 4
    //   677: iload_3
    //   678: iload 4
    //   680: if_icmpge +106 -> 786
    //   683: aload_0
    //   684: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   687: ldc 31
    //   689: if_icmpeq +51 -> 740
    //   692: aload 18
    //   694: aload 19
    //   696: iconst_0
    //   697: iload_3
    //   698: invokevirtual 156	vof:a	([BII)V
    //   701: aload_0
    //   702: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   705: ldc 31
    //   707: aload 18
    //   709: aload 16
    //   711: invokestatic 158	vod:a	(IILvof;Lvof;)Z
    //   714: ifeq +289 -> 1003
    //   717: aload 14
    //   719: aload 16
    //   721: getfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   724: aload 16
    //   726: getfield 126	vof:jdField_a_of_type_Int	I
    //   729: aload 16
    //   731: getfield 131	vof:jdField_b_of_type_Int	I
    //   734: invokevirtual 161	java/io/FileOutputStream:write	([BII)V
    //   737: goto +266 -> 1003
    //   740: aload 14
    //   742: aload 19
    //   744: iconst_0
    //   745: iload_3
    //   746: invokevirtual 161	java/io/FileOutputStream:write	([BII)V
    //   749: goto +254 -> 1003
    //   752: astore 16
    //   754: aload 15
    //   756: astore_0
    //   757: aload 16
    //   759: astore 15
    //   761: aload 15
    //   763: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   766: aload_0
    //   767: ifnull +7 -> 774
    //   770: aload_0
    //   771: invokevirtual 143	java/io/FileInputStream:close	()V
    //   774: aload 14
    //   776: ifnull +8 -> 784
    //   779: aload 14
    //   781: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   784: iconst_0
    //   785: ireturn
    //   786: aload_0
    //   787: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   790: ldc 31
    //   792: if_icmpeq +75 -> 867
    //   795: aload 18
    //   797: aload 19
    //   799: iconst_0
    //   800: iload 4
    //   802: invokevirtual 156	vof:a	([BII)V
    //   805: aload_0
    //   806: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   809: ldc 31
    //   811: aload 18
    //   813: aload 16
    //   815: invokestatic 158	vod:a	(IILvof;Lvof;)Z
    //   818: ifeq +185 -> 1003
    //   821: aload 14
    //   823: aload 16
    //   825: getfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   828: aload 16
    //   830: getfield 126	vof:jdField_a_of_type_Int	I
    //   833: aload 16
    //   835: getfield 131	vof:jdField_b_of_type_Int	I
    //   838: invokevirtual 161	java/io/FileOutputStream:write	([BII)V
    //   841: goto +162 -> 1003
    //   844: astore_0
    //   845: aload 15
    //   847: ifnull +8 -> 855
    //   850: aload 15
    //   852: invokevirtual 143	java/io/FileInputStream:close	()V
    //   855: aload 14
    //   857: ifnull +8 -> 865
    //   860: aload 14
    //   862: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   865: aload_0
    //   866: athrow
    //   867: aload 14
    //   869: aload 19
    //   871: iconst_0
    //   872: iload 4
    //   874: invokevirtual 161	java/io/FileOutputStream:write	([BII)V
    //   877: goto +126 -> 1003
    //   880: aload_0
    //   881: aload 17
    //   883: putfield 76	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   886: iconst_1
    //   887: istore 5
    //   889: aload 15
    //   891: ifnull +8 -> 899
    //   894: aload 15
    //   896: invokevirtual 143	java/io/FileInputStream:close	()V
    //   899: aload 14
    //   901: ifnull -880 -> 21
    //   904: aload 14
    //   906: invokevirtual 165	java/io/FileOutputStream:close	()V
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
    //   993: lload 10
    //   995: lstore 8
    //   997: goto -492 -> 505
    //   1000: goto -503 -> 497
    //   1003: lload 6
    //   1005: iload_3
    //   1006: i2l
    //   1007: ladd
    //   1008: lstore 6
    //   1010: goto -361 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1013	0	paramSlideItemInfo	SlideItemInfo
    //   236	114	1	f1	float
    //   222	117	2	f2	float
    //   557	449	3	i	int
    //   675	198	4	j	int
    //   19	869	5	bool	boolean
    //   344	665	6	l1	long
    //   293	703	8	l2	long
    //   352	642	10	l3	long
    //   596	3	12	l4	long
    //   286	619	14	localObject1	Object
    //   935	1	14	localIOException1	java.io.IOException
    //   945	37	14	localObject2	Object
    //   587	308	15	localObject3	Object
    //   930	1	15	localIOException2	java.io.IOException
    //   942	19	15	localSlideItemInfo	SlideItemInfo
    //   968	16	15	localException1	java.lang.Exception
    //   988	1	15	localException2	java.lang.Exception
    //   540	190	16	localvof1	vof
    //   752	82	16	localException3	java.lang.Exception
    //   957	6	16	localObject4	Object
    //   978	9	16	localException4	java.lang.Exception
    //   259	623	17	str	java.lang.String
    //   530	282	18	localvof2	vof
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
  
  public static boolean a(List<SlideItemInfo> paramList)
  {
    return true;
  }
  
  /* Error */
  private static boolean b(int paramInt1, int paramInt2, vof paramvof1, vof paramvof2)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 131	vof:jdField_b_of_type_Int	I
    //   4: aload_2
    //   5: getfield 126	vof:jdField_a_of_type_Int	I
    //   8: isub
    //   9: istore 4
    //   11: new 170	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_2
    //   16: getfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   19: aload_2
    //   20: getfield 126	vof:jdField_a_of_type_Int	I
    //   23: aload_2
    //   24: getfield 131	vof:jdField_b_of_type_Int	I
    //   27: invokespecial 172	java/io/ByteArrayInputStream:<init>	([BII)V
    //   30: astore 9
    //   32: new 174	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 175	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore_2
    //   40: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   43: lstore 5
    //   45: new 182	voj
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
    //   62: invokespecial 185	voj:<init>	(Ljava/io/InputStream;Ljava/io/OutputStream;IIIIIIDIZ)V
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
    //   81: putfield 126	vof:jdField_a_of_type_Int	I
    //   84: aload_3
    //   85: aload_2
    //   86: invokevirtual 189	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: putfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 193	java/io/ByteArrayOutputStream:size	()I
    //   97: putfield 131	vof:jdField_b_of_type_Int	I
    //   100: aload_3
    //   101: getfield 129	vof:jdField_a_of_type_ArrayOfByte	[B
    //   104: arraylength
    //   105: aload_3
    //   106: getfield 131	vof:jdField_b_of_type_Int	I
    //   109: if_icmpeq +29 -> 138
    //   112: new 195	java/lang/RuntimeException
    //   115: dup
    //   116: ldc 197
    //   118: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   127: aload 9
    //   129: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   132: aload_2
    //   133: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   141: lstore 7
    //   143: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +63 -> 209
    //   149: ldc 39
    //   151: iconst_2
    //   152: new 41	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   159: ldc 203
    //   161: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload_0
    //   165: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc 205
    //   170: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_3
    //   174: getfield 131	vof:jdField_b_of_type_Int	I
    //   177: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 207
    //   182: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: lload 7
    //   187: lload 5
    //   189: lsub
    //   190: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc 209
    //   195: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload 4
    //   200: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload 9
    //   211: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   214: aload_2
    //   215: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   218: iconst_1
    //   219: ireturn
    //   220: astore_2
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_3
    //   224: aload 9
    //   226: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   229: aload_2
    //   230: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
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
    //   0	256	2	paramvof1	vof
    //   0	256	3	paramvof2	vof
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
  
  public static boolean b(List<SlideItemInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if ((localSlideItemInfo.jdField_b_of_type_Int == 1) && (localSlideItemInfo.jdField_a_of_type_Boolean) && (!a(localSlideItemInfo))) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean c(int paramInt1, int paramInt2, vof paramvof1, vof paramvof2)
  {
    if (d(paramInt1, paramInt2, paramvof1, paramvof2)) {
      return true;
    }
    try
    {
      int i = paramvof1.jdField_b_of_type_Int - paramvof1.jdField_a_of_type_Int;
      int j = (int)(i * 1.0F / paramInt1 * paramInt2);
      long l1 = System.currentTimeMillis();
      paramInt1 = AudioResample.nativeResample(paramInt1, paramInt2, paramvof1.jdField_a_of_type_ArrayOfByte, paramvof1.jdField_b_of_type_Int, paramvof2.jdField_a_of_type_ArrayOfByte, paramvof2.jdField_a_of_type_ArrayOfByte.length, -1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convertAudioDataQuick:  sizeOut=" + paramInt1 + " cost: " + (l2 - l1) + " ms quickChunkSize:" + j + " result:" + paramInt1 * 2 + " inChunkLength:" + i);
      }
      if (paramInt1 > 0)
      {
        paramvof2.jdField_a_of_type_Int = 0;
        paramvof2.jdField_b_of_type_Int = (paramInt1 * 2);
        return true;
      }
    }
    catch (UnsatisfiedLinkError paramvof1)
    {
      paramvof1.printStackTrace();
    }
    return false;
  }
  
  private static boolean d(int paramInt1, int paramInt2, vof paramvof1, vof paramvof2)
  {
    if ((paramInt1 == 48000) && (paramInt2 == 44100))
    {
      float f = (paramInt1 - paramInt2) * 1.0F / paramInt1;
      int k = paramvof1.jdField_b_of_type_Int - paramvof1.jdField_a_of_type_Int;
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
          paramvof2.jdField_a_of_type_ArrayOfByte[(j * 2)] = paramvof1.jdField_a_of_type_ArrayOfByte[(paramInt2 * 2)];
          paramvof2.jdField_a_of_type_ArrayOfByte[(j * 2 + 1)] = paramvof1.jdField_a_of_type_ArrayOfByte[(paramInt2 * 2 + 1)];
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
      paramvof2.jdField_a_of_type_Int = 0;
      paramvof2.jdField_b_of_type_Int = (j * 2);
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convert48KTo441KB:  k=" + j + " cost: " + (l2 - l1) + " ms diff:" + n + " remain:" + (m - n) + " inChunkLength:" + k);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */