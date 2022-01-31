package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GrpData
  extends JceStruct
{
  public int GrpDataStamp = 0;
  public long GrpId = 0L;
  public int GrpMemberNum = 0;
  public String GrpName = "";
  
  public GrpData() {}
  
  public GrpData(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this.GrpId = paramLong;
    this.GrpName = paramString;
    this.GrpMemberNum = paramInt1;
    this.GrpDataStamp = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GrpId = paramJceInputStream.read(this.GrpId, 0, true);
    this.GrpName = paramJceInputStream.readString(1, true);
    this.GrpMemberNum = paramJceInputStream.read(this.GrpMemberNum, 2, true);
    this.GrpDataStamp = paramJceInputStream.read(this.GrpDataStamp, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpId, 0);
    paramJceOutputStream.write(this.GrpName, 1);
    paramJceOutputStream.write(this.GrpMemberNum, 2);
    paramJceOutputStream.write(this.GrpDataStamp, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpData
 * JD-Core Version:    0.7.0.1
 */