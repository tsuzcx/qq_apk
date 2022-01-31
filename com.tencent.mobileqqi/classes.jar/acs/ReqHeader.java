package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  public int guid = 0;
  public int mask = 0;
  public long qq = 0L;
  public String qua = "";
  public String sid = "";
  public int version = 0;
  
  public ReqHeader() {}
  
  public ReqHeader(int paramInt1, String paramString1, long paramLong, int paramInt2, String paramString2, int paramInt3)
  {
    this.version = paramInt1;
    this.qua = paramString1;
    this.qq = paramLong;
    this.guid = paramInt2;
    this.sid = paramString2;
    this.mask = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.read(this.version, 0, true);
    this.qua = paramJceInputStream.readString(1, true);
    this.qq = paramJceInputStream.read(this.qq, 2, true);
    this.guid = paramJceInputStream.read(this.guid, 3, true);
    this.sid = paramJceInputStream.readString(4, false);
    this.mask = paramJceInputStream.read(this.mask, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
    paramJceOutputStream.write(this.qua, 1);
    paramJceOutputStream.write(this.qq, 2);
    paramJceOutputStream.write(this.guid, 3);
    if (this.sid != null) {
      paramJceOutputStream.write(this.sid, 4);
    }
    paramJceOutputStream.write(this.mask, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     acs.ReqHeader
 * JD-Core Version:    0.7.0.1
 */