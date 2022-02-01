public class aeyo
{
  private long iS;
  private long iT;
  
  public aeyo(long paramLong)
  {
    this.iT = paramLong;
    this.iS = this.iT;
  }
  
  public aeyo a()
  {
    return new aeyo(this.iT);
  }
  
  public void setFactor(float paramFloat)
  {
    this.iT = (((float)this.iT * paramFloat));
  }
  
  public long value()
  {
    return this.iT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyo
 * JD-Core Version:    0.7.0.1
 */