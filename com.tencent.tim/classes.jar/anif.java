public class anif
{
  private long alF;
  private long alG;
  private long mp;
  private float zJ;
  private float zK;
  private float zL;
  
  public long T(long paramLong)
  {
    if (this.alF == 0L)
    {
      this.alF = (paramLong * 1000L);
      this.alG = (paramLong * 1000L);
      this.mp = paramLong;
    }
    return paramLong * 1000L;
  }
  
  public long a(float paramFloat)
  {
    this.alG += (1000.0F * paramFloat);
    return this.alG;
  }
  
  public void bd(float paramFloat)
  {
    this.zJ = ((float)(1000.0D / paramFloat));
    this.zK = (this.zJ + 0.3F);
    this.zL = (this.zJ - 0.7F);
  }
  
  public void dQf()
  {
    this.alF = 0L;
    this.alG = 0L;
    this.mp = 0L;
    this.zJ = 0.0F;
    this.zK = 0.0F;
    this.zL = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anif
 * JD-Core Version:    0.7.0.1
 */