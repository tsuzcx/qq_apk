import android.opengl.GLES20;
import java.util.concurrent.ConcurrentLinkedQueue;

public class alzg
{
  private static final ConcurrentLinkedQueue<alzg> G = new ConcurrentLinkedQueue();
  private long aig;
  private long aih;
  private int dAQ;
  public float[] dq;
  private int textureId;
  
  private alzg()
    throws Throwable
  {
    int i = alzr.o(1)[0];
    if (i == 0)
    {
      alzr.checkGlError("glGenTexture");
      throw new Exception("Unable to generate new texture " + Integer.toHexString(GLES20.glGetError()));
    }
    this.textureId = i;
  }
  
  public static alzg a()
  {
    synchronized (G)
    {
      alzg localalzg1 = (alzg)G.poll();
      ??? = localalzg1;
      if (localalzg1 != null) {}
    }
    return localalzg2;
  }
  
  public static void releaseAll()
  {
    try
    {
      ram.i("FlowEdit_DecodedFrame", "releaseAll");
      synchronized (G)
      {
        if (!G.isEmpty()) {
          ((alzg)G.poll()).release();
        }
      }
    }
    finally {}
  }
  
  public int Iv()
  {
    return this.dAQ;
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 108	java/lang/Object:finalize	()V
    //   4: aload_0
    //   5: getfield 71	alzg:textureId	I
    //   8: ifeq +10 -> 18
    //   11: ldc 81
    //   13: ldc 110
    //   15: invokestatic 113	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 71	alzg:textureId	I
    //   24: ifeq -6 -> 18
    //   27: ldc 81
    //   29: ldc 110
    //   31: invokestatic 113	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 71	alzg:textureId	I
    //   40: ifeq +10 -> 50
    //   43: ldc 81
    //   45: ldc 110
    //   47: invokestatic 113	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	alzg
    //   19	1	1	localThrowable	Throwable
    //   35	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	19	java/lang/Throwable
    //   0	4	35	finally
  }
  
  public long gH()
  {
    return this.aig;
  }
  
  public long gI()
  {
    return this.aih;
  }
  
  public int getTextureId()
  {
    return this.textureId;
  }
  
  public void k(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.textureId == 0) {
      throw new IllegalStateException("this is an invalid frame");
    }
    this.dAQ = paramInt;
    this.aig = paramLong1;
    this.aih = paramLong2;
  }
  
  public void recycle()
  {
    if (this.textureId == 0) {
      throw new IllegalStateException("this is an invalid frame, don't recycle please");
    }
    this.aig = 0L;
    this.dAQ = 0;
    synchronized (G)
    {
      G.offer(this);
      return;
    }
  }
  
  public void release()
  {
    if (this.textureId != 0)
    {
      alzr.deleteTexture(this.textureId);
      this.textureId = 0;
      return;
    }
    ram.w("FlowEdit_DecodedFrame", "release duplicate %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
  }
  
  public String toString()
  {
    return "DecodedFrame{textureId=" + this.textureId + ", timeStampUs=" + this.aig + ", cycleCount=" + this.dAQ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzg
 * JD-Core Version:    0.7.0.1
 */