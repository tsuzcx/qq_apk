package oicq.wlogin_sdk.b;

public class ci
  extends a
{
  public ci()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ci
 * JD-Core Version:    0.7.0.1
 */