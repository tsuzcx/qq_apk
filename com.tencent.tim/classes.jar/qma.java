public class qma
{
  private double mSpeed = 1.0D;
  private long mStartTime;
  
  public qma()
  {
    start();
  }
  
  private long dS()
  {
    return (System.nanoTime() / 1000L * this.mSpeed);
  }
  
  public long I(long paramLong)
  {
    return paramLong - getCurrentTime();
  }
  
  public void fl(long paramLong)
  {
    this.mStartTime = (dS() - paramLong);
  }
  
  public long getCurrentTime()
  {
    return dS() - this.mStartTime;
  }
  
  public double getSpeed()
  {
    return this.mSpeed;
  }
  
  public void start()
  {
    fl(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qma
 * JD-Core Version:    0.7.0.1
 */