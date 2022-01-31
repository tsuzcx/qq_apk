package tmsdk.Protocol.MCommon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Sharkfin
  extends JceStruct
{
  public long accountId = 0L;
  public int apn = 2;
  public int authType = 0;
  public int bootType = 0;
  public int buildno = 0;
  public String ext1 = "";
  public String guid = "";
  public int netType = 0;
  public String sessionId = "";
  public String wsGuid = "";
  
  public JceStruct newInit()
  {
    return new Sharkfin();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.apn = paramJceInputStream.read(this.apn, 0, true);
    this.authType = paramJceInputStream.read(this.authType, 1, true);
    this.guid = paramJceInputStream.readString(2, false);
    this.ext1 = paramJceInputStream.readString(3, false);
    this.sessionId = paramJceInputStream.readString(4, false);
    this.buildno = paramJceInputStream.read(this.buildno, 5, false);
    this.netType = paramJceInputStream.read(this.netType, 6, false);
    this.accountId = paramJceInputStream.read(this.accountId, 7, false);
    this.bootType = paramJceInputStream.read(this.bootType, 8, false);
    this.wsGuid = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.apn, 0);
    paramJceOutputStream.write(this.authType, 1);
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 2);
    }
    if (this.ext1 != null) {
      paramJceOutputStream.write(this.ext1, 3);
    }
    if (this.sessionId != null) {
      paramJceOutputStream.write(this.sessionId, 4);
    }
    if (this.buildno != 0) {
      paramJceOutputStream.write(this.buildno, 5);
    }
    if (this.netType != 0) {
      paramJceOutputStream.write(this.netType, 6);
    }
    if (this.accountId != 0L) {
      paramJceOutputStream.write(this.accountId, 7);
    }
    if (this.bootType != 0) {
      paramJceOutputStream.write(this.bootType, 8);
    }
    if (this.wsGuid != null) {
      paramJceOutputStream.write(this.wsGuid, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MCommon.Sharkfin
 * JD-Core Version:    0.7.0.1
 */