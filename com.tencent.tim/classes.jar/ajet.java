public class ajet
{
  private int bizType;
  private String sig;
  
  private ajet(String paramString, int paramInt)
  {
    this.sig = paramString;
    this.bizType = paramInt;
  }
  
  public int Gi()
  {
    return this.bizType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupPushData--");
    localStringBuilder.append(",sig:").append(this.sig).append(",bizType:").append(this.bizType);
    return localStringBuilder.toString();
  }
  
  public String xn()
  {
    return this.sig;
  }
  
  public static class a
  {
    private int bizType;
    private String sig;
    
    public a a(int paramInt)
    {
      this.bizType = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.sig = paramString;
      return this;
    }
    
    public ajet a()
    {
      return new ajet(this.sig, this.bizType, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajet
 * JD-Core Version:    0.7.0.1
 */