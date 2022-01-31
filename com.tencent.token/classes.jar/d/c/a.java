package d.c;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import tmsdk.common.tcc.TccCryptor;

public class a
{
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("gbk");
        if (arrayOfByte == null) {
          continue;
        }
        return tmsdk.common.e.a.b(TccCryptor.encrypt(paramContext, arrayOfByte, null), 0);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +8 -> 14
    //   9: ldc 43
    //   11: astore_0
    //   12: aload_0
    //   13: areturn
    //   14: aload_1
    //   15: iconst_0
    //   16: invokestatic 46	tmsdk/common/e/a:a	(Ljava/lang/String;I)[B
    //   19: astore_2
    //   20: aload_0
    //   21: aload_2
    //   22: aconst_null
    //   23: invokestatic 49	tmsdk/common/tcc/TccCryptor:decrypt	(Landroid/content/Context;[B[B)[B
    //   26: astore_2
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull -18 -> 12
    //   33: new 12	java/lang/String
    //   36: dup
    //   37: aload_2
    //   38: ldc 10
    //   40: invokespecial 53	java/lang/String:<init>	([BLjava/lang/String;)V
    //   43: astore_2
    //   44: aload_1
    //   45: astore_0
    //   46: aload_2
    //   47: ifnull -35 -> 12
    //   50: aload_2
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: areturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 54	java/lang/Exception:printStackTrace	()V
    //   60: aconst_null
    //   61: astore_2
    //   62: goto -35 -> 27
    //   65: astore_0
    //   66: aload_3
    //   67: astore_2
    //   68: goto -24 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	Context
    //   0	71	1	paramString	String
    //   19	49	2	localObject1	Object
    //   1	66	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	52	java/lang/Exception
    //   20	27	55	java/lang/Exception
    //   33	44	65	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     d.c.a
 * JD-Core Version:    0.7.0.1
 */