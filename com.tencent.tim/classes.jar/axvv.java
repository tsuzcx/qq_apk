public class axvv
{
  public int busType;
  int eIp;
  volatile boolean enabled = false;
  long endTime;
  int frameCount;
  long startTime;
  public long[] t = new long[4];
  int[] tX;
  int[] tY;
  
  public axvv() {}
  
  public axvv(int paramInt)
  {
    this.t = new long[paramInt];
  }
  
  public void ay(int paramInt, long paramLong)
  {
    if ((this.enabled) && (this.t[paramInt] == 0L)) {
      this.t[paramInt] = paramLong;
    }
  }
  
  public void e(Integer... paramVarArgs)
  {
    if ((paramVarArgs == null) || (this.frameCount >= 400)) {
      return;
    }
    if (paramVarArgs.length == 1)
    {
      if (this.tX == null) {
        this.tX = new int[400];
      }
      this.tX[this.frameCount] = paramVarArgs[0].intValue();
    }
    for (;;)
    {
      this.frameCount += 1;
      return;
      if (paramVarArgs.length == 2)
      {
        if (this.tX == null) {
          this.tX = new int[400];
        }
        if (this.tY == null) {
          this.tY = new int[400];
        }
        this.tX[this.frameCount] = paramVarArgs[0].intValue();
        this.tY[this.frameCount] = paramVarArgs[1].intValue();
      }
    }
  }
  
  public void init()
  {
    int i = 0;
    this.frameCount = 0;
    this.eIp = 0;
    while (i < this.t.length)
    {
      this.t[i] = 0L;
      i += 1;
    }
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public boolean ov(int paramInt)
  {
    return System.currentTimeMillis() - this.startTime >= paramInt;
  }
  
  public void startMonitor()
  {
    if (this.enabled) {
      return;
    }
    this.enabled = true;
    this.startTime = System.currentTimeMillis();
    init();
  }
  
  public void stopMonitor()
  {
    this.enabled = false;
    this.endTime = System.currentTimeMillis();
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvv
 * JD-Core Version:    0.7.0.1
 */