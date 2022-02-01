package com.tencent.token;

import android.content.Context;
import com.tencent.qqpimsecure.taiji.KeyCreator;

public final class rj
{
  private byte[] a;
  private byte[] b;
  
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
    //   3: invokestatic 33	com/tencent/token/rq:a	(Landroid/content/Context;)Lcom/tencent/token/rq;
    //   6: pop
    //   7: aload_0
    //   8: getfield 19	com/tencent/token/rj:a	[B
    //   11: ifnonnull +323 -> 334
    //   14: invokestatic 38	com/tencent/token/rk$a:a	()Lcom/tencent/token/rk;
    //   17: ldc 40
    //   19: invokevirtual 45	com/tencent/token/rk:a	(Ljava/lang/String;)Lcom/tencent/token/avb;
    //   22: ldc 47
    //   24: ldc 49
    //   26: invokeinterface 54 3 0
    //   31: astore_3
    //   32: invokestatic 38	com/tencent/token/rk$a:a	()Lcom/tencent/token/rk;
    //   35: ldc 40
    //   37: invokevirtual 45	com/tencent/token/rk:a	(Ljava/lang/String;)Lcom/tencent/token/avb;
    //   40: ldc 56
    //   42: ldc 49
    //   44: invokeinterface 54 3 0
    //   49: astore 5
    //   51: aload_3
    //   52: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +15 -> 70
    //   58: aload 5
    //   60: astore 4
    //   62: aload 5
    //   64: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +171 -> 238
    //   70: ldc 64
    //   72: astore_3
    //   73: ldc 64
    //   75: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +18 -> 96
    //   81: ldc 64
    //   83: ldc 66
    //   85: invokevirtual 72	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   88: istore_2
    //   89: aload_3
    //   90: astore 4
    //   92: iload_2
    //   93: ifeq +28 -> 121
    //   96: aload_1
    //   97: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: ldc 80
    //   102: invokestatic 86	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 4
    //   107: ldc 88
    //   109: aload 4
    //   111: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokevirtual 96	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   117: pop
    //   118: invokestatic 100	com/tencent/token/aqx:b	()V
    //   121: aload 4
    //   123: astore_3
    //   124: aload 4
    //   126: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +6 -> 135
    //   132: ldc 102
    //   134: astore_3
    //   135: aload_1
    //   136: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   139: ldc 80
    //   141: invokestatic 86	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 4
    //   146: aload 4
    //   148: astore 5
    //   150: aload 5
    //   152: astore 4
    //   154: aload 5
    //   156: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +7 -> 166
    //   162: ldc 102
    //   164: astore 4
    //   166: new 104	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 106
    //   172: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: astore 5
    //   177: aload 5
    //   179: aload_3
    //   180: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc 115
    //   188: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload 4
    //   196: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: invokestatic 100	com/tencent/token/aqx:b	()V
    //   203: invokestatic 38	com/tencent/token/rk$a:a	()Lcom/tencent/token/rk;
    //   206: ldc 40
    //   208: invokevirtual 45	com/tencent/token/rk:a	(Ljava/lang/String;)Lcom/tencent/token/avb;
    //   211: ldc 47
    //   213: aload_3
    //   214: invokeinterface 118 3 0
    //   219: pop
    //   220: invokestatic 38	com/tencent/token/rk$a:a	()Lcom/tencent/token/rk;
    //   223: ldc 40
    //   225: invokevirtual 45	com/tencent/token/rk:a	(Ljava/lang/String;)Lcom/tencent/token/avb;
    //   228: ldc 56
    //   230: aload 4
    //   232: invokeinterface 118 3 0
    //   237: pop
    //   238: aload_0
    //   239: aload_1
    //   240: aload_3
    //   241: invokevirtual 122	java/lang/String:getBytes	()[B
    //   244: aload 4
    //   246: invokevirtual 122	java/lang/String:getBytes	()[B
    //   249: invokestatic 128	com/tencent/qqpimsecure/taiji/KeyCreator:create	(Landroid/content/Context;[B[B)[B
    //   252: putfield 19	com/tencent/token/rj:a	[B
    //   255: new 104	java/lang/StringBuilder
    //   258: dup
    //   259: ldc 130
    //   261: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: aload_0
    //   265: getfield 19	com/tencent/token/rj:a	[B
    //   268: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: invokestatic 100	com/tencent/token/aqx:b	()V
    //   275: aload_0
    //   276: getfield 19	com/tencent/token/rj:a	[B
    //   279: ifnull +11 -> 290
    //   282: aload_0
    //   283: getfield 19	com/tencent/token/rj:a	[B
    //   286: arraylength
    //   287: ifne +47 -> 334
    //   290: invokestatic 100	com/tencent/token/aqx:b	()V
    //   293: aload_0
    //   294: invokestatic 38	com/tencent/token/rk$a:a	()Lcom/tencent/token/rk;
    //   297: invokevirtual 136	com/tencent/token/rk:c	()Lcom/tencent/token/ave;
    //   300: ldc 138
    //   302: invokevirtual 122	java/lang/String:getBytes	()[B
    //   305: aconst_null
    //   306: invokeinterface 143 3 0
    //   311: putfield 19	com/tencent/token/rj:a	[B
    //   314: new 104	java/lang/StringBuilder
    //   317: dup
    //   318: ldc 145
    //   320: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload_0
    //   324: getfield 19	com/tencent/token/rj:a	[B
    //   327: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: invokestatic 100	com/tencent/token/aqx:b	()V
    //   334: aload_0
    //   335: monitorexit
    //   336: return
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: astore 4
    //   344: aload_3
    //   345: astore 4
    //   347: goto -240 -> 107
    //   350: astore 4
    //   352: goto -202 -> 150
    //   355: astore_1
    //   356: goto -81 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	rj
    //   0	359	1	paramContext	Context
    //   88	5	2	bool	boolean
    //   31	314	3	localObject1	Object
    //   60	185	4	localObject2	Object
    //   342	1	4	localThrowable1	Throwable
    //   345	1	4	localObject3	Object
    //   350	1	4	localThrowable2	Throwable
    //   49	144	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	337	finally
    //   62	70	337	finally
    //   73	89	337	finally
    //   96	107	337	finally
    //   107	121	337	finally
    //   124	132	337	finally
    //   135	146	337	finally
    //   154	162	337	finally
    //   166	238	337	finally
    //   238	275	337	finally
    //   275	290	337	finally
    //   290	334	337	finally
    //   96	107	342	java/lang/Throwable
    //   135	146	350	java/lang/Throwable
    //   238	275	355	java/lang/Throwable
  }
  
  private void c(Context paramContext)
  {
    try
    {
      try
      {
        this.b = KeyCreator.create(paramContext, null, null);
        new StringBuilder("mDefaultKey:").append(this.b);
        aqx.b();
      }
      finally
      {
        break label101;
      }
    }
    catch (Throwable paramContext)
    {
      label39:
      label101:
      break label39;
    }
    if ((this.b == null) || (this.b.length == 0))
    {
      aqx.b();
      this.b = rk.a.a().c().a("*M<>DFG##%$R(&$G%^HR<".getBytes(), null);
      new StringBuilder("initDefaultKey exception key:").append(this.b);
      aqx.b();
    }
    return;
    throw paramContext;
  }
  
  public final byte[] a(Context paramContext, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    a(paramContext);
    try
    {
      paramContext = this.a;
      paramContext = rk.a.a().c().a(paramArrayOfByte, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.getMessage();
      aqx.a();
    }
    return null;
  }
  
  public final byte[] a(Context paramContext, byte[] paramArrayOfByte, boolean paramBoolean)
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
      paramContext = rk.a.a().c().b(paramArrayOfByte, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.getMessage();
      aqx.a();
    }
    return null;
  }
  
  static final class a
  {
    private static final rj a = new rj((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rj
 * JD-Core Version:    0.7.0.1
 */