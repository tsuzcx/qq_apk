import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;

public class xeu
  extends Handler
{
  public xeu(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 26	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 5:+25->29, 6:+1149->1153
    //   29: aload_0
    //   30: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   33: astore 12
    //   35: aload 12
    //   37: aload 12
    //   39: getfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   42: lconst_1
    //   43: ladd
    //   44: putfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   47: aload_1
    //   48: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   51: ifnull +13 -> 64
    //   54: aload_1
    //   55: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   58: instanceof 38
    //   61: ifne +16 -> 77
    //   64: aload_0
    //   65: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   68: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   71: iconst_2
    //   72: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   75: pop
    //   76: return
    //   77: aload_1
    //   78: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   81: checkcast 38	[B
    //   84: checkcast 38	[B
    //   87: astore 13
    //   89: aload_0
    //   90: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   93: getfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   96: iconst_3
    //   97: if_icmpge +49 -> 146
    //   100: iconst_0
    //   101: istore 8
    //   103: aload 13
    //   105: arraylength
    //   106: istore 9
    //   108: iconst_0
    //   109: istore 6
    //   111: iload 8
    //   113: istore 7
    //   115: iload 6
    //   117: iload 9
    //   119: if_icmpge +14 -> 133
    //   122: aload 13
    //   124: iload 6
    //   126: baload
    //   127: ifeq +578 -> 705
    //   130: iconst_1
    //   131: istore 7
    //   133: iload 7
    //   135: ifeq +579 -> 714
    //   138: aload_0
    //   139: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   142: iconst_3
    //   143: putfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   146: aload_0
    //   147: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   150: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   158: getfield 53	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   161: astore 12
    //   163: aload_1
    //   164: ifnonnull +1069 -> 1233
    //   167: aload 12
    //   169: astore_1
    //   170: aload 12
    //   172: ifnonnull +39 -> 211
    //   175: aload_0
    //   176: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   179: astore 12
    //   181: new 55	android/graphics/Rect
    //   184: dup
    //   185: iconst_0
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   191: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   194: aload_0
    //   195: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   198: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   201: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   204: astore_1
    //   205: aload 12
    //   207: aload_1
    //   208: putfield 53	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   211: aload_0
    //   212: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   215: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   218: bipush 90
    //   220: if_icmpne +535 -> 755
    //   223: aload_0
    //   224: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   227: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   230: i2f
    //   231: aload_0
    //   232: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   235: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   238: i2f
    //   239: fdiv
    //   240: fstore 4
    //   242: aload_0
    //   243: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   246: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   249: i2f
    //   250: aload_0
    //   251: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   254: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   257: i2f
    //   258: fdiv
    //   259: fstore 5
    //   261: new 55	android/graphics/Rect
    //   264: dup
    //   265: aload_1
    //   266: getfield 74	android/graphics/Rect:top	I
    //   269: i2f
    //   270: fload 4
    //   272: fmul
    //   273: f2i
    //   274: aload_0
    //   275: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   278: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   281: aload_1
    //   282: getfield 77	android/graphics/Rect:right	I
    //   285: isub
    //   286: i2f
    //   287: fload 5
    //   289: fmul
    //   290: f2i
    //   291: fload 4
    //   293: aload_1
    //   294: getfield 80	android/graphics/Rect:bottom	I
    //   297: i2f
    //   298: fmul
    //   299: f2i
    //   300: aload_0
    //   301: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   304: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   307: aload_1
    //   308: getfield 83	android/graphics/Rect:left	I
    //   311: isub
    //   312: i2f
    //   313: fload 5
    //   315: fmul
    //   316: f2i
    //   317: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   325: aload_1
    //   326: putfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   329: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   332: lstore 10
    //   334: iconst_2
    //   335: newarray int
    //   337: astore 14
    //   339: aload_1
    //   340: invokevirtual 93	android/graphics/Rect:width	()I
    //   343: aload_1
    //   344: invokevirtual 96	android/graphics/Rect:height	()I
    //   347: imul
    //   348: iconst_3
    //   349: imul
    //   350: iconst_1
    //   351: ishr
    //   352: newarray byte
    //   354: astore 12
    //   356: aload 12
    //   358: ifnull +869 -> 1227
    //   361: aload_0
    //   362: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   365: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   368: ifle +859 -> 1227
    //   371: aload_0
    //   372: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   375: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   378: ifle +849 -> 1227
    //   381: aload_1
    //   382: getfield 83	android/graphics/Rect:left	I
    //   385: iflt +842 -> 1227
    //   388: aload_1
    //   389: getfield 74	android/graphics/Rect:top	I
    //   392: iflt +835 -> 1227
    //   395: aload_1
    //   396: invokevirtual 93	android/graphics/Rect:width	()I
    //   399: ifle +828 -> 1227
    //   402: aload_1
    //   403: invokevirtual 96	android/graphics/Rect:height	()I
    //   406: ifle +821 -> 1227
    //   409: aload_1
    //   410: getfield 77	android/graphics/Rect:right	I
    //   413: aload_0
    //   414: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   417: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   420: if_icmpgt +807 -> 1227
    //   423: aload_1
    //   424: getfield 80	android/graphics/Rect:bottom	I
    //   427: aload_0
    //   428: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   431: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   434: if_icmpgt +793 -> 1227
    //   437: aload 13
    //   439: arraylength
    //   440: aload_0
    //   441: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   444: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   447: aload_0
    //   448: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   451: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   454: imul
    //   455: iconst_3
    //   456: imul
    //   457: iconst_1
    //   458: ishr
    //   459: if_icmpne +768 -> 1227
    //   462: aload 12
    //   464: aload 14
    //   466: aload 13
    //   468: aload_0
    //   469: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   472: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   475: aload_0
    //   476: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   479: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   482: aload_1
    //   483: getfield 83	android/graphics/Rect:left	I
    //   486: aload_1
    //   487: getfield 74	android/graphics/Rect:top	I
    //   490: aload_1
    //   491: invokevirtual 93	android/graphics/Rect:width	()I
    //   494: aload_1
    //   495: invokevirtual 96	android/graphics/Rect:height	()I
    //   498: aload_0
    //   499: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   502: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   505: iconst_0
    //   506: invokestatic 102	com/tencent/imageboost/ImgProcessScan:gray_rotate_crop_sub	([B[I[BIIIIIIII)I
    //   509: iconst_1
    //   510: if_icmpne +717 -> 1227
    //   513: aload 12
    //   515: aload 14
    //   517: iconst_0
    //   518: iaload
    //   519: aload 14
    //   521: iconst_1
    //   522: iaload
    //   523: iconst_0
    //   524: invokestatic 107	bcof:b	([BIII)I
    //   527: istore 6
    //   529: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   532: lload 10
    //   534: lsub
    //   535: l2d
    //   536: dstore_2
    //   537: iload 6
    //   539: istore 7
    //   541: invokestatic 113	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   544: ifeq +32 -> 576
    //   547: ldc 115
    //   549: iconst_4
    //   550: new 117	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   557: ldc 122
    //   559: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: dload_2
    //   563: invokevirtual 129	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   566: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: iload 6
    //   574: istore 7
    //   576: iload 7
    //   578: iconst_1
    //   579: if_icmpne +561 -> 1140
    //   582: new 117	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   589: astore_1
    //   590: new 117	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   597: astore 12
    //   599: aload_1
    //   600: aload 12
    //   602: invokestatic 140	bcof:b	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   605: pop
    //   606: aconst_null
    //   607: ldc 142
    //   609: ldc 144
    //   611: ldc 146
    //   613: ldc 148
    //   615: ldc 150
    //   617: iconst_0
    //   618: iconst_0
    //   619: new 117	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   626: ldc 146
    //   628: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   634: aload_0
    //   635: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   638: getfield 152	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Long	J
    //   641: lsub
    //   642: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   645: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: new 117	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   655: ldc 146
    //   657: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_0
    //   661: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   664: getfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   667: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   670: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: ldc 146
    //   675: ldc 146
    //   677: invokestatic 160	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload_0
    //   681: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   684: aload_1
    //   685: putfield 163	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   688: aload_0
    //   689: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   692: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   695: iconst_1
    //   696: aload 12
    //   698: invokevirtual 167	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   701: invokevirtual 170	android/os/Message:sendToTarget	()V
    //   704: return
    //   705: iload 6
    //   707: iconst_1
    //   708: iadd
    //   709: istore 6
    //   711: goto -600 -> 111
    //   714: aload_0
    //   715: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   718: astore_1
    //   719: aload_1
    //   720: getfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   723: iconst_1
    //   724: iadd
    //   725: istore 6
    //   727: aload_1
    //   728: iload 6
    //   730: putfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   733: iload 6
    //   735: iconst_3
    //   736: if_icmpne -590 -> 146
    //   739: aload_0
    //   740: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   743: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   746: bipush 9
    //   748: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   751: pop
    //   752: goto -606 -> 146
    //   755: aload_0
    //   756: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   759: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   762: sipush 180
    //   765: if_icmpne +120 -> 885
    //   768: aload_0
    //   769: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   772: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   775: i2f
    //   776: aload_0
    //   777: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   780: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   783: i2f
    //   784: fdiv
    //   785: fstore 4
    //   787: aload_0
    //   788: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   791: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   794: i2f
    //   795: aload_0
    //   796: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   799: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   802: i2f
    //   803: fdiv
    //   804: fstore 5
    //   806: new 55	android/graphics/Rect
    //   809: dup
    //   810: aload_0
    //   811: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   814: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   817: aload_1
    //   818: getfield 77	android/graphics/Rect:right	I
    //   821: isub
    //   822: i2f
    //   823: fload 4
    //   825: fmul
    //   826: f2i
    //   827: aload_0
    //   828: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   831: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   834: aload_1
    //   835: getfield 80	android/graphics/Rect:bottom	I
    //   838: isub
    //   839: i2f
    //   840: fload 5
    //   842: fmul
    //   843: f2i
    //   844: fload 4
    //   846: aload_0
    //   847: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   850: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   853: aload_1
    //   854: getfield 83	android/graphics/Rect:left	I
    //   857: isub
    //   858: i2f
    //   859: fmul
    //   860: f2i
    //   861: aload_0
    //   862: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   865: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   868: aload_1
    //   869: getfield 74	android/graphics/Rect:top	I
    //   872: isub
    //   873: i2f
    //   874: fload 5
    //   876: fmul
    //   877: f2i
    //   878: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   881: astore_1
    //   882: goto -561 -> 321
    //   885: aload_0
    //   886: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   889: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   892: sipush 270
    //   895: if_icmpne +104 -> 999
    //   898: aload_0
    //   899: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   902: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   905: i2f
    //   906: aload_0
    //   907: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   910: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   913: i2f
    //   914: fdiv
    //   915: fstore 4
    //   917: aload_0
    //   918: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   921: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   924: i2f
    //   925: aload_0
    //   926: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   929: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   932: i2f
    //   933: fdiv
    //   934: fstore 5
    //   936: new 55	android/graphics/Rect
    //   939: dup
    //   940: aload_0
    //   941: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   944: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   947: aload_1
    //   948: getfield 80	android/graphics/Rect:bottom	I
    //   951: isub
    //   952: i2f
    //   953: fload 4
    //   955: fmul
    //   956: f2i
    //   957: aload_1
    //   958: getfield 83	android/graphics/Rect:left	I
    //   961: i2f
    //   962: fload 5
    //   964: fmul
    //   965: f2i
    //   966: fload 4
    //   968: aload_0
    //   969: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   972: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   975: aload_1
    //   976: getfield 74	android/graphics/Rect:top	I
    //   979: isub
    //   980: i2f
    //   981: fmul
    //   982: f2i
    //   983: aload_1
    //   984: getfield 77	android/graphics/Rect:right	I
    //   987: i2f
    //   988: fload 5
    //   990: fmul
    //   991: f2i
    //   992: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   995: astore_1
    //   996: goto -675 -> 321
    //   999: aload_0
    //   1000: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1003: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   1006: i2f
    //   1007: aload_0
    //   1008: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1011: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   1014: i2f
    //   1015: fdiv
    //   1016: fstore 4
    //   1018: aload_0
    //   1019: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1022: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   1025: i2f
    //   1026: aload_0
    //   1027: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1030: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   1033: i2f
    //   1034: fdiv
    //   1035: fstore 5
    //   1037: new 55	android/graphics/Rect
    //   1040: dup
    //   1041: aload_1
    //   1042: getfield 83	android/graphics/Rect:left	I
    //   1045: i2f
    //   1046: fload 4
    //   1048: fmul
    //   1049: f2i
    //   1050: aload_1
    //   1051: getfield 74	android/graphics/Rect:top	I
    //   1054: i2f
    //   1055: fload 5
    //   1057: fmul
    //   1058: f2i
    //   1059: fload 4
    //   1061: aload_1
    //   1062: getfield 77	android/graphics/Rect:right	I
    //   1065: i2f
    //   1066: fmul
    //   1067: f2i
    //   1068: aload_1
    //   1069: getfield 80	android/graphics/Rect:bottom	I
    //   1072: i2f
    //   1073: fload 5
    //   1075: fmul
    //   1076: f2i
    //   1077: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   1080: astore_1
    //   1081: goto -760 -> 321
    //   1084: astore 12
    //   1086: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +14 -> 1103
    //   1092: ldc 115
    //   1094: iconst_2
    //   1095: aload 12
    //   1097: invokevirtual 174	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1100: invokestatic 177	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: aconst_null
    //   1104: astore 12
    //   1106: goto -750 -> 356
    //   1109: astore_1
    //   1110: iconst_0
    //   1111: istore 6
    //   1113: iload 6
    //   1115: istore 7
    //   1117: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq -544 -> 576
    //   1123: ldc 115
    //   1125: iconst_2
    //   1126: aload_1
    //   1127: invokevirtual 178	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1130: invokestatic 177	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1133: iload 6
    //   1135: istore 7
    //   1137: goto -561 -> 576
    //   1140: aload_0
    //   1141: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1144: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1147: iconst_2
    //   1148: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   1151: pop
    //   1152: return
    //   1153: aconst_null
    //   1154: astore 12
    //   1156: aload_1
    //   1157: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   1160: instanceof 180
    //   1163: ifeq +22 -> 1185
    //   1166: aload_1
    //   1167: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   1170: checkcast 180	android/net/Uri
    //   1173: aload_0
    //   1174: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1177: invokevirtual 184	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   1180: invokestatic 189	vup:a	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
    //   1183: astore 12
    //   1185: aload 12
    //   1187: ifnull +23 -> 1210
    //   1190: aload_0
    //   1191: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1194: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1197: iconst_3
    //   1198: aload 12
    //   1200: getfield 194	android/util/Pair:first	Ljava/lang/Object;
    //   1203: invokevirtual 167	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1206: invokevirtual 170	android/os/Message:sendToTarget	()V
    //   1209: return
    //   1210: aload_0
    //   1211: getfield 10	xeu:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1214: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1217: iconst_4
    //   1218: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   1221: pop
    //   1222: return
    //   1223: astore_1
    //   1224: goto -111 -> 1113
    //   1227: iconst_0
    //   1228: istore 6
    //   1230: goto -701 -> 529
    //   1233: goto -904 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1236	0	this	xeu
    //   0	1236	1	paramMessage	android.os.Message
    //   536	27	2	d	double
    //   240	820	4	f1	float
    //   259	815	5	f2	float
    //   109	1120	6	i	int
    //   113	1023	7	j	int
    //   101	11	8	k	int
    //   106	14	9	m	int
    //   332	201	10	l	long
    //   33	664	12	localObject	java.lang.Object
    //   1084	12	12	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1104	95	12	localPair	android.util.Pair
    //   87	380	13	arrayOfByte	byte[]
    //   337	183	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   339	356	1084	java/lang/OutOfMemoryError
    //   329	339	1109	java/lang/UnsatisfiedLinkError
    //   339	356	1109	java/lang/UnsatisfiedLinkError
    //   361	529	1109	java/lang/UnsatisfiedLinkError
    //   1086	1103	1109	java/lang/UnsatisfiedLinkError
    //   529	537	1223	java/lang/UnsatisfiedLinkError
    //   541	572	1223	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xeu
 * JD-Core Version:    0.7.0.1
 */