package com.tencent.qqmail.view;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;

@SuppressLint({"NewApi"})
public class WindowCheckTask
  extends HandlerThread
{
  public static final int MSG_CANCEL = 1001;
  public static final int MSG_DO_ASYNC_CHECK = 1000;
  private static final int MSG_HANDLE_RESULT = 1002;
  private static final String TAG = "tagorewang:WindowCheckTask";
  private static final int VIRTUAL_DEVICE_ID = -558907729;
  private ICallbackWhenObscured mCallback;
  private Handler mHandler;
  private int mInitMsg;
  private ObservableRelativeLayout mTargetView;
  private long mThreadId;
  private Handler mUiHandler = new WindowCheckTask.1(this, Looper.getMainLooper());
  
  public WindowCheckTask(ObservableRelativeLayout paramObservableRelativeLayout, ICallbackWhenObscured paramICallbackWhenObscured)
  {
    super("tagorewang:WindowCheckTask");
    setViewForObscuredDetection(paramObservableRelativeLayout);
    setCallbackWhenObscured(paramICallbackWhenObscured);
  }
  
  /* Error */
  private void doAsyncCheck()
  {
    // Byte code:
    //   0: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   8: ifnonnull +12 -> 20
    //   11: ldc 21
    //   13: ldc 84
    //   15: invokestatic 90	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: return
    //   20: aload_0
    //   21: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   24: invokevirtual 96	com/tencent/qqmail/view/ObservableRelativeLayout:isAttachedToWindowCompat	()Z
    //   27: ifne +12 -> 39
    //   30: ldc 21
    //   32: ldc 98
    //   34: invokestatic 90	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: return
    //   39: aload_0
    //   40: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   43: invokevirtual 102	com/tencent/qqmail/view/ObservableRelativeLayout:getWindowVisibility	()I
    //   46: ifeq +12 -> 58
    //   49: ldc 21
    //   51: ldc 104
    //   53: invokestatic 90	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: return
    //   58: iconst_2
    //   59: newarray int
    //   61: astore 24
    //   63: aload_0
    //   64: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   67: aload 24
    //   69: invokevirtual 108	com/tencent/qqmail/view/ObservableRelativeLayout:getLocationOnScreen	([I)V
    //   72: aload_0
    //   73: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   76: invokevirtual 111	com/tencent/qqmail/view/ObservableRelativeLayout:getWidth	()I
    //   79: istore_1
    //   80: aload_0
    //   81: getfield 82	com/tencent/qqmail/view/WindowCheckTask:mTargetView	Lcom/tencent/qqmail/view/ObservableRelativeLayout;
    //   84: invokevirtual 114	com/tencent/qqmail/view/ObservableRelativeLayout:getHeight	()I
    //   87: istore_2
    //   88: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   91: lstore 9
    //   93: aconst_null
    //   94: astore 16
    //   96: aconst_null
    //   97: astore 13
    //   99: aconst_null
    //   100: astore 21
    //   102: aconst_null
    //   103: astore 20
    //   105: aconst_null
    //   106: astore 23
    //   108: aconst_null
    //   109: astore 22
    //   111: ldc2_w 115
    //   114: lload 9
    //   116: ladd
    //   117: lstore 5
    //   119: lload 9
    //   121: ldc2_w 117
    //   124: ladd
    //   125: lstore 7
    //   127: lload 9
    //   129: ldc2_w 119
    //   132: ladd
    //   133: lstore 9
    //   135: aload 20
    //   137: astore 17
    //   139: aload 13
    //   141: astore 18
    //   143: aload 23
    //   145: astore 19
    //   147: aload 21
    //   149: astore 14
    //   151: aload 16
    //   153: astore 15
    //   155: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   158: bipush 9
    //   160: if_icmplt +597 -> 757
    //   163: aload 20
    //   165: astore 17
    //   167: aload 13
    //   169: astore 18
    //   171: aload 23
    //   173: astore 19
    //   175: aload 21
    //   177: astore 14
    //   179: aload 16
    //   181: astore 15
    //   183: iconst_1
    //   184: newarray int
    //   186: astore 25
    //   188: aload 25
    //   190: iconst_0
    //   191: iconst_0
    //   192: iastore
    //   193: aload 20
    //   195: astore 17
    //   197: aload 13
    //   199: astore 18
    //   201: aload 23
    //   203: astore 19
    //   205: aload 21
    //   207: astore 14
    //   209: aload 16
    //   211: astore 15
    //   213: new 127	android/view/MotionEvent$PointerCoords
    //   216: dup
    //   217: invokespecial 129	android/view/MotionEvent$PointerCoords:<init>	()V
    //   220: astore 26
    //   222: aload 20
    //   224: astore 17
    //   226: aload 13
    //   228: astore 18
    //   230: aload 23
    //   232: astore 19
    //   234: aload 21
    //   236: astore 14
    //   238: aload 16
    //   240: astore 15
    //   242: aload 26
    //   244: aload 24
    //   246: iconst_0
    //   247: iaload
    //   248: i2f
    //   249: putfield 133	android/view/MotionEvent$PointerCoords:x	F
    //   252: aload 20
    //   254: astore 17
    //   256: aload 13
    //   258: astore 18
    //   260: aload 23
    //   262: astore 19
    //   264: aload 21
    //   266: astore 14
    //   268: aload 16
    //   270: astore 15
    //   272: aload 26
    //   274: aload 24
    //   276: iconst_1
    //   277: iaload
    //   278: i2f
    //   279: putfield 136	android/view/MotionEvent$PointerCoords:y	F
    //   282: aload 20
    //   284: astore 17
    //   286: aload 13
    //   288: astore 18
    //   290: aload 23
    //   292: astore 19
    //   294: aload 21
    //   296: astore 14
    //   298: aload 16
    //   300: astore 15
    //   302: lload 5
    //   304: lload 5
    //   306: iconst_0
    //   307: iconst_1
    //   308: aload 25
    //   310: iconst_1
    //   311: anewarray 127	android/view/MotionEvent$PointerCoords
    //   314: dup
    //   315: iconst_0
    //   316: aload 26
    //   318: aastore
    //   319: iconst_0
    //   320: fconst_1
    //   321: fconst_1
    //   322: ldc 23
    //   324: iconst_0
    //   325: iconst_0
    //   326: iconst_1
    //   327: invokestatic 142	android/view/MotionEvent:obtain	(JJII[I[Landroid/view/MotionEvent$PointerCoords;IFFIIII)Landroid/view/MotionEvent;
    //   330: astore 13
    //   332: aload 20
    //   334: astore 17
    //   336: aload 13
    //   338: astore 18
    //   340: aload 23
    //   342: astore 19
    //   344: aload 21
    //   346: astore 14
    //   348: aload 13
    //   350: astore 15
    //   352: aload 13
    //   354: astore 16
    //   356: new 127	android/view/MotionEvent$PointerCoords
    //   359: dup
    //   360: invokespecial 129	android/view/MotionEvent$PointerCoords:<init>	()V
    //   363: astore 26
    //   365: aload 20
    //   367: astore 17
    //   369: aload 13
    //   371: astore 18
    //   373: aload 23
    //   375: astore 19
    //   377: aload 21
    //   379: astore 14
    //   381: aload 13
    //   383: astore 15
    //   385: aload 13
    //   387: astore 16
    //   389: aload 26
    //   391: aload 24
    //   393: iconst_0
    //   394: iaload
    //   395: iload_1
    //   396: iconst_2
    //   397: idiv
    //   398: iadd
    //   399: i2f
    //   400: putfield 133	android/view/MotionEvent$PointerCoords:x	F
    //   403: aload 20
    //   405: astore 17
    //   407: aload 13
    //   409: astore 18
    //   411: aload 23
    //   413: astore 19
    //   415: aload 21
    //   417: astore 14
    //   419: aload 13
    //   421: astore 15
    //   423: aload 13
    //   425: astore 16
    //   427: aload 26
    //   429: aload 24
    //   431: iconst_1
    //   432: iaload
    //   433: iload_2
    //   434: iconst_2
    //   435: idiv
    //   436: iadd
    //   437: i2f
    //   438: putfield 136	android/view/MotionEvent$PointerCoords:y	F
    //   441: aload 20
    //   443: astore 17
    //   445: aload 13
    //   447: astore 18
    //   449: aload 23
    //   451: astore 19
    //   453: aload 21
    //   455: astore 14
    //   457: aload 13
    //   459: astore 15
    //   461: aload 13
    //   463: astore 16
    //   465: lload 7
    //   467: lload 7
    //   469: iconst_0
    //   470: iconst_1
    //   471: aload 25
    //   473: iconst_1
    //   474: anewarray 127	android/view/MotionEvent$PointerCoords
    //   477: dup
    //   478: iconst_0
    //   479: aload 26
    //   481: aastore
    //   482: iconst_0
    //   483: fconst_1
    //   484: fconst_1
    //   485: ldc 23
    //   487: iconst_0
    //   488: iconst_0
    //   489: iconst_1
    //   490: invokestatic 142	android/view/MotionEvent:obtain	(JJII[I[Landroid/view/MotionEvent$PointerCoords;IFFIIII)Landroid/view/MotionEvent;
    //   493: astore 20
    //   495: aload 20
    //   497: astore 16
    //   499: aload 16
    //   501: astore 17
    //   503: aload 13
    //   505: astore 18
    //   507: aload 23
    //   509: astore 19
    //   511: aload 16
    //   513: astore 14
    //   515: aload 13
    //   517: astore 15
    //   519: aload 16
    //   521: astore 21
    //   523: aload 13
    //   525: astore 20
    //   527: new 127	android/view/MotionEvent$PointerCoords
    //   530: dup
    //   531: invokespecial 129	android/view/MotionEvent$PointerCoords:<init>	()V
    //   534: astore 26
    //   536: aload 16
    //   538: astore 17
    //   540: aload 13
    //   542: astore 18
    //   544: aload 23
    //   546: astore 19
    //   548: aload 16
    //   550: astore 14
    //   552: aload 13
    //   554: astore 15
    //   556: aload 16
    //   558: astore 21
    //   560: aload 13
    //   562: astore 20
    //   564: aload 26
    //   566: aload 24
    //   568: iconst_0
    //   569: iaload
    //   570: iload_1
    //   571: iadd
    //   572: iconst_1
    //   573: isub
    //   574: i2f
    //   575: putfield 133	android/view/MotionEvent$PointerCoords:x	F
    //   578: aload 16
    //   580: astore 17
    //   582: aload 13
    //   584: astore 18
    //   586: aload 23
    //   588: astore 19
    //   590: aload 16
    //   592: astore 14
    //   594: aload 13
    //   596: astore 15
    //   598: aload 16
    //   600: astore 21
    //   602: aload 13
    //   604: astore 20
    //   606: aload 26
    //   608: aload 24
    //   610: iconst_1
    //   611: iaload
    //   612: iload_2
    //   613: iadd
    //   614: iconst_1
    //   615: isub
    //   616: i2f
    //   617: putfield 136	android/view/MotionEvent$PointerCoords:y	F
    //   620: aload 16
    //   622: astore 17
    //   624: aload 13
    //   626: astore 18
    //   628: aload 23
    //   630: astore 19
    //   632: aload 16
    //   634: astore 14
    //   636: aload 13
    //   638: astore 15
    //   640: aload 16
    //   642: astore 21
    //   644: aload 13
    //   646: astore 20
    //   648: lload 9
    //   650: lload 9
    //   652: iconst_0
    //   653: iconst_1
    //   654: aload 25
    //   656: iconst_1
    //   657: anewarray 127	android/view/MotionEvent$PointerCoords
    //   660: dup
    //   661: iconst_0
    //   662: aload 26
    //   664: aastore
    //   665: iconst_0
    //   666: fconst_1
    //   667: fconst_1
    //   668: ldc 23
    //   670: iconst_0
    //   671: iconst_0
    //   672: iconst_1
    //   673: invokestatic 142	android/view/MotionEvent:obtain	(JJII[I[Landroid/view/MotionEvent$PointerCoords;IFFIIII)Landroid/view/MotionEvent;
    //   676: astore 23
    //   678: aload 23
    //   680: astore 15
    //   682: aload 16
    //   684: astore 14
    //   686: ldc 21
    //   688: ldc 144
    //   690: invokestatic 147	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   693: pop
    //   694: aload_0
    //   695: aload 13
    //   697: invokespecial 151	com/tencent/qqmail/view/WindowCheckTask:sendEvent	(Landroid/view/MotionEvent;)V
    //   700: aload_0
    //   701: aload 14
    //   703: invokespecial 151	com/tencent/qqmail/view/WindowCheckTask:sendEvent	(Landroid/view/MotionEvent;)V
    //   706: aload_0
    //   707: aload 15
    //   709: invokespecial 151	com/tencent/qqmail/view/WindowCheckTask:sendEvent	(Landroid/view/MotionEvent;)V
    //   712: aload 13
    //   714: ifnull +8 -> 722
    //   717: aload 13
    //   719: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   722: aload 14
    //   724: ifnull +8 -> 732
    //   727: aload 14
    //   729: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   732: aload 15
    //   734: ifnull +445 -> 1179
    //   737: aload 15
    //   739: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   742: iconst_0
    //   743: istore 11
    //   745: aload_0
    //   746: iload 11
    //   748: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   751: lload_3
    //   752: lsub
    //   753: invokespecial 158	com/tencent/qqmail/view/WindowCheckTask:postResult	(ZJ)V
    //   756: return
    //   757: aload 20
    //   759: astore 17
    //   761: aload 13
    //   763: astore 18
    //   765: aload 23
    //   767: astore 19
    //   769: aload 21
    //   771: astore 14
    //   773: aload 16
    //   775: astore 15
    //   777: lload 5
    //   779: lload 5
    //   781: iconst_0
    //   782: iconst_1
    //   783: aload 24
    //   785: iconst_0
    //   786: iaload
    //   787: i2f
    //   788: aload 24
    //   790: iconst_1
    //   791: iaload
    //   792: i2f
    //   793: fconst_0
    //   794: fconst_1
    //   795: iconst_0
    //   796: fconst_1
    //   797: fconst_1
    //   798: ldc 23
    //   800: iconst_0
    //   801: invokestatic 161	android/view/MotionEvent:obtain	(JJIIFFFFIFFII)Landroid/view/MotionEvent;
    //   804: astore 13
    //   806: aload 20
    //   808: astore 17
    //   810: aload 13
    //   812: astore 18
    //   814: aload 23
    //   816: astore 19
    //   818: aload 21
    //   820: astore 14
    //   822: aload 13
    //   824: astore 15
    //   826: aload 13
    //   828: astore 16
    //   830: lload 7
    //   832: lload 7
    //   834: iconst_0
    //   835: iconst_1
    //   836: aload 24
    //   838: iconst_0
    //   839: iaload
    //   840: iload_1
    //   841: iconst_2
    //   842: idiv
    //   843: iadd
    //   844: i2f
    //   845: aload 24
    //   847: iconst_1
    //   848: iaload
    //   849: iload_2
    //   850: iconst_2
    //   851: idiv
    //   852: iadd
    //   853: i2f
    //   854: fconst_0
    //   855: fconst_1
    //   856: iconst_0
    //   857: fconst_1
    //   858: fconst_1
    //   859: ldc 23
    //   861: iconst_0
    //   862: invokestatic 161	android/view/MotionEvent:obtain	(JJIIFFFFIFFII)Landroid/view/MotionEvent;
    //   865: astore 20
    //   867: aload 20
    //   869: astore 16
    //   871: aload 16
    //   873: astore 17
    //   875: aload 13
    //   877: astore 18
    //   879: aload 23
    //   881: astore 19
    //   883: aload 16
    //   885: astore 14
    //   887: aload 13
    //   889: astore 15
    //   891: aload 16
    //   893: astore 21
    //   895: aload 13
    //   897: astore 20
    //   899: lload 9
    //   901: lload 9
    //   903: iconst_0
    //   904: iconst_1
    //   905: aload 24
    //   907: iconst_0
    //   908: iaload
    //   909: iload_1
    //   910: iadd
    //   911: iconst_1
    //   912: isub
    //   913: i2f
    //   914: aload 24
    //   916: iconst_1
    //   917: iaload
    //   918: iload_2
    //   919: iadd
    //   920: iconst_1
    //   921: isub
    //   922: i2f
    //   923: fconst_0
    //   924: fconst_1
    //   925: iconst_0
    //   926: fconst_1
    //   927: fconst_1
    //   928: ldc 23
    //   930: iconst_0
    //   931: invokestatic 161	android/view/MotionEvent:obtain	(JJIIFFFFIFFII)Landroid/view/MotionEvent;
    //   934: astore 23
    //   936: aload 23
    //   938: astore 15
    //   940: aload 16
    //   942: astore 14
    //   944: goto -258 -> 686
    //   947: astore 13
    //   949: aconst_null
    //   950: astore 13
    //   952: aconst_null
    //   953: astore 14
    //   955: aconst_null
    //   956: astore 15
    //   958: iconst_1
    //   959: istore 12
    //   961: aload 15
    //   963: ifnull +8 -> 971
    //   966: aload 15
    //   968: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   971: aload 14
    //   973: ifnull +8 -> 981
    //   976: aload 14
    //   978: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   981: iload 12
    //   983: istore 11
    //   985: aload 13
    //   987: ifnull -242 -> 745
    //   990: aload 13
    //   992: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   995: iload 12
    //   997: istore 11
    //   999: goto -254 -> 745
    //   1002: astore 16
    //   1004: aload 22
    //   1006: astore 13
    //   1008: aload 13
    //   1010: astore 19
    //   1012: aload 17
    //   1014: astore 14
    //   1016: aload 18
    //   1018: astore 15
    //   1020: ldc 21
    //   1022: ldc 163
    //   1024: aload 16
    //   1026: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1029: pop
    //   1030: aload 18
    //   1032: ifnull +8 -> 1040
    //   1035: aload 18
    //   1037: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1040: aload 17
    //   1042: ifnull +8 -> 1050
    //   1045: aload 17
    //   1047: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1050: aload 13
    //   1052: ifnull +127 -> 1179
    //   1055: aload 13
    //   1057: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1060: iconst_0
    //   1061: istore 11
    //   1063: goto -318 -> 745
    //   1066: astore 16
    //   1068: aload 15
    //   1070: astore 13
    //   1072: aload 19
    //   1074: astore 15
    //   1076: aload 13
    //   1078: ifnull +8 -> 1086
    //   1081: aload 13
    //   1083: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1086: aload 14
    //   1088: ifnull +8 -> 1096
    //   1091: aload 14
    //   1093: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1096: aload 15
    //   1098: ifnull +8 -> 1106
    //   1101: aload 15
    //   1103: invokevirtual 154	android/view/MotionEvent:recycle	()V
    //   1106: aload 16
    //   1108: athrow
    //   1109: astore 16
    //   1111: goto -35 -> 1076
    //   1114: astore 16
    //   1116: aload 13
    //   1118: astore 18
    //   1120: aload 15
    //   1122: astore 13
    //   1124: aload 14
    //   1126: astore 17
    //   1128: goto -120 -> 1008
    //   1131: astore 13
    //   1133: aconst_null
    //   1134: astore 13
    //   1136: aconst_null
    //   1137: astore 14
    //   1139: aload 16
    //   1141: astore 15
    //   1143: goto -185 -> 958
    //   1146: astore 13
    //   1148: aconst_null
    //   1149: astore 13
    //   1151: aload 21
    //   1153: astore 14
    //   1155: aload 20
    //   1157: astore 15
    //   1159: goto -201 -> 958
    //   1162: astore 16
    //   1164: aload 13
    //   1166: astore 16
    //   1168: aload 15
    //   1170: astore 13
    //   1172: aload 16
    //   1174: astore 15
    //   1176: goto -218 -> 958
    //   1179: iconst_0
    //   1180: istore 11
    //   1182: goto -437 -> 745
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1185	0	this	WindowCheckTask
    //   79	832	1	i	int
    //   87	833	2	j	int
    //   3	749	3	l1	long
    //   117	663	5	l2	long
    //   125	708	7	l3	long
    //   91	811	9	l4	long
    //   743	438	11	bool1	boolean
    //   959	37	12	bool2	boolean
    //   97	799	13	localMotionEvent1	MotionEvent
    //   947	1	13	localSecurityException1	SecurityException
    //   950	173	13	localObject1	Object
    //   1131	1	13	localSecurityException2	SecurityException
    //   1134	1	13	localObject2	Object
    //   1146	1	13	localSecurityException3	SecurityException
    //   1149	22	13	localObject3	Object
    //   149	1005	14	localObject4	Object
    //   153	1022	15	localObject5	Object
    //   94	847	16	localObject6	Object
    //   1002	23	16	localThrowable1	java.lang.Throwable
    //   1066	41	16	localObject7	Object
    //   1109	1	16	localObject8	Object
    //   1114	26	16	localThrowable2	java.lang.Throwable
    //   1162	1	16	localSecurityException4	SecurityException
    //   1166	7	16	localObject9	Object
    //   137	990	17	localObject10	Object
    //   141	978	18	localObject11	Object
    //   145	928	19	localObject12	Object
    //   103	1053	20	localMotionEvent2	MotionEvent
    //   100	1052	21	localObject13	Object
    //   109	896	22	localObject14	Object
    //   106	831	23	localMotionEvent3	MotionEvent
    //   61	854	24	arrayOfInt1	int[]
    //   186	469	25	arrayOfInt2	int[]
    //   220	443	26	localPointerCoords	android.view.MotionEvent.PointerCoords
    // Exception table:
    //   from	to	target	type
    //   155	163	947	java/lang/SecurityException
    //   183	188	947	java/lang/SecurityException
    //   213	222	947	java/lang/SecurityException
    //   242	252	947	java/lang/SecurityException
    //   272	282	947	java/lang/SecurityException
    //   302	332	947	java/lang/SecurityException
    //   777	806	947	java/lang/SecurityException
    //   155	163	1002	java/lang/Throwable
    //   183	188	1002	java/lang/Throwable
    //   213	222	1002	java/lang/Throwable
    //   242	252	1002	java/lang/Throwable
    //   272	282	1002	java/lang/Throwable
    //   302	332	1002	java/lang/Throwable
    //   356	365	1002	java/lang/Throwable
    //   389	403	1002	java/lang/Throwable
    //   427	441	1002	java/lang/Throwable
    //   465	495	1002	java/lang/Throwable
    //   527	536	1002	java/lang/Throwable
    //   564	578	1002	java/lang/Throwable
    //   606	620	1002	java/lang/Throwable
    //   648	678	1002	java/lang/Throwable
    //   777	806	1002	java/lang/Throwable
    //   830	867	1002	java/lang/Throwable
    //   899	936	1002	java/lang/Throwable
    //   155	163	1066	finally
    //   183	188	1066	finally
    //   213	222	1066	finally
    //   242	252	1066	finally
    //   272	282	1066	finally
    //   302	332	1066	finally
    //   356	365	1066	finally
    //   389	403	1066	finally
    //   427	441	1066	finally
    //   465	495	1066	finally
    //   527	536	1066	finally
    //   564	578	1066	finally
    //   606	620	1066	finally
    //   648	678	1066	finally
    //   777	806	1066	finally
    //   830	867	1066	finally
    //   899	936	1066	finally
    //   1020	1030	1066	finally
    //   686	712	1109	finally
    //   686	712	1114	java/lang/Throwable
    //   356	365	1131	java/lang/SecurityException
    //   389	403	1131	java/lang/SecurityException
    //   427	441	1131	java/lang/SecurityException
    //   465	495	1131	java/lang/SecurityException
    //   830	867	1131	java/lang/SecurityException
    //   527	536	1146	java/lang/SecurityException
    //   564	578	1146	java/lang/SecurityException
    //   606	620	1146	java/lang/SecurityException
    //   648	678	1146	java/lang/SecurityException
    //   899	936	1146	java/lang/SecurityException
    //   686	712	1162	java/lang/SecurityException
  }
  
  public static boolean filterTouchEventForSecurity(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramMotionEvent.getToolType(0) == 0)
      {
        Log.d("tagorewang:WindowCheckTask", "filterTouchEventForSecurity: MotionEvent.TOOL_TYPE_UNKNOWN");
        return bool2;
      }
    }
    else if ((Build.VERSION.SDK_INT >= 9) && (1 == paramMotionEvent.getFlags()))
    {
      Log.d("tagorewang:WindowCheckTask", "filterTouchEventForSecurity: MotionEvent.FLAG_WINDOW_IS_OBSCURED");
      return true;
    }
    if (paramMotionEvent.getDeviceId() == -558907729) {}
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      Log.d("tagorewang:WindowCheckTask", "filterTouchEventForSecurity: VIRTUAL_DEVICE_ID");
      return bool1;
      bool1 = false;
    }
  }
  
  private void postResult(boolean paramBoolean, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1002;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.arg2 = ((int)paramLong);
      this.mUiHandler.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
  }
  
  private void sendEvent(MotionEvent paramMotionEvent)
    throws SecurityException
  {
    new Instrumentation().sendPointerSync(paramMotionEvent);
  }
  
  public void cancel()
  {
    if (this.mHandler != null)
    {
      this.mHandler.sendEmptyMessage(1001);
      return;
    }
    this.mInitMsg = 1001;
  }
  
  public void check()
  {
    if (this.mHandler != null)
    {
      this.mHandler.sendEmptyMessage(1000);
      return;
    }
    this.mInitMsg = 1000;
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    this.mThreadId = Thread.currentThread().getId();
    this.mHandler = new WindowCheckTask.2(this);
    this.mHandler.sendEmptyMessage(this.mInitMsg);
  }
  
  public void setCallbackWhenObscured(ICallbackWhenObscured paramICallbackWhenObscured)
  {
    this.mCallback = paramICallbackWhenObscured;
  }
  
  public void setViewForObscuredDetection(ObservableRelativeLayout paramObservableRelativeLayout)
  {
    this.mTargetView = paramObservableRelativeLayout;
  }
  
  public static abstract interface ICallbackWhenObscured
  {
    public abstract void onCallbackWhenBroughtToFront(long paramLong);
    
    public abstract void onCallbackWhenObscured();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.WindowCheckTask
 * JD-Core Version:    0.7.0.1
 */