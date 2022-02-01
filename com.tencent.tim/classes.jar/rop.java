import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Command;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class rop
{
  private static Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (OutOfMemoryError paramConfig)
    {
      ram.e("BitmapUtils", "OutOfMemoryError", paramConfig);
      pmi.a().dispatch(new rop.b());
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if (i != paramInt1) {
        break;
      }
      localBitmap = paramBitmap;
    } while (j == paramInt2);
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    Bitmap localBitmap = a(paramInt1, paramInt2, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    if (paramBoolean2) {
      localBitmap.setDensity(paramBitmap.getDensity());
    }
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt1 - i) / 2.0F, (paramInt2 - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean1) {
      f(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null)) {}
    for (;;)
    {
      return null;
      try
      {
        int i = paramBitmap1.getWidth();
        int j = paramBitmap1.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          if (paramBoolean) {
            localBitmap.setDensity(paramBitmap1.getDensity());
          }
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
          float f1 = i / paramBitmap2.getWidth();
          float f2 = j / paramBitmap2.getHeight();
          paramBitmap1 = new Matrix();
          paramBitmap1.postScale(f1, f2);
          localCanvas.drawBitmap(paramBitmap2, paramBitmap1, null);
          localCanvas.save();
          return localBitmap;
        }
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        ram.e("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    if (paramBitmap == null) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = a(paramRect.width(), paramRect.height(), a(paramBitmap), false);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(6);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), paramRect, localPaint);
    if (paramBoolean) {
      f(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    int i = (int)((paramRectF1.left - paramRectF2.left) / paramFloat);
    int j = (int)((paramRectF1.top - paramRectF2.top) / paramFloat);
    int k = (int)(paramRectF1.width() / paramFloat);
    int m = (int)(paramRectF1.height() / paramFloat);
    Bitmap localBitmap = paramBitmap;
    if (a(paramRectF1, paramRectF2, k, m)) {}
    try
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      QLog.d("BitmapUtils", 1, "ImageStateTransform transform", paramBitmap);
      pmi.a().dispatch(new rop.b());
    }
    return null;
  }
  
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dU(paramView);
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        break label28;
      }
    }
    for (;;)
    {
      try
      {
        i = paramView.getWidth();
        paramInt1 = paramView.getHeight();
        label28:
        if ((i > 0) && (paramInt1 > 0))
        {
          Bitmap localBitmap = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(localBitmap);
          Matrix localMatrix = new Matrix();
          localMatrix.setTranslate(paramInt3, paramInt4);
          localMatrix.setScale(i / paramView.getWidth(), paramInt1 / paramView.getHeight());
          localCanvas.setMatrix(localMatrix);
          paramView.draw(localCanvas);
          paramView = localBitmap;
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        return null;
      }
      catch (OutOfMemoryError paramView)
      {
        return null;
      }
      paramView = null;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, rop.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: ifnonnull +13 -> 26
    //   16: new 205	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc 207
    //   22: invokespecial 210	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: new 212	java/io/DataInputStream
    //   29: dup
    //   30: new 214	java/io/FileInputStream
    //   33: dup
    //   34: new 216	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 223	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore 8
    //   50: aload 5
    //   52: astore 6
    //   54: aload 9
    //   56: astore_0
    //   57: aload 8
    //   59: astore 7
    //   61: aload 8
    //   63: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   66: istore_2
    //   67: aload 5
    //   69: astore 6
    //   71: aload 9
    //   73: astore_0
    //   74: aload 8
    //   76: astore 7
    //   78: aload 8
    //   80: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   83: pop
    //   84: iload_2
    //   85: sipush 187
    //   88: if_icmpne +259 -> 347
    //   91: aload 5
    //   93: astore 6
    //   95: aload 9
    //   97: astore_0
    //   98: aload 8
    //   100: astore 7
    //   102: aload 8
    //   104: invokevirtual 230	java/io/DataInputStream:readBoolean	()Z
    //   107: pop
    //   108: aload 5
    //   110: astore 6
    //   112: aload 9
    //   114: astore_0
    //   115: aload 8
    //   117: astore 7
    //   119: invokestatic 234	android/graphics/Bitmap$Config:values	()[Landroid/graphics/Bitmap$Config;
    //   122: aload 8
    //   124: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   127: aaload
    //   128: astore 10
    //   130: aload 5
    //   132: astore 6
    //   134: aload 9
    //   136: astore_0
    //   137: aload 8
    //   139: astore 7
    //   141: aload 8
    //   143: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   146: istore_2
    //   147: aload 5
    //   149: astore 6
    //   151: aload 9
    //   153: astore_0
    //   154: aload 8
    //   156: astore 7
    //   158: aload 8
    //   160: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   163: istore_3
    //   164: aload 5
    //   166: astore 6
    //   168: aload 9
    //   170: astore_0
    //   171: aload 8
    //   173: astore 7
    //   175: aload 8
    //   177: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   180: pop
    //   181: aload 5
    //   183: astore 6
    //   185: aload 9
    //   187: astore_0
    //   188: aload 8
    //   190: astore 7
    //   192: aload 8
    //   194: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   197: pop
    //   198: aload 5
    //   200: astore 6
    //   202: aload 9
    //   204: astore_0
    //   205: aload 8
    //   207: astore 7
    //   209: aload 8
    //   211: invokevirtual 226	java/io/DataInputStream:readInt	()I
    //   214: istore 4
    //   216: aload_1
    //   217: ifnull +110 -> 327
    //   220: aload 5
    //   222: astore 6
    //   224: aload 9
    //   226: astore_0
    //   227: aload 8
    //   229: astore 7
    //   231: aload_1
    //   232: iload 4
    //   234: invokevirtual 238	rop$a:getByteArray	(I)[B
    //   237: astore 5
    //   239: aload 5
    //   241: astore 6
    //   243: aload 5
    //   245: astore_0
    //   246: aload 8
    //   248: astore 7
    //   250: aload 8
    //   252: aload 5
    //   254: invokevirtual 242	java/io/DataInputStream:read	([B)I
    //   257: pop
    //   258: aload 5
    //   260: astore 6
    //   262: aload 5
    //   264: astore_0
    //   265: aload 8
    //   267: astore 7
    //   269: iload_2
    //   270: iload_3
    //   271: aload 10
    //   273: invokestatic 31	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   276: astore 9
    //   278: aload 5
    //   280: astore 6
    //   282: aload 5
    //   284: astore_0
    //   285: aload 8
    //   287: astore 7
    //   289: aload 9
    //   291: aload 5
    //   293: invokestatic 248	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   296: invokevirtual 252	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   299: aload_1
    //   300: ifnull +14 -> 314
    //   303: aload 5
    //   305: ifnull +9 -> 314
    //   308: aload_1
    //   309: aload 5
    //   311: invokevirtual 256	rop$a:T	([B)V
    //   314: aload 8
    //   316: ifnull +8 -> 324
    //   319: aload 8
    //   321: invokevirtual 259	java/io/DataInputStream:close	()V
    //   324: aload 9
    //   326: areturn
    //   327: aload 5
    //   329: astore 6
    //   331: aload 9
    //   333: astore_0
    //   334: aload 8
    //   336: astore 7
    //   338: iload 4
    //   340: newarray byte
    //   342: astore 5
    //   344: goto -105 -> 239
    //   347: aload 5
    //   349: astore 6
    //   351: aload 9
    //   353: astore_0
    //   354: aload 8
    //   356: astore 7
    //   358: new 203	java/io/IOException
    //   361: dup
    //   362: new 261	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 264
    //   372: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload_2
    //   376: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokespecial 275	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   385: athrow
    //   386: astore 5
    //   388: aload 8
    //   390: astore 7
    //   392: aload 6
    //   394: astore_0
    //   395: new 203	java/io/IOException
    //   398: dup
    //   399: ldc_w 277
    //   402: aload 5
    //   404: invokespecial 280	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   407: athrow
    //   408: astore 6
    //   410: aload_0
    //   411: astore 5
    //   413: aload 6
    //   415: astore_0
    //   416: aload_1
    //   417: ifnull +14 -> 431
    //   420: aload 5
    //   422: ifnull +9 -> 431
    //   425: aload_1
    //   426: aload 5
    //   428: invokevirtual 256	rop$a:T	([B)V
    //   431: aload 7
    //   433: ifnull +8 -> 441
    //   436: aload 7
    //   438: invokevirtual 259	java/io/DataInputStream:close	()V
    //   441: aload_0
    //   442: athrow
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 6
    //   447: aload 7
    //   449: astore 5
    //   451: aload 6
    //   453: astore 7
    //   455: goto -39 -> 416
    //   458: astore 5
    //   460: aconst_null
    //   461: astore 7
    //   463: aload 6
    //   465: astore_0
    //   466: goto -71 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramString	String
    //   0	469	1	parama	rop.a
    //   66	310	2	i	int
    //   163	108	3	j	int
    //   214	125	4	k	int
    //   10	338	5	arrayOfByte	byte[]
    //   386	17	5	localOutOfMemoryError1	OutOfMemoryError
    //   411	39	5	localObject1	Object
    //   458	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   1	392	6	localObject2	Object
    //   408	6	6	localObject3	Object
    //   445	19	6	localObject4	Object
    //   7	455	7	localObject5	Object
    //   48	341	8	localDataInputStream	java.io.DataInputStream
    //   4	348	9	localBitmap	Bitmap
    //   128	144	10	localConfig	Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   61	67	386	java/lang/OutOfMemoryError
    //   78	84	386	java/lang/OutOfMemoryError
    //   102	108	386	java/lang/OutOfMemoryError
    //   119	130	386	java/lang/OutOfMemoryError
    //   141	147	386	java/lang/OutOfMemoryError
    //   158	164	386	java/lang/OutOfMemoryError
    //   175	181	386	java/lang/OutOfMemoryError
    //   192	198	386	java/lang/OutOfMemoryError
    //   209	216	386	java/lang/OutOfMemoryError
    //   231	239	386	java/lang/OutOfMemoryError
    //   250	258	386	java/lang/OutOfMemoryError
    //   269	278	386	java/lang/OutOfMemoryError
    //   289	299	386	java/lang/OutOfMemoryError
    //   338	344	386	java/lang/OutOfMemoryError
    //   358	386	386	java/lang/OutOfMemoryError
    //   61	67	408	finally
    //   78	84	408	finally
    //   102	108	408	finally
    //   119	130	408	finally
    //   141	147	408	finally
    //   158	164	408	finally
    //   175	181	408	finally
    //   192	198	408	finally
    //   209	216	408	finally
    //   231	239	408	finally
    //   250	258	408	finally
    //   269	278	408	finally
    //   289	299	408	finally
    //   338	344	408	finally
    //   358	386	408	finally
    //   395	408	408	finally
    //   26	50	443	finally
    //   26	50	458	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public static void a(Bitmap paramBitmap, String paramString, rop.a parama)
    throws IOException
  {
    try
    {
      b(paramBitmap, paramString, parama);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ram.e("BitmapUtils", "serializeBitmapToFile failed", localOutOfMemoryError);
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      b(paramBitmap, paramString, parama);
    }
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 309	android/graphics/Bitmap:isRecycled	()Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   16: pop2
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 8
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 6
    //   29: new 216	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 9
    //   39: aload 5
    //   41: astore_3
    //   42: aload 9
    //   44: invokevirtual 318	java/io/File:exists	()Z
    //   47: ifne +31 -> 78
    //   50: aload 5
    //   52: astore_3
    //   53: aload 9
    //   55: invokevirtual 321	java/io/File:createNewFile	()Z
    //   58: ifne +20 -> 78
    //   61: aload 5
    //   63: astore_3
    //   64: ldc 33
    //   66: ldc_w 323
    //   69: invokestatic 326	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload 5
    //   80: astore_3
    //   81: new 334	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 336	java/io/FileOutputStream
    //   88: dup
    //   89: aload 9
    //   91: invokespecial 337	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: sipush 8192
    //   97: invokespecial 340	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   100: astore 5
    //   102: aload_0
    //   103: invokevirtual 309	android/graphics/Bitmap:isRecycled	()Z
    //   106: istore 4
    //   108: iload 4
    //   110: ifeq +10 -> 120
    //   113: aload 5
    //   115: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: aload_1
    //   122: iload_2
    //   123: aload 5
    //   125: invokevirtual 344	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   128: ifne +18 -> 146
    //   131: ldc 33
    //   133: ldc_w 346
    //   136: invokestatic 326	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 5
    //   141: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 5
    //   148: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   151: iconst_1
    //   152: ireturn
    //   153: astore_1
    //   154: aload 6
    //   156: astore_0
    //   157: aload_0
    //   158: astore_3
    //   159: ldc 33
    //   161: aload_1
    //   162: invokevirtual 347	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   165: aload_1
    //   166: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_0
    //   170: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload 7
    //   178: astore_0
    //   179: aload_0
    //   180: astore_3
    //   181: ldc 33
    //   183: aload_1
    //   184: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   187: aload_1
    //   188: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aload 8
    //   200: astore_0
    //   201: aload_0
    //   202: astore_3
    //   203: ldc 33
    //   205: aload_1
    //   206: invokevirtual 349	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   209: aload_1
    //   210: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_0
    //   214: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_0
    //   220: aload_3
    //   221: invokestatic 332	rpa:closeSilently	(Ljava/io/Closeable;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aload 5
    //   229: astore_3
    //   230: goto -10 -> 220
    //   233: astore_1
    //   234: aload 5
    //   236: astore_0
    //   237: goto -36 -> 201
    //   240: astore_1
    //   241: aload 5
    //   243: astore_0
    //   244: goto -65 -> 179
    //   247: astore_1
    //   248: aload 5
    //   250: astore_0
    //   251: goto -94 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramBitmap	Bitmap
    //   0	254	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	254	2	paramInt	int
    //   0	254	3	paramString	String
    //   106	3	4	bool	boolean
    //   24	225	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   27	128	6	localObject1	Object
    //   18	159	7	localObject2	Object
    //   21	178	8	localObject3	Object
    //   37	53	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   42	50	153	java/io/FileNotFoundException
    //   53	61	153	java/io/FileNotFoundException
    //   64	72	153	java/io/FileNotFoundException
    //   81	102	153	java/io/FileNotFoundException
    //   42	50	175	java/io/IOException
    //   53	61	175	java/io/IOException
    //   64	72	175	java/io/IOException
    //   81	102	175	java/io/IOException
    //   42	50	197	java/lang/IllegalStateException
    //   53	61	197	java/lang/IllegalStateException
    //   64	72	197	java/lang/IllegalStateException
    //   81	102	197	java/lang/IllegalStateException
    //   42	50	219	finally
    //   53	61	219	finally
    //   64	72	219	finally
    //   81	102	219	finally
    //   159	169	219	finally
    //   181	191	219	finally
    //   203	213	219	finally
    //   102	108	226	finally
    //   120	139	226	finally
    //   102	108	233	java/lang/IllegalStateException
    //   120	139	233	java/lang/IllegalStateException
    //   102	108	240	java/io/IOException
    //   120	139	240	java/io/IOException
    //   102	108	247	java/io/FileNotFoundException
    //   120	139	247	java/io/FileNotFoundException
  }
  
  private static boolean a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(1 + Math.max(paramInt1, paramInt2) / 1000.0F);
    return (Math.abs(paramRectF1.left - paramRectF2.left) > paramInt1) || (Math.abs(paramRectF1.top - paramRectF2.top) > paramInt1) || (Math.abs(paramRectF1.bottom - paramRectF2.bottom) > paramInt1) || (Math.abs(paramRectF1.right - paramRectF2.right) > paramInt1);
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      localBitmap = null;
    }
    int i;
    int j;
    do
    {
      return localBitmap;
      i = Math.round(paramBitmap.getWidth() * paramFloat);
      j = Math.round(paramBitmap.getHeight() * paramFloat);
      if (i != paramBitmap.getWidth()) {
        break;
      }
      localBitmap = paramBitmap;
    } while (j == paramBitmap.getHeight());
    Bitmap localBitmap = a(i, j, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(paramFloat, paramFloat);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      f(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramBitmap, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == paramInt1) && (j == paramInt2)) {
      return paramBitmap;
    }
    Object localObject2 = paramBitmap.getConfig();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Bitmap.Config.ARGB_8888;
    }
    localObject2 = a(paramInt1, paramInt2, (Bitmap.Config)localObject1, false);
    if (localObject2 == null) {
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject2);
    if (!paramBoolean1) {
      localCanvas.drawColor(-16777216);
    }
    float f = i * 1.0F / j;
    int k;
    int m;
    if (f > paramInt1 * 1.0F / paramInt2)
    {
      k = Math.round(paramInt1 / f);
      m = (paramInt2 - k) / 2;
      f = paramInt2 / 2.0F;
    }
    for (localObject1 = new Rect(0, m, paramInt1, Math.round(k / 2.0F + f));; localObject1 = new Rect(m, 0, Math.round(k / 2.0F + f), paramInt2))
    {
      ram.i("BitmapUtils", "resizeAndFillBitmapEdge srcWidth=%s, srcHeight=%s, targetWidth=%s, targetHeight=%s, destRect=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
      localCanvas.drawBitmap(paramBitmap, null, (Rect)localObject1, new Paint(6));
      localCanvas.setBitmap(null);
      if (paramBoolean2) {
        f(paramBitmap);
      }
      return localObject2;
      k = Math.round(f * paramInt2);
      m = (paramInt1 - k) / 2;
      f = paramInt1 / 2.0F;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null)) {
      return null;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    float f = Math.min(i / k, j / m);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap2, (int)(k * f), (int)(m * f), false);
    k = localBitmap.getWidth();
    m = localBitmap.getHeight();
    if (paramBitmap1.isMutable()) {}
    for (paramBitmap2 = paramBitmap1;; paramBitmap2 = paramBitmap1.copy(paramBitmap1.getConfig(), true))
    {
      paramBitmap2 = new Canvas(paramBitmap2);
      paramBitmap2.drawBitmap(localBitmap, (i - k) / 2, (j - m) / 2, null);
      paramBitmap2.save();
      paramBitmap2.restore();
      return paramBitmap1;
    }
  }
  
  /* Error */
  @TargetApi(12)
  public static void b(Bitmap paramBitmap, String paramString, rop.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: invokevirtual 309	android/graphics/Bitmap:isRecycled	()Z
    //   13: ifeq +14 -> 27
    //   16: new 205	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc_w 405
    //   23: invokespecial 210	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: aload_1
    //   28: ifnonnull +14 -> 42
    //   31: new 205	java/lang/IllegalArgumentException
    //   34: dup
    //   35: ldc_w 407
    //   38: invokespecial 210	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   41: athrow
    //   42: new 409	java/io/DataOutputStream
    //   45: dup
    //   46: new 336	java/io/FileOutputStream
    //   49: dup
    //   50: new 216	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 337	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 412	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 4
    //   66: aload_3
    //   67: astore_1
    //   68: aload 4
    //   70: sipush 187
    //   73: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   76: aload_3
    //   77: astore_1
    //   78: aload 4
    //   80: iconst_1
    //   81: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   84: aload_3
    //   85: astore_1
    //   86: aload 4
    //   88: aload_0
    //   89: invokevirtual 396	android/graphics/Bitmap:isMutable	()Z
    //   92: invokevirtual 419	java/io/DataOutputStream:writeBoolean	(Z)V
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: aload_0
    //   100: invokevirtual 17	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   103: invokevirtual 422	android/graphics/Bitmap$Config:ordinal	()I
    //   106: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 61	android/graphics/Bitmap:getWidth	()I
    //   117: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: aload_0
    //   125: invokevirtual 64	android/graphics/Bitmap:getHeight	()I
    //   128: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_3
    //   132: astore_1
    //   133: aload 4
    //   135: aload_0
    //   136: invokevirtual 425	android/graphics/Bitmap:getRowBytes	()I
    //   139: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload 4
    //   146: aload_0
    //   147: invokevirtual 77	android/graphics/Bitmap:getDensity	()I
    //   150: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   153: aload_2
    //   154: ifnull +75 -> 229
    //   157: aload_3
    //   158: astore_1
    //   159: aload_2
    //   160: aload_0
    //   161: invokevirtual 428	android/graphics/Bitmap:getByteCount	()I
    //   164: invokevirtual 238	rop$a:getByteArray	(I)[B
    //   167: astore_3
    //   168: aload_3
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokestatic 248	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   175: invokevirtual 431	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   178: aload_3
    //   179: astore_1
    //   180: aload 4
    //   182: aload_3
    //   183: arraylength
    //   184: invokevirtual 415	java/io/DataOutputStream:writeInt	(I)V
    //   187: aload_3
    //   188: astore_1
    //   189: aload 4
    //   191: aload_3
    //   192: iconst_0
    //   193: aload_3
    //   194: arraylength
    //   195: invokevirtual 435	java/io/DataOutputStream:write	([BII)V
    //   198: aload_3
    //   199: astore_1
    //   200: aload 4
    //   202: invokevirtual 438	java/io/DataOutputStream:flush	()V
    //   205: aload_2
    //   206: ifnull +12 -> 218
    //   209: aload_3
    //   210: ifnull +8 -> 218
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 256	rop$a:T	([B)V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 439	java/io/DataOutputStream:close	()V
    //   228: return
    //   229: aload_3
    //   230: astore_1
    //   231: aload_0
    //   232: invokevirtual 428	android/graphics/Bitmap:getByteCount	()I
    //   235: newarray byte
    //   237: astore_3
    //   238: goto -70 -> 168
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_3
    //   244: aload 5
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull +12 -> 260
    //   251: aload_1
    //   252: ifnull +8 -> 260
    //   255: aload_2
    //   256: aload_1
    //   257: invokevirtual 256	rop$a:T	([B)V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 439	java/io/DataOutputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: aload 4
    //   273: astore_3
    //   274: goto -27 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramBitmap	Bitmap
    //   0	277	1	paramString	String
    //   0	277	2	parama	rop.a
    //   1	273	3	localObject1	Object
    //   64	208	4	localDataOutputStream	java.io.DataOutputStream
    //   3	242	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	66	241	finally
    //   68	76	270	finally
    //   78	84	270	finally
    //   86	95	270	finally
    //   97	109	270	finally
    //   111	120	270	finally
    //   122	131	270	finally
    //   133	142	270	finally
    //   144	153	270	finally
    //   159	168	270	finally
    //   170	178	270	finally
    //   180	187	270	finally
    //   189	198	270	finally
    //   200	205	270	finally
    //   231	238	270	finally
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    float f2 = paramInt1 * 1.0F / paramInt2;
    if (f2 == f1)
    {
      ram.d("BitmapUtils", "fillBackground. no need to resize");
      return paramBitmap;
    }
    if (f1 > f2)
    {
      paramInt1 = Math.round(i / f2);
      paramInt2 = i;
    }
    Object localObject1;
    for (;;)
    {
      localObject2 = paramBitmap.getConfig();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Bitmap.Config.ARGB_8888;
      }
      localObject1 = a(paramInt2, paramInt1, (Bitmap.Config)localObject1, false);
      if (localObject1 != null) {
        break;
      }
      return null;
      paramInt2 = Math.round(j * f2);
      paramInt1 = j;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    if (!paramBoolean1) {
      ((Canvas)localObject2).drawColor(-16777216);
    }
    Paint localPaint = new Paint(6);
    ((Canvas)localObject2).drawBitmap(paramBitmap, (paramInt2 - i) / 2, (paramInt1 - j) / 2, localPaint);
    ((Canvas)localObject2).setBitmap(null);
    if (paramBoolean2) {
      f(paramBitmap);
    }
    return localObject1;
  }
  
  public static Bitmap c(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    try
    {
      int i = paramBitmap1.getWidth();
      int j = paramBitmap1.getHeight();
      Paint localPaint = new Paint();
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, localPaint);
      float f1 = i / paramBitmap2.getWidth();
      float f2 = j / paramBitmap2.getHeight();
      paramBitmap1 = new Matrix();
      paramBitmap1.postScale(f1, f2);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap2, 0, 0, paramBitmap2.getWidth(), paramBitmap2.getHeight(), paramBitmap1, true), 0.0F, 0.0F, null);
      localCanvas.save();
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap1)
    {
      ram.e("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
    }
    return null;
  }
  
  public static Bitmap d(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return a(paramBitmap1, paramBitmap2, false);
  }
  
  public static boolean d(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
  
  private static void dU(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        dU(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    paramView.destroyDrawingCache();
    paramView.invalidate();
  }
  
  public static void f(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap.recycle();
  }
  
  public static boolean fz(String paramString)
  {
    if (paramString != null) {
      try
      {
        Bitmap localBitmap = a(paramString, null);
        rox.fA(paramString);
        boolean bool = a(localBitmap, Bitmap.CompressFormat.PNG, 100, paramString);
        return bool;
      }
      catch (Throwable paramString)
      {
        ram.e("BitmapUtils", "convertBitmapBinFileToPng failed", paramString);
      }
    }
    return false;
  }
  
  public static String gk(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString)), null, localOptions);
      paramString = String.format("w=%d,h=%d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (paramInt % 360 != 0)
    {
      ram.w("BitmapUtils", "generateOrientation begin!");
      long l = System.currentTimeMillis();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.postRotate(paramInt);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      ram.w("BitmapUtils", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      return paramBitmap;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  /* Error */
  public static Bitmap u(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 567	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: new 502	java/io/BufferedInputStream
    //   16: dup
    //   17: new 214	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 503	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 504	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokestatic 572	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: ifnull -30 -> 11
    //   44: aload_0
    //   45: invokevirtual 573	java/io/BufferedInputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_0
    //   51: ldc 33
    //   53: ldc_w 575
    //   56: aload_0
    //   57: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: ldc 33
    //   69: ldc_w 577
    //   72: aload_2
    //   73: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: astore_1
    //   78: aload_2
    //   79: athrow
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 573	java/io/BufferedInputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: ldc 33
    //   96: ldc_w 579
    //   99: aload_1
    //   100: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: ifnull -95 -> 11
    //   109: aload_0
    //   110: invokevirtual 573	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: ldc 33
    //   118: ldc_w 575
    //   121: aload_0
    //   122: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: ldc 33
    //   130: ldc_w 575
    //   133: aload_1
    //   134: invokestatic 41	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -48 -> 89
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: goto -62 -> 81
    //   146: astore_2
    //   147: aload_0
    //   148: astore_1
    //   149: aload_2
    //   150: astore_0
    //   151: goto -70 -> 81
    //   154: astore_1
    //   155: goto -61 -> 94
    //   158: astore_2
    //   159: goto -94 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   10	76	1	localObject1	Object
    //   91	9	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   104	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   127	7	1	localIOException	IOException
    //   142	7	1	str	String
    //   154	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	60	2	localObject2	Object
    //   62	42	2	localOutOfMemoryError2	OutOfMemoryError
    //   146	4	2	localObject3	Object
    //   158	1	2	localOutOfMemoryError3	OutOfMemoryError
    //   35	2	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   13	29	62	java/lang/OutOfMemoryError
    //   31	36	80	finally
    //   67	76	80	finally
    //   78	80	80	finally
    //   13	29	91	java/io/FileNotFoundException
    //   109	113	115	java/io/IOException
    //   85	89	127	java/io/IOException
    //   13	29	140	finally
    //   94	103	146	finally
    //   31	36	154	java/io/FileNotFoundException
    //   31	36	158	java/lang/OutOfMemoryError
  }
  
  public static class a
  {
    public void T(byte[] paramArrayOfByte) {}
    
    @NonNull
    public byte[] getByteArray(int paramInt)
    {
      return new byte[paramInt];
    }
  }
  
  public static class b
    implements Dispatcher.Command
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rop
 * JD-Core Version:    0.7.0.1
 */