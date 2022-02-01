package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class afb
  implements aew
{
  public aez a;
  
  /* Error */
  private static int a(Context arg0, AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore_3
    //   8: new 20	android/content/Intent
    //   11: dup
    //   12: getstatic 26	com/tencent/token/agg:k	[I
    //   15: invokestatic 29	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   18: invokespecial 32	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: new 34	android/content/ComponentName
    //   28: dup
    //   29: getstatic 37	com/tencent/token/agg:g	[I
    //   32: invokestatic 29	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   35: getstatic 40	com/tencent/token/agg:h	[I
    //   38: invokestatic 29	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   41: invokespecial 43	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokevirtual 47	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   47: pop
    //   48: aload_0
    //   49: aload 4
    //   51: new 8	com/tencent/token/afb$a
    //   54: dup
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: invokespecial 50	com/tencent/token/afb$a:<init>	(Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   61: iconst_1
    //   62: invokevirtual 56	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   65: ifne +6 -> 71
    //   68: bipush 156
    //   70: ireturn
    //   71: aload_1
    //   72: invokevirtual 62	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   75: ifnonnull +22 -> 97
    //   78: aload_3
    //   79: monitorenter
    //   80: aload_3
    //   81: ldc2_w 63
    //   84: invokevirtual 68	java/lang/Object:wait	(J)V
    //   87: aload_3
    //   88: monitorexit
    //   89: goto +8 -> 97
    //   92: astore_0
    //   93: aload_3
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    //   97: aload_1
    //   98: invokevirtual 62	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   101: ifnonnull +6 -> 107
    //   104: bipush 151
    //   106: ireturn
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: goto -23 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	1	paramAtomicReference	AtomicReference<IBinder>
    //   0	113	2	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   7	87	3	localObject	Object
    //   21	29	4	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   87	89	92	finally
    //   93	95	92	finally
    //   80	87	109	finally
  }
  
  /* Error */
  private int a(Context arg1, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 58	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 80	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: new 10	com/tencent/token/afb$b
    //   25: dup
    //   26: aload_0
    //   27: aload_2
    //   28: aload 6
    //   30: aload 4
    //   32: aload_1
    //   33: aload_3
    //   34: aload 5
    //   36: invokespecial 83	com/tencent/token/afb$b:<init>	(Lcom/tencent/token/afb;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   39: invokevirtual 88	java/lang/Thread:start	()V
    //   42: aload 5
    //   44: monitorenter
    //   45: aload 5
    //   47: ldc2_w 63
    //   50: invokevirtual 68	java/lang/Object:wait	(J)V
    //   53: aload 5
    //   55: monitorexit
    //   56: aload 6
    //   58: invokevirtual 62	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   61: checkcast 73	java/lang/Integer
    //   64: invokevirtual 92	java/lang/Integer:intValue	()I
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
    //   0	78	0	this	afb
    //   0	78	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	78	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   0	78	4	paramAtomicReference2	AtomicReference<String>
    //   7	63	5	localObject	Object
    //   20	37	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   53	56	68	finally
    //   69	72	68	finally
    //   45	53	74	finally
  }
  
  /* Error */
  private aez c(Context paramContext)
  {
    // Byte code:
    //   0: new 58	java/util/concurrent/atomic/AtomicReference
    //   3: dup
    //   4: invokespecial 96	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 98
    //   13: invokevirtual 101	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   16: new 58	java/util/concurrent/atomic/AtomicReference
    //   19: dup
    //   20: invokespecial 96	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   23: astore 5
    //   25: new 58	java/util/concurrent/atomic/AtomicReference
    //   28: dup
    //   29: invokespecial 96	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   32: astore 6
    //   34: aload_1
    //   35: aload 5
    //   37: aload 6
    //   39: invokestatic 103	com/tencent/token/afb:a	(Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;)I
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: ifne +20 -> 66
    //   49: aload_0
    //   50: aload_1
    //   51: aload 5
    //   53: aload 6
    //   55: aload 4
    //   57: invokespecial 105	com/tencent/token/afb:a	(Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;)I
    //   60: istore_2
    //   61: goto +5 -> 66
    //   64: iconst_m1
    //   65: istore_2
    //   66: new 107	com/tencent/token/aez
    //   69: dup
    //   70: aload 4
    //   72: invokevirtual 62	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   75: checkcast 109	java/lang/String
    //   78: iload_2
    //   79: invokespecial 112	com/tencent/token/aez:<init>	(Ljava/lang/String;I)V
    //   82: areturn
    //   83: astore_1
    //   84: goto -20 -> 64
    //   87: astore_1
    //   88: iload_3
    //   89: istore_2
    //   90: goto -24 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	afb
    //   0	93	1	paramContext	Context
    //   44	46	2	i	int
    //   42	47	3	j	int
    //   7	64	4	localAtomicReference1	AtomicReference
    //   23	29	5	localAtomicReference2	AtomicReference
    //   32	22	6	localAtomicReference3	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   16	43	83	finally
    //   49	61	87	finally
  }
  
  public final aez a(Context paramContext)
  {
    aez localaez = this.a;
    if ((localaez == null) || (localaez.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public final void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  public final class a
    implements ServiceConnection
  {
    public a(AtomicReference paramAtomicReference, Object paramObject) {}
    
    /* Error */
    public final void onServiceConnected(ComponentName paramComponentName, IBinder arg2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/tencent/token/afb$a:a	Ljava/util/concurrent/atomic/AtomicReference;
      //   4: aload_2
      //   5: invokevirtual 35	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   8: aload_0
      //   9: getfield 21	com/tencent/token/afb$a:b	Ljava/util/concurrent/atomic/AtomicReference;
      //   12: aload_0
      //   13: invokevirtual 35	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 23	com/tencent/token/afb$a:c	Ljava/lang/Object;
      //   20: astore_1
      //   21: aload_1
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 23	com/tencent/token/afb$a:c	Ljava/lang/Object;
      //   27: invokevirtual 38	java/lang/Object:notifyAll	()V
      //   30: aload_1
      //   31: monitorexit
      //   32: return
      //   33: astore_2
      //   34: aload_1
      //   35: monitorexit
      //   36: aload_2
      //   37: athrow
      //   38: astore_2
      //   39: goto -9 -> 30
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	42	0	this	a
      //   0	42	1	paramComponentName	ComponentName
      // Exception table:
      //   from	to	target	type
      //   30	32	33	finally
      //   34	36	33	finally
      //   23	30	38	finally
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  public final class b
    extends Thread
  {
    public b(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 42
      //   2: astore_1
      //   3: aload_0
      //   4: getfield 23	com/tencent/token/afb$b:g	Lcom/tencent/token/afb;
      //   7: aload_0
      //   8: getfield 25	com/tencent/token/afb$b:a	Ljava/util/concurrent/atomic/AtomicReference;
      //   11: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   14: checkcast 50	android/os/IBinder
      //   17: invokevirtual 53	com/tencent/token/afb:a	(Landroid/os/IBinder;)Ljava/lang/String;
      //   20: astore_2
      //   21: aload_2
      //   22: astore_1
      //   23: goto +15 -> 38
      //   26: aload_0
      //   27: getfield 27	com/tencent/token/afb$b:b	Ljava/util/concurrent/atomic/AtomicReference;
      //   30: bipush 154
      //   32: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   35: invokevirtual 63	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   38: aload_0
      //   39: getfield 29	com/tencent/token/afb$b:c	Ljava/util/concurrent/atomic/AtomicReference;
      //   42: aload_1
      //   43: invokevirtual 63	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   46: aload_0
      //   47: getfield 31	com/tencent/token/afb$b:d	Landroid/content/Context;
      //   50: aload_0
      //   51: getfield 33	com/tencent/token/afb$b:e	Ljava/util/concurrent/atomic/AtomicReference;
      //   54: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   57: checkcast 65	android/content/ServiceConnection
      //   60: invokevirtual 71	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   63: goto +15 -> 78
      //   66: aload_0
      //   67: getfield 27	com/tencent/token/afb$b:b	Ljava/util/concurrent/atomic/AtomicReference;
      //   70: bipush 153
      //   72: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   75: invokevirtual 63	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   78: aload_0
      //   79: getfield 35	com/tencent/token/afb$b:f	Ljava/lang/Object;
      //   82: astore_1
      //   83: aload_1
      //   84: monitorenter
      //   85: aload_0
      //   86: getfield 35	com/tencent/token/afb$b:f	Ljava/lang/Object;
      //   89: invokevirtual 76	java/lang/Object:notifyAll	()V
      //   92: aload_1
      //   93: monitorexit
      //   94: return
      //   95: astore_2
      //   96: aload_1
      //   97: monitorexit
      //   98: aload_2
      //   99: athrow
      //   100: astore_2
      //   101: goto -75 -> 26
      //   104: astore_1
      //   105: goto -39 -> 66
      //   108: astore_2
      //   109: goto -17 -> 92
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	b
      //   2	95	1	localObject1	Object
      //   104	1	1	localObject2	Object
      //   20	2	2	str	String
      //   100	1	2	localObject4	Object
      //   108	1	2	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   92	94	95	finally
      //   96	98	95	finally
      //   3	21	100	finally
      //   46	63	104	finally
      //   85	92	108	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afb
 * JD-Core Version:    0.7.0.1
 */