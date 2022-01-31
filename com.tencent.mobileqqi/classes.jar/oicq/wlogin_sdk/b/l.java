package oicq.wlogin_sdk.b;

public class l
  extends a
{
  public l()
  {
    this.g = 266;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new byte[arrayOfByte.length];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    a(this.g);
    b(paramArrayOfByte, paramArrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.l
 * JD-Core Version:    0.7.0.1
 */