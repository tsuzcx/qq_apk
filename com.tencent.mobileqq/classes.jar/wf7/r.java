package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class r
  extends JceStruct
{
  static byte[] bQ = (byte[])new byte[1];
  public byte[] bP = null;
  
  static
  {
    ((byte[])bQ)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new r();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bP = ((byte[])paramJceInputStream.read(bQ, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    byte[] arrayOfByte = this.bP;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.r
 * JD-Core Version:    0.7.0.1
 */