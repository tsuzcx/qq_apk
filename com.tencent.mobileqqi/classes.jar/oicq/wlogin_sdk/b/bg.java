package oicq.wlogin_sdk.b;

public class bg
  extends a
{
  int h = 0;
  
  public bg()
  {
    this.g = 370;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this.h = arrayOfByte.length;
    paramArrayOfByte = new byte[this.h];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    a(this.g);
    b(paramArrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bg
 * JD-Core Version:    0.7.0.1
 */