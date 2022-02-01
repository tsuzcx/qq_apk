public class awlr
{
  public int EP;
  public String cRj = "";
  public String cRk = "0";
  public int eBA;
  public int eBB;
  public int mType;
  public long mUin;
  
  public awlr(int paramInt1, long paramLong, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.EP = paramInt1;
    this.mUin = paramLong;
    this.mType = paramInt2;
    this.cRj = paramString1;
    this.eBA = paramInt3;
    this.cRk = paramString2;
    this.eBB = paramInt4;
  }
  
  public String toString()
  {
    return " mBusinessType =" + this.EP + " mType = " + this.mType + " mOrederId = " + this.cRk;
  }
  
  public static class a
  {
    private int EP;
    private String cRj;
    private String cRk;
    private int eBA;
    private int eBB;
    private int mType;
    private long mUin;
    
    public a a(int paramInt)
    {
      this.EP = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.mUin = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.cRj = paramString;
      return this;
    }
    
    public awlr a()
    {
      return new awlr(this.EP, this.mUin, this.mType, this.cRj, this.eBA, this.cRk, this.eBB);
    }
    
    public a b(int paramInt)
    {
      this.mType = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.cRk = paramString;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.eBA = paramInt;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.eBB = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlr
 * JD-Core Version:    0.7.0.1
 */