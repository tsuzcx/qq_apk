package com.tencent.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import wja;

public class ProgressPieView
  extends View
{
  static LruCache<String, Typeface> J = new LruCache(8);
  public float BP = 4.0F;
  float BQ;
  float CV;
  a jdField_a_of_type_ComTencentWidgetProgressPieView$a = new a();
  b jdField_a_of_type_ComTencentWidgetProgressPieView$b = new b();
  c jdField_a_of_type_ComTencentWidgetProgressPieView$c;
  RectF bl;
  RectF bm;
  public String cAw;
  public Paint cX;
  public boolean dba;
  public boolean dbb;
  public boolean dbc = true;
  public boolean dbd = true;
  private boolean dbe;
  public boolean dbf = true;
  public int ehH = -90;
  public int ehI = 1;
  public int ehJ = 25;
  public int eul = 1;
  public int eum = 0;
  public Drawable gi;
  public Paint mBackgroundPaint;
  DisplayMetrics mDisplayMetrics;
  Rect mImageRect;
  public int mMax = 100;
  public int mProgress = 0;
  public Paint mProgressPaint;
  public boolean mShowText = true;
  public Paint mStrokePaint;
  public float mStrokeWidth = 1.5F;
  public String mText;
  public Paint mTextPaint;
  public float mTextSize = 14.0F;
  
  public ProgressPieView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  /* Error */
  void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 128	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 134	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   11: putfield 136	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 89	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   19: aload_0
    //   20: getfield 136	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   23: getfield 141	android/util/DisplayMetrics:density	F
    //   26: fmul
    //   27: putfield 89	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   35: aload_0
    //   36: getfield 136	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   39: getfield 141	android/util/DisplayMetrics:density	F
    //   42: fmul
    //   43: putfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 97	com/tencent/widget/ProgressPieView:mTextSize	F
    //   51: aload_0
    //   52: getfield 136	com/tencent/widget/ProgressPieView:mDisplayMetrics	Landroid/util/DisplayMetrics;
    //   55: getfield 144	android/util/DisplayMetrics:scaledDensity	F
    //   58: fmul
    //   59: putfield 97	com/tencent/widget/ProgressPieView:mTextSize	F
    //   62: aload_0
    //   63: ldc 145
    //   65: putfield 147	com/tencent/widget/ProgressPieView:CV	F
    //   68: aload_1
    //   69: aload_2
    //   70: getstatic 153	atau$a:ro	[I
    //   73: invokevirtual 157	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   76: astore_2
    //   77: aload_0
    //   78: invokevirtual 158	com/tencent/widget/ProgressPieView:getResources	()Landroid/content/res/Resources;
    //   81: astore_1
    //   82: aload_0
    //   83: aload_2
    //   84: bipush 7
    //   86: aload_0
    //   87: getfield 80	com/tencent/widget/ProgressPieView:mMax	I
    //   90: invokevirtual 164	android/content/res/TypedArray:getInteger	(II)I
    //   93: putfield 80	com/tencent/widget/ProgressPieView:mMax	I
    //   96: aload_0
    //   97: aload_2
    //   98: bipush 8
    //   100: aload_0
    //   101: getfield 82	com/tencent/widget/ProgressPieView:mProgress	I
    //   104: invokevirtual 164	android/content/res/TypedArray:getInteger	(II)I
    //   107: putfield 82	com/tencent/widget/ProgressPieView:mProgress	I
    //   110: aload_0
    //   111: aload_2
    //   112: bipush 15
    //   114: aload_0
    //   115: getfield 84	com/tencent/widget/ProgressPieView:ehH	I
    //   118: invokevirtual 167	android/content/res/TypedArray:getInt	(II)I
    //   121: putfield 84	com/tencent/widget/ProgressPieView:ehH	I
    //   124: aload_0
    //   125: aload_2
    //   126: bipush 6
    //   128: aload_0
    //   129: getfield 169	com/tencent/widget/ProgressPieView:dba	Z
    //   132: invokevirtual 173	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   135: putfield 169	com/tencent/widget/ProgressPieView:dba	Z
    //   138: aload_0
    //   139: aload_2
    //   140: iconst_4
    //   141: aload_0
    //   142: getfield 175	com/tencent/widget/ProgressPieView:dbb	Z
    //   145: invokevirtual 173	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   148: putfield 175	com/tencent/widget/ProgressPieView:dbb	Z
    //   151: aload_0
    //   152: aload_2
    //   153: bipush 17
    //   155: aload_0
    //   156: getfield 89	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   159: invokevirtual 179	android/content/res/TypedArray:getDimension	(IF)F
    //   162: putfield 89	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   165: aload_0
    //   166: aload_2
    //   167: bipush 12
    //   169: aload_0
    //   170: getfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   173: invokevirtual 179	android/content/res/TypedArray:getDimension	(IF)F
    //   176: putfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   179: aload_0
    //   180: aload_2
    //   181: bipush 18
    //   183: invokevirtual 183	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   186: putfield 185	com/tencent/widget/ProgressPieView:cAw	Ljava/lang/String;
    //   189: aload_0
    //   190: aload_2
    //   191: iconst_0
    //   192: aload_0
    //   193: getfield 97	com/tencent/widget/ProgressPieView:mTextSize	F
    //   196: invokevirtual 179	android/content/res/TypedArray:getDimension	(IF)F
    //   199: putfield 97	com/tencent/widget/ProgressPieView:mTextSize	F
    //   202: aload_0
    //   203: aload_2
    //   204: iconst_2
    //   205: invokevirtual 183	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   208: putfield 187	com/tencent/widget/ProgressPieView:mText	Ljava/lang/String;
    //   211: aload_0
    //   212: aload_2
    //   213: bipush 13
    //   215: aload_0
    //   216: getfield 86	com/tencent/widget/ProgressPieView:dbc	Z
    //   219: invokevirtual 173	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   222: putfield 86	com/tencent/widget/ProgressPieView:dbc	Z
    //   225: aload_0
    //   226: aload_2
    //   227: bipush 14
    //   229: aload_0
    //   230: getfield 94	com/tencent/widget/ProgressPieView:mShowText	Z
    //   233: invokevirtual 173	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   236: putfield 94	com/tencent/widget/ProgressPieView:mShowText	Z
    //   239: aload_0
    //   240: aload_2
    //   241: iconst_5
    //   242: invokevirtual 191	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   245: putfield 193	com/tencent/widget/ProgressPieView:gi	Landroid/graphics/drawable/Drawable;
    //   248: aload_0
    //   249: aload_2
    //   250: bipush 10
    //   252: aload_0
    //   253: getfield 101	com/tencent/widget/ProgressPieView:ehI	I
    //   256: invokevirtual 164	android/content/res/TypedArray:getInteger	(II)I
    //   259: putfield 101	com/tencent/widget/ProgressPieView:ehI	I
    //   262: aload_1
    //   263: ldc 194
    //   265: invokevirtual 198	android/content/res/Resources:getColor	(I)I
    //   268: istore_3
    //   269: iload_3
    //   270: istore 8
    //   272: aload_2
    //   273: iconst_3
    //   274: iload_3
    //   275: invokevirtual 200	android/content/res/TypedArray:getColor	(II)I
    //   278: istore 7
    //   280: iload 7
    //   282: istore 8
    //   284: aload_1
    //   285: ldc 201
    //   287: invokevirtual 198	android/content/res/Resources:getColor	(I)I
    //   290: istore_3
    //   291: iload_3
    //   292: istore 8
    //   294: aload_2
    //   295: bipush 9
    //   297: iload_3
    //   298: invokevirtual 200	android/content/res/TypedArray:getColor	(II)I
    //   301: istore 6
    //   303: iload 6
    //   305: istore 8
    //   307: aload_1
    //   308: ldc 201
    //   310: invokevirtual 198	android/content/res/Resources:getColor	(I)I
    //   313: istore_3
    //   314: iload_3
    //   315: istore 8
    //   317: aload_2
    //   318: bipush 11
    //   320: iload_3
    //   321: invokevirtual 200	android/content/res/TypedArray:getColor	(II)I
    //   324: istore 5
    //   326: iload 5
    //   328: istore 8
    //   330: aload_1
    //   331: ldc 202
    //   333: invokevirtual 198	android/content/res/Resources:getColor	(I)I
    //   336: istore_3
    //   337: iload_3
    //   338: istore 8
    //   340: iload 8
    //   342: istore 4
    //   344: iload 9
    //   346: istore_3
    //   347: aload_2
    //   348: bipush 16
    //   350: iload 8
    //   352: invokevirtual 200	android/content/res/TypedArray:getColor	(II)I
    //   355: istore 8
    //   357: iload 8
    //   359: istore 4
    //   361: iload 9
    //   363: istore_3
    //   364: aload_1
    //   365: ldc 203
    //   367: invokevirtual 198	android/content/res/Resources:getColor	(I)I
    //   370: istore 9
    //   372: iload 8
    //   374: istore 4
    //   376: iload 9
    //   378: istore_3
    //   379: aload_2
    //   380: iconst_1
    //   381: iload 9
    //   383: invokevirtual 200	android/content/res/TypedArray:getColor	(II)I
    //   386: istore 9
    //   388: iload 9
    //   390: istore_3
    //   391: iload_3
    //   392: istore 9
    //   394: iload 8
    //   396: istore 10
    //   398: iload 5
    //   400: istore 11
    //   402: iload 6
    //   404: istore 12
    //   406: iload 7
    //   408: istore 13
    //   410: aload_2
    //   411: ifnull +26 -> 437
    //   414: aload_2
    //   415: invokevirtual 206	android/content/res/TypedArray:recycle	()V
    //   418: iload 7
    //   420: istore 13
    //   422: iload 6
    //   424: istore 12
    //   426: iload 5
    //   428: istore 11
    //   430: iload 8
    //   432: istore 10
    //   434: iload_3
    //   435: istore 9
    //   437: aload_0
    //   438: new 208	android/graphics/Paint
    //   441: dup
    //   442: iconst_1
    //   443: invokespecial 209	android/graphics/Paint:<init>	(I)V
    //   446: putfield 211	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   449: aload_0
    //   450: getfield 211	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   453: iload 13
    //   455: invokevirtual 214	android/graphics/Paint:setColor	(I)V
    //   458: aload_0
    //   459: getfield 211	com/tencent/widget/ProgressPieView:mBackgroundPaint	Landroid/graphics/Paint;
    //   462: getstatic 220	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   465: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   468: aload_0
    //   469: new 208	android/graphics/Paint
    //   472: dup
    //   473: iconst_1
    //   474: invokespecial 209	android/graphics/Paint:<init>	(I)V
    //   477: putfield 226	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   480: aload_0
    //   481: new 208	android/graphics/Paint
    //   484: dup
    //   485: iconst_1
    //   486: invokespecial 209	android/graphics/Paint:<init>	(I)V
    //   489: putfield 228	com/tencent/widget/ProgressPieView:cX	Landroid/graphics/Paint;
    //   492: aload_0
    //   493: getfield 226	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   496: iload 12
    //   498: invokevirtual 214	android/graphics/Paint:setColor	(I)V
    //   501: aload_0
    //   502: getfield 228	com/tencent/widget/ProgressPieView:cX	Landroid/graphics/Paint;
    //   505: iload 11
    //   507: invokevirtual 214	android/graphics/Paint:setColor	(I)V
    //   510: aload_0
    //   511: getfield 101	com/tencent/widget/ProgressPieView:ehI	I
    //   514: iconst_1
    //   515: if_icmpne +242 -> 757
    //   518: aload_0
    //   519: getfield 226	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   522: getstatic 231	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   525: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   528: aload_0
    //   529: getfield 226	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   532: aload_0
    //   533: getfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   536: invokevirtual 235	android/graphics/Paint:setStrokeWidth	(F)V
    //   539: aload_0
    //   540: getfield 228	com/tencent/widget/ProgressPieView:cX	Landroid/graphics/Paint;
    //   543: getstatic 231	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   546: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   549: aload_0
    //   550: getfield 228	com/tencent/widget/ProgressPieView:cX	Landroid/graphics/Paint;
    //   553: aload_0
    //   554: getfield 92	com/tencent/widget/ProgressPieView:BP	F
    //   557: invokevirtual 235	android/graphics/Paint:setStrokeWidth	(F)V
    //   560: aload_0
    //   561: new 208	android/graphics/Paint
    //   564: dup
    //   565: iconst_1
    //   566: invokespecial 209	android/graphics/Paint:<init>	(I)V
    //   569: putfield 237	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   572: aload_0
    //   573: getfield 237	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   576: iload 10
    //   578: invokevirtual 214	android/graphics/Paint:setColor	(I)V
    //   581: aload_0
    //   582: getfield 237	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   585: getstatic 231	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   588: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   591: aload_0
    //   592: getfield 237	com/tencent/widget/ProgressPieView:mStrokePaint	Landroid/graphics/Paint;
    //   595: aload_0
    //   596: getfield 89	com/tencent/widget/ProgressPieView:mStrokeWidth	F
    //   599: invokevirtual 235	android/graphics/Paint:setStrokeWidth	(F)V
    //   602: aload_0
    //   603: new 208	android/graphics/Paint
    //   606: dup
    //   607: iconst_1
    //   608: invokespecial 209	android/graphics/Paint:<init>	(I)V
    //   611: putfield 239	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   614: aload_0
    //   615: getfield 239	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   618: iload 9
    //   620: invokevirtual 214	android/graphics/Paint:setColor	(I)V
    //   623: aload_0
    //   624: getfield 239	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   627: aload_0
    //   628: getfield 97	com/tencent/widget/ProgressPieView:mTextSize	F
    //   631: invokevirtual 242	android/graphics/Paint:setTextSize	(F)V
    //   634: aload_0
    //   635: getfield 239	com/tencent/widget/ProgressPieView:mTextPaint	Landroid/graphics/Paint;
    //   638: getstatic 248	android/graphics/Paint$Align:CENTER	Landroid/graphics/Paint$Align;
    //   641: invokevirtual 252	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   644: aload_0
    //   645: new 254	android/graphics/RectF
    //   648: dup
    //   649: invokespecial 256	android/graphics/RectF:<init>	()V
    //   652: putfield 258	com/tencent/widget/ProgressPieView:bl	Landroid/graphics/RectF;
    //   655: aload_0
    //   656: new 260	android/graphics/Rect
    //   659: dup
    //   660: invokespecial 261	android/graphics/Rect:<init>	()V
    //   663: putfield 263	com/tencent/widget/ProgressPieView:mImageRect	Landroid/graphics/Rect;
    //   666: aload_0
    //   667: new 254	android/graphics/RectF
    //   670: dup
    //   671: invokespecial 256	android/graphics/RectF:<init>	()V
    //   674: putfield 265	com/tencent/widget/ProgressPieView:bm	Landroid/graphics/RectF;
    //   677: return
    //   678: astore_1
    //   679: iconst_0
    //   680: istore 4
    //   682: iconst_0
    //   683: istore 5
    //   685: iconst_0
    //   686: istore 6
    //   688: iconst_0
    //   689: istore 7
    //   691: iconst_0
    //   692: istore_3
    //   693: aload_1
    //   694: invokevirtual 268	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   697: iload_3
    //   698: istore 9
    //   700: iload 4
    //   702: istore 10
    //   704: iload 5
    //   706: istore 11
    //   708: iload 6
    //   710: istore 12
    //   712: iload 7
    //   714: istore 13
    //   716: aload_2
    //   717: ifnull -280 -> 437
    //   720: aload_2
    //   721: invokevirtual 206	android/content/res/TypedArray:recycle	()V
    //   724: iload_3
    //   725: istore 9
    //   727: iload 4
    //   729: istore 10
    //   731: iload 5
    //   733: istore 11
    //   735: iload 6
    //   737: istore 12
    //   739: iload 7
    //   741: istore 13
    //   743: goto -306 -> 437
    //   746: astore_1
    //   747: aload_2
    //   748: ifnull +7 -> 755
    //   751: aload_2
    //   752: invokevirtual 206	android/content/res/TypedArray:recycle	()V
    //   755: aload_1
    //   756: athrow
    //   757: aload_0
    //   758: getfield 226	com/tencent/widget/ProgressPieView:mProgressPaint	Landroid/graphics/Paint;
    //   761: getstatic 220	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   764: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   767: aload_0
    //   768: getfield 228	com/tencent/widget/ProgressPieView:cX	Landroid/graphics/Paint;
    //   771: getstatic 220	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   774: invokevirtual 224	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   777: goto -217 -> 560
    //   780: astore_1
    //   781: iconst_0
    //   782: istore 4
    //   784: iconst_0
    //   785: istore 5
    //   787: iconst_0
    //   788: istore 6
    //   790: iconst_0
    //   791: istore_3
    //   792: iload 8
    //   794: istore 7
    //   796: goto -103 -> 693
    //   799: astore_1
    //   800: iconst_0
    //   801: istore 4
    //   803: iconst_0
    //   804: istore 5
    //   806: iconst_0
    //   807: istore_3
    //   808: iload 8
    //   810: istore 6
    //   812: goto -119 -> 693
    //   815: astore_1
    //   816: iconst_0
    //   817: istore 4
    //   819: iconst_0
    //   820: istore_3
    //   821: iload 8
    //   823: istore 5
    //   825: goto -132 -> 693
    //   828: astore_1
    //   829: goto -136 -> 693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	ProgressPieView
    //   0	832	1	paramContext	Context
    //   0	832	2	paramAttributeSet	AttributeSet
    //   268	553	3	i	int
    //   342	476	4	j	int
    //   324	500	5	k	int
    //   301	510	6	m	int
    //   278	517	7	n	int
    //   270	552	8	i1	int
    //   1	725	9	i2	int
    //   396	334	10	i3	int
    //   400	334	11	i4	int
    //   404	334	12	i5	int
    //   408	334	13	i6	int
    // Exception table:
    //   from	to	target	type
    //   262	269	678	android/content/res/Resources$NotFoundException
    //   262	269	746	finally
    //   272	280	746	finally
    //   284	291	746	finally
    //   294	303	746	finally
    //   307	314	746	finally
    //   317	326	746	finally
    //   330	337	746	finally
    //   347	357	746	finally
    //   364	372	746	finally
    //   379	388	746	finally
    //   693	697	746	finally
    //   272	280	780	android/content/res/Resources$NotFoundException
    //   284	291	780	android/content/res/Resources$NotFoundException
    //   294	303	799	android/content/res/Resources$NotFoundException
    //   307	314	799	android/content/res/Resources$NotFoundException
    //   317	326	815	android/content/res/Resources$NotFoundException
    //   330	337	815	android/content/res/Resources$NotFoundException
    //   347	357	828	android/content/res/Resources$NotFoundException
    //   364	372	828	android/content/res/Resources$NotFoundException
    //   379	388	828	android/content/res/Resources$NotFoundException
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.bl.set(0.0F, 0.0F, this.BQ, this.BQ);
    this.bl.offset((getWidth() - this.BQ) / 2.0F, (getHeight() - this.BQ) / 2.0F);
    int i;
    if (this.dbc)
    {
      i = (int)(this.mStrokePaint.getStrokeWidth() / 2.0F + 0.5F);
      this.bl.inset(i, i);
    }
    float f3 = this.bl.centerX();
    float f4 = this.bl.centerY();
    float f2;
    float f1;
    if (this.dbf)
    {
      this.bm.set(this.bl);
      paramCanvas.drawArc(this.bm, 0.0F, 360.0F, true, this.mBackgroundPaint);
      switch (this.ehI)
      {
      default: 
        throw new IllegalArgumentException("Invalid Progress Fill = " + this.ehI);
      case 0: 
      case 1: 
        f2 = this.mProgress * 360 / this.mMax;
        f1 = f2;
        if (this.dba) {
          f1 = f2 - 360.0F;
        }
        if (this.dbb) {
          f1 = -f1;
        }
        break;
      }
    }
    for (;;)
    {
      if (this.ehI == 0)
      {
        paramCanvas.drawArc(this.bm, this.ehH, f1, true, this.mProgressPaint);
        if ((!TextUtils.isEmpty(this.mText)) && (this.mShowText))
        {
          if (!TextUtils.isEmpty(this.cAw))
          {
            Typeface localTypeface2 = (Typeface)J.get(this.cAw);
            Typeface localTypeface1 = localTypeface2;
            if (localTypeface2 == null)
            {
              localTypeface1 = localTypeface2;
              if (getResources() != null)
              {
                AssetManager localAssetManager = getResources().getAssets();
                localTypeface1 = localTypeface2;
                if (localAssetManager != null)
                {
                  localTypeface1 = Typeface.createFromAsset(localAssetManager, this.cAw);
                  J.put(this.cAw, localTypeface1);
                }
              }
            }
            this.mTextPaint.setTypeface(localTypeface1);
          }
          i = (int)f3;
          int j = (int)(f4 - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F);
          paramCanvas.drawText(this.mText, i, j, this.mTextPaint);
        }
        if ((this.gi != null) && (this.dbd))
        {
          if (!this.dbe) {
            break label722;
          }
          this.mImageRect.set(0, 0, getWidth(), getHeight());
        }
      }
      for (;;)
      {
        this.gi.setBounds(this.mImageRect);
        this.gi.draw(paramCanvas);
        if ((this.dbc) && (this.dbf)) {
          paramCanvas.drawOval(this.bl, this.mStrokePaint);
        }
        return;
        i = (int)(this.mProgressPaint.getStrokeWidth() / 2.0F + 0.5F);
        this.bm.inset(i, i);
        if (this.eum == 1)
        {
          if (this.mProgress >= 500)
          {
            i = 180000 / this.mMax;
            paramCanvas.drawArc(this.bm, this.ehH, i, false, this.cX);
            paramCanvas.drawArc(this.bm, this.ehH + i, f1 - i, false, this.mProgressPaint);
            break;
          }
          paramCanvas.drawArc(this.bm, this.ehH, f1, false, this.cX);
          break;
        }
        paramCanvas.drawArc(this.bm, this.ehH, f1, false, this.mProgressPaint);
        break;
        f2 = this.BQ / 2.0F * (this.mProgress / this.mMax);
        f1 = f2;
        if (this.dbc) {
          f1 = f2 + 0.5F - this.mStrokePaint.getStrokeWidth();
        }
        paramCanvas.drawCircle(f3, f4, f1, this.mProgressPaint);
        break;
        label722:
        i = this.gi.getIntrinsicWidth();
        this.mImageRect.set(0, 0, i, i);
        this.mImageRect.offset((getWidth() - i) / 2, (getHeight() - i) / 2);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = resolveSize(wja.dp2px(this.CV, getResources()), paramInt1);
    paramInt2 = resolveSize(wja.dp2px(this.CV, getResources()), paramInt2);
    this.BQ = Math.min(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setAnimationSpeed(int paramInt)
  {
    this.ehJ = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCounterclockwise(boolean paramBoolean)
  {
    this.dbb = paramBoolean;
  }
  
  public void setDefaultViewSize(int paramInt)
  {
    if (Float.compare(this.CV, paramInt) != 0)
    {
      this.CV = paramInt;
      invalidate();
    }
  }
  
  public void setDrawImageFillView(boolean paramBoolean)
  {
    this.dbe = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.gi = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.gi = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.dba = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt < this.mProgress)) {
      throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mProgress) }));
    }
    this.mMax = paramInt;
    invalidate();
  }
  
  public void setOnProgressListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$c = paramc;
  }
  
  public void setPregressPreColor(int paramInt)
  {
    this.cX.setColor(paramInt);
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt > this.mMax) || (paramInt < 0)) {
      throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.mMax) }));
    }
    this.mProgress = paramInt;
    invalidate();
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView$c != null)
    {
      if (this.mProgress == this.mMax) {
        this.jdField_a_of_type_ComTencentWidgetProgressPieView$c.btJ();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$c.onProgressChanged(this.mProgress, this.mMax);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgressFillType(int paramInt)
  {
    this.ehI = paramInt;
    if (paramInt == 1)
    {
      this.mProgressPaint.setStyle(Paint.Style.STROKE);
      this.mProgressPaint.setStrokeWidth(this.BP);
      return;
    }
    this.mProgressPaint.setStyle(Paint.Style.FILL);
  }
  
  public void setProgressPreType(int paramInt)
  {
    this.eum = paramInt;
  }
  
  public void setProgressStrokeWidth(int paramInt)
  {
    if (this.mProgressPaint.getStyle() == Paint.Style.STROKE)
    {
      this.BP = (paramInt * this.mDisplayMetrics.density);
      this.mProgressPaint.setStrokeWidth(this.BP);
      invalidate();
    }
  }
  
  public void setShowImage(boolean paramBoolean)
  {
    this.dbd = paramBoolean;
    invalidate();
  }
  
  public void setShowStroke(boolean paramBoolean)
  {
    this.dbc = paramBoolean;
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.mShowText = paramBoolean;
    invalidate();
  }
  
  public void setStartAngle(int paramInt)
  {
    this.ehH = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.mStrokePaint.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = (paramInt * this.mDisplayMetrics.density);
    this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.mTextSize = (paramInt * this.mDisplayMetrics.scaledDensity);
    this.mTextPaint.setTextSize(this.mTextSize);
    invalidate();
  }
  
  public void setTypeface(String paramString)
  {
    this.cAw = paramString;
    invalidate();
  }
  
  class a
    extends Handler
  {
    boolean caK;
    int ehK;
    
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (ProgressPieView.this.mProgress > this.ehK)
      {
        ProgressPieView.this.setProgress(ProgressPieView.this.mProgress - 1);
        sendEmptyMessageDelayed(0, ProgressPieView.this.ehJ);
      }
      do
      {
        return;
        if (ProgressPieView.this.mProgress < this.ehK)
        {
          int i = ProgressPieView.this.mProgress + ProgressPieView.this.eul;
          if (i <= this.ehK) {
            ProgressPieView.this.setProgress(i);
          }
          for (;;)
          {
            sendEmptyMessageDelayed(0, ProgressPieView.this.ehJ);
            return;
            ProgressPieView.this.setProgress(this.ehK);
          }
        }
        removeMessages(0);
      } while (!this.caK);
      ProgressPieView.this.setVisibility(4);
      ProgressPieView.this.setShowImage(false);
      ProgressPieView.this.dbf = true;
      this.caK = false;
    }
  }
  
  class b
    extends Handler
  {
    long startTime;
    
    b() {}
    
    public void handleMessage(Message paramMessage)
    {
      int i = (int)(SystemClock.elapsedRealtime() - this.startTime);
      if (i < ProgressPieView.this.mMax)
      {
        ProgressPieView.this.setProgress(i);
        sendEmptyMessageDelayed(0, 1L);
        return;
      }
      ProgressPieView.this.setProgress(ProgressPieView.this.mMax);
    }
  }
  
  public static abstract interface c
  {
    public abstract void btJ();
    
    public abstract void onProgressChanged(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ProgressPieView
 * JD-Core Version:    0.7.0.1
 */