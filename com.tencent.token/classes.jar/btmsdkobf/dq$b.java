package btmsdkobf;

public class dq$b
{
  private int ng;
  private int nh;
  private String ni;
  
  public dq$b() {}
  
  public dq$b(String paramString, int paramInt)
  {
    this.ni = paramString;
    this.nh = paramInt;
  }
  
  public dq$b(String paramString, int paramInt1, int paramInt2)
  {
    this.ng = paramInt2;
    this.ni = paramString;
    this.nh = paramInt1;
  }
  
  protected Object clone()
  {
    return new b(this.ni, this.nh, this.ng);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((!paramObject.ni.equals(this.ni)) || (paramObject.nh != this.nh));
    return true;
  }
  
  public String getIp()
  {
    return this.ni;
  }
  
  public int getPort()
  {
    return this.nh;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    if (this.nh >= 0) {
      return this.ni + ":" + this.nh;
    }
    return this.ni;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dq.b
 * JD-Core Version:    0.7.0.1
 */