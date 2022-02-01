package com.tencent.av.ui.funchat.magicface;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import igd;
import ijy.b;

public class MagicfaceViewForAV
  extends SurfaceView
  implements SurfaceHolder.Callback, ijy.b
{
  public volatile boolean Zf;
  private SurfaceHolder a;
  private float mDensity;
  private int mScreenWidth;
  
  public MagicfaceViewForAV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.a = getHolder();
    this.a.addCallback(this);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.mScreenWidth = localDisplayMetrics.widthPixels;
    igd.aJ("MagicfaceViewForAV", "init() density: " + this.mScreenWidth + "|" + this.mDensity);
  }
  
  /* Error */
  public void a(android.graphics.Bitmap paramBitmap1, android.graphics.Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, android.graphics.Rect paramRect)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 14
    //   6: aload 14
    //   8: astore 13
    //   10: aload 15
    //   12: astore 12
    //   14: aload_0
    //   15: invokevirtual 102	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getWidth	()I
    //   18: istore 9
    //   20: aload 14
    //   22: astore 13
    //   24: aload 15
    //   26: astore 12
    //   28: aload_0
    //   29: invokevirtual 105	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getHeight	()I
    //   32: istore 10
    //   34: aload 14
    //   36: astore 13
    //   38: aload 15
    //   40: astore 12
    //   42: aload_0
    //   43: getfield 31	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:a	Landroid/view/SurfaceHolder;
    //   46: aconst_null
    //   47: invokeinterface 109 2 0
    //   52: astore 14
    //   54: aload 14
    //   56: ifnull +345 -> 401
    //   59: aload 14
    //   61: astore 13
    //   63: aload 14
    //   65: astore 12
    //   67: new 111	android/graphics/Paint
    //   70: dup
    //   71: invokespecial 112	android/graphics/Paint:<init>	()V
    //   74: astore 15
    //   76: aload 14
    //   78: astore 13
    //   80: aload 14
    //   82: astore 12
    //   84: aload 15
    //   86: new 114	android/graphics/PorterDuffXfermode
    //   89: dup
    //   90: getstatic 120	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   93: invokespecial 123	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   96: invokevirtual 127	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   99: pop
    //   100: aload 14
    //   102: astore 13
    //   104: aload 14
    //   106: astore 12
    //   108: aload 14
    //   110: aload 15
    //   112: invokevirtual 133	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   115: aload 14
    //   117: astore 13
    //   119: aload 14
    //   121: astore 12
    //   123: aload 15
    //   125: new 114	android/graphics/PorterDuffXfermode
    //   128: dup
    //   129: getstatic 136	android/graphics/PorterDuff$Mode:SRC_OVER	Landroid/graphics/PorterDuff$Mode;
    //   132: invokespecial 123	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   135: invokevirtual 127	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   138: pop
    //   139: aload 14
    //   141: astore 13
    //   143: aload 14
    //   145: astore 12
    //   147: aload 15
    //   149: iconst_1
    //   150: invokevirtual 140	android/graphics/Paint:setFilterBitmap	(Z)V
    //   153: aload 14
    //   155: astore 13
    //   157: aload 14
    //   159: astore 12
    //   161: aload 15
    //   163: iconst_1
    //   164: invokevirtual 143	android/graphics/Paint:setAntiAlias	(Z)V
    //   167: aload 14
    //   169: astore 13
    //   171: aload 14
    //   173: astore 12
    //   175: new 145	android/graphics/Rect
    //   178: dup
    //   179: invokespecial 146	android/graphics/Rect:<init>	()V
    //   182: astore 16
    //   184: iload_3
    //   185: ifeq +240 -> 425
    //   188: iload 4
    //   190: ifeq +235 -> 425
    //   193: aload 14
    //   195: astore 13
    //   197: aload 14
    //   199: astore 12
    //   201: aload 16
    //   203: iconst_0
    //   204: putfield 149	android/graphics/Rect:top	I
    //   207: aload 14
    //   209: astore 13
    //   211: aload 14
    //   213: astore 12
    //   215: aload 16
    //   217: iconst_0
    //   218: putfield 152	android/graphics/Rect:left	I
    //   221: aload 14
    //   223: astore 13
    //   225: aload 14
    //   227: astore 12
    //   229: aload 16
    //   231: iload 9
    //   233: putfield 155	android/graphics/Rect:right	I
    //   236: aload 14
    //   238: astore 13
    //   240: aload 14
    //   242: astore 12
    //   244: aload 16
    //   246: iload 10
    //   248: putfield 158	android/graphics/Rect:bottom	I
    //   251: aload 14
    //   253: astore 13
    //   255: aload 14
    //   257: astore 12
    //   259: invokestatic 164	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   262: ifeq +97 -> 359
    //   265: aload 14
    //   267: astore 13
    //   269: aload 14
    //   271: astore 12
    //   273: ldc 67
    //   275: iconst_1
    //   276: new 69	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   283: ldc 166
    //   285: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 9
    //   290: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc 168
    //   295: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 10
    //   300: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc 170
    //   305: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_3
    //   309: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: ldc 175
    //   314: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 4
    //   319: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   322: ldc 177
    //   324: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 7
    //   329: invokevirtual 178	android/graphics/Rect:toString	()Ljava/lang/String;
    //   332: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc 180
    //   337: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 16
    //   342: invokevirtual 178	android/graphics/Rect:toString	()Ljava/lang/String;
    //   345: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: ldc 182
    //   350: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 188	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload_2
    //   360: ifnull +22 -> 382
    //   363: aload 14
    //   365: astore 13
    //   367: aload 14
    //   369: astore 12
    //   371: aload 14
    //   373: aload_2
    //   374: aconst_null
    //   375: aload 16
    //   377: aload 15
    //   379: invokevirtual 192	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   382: aload 14
    //   384: astore 13
    //   386: aload 14
    //   388: astore 12
    //   390: aload 14
    //   392: aload_1
    //   393: aconst_null
    //   394: aload 16
    //   396: aload 15
    //   398: invokevirtual 192	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   401: aload 14
    //   403: ifnull +21 -> 424
    //   406: aload_0
    //   407: getfield 194	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:Zf	Z
    //   410: ifeq +14 -> 424
    //   413: aload_0
    //   414: getfield 31	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:a	Landroid/view/SurfaceHolder;
    //   417: aload 14
    //   419: invokeinterface 198 2 0
    //   424: return
    //   425: iload_3
    //   426: ifeq +165 -> 591
    //   429: aload 14
    //   431: astore 13
    //   433: aload 14
    //   435: astore 12
    //   437: aload 16
    //   439: iconst_0
    //   440: putfield 152	android/graphics/Rect:left	I
    //   443: aload 14
    //   445: astore 13
    //   447: aload 14
    //   449: astore 12
    //   451: aload 16
    //   453: iload 9
    //   455: putfield 155	android/graphics/Rect:right	I
    //   458: aload 14
    //   460: astore 13
    //   462: aload 14
    //   464: astore 12
    //   466: aload 16
    //   468: invokevirtual 201	android/graphics/Rect:width	()I
    //   471: aload_1
    //   472: invokevirtual 204	android/graphics/Bitmap:getHeight	()I
    //   475: imul
    //   476: aload_1
    //   477: invokevirtual 205	android/graphics/Bitmap:getWidth	()I
    //   480: idiv
    //   481: istore 11
    //   483: aload 14
    //   485: astore 13
    //   487: aload 14
    //   489: astore 12
    //   491: aload 16
    //   493: aload 7
    //   495: getfield 149	android/graphics/Rect:top	I
    //   498: i2f
    //   499: aload_0
    //   500: getfield 60	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mDensity	F
    //   503: fmul
    //   504: f2i
    //   505: putfield 149	android/graphics/Rect:top	I
    //   508: aload 14
    //   510: astore 13
    //   512: aload 14
    //   514: astore 12
    //   516: aload 16
    //   518: iload 11
    //   520: aload 16
    //   522: getfield 149	android/graphics/Rect:top	I
    //   525: iadd
    //   526: putfield 158	android/graphics/Rect:bottom	I
    //   529: goto -278 -> 251
    //   532: astore_1
    //   533: aload 13
    //   535: astore 12
    //   537: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +16 -> 556
    //   543: aload 13
    //   545: astore 12
    //   547: ldc 67
    //   549: iconst_2
    //   550: ldc 210
    //   552: aload_1
    //   553: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: aload 13
    //   558: ifnull -134 -> 424
    //   561: aload_0
    //   562: getfield 194	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:Zf	Z
    //   565: ifeq -141 -> 424
    //   568: aload_0
    //   569: getfield 31	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:a	Landroid/view/SurfaceHolder;
    //   572: aload 13
    //   574: invokeinterface 198 2 0
    //   579: return
    //   580: astore_1
    //   581: ldc 67
    //   583: aload_1
    //   584: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokestatic 220	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: return
    //   591: iload 4
    //   593: ifeq +132 -> 725
    //   596: aload 14
    //   598: astore 13
    //   600: aload 14
    //   602: astore 12
    //   604: aload 16
    //   606: iconst_0
    //   607: putfield 149	android/graphics/Rect:top	I
    //   610: aload 14
    //   612: astore 13
    //   614: aload 14
    //   616: astore 12
    //   618: aload 16
    //   620: iload 10
    //   622: putfield 158	android/graphics/Rect:bottom	I
    //   625: aload 14
    //   627: astore 13
    //   629: aload 14
    //   631: astore 12
    //   633: aload 16
    //   635: invokevirtual 223	android/graphics/Rect:height	()I
    //   638: aload_1
    //   639: invokevirtual 205	android/graphics/Bitmap:getWidth	()I
    //   642: imul
    //   643: aload_1
    //   644: invokevirtual 204	android/graphics/Bitmap:getHeight	()I
    //   647: idiv
    //   648: istore 11
    //   650: aload 14
    //   652: astore 13
    //   654: aload 14
    //   656: astore 12
    //   658: aload 16
    //   660: aload 7
    //   662: getfield 152	android/graphics/Rect:left	I
    //   665: i2f
    //   666: aload_0
    //   667: getfield 60	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mDensity	F
    //   670: fmul
    //   671: f2i
    //   672: putfield 152	android/graphics/Rect:left	I
    //   675: aload 14
    //   677: astore 13
    //   679: aload 14
    //   681: astore 12
    //   683: aload 16
    //   685: iload 11
    //   687: aload 16
    //   689: getfield 152	android/graphics/Rect:left	I
    //   692: iadd
    //   693: putfield 155	android/graphics/Rect:right	I
    //   696: goto -445 -> 251
    //   699: astore_1
    //   700: aload 12
    //   702: ifnull +21 -> 723
    //   705: aload_0
    //   706: getfield 194	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:Zf	Z
    //   709: ifeq +14 -> 723
    //   712: aload_0
    //   713: getfield 31	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:a	Landroid/view/SurfaceHolder;
    //   716: aload 12
    //   718: invokeinterface 198 2 0
    //   723: aload_1
    //   724: athrow
    //   725: iload 5
    //   727: ifne -476 -> 251
    //   730: iload 6
    //   732: ifne -481 -> 251
    //   735: iload 5
    //   737: ifne -486 -> 251
    //   740: iload 6
    //   742: ifne -491 -> 251
    //   745: aload 14
    //   747: astore 13
    //   749: aload 14
    //   751: astore 12
    //   753: aload 16
    //   755: aload 7
    //   757: invokevirtual 227	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   760: fconst_1
    //   761: fstore 8
    //   763: aload 14
    //   765: astore 13
    //   767: aload 14
    //   769: astore 12
    //   771: aload 14
    //   773: invokevirtual 228	android/graphics/Canvas:getWidth	()I
    //   776: istore 11
    //   778: aload 14
    //   780: astore 13
    //   782: aload 14
    //   784: astore 12
    //   786: iload 11
    //   788: aload_0
    //   789: getfield 65	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mScreenWidth	I
    //   792: if_icmpeq +22 -> 814
    //   795: aload 14
    //   797: astore 13
    //   799: aload 14
    //   801: astore 12
    //   803: iload 11
    //   805: i2f
    //   806: aload_0
    //   807: getfield 65	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mScreenWidth	I
    //   810: i2f
    //   811: fdiv
    //   812: fstore 8
    //   814: aload 14
    //   816: astore 13
    //   818: aload 14
    //   820: astore 12
    //   822: fload 8
    //   824: aload_0
    //   825: getfield 60	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mDensity	F
    //   828: fconst_2
    //   829: fdiv
    //   830: fmul
    //   831: fstore 8
    //   833: aload 14
    //   835: astore 13
    //   837: aload 14
    //   839: astore 12
    //   841: invokestatic 164	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   844: ifeq +67 -> 911
    //   847: aload 14
    //   849: astore 13
    //   851: aload 14
    //   853: astore 12
    //   855: ldc 67
    //   857: iconst_1
    //   858: new 69	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   865: ldc 230
    //   867: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: fload 8
    //   872: invokevirtual 85	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   875: ldc 232
    //   877: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload_0
    //   881: getfield 60	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:mDensity	F
    //   884: invokevirtual 85	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   887: ldc 180
    //   889: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload 16
    //   894: invokevirtual 178	android/graphics/Rect:toString	()Ljava/lang/String;
    //   897: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: ldc 182
    //   902: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 188	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: aload 14
    //   913: astore 13
    //   915: aload 14
    //   917: astore 12
    //   919: aload 16
    //   921: aload 16
    //   923: getfield 152	android/graphics/Rect:left	I
    //   926: i2f
    //   927: fload 8
    //   929: fmul
    //   930: f2i
    //   931: putfield 152	android/graphics/Rect:left	I
    //   934: aload 14
    //   936: astore 13
    //   938: aload 14
    //   940: astore 12
    //   942: aload 16
    //   944: aload 16
    //   946: getfield 149	android/graphics/Rect:top	I
    //   949: i2f
    //   950: fload 8
    //   952: fmul
    //   953: f2i
    //   954: putfield 149	android/graphics/Rect:top	I
    //   957: aload 14
    //   959: astore 13
    //   961: aload 14
    //   963: astore 12
    //   965: aload 16
    //   967: aload 16
    //   969: getfield 155	android/graphics/Rect:right	I
    //   972: i2f
    //   973: fload 8
    //   975: fmul
    //   976: f2i
    //   977: putfield 155	android/graphics/Rect:right	I
    //   980: aload 14
    //   982: astore 13
    //   984: aload 14
    //   986: astore 12
    //   988: aload 16
    //   990: fload 8
    //   992: aload 16
    //   994: getfield 158	android/graphics/Rect:bottom	I
    //   997: i2f
    //   998: fmul
    //   999: f2i
    //   1000: putfield 158	android/graphics/Rect:bottom	I
    //   1003: goto -752 -> 251
    //   1006: astore_1
    //   1007: ldc 67
    //   1009: aload_1
    //   1010: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1013: invokestatic 220	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: return
    //   1017: astore_2
    //   1018: ldc 67
    //   1020: aload_2
    //   1021: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1024: invokestatic 220	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
    //   1027: goto -304 -> 723
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1030	0	this	MagicfaceViewForAV
    //   0	1030	1	paramBitmap1	android.graphics.Bitmap
    //   0	1030	2	paramBitmap2	android.graphics.Bitmap
    //   0	1030	3	paramBoolean1	boolean
    //   0	1030	4	paramBoolean2	boolean
    //   0	1030	5	paramBoolean3	boolean
    //   0	1030	6	paramBoolean4	boolean
    //   0	1030	7	paramRect	android.graphics.Rect
    //   761	230	8	f	float
    //   18	436	9	i	int
    //   32	589	10	j	int
    //   481	323	11	k	int
    //   12	975	12	localObject	java.lang.Object
    //   8	975	13	localCanvas1	android.graphics.Canvas
    //   4	981	14	localCanvas2	android.graphics.Canvas
    //   1	396	15	localPaint	android.graphics.Paint
    //   182	811	16	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   14	20	532	java/lang/Exception
    //   28	34	532	java/lang/Exception
    //   42	54	532	java/lang/Exception
    //   67	76	532	java/lang/Exception
    //   84	100	532	java/lang/Exception
    //   108	115	532	java/lang/Exception
    //   123	139	532	java/lang/Exception
    //   147	153	532	java/lang/Exception
    //   161	167	532	java/lang/Exception
    //   175	184	532	java/lang/Exception
    //   201	207	532	java/lang/Exception
    //   215	221	532	java/lang/Exception
    //   229	236	532	java/lang/Exception
    //   244	251	532	java/lang/Exception
    //   259	265	532	java/lang/Exception
    //   273	359	532	java/lang/Exception
    //   371	382	532	java/lang/Exception
    //   390	401	532	java/lang/Exception
    //   437	443	532	java/lang/Exception
    //   451	458	532	java/lang/Exception
    //   466	483	532	java/lang/Exception
    //   491	508	532	java/lang/Exception
    //   516	529	532	java/lang/Exception
    //   604	610	532	java/lang/Exception
    //   618	625	532	java/lang/Exception
    //   633	650	532	java/lang/Exception
    //   658	675	532	java/lang/Exception
    //   683	696	532	java/lang/Exception
    //   753	760	532	java/lang/Exception
    //   771	778	532	java/lang/Exception
    //   786	795	532	java/lang/Exception
    //   803	814	532	java/lang/Exception
    //   822	833	532	java/lang/Exception
    //   841	847	532	java/lang/Exception
    //   855	911	532	java/lang/Exception
    //   919	934	532	java/lang/Exception
    //   942	957	532	java/lang/Exception
    //   965	980	532	java/lang/Exception
    //   988	1003	532	java/lang/Exception
    //   568	579	580	java/lang/Exception
    //   14	20	699	finally
    //   28	34	699	finally
    //   42	54	699	finally
    //   67	76	699	finally
    //   84	100	699	finally
    //   108	115	699	finally
    //   123	139	699	finally
    //   147	153	699	finally
    //   161	167	699	finally
    //   175	184	699	finally
    //   201	207	699	finally
    //   215	221	699	finally
    //   229	236	699	finally
    //   244	251	699	finally
    //   259	265	699	finally
    //   273	359	699	finally
    //   371	382	699	finally
    //   390	401	699	finally
    //   437	443	699	finally
    //   451	458	699	finally
    //   466	483	699	finally
    //   491	508	699	finally
    //   516	529	699	finally
    //   537	543	699	finally
    //   547	556	699	finally
    //   604	610	699	finally
    //   618	625	699	finally
    //   633	650	699	finally
    //   658	675	699	finally
    //   683	696	699	finally
    //   753	760	699	finally
    //   771	778	699	finally
    //   786	795	699	finally
    //   803	814	699	finally
    //   822	833	699	finally
    //   841	847	699	finally
    //   855	911	699	finally
    //   919	934	699	finally
    //   942	957	699	finally
    //   965	980	699	finally
    //   988	1003	699	finally
    //   413	424	1006	java/lang/Exception
    //   712	723	1017	java/lang/Exception
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.Zf = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.Zf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV
 * JD-Core Version:    0.7.0.1
 */