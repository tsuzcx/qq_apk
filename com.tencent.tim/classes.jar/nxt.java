import com.tencent.qphone.base.remote.ToServiceMsg;

public class nxt
{
  private static nxt a;
  private Runnable dd;
  private ToServiceMsg h;
  
  public static nxt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new nxt();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public void i(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 30	nxs:k	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 32
    //   11: iconst_1
    //   12: ldc 34
    //   14: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: invokestatic 44	nxs:dm	()J
    //   23: lstore_2
    //   24: aload_0
    //   25: getfield 46	nxt:dd	Ljava/lang/Runnable;
    //   28: ifnonnull +16 -> 44
    //   31: aload_0
    //   32: new 48	com/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetManager$1
    //   35: dup
    //   36: aload_0
    //   37: lload_2
    //   38: invokespecial 51	com/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetManager$1:<init>	(Lnxt;J)V
    //   41: putfield 46	nxt:dd	Ljava/lang/Runnable;
    //   44: invokestatic 57	kxm:p	()Landroid/os/Handler;
    //   47: aload_0
    //   48: getfield 46	nxt:dd	Ljava/lang/Runnable;
    //   51: invokevirtual 63	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   54: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +11 -> 68
    //   60: ldc 32
    //   62: iconst_2
    //   63: ldc 69
    //   65: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: aload_1
    //   70: putfield 18	nxt:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   73: invokestatic 57	kxm:p	()Landroid/os/Handler;
    //   76: aload_0
    //   77: getfield 46	nxt:dd	Ljava/lang/Runnable;
    //   80: lload_2
    //   81: invokevirtual 73	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   84: pop
    //   85: ldc 32
    //   87: iconst_1
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc 75
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: lload_2
    //   100: invokestatic 81	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   107: goto -90 -> 17
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	nxt
    //   0	115	1	paramToServiceMsg	ToServiceMsg
    //   23	77	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	17	110	finally
    //   20	44	110	finally
    //   44	68	110	finally
    //   68	107	110	finally
  }
  
  /* Error */
  public void j(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	nxt:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   6: aload_1
    //   7: if_acmpne +29 -> 36
    //   10: invokestatic 57	kxm:p	()Landroid/os/Handler;
    //   13: aload_0
    //   14: getfield 46	nxt:dd	Ljava/lang/Runnable;
    //   17: invokevirtual 63	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 18	nxt:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   25: ldc 32
    //   27: iconst_1
    //   28: ldc 87
    //   30: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: ldc 32
    //   38: iconst_1
    //   39: ldc 89
    //   41: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: goto -11 -> 33
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	nxt
    //   0	52	1	paramToServiceMsg	ToServiceMsg
    // Exception table:
    //   from	to	target	type
    //   2	33	47	finally
    //   36	44	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxt
 * JD-Core Version:    0.7.0.1
 */