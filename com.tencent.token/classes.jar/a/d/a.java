package a.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static byte[] b;
  public byte[] a = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (b == null)
    {
      b = (byte[])new byte[1];
      ((byte[])b)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(b, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.d.a
 * JD-Core Version:    0.7.0.1
 */