import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class abjr
{
  private static TextPaint g = new TextPaint(1);
  private static HashMap<Float, Float> ik = new HashMap();
  private static HashMap<String, Integer> il = new HashMap();
  protected HashMap<String, WeakReference<Bitmap>> im = new HashMap();
  
  public static float a(abjv paramabjv1, abjv paramabjv2)
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (paramabjv1 != null)
    {
      f1 = f2;
      if (paramabjv2 != null)
      {
        f1 = x(paramabjv1.mTextSize);
        f2 = paramabjv1.mTopPadding * 2;
        f1 = (x(paramabjv2.mTextSize) + paramabjv2.mTopPadding * 2) / (f1 + f2);
      }
    }
    return f1;
  }
  
  public static float x(float paramFloat)
  {
    Float localFloat = (Float)ik.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      if (paramFloat != g.getTextSize()) {
        g.setTextSize(paramFloat);
      }
      localObject = g.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      ik.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  /* Error */
  public Bitmap a(abjv paramabjv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: getfield 99	abjv:mWidth	I
    //   14: ifeq +10 -> 24
    //   17: aload_1
    //   18: getfield 102	abjv:mHeight	I
    //   21: ifne +7 -> 28
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_3
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 105	abjr:b	(Labjv;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +48 -> 83
    //   38: aload_2
    //   39: invokevirtual 111	android/graphics/Bitmap:isRecycled	()Z
    //   42: ifne +41 -> 83
    //   45: aload_2
    //   46: astore_3
    //   47: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -24 -> 26
    //   53: ldc 118
    //   55: iconst_2
    //   56: new 120	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   63: ldc 123
    //   65: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 131	abjv:mText	Ljava/lang/CharSequence;
    //   72: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +31 -> 117
    //   89: ldc 118
    //   91: iconst_2
    //   92: new 120	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   99: ldc 144
    //   101: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: getfield 131	abjv:mText	Ljava/lang/CharSequence;
    //   108: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: new 146	android/graphics/Canvas
    //   120: dup
    //   121: invokespecial 147	android/graphics/Canvas:<init>	()V
    //   124: astore 6
    //   126: aload_1
    //   127: getfield 99	abjv:mWidth	I
    //   130: aload_1
    //   131: getfield 102	abjv:mHeight	I
    //   134: getstatic 153	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   137: invokestatic 157	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   140: astore_3
    //   141: aload 6
    //   143: aload_3
    //   144: invokevirtual 161	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   147: aload 5
    //   149: astore_2
    //   150: aload_1
    //   151: getfield 165	abjv:bgG	Ljava/lang/String;
    //   154: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +101 -> 258
    //   160: aload_0
    //   161: getfield 35	abjr:im	Ljava/util/HashMap;
    //   164: aload_1
    //   165: getfield 165	abjv:bgG	Ljava/lang/String;
    //   168: invokevirtual 61	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 173	java/lang/ref/WeakReference
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +12 -> 188
    //   179: aload_2
    //   180: invokevirtual 176	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   183: checkcast 107	android/graphics/Bitmap
    //   186: astore 4
    //   188: aload 4
    //   190: astore_2
    //   191: aload 4
    //   193: ifnonnull +65 -> 258
    //   196: aload 4
    //   198: astore_2
    //   199: new 178	java/io/File
    //   202: dup
    //   203: aload_1
    //   204: getfield 165	abjv:bgG	Ljava/lang/String;
    //   207: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 184	java/io/File:exists	()Z
    //   213: ifeq +45 -> 258
    //   216: new 186	java/io/BufferedInputStream
    //   219: dup
    //   220: new 188	java/io/FileInputStream
    //   223: dup
    //   224: aload_1
    //   225: getfield 165	abjv:bgG	Ljava/lang/String;
    //   228: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   231: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   234: invokestatic 198	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   237: astore_2
    //   238: aload_0
    //   239: getfield 35	abjr:im	Ljava/util/HashMap;
    //   242: aload_1
    //   243: getfield 165	abjv:bgG	Ljava/lang/String;
    //   246: new 173	java/lang/ref/WeakReference
    //   249: dup
    //   250: aload_2
    //   251: invokespecial 201	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   254: invokevirtual 88	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: aload_2
    //   259: ifnonnull +275 -> 534
    //   262: aload_0
    //   263: getfield 35	abjr:im	Ljava/util/HashMap;
    //   266: ldc 203
    //   268: invokevirtual 61	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   271: checkcast 173	java/lang/ref/WeakReference
    //   274: astore 4
    //   276: aload 4
    //   278: ifnull +256 -> 534
    //   281: aload 4
    //   283: invokevirtual 176	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   286: checkcast 107	android/graphics/Bitmap
    //   289: astore_2
    //   290: aload_2
    //   291: astore 4
    //   293: aload_2
    //   294: ifnonnull +36 -> 330
    //   297: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   300: invokevirtual 215	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   303: ldc 216
    //   305: aconst_null
    //   306: invokestatic 220	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   309: astore 4
    //   311: aload_0
    //   312: getfield 35	abjr:im	Ljava/util/HashMap;
    //   315: ldc 203
    //   317: new 173	java/lang/ref/WeakReference
    //   320: dup
    //   321: aload 4
    //   323: invokespecial 201	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   326: invokevirtual 88	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: aload 4
    //   332: invokevirtual 224	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   335: astore_2
    //   336: aload_2
    //   337: ifnull +84 -> 421
    //   340: new 226	android/graphics/NinePatch
    //   343: dup
    //   344: aload 4
    //   346: aload_2
    //   347: aconst_null
    //   348: invokespecial 229	android/graphics/NinePatch:<init>	(Landroid/graphics/Bitmap;[BLjava/lang/String;)V
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull +27 -> 380
    //   356: aload_2
    //   357: aload 6
    //   359: new 231	android/graphics/Rect
    //   362: dup
    //   363: iconst_0
    //   364: iconst_0
    //   365: aload_1
    //   366: getfield 99	abjv:mWidth	I
    //   369: aload_1
    //   370: getfield 102	abjv:mHeight	I
    //   373: invokespecial 234	android/graphics/Rect:<init>	(IIII)V
    //   376: aconst_null
    //   377: invokevirtual 238	android/graphics/NinePatch:draw	(Landroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   380: aload_3
    //   381: astore_2
    //   382: aload_1
    //   383: getfield 241	abjv:d	Landroid/text/StaticLayout;
    //   386: ifnull +27 -> 413
    //   389: aload 6
    //   391: aload_1
    //   392: getfield 244	abjv:mLeftPadding	I
    //   395: i2f
    //   396: aload_1
    //   397: getfield 51	abjv:mTopPadding	I
    //   400: i2f
    //   401: invokevirtual 248	android/graphics/Canvas:translate	(FF)V
    //   404: aload_1
    //   405: getfield 241	abjv:d	Landroid/text/StaticLayout;
    //   408: aload 6
    //   410: invokevirtual 253	android/text/StaticLayout:draw	(Landroid/graphics/Canvas;)V
    //   413: aload_0
    //   414: aload_1
    //   415: aload_2
    //   416: invokevirtual 256	abjr:a	(Labjv;Landroid/graphics/Bitmap;)V
    //   419: aload_2
    //   420: areturn
    //   421: aload 6
    //   423: aload 4
    //   425: new 231	android/graphics/Rect
    //   428: dup
    //   429: iconst_0
    //   430: iconst_0
    //   431: aload 4
    //   433: invokevirtual 260	android/graphics/Bitmap:getWidth	()I
    //   436: aload 4
    //   438: invokevirtual 263	android/graphics/Bitmap:getHeight	()I
    //   441: invokespecial 234	android/graphics/Rect:<init>	(IIII)V
    //   444: new 231	android/graphics/Rect
    //   447: dup
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_1
    //   451: getfield 99	abjv:mWidth	I
    //   454: aload_1
    //   455: getfield 102	abjv:mHeight	I
    //   458: invokespecial 234	android/graphics/Rect:<init>	(IIII)V
    //   461: aconst_null
    //   462: invokevirtual 267	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   465: goto -85 -> 380
    //   468: astore 4
    //   470: aload_3
    //   471: astore_2
    //   472: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -93 -> 382
    //   478: ldc 118
    //   480: iconst_2
    //   481: aload 4
    //   483: invokevirtual 270	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   486: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload_3
    //   490: astore_2
    //   491: goto -109 -> 382
    //   494: astore 4
    //   496: aload_2
    //   497: astore_3
    //   498: aload_3
    //   499: astore_2
    //   500: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -121 -> 382
    //   506: ldc 118
    //   508: iconst_2
    //   509: aload 4
    //   511: invokevirtual 274	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   514: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_3
    //   518: astore_2
    //   519: goto -137 -> 382
    //   522: astore 4
    //   524: goto -26 -> 498
    //   527: astore 4
    //   529: aload_2
    //   530: astore_3
    //   531: goto -61 -> 470
    //   534: goto -244 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	abjr
    //   0	537	1	paramabjv	abjv
    //   33	497	2	localObject1	Object
    //   25	506	3	localObject2	Object
    //   4	433	4	localObject3	Object
    //   468	14	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   494	16	4	localException1	java.lang.Exception
    //   522	1	4	localException2	java.lang.Exception
    //   527	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	147	5	localObject4	Object
    //   124	298	6	localCanvas	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   141	147	468	java/lang/OutOfMemoryError
    //   150	175	468	java/lang/OutOfMemoryError
    //   179	188	468	java/lang/OutOfMemoryError
    //   199	258	468	java/lang/OutOfMemoryError
    //   262	276	468	java/lang/OutOfMemoryError
    //   281	290	468	java/lang/OutOfMemoryError
    //   297	330	468	java/lang/OutOfMemoryError
    //   330	336	468	java/lang/OutOfMemoryError
    //   340	352	468	java/lang/OutOfMemoryError
    //   356	380	468	java/lang/OutOfMemoryError
    //   421	465	468	java/lang/OutOfMemoryError
    //   126	141	494	java/lang/Exception
    //   141	147	522	java/lang/Exception
    //   150	175	522	java/lang/Exception
    //   179	188	522	java/lang/Exception
    //   199	258	522	java/lang/Exception
    //   262	276	522	java/lang/Exception
    //   281	290	522	java/lang/Exception
    //   297	330	522	java/lang/Exception
    //   330	336	522	java/lang/Exception
    //   340	352	522	java/lang/Exception
    //   356	380	522	java/lang/Exception
    //   421	465	522	java/lang/Exception
    //   126	141	527	java/lang/OutOfMemoryError
  }
  
  public void a(abjv paramabjv)
  {
    if ((paramabjv == null) || (TextUtils.isEmpty(paramabjv.mText)) || (paramabjv.mMeasured)) {
      return;
    }
    if (g.getTextSize() != paramabjv.mTextSize) {
      g.setTextSize(paramabjv.mTextSize);
    }
    g.setColor(paramabjv.mTextColor);
    String str = paramabjv.mText + "_" + Float.valueOf(paramabjv.mTextSize);
    Integer localInteger = (Integer)il.get(str);
    Object localObject = localInteger;
    if (localInteger == null)
    {
      localObject = Integer.valueOf((int)Math.ceil(StaticLayout.getDesiredWidth(paramabjv.mText, g)));
      il.put(str, localObject);
    }
    localObject = new StaticLayout(paramabjv.mText, g, ((Integer)localObject).intValue(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
    paramabjv.mWidth = (((StaticLayout)localObject).getWidth() + paramabjv.mLeftPadding * 2);
    paramabjv.mHeight = (((StaticLayout)localObject).getHeight() + paramabjv.mTopPadding * 2);
    paramabjv.mMeasured = true;
    paramabjv.d = ((StaticLayout)localObject);
  }
  
  public abstract void a(abjv paramabjv, Bitmap paramBitmap);
  
  public abstract Bitmap b(abjv paramabjv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjr
 * JD-Core Version:    0.7.0.1
 */