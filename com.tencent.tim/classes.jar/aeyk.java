import android.os.SystemClock;

public class aeyk
{
  private long Xb;
  private long iV;
  private long mBaseTime;
  
  public long be()
  {
    return this.iV;
  }
  
  public void cYd()
  {
    this.mBaseTime = SystemClock.uptimeMillis();
  }
  
  public long en()
  {
    this.iV = (SystemClock.uptimeMillis() - this.mBaseTime);
    this.Xb += this.iV;
    cYd();
    return this.iV;
  }
  
  public long getTime()
  {
    return this.Xb;
  }
  
  public void resetTime()
  {
    this.Xb = 0L;
    this.iV = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyk
 * JD-Core Version:    0.7.0.1
 */