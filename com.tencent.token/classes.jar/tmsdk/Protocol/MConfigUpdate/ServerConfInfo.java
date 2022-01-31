package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ServerConfInfo
  extends JceStruct
{
  static byte[] bE;
  static byte[] bF;
  static Map bG;
  static byte[] bx = (byte[])new byte[1];
  public byte[] confData = null;
  public int downloadflag = 0;
  public Map extmap = null;
  public int fileId = 0;
  public int fileSize = 0;
  public boolean isIncreUpdate = false;
  public byte[] iuMd5Bin = null;
  public byte[] md5Bin = null;
  public long taskid = 0L;
  public int timestamp = 0;
  public int updateNum = 0;
  public String url = "";
  public String wrapkey = "";
  public int wraptype = 0;
  
  static
  {
    ((byte[])bx)[0] = 0;
    bE = (byte[])new byte[1];
    ((byte[])bE)[0] = 0;
    bF = (byte[])new byte[1];
    ((byte[])bF)[0] = 0;
    bG = new HashMap();
    bG.put("", "");
  }
  
  public JceStruct newInit()
  {
    return new ServerConfInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileId = paramJceInputStream.read(this.fileId, 0, true);
    this.md5Bin = ((byte[])paramJceInputStream.read(bx, 1, true));
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, true);
    this.url = paramJceInputStream.readString(3, false);
    this.isIncreUpdate = paramJceInputStream.read(this.isIncreUpdate, 4, false);
    this.iuMd5Bin = ((byte[])paramJceInputStream.read(bE, 5, false));
    this.confData = ((byte[])paramJceInputStream.read(bF, 6, false));
    this.updateNum = paramJceInputStream.read(this.updateNum, 7, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 8, false);
    this.taskid = paramJceInputStream.read(this.taskid, 9, false);
    this.downloadflag = paramJceInputStream.read(this.downloadflag, 10, false);
    this.wraptype = paramJceInputStream.read(this.wraptype, 11, false);
    this.wrapkey = paramJceInputStream.readString(12, false);
    this.extmap = ((Map)paramJceInputStream.read(bG, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fileId, 0);
    paramJceOutputStream.write(this.md5Bin, 1);
    paramJceOutputStream.write(this.timestamp, 2);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
    if (this.isIncreUpdate) {
      paramJceOutputStream.write(this.isIncreUpdate, 4);
    }
    if (this.iuMd5Bin != null) {
      paramJceOutputStream.write(this.iuMd5Bin, 5);
    }
    if (this.confData != null) {
      paramJceOutputStream.write(this.confData, 6);
    }
    if (this.updateNum != 0) {
      paramJceOutputStream.write(this.updateNum, 7);
    }
    if (this.fileSize != 0) {
      paramJceOutputStream.write(this.fileSize, 8);
    }
    if (this.taskid != 0L) {
      paramJceOutputStream.write(this.taskid, 9);
    }
    if (this.downloadflag != 0) {
      paramJceOutputStream.write(this.downloadflag, 10);
    }
    if (this.wraptype != 0) {
      paramJceOutputStream.write(this.wraptype, 11);
    }
    if (this.wrapkey != null) {
      paramJceOutputStream.write(this.wrapkey, 12);
    }
    if (this.extmap != null) {
      paramJceOutputStream.write(this.extmap, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.ServerConfInfo
 * JD-Core Version:    0.7.0.1
 */