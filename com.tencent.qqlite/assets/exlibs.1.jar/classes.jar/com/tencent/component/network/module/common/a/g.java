package com.tencent.component.network.module.common.a;

public final class g
{
  private static byte[] c;
  private static byte[] d;
  private String a;
  private int b;
  
  static
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[2] = 1;
    arrayOfByte[5] = 1;
    c = arrayOfByte;
    arrayOfByte = new byte[5];
    arrayOfByte[2] = 1;
    arrayOfByte[4] = 1;
    d = arrayOfByte;
  }
  
  public g(String paramString)
  {
    this.a = paramString;
    this.b = b.a().b();
  }
  
  public final byte[] a()
  {
    if (this.a == null) {}
    do
    {
      return null;
      this.a = this.a.trim().toLowerCase();
    } while (this.a.length() == 0);
    byte[] arrayOfByte1 = new byte[c.length + d.length + this.a.length() + 1];
    String[] arrayOfString = this.a.split("\\.");
    int j = c.length;
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length)
      {
        System.arraycopy(c, 0, arrayOfByte1, 0, c.length);
        System.arraycopy(d, 0, arrayOfByte1, j, d.length);
        arrayOfByte1[0] = ((byte)(this.b >>> 8));
        arrayOfByte1[1] = ((byte)this.b);
        return arrayOfByte1;
      }
      arrayOfByte1[j] = ((byte)arrayOfString[i].length());
      j += 1;
      byte[] arrayOfByte2 = arrayOfString[i].getBytes();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.g
 * JD-Core Version:    0.7.0.1
 */