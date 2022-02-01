public class awls
{
  public boolean dqT;
  public int eBC;
  public int eBD;
  public int eBE;
  public long mEndTime;
  public long mStartTime;
  
  public awls(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    this.dqT = paramBoolean;
    this.eBD = paramInt1;
    this.eBE = paramInt2;
    this.eBC = paramInt3;
  }
  
  public static class a
  {
    public boolean dqT;
    public int eBC;
    public int eBD;
    public int eBE;
    public long mEndTime;
    public long mStartTime;
    
    public a a(int paramInt)
    {
      this.eBD = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.mEndTime = paramLong;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dqT = paramBoolean;
      return this;
    }
    
    public awls a()
    {
      return new awls(this.mStartTime, this.mEndTime, this.dqT, this.eBD, this.eBE, this.eBC);
    }
    
    public a b(int paramInt)
    {
      this.eBE = paramInt;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.eBC = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awls
 * JD-Core Version:    0.7.0.1
 */