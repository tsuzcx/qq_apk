package btmsdkobf;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

final class ja
  extends Thread
{
  ja(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Context paramContext, AtomicReference paramAtomicReference3, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	btmsdkobf/ja:a	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: invokevirtual 37	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   7: checkcast 39	android/os/IBinder
    //   10: invokestatic 44	btmsdkobf/eu$a:c	(Landroid/os/IBinder;)Lbtmsdkobf/eu;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +34 -> 49
    //   18: aload_0
    //   19: getfield 20	btmsdkobf/ja:c	Landroid/content/Context;
    //   22: invokevirtual 50	android/content/Context:getPackageName	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_1
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 20	btmsdkobf/ja:c	Landroid/content/Context;
    //   32: aload_2
    //   33: ldc 52
    //   35: invokestatic 57	btmsdkobf/et:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: ldc 59
    //   40: invokeinterface 64 4 0
    //   45: invokestatic 70	btmsdkobf/ev:N	(Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload_0
    //   50: getfield 20	btmsdkobf/ja:c	Landroid/content/Context;
    //   53: aload_0
    //   54: getfield 22	btmsdkobf/ja:d	Ljava/util/concurrent/atomic/AtomicReference;
    //   57: invokevirtual 37	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   60: checkcast 72	android/content/ServiceConnection
    //   63: invokevirtual 76	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   66: aload_0
    //   67: getfield 24	btmsdkobf/ja:e	Ljava/lang/Object;
    //   70: astore_1
    //   71: aload_1
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 24	btmsdkobf/ja:e	Ljava/lang/Object;
    //   77: invokevirtual 81	java/lang/Object:notifyAll	()V
    //   80: aload_1
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 18	btmsdkobf/ja:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   88: sipush -401
    //   91: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: invokevirtual 91	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: astore_1
    //   99: goto -85 -> 14
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 18	btmsdkobf/ja:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   107: sipush -402
    //   110: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: invokevirtual 91	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   116: goto -67 -> 49
    //   119: astore_1
    //   120: aload_0
    //   121: getfield 18	btmsdkobf/ja:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   124: sipush -403
    //   127: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: invokevirtual 91	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   133: goto -67 -> 66
    //   136: astore_2
    //   137: aload_1
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: goto -62 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	ja
    //   83	1	1	localThrowable1	java.lang.Throwable
    //   98	1	1	localObject2	Object
    //   102	1	1	localThrowable2	java.lang.Throwable
    //   119	19	1	localThrowable3	java.lang.Throwable
    //   25	8	2	str	java.lang.String
    //   136	4	2	localObject3	Object
    //   141	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	14	83	java/lang/Throwable
    //   18	49	102	java/lang/Throwable
    //   49	66	119	java/lang/Throwable
    //   73	80	136	finally
    //   80	82	136	finally
    //   137	139	136	finally
    //   73	80	141	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ja
 * JD-Core Version:    0.7.0.1
 */