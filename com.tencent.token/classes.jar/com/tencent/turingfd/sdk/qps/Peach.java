package com.tencent.turingfd.sdk.qps;

import android.content.Context;
import com.tencent.token.aef;
import com.tencent.token.aek;

public class Peach
{
  public static Peach a = new Peach();
  
  public boolean a(Context paramContext, aef paramaef)
  {
    boolean bool2 = b(paramContext, paramaef);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    long l1 = aef.b(paramContext, "112");
    long l2 = System.currentTimeMillis();
    aek.b.getClass();
    long l3 = aek.a(paramContext, "1", 0L, 3600000L);
    if (Math.abs(l1 - l2) >= l3) {
      bool1 = true;
    }
    return bool1;
  }
  
  /* Error */
  public final boolean b(Context paramContext, aef paramaef)
  {
    // Byte code:
    //   0: getstatic 57	com/tencent/token/aef:a	Ljava/lang/String;
    //   3: astore 9
    //   5: aload_1
    //   6: ldc 59
    //   8: invokestatic 62	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   11: invokestatic 68	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   14: invokevirtual 71	java/lang/Long:longValue	()J
    //   17: lstore 5
    //   19: goto +6 -> 25
    //   22: lconst_0
    //   23: lstore 5
    //   25: aload_2
    //   26: invokevirtual 41	java/lang/Object:getClass	()Ljava/lang/Class;
    //   29: pop
    //   30: aload_1
    //   31: ldc 73
    //   33: invokestatic 62	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 68	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   39: invokevirtual 71	java/lang/Long:longValue	()J
    //   42: lstore_3
    //   43: goto +5 -> 48
    //   46: lconst_0
    //   47: lstore_3
    //   48: lload_3
    //   49: lstore 7
    //   51: lload_3
    //   52: lconst_0
    //   53: lcmp
    //   54: ifne +8 -> 62
    //   57: ldc2_w 74
    //   60: lstore 7
    //   62: lload 5
    //   64: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   67: lsub
    //   68: invokestatic 54	java/lang/Math:abs	(J)J
    //   71: lload 7
    //   73: lcmp
    //   74: iflt +5 -> 79
    //   77: iconst_1
    //   78: ireturn
    //   79: iconst_0
    //   80: ireturn
    //   81: astore 9
    //   83: goto -61 -> 22
    //   86: astore_1
    //   87: goto -41 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	Peach
    //   0	90	1	paramContext	Context
    //   0	90	2	paramaef	aef
    //   42	10	3	l1	long
    //   17	46	5	l2	long
    //   49	23	7	l3	long
    //   3	1	9	str	java.lang.String
    //   81	1	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	19	81	finally
    //   30	43	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Peach
 * JD-Core Version:    0.7.0.1
 */