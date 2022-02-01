import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class jhn
  implements ImageAssetDelegate
{
  jhn(jhm paramjhm) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 12	jhn:a	Ljhm;
    //   6: getfield 29	jhm:val$context	Landroid/content/Context;
    //   9: invokevirtual 35	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: new 37	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   19: getstatic 44	com/tencent/av/ui/guide/GuideHelper:RX	Ljava/lang/String;
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 54	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   29: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: new 65	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 66	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: iconst_0
    //   55: putfield 70	android/graphics/BitmapFactory$Options:inScaled	Z
    //   58: aload_2
    //   59: astore_1
    //   60: aload_2
    //   61: aconst_null
    //   62: checkcast 72	android/graphics/Rect
    //   65: aload_3
    //   66: invokestatic 78	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: invokevirtual 83	java/io/InputStream:close	()V
    //   76: aload_2
    //   77: ifnull +7 -> 84
    //   80: aload_2
    //   81: invokevirtual 83	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: areturn
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: ldc 85
    //   93: iconst_2
    //   94: ldc 87
    //   96: aload_3
    //   97: invokestatic 93	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 83	java/io/InputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 83	java/io/InputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: aload_3
    //   123: areturn
    //   124: astore_1
    //   125: goto -17 -> 108
    //   128: astore_2
    //   129: goto -10 -> 119
    //   132: astore_3
    //   133: aload_1
    //   134: astore_2
    //   135: aload_3
    //   136: astore_1
    //   137: goto -26 -> 111
    //   140: astore_3
    //   141: goto -52 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	jhn
    //   0	144	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   1	115	2	localLottieImageAsset1	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   128	1	2	localException	java.lang.Exception
    //   134	1	2	localLottieImageAsset2	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   50	35	3	localObject1	Object
    //   86	37	3	localThrowable1	java.lang.Throwable
    //   132	4	3	localObject2	Object
    //   140	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	39	86	java/lang/Throwable
    //   2	39	110	finally
    //   80	84	121	java/lang/Exception
    //   104	108	124	java/lang/Exception
    //   115	119	128	java/lang/Exception
    //   43	51	132	finally
    //   53	58	132	finally
    //   60	70	132	finally
    //   72	76	132	finally
    //   91	100	132	finally
    //   43	51	140	java/lang/Throwable
    //   53	58	140	java/lang/Throwable
    //   60	70	140	java/lang/Throwable
    //   72	76	140	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhn
 * JD-Core Version:    0.7.0.1
 */