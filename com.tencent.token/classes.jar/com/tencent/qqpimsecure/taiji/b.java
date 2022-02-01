package com.tencent.qqpimsecure.taiji;

import android.content.Context;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager;

public class b
{
  private byte[] a;
  private byte[] b;
  
  public static b a()
  {
    return a.a();
  }
  
  private void a(Context paramContext)
  {
    if (this.a == null) {
      b(paramContext);
    }
    if (this.b == null) {
      c(paramContext);
    }
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 38	com/tencent/qqpimsecure/taiji/i:a	(Landroid/content/Context;)Lcom/tencent/qqpimsecure/taiji/i;
    //   6: astore 6
    //   8: aload_0
    //   9: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   12: ifnonnull +337 -> 349
    //   15: aload 6
    //   17: invokevirtual 41	com/tencent/qqpimsecure/taiji/i:a	()Ljava/lang/String;
    //   20: astore_3
    //   21: aload 6
    //   23: invokevirtual 43	com/tencent/qqpimsecure/taiji/i:b	()Ljava/lang/String;
    //   26: astore 5
    //   28: aload_3
    //   29: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +15 -> 47
    //   35: aload 5
    //   37: astore 4
    //   39: aload 5
    //   41: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifeq +179 -> 223
    //   47: aload_1
    //   48: invokestatic 54	taiji/bl:a	(Landroid/content/Context;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +17 -> 73
    //   59: aload_3
    //   60: ldc 56
    //   62: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: istore_2
    //   66: aload_3
    //   67: astore 4
    //   69: iload_2
    //   70: ifeq +45 -> 115
    //   73: aload_1
    //   74: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   77: ldc 70
    //   79: invokestatic 76	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 4
    //   84: new 78	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   91: astore_3
    //   92: aload_3
    //   93: ldc 81
    //   95: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: aload 4
    //   102: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 87
    //   108: aload_3
    //   109: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +6 -> 129
    //   126: ldc 97
    //   128: astore_3
    //   129: aload_1
    //   130: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   133: ldc 70
    //   135: invokestatic 76	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: astore 5
    //   144: aload 5
    //   146: astore 4
    //   148: aload 5
    //   150: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +7 -> 160
    //   156: ldc 97
    //   158: astore 4
    //   160: new 78	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   167: astore 5
    //   169: aload 5
    //   171: ldc 99
    //   173: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: aload_3
    //   180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc 101
    //   188: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload 4
    //   196: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 87
    //   202: aload 5
    //   204: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 6
    //   212: aload_3
    //   213: invokevirtual 104	com/tencent/qqpimsecure/taiji/i:a	(Ljava/lang/String;)V
    //   216: aload 6
    //   218: aload 4
    //   220: invokevirtual 106	com/tencent/qqpimsecure/taiji/i:b	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload_1
    //   225: aload_3
    //   226: invokevirtual 110	java/lang/String:getBytes	()[B
    //   229: aload 4
    //   231: invokevirtual 110	java/lang/String:getBytes	()[B
    //   234: invokestatic 116	com/tencent/qqpimsecure/taiji/KeyCreator:create	(Landroid/content/Context;[B[B)[B
    //   237: putfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   240: new 78	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   247: astore_1
    //   248: aload_1
    //   249: ldc 118
    //   251: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: aload_0
    //   257: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   260: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 87
    //   266: aload_1
    //   267: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   277: ifnull +11 -> 288
    //   280: aload_0
    //   281: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   284: arraylength
    //   285: ifne +64 -> 349
    //   288: ldc 87
    //   290: ldc 123
    //   292: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: invokestatic 128	com/tencent/qqpimsecure/taiji/c:a	()Lcom/tencent/qqpimsecure/taiji/c;
    //   299: invokevirtual 132	com/tencent/qqpimsecure/taiji/c:f	()Ltmsdk/common/module/pgsdk/manager/ITaijiTccCryptManager;
    //   302: ldc 134
    //   304: invokevirtual 110	java/lang/String:getBytes	()[B
    //   307: aconst_null
    //   308: invokeinterface 140 3 0
    //   313: putfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   316: new 78	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   323: astore_1
    //   324: aload_1
    //   325: ldc 142
    //   327: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: aload_0
    //   333: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   336: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: ldc 87
    //   342: aload_1
    //   343: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: monitorexit
    //   351: return
    //   352: astore_1
    //   353: aload_0
    //   354: monitorexit
    //   355: aload_1
    //   356: athrow
    //   357: astore 4
    //   359: aload_3
    //   360: astore 4
    //   362: goto -278 -> 84
    //   365: astore 4
    //   367: goto -223 -> 144
    //   370: astore_1
    //   371: goto -98 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	b
    //   0	374	1	paramContext	Context
    //   65	5	2	bool	boolean
    //   20	340	3	localObject1	Object
    //   37	193	4	localObject2	Object
    //   357	1	4	localThrowable1	Throwable
    //   360	1	4	localObject3	Object
    //   365	1	4	localThrowable2	Throwable
    //   26	177	5	localObject4	Object
    //   6	211	6	locali	i
    // Exception table:
    //   from	to	target	type
    //   2	35	352	finally
    //   39	47	352	finally
    //   47	66	352	finally
    //   73	84	352	finally
    //   84	115	352	finally
    //   118	126	352	finally
    //   129	140	352	finally
    //   148	156	352	finally
    //   160	223	352	finally
    //   223	273	352	finally
    //   273	288	352	finally
    //   288	349	352	finally
    //   73	84	357	java/lang/Throwable
    //   129	140	365	java/lang/Throwable
    //   223	273	370	java/lang/Throwable
  }
  
  private void c(Context paramContext)
  {
    label131:
    try
    {
      try
      {
        this.b = KeyCreator.create(paramContext, null, null);
        paramContext = new StringBuilder();
        paramContext.append("mDefaultKey:");
        paramContext.append(this.b);
        bn.b("TaijiEncryptor", paramContext.toString());
      }
      finally
      {
        break label131;
      }
    }
    catch (Throwable paramContext)
    {
      label52:
      break label52;
    }
    if ((this.b == null) || (this.b.length == 0))
    {
      bn.b("TaijiEncryptor", "initDefaultKey exception key");
      this.b = c.a().f().encrypt("*M<>DFG##%$R(&$G%^HR<".getBytes(), null);
      paramContext = new StringBuilder();
      paramContext.append("initDefaultKey exception key:");
      paramContext.append(this.b);
      bn.b("TaijiEncryptor", paramContext.toString());
    }
    return;
    throw paramContext;
  }
  
  public byte[] a(Context paramContext, byte[] paramArrayOfByte)
  {
    return a(paramContext, paramArrayOfByte, false);
  }
  
  public byte[] a(Context paramContext, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    a(paramContext);
    try
    {
      paramContext = this.b;
      if (!paramBoolean) {
        paramContext = this.a;
      }
      paramContext = c.a().f().encrypt(paramArrayOfByte, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      bn.a("TaijiEncryptor", paramContext.getMessage());
    }
    return null;
  }
  
  public byte[] b(Context paramContext, byte[] paramArrayOfByte)
  {
    return b(paramContext, paramArrayOfByte, false);
  }
  
  public byte[] b(Context paramContext, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    a(paramContext);
    try
    {
      paramContext = this.b;
      if (!paramBoolean) {
        paramContext = this.a;
      }
      paramContext = c.a().f().decrypt(paramArrayOfByte, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      bn.a("TaijiEncryptor", paramContext.getMessage());
    }
    return null;
  }
  
  private static final class a
  {
    private static final b a = new b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.b
 * JD-Core Version:    0.7.0.1
 */