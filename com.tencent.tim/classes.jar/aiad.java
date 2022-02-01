import android.os.SystemClock;

public class aiad
{
  aiad.a a;
  int cOq = 100;
  int mDistance;
  long mStartTime;
  int mThreshold;
  boolean mWorking = false;
  
  public aiad(int paramInt, aiad.a parama)
  {
    this.mThreshold = paramInt;
    this.a = parama;
  }
  
  public void KQ(boolean paramBoolean)
  {
    this.mWorking = paramBoolean;
  }
  
  public void PK(int paramInt)
  {
    this.cOq = paramInt;
  }
  
  public void onMove(int paramInt)
  {
    if (!this.mWorking) {}
    do
    {
      return;
      this.mDistance += paramInt;
      if (this.mStartTime == 0L)
      {
        this.mStartTime = SystemClock.uptimeMillis();
        return;
      }
    } while (SystemClock.uptimeMillis() - this.mStartTime <= this.cOq);
    aiad.a locala = this.a;
    if (this.mDistance > this.mThreshold) {}
    for (boolean bool = true;; bool = false)
    {
      locala.Ib(bool);
      this.mStartTime = 0L;
      this.mDistance = 0;
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ib(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiad
 * JD-Core Version:    0.7.0.1
 */