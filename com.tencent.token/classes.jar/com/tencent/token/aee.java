package com.tencent.token;

import android.content.Context;

public final class aee
  implements adx
{
  /* Error */
  public final aeb a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/token/afg:av	[I
    //   3: invokestatic 24	com/tencent/token/afg:a	([I)Ljava/lang/String;
    //   6: invokestatic 30	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   9: astore 4
    //   11: getstatic 32	com/tencent/token/afg:a	[I
    //   14: invokestatic 24	com/tencent/token/afg:a	([I)Ljava/lang/String;
    //   17: astore 5
    //   19: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   22: istore_2
    //   23: aconst_null
    //   24: astore_3
    //   25: iload_2
    //   26: bipush 17
    //   28: if_icmplt +115 -> 143
    //   31: aload_1
    //   32: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload 4
    //   37: invokevirtual 50	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   40: astore 4
    //   42: aload 4
    //   44: aload 5
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 56	android/content/ContentProviderClient:call	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   51: astore_1
    //   52: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 24
    //   57: if_icmplt +11 -> 68
    //   60: aload 4
    //   62: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   65: goto +92 -> 157
    //   68: aload 4
    //   70: invokevirtual 63	android/content/ContentProviderClient:release	()Z
    //   73: pop
    //   74: goto +83 -> 157
    //   77: astore_1
    //   78: aload 4
    //   80: ifnull +25 -> 105
    //   83: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 24
    //   88: if_icmplt +11 -> 99
    //   91: aload 4
    //   93: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   96: goto +9 -> 105
    //   99: aload 4
    //   101: invokevirtual 63	android/content/ContentProviderClient:release	()Z
    //   104: pop
    //   105: aload_1
    //   106: athrow
    //   107: aload_3
    //   108: astore_1
    //   109: aload 4
    //   111: ifnull +46 -> 157
    //   114: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   117: bipush 24
    //   119: if_icmplt +13 -> 132
    //   122: aload 4
    //   124: invokevirtual 59	android/content/ContentProviderClient:close	()V
    //   127: aload_3
    //   128: astore_1
    //   129: goto +28 -> 157
    //   132: aload 4
    //   134: invokevirtual 63	android/content/ContentProviderClient:release	()Z
    //   137: pop
    //   138: aload_3
    //   139: astore_1
    //   140: goto +17 -> 157
    //   143: aload_1
    //   144: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   147: aload 4
    //   149: aload 5
    //   151: aconst_null
    //   152: aconst_null
    //   153: invokevirtual 66	android/content/ContentResolver:call	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   156: astore_1
    //   157: aload_1
    //   158: ifnonnull +8 -> 166
    //   161: iconst_m1
    //   162: invokestatic 71	com/tencent/token/aeb:a	(I)Lcom/tencent/token/aeb;
    //   165: areturn
    //   166: aload_1
    //   167: getstatic 74	com/tencent/token/afg:aw	[I
    //   170: invokestatic 24	com/tencent/token/afg:a	([I)Ljava/lang/String;
    //   173: iconst_m1
    //   174: invokevirtual 80	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   177: ifeq +9 -> 186
    //   180: bipush 254
    //   182: invokestatic 71	com/tencent/token/aeb:a	(I)Lcom/tencent/token/aeb;
    //   185: areturn
    //   186: new 68	com/tencent/token/aeb
    //   189: dup
    //   190: aload_1
    //   191: getstatic 83	com/tencent/token/afg:ax	[I
    //   194: invokestatic 24	com/tencent/token/afg:a	([I)Ljava/lang/String;
    //   197: invokevirtual 87	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: iconst_0
    //   201: invokespecial 90	com/tencent/token/aeb:<init>	(Ljava/lang/String;I)V
    //   204: areturn
    //   205: astore_1
    //   206: goto -99 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	aee
    //   0	209	1	paramContext	Context
    //   22	7	2	i	int
    //   24	115	3	localObject1	Object
    //   9	139	4	localObject2	Object
    //   17	133	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   42	52	77	finally
    //   42	52	205	java/lang/Throwable
  }
  
  public final void b(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aee
 * JD-Core Version:    0.7.0.1
 */