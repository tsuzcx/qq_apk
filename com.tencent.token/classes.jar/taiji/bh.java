package taiji;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;

public class bh
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
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
  }
  
  /* Error */
  public static byte[] a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +66 -> 67
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
    //   25: invokestatic 40	taiji/bh:a	(Ljava/io/InputStream;)[B
    //   28: astore_2
    //   29: aload_1
    //   30: invokestatic 42	taiji/bh:a	(Ljava/io/Closeable;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: goto +12 -> 48
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: goto +19 -> 61
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: invokevirtual 17	java/lang/Throwable:printStackTrace	()V
    //   54: aload_1
    //   55: invokestatic 42	taiji/bh:a	(Ljava/io/Closeable;)V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_1
    //   61: aload_0
    //   62: invokestatic 42	taiji/bh:a	(Ljava/io/Closeable;)V
    //   65: aload_1
    //   66: athrow
    //   67: aconst_null
    //   68: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramContext	android.content.Context
    //   0	69	1	paramString	java.lang.String
    //   28	6	2	arrayOfByte	byte[]
    //   35	1	2	localThrowable1	Throwable
    //   45	6	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	29	35	java/lang/Throwable
    //   13	22	39	finally
    //   13	22	45	java/lang/Throwable
    //   24	29	60	finally
    //   50	54	60	finally
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
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bh
 * JD-Core Version:    0.7.0.1
 */