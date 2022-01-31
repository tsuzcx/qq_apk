package oicq.wlogin_sdk.b;

public class ao
  extends a
{
  public int h = 0;
  
  public ao()
  {
    this.g = 325;
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
    int i = arrayOfByte.length;
    a(this.g);
    b(paramArrayOfByte, paramArrayOfByte.length);
    d();
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.ao
 * JD-Core Version:    0.7.0.1
 */