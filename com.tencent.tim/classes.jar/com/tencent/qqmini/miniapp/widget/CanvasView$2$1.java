package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;

class CanvasView$2$1
  implements Runnable
{
  CanvasView$2$1(CanvasView.2 param2, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +22 -> 26
    //   7: ldc 27
    //   9: ldc 29
    //   11: invokestatic 35	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   18: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   21: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   24: pop
    //   25: return
    //   26: aload_0
    //   27: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   30: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   33: aload_0
    //   34: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   37: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   40: ldc 57
    //   42: dconst_0
    //   43: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   46: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   49: istore 10
    //   51: aload_0
    //   52: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   55: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   58: aload_0
    //   59: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   62: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   65: ldc 71
    //   67: dconst_0
    //   68: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   71: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   74: istore 11
    //   76: iload 10
    //   78: ifgt +894 -> 972
    //   81: aload_0
    //   82: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   85: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   88: invokevirtual 75	com/tencent/qqmini/miniapp/widget/CanvasView:getWidth	()I
    //   91: istore 10
    //   93: iload 11
    //   95: ifgt +874 -> 969
    //   98: aload_0
    //   99: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   102: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   105: invokevirtual 78	com/tencent/qqmini/miniapp/widget/CanvasView:getHeight	()I
    //   108: istore 11
    //   110: aload_0
    //   111: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   114: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   117: ldc 80
    //   119: dconst_0
    //   120: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   123: d2i
    //   124: istore 5
    //   126: aload_0
    //   127: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   130: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   133: ldc 82
    //   135: dconst_0
    //   136: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   139: d2i
    //   140: istore 6
    //   142: iload 5
    //   144: istore 4
    //   146: iload 5
    //   148: ifgt +18 -> 166
    //   151: aload_0
    //   152: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   155: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   158: iload 10
    //   160: i2d
    //   161: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   164: istore 4
    //   166: iload 6
    //   168: istore 5
    //   170: iload 6
    //   172: ifgt +18 -> 190
    //   175: aload_0
    //   176: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   179: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   182: iload 11
    //   184: i2d
    //   185: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   188: istore 5
    //   190: ldc 27
    //   192: new 87	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   199: ldc 90
    //   201: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 4
    //   206: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc 99
    //   211: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 5
    //   216: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 105	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aconst_null
    //   226: astore 12
    //   228: aload_0
    //   229: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   232: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   235: ifeq +209 -> 444
    //   238: getstatic 115	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   241: astore 13
    //   243: iload 4
    //   245: iload 5
    //   247: aload 13
    //   249: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   252: astore 14
    //   254: aload 14
    //   256: astore 12
    //   258: aload 12
    //   260: ifnonnull +698 -> 958
    //   263: aload_0
    //   264: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   267: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   270: ifeq +194 -> 464
    //   273: ldc2_w 122
    //   276: iload 4
    //   278: i2l
    //   279: ldiv
    //   280: iload 5
    //   282: i2l
    //   283: ldiv
    //   284: ldc2_w 124
    //   287: ldiv
    //   288: l2d
    //   289: invokestatic 131	java/lang/Math:sqrt	(D)D
    //   292: dstore_1
    //   293: dload_1
    //   294: d2f
    //   295: fstore_3
    //   296: fload_3
    //   297: fconst_1
    //   298: fcmpg
    //   299: ifge +659 -> 958
    //   302: iload 4
    //   304: i2f
    //   305: fload_3
    //   306: fmul
    //   307: f2i
    //   308: istore 7
    //   310: fload_3
    //   311: iload 5
    //   313: i2f
    //   314: fmul
    //   315: f2i
    //   316: istore 6
    //   318: iload 7
    //   320: iload 6
    //   322: aload 13
    //   324: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   327: astore 14
    //   329: aload 14
    //   331: astore 12
    //   333: iload 6
    //   335: istore 8
    //   337: iload 7
    //   339: istore 9
    //   341: aload 12
    //   343: ifnonnull +633 -> 976
    //   346: iload 7
    //   348: i2d
    //   349: ldc2_w 132
    //   352: ddiv
    //   353: d2i
    //   354: istore 9
    //   356: iload 6
    //   358: i2d
    //   359: ldc2_w 132
    //   362: ddiv
    //   363: d2i
    //   364: istore 6
    //   366: iload 9
    //   368: iload 6
    //   370: aload 13
    //   372: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   375: astore 13
    //   377: iload 9
    //   379: istore 7
    //   381: aload 13
    //   383: astore 12
    //   385: aload 12
    //   387: ifnonnull +131 -> 518
    //   390: aload_0
    //   391: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   394: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   397: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   400: pop
    //   401: return
    //   402: astore 12
    //   404: ldc 27
    //   406: new 87	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   413: ldc 135
    //   415: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 12
    //   420: invokestatic 141	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   423: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 35	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload_0
    //   433: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   436: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   439: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   442: pop
    //   443: return
    //   444: getstatic 144	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   447: astore 13
    //   449: goto -206 -> 243
    //   452: astore 14
    //   454: ldc 27
    //   456: ldc 146
    //   458: invokestatic 149	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -203 -> 258
    //   464: ldc2_w 122
    //   467: iload 4
    //   469: i2l
    //   470: ldiv
    //   471: iload 5
    //   473: i2l
    //   474: ldiv
    //   475: ldc2_w 124
    //   478: ldiv
    //   479: l2d
    //   480: invokestatic 131	java/lang/Math:sqrt	(D)D
    //   483: d2f
    //   484: fstore_3
    //   485: goto -189 -> 296
    //   488: astore 14
    //   490: ldc 27
    //   492: ldc 151
    //   494: invokestatic 149	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -164 -> 333
    //   500: astore 13
    //   502: ldc 27
    //   504: ldc 153
    //   506: aload 13
    //   508: invokestatic 156	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   511: iload 6
    //   513: istore 8
    //   515: goto +461 -> 976
    //   518: new 158	android/graphics/Canvas
    //   521: dup
    //   522: aload 12
    //   524: invokespecial 161	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   527: astore 13
    //   529: aload 13
    //   531: new 163	android/graphics/PaintFlagsDrawFilter
    //   534: dup
    //   535: iconst_0
    //   536: iconst_3
    //   537: invokespecial 166	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   540: invokevirtual 170	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   543: new 172	android/graphics/Rect
    //   546: dup
    //   547: iconst_0
    //   548: iconst_0
    //   549: iload 7
    //   551: iload 6
    //   553: invokespecial 175	android/graphics/Rect:<init>	(IIII)V
    //   556: astore 14
    //   558: aload_0
    //   559: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   562: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   565: aload_0
    //   566: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   569: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   572: ldc 177
    //   574: dconst_0
    //   575: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   578: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   581: istore 8
    //   583: aload_0
    //   584: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   587: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   590: aload_0
    //   591: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   594: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   597: ldc 179
    //   599: dconst_0
    //   600: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   603: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   606: istore 9
    //   608: new 172	android/graphics/Rect
    //   611: dup
    //   612: iload 8
    //   614: iload 9
    //   616: iload 10
    //   618: iload 8
    //   620: iadd
    //   621: iload 11
    //   623: iload 9
    //   625: iadd
    //   626: invokespecial 175	android/graphics/Rect:<init>	(IIII)V
    //   629: astore 15
    //   631: aload 13
    //   633: aload_0
    //   634: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   637: aload 15
    //   639: aload 14
    //   641: aconst_null
    //   642: invokevirtual 183	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   645: aload_0
    //   646: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   649: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   652: invokestatic 187	com/tencent/qqmini/miniapp/widget/CanvasView:access$200	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   655: ldc 189
    //   657: invokeinterface 195 2 0
    //   662: checkcast 189	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   665: aload_0
    //   666: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   669: getfield 199	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$fileType	Ljava/lang/String;
    //   672: invokevirtual 203	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 14
    //   677: aload 14
    //   679: invokestatic 209	com/tencent/qqmini/sdk/core/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   682: astore 13
    //   684: new 211	java/io/FileOutputStream
    //   687: dup
    //   688: aload 13
    //   690: invokespecial 214	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   693: astore 13
    //   695: iload 7
    //   697: iload 6
    //   699: imul
    //   700: iload 4
    //   702: idiv
    //   703: iload 5
    //   705: idiv
    //   706: i2f
    //   707: fstore_3
    //   708: aload_0
    //   709: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   712: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   715: ifeq +132 -> 847
    //   718: aload_0
    //   719: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   722: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   725: ldc 216
    //   727: dconst_1
    //   728: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   731: fload_3
    //   732: f2d
    //   733: ddiv
    //   734: dstore_1
    //   735: aload 12
    //   737: getstatic 222	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   740: dload_1
    //   741: ldc2_w 223
    //   744: dmul
    //   745: d2i
    //   746: aload 13
    //   748: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   751: pop
    //   752: new 59	org/json/JSONObject
    //   755: dup
    //   756: invokespecial 229	org/json/JSONObject:<init>	()V
    //   759: astore 12
    //   761: aload 12
    //   763: ldc 231
    //   765: aload_0
    //   766: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   769: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   772: invokestatic 187	com/tencent/qqmini/miniapp/widget/CanvasView:access$200	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   775: ldc 189
    //   777: invokeinterface 195 2 0
    //   782: checkcast 189	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   785: aload 14
    //   787: invokevirtual 234	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   790: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   793: pop
    //   794: aload_0
    //   795: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   798: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   801: aload 12
    //   803: invokevirtual 242	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   806: pop
    //   807: aload 13
    //   809: ifnull +13 -> 822
    //   812: aload 13
    //   814: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   817: aload 13
    //   819: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   822: aload_0
    //   823: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   826: ifnull +149 -> 975
    //   829: aload_0
    //   830: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   833: invokevirtual 252	android/graphics/Bitmap:isRecycled	()Z
    //   836: ifne +139 -> 975
    //   839: aload_0
    //   840: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   843: invokevirtual 255	android/graphics/Bitmap:recycle	()V
    //   846: return
    //   847: aload_0
    //   848: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   851: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   854: ldc_w 257
    //   857: dconst_1
    //   858: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   861: fload_3
    //   862: f2d
    //   863: ddiv
    //   864: dstore_1
    //   865: aload 12
    //   867: getstatic 260	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   870: dload_1
    //   871: ldc2_w 223
    //   874: dmul
    //   875: d2i
    //   876: aload 13
    //   878: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   881: pop
    //   882: goto -130 -> 752
    //   885: astore 12
    //   887: aload 13
    //   889: ifnull +13 -> 902
    //   892: aload 13
    //   894: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   897: aload 13
    //   899: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   902: aload_0
    //   903: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   906: ifnull +20 -> 926
    //   909: aload_0
    //   910: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   913: invokevirtual 252	android/graphics/Bitmap:isRecycled	()Z
    //   916: ifne +10 -> 926
    //   919: aload_0
    //   920: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   923: invokevirtual 255	android/graphics/Bitmap:recycle	()V
    //   926: aload 12
    //   928: athrow
    //   929: astore 12
    //   931: aload 12
    //   933: invokevirtual 263	org/json/JSONException:printStackTrace	()V
    //   936: aload_0
    //   937: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   940: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   943: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   946: pop
    //   947: goto -140 -> 807
    //   950: astore 12
    //   952: aconst_null
    //   953: astore 13
    //   955: goto -68 -> 887
    //   958: iload 5
    //   960: istore 6
    //   962: iload 4
    //   964: istore 7
    //   966: goto -633 -> 333
    //   969: goto -859 -> 110
    //   972: goto -879 -> 93
    //   975: return
    //   976: iload 8
    //   978: istore 6
    //   980: iload 9
    //   982: istore 7
    //   984: goto -599 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	987	0	this	1
    //   292	579	1	d	double
    //   295	567	3	f	float
    //   144	819	4	i	int
    //   124	835	5	j	int
    //   140	839	6	k	int
    //   308	675	7	m	int
    //   335	642	8	n	int
    //   339	642	9	i1	int
    //   49	572	10	i2	int
    //   74	552	11	i3	int
    //   226	160	12	localObject1	Object
    //   402	334	12	localThrowable1	java.lang.Throwable
    //   759	107	12	localJSONObject	org.json.JSONObject
    //   885	42	12	localObject2	Object
    //   929	3	12	localJSONException	org.json.JSONException
    //   950	1	12	localObject3	Object
    //   241	207	13	localObject4	Object
    //   500	7	13	localThrowable2	java.lang.Throwable
    //   527	427	13	localObject5	Object
    //   252	78	14	localBitmap	Bitmap
    //   452	1	14	localThrowable3	java.lang.Throwable
    //   488	1	14	localThrowable4	java.lang.Throwable
    //   556	230	14	localObject6	Object
    //   629	9	15	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	25	402	java/lang/Throwable
    //   26	76	402	java/lang/Throwable
    //   81	93	402	java/lang/Throwable
    //   98	110	402	java/lang/Throwable
    //   110	142	402	java/lang/Throwable
    //   151	166	402	java/lang/Throwable
    //   175	190	402	java/lang/Throwable
    //   190	225	402	java/lang/Throwable
    //   228	243	402	java/lang/Throwable
    //   263	293	402	java/lang/Throwable
    //   390	401	402	java/lang/Throwable
    //   444	449	402	java/lang/Throwable
    //   454	461	402	java/lang/Throwable
    //   464	485	402	java/lang/Throwable
    //   490	497	402	java/lang/Throwable
    //   502	511	402	java/lang/Throwable
    //   518	684	402	java/lang/Throwable
    //   812	822	402	java/lang/Throwable
    //   822	846	402	java/lang/Throwable
    //   892	902	402	java/lang/Throwable
    //   902	926	402	java/lang/Throwable
    //   926	929	402	java/lang/Throwable
    //   243	254	452	java/lang/Throwable
    //   318	329	488	java/lang/Throwable
    //   366	377	500	java/lang/Throwable
    //   695	752	885	finally
    //   752	807	885	finally
    //   847	882	885	finally
    //   931	947	885	finally
    //   752	807	929	org/json/JSONException
    //   684	695	950	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */