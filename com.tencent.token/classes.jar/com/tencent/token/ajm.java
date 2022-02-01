package com.tencent.token;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import tmsdk.common.tcc.TccCryptor;

public final class ajm
{
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte2;
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("gbk");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      arrayOfByte2 = null;
    }
    if (arrayOfByte2 != null) {
      return aug.a(TccCryptor.encrypt(paramContext, arrayOfByte2, null));
    }
    return paramString;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 43
    //   9: areturn
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_1
    //   13: invokestatic 45	com/tencent/token/aug:a	(Ljava/lang/String;)[B
    //   16: astore_3
    //   17: aload_0
    //   18: aload_3
    //   19: aconst_null
    //   20: invokestatic 48	tmsdk/common/tcc/TccCryptor:decrypt	(Landroid/content/Context;[B[B)[B
    //   23: astore_0
    //   24: goto +10 -> 34
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 49	java/lang/Exception:printStackTrace	()V
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +22 -> 57
    //   38: new 12	java/lang/String
    //   41: dup
    //   42: aload_0
    //   43: ldc 10
    //   45: invokespecial 53	java/lang/String:<init>	([BLjava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: ifnull +5 -> 55
    //   53: aload_0
    //   54: areturn
    //   55: aload_1
    //   56: areturn
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aload_2
    //   64: astore_0
    //   65: goto -16 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   0	68	1	paramString	String
    //   11	53	2	localObject	Object
    //   16	3	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	27	java/lang/Exception
    //   12	17	59	java/lang/Exception
    //   38	49	62	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajm
 * JD-Core Version:    0.7.0.1
 */