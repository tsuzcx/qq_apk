final class awpo
{
  public static int oL = 16;
  int bodyLength;
  int length;
  int oJ = 538116905;
  short type = 1;
  short u = 0;
  
  public void aL(int paramInt)
  {
    this.bodyLength = paramInt;
  }
  
  public int bO()
  {
    return this.bodyLength;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public void r(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    this.oJ = aqcz.x(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 2);
    this.type = aqcz.a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 6, arrayOfByte, 0, 4);
    this.length = aqcz.x(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 10, arrayOfByte, 0, 4);
    this.bodyLength = aqcz.x(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 14, arrayOfByte, 0, 2);
    this.u = aqcz.a(arrayOfByte);
  }
  
  public void setLength(int paramInt)
  {
    this.length = paramInt;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(aqcz.h(this.oJ), 0, arrayOfByte, 0, 4);
    System.arraycopy(aqcz.a(this.type), 0, arrayOfByte, 4, 2);
    System.arraycopy(aqcz.h(this.length), 0, arrayOfByte, 6, 4);
    System.arraycopy(aqcz.h(this.bodyLength), 0, arrayOfByte, 10, 4);
    System.arraycopy(aqcz.a(this.u), 0, arrayOfByte, 14, 2);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpo
 * JD-Core Version:    0.7.0.1
 */