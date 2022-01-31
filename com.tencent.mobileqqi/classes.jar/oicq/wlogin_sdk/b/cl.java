package oicq.wlogin_sdk.b;

public class cl
  extends a
{
  public cl()
  {
    this.g = 1025;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte = new byte[arrayOfByte.length];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    int i = arrayOfByte.length;
    a(this.g);
    b(paramArrayOfByte, paramArrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.cl
 * JD-Core Version:    0.7.0.1
 */