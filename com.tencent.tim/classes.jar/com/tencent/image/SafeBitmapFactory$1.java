package com.tencent.image;

import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import java.util.concurrent.CountDownLatch;

final class SafeBitmapFactory$1
  implements Runnable
{
  SafeBitmapFactory$1(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Canvas paramCanvas, CountDownLatch paramCountDownLatch) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   6: getfield 49	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   9: ifle +11 -> 20
    //   12: aload_0
    //   13: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   16: getfield 49	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   19: istore_1
    //   20: new 51	android/graphics/Rect
    //   23: dup
    //   24: aload_0
    //   25: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   28: aload_0
    //   29: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   32: imul
    //   33: iload_1
    //   34: imul
    //   35: aload_0
    //   36: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   39: aload_0
    //   40: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   43: imul
    //   44: iload_1
    //   45: imul
    //   46: aload_0
    //   47: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   50: iconst_1
    //   51: iadd
    //   52: aload_0
    //   53: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   56: imul
    //   57: iload_1
    //   58: imul
    //   59: iload_1
    //   60: aload_0
    //   61: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   64: iconst_1
    //   65: iadd
    //   66: aload_0
    //   67: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   70: imul
    //   71: imul
    //   72: invokespecial 54	android/graphics/Rect:<init>	(IIII)V
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 33	com/tencent/image/SafeBitmapFactory$1:val$dataSource	Ljava/lang/Object;
    //   80: iconst_1
    //   81: invokestatic 60	com/tencent/image/SafeBitmapFactory:access$000	(Ljava/lang/Object;Z)Landroid/graphics/BitmapRegionDecoder;
    //   84: astore_2
    //   85: aload_2
    //   86: aload_3
    //   87: aload_0
    //   88: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   91: invokevirtual 66	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   94: astore 4
    //   96: aload_0
    //   97: getfield 35	com/tencent/image/SafeBitmapFactory$1:val$canvas	Landroid/graphics/Canvas;
    //   100: astore_3
    //   101: aload_3
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 35	com/tencent/image/SafeBitmapFactory$1:val$canvas	Landroid/graphics/Canvas;
    //   107: aload 4
    //   109: aload_0
    //   110: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   113: aload_0
    //   114: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   117: imul
    //   118: i2f
    //   119: aload_0
    //   120: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   123: aload_0
    //   124: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   127: imul
    //   128: i2f
    //   129: aconst_null
    //   130: invokevirtual 72	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   133: aload_3
    //   134: monitorexit
    //   135: aload 4
    //   137: invokevirtual 77	android/graphics/Bitmap:recycle	()V
    //   140: aload_2
    //   141: invokevirtual 78	android/graphics/BitmapRegionDecoder:recycle	()V
    //   144: aload_0
    //   145: getfield 37	com/tencent/image/SafeBitmapFactory$1:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   148: invokevirtual 83	java/util/concurrent/CountDownLatch:countDown	()V
    //   151: return
    //   152: astore_2
    //   153: aload_3
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aload_2
    //   159: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   162: aload_0
    //   163: getfield 37	com/tencent/image/SafeBitmapFactory$1:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   166: invokevirtual 83	java/util/concurrent/CountDownLatch:countDown	()V
    //   169: return
    //   170: astore_2
    //   171: aload_0
    //   172: getfield 37	com/tencent/image/SafeBitmapFactory$1:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   175: invokevirtual 83	java/util/concurrent/CountDownLatch:countDown	()V
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	1
    //   1	71	1	i	int
    //   84	57	2	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   152	4	2	localObject1	Object
    //   157	2	2	localIOException	java.io.IOException
    //   170	9	2	localObject2	Object
    //   94	42	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   103	135	152	finally
    //   153	155	152	finally
    //   2	20	157	java/io/IOException
    //   20	103	157	java/io/IOException
    //   135	144	157	java/io/IOException
    //   155	157	157	java/io/IOException
    //   2	20	170	finally
    //   20	103	170	finally
    //   135	144	170	finally
    //   155	157	170	finally
    //   158	162	170	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory.1
 * JD-Core Version:    0.7.0.1
 */