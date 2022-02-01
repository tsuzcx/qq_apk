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
    String str = this.guid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.ext1;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.sessionId;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int i = this.buildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.netType;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    long l = this.accountId;
    if (l != 0L) {
      paramJceOutputStream.write(l, 7);
    }
    i = this.bootType;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    str = this.wsGuid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MCommon.Sharkfin
 * JD-Core Version:    0.7.0.1
 */