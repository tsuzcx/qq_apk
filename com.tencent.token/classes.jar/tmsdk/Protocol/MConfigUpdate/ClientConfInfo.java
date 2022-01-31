package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientConfInfo
  extends JceStruct
{
  static byte[] bx = (byte[])new byte[1];
  public int PFUTimestamp = 0;
  public int fileId = 0;
  public int getType = 0;
  public byte[] md5Bin = null;
  public int timestamp = 0;
  public int version = 0;
  
  static
  {
    ((byte[])bx)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new ClientConfInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileId = paramJceInputStream.read(this.fileId, 0, true);
    this.md5Bin = ((byte[])paramJceInputStream.read(bx, 1, true));
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, true);
    this.PFUTimestamp = paramJceInputStream.read(this.PFUTimestamp, 3, false);
    this.getType = paramJceInputStream.read(this.getType, 4, false);
    this.version = paramJceInputStream.read(this.version, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fileId, 0);
    paramJceOutputStream.write(this.md5Bin, 1);
    paramJceOutputStream.write(this.timestamp, 2);
    if (this.PFUTimestamp != 0) {
      paramJceOutputStream.write(this.PFUTimestamp, 3);
    }
    if (this.getType != 0) {
      paramJceOutputStream.write(this.getType, 4);
    }
    if (this.version != 0) {
      paramJceOutputStream.write(this.version, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.ClientConfInfo
 * JD-Core Version:    0.7.0.1
 */