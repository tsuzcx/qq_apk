package oicq.wlogin_sdk.b;

public class ag
  extends a
{
  public ag()
  {
    this.g = 304;
  }
  
  public Boolean e()
  {
    if (this.e < 14) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(this.f, this.d + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] g()
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(this.f, this.d + 2 + 4, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ag
 * JD-Core Version:    0.7.0.1
 */