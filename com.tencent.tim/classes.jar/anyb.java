public abstract class anyb
{
  private anyb.a a;
  public int duration;
  public boolean isEnd;
  public boolean isRepeat;
  protected long mPauseTime;
  public int opacity = 255;
  public int rotate;
  public float scale = 1.0F;
  public int speedType = 0;
  protected long startTime;
  public int type;
  public float x;
  public float y;
  
  public anyb(int paramInt1, int paramInt2, int paramInt3)
  {
    this.duration = paramInt1;
    this.type = paramInt2;
    this.speedType = paramInt3;
  }
  
  public void a(anyb.a parama)
  {
    this.a = parama;
  }
  
  public void pause()
  {
    this.mPauseTime = System.currentTimeMillis();
  }
  
  public void resume()
  {
    this.startTime += System.currentTimeMillis() - this.mPauseTime;
  }
  
  public boolean run()
  {
    if (this.isEnd) {
      return false;
    }
    int i = (int)(System.currentTimeMillis() - this.startTime);
    float f = i / this.duration;
    if (this.speedType == 1) {
      f = i * i / (this.duration * this.duration);
    }
    for (;;)
    {
      s(i, f);
      if (i >= this.duration) {
        stop();
      }
      return true;
      if (this.speedType == 2)
      {
        f = i / this.duration;
        f *= (2.0F - f);
      }
    }
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    if ((paramInt >= this.duration) && (this.a != null)) {
      this.a.aVH();
    }
  }
  
  public void start()
  {
    this.isEnd = false;
    this.startTime = System.currentTimeMillis();
  }
  
  public void stop()
  {
    this.isEnd = true;
  }
  
  public static abstract interface a
  {
    public abstract void aVH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyb
 * JD-Core Version:    0.7.0.1
 */