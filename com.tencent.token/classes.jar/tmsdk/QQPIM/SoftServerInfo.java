package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SoftServerInfo
  extends JceStruct
{
  static byte[] dM;
  public byte[] expand = null;
  public int servertime = 0;
  public int softupdate_tips = 1;
  public int status = 0;
  
  public SoftServerInfo() {}
  
  public SoftServerInfo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.status = paramInt1;
    this.expand = paramArrayOfByte;
    this.servertime = paramInt2;
    this.softupdate_tips = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, true);
    if (dM == null)
    {
      dM = (byte[])new byte[1];
      ((byte[])dM)[0] = 0;
    }
    this.expand = ((byte[])paramJceInputStream.read(dM, 1, false));
    this.servertime = paramJceInputStream.read(this.servertime, 2, false);
    this.softupdate_tips = paramJceInputStream.read(this.softupdate_tips, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    if (this.expand != null) {
      paramJceOutputStream.write(this.expand, 1);
    }
    paramJceOutputStream.write(this.servertime, 2);
    paramJceOutputStream.write(this.softupdate_tips, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftServerInfo
 * JD-Core Version:    0.7.0.1
 */