package PasserbySvc;

import NeighborComm.PassTime;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespPasserbyInfo
  extends JceStruct
{
  static ArrayList cache_vRecords;
  public byte cAge = -1;
  public byte cSex = -1;
  public long lPBMid = 0L;
  public String strCompanyName = "";
  public String strPYFaceUrl = "";
  public String strPYName = "";
  public String strSchoolName = "";
  public ArrayList vRecords = null;
  
  public RespPasserbyInfo() {}
  
  public RespPasserbyInfo(long paramLong, ArrayList paramArrayList, byte paramByte1, byte paramByte2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lPBMid = paramLong;
    this.vRecords = paramArrayList;
    this.cSex = paramByte1;
    this.cAge = paramByte2;
    this.strPYFaceUrl = paramString1;
    this.strSchoolName = paramString2;
    this.strCompanyName = paramString3;
    this.strPYName = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPBMid = paramJceInputStream.read(this.lPBMid, 0, true);
    if (cache_vRecords == null)
    {
      cache_vRecords = new ArrayList();
      PassTime localPassTime = new PassTime();
      cache_vRecords.add(localPassTime);
    }
    this.vRecords = ((ArrayList)paramJceInputStream.read(cache_vRecords, 1, true));
    this.cSex = paramJceInputStream.read(this.cSex, 2, false);
    this.cAge = paramJceInputStream.read(this.cAge, 3, false);
    this.strPYFaceUrl = paramJceInputStream.readString(4, false);
    this.strSchoolName = paramJceInputStream.readString(5, false);
    this.strCompanyName = paramJceInputStream.readString(6, false);
    this.strPYName = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPBMid, 0);
    paramJceOutputStream.write(this.vRecords, 1);
    paramJceOutputStream.write(this.cSex, 2);
    paramJceOutputStream.write(this.cAge, 3);
    if (this.strPYFaceUrl != null) {
      paramJceOutputStream.write(this.strPYFaceUrl, 4);
    }
    if (this.strSchoolName != null) {
      paramJceOutputStream.write(this.strSchoolName, 5);
    }
    if (this.strCompanyName != null) {
      paramJceOutputStream.write(this.strCompanyName, 6);
    }
    if (this.strPYName != null) {
      paramJceOutputStream.write(this.strPYName, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PasserbySvc.RespPasserbyInfo
 * JD-Core Version:    0.7.0.1
 */