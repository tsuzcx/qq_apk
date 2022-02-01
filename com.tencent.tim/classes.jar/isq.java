public abstract class isq
  extends isd
{
  public itc[] c;
  protected long mDuration;
  
  public void recycle()
  {
    super.recycle();
    if (this.c != null)
    {
      itc[] arrayOfitc = this.c;
      int j = arrayOfitc.length;
      int i = 0;
      while (i < j)
      {
        itc localitc = arrayOfitc[i];
        if (localitc != null) {
          localitc.recycle();
        }
        i += 1;
      }
      this.c = null;
    }
  }
  
  public void update(long paramLong)
  {
    long l = this.mStartTime;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.mDuration * this.c.length / this.mDuration);
      if ((i >= 0) && (i < this.c.length)) {
        this.b = this.c[i];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isq
 * JD-Core Version:    0.7.0.1
 */