package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class cj
  implements bx
{
  public cc a;
  
  /* Error */
  public final int a(Context paramContext, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 12	java/lang/Object:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: checkcast 18	com/tencent/turingfd/sdk/base/cl
    //   13: astore 5
    //   15: new 20	android/content/Intent
    //   18: dup
    //   19: getstatic 26	com/tencent/turingfd/sdk/base/db:j	[I
    //   22: invokestatic 29	com/tencent/turingfd/sdk/base/db:a	([I)Ljava/lang/String;
    //   25: invokespecial 32	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   28: astore 5
    //   30: aload 5
    //   32: new 34	android/content/ComponentName
    //   35: dup
    //   36: getstatic 37	com/tencent/turingfd/sdk/base/db:g	[I
    //   39: invokestatic 29	com/tencent/turingfd/sdk/base/db:a	([I)Ljava/lang/String;
    //   42: getstatic 40	com/tencent/turingfd/sdk/base/db:h	[I
    //   45: invokestatic 29	com/tencent/turingfd/sdk/base/db:a	([I)Ljava/lang/String;
    //   48: invokespecial 43	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokevirtual 47	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_1
    //   56: aload 5
    //   58: new 49	com/tencent/turingfd/sdk/base/cd
    //   61: dup
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: aload 4
    //   67: invokespecial 52	com/tencent/turingfd/sdk/base/cd:<init>	(Lcom/tencent/turingfd/sdk/base/cj;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   70: iconst_1
    //   71: invokevirtual 58	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   74: ifne +6 -> 80
    //   77: bipush 156
    //   79: ireturn
    //   80: aload_2
    //   81: invokevirtual 64	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   84: ifnonnull +17 -> 101
    //   87: aload 4
    //   89: monitorenter
    //   90: aload 4
    //   92: ldc2_w 65
    //   95: invokevirtual 70	java/lang/Object:wait	(J)V
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_2
    //   102: invokevirtual 64	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   105: ifnonnull +12 -> 117
    //   108: bipush 151
    //   110: ireturn
    //   111: astore_1
    //   112: aload 4
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_1
    //   120: goto -22 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	cj
    //   0	123	1	paramContext	Context
    //   0	123	2	paramAtomicReference1	AtomicReference
    //   0	123	3	paramAtomicReference2	AtomicReference
    //   7	106	4	localObject1	Object
    //   13	44	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   90	98	111	finally
    //   98	101	111	finally
    //   112	115	111	finally
    //   90	98	119	java/lang/Throwable
  }
  
  /* Error */
  public final int a(Context paramContext, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 12	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 60	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 80	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: new 82	com/tencent/turingfd/sdk/base/ch
    //   25: dup
    //   26: aload_0
    //   27: aload_2
    //   28: aload 6
    //   30: aload 4
    //   32: aload_1
    //   33: aload_3
    //   34: aload 5
    //   36: invokespecial 85	com/tencent/turingfd/sdk/base/ch:<init>	(Lcom/tencent/turingfd/sdk/base/cj;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   39: invokevirtual 90	java/lang/Thread:start	()V
    //   42: aload 5
    //   44: monitorenter
    //   45: aload 5
    //   47: ldc2_w 65
    //   50: invokevirtual 70	java/lang/Object:wait	(J)V
    //   53: aload 5
    //   55: monitorexit
    //   56: aload 6
    //   58: invokevirtual 64	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   61: checkcast 73	java/lang/Integer
    //   64: invokevirtual 94	java/lang/Integer:intValue	()I
    //   67: ireturn
    //   68: astore_1
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: goto -22 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	cj
    //   0	78	1	paramContext	Context
    //   0	78	2	paramAtomicReference1	AtomicReference
    //   0	78	3	paramAtomicReference2	AtomicReference
    //   0	78	4	paramAtomicReference3	AtomicReference
    //   7	63	5	localObject	Object
    //   20	37	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   45	53	68	finally
    //   53	56	68	finally
    //   69	72	68	finally
    //   45	53	74	java/lang/Throwable
  }
  
  public cc a(Context paramContext)
  {
    cc localcc = this.a;
    if ((localcc == null) || (localcc.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  public final cc c(Context paramContext)
  {
    AtomicReference localAtomicReference1 = new AtomicReference();
    localAtomicReference1.set("");
    for (;;)
    {
      try
      {
        localAtomicReference2 = new AtomicReference();
        localAtomicReference3 = new AtomicReference();
        i = a(paramContext, localAtomicReference2, localAtomicReference3);
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        AtomicReference localAtomicReference2;
        AtomicReference localAtomicReference3;
        int j;
        int i = -1;
        continue;
      }
      try
      {
        j = a(paramContext, localAtomicReference2, localAtomicReference3, localAtomicReference1);
        i = j;
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      return new cc((String)localAtomicReference1.get(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cj
 * JD-Core Version:    0.7.0.1
 */