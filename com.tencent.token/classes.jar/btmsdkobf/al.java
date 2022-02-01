package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class al
  extends JceStruct
{
  static byte[] bQ;
  public byte[] bP = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    bQ = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new al();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bP = ((byte[])paramJceInputStream.read(bQ, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    byte[] arrayOfByte = this.bP;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.al
 * JD-Core Version:    0.7.0.1
 */