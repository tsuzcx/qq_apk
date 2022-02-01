import android.content.Context;
import com.rookery.translate.model.TranslateCache.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ifs
{
  private static ifo a;
  private static ifp b;
  
  /* Error */
  public static ifo a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 18	ifs:a	Lifo;
    //   3: ifnonnull +81 -> 84
    //   6: aload_0
    //   7: ldc 20
    //   9: invokevirtual 26	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 28	android/app/ActivityManager
    //   15: invokevirtual 32	android/app/ActivityManager:getMemoryClass	()I
    //   18: ldc 33
    //   20: imul
    //   21: bipush 8
    //   23: idiv
    //   24: istore_1
    //   25: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +28 -> 56
    //   31: ldc 41
    //   33: iconst_2
    //   34: new 43	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   41: ldc 46
    //   43: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 2
    //   58: monitorenter
    //   59: getstatic 18	ifs:a	Lifo;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnonnull +17 -> 81
    //   67: new 63	ifo
    //   70: dup
    //   71: aload_0
    //   72: iconst_1
    //   73: iload_1
    //   74: i2l
    //   75: invokespecial 66	ifo:<init>	(Landroid/content/Context;IJ)V
    //   78: putstatic 18	ifs:a	Lifo;
    //   81: ldc 2
    //   83: monitorexit
    //   84: getstatic 18	ifs:a	Lifo;
    //   87: areturn
    //   88: astore_0
    //   89: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -11 -> 81
    //   95: ldc 41
    //   97: iconst_2
    //   98: new 43	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   105: ldc 68
    //   107: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -39 -> 81
    //   123: astore_0
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_0
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   24	50	1	i	int
    //   62	2	2	localifo	ifo
    // Exception table:
    //   from	to	target	type
    //   67	81	88	java/io/IOException
    //   59	63	123	finally
    //   67	81	123	finally
    //   81	84	123	finally
    //   89	120	123	finally
    //   124	127	123	finally
  }
  
  public static ifp a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new ifp(65536);
      }
      return b;
    }
    finally {}
  }
  
  public static ifo b(Context paramContext)
  {
    if (a == null) {
      ThreadManager.post(new TranslateCache.1(paramContext), 5, null, true);
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifs
 * JD-Core Version:    0.7.0.1
 */