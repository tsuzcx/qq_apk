package com.tencent.token;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ph
{
  public static Context a;
  public static ThreadPoolExecutor b = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private static final int c;
  private static final int d;
  private static final int e;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    c = i;
    d = i + 1;
    e = c * 2 + 1;
  }
  
  /* Error */
  private static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +101 -> 102
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 60	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +13 -> 35
    //   25: aload_0
    //   26: ifnull +7 -> 33
    //   29: aload_0
    //   30: invokevirtual 65	java/io/InputStream:close	()V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: astore_3
    //   37: aload_0
    //   38: astore 4
    //   40: aload_0
    //   41: invokevirtual 68	java/io/InputStream:available	()I
    //   44: istore_2
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 65	java/io/InputStream:close	()V
    //   53: iload_2
    //   54: ireturn
    //   55: astore_0
    //   56: goto +36 -> 92
    //   59: astore_0
    //   60: aload 4
    //   62: astore_3
    //   63: new 70	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 72
    //   69: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: ifnull +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 65	java/io/InputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 65	java/io/InputStream:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: iload_2
    //   109: ireturn
    //   110: astore_0
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: goto -14 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContentResolver	android.content.ContentResolver
    //   0	117	1	paramUri	Uri
    //   44	65	2	i	int
    //   14	83	3	localContentResolver1	android.content.ContentResolver
    //   11	75	4	localContentResolver2	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   15	21	55	finally
    //   40	45	55	finally
    //   63	80	55	finally
    //   15	21	59	java/lang/Exception
    //   40	45	59	java/lang/Exception
    //   29	33	104	java/io/IOException
    //   49	53	107	java/io/IOException
    //   85	90	110	java/io/IOException
    //   96	100	113	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int b(String paramString)
  {
    File localFile;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      localFile = new File(paramString);
      if ((!localFile.exists()) && ((a == null) || (!paramString.startsWith("content")))) {}
    }
    try
    {
      int i = a(a.getContentResolver(), Uri.parse(paramString));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
    return (int)localFile.length();
    return 0;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ph
 * JD-Core Version:    0.7.0.1
 */