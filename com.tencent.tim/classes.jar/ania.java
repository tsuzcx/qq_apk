import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.atomic.AtomicReference;

public class ania
{
  public AtomicReference<SVHwEncoder> c = new AtomicReference(null);
  private int dGm;
  private long mCurrentTime;
  private long mStartTime;
  
  public void aJ(long paramLong1, long paramLong2)
  {
    this.mCurrentTime = paramLong1;
    if (((this.mCurrentTime - this.mStartTime) / anhz.dGl == this.dGm + 1) && (this.c.get() != null))
    {
      float f = (float)(paramLong2 * 1000.0D / paramLong1);
      ((SVHwEncoder)this.c.get()).f(f, -1);
      this.dGm += 1;
    }
  }
  
  public void lo(long paramLong)
  {
    this.mStartTime = paramLong;
    this.mCurrentTime = paramLong;
    this.dGm = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ania
 * JD-Core Version:    0.7.0.1
 */