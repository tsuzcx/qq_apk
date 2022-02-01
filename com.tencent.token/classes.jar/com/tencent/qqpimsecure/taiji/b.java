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
    //   12: ifnonnull +303 -> 315
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
    //   44: ifeq +157 -> 201
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
    //   70: ifeq +39 -> 109
    //   73: aload_1
    //   74: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   77: ldc 70
    //   79: invokestatic 76	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 4
    //   84: ldc 78
    //   86: new 80	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   93: ldc 83
    //   95: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 4
    //   100: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 4
    //   111: astore_3
    //   112: aload 4
    //   114: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +6 -> 123
    //   120: ldc 97
    //   122: astore_3
    //   123: aload_1
    //   124: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   127: ldc 70
    //   129: invokestatic 76	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: astore 5
    //   138: aload 5
    //   140: astore 4
    //   142: aload 5
    //   144: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifeq +7 -> 154
    //   150: ldc 97
    //   152: astore 4
    //   154: ldc 78
    //   156: new 80	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   163: ldc 99
    //   165: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_3
    //   169: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 101
    //   174: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 4
    //   179: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 6
    //   190: aload_3
    //   191: invokevirtual 104	com/tencent/qqpimsecure/taiji/i:a	(Ljava/lang/String;)V
    //   194: aload 6
    //   196: aload 4
    //   198: invokevirtual 106	com/tencent/qqpimsecure/taiji/i:b	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: aload_1
    //   203: aload_3
    //   204: invokevirtual 110	java/lang/String:getBytes	()[B
    //   207: aload 4
    //   209: invokevirtual 110	java/lang/String:getBytes	()[B
    //   212: invokestatic 116	com/tencent/qqpimsecure/taiji/KeyCreator:create	(Landroid/content/Context;[B[B)[B
    //   215: putfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   218: ldc 78
    //   220: new 80	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   227: ldc 118
    //   229: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   236: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   249: ifnull +11 -> 260
    //   252: aload_0
    //   253: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   256: arraylength
    //   257: ifne +58 -> 315
    //   260: ldc 78
    //   262: ldc 123
    //   264: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: invokestatic 128	com/tencent/qqpimsecure/taiji/c:a	()Lcom/tencent/qqpimsecure/taiji/c;
    //   271: invokevirtual 132	com/tencent/qqpimsecure/taiji/c:f	()Ltmsdk/common/module/pgsdk/manager/ITaijiTccCryptManager;
    //   274: ldc 134
    //   276: invokevirtual 110	java/lang/String:getBytes	()[B
    //   279: aconst_null
    //   280: invokeinterface 140 3 0
    //   285: putfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   288: ldc 78
    //   290: new 80	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   297: ldc 142
    //   299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 24	com/tencent/qqpimsecure/taiji/b:a	[B
    //   306: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_0
    //   316: monitorexit
    //   317: return
    //   318: astore_1
    //   319: aload_0
    //   320: monitorexit
    //   321: aload_1
    //   322: athrow
    //   323: astore_1
    //   324: goto -79 -> 245
    //   327: astore 4
    //   329: goto -191 -> 138
    //   332: astore 4
    //   334: aload_3
    //   335: astore 4
    //   337: goto -253 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	b
    //   0	340	1	paramContext	Context
    //   65	5	2	bool	boolean
    //   20	315	3	localObject1	Object
    //   37	171	4	localObject2	Object
    //   327	1	4	localThrowable1	Throwable
    //   332	1	4	localThrowable2	Throwable
    //   335	1	4	localObject3	Object
    //   26	117	5	localObject4	Object
    //   6	189	6	locali	i
    // Exception table:
    //   from	to	target	type
    //   2	35	318	finally
    //   39	47	318	finally
    //   47	66	318	finally
    //   73	84	318	finally
    //   84	109	318	finally
    //   112	120	318	finally
    //   123	134	318	finally
    //   142	150	318	finally
    //   154	201	318	finally
    //   201	245	318	finally
    //   245	260	318	finally
    //   260	315	318	finally
    //   201	245	323	java/lang/Throwable
    //   123	134	327	java/lang/Throwable
    //   73	84	332	java/lang/Throwable
  }
  
  /* Error */
  private void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aconst_null
    //   5: aconst_null
    //   6: invokestatic 116	com/tencent/qqpimsecure/taiji/KeyCreator:create	(Landroid/content/Context;[B[B)[B
    //   9: putfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   12: ldc 78
    //   14: new 80	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   21: ldc 144
    //   23: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   30: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   43: ifnull +11 -> 54
    //   46: aload_0
    //   47: getfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   50: arraylength
    //   51: ifne +58 -> 109
    //   54: ldc 78
    //   56: ldc 146
    //   58: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 128	com/tencent/qqpimsecure/taiji/c:a	()Lcom/tencent/qqpimsecure/taiji/c;
    //   65: invokevirtual 132	com/tencent/qqpimsecure/taiji/c:f	()Ltmsdk/common/module/pgsdk/manager/ITaijiTccCryptManager;
    //   68: ldc 134
    //   70: invokevirtual 110	java/lang/String:getBytes	()[B
    //   73: aconst_null
    //   74: invokeinterface 140 3 0
    //   79: putfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   82: ldc 78
    //   84: new 80	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   91: ldc 148
    //   93: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 28	com/tencent/qqpimsecure/taiji/b:b	[B
    //   100: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 95	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -79 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	b
    //   0	121	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	39	112	finally
    //   39	54	112	finally
    //   54	109	112	finally
    //   2	39	117	java/lang/Throwable
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