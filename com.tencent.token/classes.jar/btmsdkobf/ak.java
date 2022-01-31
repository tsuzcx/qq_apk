package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ak
  extends JceStruct
{
  static byte[] bO = (byte[])new byte[1];
  public int bM = 0;
  public byte[] bN = null;
  public int status = 0;
  
  static
  {
    ((byte[])bO)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new ak();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bM = paramJceInputStream.read(this.bM, 0, true);
    this.bN = ((byte[])paramJceInputStream.read(bO, 1, false));
    this.status = paramJceInputStream.read(this.status, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bM, 0);
    if (this.bN != null) {
      paramJceOutputStream.write(this.bN, 1);
    }
    if (this.status != 0) {
      paramJceOutputStream.write(this.status, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ak
 * JD-Core Version:    0.7.0.1
 */