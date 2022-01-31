package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class o
  extends JceStruct
{
  static byte[] bJ = (byte[])new byte[1];
  public int bH = 0;
  public byte[] bI = null;
  public int status = 0;
  
  static
  {
    ((byte[])bJ)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new o();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bH = paramJceInputStream.read(this.bH, 0, true);
    this.bI = ((byte[])paramJceInputStream.read(bJ, 1, false));
    this.status = paramJceInputStream.read(this.status, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bH, 0);
    if (this.bI != null) {
      paramJceOutputStream.write(this.bI, 1);
    }
    if (this.status != 0) {
      paramJceOutputStream.write(this.status, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.o
 * JD-Core Version:    0.7.0.1
 */