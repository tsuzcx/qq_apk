package a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] f;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public byte[] d = null;
  public long e = 0L;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(f, 3, false));
    this.e = paramJceInputStream.read(this.e, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != 0) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != 0) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != 0L) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.c
 * JD-Core Version:    0.7.0.1
 */