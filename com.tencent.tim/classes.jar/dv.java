public class dv
{
  private boolean bA;
  private boolean bz;
  
  public dv(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bz = paramBoolean1;
    this.bA = paramBoolean2;
  }
  
  public void cl()
  {
    try
    {
      if (!this.bz) {
        this.bz = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean f(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 14	dv:bz	Z
    //   8: ifeq +28 -> 36
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 16	dv:bA	Z
    //   17: ifeq +15 -> 32
    //   20: aload_0
    //   21: getfield 14	dv:bz	Z
    //   24: ifeq +8 -> 32
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 14	dv:bz	Z
    //   32: aload_0
    //   33: monitorexit
    //   34: iconst_1
    //   35: ireturn
    //   36: lconst_1
    //   37: invokestatic 34	java/lang/Thread:sleep	(J)V
    //   40: lload_1
    //   41: ldc2_w 35
    //   44: lcmp
    //   45: ifeq -41 -> 4
    //   48: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   51: lload_3
    //   52: lsub
    //   53: lload_1
    //   54: lcmp
    //   55: iflt -51 -> 4
    //   58: iconst_0
    //   59: ireturn
    //   60: astore 5
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: athrow
    //   67: astore 5
    //   69: goto -29 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	dv
    //   0	72	1	paramLong	long
    //   3	49	3	l	long
    //   60	5	5	localObject	Object
    //   67	1	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   13	32	60	finally
    //   32	34	60	finally
    //   62	64	60	finally
    //   36	40	67	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.7.0.1
 */