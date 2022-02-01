package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ak
  extends JceStruct
{
  static byte[] bO;
  public int bM = 0;
  public byte[] bN = null;
  public int status = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    bO = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new ak();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bM = paramJceInputStream.read(this.bM, 0, true);
    this.bN = ((byte[])paramJceInputStream.read(bO, 1, false));
    this.status = paramJceInputStream.read(this.status, 2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bM, 0);
    byte[] arrayOfByte = this.bN;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 1);
    }
    int i = this.status;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ak
 * JD-Core Version:    0.7.0.1
 */