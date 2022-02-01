package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import aqqe;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FriendProfileCardBgDrawable
  extends Drawable
  implements Runnable
{
  private aqqe a;
  public a a;
  private Rect aX;
  private Rect aY;
  public Object bN;
  private final byte[] cp = new byte[0];
  public Bitmap dC;
  private Bitmap dD;
  public boolean isDynamic;
  private Bitmap mBackground;
  public Bitmap mBitmap;
  public int mCurFrameIndex = -1;
  public boolean mDecodeNextFrameEnd = true;
  public boolean mFinished;
  private int mFrameCount;
  public int mFrameDelay = 50;
  private int mHeight;
  private Paint mPaint = new Paint(6);
  public boolean mPaused;
  private boolean mRecycled;
  public int mRepeatCount;
  public Resources mResources;
  private int mWidth;
  public Handler sHandler = new Handler(Looper.getMainLooper());
  
  public FriendProfileCardBgDrawable(Resources paramResources, aqqe paramaqqe)
  {
    this.mResources = paramResources;
    this.jdField_a_of_type_Aqqe = paramaqqe;
    if (paramaqqe != null)
    {
      if (paramaqqe.hY != null) {
        this.isDynamic = true;
      }
      a(paramaqqe.hY, paramaqqe.mInterval, paramaqqe.cuW);
    }
  }
  
  private void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Aqqe != null) && (this.isDynamic))
    {
      float f1 = this.mWidth / paramInt1;
      float f2 = this.mHeight / paramInt2;
      int i = (int)(this.jdField_a_of_type_Aqqe.x * paramInt3);
      paramInt1 = (int)(this.jdField_a_of_type_Aqqe.y * paramInt4);
      paramInt2 = (int)(this.jdField_a_of_type_Aqqe.mWidth * paramInt3);
      paramInt3 = (int)(this.jdField_a_of_type_Aqqe.mHeight * paramInt4);
      paramInt4 = (int)(i / f1);
      paramInt1 = (int)(paramInt1 / f2);
      this.aX = new Rect(paramInt4, paramInt1, (int)(paramInt2 / f1) + paramInt4, (int)(paramInt3 / f2) + paramInt1);
    }
  }
  
  /* Error */
  private void a(String[] paramArrayOfString, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:bN	Ljava/lang/Object;
    //   5: new 130	android/graphics/BitmapFactory$Options
    //   8: dup
    //   9: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   12: astore 13
    //   14: aload 13
    //   16: iconst_1
    //   17: putfield 134	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: new 136	java/io/BufferedInputStream
    //   23: dup
    //   24: new 138	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 12
    //   37: aload 12
    //   39: astore_3
    //   40: aload 12
    //   42: aconst_null
    //   43: aload 13
    //   45: invokestatic 150	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload 12
    //   51: astore_3
    //   52: aload 13
    //   54: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   57: istore 5
    //   59: aload 12
    //   61: astore_3
    //   62: aload 13
    //   64: getfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   67: istore 6
    //   69: aload 12
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 77	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mResources	Landroid/content/res/Resources;
    //   76: invokevirtual 162	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   79: astore 13
    //   81: aload 12
    //   83: astore_3
    //   84: aload 13
    //   86: getfield 167	android/util/DisplayMetrics:widthPixels	I
    //   89: aload 13
    //   91: getfield 170	android/util/DisplayMetrics:heightPixels	I
    //   94: invokestatic 176	java/lang/Math:min	(II)I
    //   97: istore 7
    //   99: aload 12
    //   101: astore_3
    //   102: aload 13
    //   104: getfield 167	android/util/DisplayMetrics:widthPixels	I
    //   107: aload 13
    //   109: getfield 170	android/util/DisplayMetrics:heightPixels	I
    //   112: invokestatic 179	java/lang/Math:max	(II)I
    //   115: istore 8
    //   117: aload 12
    //   119: astore_3
    //   120: iload 7
    //   122: i2f
    //   123: iload 8
    //   125: i2f
    //   126: fdiv
    //   127: fstore 4
    //   129: aload 12
    //   131: astore_3
    //   132: iload 6
    //   134: iload 5
    //   136: i2f
    //   137: fload 4
    //   139: fmul
    //   140: f2i
    //   141: invokestatic 176	java/lang/Math:min	(II)I
    //   144: istore 9
    //   146: aload 12
    //   148: astore_3
    //   149: iload 9
    //   151: i2f
    //   152: fload 4
    //   154: fdiv
    //   155: f2i
    //   156: istore 10
    //   158: aload 12
    //   160: astore_3
    //   161: aload_0
    //   162: iload 9
    //   164: putfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   167: aload 12
    //   169: astore_3
    //   170: aload_0
    //   171: iload 10
    //   173: putfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   176: aload 12
    //   178: astore_3
    //   179: aload_0
    //   180: new 117	android/graphics/Rect
    //   183: dup
    //   184: iconst_0
    //   185: iconst_0
    //   186: iload 7
    //   188: iload 8
    //   190: invokespecial 119	android/graphics/Rect:<init>	(IIII)V
    //   193: putfield 181	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:aY	Landroid/graphics/Rect;
    //   196: aload 12
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 87	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:isDynamic	Z
    //   203: istore 11
    //   205: iload 11
    //   207: ifne +41 -> 248
    //   210: aload 12
    //   212: ifnull +8 -> 220
    //   215: aload 12
    //   217: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   220: return
    //   221: astore_1
    //   222: ldc 186
    //   224: iconst_1
    //   225: new 188	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   232: ldc 191
    //   234: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: return
    //   248: aload 12
    //   250: astore_3
    //   251: aload_0
    //   252: iload 7
    //   254: iload 8
    //   256: iload 6
    //   258: iload 5
    //   260: invokespecial 210	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:A	(IIII)V
    //   263: aload 12
    //   265: astore_3
    //   266: aload_0
    //   267: aload_1
    //   268: arraylength
    //   269: putfield 212	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mFrameCount	I
    //   272: aload 12
    //   274: astore_3
    //   275: aload_0
    //   276: iload_2
    //   277: putfield 51	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mFrameDelay	I
    //   280: aload 12
    //   282: astore_3
    //   283: aload_0
    //   284: ldc 213
    //   286: putfield 215	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mRepeatCount	I
    //   289: aload 12
    //   291: astore_3
    //   292: aload_0
    //   293: iconst_0
    //   294: putfield 217	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mFinished	Z
    //   297: aload 12
    //   299: ifnull -79 -> 220
    //   302: aload 12
    //   304: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   307: return
    //   308: astore_1
    //   309: ldc 186
    //   311: iconst_1
    //   312: new 188	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   319: ldc 191
    //   321: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_1
    //   325: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: return
    //   335: astore 13
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: astore_3
    //   341: ldc 186
    //   343: iconst_1
    //   344: new 188	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   351: ldc 219
    //   353: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 13
    //   358: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_1
    //   371: astore_3
    //   372: aload_0
    //   373: invokevirtual 225	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:recycle	()V
    //   376: aload_1
    //   377: ifnull -157 -> 220
    //   380: aload_1
    //   381: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   384: return
    //   385: astore_1
    //   386: ldc 186
    //   388: iconst_1
    //   389: new 188	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   396: ldc 191
    //   398: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: return
    //   412: astore_1
    //   413: aconst_null
    //   414: astore_3
    //   415: aload_3
    //   416: ifnull +7 -> 423
    //   419: aload_3
    //   420: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   423: aload_1
    //   424: athrow
    //   425: astore_3
    //   426: ldc 186
    //   428: iconst_1
    //   429: new 188	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   436: ldc 191
    //   438: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_3
    //   442: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: goto -28 -> 423
    //   454: astore_1
    //   455: goto -40 -> 415
    //   458: astore 13
    //   460: aload 12
    //   462: astore_1
    //   463: goto -124 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	FriendProfileCardBgDrawable
    //   0	466	1	paramArrayOfString	String[]
    //   0	466	2	paramInt	int
    //   0	466	3	paramString	String
    //   127	26	4	f	float
    //   57	202	5	i	int
    //   67	190	6	j	int
    //   97	156	7	k	int
    //   115	140	8	m	int
    //   144	19	9	n	int
    //   156	16	10	i1	int
    //   203	3	11	bool	boolean
    //   35	426	12	localBufferedInputStream	BufferedInputStream
    //   12	96	13	localObject	Object
    //   335	22	13	localIOException1	IOException
    //   458	1	13	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   215	220	221	java/io/IOException
    //   302	307	308	java/io/IOException
    //   0	37	335	java/io/IOException
    //   380	384	385	java/io/IOException
    //   0	37	412	finally
    //   419	423	425	java/io/IOException
    //   40	49	454	finally
    //   52	59	454	finally
    //   62	69	454	finally
    //   72	81	454	finally
    //   84	99	454	finally
    //   102	117	454	finally
    //   120	129	454	finally
    //   132	146	454	finally
    //   149	158	454	finally
    //   161	167	454	finally
    //   170	176	454	finally
    //   179	196	454	finally
    //   199	205	454	finally
    //   251	263	454	finally
    //   266	272	454	finally
    //   275	280	454	finally
    //   283	289	454	finally
    //   292	297	454	finally
    //   341	370	454	finally
    //   372	376	454	finally
    //   40	49	458	java/io/IOException
    //   52	59	458	java/io/IOException
    //   62	69	458	java/io/IOException
    //   72	81	458	java/io/IOException
    //   84	99	458	java/io/IOException
    //   102	117	458	java/io/IOException
    //   120	129	458	java/io/IOException
    //   132	146	458	java/io/IOException
    //   149	158	458	java/io/IOException
    //   161	167	458	java/io/IOException
    //   170	176	458	java/io/IOException
    //   179	196	458	java/io/IOException
    //   199	205	458	java/io/IOException
    //   251	263	458	java/io/IOException
    //   266	272	458	java/io/IOException
    //   275	280	458	java/io/IOException
    //   283	289	458	java/io/IOException
    //   292	297	458	java/io/IOException
  }
  
  @TargetApi(19)
  public static boolean b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramInt1 * paramInt2 * getBytesPerPixel(paramBitmap.getConfig()) > paramBitmap.getAllocationByteCount()) {}
    }
    while ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      return true;
      return false;
    }
    return false;
  }
  
  /* Error */
  private void bZO()
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 5
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   17: ifnonnull +103 -> 120
    //   20: aload_3
    //   21: astore_1
    //   22: new 188	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 261
    //   32: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   39: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   42: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 6
    //   50: aload_3
    //   51: astore_1
    //   52: getstatic 267	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   55: aload 6
    //   57: invokevirtual 273	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 237	android/graphics/Bitmap
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +64 -> 129
    //   68: aload_3
    //   69: astore_1
    //   70: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +37 -> 110
    //   76: aload_3
    //   77: astore_1
    //   78: ldc 186
    //   80: iconst_2
    //   81: new 188	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 279
    //   91: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   98: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   101: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_3
    //   111: astore_1
    //   112: aload_0
    //   113: aload_2
    //   114: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   117: aload 5
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   128: return
    //   129: aload_3
    //   130: astore_1
    //   131: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +37 -> 171
    //   137: aload_3
    //   138: astore_1
    //   139: ldc 186
    //   141: iconst_2
    //   142: new 188	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 284
    //   152: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   159: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   162: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_3
    //   172: astore_1
    //   173: new 130	android/graphics/BitmapFactory$Options
    //   176: dup
    //   177: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   180: astore 5
    //   182: aload_3
    //   183: astore_1
    //   184: new 136	java/io/BufferedInputStream
    //   187: dup
    //   188: new 138	java/io/FileInputStream
    //   191: dup
    //   192: aload_0
    //   193: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   196: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   199: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   202: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   205: astore_2
    //   206: aload_2
    //   207: aconst_null
    //   208: aload 5
    //   210: invokestatic 150	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   213: astore_1
    //   214: aload 5
    //   216: getfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   219: aload_0
    //   220: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   223: if_icmpne +36 -> 259
    //   226: aload 5
    //   228: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   231: aload_0
    //   232: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   235: if_icmpne +24 -> 259
    //   238: aload_0
    //   239: aload_1
    //   240: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   243: getstatic 267	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   246: aload 6
    //   248: aload_0
    //   249: getfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   252: invokevirtual 288	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   255: pop
    //   256: goto -136 -> 120
    //   259: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 186
    //   267: iconst_2
    //   268: ldc_w 290
    //   271: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_1
    //   275: ifnull +171 -> 446
    //   278: aload_0
    //   279: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   282: ifle +93 -> 375
    //   285: aload_0
    //   286: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   289: ifle +86 -> 375
    //   292: aload_0
    //   293: aload_1
    //   294: aload_1
    //   295: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   298: aload_0
    //   299: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   302: isub
    //   303: iconst_2
    //   304: idiv
    //   305: aload_1
    //   306: invokevirtual 255	android/graphics/Bitmap:getHeight	()I
    //   309: aload_0
    //   310: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   313: isub
    //   314: iconst_2
    //   315: idiv
    //   316: aload_0
    //   317: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   320: aload_0
    //   321: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   324: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   327: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   330: aload_1
    //   331: invokevirtual 295	android/graphics/Bitmap:recycle	()V
    //   334: goto -91 -> 243
    //   337: astore_3
    //   338: aload_2
    //   339: astore_1
    //   340: ldc 186
    //   342: iconst_1
    //   343: new 188	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 297
    //   353: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_3
    //   357: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_2
    //   367: ifnull -239 -> 128
    //   370: aload_2
    //   371: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   374: return
    //   375: aload_0
    //   376: aload_1
    //   377: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   380: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -53 -> 330
    //   386: ldc 186
    //   388: iconst_2
    //   389: new 188	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 299
    //   399: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   406: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: ldc_w 304
    //   412: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   419: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: goto -98 -> 330
    //   431: astore_3
    //   432: aload_2
    //   433: astore_1
    //   434: aload_3
    //   435: astore_2
    //   436: aload_1
    //   437: ifnull +7 -> 444
    //   440: aload_1
    //   441: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   444: aload_2
    //   445: athrow
    //   446: ldc 186
    //   448: iconst_1
    //   449: ldc_w 306
    //   452: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto -212 -> 243
    //   458: astore_2
    //   459: goto -23 -> 436
    //   462: astore_3
    //   463: aload 4
    //   465: astore_2
    //   466: goto -128 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	FriendProfileCardBgDrawable
    //   12	429	1	localObject1	Object
    //   10	435	2	localObject2	Object
    //   458	1	2	localObject3	Object
    //   465	1	2	localObject4	Object
    //   4	179	3	localObject5	Object
    //   337	20	3	localThrowable1	Throwable
    //   431	4	3	localObject6	Object
    //   462	1	3	localThrowable2	Throwable
    //   1	463	4	localObject7	Object
    //   6	221	5	localOptions	BitmapFactory.Options
    //   48	199	6	str	String
    // Exception table:
    //   from	to	target	type
    //   206	243	337	java/lang/Throwable
    //   243	256	337	java/lang/Throwable
    //   259	274	337	java/lang/Throwable
    //   278	330	337	java/lang/Throwable
    //   330	334	337	java/lang/Throwable
    //   375	428	337	java/lang/Throwable
    //   446	455	337	java/lang/Throwable
    //   206	243	431	finally
    //   243	256	431	finally
    //   259	274	431	finally
    //   278	330	431	finally
    //   330	334	431	finally
    //   375	428	431	finally
    //   446	455	431	finally
    //   13	20	458	finally
    //   22	50	458	finally
    //   52	64	458	finally
    //   70	76	458	finally
    //   78	110	458	finally
    //   112	117	458	finally
    //   131	137	458	finally
    //   139	171	458	finally
    //   173	182	458	finally
    //   184	206	458	finally
    //   340	366	458	finally
    //   13	20	462	java/lang/Throwable
    //   22	50	462	java/lang/Throwable
    //   52	64	462	java/lang/Throwable
    //   70	76	462	java/lang/Throwable
    //   78	110	462	java/lang/Throwable
    //   112	117	462	java/lang/Throwable
    //   131	137	462	java/lang/Throwable
    //   139	171	462	java/lang/Throwable
    //   173	182	462	java/lang/Throwable
    //   184	206	462	java/lang/Throwable
  }
  
  static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  @TargetApi(11)
  protected Bitmap a(Object paramObject, int paramInt)
    throws IOException
  {
    Object localObject = new BitmapFactory.Options();
    if (this.jdField_a_of_type_Aqqe != null)
    {
      bZO();
      if (this.isDynamic) {}
    }
    else
    {
      return null;
    }
    paramObject = (String[])paramObject;
    paramInt = (paramInt + 1) % paramObject.length;
    String str = paramObject[paramInt];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.mResources.getDisplayMetrics().densityDpi;
    ((BitmapFactory.Options)localObject).inMutable = true;
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramObject = new BufferedInputStream(new FileInputStream(paramObject[paramInt]));
    BitmapFactory.decodeStream(paramObject, null, localOptions);
    paramObject.close();
    if (this.dD != null) {}
    for (;;)
    {
      synchronized (this.cp)
      {
        if (this.dD == null) {
          break label246;
        }
        paramObject = this.dD;
        this.dD = null;
        if ((paramObject != null) && (Build.VERSION.SDK_INT > 11) && (b(paramObject, localOptions.outWidth, localOptions.outHeight)))
        {
          ((BitmapFactory.Options)localObject).inBitmap = paramObject;
          paramObject = new BufferedInputStream(new FileInputStream(str));
          localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
          paramObject.close();
          return localObject;
        }
      }
      ((BitmapFactory.Options)localObject).inBitmap = null;
      if (paramObject != null)
      {
        paramObject.recycle();
        continue;
        label246:
        paramObject = null;
        continue;
        paramObject = null;
      }
    }
  }
  
  public Bitmap ah()
  {
    if (this.mBackground == null) {}
    try
    {
      bZO();
      return this.mBackground;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardBgDrawable", 2, "decode Bg error, e.message = " + localIOException.toString());
      }
    }
  }
  
  /* Error */
  public Bitmap ai()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   8: ifnonnull +113 -> 121
    //   11: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: ldc 186
    //   19: iconst_2
    //   20: ldc_w 360
    //   23: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: new 188	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 261
    //   36: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   43: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   46: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 4
    //   54: getstatic 267	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   57: aload 4
    //   59: invokevirtual 273	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 237	android/graphics/Bitmap
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +59 -> 126
    //   70: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +35 -> 108
    //   76: ldc 186
    //   78: iconst_2
    //   79: new 188	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 362
    //   89: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   96: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   99: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_0
    //   109: aload_2
    //   110: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   121: aload_0
    //   122: getfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   125: areturn
    //   126: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +35 -> 164
    //   132: ldc 186
    //   134: iconst_2
    //   135: new 188	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 364
    //   145: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   152: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   155: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: new 130	android/graphics/BitmapFactory$Options
    //   167: dup
    //   168: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   171: astore 5
    //   173: new 136	java/io/BufferedInputStream
    //   176: dup
    //   177: new 138	java/io/FileInputStream
    //   180: dup
    //   181: aload_0
    //   182: getfield 79	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Aqqe	Laqqe;
    //   185: getfield 94	aqqe:cuW	Ljava/lang/String;
    //   188: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   191: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   194: astore_1
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: aconst_null
    //   199: aload 5
    //   201: invokestatic 150	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   204: astore_3
    //   205: aload_1
    //   206: astore_2
    //   207: aload 5
    //   209: getfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   212: aload_0
    //   213: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   216: if_icmpne +42 -> 258
    //   219: aload_1
    //   220: astore_2
    //   221: aload 5
    //   223: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   226: aload_0
    //   227: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   230: if_icmpne +28 -> 258
    //   233: aload_1
    //   234: astore_2
    //   235: aload_0
    //   236: aload_3
    //   237: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   240: aload_1
    //   241: astore_2
    //   242: getstatic 267	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   245: aload 4
    //   247: aload_0
    //   248: getfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   251: invokevirtual 288	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: goto -142 -> 113
    //   258: aload_1
    //   259: astore_2
    //   260: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +14 -> 277
    //   266: aload_1
    //   267: astore_2
    //   268: ldc 186
    //   270: iconst_2
    //   271: ldc_w 366
    //   274: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload_3
    //   278: ifnull +273 -> 551
    //   281: aload_1
    //   282: astore_2
    //   283: aload_0
    //   284: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   287: ifle +132 -> 419
    //   290: aload_1
    //   291: astore_2
    //   292: aload_0
    //   293: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   296: ifle +123 -> 419
    //   299: aload_1
    //   300: astore_2
    //   301: aload_0
    //   302: aload_3
    //   303: aload_3
    //   304: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   307: aload_0
    //   308: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   311: isub
    //   312: iconst_2
    //   313: idiv
    //   314: aload_3
    //   315: invokevirtual 255	android/graphics/Bitmap:getHeight	()I
    //   318: aload_0
    //   319: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   322: isub
    //   323: iconst_2
    //   324: idiv
    //   325: aload_0
    //   326: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   329: aload_0
    //   330: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   333: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   336: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   339: aload_1
    //   340: astore_2
    //   341: aload_3
    //   342: invokevirtual 295	android/graphics/Bitmap:recycle	()V
    //   345: goto -105 -> 240
    //   348: astore_2
    //   349: ldc 186
    //   351: iconst_1
    //   352: new 188	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 368
    //   362: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_2
    //   366: invokevirtual 357	java/io/IOException:toString	()Ljava/lang/String;
    //   369: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_1
    //   379: ifnull -258 -> 121
    //   382: aload_1
    //   383: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   386: goto -265 -> 121
    //   389: astore_1
    //   390: ldc 186
    //   392: iconst_1
    //   393: new 188	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 370
    //   403: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: goto -295 -> 121
    //   419: aload_1
    //   420: astore_2
    //   421: aload_0
    //   422: aload_3
    //   423: putfield 124	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mBackground	Landroid/graphics/Bitmap;
    //   426: aload_1
    //   427: astore_2
    //   428: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -92 -> 339
    //   434: aload_1
    //   435: astore_2
    //   436: ldc 186
    //   438: iconst_2
    //   439: new 188	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 372
    //   449: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 102	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mWidth	I
    //   456: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 304
    //   462: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_0
    //   466: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:mHeight	I
    //   469: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: goto -139 -> 339
    //   481: astore_3
    //   482: aload_1
    //   483: astore_2
    //   484: ldc 186
    //   486: iconst_1
    //   487: new 188	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   494: ldc_w 374
    //   497: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_3
    //   501: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: aload_1
    //   511: ifnull -390 -> 121
    //   514: aload_1
    //   515: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   518: goto -397 -> 121
    //   521: astore_1
    //   522: ldc 186
    //   524: iconst_1
    //   525: new 188	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 370
    //   535: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: goto -427 -> 121
    //   551: aload_1
    //   552: astore_2
    //   553: ldc 186
    //   555: iconst_1
    //   556: ldc_w 376
    //   559: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -322 -> 240
    //   565: astore_1
    //   566: aload_2
    //   567: ifnull +7 -> 574
    //   570: aload_2
    //   571: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   574: aload_1
    //   575: athrow
    //   576: astore_1
    //   577: ldc 186
    //   579: iconst_1
    //   580: new 188	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 370
    //   590: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_1
    //   594: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: goto -482 -> 121
    //   606: astore_2
    //   607: ldc 186
    //   609: iconst_1
    //   610: new 188	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 370
    //   620: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_2
    //   624: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: goto -59 -> 574
    //   636: astore_1
    //   637: aconst_null
    //   638: astore_2
    //   639: goto -73 -> 566
    //   642: astore_3
    //   643: aload_1
    //   644: astore_2
    //   645: aload_3
    //   646: astore_1
    //   647: goto -81 -> 566
    //   650: astore_3
    //   651: aconst_null
    //   652: astore_1
    //   653: goto -171 -> 482
    //   656: astore_2
    //   657: aload_3
    //   658: astore_1
    //   659: goto -310 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	FriendProfileCardBgDrawable
    //   3	380	1	localBufferedInputStream	BufferedInputStream
    //   389	126	1	localIOException1	IOException
    //   521	31	1	localIOException2	IOException
    //   565	10	1	localObject1	Object
    //   576	18	1	localIOException3	IOException
    //   636	8	1	localObject2	Object
    //   646	13	1	localObject3	Object
    //   65	276	2	localObject4	Object
    //   348	18	2	localIOException4	IOException
    //   420	151	2	localIOException5	IOException
    //   606	18	2	localIOException6	IOException
    //   638	7	2	localObject5	Object
    //   656	1	2	localIOException7	IOException
    //   1	422	3	localBitmap	Bitmap
    //   481	20	3	localThrowable1	Throwable
    //   642	4	3	localObject6	Object
    //   650	8	3	localThrowable2	Throwable
    //   52	194	4	str	String
    //   171	51	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   197	205	348	java/io/IOException
    //   207	219	348	java/io/IOException
    //   221	233	348	java/io/IOException
    //   235	240	348	java/io/IOException
    //   242	255	348	java/io/IOException
    //   260	266	348	java/io/IOException
    //   268	277	348	java/io/IOException
    //   283	290	348	java/io/IOException
    //   292	299	348	java/io/IOException
    //   301	339	348	java/io/IOException
    //   341	345	348	java/io/IOException
    //   421	426	348	java/io/IOException
    //   428	434	348	java/io/IOException
    //   436	478	348	java/io/IOException
    //   553	562	348	java/io/IOException
    //   382	386	389	java/io/IOException
    //   197	205	481	java/lang/Throwable
    //   207	219	481	java/lang/Throwable
    //   221	233	481	java/lang/Throwable
    //   235	240	481	java/lang/Throwable
    //   242	255	481	java/lang/Throwable
    //   260	266	481	java/lang/Throwable
    //   268	277	481	java/lang/Throwable
    //   283	290	481	java/lang/Throwable
    //   292	299	481	java/lang/Throwable
    //   301	339	481	java/lang/Throwable
    //   341	345	481	java/lang/Throwable
    //   421	426	481	java/lang/Throwable
    //   428	434	481	java/lang/Throwable
    //   436	478	481	java/lang/Throwable
    //   553	562	481	java/lang/Throwable
    //   514	518	521	java/io/IOException
    //   197	205	565	finally
    //   207	219	565	finally
    //   221	233	565	finally
    //   235	240	565	finally
    //   242	255	565	finally
    //   260	266	565	finally
    //   268	277	565	finally
    //   283	290	565	finally
    //   292	299	565	finally
    //   301	339	565	finally
    //   341	345	565	finally
    //   421	426	565	finally
    //   428	434	565	finally
    //   436	478	565	finally
    //   484	510	565	finally
    //   553	562	565	finally
    //   117	121	576	java/io/IOException
    //   570	574	606	java/io/IOException
    //   26	66	636	finally
    //   70	108	636	finally
    //   108	113	636	finally
    //   126	164	636	finally
    //   164	195	636	finally
    //   349	378	642	finally
    //   26	66	650	java/lang/Throwable
    //   70	108	650	java/lang/Throwable
    //   108	113	650	java/lang/Throwable
    //   126	164	650	java/lang/Throwable
    //   164	195	650	java/lang/Throwable
    //   26	66	656	java/io/IOException
    //   70	108	656	java/io/IOException
    //   108	113	656	java/io/IOException
    //   126	164	656	java/io/IOException
    //   164	195	656	java/io/IOException
  }
  
  protected void bZN()
  {
    if (this.mRecycled) {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame, FriendProfileCardBgDrawable has been recycled");
    }
    while ((!this.mDecodeNextFrameEnd) || (this.mPaused)) {
      return;
    }
    this.mDecodeNextFrameEnd = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mFrameDelay;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a != null) {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame mTask != null currentFrame = " + this.mCurFrameIndex);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a = new a(this.bN);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.mCurFrameIndex) });
  }
  
  protected int ce(int paramInt)
  {
    if (paramInt == this.mFrameCount - 1)
    {
      this.mRepeatCount -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRecycled) {
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, FriendProfileCardBgDrawable has been recycled");
    }
    do
    {
      do
      {
        return;
        if (this.isDynamic) {
          break;
        }
        if (this.mBackground == null)
        {
          bZN();
          return;
        }
      } while (this.mPaint == null);
      if (this.mBackground.isRecycled())
      {
        this.mBackground = null;
        QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBackground has been recycled");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardBgDrawable", 2, "draw static background");
      }
    } while (this.aY == null);
    paramCanvas.drawBitmap(this.mBackground, null, this.aY, this.mPaint);
    return;
    if ((this.mBackground != null) && (!this.mBackground.isRecycled()) && (this.mPaint != null) && (this.aY != null)) {
      paramCanvas.drawBitmap(this.mBackground, null, this.aY, this.mPaint);
    }
    if ((this.mCurFrameIndex != -1) && (this.mBitmap != null))
    {
      if (!this.mBitmap.isRecycled()) {
        break label212;
      }
      this.mBitmap = null;
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBitmap has been recycled");
    }
    while (this.mRepeatCount == 0)
    {
      super.invalidateSelf();
      this.mFinished = true;
      return;
      label212:
      if ((this.mPaint != null) && (this.aX != null)) {
        paramCanvas.drawBitmap(this.mBitmap, null, this.aX, this.mPaint);
      }
    }
    bZN();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void recycle()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new FriendProfileCardBgDrawable.1(this));
      return;
    }
    recycleBitmaps();
  }
  
  public void recycleBitmaps()
  {
    this.mRecycled = true;
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    if (this.dC != null)
    {
      this.dC.recycle();
      this.dC = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$a = null;
    }
    if (this.dD != null) {
      synchronized (this.cp)
      {
        if (this.dD != null)
        {
          this.dD.recycle();
          this.dD = null;
        }
        return;
      }
    }
  }
  
  public void run()
  {
    if (!this.isDynamic)
    {
      super.invalidateSelf();
      this.mDecodeNextFrameEnd = true;
    }
    do
    {
      do
      {
        return;
      } while (this.dC == null);
      this.mDecodeNextFrameEnd = true;
      this.mCurFrameIndex = ce(this.mCurFrameIndex);
    } while ((this.dC == null) || (this.mBitmap == this.dC));
    if (this.mBitmap != null) {
      if (Build.VERSION.SDK_INT <= 11) {
        break label100;
      }
    }
    for (this.dD = this.mBitmap;; this.dD = null)
    {
      this.mBitmap = this.dC;
      this.dC = null;
      super.invalidateSelf();
      return;
      label100:
      this.mBitmap.recycle();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
  
  public class a
    extends AsyncTask<Long, Void, Void>
  {
    private Object source;
    
    public a(Object paramObject)
    {
      this.source = paramObject;
    }
    
    protected Void a(Long... paramVarArgs)
    {
      for (;;)
      {
        try
        {
          l1 = paramVarArgs[0].longValue();
          long l2 = paramVarArgs[1].longValue();
          paramVarArgs = FriendProfileCardBgDrawable.this.a(this.source, (int)l2);
          if (!FriendProfileCardBgDrawable.this.isDynamic)
          {
            paramVarArgs = FriendProfileCardBgDrawable.this.sHandler;
            FriendProfileCardBgDrawable localFriendProfileCardBgDrawable = FriendProfileCardBgDrawable.this;
            if (FriendProfileCardBgDrawable.a(FriendProfileCardBgDrawable.this) != null) {
              break label203;
            }
            l1 = 1000L;
            paramVarArgs.postDelayed(localFriendProfileCardBgDrawable, l1);
            return null;
          }
          if ((paramVarArgs != null) && (!isCancelled()))
          {
            FriendProfileCardBgDrawable.this.dC = paramVarArgs;
            l2 = SystemClock.uptimeMillis();
            if (l2 < l1)
            {
              FriendProfileCardBgDrawable.this.sHandler.postDelayed(FriendProfileCardBgDrawable.this, l1 - l2);
              return null;
            }
          }
        }
        catch (OutOfMemoryError paramVarArgs)
        {
          QLog.e("FriendProfileCardBgDrawable", 4, "", paramVarArgs);
          FriendProfileCardBgDrawable.this.dC = null;
          FriendProfileCardBgDrawable.this.mDecodeNextFrameEnd = true;
          return null;
          FriendProfileCardBgDrawable.this.sHandler.post(FriendProfileCardBgDrawable.this);
          return null;
        }
        catch (Throwable paramVarArgs)
        {
          QLog.e("FriendProfileCardBgDrawable", 1, "", paramVarArgs);
          FriendProfileCardBgDrawable.this.dC = null;
          FriendProfileCardBgDrawable.this.mDecodeNextFrameEnd = true;
        }
        return null;
        label203:
        long l1 = 0L;
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      FriendProfileCardBgDrawable.this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable
 * JD-Core Version:    0.7.0.1
 */