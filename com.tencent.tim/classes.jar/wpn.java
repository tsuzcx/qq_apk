import android.content.Context;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

public class wpn
  implements ImageAssetDelegate
{
  private Context mContext;
  String mPath;
  
  public wpn(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mPath = (wpj.aTO + paramString + "images/");
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: new 45	java/io/FileInputStream
    //   3: dup
    //   4: new 19	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: getfield 37	wpn:mPath	Ljava/lang/String;
    //   15: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 50	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   22: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new 55	android/graphics/BitmapFactory$Options
    //   37: dup
    //   38: invokespecial 56	android/graphics/BitmapFactory$Options:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 60	android/graphics/BitmapFactory$Options:inScaled	Z
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aconst_null
    //   53: checkcast 62	android/graphics/Rect
    //   56: aload_3
    //   57: invokestatic 68	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_3
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 73	java/io/InputStream:close	()V
    //   69: aload_3
    //   70: areturn
    //   71: astore_1
    //   72: ldc 75
    //   74: iconst_2
    //   75: new 19	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   82: ldc 77
    //   84: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_3
    //   101: areturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 75
    //   109: iconst_2
    //   110: new 19	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   117: ldc 88
    //   119: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 73	java/io/InputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: ldc 75
    //   148: iconst_2
    //   149: new 19	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   156: ldc 77
    //   158: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: goto -31 -> 143
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 73	java/io/InputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: ldc 75
    //   193: iconst_2
    //   194: new 19	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   201: ldc 77
    //   203: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: goto -31 -> 188
    //   222: astore_2
    //   223: goto -43 -> 180
    //   226: astore_3
    //   227: goto -122 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	wpn
    //   0	230	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   31	109	2	localFileInputStream	java.io.FileInputStream
    //   177	12	2	localObject1	Object
    //   222	1	2	localObject2	Object
    //   41	60	3	localObject3	Object
    //   102	21	3	localThrowable1	java.lang.Throwable
    //   226	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/lang/Throwable
    //   0	32	102	java/lang/Throwable
    //   139	143	145	java/lang/Throwable
    //   0	32	177	finally
    //   184	188	190	java/lang/Throwable
    //   34	42	222	finally
    //   44	49	222	finally
    //   51	61	222	finally
    //   107	135	222	finally
    //   34	42	226	java/lang/Throwable
    //   44	49	226	java/lang/Throwable
    //   51	61	226	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpn
 * JD-Core Version:    0.7.0.1
 */