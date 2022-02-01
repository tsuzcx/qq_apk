package com.tencent.turingfd.sdk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bq
  implements bk
{
  public bo a;
  
  /* Error */
  public final int a(Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: checkcast 22	com/tencent/turingfd/sdk/base/bs
    //   13: astore 5
    //   15: new 24	android/content/Intent
    //   18: dup
    //   19: getstatic 30	com/tencent/turingfd/sdk/base/ct:k	[I
    //   22: invokestatic 33	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   25: invokespecial 36	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   28: astore 5
    //   30: aload 5
    //   32: new 38	android/content/ComponentName
    //   35: dup
    //   36: getstatic 41	com/tencent/turingfd/sdk/base/ct:g	[I
    //   39: invokestatic 33	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   42: getstatic 44	com/tencent/turingfd/sdk/base/ct:h	[I
    //   45: invokestatic 33	com/tencent/turingfd/sdk/base/ct:a	([I)Ljava/lang/String;
    //   48: invokespecial 47	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokevirtual 51	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_1
    //   56: aload 5
    //   58: new 8	com/tencent/turingfd/sdk/base/bq$a
    //   61: dup
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: aload 4
    //   67: invokespecial 54	com/tencent/turingfd/sdk/base/bq$a:<init>	(Lcom/tencent/turingfd/sdk/base/bq;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   70: iconst_1
    //   71: invokevirtual 60	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   74: ifne +6 -> 80
    //   77: bipush 156
    //   79: ireturn
    //   80: aload_2
    //   81: invokevirtual 66	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   84: ifnonnull +17 -> 101
    //   87: aload 4
    //   89: monitorenter
    //   90: aload 4
    //   92: ldc2_w 67
    //   95: invokevirtual 72	java/lang/Object:wait	(J)V
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_2
    //   102: invokevirtual 66	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
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
    //   0	123	0	this	bq
    //   0	123	1	paramContext	Context
    //   0	123	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	123	3	paramAtomicReference1	AtomicReference<ServiceConnection>
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
  public final int a(final Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 62	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 84	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: new 10	com/tencent/turingfd/sdk/base/bq$b
    //   25: dup
    //   26: aload_0
    //   27: aload_2
    //   28: aload 6
    //   30: aload 4
    //   32: aload_1
    //   33: aload_3
    //   34: aload 5
    //   36: invokespecial 87	com/tencent/turingfd/sdk/base/bq$b:<init>	(Lcom/tencent/turingfd/sdk/base/bq;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   39: invokevirtual 92	java/lang/Thread:start	()V
    //   42: aload 5
    //   44: monitorenter
    //   45: aload 5
    //   47: ldc2_w 67
    //   50: invokevirtual 72	java/lang/Object:wait	(J)V
    //   53: aload 5
    //   55: monitorexit
    //   56: aload 6
    //   58: invokevirtual 66	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   61: checkcast 77	java/lang/Integer
    //   64: invokevirtual 96	java/lang/Integer:intValue	()I
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
    //   0	78	0	this	bq
    //   0	78	1	paramContext	Context
    //   0	78	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	78	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   0	78	4	paramAtomicReference2	AtomicReference<String>
    //   7	63	5	localObject	Object
    //   20	37	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   45	53	68	finally
    //   53	56	68	finally
    //   69	72	68	finally
    //   45	53	74	java/lang/Throwable
  }
  
  public bo a(Context paramContext)
  {
    bo localbo = this.a;
    if ((localbo == null) || (localbo.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  public final bo c(Context paramContext)
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
      return new bo((String)localAtomicReference1.get(), i);
    }
  }
  
  public class a
    implements ServiceConnection
  {
    public a(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      paramAtomicReference.set(paramIBinder);
      paramAtomicReference1.set(this);
      try
      {
        synchronized (localObject1)
        {
          localObject1.notifyAll();
          label30:
          return;
        }
      }
      catch (Throwable paramIBinder)
      {
        break label30;
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  public class b
    extends Thread
  {
    public b(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 23	com/tencent/turingfd/sdk/base/bq$b:g	Lcom/tencent/turingfd/sdk/base/bq;
      //   4: aload_0
      //   5: getfield 25	com/tencent/turingfd/sdk/base/bq$b:a	Ljava/util/concurrent/atomic/AtomicReference;
      //   8: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   11: checkcast 50	android/os/IBinder
      //   14: invokevirtual 53	com/tencent/turingfd/sdk/base/bq:a	(Landroid/os/IBinder;)Ljava/lang/String;
      //   17: astore_1
      //   18: aload_0
      //   19: getfield 29	com/tencent/turingfd/sdk/base/bq$b:c	Ljava/util/concurrent/atomic/AtomicReference;
      //   22: aload_1
      //   23: invokevirtual 57	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   26: aload_0
      //   27: getfield 31	com/tencent/turingfd/sdk/base/bq$b:d	Landroid/content/Context;
      //   30: aload_0
      //   31: getfield 33	com/tencent/turingfd/sdk/base/bq$b:e	Ljava/util/concurrent/atomic/AtomicReference;
      //   34: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   37: checkcast 59	android/content/ServiceConnection
      //   40: invokevirtual 65	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   43: aload_0
      //   44: getfield 35	com/tencent/turingfd/sdk/base/bq$b:f	Ljava/lang/Object;
      //   47: astore_1
      //   48: aload_1
      //   49: monitorenter
      //   50: aload_0
      //   51: getfield 35	com/tencent/turingfd/sdk/base/bq$b:f	Ljava/lang/Object;
      //   54: invokevirtual 70	java/lang/Object:notifyAll	()V
      //   57: aload_1
      //   58: monitorexit
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: getfield 27	com/tencent/turingfd/sdk/base/bq$b:b	Ljava/util/concurrent/atomic/AtomicReference;
      //   65: bipush 154
      //   67: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   70: invokevirtual 57	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   73: ldc 78
      //   75: astore_1
      //   76: goto -58 -> 18
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 27	com/tencent/turingfd/sdk/base/bq$b:b	Ljava/util/concurrent/atomic/AtomicReference;
      //   84: bipush 153
      //   86: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: invokevirtual 57	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
      //   92: goto -49 -> 43
      //   95: astore_2
      //   96: aload_1
      //   97: monitorexit
      //   98: aload_2
      //   99: athrow
      //   100: astore_2
      //   101: goto -44 -> 57
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	b
      //   60	1	1	localThrowable1	Throwable
      //   75	1	1	str	String
      //   79	18	1	localThrowable2	Throwable
      //   95	4	2	localObject2	Object
      //   100	1	2	localThrowable3	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	18	60	java/lang/Throwable
      //   26	43	79	java/lang/Throwable
      //   50	57	95	finally
      //   57	59	95	finally
      //   96	98	95	finally
      //   50	57	100	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bq
 * JD-Core Version:    0.7.0.1
 */