package btmsdkobf;

public class ce
{
  private int hA = 0;
  private long hB = 0L;
  private int hC = 0;
  private long hD = 0L;
  private long hE = 0L;
  private ec hz;
  
  public ce(String paramString, long paramLong, int paramInt)
  {
    this.hz = new ec("freq_ctrl_" + paramString);
    this.hA = paramInt;
    this.hB = paramLong;
    this.hC = this.hz.getInt("times_now", this.hC);
    this.hD = this.hz.getLong("time_span_start", this.hD);
    this.hE = this.hz.getLong("time_span_end", this.hE);
    this.hz.putInt("times", paramInt);
    this.hz.putLong("time_span", paramLong);
  }
  
  private void d(long paramLong)
  {
    this.hD = paramLong;
    this.hE = (this.hB + paramLong);
    this.hz.putLong("time_span_start", this.hD);
    this.hz.putLong("time_span_end", this.hE);
  }
  
  private void s(int paramInt)
  {
    this.hC = paramInt;
    this.hz.putInt("times_now", this.hC);
  }
  
  public boolean aW()
  {
    if (this.hD == 0L) {}
    long l;
    do
    {
      return true;
      l = System.currentTimeMillis();
    } while ((this.hC < this.hA) || (l >= this.hE));
    return false;
  }
  
  public void aX()
  {
    long l = System.currentTimeMillis();
    if (this.hD == 0L)
    {
      d(l);
      s(0);
    }
    for (;;)
    {
      s(this.hC + 1);
      return;
      if (l >= this.hE)
      {
        d(l);
        s(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ce
 * JD-Core Version:    0.7.0.1
 */