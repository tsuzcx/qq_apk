package taiji;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;

public class cf
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  /* Error */
  public static byte[] a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 25	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: invokevirtual 31	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: aload_1
    //   18: invokevirtual 37	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokestatic 40	taiji/cf:a	(Ljava/io/InputStream;)[B
    //   28: astore_2
    //   29: aload_1
    //   30: invokestatic 42	taiji/cf:a	(Ljava/io/Closeable;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_2
    //   41: invokevirtual 17	java/lang/Throwable:printStackTrace	()V
    //   44: aload_1
    //   45: invokestatic 42	taiji/cf:a	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_0
    //   54: astore_1
    //   55: aload_2
    //   56: invokestatic 42	taiji/cf:a	(Ljava/io/Closeable;)V
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: astore_2
    //   64: goto -9 -> 55
    //   67: astore_2
    //   68: goto -30 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	android.content.Context
    //   0	71	1	paramString	java.lang.String
    //   28	6	2	arrayOfByte	byte[]
    //   35	6	2	localThrowable1	Throwable
    //   52	12	2	localObject	Object
    //   67	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	22	35	java/lang/Throwable
    //   13	22	50	finally
    //   24	29	61	finally
    //   40	44	61	finally
    //   24	29	67	java/lang/Throwable
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cf
 * JD-Core Version:    0.7.0.1
 */