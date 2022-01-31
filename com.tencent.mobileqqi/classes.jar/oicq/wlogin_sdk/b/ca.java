package oicq.wlogin_sdk.b;

public class ca
  extends a
{
  byte[] h = new byte[0];
  
  public ca()
  {
    this.g = 402;
  }
  
  public Boolean e()
  {
    this.h = new byte[this.e];
    System.arraycopy(this.f, this.d, this.h, 0, this.e);
    return Boolean.valueOf(true);
  }
  
  public String f()
  {
    return new String(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ca
 * JD-Core Version:    0.7.0.1
 */