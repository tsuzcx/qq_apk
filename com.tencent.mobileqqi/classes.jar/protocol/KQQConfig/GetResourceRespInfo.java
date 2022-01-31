package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetResourceRespInfo
  extends JceStruct
{
  public int iResult = 0;
  public short sLanType = 0;
  public short sPriority = 0;
  public short sResType = 0;
  public String strPkgName = "";
  public String strResConf = "";
  public String strResDesc = "";
  public String strResName = "";
  public String strResURL_big = "";
  public String strResURL_small = "";
  public long uiNewVer = 0L;
  public long uiResID = 0L;
  
  public GetResourceRespInfo() {}
  
  public GetResourceRespInfo(int paramInt, long paramLong1, String paramString1, long paramLong2, short paramShort1, short paramShort2, short paramShort3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.iResult = paramInt;
    this.uiResID = paramLong1;
    this.strPkgName = paramString1;
    this.uiNewVer = paramLong2;
    this.sResType = paramShort1;
    this.sLanType = paramShort2;
    this.sPriority = paramShort3;
    this.strResName = paramString2;
    this.strResDesc = paramString3;
    this.strResURL_big = paramString4;
    this.strResURL_small = paramString5;
    this.strResConf = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.uiResID = paramJceInputStream.read(this.uiResID, 2, true);
    this.strPkgName = paramJceInputStream.readString(3, true);
    this.uiNewVer = paramJceInputStream.read(this.uiNewVer, 4, true);
    this.sResType = paramJceInputStream.read(this.sResType, 5, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 6, true);
    this.sPriority = paramJceInputStream.read(this.sPriority, 7, true);
    this.strResName = paramJceInputStream.readString(8, true);
    this.strResDesc = paramJceInputStream.readString(9, true);
    this.strResURL_big = paramJceInputStream.readString(10, true);
    this.strResURL_small = paramJceInputStream.readString(11, true);
    this.strResConf = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.uiResID, 2);
    paramJceOutputStream.write(this.strPkgName, 3);
    paramJceOutputStream.write(this.uiNewVer, 4);
    paramJceOutputStream.write(this.sResType, 5);
    paramJceOutputStream.write(this.sLanType, 6);
    paramJceOutputStream.write(this.sPriority, 7);
    paramJceOutputStream.write(this.strResName, 8);
    paramJceOutputStream.write(this.strResDesc, 9);
    paramJceOutputStream.write(this.strResURL_big, 10);
    paramJceOutputStream.write(this.strResURL_small, 11);
    if (this.strResConf != null) {
      paramJceOutputStream.write(this.strResConf, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceRespInfo
 * JD-Core Version:    0.7.0.1
 */