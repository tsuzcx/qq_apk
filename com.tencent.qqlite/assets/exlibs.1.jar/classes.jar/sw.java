import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;

public class sw
  extends Handler
{
  public sw(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 30	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 5:+25->29, 6:+1047->1051
    //   29: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   32: ifne +9 -> 41
    //   35: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   38: ifeq +17 -> 55
    //   41: aload_0
    //   42: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   45: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: bipush 10
    //   50: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   53: pop
    //   54: return
    //   55: aload_1
    //   56: getfield 52	android/os/Message:obj	Ljava/lang/Object;
    //   59: ifnull +13 -> 72
    //   62: aload_1
    //   63: getfield 52	android/os/Message:obj	Ljava/lang/Object;
    //   66: instanceof 54
    //   69: ifne +16 -> 85
    //   72: aload_0
    //   73: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   76: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   79: iconst_2
    //   80: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   83: pop
    //   84: return
    //   85: aload_1
    //   86: getfield 52	android/os/Message:obj	Ljava/lang/Object;
    //   89: checkcast 54	[B
    //   92: checkcast 54	[B
    //   95: astore 17
    //   97: aload_0
    //   98: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   101: getfield 57	com/tencent/biz/widgets/ScannerView:v	I
    //   104: iconst_3
    //   105: if_icmpge +49 -> 154
    //   108: iconst_0
    //   109: istore 8
    //   111: aload 17
    //   113: arraylength
    //   114: istore 9
    //   116: iconst_0
    //   117: istore 6
    //   119: iload 8
    //   121: istore 7
    //   123: iload 6
    //   125: iload 9
    //   127: if_icmpge +14 -> 141
    //   130: aload 17
    //   132: iload 6
    //   134: baload
    //   135: ifeq +492 -> 627
    //   138: iconst_1
    //   139: istore 7
    //   141: iload 7
    //   143: ifeq +493 -> 636
    //   146: aload_0
    //   147: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   150: iconst_3
    //   151: putfield 57	com/tencent/biz/widgets/ScannerView:v	I
    //   154: aload_0
    //   155: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   158: getfield 60	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   166: getfield 62	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   169: astore 16
    //   171: aload_1
    //   172: ifnonnull +3130 -> 3302
    //   175: aload 16
    //   177: astore_1
    //   178: aload 16
    //   180: ifnonnull +39 -> 219
    //   183: aload_0
    //   184: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   187: astore 16
    //   189: new 64	android/graphics/Rect
    //   192: dup
    //   193: iconst_0
    //   194: iconst_0
    //   195: aload_0
    //   196: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   199: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   202: aload_0
    //   203: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   206: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   209: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   212: astore_1
    //   213: aload 16
    //   215: aload_1
    //   216: putfield 62	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   219: aload_0
    //   220: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   223: getfield 76	com/tencent/biz/widgets/ScannerView:u	I
    //   226: bipush 90
    //   228: if_icmpne +449 -> 677
    //   231: aload_0
    //   232: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   235: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   238: i2f
    //   239: aload_0
    //   240: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   243: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   246: i2f
    //   247: fdiv
    //   248: fstore 4
    //   250: aload_0
    //   251: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   254: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   257: i2f
    //   258: aload_0
    //   259: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   262: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   265: i2f
    //   266: fdiv
    //   267: fstore 5
    //   269: new 64	android/graphics/Rect
    //   272: dup
    //   273: aload_1
    //   274: getfield 85	android/graphics/Rect:top	I
    //   277: i2f
    //   278: fload 4
    //   280: fmul
    //   281: f2i
    //   282: aload_0
    //   283: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   286: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   289: aload_1
    //   290: getfield 88	android/graphics/Rect:right	I
    //   293: isub
    //   294: i2f
    //   295: fload 5
    //   297: fmul
    //   298: f2i
    //   299: fload 4
    //   301: aload_1
    //   302: getfield 91	android/graphics/Rect:bottom	I
    //   305: i2f
    //   306: fmul
    //   307: f2i
    //   308: aload_0
    //   309: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   312: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   315: aload_1
    //   316: getfield 94	android/graphics/Rect:left	I
    //   319: isub
    //   320: i2f
    //   321: fload 5
    //   323: fmul
    //   324: f2i
    //   325: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   328: astore_1
    //   329: aload_0
    //   330: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   333: aload_1
    //   334: putfield 60	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   337: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   340: lstore 14
    //   342: iconst_2
    //   343: newarray int
    //   345: astore 16
    //   347: aload_1
    //   348: invokevirtual 104	android/graphics/Rect:width	()I
    //   351: aload_1
    //   352: invokevirtual 107	android/graphics/Rect:height	()I
    //   355: imul
    //   356: iconst_3
    //   357: imul
    //   358: iconst_1
    //   359: ishr
    //   360: newarray byte
    //   362: astore 18
    //   364: aload_0
    //   365: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   368: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   371: ifle +2925 -> 3296
    //   374: aload_0
    //   375: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   378: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   381: ifle +2915 -> 3296
    //   384: aload_1
    //   385: getfield 94	android/graphics/Rect:left	I
    //   388: iflt +2908 -> 3296
    //   391: aload_1
    //   392: getfield 85	android/graphics/Rect:top	I
    //   395: iflt +2901 -> 3296
    //   398: aload_1
    //   399: invokevirtual 104	android/graphics/Rect:width	()I
    //   402: ifle +2894 -> 3296
    //   405: aload_1
    //   406: invokevirtual 107	android/graphics/Rect:height	()I
    //   409: ifle +2887 -> 3296
    //   412: aload_1
    //   413: getfield 88	android/graphics/Rect:right	I
    //   416: aload_0
    //   417: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   420: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   423: if_icmpgt +2873 -> 3296
    //   426: aload_1
    //   427: getfield 91	android/graphics/Rect:bottom	I
    //   430: aload_0
    //   431: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   434: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   437: if_icmpgt +2859 -> 3296
    //   440: aload 17
    //   442: arraylength
    //   443: aload_0
    //   444: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   447: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   450: aload_0
    //   451: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   454: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   457: imul
    //   458: iconst_3
    //   459: imul
    //   460: iconst_1
    //   461: ishr
    //   462: if_icmpne +2834 -> 3296
    //   465: aload 18
    //   467: aload 16
    //   469: aload 17
    //   471: aload_0
    //   472: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   475: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   478: aload_0
    //   479: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   482: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   485: aload_1
    //   486: getfield 94	android/graphics/Rect:left	I
    //   489: aload_1
    //   490: getfield 85	android/graphics/Rect:top	I
    //   493: aload_1
    //   494: invokevirtual 104	android/graphics/Rect:width	()I
    //   497: aload_1
    //   498: invokevirtual 107	android/graphics/Rect:height	()I
    //   501: aload_0
    //   502: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   505: getfield 76	com/tencent/biz/widgets/ScannerView:u	I
    //   508: iconst_0
    //   509: invokestatic 110	com/tencent/imageboost/ImgProcessScan:a	([B[I[BIIIIIIII)I
    //   512: iconst_1
    //   513: if_icmpne +2783 -> 3296
    //   516: aload 18
    //   518: aload 16
    //   520: iconst_0
    //   521: iaload
    //   522: aload 16
    //   524: iconst_1
    //   525: iaload
    //   526: iconst_0
    //   527: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   530: istore 6
    //   532: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   535: lload 14
    //   537: lsub
    //   538: l2d
    //   539: dstore_2
    //   540: iload 6
    //   542: istore 7
    //   544: invokestatic 120	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   547: ifeq +33 -> 580
    //   550: getstatic 123	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   553: iconst_4
    //   554: new 125	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   561: ldc 130
    //   563: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: dload_2
    //   567: invokevirtual 137	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   570: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: iload 6
    //   578: istore 7
    //   580: iload 7
    //   582: iconst_1
    //   583: if_icmpne +455 -> 1038
    //   586: new 125	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   593: astore_1
    //   594: new 125	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   601: astore 16
    //   603: aload_1
    //   604: aload 16
    //   606: invokestatic 148	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   609: pop
    //   610: aload_0
    //   611: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   614: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   617: iconst_1
    //   618: aload 16
    //   620: invokevirtual 152	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   623: invokevirtual 155	android/os/Message:sendToTarget	()V
    //   626: return
    //   627: iload 6
    //   629: iconst_1
    //   630: iadd
    //   631: istore 6
    //   633: goto -514 -> 119
    //   636: aload_0
    //   637: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   640: astore_1
    //   641: aload_1
    //   642: getfield 57	com/tencent/biz/widgets/ScannerView:v	I
    //   645: iconst_1
    //   646: iadd
    //   647: istore 6
    //   649: aload_1
    //   650: iload 6
    //   652: putfield 57	com/tencent/biz/widgets/ScannerView:v	I
    //   655: iload 6
    //   657: iconst_3
    //   658: if_icmpne -504 -> 154
    //   661: aload_0
    //   662: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   665: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   668: bipush 9
    //   670: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   673: pop
    //   674: goto -520 -> 154
    //   677: aload_0
    //   678: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   681: getfield 76	com/tencent/biz/widgets/ScannerView:u	I
    //   684: sipush 180
    //   687: if_icmpne +120 -> 807
    //   690: aload_0
    //   691: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   694: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   697: i2f
    //   698: aload_0
    //   699: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   702: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   705: i2f
    //   706: fdiv
    //   707: fstore 4
    //   709: aload_0
    //   710: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   713: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   716: i2f
    //   717: aload_0
    //   718: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   721: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   724: i2f
    //   725: fdiv
    //   726: fstore 5
    //   728: new 64	android/graphics/Rect
    //   731: dup
    //   732: aload_0
    //   733: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   736: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   739: aload_1
    //   740: getfield 88	android/graphics/Rect:right	I
    //   743: isub
    //   744: i2f
    //   745: fload 4
    //   747: fmul
    //   748: f2i
    //   749: aload_0
    //   750: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   753: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   756: aload_1
    //   757: getfield 91	android/graphics/Rect:bottom	I
    //   760: isub
    //   761: i2f
    //   762: fload 5
    //   764: fmul
    //   765: f2i
    //   766: fload 4
    //   768: aload_0
    //   769: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   772: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   775: aload_1
    //   776: getfield 94	android/graphics/Rect:left	I
    //   779: isub
    //   780: i2f
    //   781: fmul
    //   782: f2i
    //   783: aload_0
    //   784: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   787: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   790: aload_1
    //   791: getfield 85	android/graphics/Rect:top	I
    //   794: isub
    //   795: i2f
    //   796: fload 5
    //   798: fmul
    //   799: f2i
    //   800: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   803: astore_1
    //   804: goto -475 -> 329
    //   807: aload_0
    //   808: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   811: getfield 76	com/tencent/biz/widgets/ScannerView:u	I
    //   814: sipush 270
    //   817: if_icmpne +104 -> 921
    //   820: aload_0
    //   821: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   824: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   827: i2f
    //   828: aload_0
    //   829: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   832: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   835: i2f
    //   836: fdiv
    //   837: fstore 4
    //   839: aload_0
    //   840: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   843: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   846: i2f
    //   847: aload_0
    //   848: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   851: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   854: i2f
    //   855: fdiv
    //   856: fstore 5
    //   858: new 64	android/graphics/Rect
    //   861: dup
    //   862: aload_0
    //   863: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   866: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   869: aload_1
    //   870: getfield 91	android/graphics/Rect:bottom	I
    //   873: isub
    //   874: i2f
    //   875: fload 4
    //   877: fmul
    //   878: f2i
    //   879: aload_1
    //   880: getfield 94	android/graphics/Rect:left	I
    //   883: i2f
    //   884: fload 5
    //   886: fmul
    //   887: f2i
    //   888: fload 4
    //   890: aload_0
    //   891: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   894: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   897: aload_1
    //   898: getfield 85	android/graphics/Rect:top	I
    //   901: isub
    //   902: i2f
    //   903: fmul
    //   904: f2i
    //   905: aload_1
    //   906: getfield 88	android/graphics/Rect:right	I
    //   909: i2f
    //   910: fload 5
    //   912: fmul
    //   913: f2i
    //   914: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   917: astore_1
    //   918: goto -589 -> 329
    //   921: aload_0
    //   922: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   925: getfield 79	com/tencent/biz/widgets/ScannerView:o	I
    //   928: i2f
    //   929: aload_0
    //   930: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   933: getfield 67	com/tencent/biz/widgets/ScannerView:s	I
    //   936: i2f
    //   937: fdiv
    //   938: fstore 4
    //   940: aload_0
    //   941: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   944: getfield 82	com/tencent/biz/widgets/ScannerView:p	I
    //   947: i2f
    //   948: aload_0
    //   949: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   952: getfield 70	com/tencent/biz/widgets/ScannerView:t	I
    //   955: i2f
    //   956: fdiv
    //   957: fstore 5
    //   959: new 64	android/graphics/Rect
    //   962: dup
    //   963: aload_1
    //   964: getfield 94	android/graphics/Rect:left	I
    //   967: i2f
    //   968: fload 4
    //   970: fmul
    //   971: f2i
    //   972: aload_1
    //   973: getfield 85	android/graphics/Rect:top	I
    //   976: i2f
    //   977: fload 5
    //   979: fmul
    //   980: f2i
    //   981: fload 4
    //   983: aload_1
    //   984: getfield 88	android/graphics/Rect:right	I
    //   987: i2f
    //   988: fmul
    //   989: f2i
    //   990: aload_1
    //   991: getfield 91	android/graphics/Rect:bottom	I
    //   994: i2f
    //   995: fload 5
    //   997: fmul
    //   998: f2i
    //   999: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   1002: astore_1
    //   1003: goto -674 -> 329
    //   1006: astore_1
    //   1007: iconst_0
    //   1008: istore 6
    //   1010: iload 6
    //   1012: istore 7
    //   1014: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1017: ifeq -437 -> 580
    //   1020: getstatic 123	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1023: iconst_2
    //   1024: aload_1
    //   1025: invokevirtual 159	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1028: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1031: iload 6
    //   1033: istore 7
    //   1035: goto -455 -> 580
    //   1038: aload_0
    //   1039: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1042: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1045: iconst_2
    //   1046: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   1049: pop
    //   1050: return
    //   1051: iconst_m1
    //   1052: istore 6
    //   1054: iload 6
    //   1056: istore 7
    //   1058: iload 6
    //   1060: istore 8
    //   1062: iload 6
    //   1064: istore 9
    //   1066: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   1069: ifne +21 -> 1090
    //   1072: iload 6
    //   1074: istore 7
    //   1076: iload 6
    //   1078: istore 8
    //   1080: iload 6
    //   1082: istore 9
    //   1084: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   1087: ifeq +112 -> 1199
    //   1090: iload 6
    //   1092: istore 7
    //   1094: iload 6
    //   1096: istore 8
    //   1098: iload 6
    //   1100: istore 9
    //   1102: aload_0
    //   1103: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1106: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1109: bipush 10
    //   1111: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   1114: pop
    //   1115: return
    //   1116: astore_1
    //   1117: iload 7
    //   1119: istore 6
    //   1121: iload 6
    //   1123: istore 7
    //   1125: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1128: ifeq +18 -> 1146
    //   1131: getstatic 123	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1134: iconst_2
    //   1135: aload_1
    //   1136: invokevirtual 163	java/io/IOException:toString	()Ljava/lang/String;
    //   1139: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1142: iload 6
    //   1144: istore 7
    //   1146: iload 7
    //   1148: iconst_1
    //   1149: if_icmpne +2023 -> 3172
    //   1152: new 125	java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1159: astore_1
    //   1160: new 125	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1167: astore 16
    //   1169: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   1172: ifne +10 -> 1182
    //   1175: aload_1
    //   1176: aload 16
    //   1178: invokestatic 148	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   1181: pop
    //   1182: aload_0
    //   1183: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1186: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1189: iconst_3
    //   1190: aload 16
    //   1192: invokevirtual 152	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1195: invokevirtual 155	android/os/Message:sendToTarget	()V
    //   1198: return
    //   1199: iload 6
    //   1201: istore 7
    //   1203: iload 6
    //   1205: istore 8
    //   1207: iload 6
    //   1209: istore 9
    //   1211: aload_1
    //   1212: getfield 52	android/os/Message:obj	Ljava/lang/Object;
    //   1215: checkcast 165	android/net/Uri
    //   1218: astore 18
    //   1220: iload 6
    //   1222: istore 7
    //   1224: iload 6
    //   1226: istore 8
    //   1228: iload 6
    //   1230: istore 9
    //   1232: aload_0
    //   1233: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1236: invokevirtual 169	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   1239: invokevirtual 175	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1242: astore 19
    //   1244: iload 6
    //   1246: istore 7
    //   1248: iload 6
    //   1250: istore 8
    //   1252: iload 6
    //   1254: istore 9
    //   1256: new 177	android/graphics/BitmapFactory$Options
    //   1259: dup
    //   1260: invokespecial 178	android/graphics/BitmapFactory$Options:<init>	()V
    //   1263: astore 17
    //   1265: iload 6
    //   1267: istore 7
    //   1269: iload 6
    //   1271: istore 8
    //   1273: iload 6
    //   1275: istore 9
    //   1277: aload 17
    //   1279: iconst_1
    //   1280: putfield 181	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1283: iload 6
    //   1285: istore 7
    //   1287: iload 6
    //   1289: istore 8
    //   1291: iload 6
    //   1293: istore 9
    //   1295: aload 19
    //   1297: aload 18
    //   1299: invokevirtual 187	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1302: astore 16
    //   1304: iload 6
    //   1306: istore 7
    //   1308: iload 6
    //   1310: istore 8
    //   1312: iload 6
    //   1314: istore 9
    //   1316: aload 16
    //   1318: aconst_null
    //   1319: aload 17
    //   1321: invokestatic 193	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1324: pop
    //   1325: iload 6
    //   1327: istore 7
    //   1329: iload 6
    //   1331: istore 8
    //   1333: iload 6
    //   1335: istore 9
    //   1337: aload 16
    //   1339: invokevirtual 198	java/io/InputStream:close	()V
    //   1342: iload 6
    //   1344: istore 7
    //   1346: iload 6
    //   1348: istore 8
    //   1350: iload 6
    //   1352: istore 9
    //   1354: aload 17
    //   1356: getfield 201	android/graphics/BitmapFactory$Options:outWidth	I
    //   1359: istore 12
    //   1361: iload 6
    //   1363: istore 7
    //   1365: iload 6
    //   1367: istore 8
    //   1369: iload 6
    //   1371: istore 9
    //   1373: aload 17
    //   1375: getfield 204	android/graphics/BitmapFactory$Options:outHeight	I
    //   1378: istore 13
    //   1380: iload 6
    //   1382: istore 7
    //   1384: iload 6
    //   1386: istore 8
    //   1388: iload 6
    //   1390: istore 9
    //   1392: aload 17
    //   1394: iconst_0
    //   1395: putfield 181	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1398: iload 12
    //   1400: iload 13
    //   1402: imul
    //   1403: ldc 205
    //   1405: if_icmple +1094 -> 2499
    //   1408: iload 6
    //   1410: istore 7
    //   1412: iload 6
    //   1414: istore 8
    //   1416: iload 6
    //   1418: istore 9
    //   1420: aload 17
    //   1422: iload 12
    //   1424: iload 13
    //   1426: imul
    //   1427: i2d
    //   1428: invokestatic 211	java/lang/Math:sqrt	(D)D
    //   1431: ldc2_w 212
    //   1434: ddiv
    //   1435: invokestatic 216	java/lang/Math:ceil	(D)D
    //   1438: d2i
    //   1439: putfield 219	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1442: iload 6
    //   1444: istore 7
    //   1446: iload 6
    //   1448: istore 8
    //   1450: iload 6
    //   1452: istore 9
    //   1454: aload 19
    //   1456: aload 18
    //   1458: invokevirtual 187	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1461: astore_1
    //   1462: iload 6
    //   1464: istore 7
    //   1466: iload 6
    //   1468: istore 8
    //   1470: iload 6
    //   1472: istore 9
    //   1474: aload_1
    //   1475: aconst_null
    //   1476: aload 17
    //   1478: invokestatic 193	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1481: astore 20
    //   1483: iload 6
    //   1485: istore 7
    //   1487: iload 6
    //   1489: istore 8
    //   1491: iload 6
    //   1493: istore 9
    //   1495: aload_1
    //   1496: invokevirtual 198	java/io/InputStream:close	()V
    //   1499: iload 6
    //   1501: istore 7
    //   1503: iload 6
    //   1505: istore 8
    //   1507: iload 6
    //   1509: istore 9
    //   1511: aload 20
    //   1513: invokevirtual 224	android/graphics/Bitmap:getWidth	()I
    //   1516: istore 10
    //   1518: iload 6
    //   1520: istore 7
    //   1522: iload 6
    //   1524: istore 8
    //   1526: iload 6
    //   1528: istore 9
    //   1530: aload 20
    //   1532: invokevirtual 227	android/graphics/Bitmap:getHeight	()I
    //   1535: istore 11
    //   1537: iload 6
    //   1539: istore 7
    //   1541: iload 6
    //   1543: istore 8
    //   1545: iload 6
    //   1547: istore 9
    //   1549: iload 10
    //   1551: iload 11
    //   1553: imul
    //   1554: newarray int
    //   1556: astore 16
    //   1558: iload 6
    //   1560: istore 7
    //   1562: iload 6
    //   1564: istore 8
    //   1566: iload 6
    //   1568: istore 9
    //   1570: aload 20
    //   1572: aload 16
    //   1574: iconst_0
    //   1575: iload 10
    //   1577: iconst_0
    //   1578: iconst_0
    //   1579: iload 10
    //   1581: iload 11
    //   1583: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1586: iload 6
    //   1588: istore 7
    //   1590: iload 6
    //   1592: istore 8
    //   1594: iload 6
    //   1596: istore 9
    //   1598: aload 20
    //   1600: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   1603: iload 6
    //   1605: istore 7
    //   1607: iload 6
    //   1609: istore 8
    //   1611: iload 6
    //   1613: istore 9
    //   1615: iload 10
    //   1617: iload 11
    //   1619: imul
    //   1620: newarray byte
    //   1622: astore 20
    //   1624: iload 6
    //   1626: istore 7
    //   1628: iload 6
    //   1630: istore 8
    //   1632: iload 6
    //   1634: istore 9
    //   1636: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   1639: ifne +914 -> 2553
    //   1642: iload 6
    //   1644: istore 7
    //   1646: iload 6
    //   1648: istore 8
    //   1650: iload 6
    //   1652: istore 9
    //   1654: aload 16
    //   1656: aload 20
    //   1658: iload 10
    //   1660: iload 11
    //   1662: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1665: pop
    //   1666: iload 6
    //   1668: istore 7
    //   1670: iload 6
    //   1672: istore 8
    //   1674: iload 6
    //   1676: istore 9
    //   1678: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   1681: ifne +1609 -> 3290
    //   1684: iload 6
    //   1686: istore 7
    //   1688: iload 6
    //   1690: istore 8
    //   1692: iload 6
    //   1694: istore 9
    //   1696: aload 20
    //   1698: iload 10
    //   1700: iload 11
    //   1702: iconst_0
    //   1703: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1706: istore 10
    //   1708: iload 10
    //   1710: istore 6
    //   1712: aload_1
    //   1713: astore 16
    //   1715: iload 6
    //   1717: istore 7
    //   1719: iload 6
    //   1721: iconst_1
    //   1722: if_icmpeq +1382 -> 3104
    //   1725: iload 12
    //   1727: iconst_2
    //   1728: imul
    //   1729: iload 13
    //   1731: if_icmpgt +893 -> 2624
    //   1734: iload 12
    //   1736: sipush 1024
    //   1739: if_icmpge +885 -> 2624
    //   1742: iload 6
    //   1744: istore 8
    //   1746: iload 6
    //   1748: istore 9
    //   1750: iload 6
    //   1752: istore 10
    //   1754: aload 19
    //   1756: aload 18
    //   1758: invokevirtual 187	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1761: astore 16
    //   1763: iload 6
    //   1765: istore 8
    //   1767: iload 6
    //   1769: istore 9
    //   1771: iload 6
    //   1773: istore 10
    //   1775: iload 6
    //   1777: istore 11
    //   1779: aload 16
    //   1781: invokestatic 240	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1784: astore_1
    //   1785: iload 6
    //   1787: istore 8
    //   1789: iload 6
    //   1791: istore 9
    //   1793: iload 6
    //   1795: istore 10
    //   1797: iload 6
    //   1799: istore 11
    //   1801: aload 16
    //   1803: invokevirtual 198	java/io/InputStream:close	()V
    //   1806: iload 6
    //   1808: istore 8
    //   1810: iload 6
    //   1812: istore 9
    //   1814: iload 6
    //   1816: istore 10
    //   1818: iload 6
    //   1820: istore 11
    //   1822: iload 12
    //   1824: iload 12
    //   1826: imul
    //   1827: newarray int
    //   1829: astore 20
    //   1831: iload 6
    //   1833: istore 8
    //   1835: iload 6
    //   1837: istore 9
    //   1839: iload 6
    //   1841: istore 10
    //   1843: iload 6
    //   1845: istore 11
    //   1847: aload_1
    //   1848: aload 20
    //   1850: iconst_0
    //   1851: iload 12
    //   1853: iconst_0
    //   1854: iconst_0
    //   1855: iload 12
    //   1857: iload 12
    //   1859: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1862: iload 6
    //   1864: istore 8
    //   1866: iload 6
    //   1868: istore 9
    //   1870: iload 6
    //   1872: istore 10
    //   1874: iload 6
    //   1876: istore 11
    //   1878: iload 12
    //   1880: iload 12
    //   1882: imul
    //   1883: newarray byte
    //   1885: astore 21
    //   1887: iload 6
    //   1889: istore 8
    //   1891: iload 6
    //   1893: istore 9
    //   1895: iload 6
    //   1897: istore 10
    //   1899: iload 6
    //   1901: istore 11
    //   1903: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   1906: ifne +31 -> 1937
    //   1909: iload 6
    //   1911: istore 8
    //   1913: iload 6
    //   1915: istore 9
    //   1917: iload 6
    //   1919: istore 10
    //   1921: iload 6
    //   1923: istore 11
    //   1925: aload 20
    //   1927: aload 21
    //   1929: iload 12
    //   1931: iload 12
    //   1933: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1936: pop
    //   1937: iload 6
    //   1939: istore 7
    //   1941: iload 6
    //   1943: istore 8
    //   1945: iload 6
    //   1947: istore 9
    //   1949: iload 6
    //   1951: istore 10
    //   1953: iload 6
    //   1955: istore 11
    //   1957: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   1960: ifne +31 -> 1991
    //   1963: iload 6
    //   1965: istore 8
    //   1967: iload 6
    //   1969: istore 9
    //   1971: iload 6
    //   1973: istore 10
    //   1975: iload 6
    //   1977: istore 11
    //   1979: aload 21
    //   1981: iload 12
    //   1983: iload 12
    //   1985: iconst_0
    //   1986: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1989: istore 7
    //   1991: iload 7
    //   1993: iconst_1
    //   1994: if_icmpeq +1289 -> 3283
    //   1997: iload 7
    //   1999: istore 8
    //   2001: iload 7
    //   2003: istore 9
    //   2005: iload 7
    //   2007: istore 10
    //   2009: iload 7
    //   2011: istore 11
    //   2013: aload_1
    //   2014: aload 20
    //   2016: iconst_0
    //   2017: iload 12
    //   2019: iconst_0
    //   2020: iload 13
    //   2022: iload 12
    //   2024: isub
    //   2025: iload 12
    //   2027: iload 12
    //   2029: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2032: iload 7
    //   2034: istore 8
    //   2036: iload 7
    //   2038: istore 9
    //   2040: iload 7
    //   2042: istore 10
    //   2044: iload 7
    //   2046: istore 11
    //   2048: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   2051: ifne +31 -> 2082
    //   2054: iload 7
    //   2056: istore 8
    //   2058: iload 7
    //   2060: istore 9
    //   2062: iload 7
    //   2064: istore 10
    //   2066: iload 7
    //   2068: istore 11
    //   2070: aload 20
    //   2072: aload 21
    //   2074: iload 12
    //   2076: iload 12
    //   2078: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2081: pop
    //   2082: iload 7
    //   2084: istore 8
    //   2086: iload 7
    //   2088: istore 9
    //   2090: iload 7
    //   2092: istore 10
    //   2094: iload 7
    //   2096: istore 11
    //   2098: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   2101: ifne +1182 -> 3283
    //   2104: iload 7
    //   2106: istore 8
    //   2108: iload 7
    //   2110: istore 9
    //   2112: iload 7
    //   2114: istore 10
    //   2116: iload 7
    //   2118: istore 11
    //   2120: aload 21
    //   2122: iload 12
    //   2124: iload 12
    //   2126: iconst_0
    //   2127: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2130: istore 6
    //   2132: iload 6
    //   2134: istore 7
    //   2136: iload 6
    //   2138: istore 8
    //   2140: iload 6
    //   2142: istore 9
    //   2144: aload_1
    //   2145: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   2148: aload 16
    //   2150: astore_1
    //   2151: iload 6
    //   2153: istore 7
    //   2155: iload 6
    //   2157: iconst_1
    //   2158: if_icmpeq -1012 -> 1146
    //   2161: iload 6
    //   2163: istore 7
    //   2165: iload 6
    //   2167: istore 8
    //   2169: iload 6
    //   2171: istore 9
    //   2173: iload 12
    //   2175: iload 13
    //   2177: invokestatic 244	java/lang/Math:min	(II)I
    //   2180: istore 10
    //   2182: iload 6
    //   2184: istore 7
    //   2186: iload 10
    //   2188: sipush 250
    //   2191: if_icmple -1045 -> 1146
    //   2194: iload 6
    //   2196: istore 7
    //   2198: iload 6
    //   2200: istore 8
    //   2202: iload 6
    //   2204: istore 9
    //   2206: aload 17
    //   2208: iload 10
    //   2210: i2d
    //   2211: ldc2_w 245
    //   2214: ddiv
    //   2215: invokestatic 216	java/lang/Math:ceil	(D)D
    //   2218: d2i
    //   2219: putfield 219	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2222: iload 6
    //   2224: istore 7
    //   2226: iload 6
    //   2228: istore 8
    //   2230: iload 6
    //   2232: istore 9
    //   2234: aload 19
    //   2236: aload 18
    //   2238: invokevirtual 187	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2241: astore 16
    //   2243: iload 6
    //   2245: istore 7
    //   2247: iload 6
    //   2249: istore 8
    //   2251: iload 6
    //   2253: istore 9
    //   2255: aload 16
    //   2257: aconst_null
    //   2258: aload 17
    //   2260: invokestatic 193	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2263: astore 17
    //   2265: iload 6
    //   2267: istore 7
    //   2269: iload 6
    //   2271: istore 8
    //   2273: iload 6
    //   2275: istore 9
    //   2277: aload 16
    //   2279: invokevirtual 198	java/io/InputStream:close	()V
    //   2282: iload 6
    //   2284: istore 7
    //   2286: iload 6
    //   2288: istore 8
    //   2290: iload 6
    //   2292: istore 9
    //   2294: aload 17
    //   2296: invokevirtual 224	android/graphics/Bitmap:getWidth	()I
    //   2299: istore 10
    //   2301: iload 6
    //   2303: istore 7
    //   2305: iload 6
    //   2307: istore 8
    //   2309: iload 6
    //   2311: istore 9
    //   2313: aload 17
    //   2315: invokevirtual 227	android/graphics/Bitmap:getHeight	()I
    //   2318: istore 11
    //   2320: iload 6
    //   2322: istore 7
    //   2324: iload 6
    //   2326: istore 8
    //   2328: iload 6
    //   2330: istore 9
    //   2332: iload 10
    //   2334: iload 11
    //   2336: imul
    //   2337: newarray int
    //   2339: astore_1
    //   2340: iload 6
    //   2342: istore 7
    //   2344: iload 6
    //   2346: istore 8
    //   2348: iload 6
    //   2350: istore 9
    //   2352: aload 17
    //   2354: aload_1
    //   2355: iconst_0
    //   2356: iload 10
    //   2358: iconst_0
    //   2359: iconst_0
    //   2360: iload 10
    //   2362: iload 11
    //   2364: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2367: iload 6
    //   2369: istore 7
    //   2371: iload 6
    //   2373: istore 8
    //   2375: iload 6
    //   2377: istore 9
    //   2379: aload 17
    //   2381: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   2384: iload 6
    //   2386: istore 7
    //   2388: iload 6
    //   2390: istore 8
    //   2392: iload 6
    //   2394: istore 9
    //   2396: iload 10
    //   2398: iload 11
    //   2400: imul
    //   2401: newarray byte
    //   2403: astore 17
    //   2405: iload 6
    //   2407: istore 7
    //   2409: iload 6
    //   2411: istore 8
    //   2413: iload 6
    //   2415: istore 9
    //   2417: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   2420: ifne +26 -> 2446
    //   2423: iload 6
    //   2425: istore 7
    //   2427: iload 6
    //   2429: istore 8
    //   2431: iload 6
    //   2433: istore 9
    //   2435: aload_1
    //   2436: aload 17
    //   2438: iload 10
    //   2440: iload 11
    //   2442: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2445: pop
    //   2446: iload 6
    //   2448: istore 7
    //   2450: iload 6
    //   2452: istore 8
    //   2454: iload 6
    //   2456: istore 9
    //   2458: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   2461: ifne +819 -> 3280
    //   2464: iload 6
    //   2466: istore 7
    //   2468: iload 6
    //   2470: istore 8
    //   2472: iload 6
    //   2474: istore 9
    //   2476: aload 17
    //   2478: iload 10
    //   2480: iload 11
    //   2482: iconst_0
    //   2483: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2486: istore 10
    //   2488: iload 10
    //   2490: istore 6
    //   2492: iload 6
    //   2494: istore 7
    //   2496: goto -1350 -> 1146
    //   2499: iload 6
    //   2501: istore 7
    //   2503: iload 6
    //   2505: istore 8
    //   2507: iload 6
    //   2509: istore 9
    //   2511: aload 17
    //   2513: iconst_1
    //   2514: putfield 219	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2517: goto -1075 -> 1442
    //   2520: astore_1
    //   2521: iload 8
    //   2523: istore 6
    //   2525: iload 6
    //   2527: istore 7
    //   2529: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2532: ifeq -1386 -> 1146
    //   2535: getstatic 123	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2538: iconst_2
    //   2539: aload_1
    //   2540: invokevirtual 247	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   2543: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2546: iload 6
    //   2548: istore 7
    //   2550: goto -1404 -> 1146
    //   2553: iload 6
    //   2555: istore 7
    //   2557: iload 6
    //   2559: istore 8
    //   2561: iload 6
    //   2563: istore 9
    //   2565: aload_0
    //   2566: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   2569: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2572: bipush 10
    //   2574: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   2577: pop
    //   2578: return
    //   2579: astore 16
    //   2581: iload 6
    //   2583: istore 7
    //   2585: iload 6
    //   2587: istore 8
    //   2589: iload 6
    //   2591: istore 9
    //   2593: aload_1
    //   2594: invokevirtual 198	java/io/InputStream:close	()V
    //   2597: iconst_m1
    //   2598: istore 6
    //   2600: goto -888 -> 1712
    //   2603: astore 16
    //   2605: iload 6
    //   2607: istore 7
    //   2609: iload 6
    //   2611: istore 8
    //   2613: iload 6
    //   2615: istore 9
    //   2617: aload_1
    //   2618: invokevirtual 198	java/io/InputStream:close	()V
    //   2621: goto -470 -> 2151
    //   2624: aload_1
    //   2625: astore 16
    //   2627: iload 6
    //   2629: istore 7
    //   2631: iload 12
    //   2633: iload 13
    //   2635: iconst_2
    //   2636: imul
    //   2637: if_icmplt +467 -> 3104
    //   2640: aload_1
    //   2641: astore 16
    //   2643: iload 6
    //   2645: istore 7
    //   2647: iload 13
    //   2649: sipush 1024
    //   2652: if_icmpge +452 -> 3104
    //   2655: iload 6
    //   2657: istore 8
    //   2659: iload 6
    //   2661: istore 9
    //   2663: iload 6
    //   2665: istore 10
    //   2667: aload 19
    //   2669: aload 18
    //   2671: invokevirtual 187	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2674: astore 16
    //   2676: iload 6
    //   2678: istore 8
    //   2680: iload 6
    //   2682: istore 9
    //   2684: iload 6
    //   2686: istore 10
    //   2688: iload 6
    //   2690: istore 11
    //   2692: aload 16
    //   2694: invokestatic 240	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2697: astore_1
    //   2698: iload 6
    //   2700: istore 8
    //   2702: iload 6
    //   2704: istore 9
    //   2706: iload 6
    //   2708: istore 10
    //   2710: iload 6
    //   2712: istore 11
    //   2714: aload 16
    //   2716: invokevirtual 198	java/io/InputStream:close	()V
    //   2719: iload 6
    //   2721: istore 8
    //   2723: iload 6
    //   2725: istore 9
    //   2727: iload 6
    //   2729: istore 10
    //   2731: iload 6
    //   2733: istore 11
    //   2735: iload 13
    //   2737: iload 13
    //   2739: imul
    //   2740: newarray int
    //   2742: astore 20
    //   2744: iload 6
    //   2746: istore 8
    //   2748: iload 6
    //   2750: istore 9
    //   2752: iload 6
    //   2754: istore 10
    //   2756: iload 6
    //   2758: istore 11
    //   2760: aload_1
    //   2761: aload 20
    //   2763: iconst_0
    //   2764: iload 13
    //   2766: iconst_0
    //   2767: iconst_0
    //   2768: iload 13
    //   2770: iload 13
    //   2772: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2775: iload 6
    //   2777: istore 8
    //   2779: iload 6
    //   2781: istore 9
    //   2783: iload 6
    //   2785: istore 10
    //   2787: iload 6
    //   2789: istore 11
    //   2791: iload 13
    //   2793: iload 13
    //   2795: imul
    //   2796: newarray byte
    //   2798: astore 21
    //   2800: iload 6
    //   2802: istore 8
    //   2804: iload 6
    //   2806: istore 9
    //   2808: iload 6
    //   2810: istore 10
    //   2812: iload 6
    //   2814: istore 11
    //   2816: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   2819: ifne +31 -> 2850
    //   2822: iload 6
    //   2824: istore 8
    //   2826: iload 6
    //   2828: istore 9
    //   2830: iload 6
    //   2832: istore 10
    //   2834: iload 6
    //   2836: istore 11
    //   2838: aload 20
    //   2840: aload 21
    //   2842: iload 13
    //   2844: iload 13
    //   2846: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2849: pop
    //   2850: iload 6
    //   2852: istore 7
    //   2854: iload 6
    //   2856: istore 8
    //   2858: iload 6
    //   2860: istore 9
    //   2862: iload 6
    //   2864: istore 10
    //   2866: iload 6
    //   2868: istore 11
    //   2870: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   2873: ifne +31 -> 2904
    //   2876: iload 6
    //   2878: istore 8
    //   2880: iload 6
    //   2882: istore 9
    //   2884: iload 6
    //   2886: istore 10
    //   2888: iload 6
    //   2890: istore 11
    //   2892: aload 21
    //   2894: iload 13
    //   2896: iload 13
    //   2898: iconst_0
    //   2899: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2902: istore 7
    //   2904: iload 7
    //   2906: istore 6
    //   2908: iload 7
    //   2910: iconst_1
    //   2911: if_icmpeq +142 -> 3053
    //   2914: iload 7
    //   2916: istore 8
    //   2918: iload 7
    //   2920: istore 9
    //   2922: iload 7
    //   2924: istore 10
    //   2926: iload 7
    //   2928: istore 11
    //   2930: aload_1
    //   2931: aload 20
    //   2933: iconst_0
    //   2934: iload 13
    //   2936: iload 12
    //   2938: iload 13
    //   2940: isub
    //   2941: iconst_0
    //   2942: iload 13
    //   2944: iload 13
    //   2946: invokevirtual 231	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2949: iload 7
    //   2951: istore 8
    //   2953: iload 7
    //   2955: istore 9
    //   2957: iload 7
    //   2959: istore 10
    //   2961: iload 7
    //   2963: istore 11
    //   2965: getstatic 38	com/tencent/imageboost/ImgProcessScan:a	Z
    //   2968: ifne +31 -> 2999
    //   2971: iload 7
    //   2973: istore 8
    //   2975: iload 7
    //   2977: istore 9
    //   2979: iload 7
    //   2981: istore 10
    //   2983: iload 7
    //   2985: istore 11
    //   2987: aload 20
    //   2989: aload 21
    //   2991: iload 13
    //   2993: iload 13
    //   2995: invokestatic 237	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2998: pop
    //   2999: iload 7
    //   3001: istore 6
    //   3003: iload 7
    //   3005: istore 8
    //   3007: iload 7
    //   3009: istore 9
    //   3011: iload 7
    //   3013: istore 10
    //   3015: iload 7
    //   3017: istore 11
    //   3019: getstatic 35	com/tencent/qbar/QbarNative:a	Z
    //   3022: ifne +31 -> 3053
    //   3025: iload 7
    //   3027: istore 8
    //   3029: iload 7
    //   3031: istore 9
    //   3033: iload 7
    //   3035: istore 10
    //   3037: iload 7
    //   3039: istore 11
    //   3041: aload 21
    //   3043: iload 13
    //   3045: iload 13
    //   3047: iconst_0
    //   3048: invokestatic 114	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   3051: istore 6
    //   3053: iload 6
    //   3055: istore 8
    //   3057: iload 6
    //   3059: istore 9
    //   3061: iload 6
    //   3063: istore 10
    //   3065: iload 6
    //   3067: istore 11
    //   3069: aload_1
    //   3070: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   3073: aload 16
    //   3075: astore_1
    //   3076: goto -925 -> 2151
    //   3079: astore 16
    //   3081: iload 6
    //   3083: istore 8
    //   3085: iload 6
    //   3087: istore 9
    //   3089: iload 6
    //   3091: istore 10
    //   3093: aload_1
    //   3094: invokevirtual 198	java/io/InputStream:close	()V
    //   3097: iload 6
    //   3099: istore 7
    //   3101: aload_1
    //   3102: astore 16
    //   3104: iload 7
    //   3106: istore 6
    //   3108: aload 16
    //   3110: astore_1
    //   3111: goto -960 -> 2151
    //   3114: astore 16
    //   3116: iload 6
    //   3118: istore 7
    //   3120: iload 6
    //   3122: istore 8
    //   3124: iload 6
    //   3126: istore 9
    //   3128: aload_1
    //   3129: invokevirtual 198	java/io/InputStream:close	()V
    //   3132: iload 6
    //   3134: istore 7
    //   3136: goto -1990 -> 1146
    //   3139: astore_1
    //   3140: iload 9
    //   3142: istore 6
    //   3144: iload 6
    //   3146: istore 7
    //   3148: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3151: ifeq -2005 -> 1146
    //   3154: getstatic 123	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3157: iconst_2
    //   3158: aload_1
    //   3159: invokevirtual 159	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3162: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3165: iload 6
    //   3167: istore 7
    //   3169: goto -2023 -> 1146
    //   3172: aload_0
    //   3173: getfield 10	sw:a	Lcom/tencent/biz/widgets/ScannerView;
    //   3176: getfield 44	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3179: iconst_4
    //   3180: invokevirtual 48	android/os/Handler:sendEmptyMessage	(I)Z
    //   3183: pop
    //   3184: return
    //   3185: astore_1
    //   3186: iload 8
    //   3188: istore 6
    //   3190: goto -46 -> 3144
    //   3193: astore_1
    //   3194: iload 7
    //   3196: istore 6
    //   3198: goto -54 -> 3144
    //   3201: astore_1
    //   3202: iload 9
    //   3204: istore 6
    //   3206: goto -681 -> 2525
    //   3209: astore_1
    //   3210: iload 8
    //   3212: istore 6
    //   3214: goto -689 -> 2525
    //   3217: astore_1
    //   3218: iload 10
    //   3220: istore 6
    //   3222: goto -2101 -> 1121
    //   3225: astore_1
    //   3226: iload 9
    //   3228: istore 6
    //   3230: goto -2109 -> 1121
    //   3233: astore_1
    //   3234: aload 16
    //   3236: astore_1
    //   3237: goto -121 -> 3116
    //   3240: astore_1
    //   3241: aload 16
    //   3243: astore_1
    //   3244: iload 11
    //   3246: istore 6
    //   3248: goto -167 -> 3081
    //   3251: astore_1
    //   3252: aload 16
    //   3254: astore_1
    //   3255: iload 11
    //   3257: istore 6
    //   3259: goto -654 -> 2605
    //   3262: astore_1
    //   3263: aload 16
    //   3265: astore_1
    //   3266: goto -661 -> 2605
    //   3269: astore_1
    //   3270: aload 16
    //   3272: astore_1
    //   3273: goto -692 -> 2581
    //   3276: astore_1
    //   3277: goto -2267 -> 1010
    //   3280: goto -788 -> 2492
    //   3283: iload 7
    //   3285: istore 6
    //   3287: goto -1155 -> 2132
    //   3290: iconst_m1
    //   3291: istore 6
    //   3293: goto -1581 -> 1712
    //   3296: iconst_0
    //   3297: istore 6
    //   3299: goto -2767 -> 532
    //   3302: goto -2965 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3305	0	this	sw
    //   0	3305	1	paramMessage	android.os.Message
    //   539	28	2	d	double
    //   248	734	4	f1	float
    //   267	729	5	f2	float
    //   117	3181	6	i	int
    //   121	3163	7	j	int
    //   109	3102	8	k	int
    //   114	3113	9	m	int
    //   1516	1703	10	n	int
    //   1535	1721	11	i1	int
    //   1359	1582	12	i2	int
    //   1378	1668	13	i3	int
    //   340	196	14	l	long
    //   169	2109	16	localObject1	java.lang.Object
    //   2579	1	16	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2603	1	16	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2625	449	16	localObject2	java.lang.Object
    //   3079	1	16	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3102	7	16	localMessage	android.os.Message
    //   3114	157	16	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   95	2417	17	localObject3	java.lang.Object
    //   362	2308	18	localObject4	java.lang.Object
    //   1242	1426	19	localContentResolver	android.content.ContentResolver
    //   1481	1507	20	localObject5	java.lang.Object
    //   1885	1157	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   337	532	1006	java/lang/UnsatisfiedLinkError
    //   1066	1072	1116	java/io/IOException
    //   1084	1090	1116	java/io/IOException
    //   1102	1115	1116	java/io/IOException
    //   1211	1220	1116	java/io/IOException
    //   1232	1244	1116	java/io/IOException
    //   1256	1265	1116	java/io/IOException
    //   1277	1283	1116	java/io/IOException
    //   1295	1304	1116	java/io/IOException
    //   1316	1325	1116	java/io/IOException
    //   1337	1342	1116	java/io/IOException
    //   1354	1361	1116	java/io/IOException
    //   1373	1380	1116	java/io/IOException
    //   1392	1398	1116	java/io/IOException
    //   1420	1442	1116	java/io/IOException
    //   1454	1462	1116	java/io/IOException
    //   1474	1483	1116	java/io/IOException
    //   1495	1499	1116	java/io/IOException
    //   1511	1518	1116	java/io/IOException
    //   1530	1537	1116	java/io/IOException
    //   1549	1558	1116	java/io/IOException
    //   1570	1586	1116	java/io/IOException
    //   1598	1603	1116	java/io/IOException
    //   1615	1624	1116	java/io/IOException
    //   1636	1642	1116	java/io/IOException
    //   1654	1666	1116	java/io/IOException
    //   1678	1684	1116	java/io/IOException
    //   1696	1708	1116	java/io/IOException
    //   2173	2182	1116	java/io/IOException
    //   2206	2222	1116	java/io/IOException
    //   2234	2243	1116	java/io/IOException
    //   2255	2265	1116	java/io/IOException
    //   2277	2282	1116	java/io/IOException
    //   2294	2301	1116	java/io/IOException
    //   2313	2320	1116	java/io/IOException
    //   2332	2340	1116	java/io/IOException
    //   2352	2367	1116	java/io/IOException
    //   2379	2384	1116	java/io/IOException
    //   2396	2405	1116	java/io/IOException
    //   2417	2423	1116	java/io/IOException
    //   2435	2446	1116	java/io/IOException
    //   2458	2464	1116	java/io/IOException
    //   2476	2488	1116	java/io/IOException
    //   2511	2517	1116	java/io/IOException
    //   2565	2578	1116	java/io/IOException
    //   2593	2597	1116	java/io/IOException
    //   3128	3132	1116	java/io/IOException
    //   1066	1072	2520	java/lang/RuntimeException
    //   1084	1090	2520	java/lang/RuntimeException
    //   1102	1115	2520	java/lang/RuntimeException
    //   1211	1220	2520	java/lang/RuntimeException
    //   1232	1244	2520	java/lang/RuntimeException
    //   1256	1265	2520	java/lang/RuntimeException
    //   1277	1283	2520	java/lang/RuntimeException
    //   1295	1304	2520	java/lang/RuntimeException
    //   1316	1325	2520	java/lang/RuntimeException
    //   1337	1342	2520	java/lang/RuntimeException
    //   1354	1361	2520	java/lang/RuntimeException
    //   1373	1380	2520	java/lang/RuntimeException
    //   1392	1398	2520	java/lang/RuntimeException
    //   1420	1442	2520	java/lang/RuntimeException
    //   1454	1462	2520	java/lang/RuntimeException
    //   1474	1483	2520	java/lang/RuntimeException
    //   1495	1499	2520	java/lang/RuntimeException
    //   1511	1518	2520	java/lang/RuntimeException
    //   1530	1537	2520	java/lang/RuntimeException
    //   1549	1558	2520	java/lang/RuntimeException
    //   1570	1586	2520	java/lang/RuntimeException
    //   1598	1603	2520	java/lang/RuntimeException
    //   1615	1624	2520	java/lang/RuntimeException
    //   1636	1642	2520	java/lang/RuntimeException
    //   1654	1666	2520	java/lang/RuntimeException
    //   1678	1684	2520	java/lang/RuntimeException
    //   1696	1708	2520	java/lang/RuntimeException
    //   2173	2182	2520	java/lang/RuntimeException
    //   2206	2222	2520	java/lang/RuntimeException
    //   2234	2243	2520	java/lang/RuntimeException
    //   2255	2265	2520	java/lang/RuntimeException
    //   2277	2282	2520	java/lang/RuntimeException
    //   2294	2301	2520	java/lang/RuntimeException
    //   2313	2320	2520	java/lang/RuntimeException
    //   2332	2340	2520	java/lang/RuntimeException
    //   2352	2367	2520	java/lang/RuntimeException
    //   2379	2384	2520	java/lang/RuntimeException
    //   2396	2405	2520	java/lang/RuntimeException
    //   2417	2423	2520	java/lang/RuntimeException
    //   2435	2446	2520	java/lang/RuntimeException
    //   2458	2464	2520	java/lang/RuntimeException
    //   2476	2488	2520	java/lang/RuntimeException
    //   2511	2517	2520	java/lang/RuntimeException
    //   2565	2578	2520	java/lang/RuntimeException
    //   2593	2597	2520	java/lang/RuntimeException
    //   3128	3132	2520	java/lang/RuntimeException
    //   1474	1483	2579	java/lang/OutOfMemoryError
    //   1495	1499	2579	java/lang/OutOfMemoryError
    //   1511	1518	2579	java/lang/OutOfMemoryError
    //   1530	1537	2579	java/lang/OutOfMemoryError
    //   1549	1558	2579	java/lang/OutOfMemoryError
    //   1570	1586	2579	java/lang/OutOfMemoryError
    //   1598	1603	2579	java/lang/OutOfMemoryError
    //   1615	1624	2579	java/lang/OutOfMemoryError
    //   1636	1642	2579	java/lang/OutOfMemoryError
    //   1654	1666	2579	java/lang/OutOfMemoryError
    //   1678	1684	2579	java/lang/OutOfMemoryError
    //   1696	1708	2579	java/lang/OutOfMemoryError
    //   2565	2578	2579	java/lang/OutOfMemoryError
    //   1754	1763	2603	java/lang/OutOfMemoryError
    //   2667	2676	3079	java/lang/OutOfMemoryError
    //   2234	2243	3114	java/lang/OutOfMemoryError
    //   1066	1072	3139	java/lang/UnsatisfiedLinkError
    //   1084	1090	3139	java/lang/UnsatisfiedLinkError
    //   1102	1115	3139	java/lang/UnsatisfiedLinkError
    //   1211	1220	3139	java/lang/UnsatisfiedLinkError
    //   1232	1244	3139	java/lang/UnsatisfiedLinkError
    //   1256	1265	3139	java/lang/UnsatisfiedLinkError
    //   1277	1283	3139	java/lang/UnsatisfiedLinkError
    //   1295	1304	3139	java/lang/UnsatisfiedLinkError
    //   1316	1325	3139	java/lang/UnsatisfiedLinkError
    //   1337	1342	3139	java/lang/UnsatisfiedLinkError
    //   1354	1361	3139	java/lang/UnsatisfiedLinkError
    //   1373	1380	3139	java/lang/UnsatisfiedLinkError
    //   1392	1398	3139	java/lang/UnsatisfiedLinkError
    //   1420	1442	3139	java/lang/UnsatisfiedLinkError
    //   1454	1462	3139	java/lang/UnsatisfiedLinkError
    //   1474	1483	3139	java/lang/UnsatisfiedLinkError
    //   1495	1499	3139	java/lang/UnsatisfiedLinkError
    //   1511	1518	3139	java/lang/UnsatisfiedLinkError
    //   1530	1537	3139	java/lang/UnsatisfiedLinkError
    //   1549	1558	3139	java/lang/UnsatisfiedLinkError
    //   1570	1586	3139	java/lang/UnsatisfiedLinkError
    //   1598	1603	3139	java/lang/UnsatisfiedLinkError
    //   1615	1624	3139	java/lang/UnsatisfiedLinkError
    //   1636	1642	3139	java/lang/UnsatisfiedLinkError
    //   1654	1666	3139	java/lang/UnsatisfiedLinkError
    //   1678	1684	3139	java/lang/UnsatisfiedLinkError
    //   1696	1708	3139	java/lang/UnsatisfiedLinkError
    //   2173	2182	3139	java/lang/UnsatisfiedLinkError
    //   2206	2222	3139	java/lang/UnsatisfiedLinkError
    //   2234	2243	3139	java/lang/UnsatisfiedLinkError
    //   2255	2265	3139	java/lang/UnsatisfiedLinkError
    //   2277	2282	3139	java/lang/UnsatisfiedLinkError
    //   2294	2301	3139	java/lang/UnsatisfiedLinkError
    //   2313	2320	3139	java/lang/UnsatisfiedLinkError
    //   2332	2340	3139	java/lang/UnsatisfiedLinkError
    //   2352	2367	3139	java/lang/UnsatisfiedLinkError
    //   2379	2384	3139	java/lang/UnsatisfiedLinkError
    //   2396	2405	3139	java/lang/UnsatisfiedLinkError
    //   2417	2423	3139	java/lang/UnsatisfiedLinkError
    //   2435	2446	3139	java/lang/UnsatisfiedLinkError
    //   2458	2464	3139	java/lang/UnsatisfiedLinkError
    //   2476	2488	3139	java/lang/UnsatisfiedLinkError
    //   2511	2517	3139	java/lang/UnsatisfiedLinkError
    //   2565	2578	3139	java/lang/UnsatisfiedLinkError
    //   2593	2597	3139	java/lang/UnsatisfiedLinkError
    //   3128	3132	3139	java/lang/UnsatisfiedLinkError
    //   1754	1763	3185	java/lang/UnsatisfiedLinkError
    //   1779	1785	3185	java/lang/UnsatisfiedLinkError
    //   1801	1806	3185	java/lang/UnsatisfiedLinkError
    //   1822	1831	3185	java/lang/UnsatisfiedLinkError
    //   1847	1862	3185	java/lang/UnsatisfiedLinkError
    //   1878	1887	3185	java/lang/UnsatisfiedLinkError
    //   1903	1909	3185	java/lang/UnsatisfiedLinkError
    //   1925	1937	3185	java/lang/UnsatisfiedLinkError
    //   1957	1963	3185	java/lang/UnsatisfiedLinkError
    //   1979	1991	3185	java/lang/UnsatisfiedLinkError
    //   2013	2032	3185	java/lang/UnsatisfiedLinkError
    //   2048	2054	3185	java/lang/UnsatisfiedLinkError
    //   2070	2082	3185	java/lang/UnsatisfiedLinkError
    //   2098	2104	3185	java/lang/UnsatisfiedLinkError
    //   2120	2132	3185	java/lang/UnsatisfiedLinkError
    //   2667	2676	3185	java/lang/UnsatisfiedLinkError
    //   2692	2698	3185	java/lang/UnsatisfiedLinkError
    //   2714	2719	3185	java/lang/UnsatisfiedLinkError
    //   2735	2744	3185	java/lang/UnsatisfiedLinkError
    //   2760	2775	3185	java/lang/UnsatisfiedLinkError
    //   2791	2800	3185	java/lang/UnsatisfiedLinkError
    //   2816	2822	3185	java/lang/UnsatisfiedLinkError
    //   2838	2850	3185	java/lang/UnsatisfiedLinkError
    //   2870	2876	3185	java/lang/UnsatisfiedLinkError
    //   2892	2904	3185	java/lang/UnsatisfiedLinkError
    //   2930	2949	3185	java/lang/UnsatisfiedLinkError
    //   2965	2971	3185	java/lang/UnsatisfiedLinkError
    //   2987	2999	3185	java/lang/UnsatisfiedLinkError
    //   3019	3025	3185	java/lang/UnsatisfiedLinkError
    //   3041	3053	3185	java/lang/UnsatisfiedLinkError
    //   3069	3073	3185	java/lang/UnsatisfiedLinkError
    //   3093	3097	3185	java/lang/UnsatisfiedLinkError
    //   2144	2148	3193	java/lang/UnsatisfiedLinkError
    //   2617	2621	3193	java/lang/UnsatisfiedLinkError
    //   1754	1763	3201	java/lang/RuntimeException
    //   1779	1785	3201	java/lang/RuntimeException
    //   1801	1806	3201	java/lang/RuntimeException
    //   1822	1831	3201	java/lang/RuntimeException
    //   1847	1862	3201	java/lang/RuntimeException
    //   1878	1887	3201	java/lang/RuntimeException
    //   1903	1909	3201	java/lang/RuntimeException
    //   1925	1937	3201	java/lang/RuntimeException
    //   1957	1963	3201	java/lang/RuntimeException
    //   1979	1991	3201	java/lang/RuntimeException
    //   2013	2032	3201	java/lang/RuntimeException
    //   2048	2054	3201	java/lang/RuntimeException
    //   2070	2082	3201	java/lang/RuntimeException
    //   2098	2104	3201	java/lang/RuntimeException
    //   2120	2132	3201	java/lang/RuntimeException
    //   2667	2676	3201	java/lang/RuntimeException
    //   2692	2698	3201	java/lang/RuntimeException
    //   2714	2719	3201	java/lang/RuntimeException
    //   2735	2744	3201	java/lang/RuntimeException
    //   2760	2775	3201	java/lang/RuntimeException
    //   2791	2800	3201	java/lang/RuntimeException
    //   2816	2822	3201	java/lang/RuntimeException
    //   2838	2850	3201	java/lang/RuntimeException
    //   2870	2876	3201	java/lang/RuntimeException
    //   2892	2904	3201	java/lang/RuntimeException
    //   2930	2949	3201	java/lang/RuntimeException
    //   2965	2971	3201	java/lang/RuntimeException
    //   2987	2999	3201	java/lang/RuntimeException
    //   3019	3025	3201	java/lang/RuntimeException
    //   3041	3053	3201	java/lang/RuntimeException
    //   3069	3073	3201	java/lang/RuntimeException
    //   3093	3097	3201	java/lang/RuntimeException
    //   2144	2148	3209	java/lang/RuntimeException
    //   2617	2621	3209	java/lang/RuntimeException
    //   1754	1763	3217	java/io/IOException
    //   1779	1785	3217	java/io/IOException
    //   1801	1806	3217	java/io/IOException
    //   1822	1831	3217	java/io/IOException
    //   1847	1862	3217	java/io/IOException
    //   1878	1887	3217	java/io/IOException
    //   1903	1909	3217	java/io/IOException
    //   1925	1937	3217	java/io/IOException
    //   1957	1963	3217	java/io/IOException
    //   1979	1991	3217	java/io/IOException
    //   2013	2032	3217	java/io/IOException
    //   2048	2054	3217	java/io/IOException
    //   2070	2082	3217	java/io/IOException
    //   2098	2104	3217	java/io/IOException
    //   2120	2132	3217	java/io/IOException
    //   2667	2676	3217	java/io/IOException
    //   2692	2698	3217	java/io/IOException
    //   2714	2719	3217	java/io/IOException
    //   2735	2744	3217	java/io/IOException
    //   2760	2775	3217	java/io/IOException
    //   2791	2800	3217	java/io/IOException
    //   2816	2822	3217	java/io/IOException
    //   2838	2850	3217	java/io/IOException
    //   2870	2876	3217	java/io/IOException
    //   2892	2904	3217	java/io/IOException
    //   2930	2949	3217	java/io/IOException
    //   2965	2971	3217	java/io/IOException
    //   2987	2999	3217	java/io/IOException
    //   3019	3025	3217	java/io/IOException
    //   3041	3053	3217	java/io/IOException
    //   3069	3073	3217	java/io/IOException
    //   3093	3097	3217	java/io/IOException
    //   2144	2148	3225	java/io/IOException
    //   2617	2621	3225	java/io/IOException
    //   2255	2265	3233	java/lang/OutOfMemoryError
    //   2277	2282	3233	java/lang/OutOfMemoryError
    //   2294	2301	3233	java/lang/OutOfMemoryError
    //   2313	2320	3233	java/lang/OutOfMemoryError
    //   2332	2340	3233	java/lang/OutOfMemoryError
    //   2352	2367	3233	java/lang/OutOfMemoryError
    //   2379	2384	3233	java/lang/OutOfMemoryError
    //   2396	2405	3233	java/lang/OutOfMemoryError
    //   2417	2423	3233	java/lang/OutOfMemoryError
    //   2435	2446	3233	java/lang/OutOfMemoryError
    //   2458	2464	3233	java/lang/OutOfMemoryError
    //   2476	2488	3233	java/lang/OutOfMemoryError
    //   2692	2698	3240	java/lang/OutOfMemoryError
    //   2714	2719	3240	java/lang/OutOfMemoryError
    //   2735	2744	3240	java/lang/OutOfMemoryError
    //   2760	2775	3240	java/lang/OutOfMemoryError
    //   2791	2800	3240	java/lang/OutOfMemoryError
    //   2816	2822	3240	java/lang/OutOfMemoryError
    //   2838	2850	3240	java/lang/OutOfMemoryError
    //   2870	2876	3240	java/lang/OutOfMemoryError
    //   2892	2904	3240	java/lang/OutOfMemoryError
    //   2930	2949	3240	java/lang/OutOfMemoryError
    //   2965	2971	3240	java/lang/OutOfMemoryError
    //   2987	2999	3240	java/lang/OutOfMemoryError
    //   3019	3025	3240	java/lang/OutOfMemoryError
    //   3041	3053	3240	java/lang/OutOfMemoryError
    //   3069	3073	3240	java/lang/OutOfMemoryError
    //   1779	1785	3251	java/lang/OutOfMemoryError
    //   1801	1806	3251	java/lang/OutOfMemoryError
    //   1822	1831	3251	java/lang/OutOfMemoryError
    //   1847	1862	3251	java/lang/OutOfMemoryError
    //   1878	1887	3251	java/lang/OutOfMemoryError
    //   1903	1909	3251	java/lang/OutOfMemoryError
    //   1925	1937	3251	java/lang/OutOfMemoryError
    //   1957	1963	3251	java/lang/OutOfMemoryError
    //   1979	1991	3251	java/lang/OutOfMemoryError
    //   2013	2032	3251	java/lang/OutOfMemoryError
    //   2048	2054	3251	java/lang/OutOfMemoryError
    //   2070	2082	3251	java/lang/OutOfMemoryError
    //   2098	2104	3251	java/lang/OutOfMemoryError
    //   2120	2132	3251	java/lang/OutOfMemoryError
    //   2144	2148	3262	java/lang/OutOfMemoryError
    //   1454	1462	3269	java/lang/OutOfMemoryError
    //   532	540	3276	java/lang/UnsatisfiedLinkError
    //   544	576	3276	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     sw
 * JD-Core Version:    0.7.0.1
 */