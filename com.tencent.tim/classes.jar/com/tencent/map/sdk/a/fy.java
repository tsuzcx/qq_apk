package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;

public final class fy
{
  protected static Paint a;
  public static a b;
  private static final String c = Bitmap.class.getCanonicalName();
  private static byte[] d;
  
  static
  {
    b = null;
    Paint localPaint = new Paint();
    a = localPaint;
    localPaint.setAntiAlias(true);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
        return paramConfig;
      }
      catch (OutOfMemoryError paramConfig) {}
    }
    return null;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +152 -> 153
    //   4: aload_1
    //   5: invokevirtual 69	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 73	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual 69	java/lang/String:trim	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 77	java/lang/String:charAt	(I)C
    //   24: bipush 47
    //   26: if_icmpeq +55 -> 81
    //   29: new 79	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 84	android/content/Context:getFilesDir	()Ljava/io/File;
    //   40: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 90
    //   45: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_0
    //   56: new 98	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: aload_1
    //   66: astore_0
    //   67: aload_1
    //   68: invokestatic 105	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   71: astore_2
    //   72: aload_1
    //   73: invokevirtual 110	java/io/InputStream:close	()V
    //   76: aload_2
    //   77: areturn
    //   78: astore_0
    //   79: aload_2
    //   80: areturn
    //   81: new 79	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   88: aload_0
    //   89: invokevirtual 84	android/content/Context:getFilesDir	()Ljava/io/File;
    //   92: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore_0
    //   103: goto -47 -> 56
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   115: aload_1
    //   116: ifnull +37 -> 153
    //   119: aload_1
    //   120: invokevirtual 110	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 110	java/io/InputStream:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_0
    //   142: goto -3 -> 139
    //   145: astore_1
    //   146: goto -15 -> 131
    //   149: astore_2
    //   150: goto -41 -> 109
    //   153: aconst_null
    //   154: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramContext	Context
    //   0	155	1	paramString	String
    //   71	9	2	localBitmap	Bitmap
    //   106	6	2	localException1	java.lang.Exception
    //   149	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/lang/Exception
    //   4	14	106	java/lang/Exception
    //   16	56	106	java/lang/Exception
    //   56	65	106	java/lang/Exception
    //   81	103	106	java/lang/Exception
    //   119	123	125	java/lang/Exception
    //   4	14	128	finally
    //   16	56	128	finally
    //   56	65	128	finally
    //   81	103	128	finally
    //   135	139	141	java/lang/Exception
    //   67	72	145	finally
    //   111	115	145	finally
    //   67	72	149	java/lang/Exception
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 > 2048) {
      i = 2048;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > 2048) {
      paramInt1 = 2048;
    }
    Bitmap localBitmap = a(i, paramInt1, Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {
      return null;
    }
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(localBitmap);
    paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    paramBitmap.setBounds(0, 0, i, paramInt1);
    paramBitmap.draw(localCanvas);
    return localBitmap;
  }
  
  /* Error */
  public static Bitmap a(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +196 -> 197
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: iconst_0
    //   8: iconst_0
    //   9: invokestatic 159	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   12: iconst_0
    //   13: iconst_0
    //   14: invokestatic 159	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   17: invokevirtual 165	android/view/View:measure	(II)V
    //   20: aload_0
    //   21: iconst_0
    //   22: iconst_0
    //   23: aload_0
    //   24: invokevirtual 168	android/view/View:getMeasuredWidth	()I
    //   27: aload_0
    //   28: invokevirtual 171	android/view/View:getMeasuredHeight	()I
    //   31: invokevirtual 174	android/view/View:layout	(IIII)V
    //   34: aload_0
    //   35: iconst_1
    //   36: invokevirtual 177	android/view/View:setDrawingCacheEnabled	(Z)V
    //   39: aload_0
    //   40: invokevirtual 180	android/view/View:buildDrawingCache	()V
    //   43: aload_0
    //   44: invokevirtual 184	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +148 -> 199
    //   54: aload 4
    //   56: invokevirtual 118	android/graphics/Bitmap:isRecycled	()Z
    //   59: ifeq +14 -> 73
    //   62: goto +137 -> 199
    //   65: aload_0
    //   66: invokevirtual 187	android/view/View:destroyDrawingCache	()V
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: areturn
    //   73: aload 4
    //   75: invokevirtual 190	android/graphics/Bitmap:getWidth	()I
    //   78: istore_1
    //   79: aload 4
    //   81: invokevirtual 193	android/graphics/Bitmap:getHeight	()I
    //   84: istore_2
    //   85: aload 4
    //   87: ifnull +117 -> 204
    //   90: aload 4
    //   92: invokevirtual 118	android/graphics/Bitmap:isRecycled	()Z
    //   95: ifne +109 -> 204
    //   98: iload_1
    //   99: ifle +105 -> 204
    //   102: iload_2
    //   103: ifgt +6 -> 109
    //   106: goto +98 -> 204
    //   109: iload_1
    //   110: iload_2
    //   111: getstatic 124	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   114: invokestatic 126	com/tencent/map/sdk/a/fy:a	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   117: astore_3
    //   118: aload_3
    //   119: ifnonnull +8 -> 127
    //   122: aconst_null
    //   123: astore_3
    //   124: goto -59 -> 65
    //   127: aload_3
    //   128: aload 4
    //   130: invokevirtual 196	android/graphics/Bitmap:getDensity	()I
    //   133: invokevirtual 199	android/graphics/Bitmap:setDensity	(I)V
    //   136: new 132	android/graphics/Canvas
    //   139: dup
    //   140: aload_3
    //   141: invokespecial 135	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   144: astore 5
    //   146: aload_3
    //   147: iconst_0
    //   148: invokevirtual 130	android/graphics/Bitmap:eraseColor	(I)V
    //   151: aload 5
    //   153: aload 4
    //   155: fconst_0
    //   156: fconst_0
    //   157: getstatic 37	com/tencent/map/sdk/a/fy:a	Landroid/graphics/Paint;
    //   160: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   163: goto -98 -> 65
    //   166: astore_3
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_3
    //   170: athrow
    //   171: astore_0
    //   172: ldc 205
    //   174: new 79	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 207
    //   180: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: invokestatic 214	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 218	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   196: pop
    //   197: aconst_null
    //   198: areturn
    //   199: aconst_null
    //   200: astore_3
    //   201: goto -136 -> 65
    //   204: aconst_null
    //   205: astore_3
    //   206: goto -141 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramView	android.view.View
    //   78	32	1	i	int
    //   84	27	2	j	int
    //   71	76	3	localBitmap1	Bitmap
    //   166	4	3	localObject1	Object
    //   200	6	3	localObject2	Object
    //   47	107	4	localBitmap2	Bitmap
    //   144	8	5	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   6	49	166	finally
    //   54	62	166	finally
    //   65	71	166	finally
    //   73	85	166	finally
    //   90	98	166	finally
    //   109	118	166	finally
    //   127	163	166	finally
    //   167	169	166	finally
    //   4	6	171	java/lang/Throwable
    //   169	171	171	java/lang/Throwable
  }
  
  public static final Bitmap a(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(paramBitmap);
  }
  
  public static byte[] a()
  {
    if (d == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawARGB(0, 255, 255, 255);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      d = localByteArrayOutputStream.toByteArray();
    }
    return d;
  }
  
  /* Error */
  public static final Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 79	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokestatic 252	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   11: invokevirtual 255	com/tencent/tencentmap/io/QStorageManager:getAssetsDynamicPath	()Ljava/lang/String;
    //   14: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 260	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_2
    //   32: aload 4
    //   34: ifnonnull +56 -> 90
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: astore 6
    //   44: aload 4
    //   46: astore 5
    //   48: getstatic 264	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   51: ifnull +94 -> 145
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: astore 6
    //   61: aload 4
    //   63: astore 5
    //   65: aload_0
    //   66: new 79	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 264	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   76: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 267	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   89: astore_2
    //   90: aload_2
    //   91: astore 4
    //   93: aload_2
    //   94: ifnonnull +27 -> 121
    //   97: aload_2
    //   98: astore_3
    //   99: aload_2
    //   100: astore 6
    //   102: aload_2
    //   103: astore 5
    //   105: aload_0
    //   106: ldc_w 269
    //   109: aload_1
    //   110: invokestatic 273	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 277	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 267	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   119: astore 4
    //   121: aload 4
    //   123: astore_3
    //   124: aload 4
    //   126: astore 6
    //   128: aload 4
    //   130: astore 5
    //   132: aload 4
    //   134: invokestatic 105	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   137: astore_0
    //   138: aload 4
    //   140: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   143: aload_0
    //   144: areturn
    //   145: aload 4
    //   147: astore_2
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: astore 6
    //   155: aload 4
    //   157: astore 5
    //   159: getstatic 282	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   162: ifnull -72 -> 90
    //   165: aload 4
    //   167: astore_3
    //   168: aload 4
    //   170: astore 6
    //   172: aload 4
    //   174: astore 5
    //   176: new 79	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   183: getstatic 282	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   186: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 260	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   199: astore_2
    //   200: goto -110 -> 90
    //   203: astore_0
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: astore_3
    //   210: aload_0
    //   211: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   214: aload 5
    //   216: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aconst_null
    //   223: astore 6
    //   225: aload 6
    //   227: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   230: aconst_null
    //   231: areturn
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   239: aload_0
    //   240: athrow
    //   241: astore_0
    //   242: goto -7 -> 235
    //   245: astore_0
    //   246: goto -21 -> 225
    //   249: astore_0
    //   250: goto -43 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   0	253	1	paramString	String
    //   31	169	2	localObject1	Object
    //   39	197	3	localObject2	Object
    //   27	146	4	localObject3	Object
    //   46	169	5	localObject4	Object
    //   42	184	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	29	203	java/lang/Exception
    //   0	29	221	java/lang/OutOfMemoryError
    //   0	29	232	finally
    //   48	54	241	finally
    //   65	90	241	finally
    //   105	121	241	finally
    //   132	138	241	finally
    //   159	165	241	finally
    //   176	200	241	finally
    //   210	214	241	finally
    //   48	54	245	java/lang/OutOfMemoryError
    //   65	90	245	java/lang/OutOfMemoryError
    //   105	121	245	java/lang/OutOfMemoryError
    //   132	138	245	java/lang/OutOfMemoryError
    //   159	165	245	java/lang/OutOfMemoryError
    //   176	200	245	java/lang/OutOfMemoryError
    //   48	54	249	java/lang/Exception
    //   65	90	249	java/lang/Exception
    //   105	121	249	java/lang/Exception
    //   132	138	249	java/lang/Exception
    //   159	165	249	java/lang/Exception
    //   176	200	249	java/lang/Exception
  }
  
  public static final Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  /* Error */
  public static final Bitmap c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 289	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 294	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 105	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   20: aload_1
    //   21: areturn
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_0
    //   25: aload_0
    //   26: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   29: aconst_null
    //   30: areturn
    //   31: astore_0
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 280	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: astore_2
    //   54: goto -9 -> 45
    //   57: astore_1
    //   58: goto -24 -> 34
    //   61: astore_1
    //   62: goto -37 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   0	65	1	paramString	String
    //   42	12	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	22	java/lang/Exception
    //   5	11	31	java/lang/OutOfMemoryError
    //   5	11	40	finally
    //   11	16	51	finally
    //   11	16	57	java/lang/OutOfMemoryError
    //   11	16	61	java/lang/Exception
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    int i;
    int j;
    if (paramBitmap != null)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      i = (int)(f1 / fz.f);
      j = (int)(f2 / fz.f);
    }
    try
    {
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public static final class a
  {
    public a<String, Bitmap> a = new a();
    
    public final Bitmap a(String paramString)
    {
      return (Bitmap)this.a.a(paramString);
    }
    
    public final void a(String paramString, Bitmap paramBitmap)
    {
      a locala = this.a;
      synchronized (locala.c)
      {
        locala.a.put(paramString, paramBitmap);
        return;
      }
    }
    
    public static final class a<K, V>
    {
      public LinkedHashMap<K, V> a = new fy.a.a.1(this, (int)Math.ceil(13.333333015441895D) + 1);
      int b = 10;
      public byte[] c = new byte[0];
      
      public final V a(K paramK)
      {
        synchronized (this.c)
        {
          paramK = this.a.get(paramK);
          return paramK;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fy
 * JD-Core Version:    0.7.0.1
 */