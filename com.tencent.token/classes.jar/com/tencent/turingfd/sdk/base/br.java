package com.tencent.turingfd.sdk.base;

import android.content.Context;

public class br
  implements bk
{
  /* Error */
  public bo a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/turingfd/sdk/base/ct:av	[I
    //   3: invokestatic 24	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   6: invokestatic 30	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   9: astore_2
    //   10: getstatic 32	com/tencent/turingfd/sdk/base/ct:a	[I
    //   13: invokestatic 24	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   16: astore_3
    //   17: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   20: bipush 17
    //   22: if_icmplt +106 -> 128
    //   25: aload_1
    //   26: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_2
    //   30: invokevirtual 50	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   33: astore_2
    //   34: aload_2
    //   35: aload_3
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 56	android/content/ContentProviderClient:call	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   41: astore_1
    //   42: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 24
    //   47: if_icmplt +16 -> 63
    //   50: aload_2
    //   51: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   54: aload_1
    //   55: ifnonnull +88 -> 143
    //   58: iconst_m1
    //   59: invokestatic 64	com/tencent/turingfd/sdk/base/bo:a	(I)Lcom/tencent/turingfd/sdk/base/bo;
    //   62: areturn
    //   63: aload_2
    //   64: invokevirtual 68	android/content/ContentProviderClient:release	()Z
    //   67: pop
    //   68: goto -14 -> 54
    //   71: astore_1
    //   72: aload_2
    //   73: ifnull +15 -> 88
    //   76: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 24
    //   81: if_icmplt +9 -> 90
    //   84: aload_2
    //   85: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: aload_2
    //   91: invokevirtual 68	android/content/ContentProviderClient:release	()Z
    //   94: pop
    //   95: goto -7 -> 88
    //   98: astore_1
    //   99: aload_2
    //   100: ifnull +15 -> 115
    //   103: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   106: bipush 24
    //   108: if_icmplt +12 -> 120
    //   111: aload_2
    //   112: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -63 -> 54
    //   120: aload_2
    //   121: invokevirtual 68	android/content/ContentProviderClient:release	()Z
    //   124: pop
    //   125: goto -10 -> 115
    //   128: aload_1
    //   129: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   132: aload_2
    //   133: aload_3
    //   134: aconst_null
    //   135: aconst_null
    //   136: invokevirtual 71	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   139: astore_1
    //   140: goto -86 -> 54
    //   143: aload_1
    //   144: getstatic 74	com/tencent/turingfd/sdk/base/ct:aw	[I
    //   147: invokestatic 24	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   150: iconst_m1
    //   151: invokevirtual 80	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   154: ifeq +9 -> 163
    //   157: bipush 254
    //   159: invokestatic 64	com/tencent/turingfd/sdk/base/bo:a	(I)Lcom/tencent/turingfd/sdk/base/bo;
    //   162: areturn
    //   163: new 61	com/tencent/turingfd/sdk/base/bo
    //   166: dup
    //   167: aload_1
    //   168: getstatic 83	com/tencent/turingfd/sdk/base/ct:ax	[I
    //   171: invokestatic 24	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   174: invokevirtual 87	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: iconst_0
    //   178: invokespecial 90	com/tencent/turingfd/sdk/base/bo:<init>	(Ljava/lang/String;I)V
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	br
    //   0	182	1	paramContext	Context
    //   9	124	2	localObject	Object
    //   16	118	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   34	42	71	finally
    //   34	42	98	java/lang/Throwable
  }
  
  public void b(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.br
 * JD-Core Version:    0.7.0.1
 */