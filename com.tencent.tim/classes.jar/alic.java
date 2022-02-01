import android.os.SystemClock;

public class alic
{
  public long Im;
  private int[] mD = { 0, 500, 700, 1000, 1500, 2100, 2800, 3500, 4200, 4800, 5000 };
  
  public boolean VY()
  {
    if (this.Im == 0L) {
      this.Im = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.Im >= 75L)
    {
      this.Im = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public int iI(int paramInt)
  {
    int i = 0;
    while (i < this.mD.length)
    {
      if (paramInt < this.mD[i]) {
        return i;
      }
      i += 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alic
 * JD-Core Version:    0.7.0.1
 */