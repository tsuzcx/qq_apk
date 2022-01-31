package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetResourceRespInfoV2
  extends JceStruct
{
  public byte cCanChangeState = 1;
  public byte cDefaultState = 0;
  public byte cPush = 0;
  public byte cStatus = 0;
  public int iPluginType = 64;
  public short sLanType = 0;
  public short sPriority = 0;
  public short sResSubType = 0;
  public String strPkgName = "";
  public String strResConf = "";
  public String strResDesc = "";
  public String strResName = "";
  public String strResURL_big = "";
  public String strResURL_small = "";
  public long uiNewVer = 0L;
  public long uiResId = 0L;
  
  public GetResourceRespInfoV2() {}
  
  public GetResourceRespInfoV2(String paramString1, long paramLong1, short paramShort1, short paramShort2, short paramShort3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, long paramLong2, byte paramByte3, byte paramByte4, int paramInt)
  {
    this.strPkgName = paramString1;
    this.uiNewVer = paramLong1;
    this.sResSubType = paramShort1;
    this.sLanType = paramShort2;
    this.sPriority = paramShort3;
    this.strResName = paramString2;
    this.strResDesc = paramString3;
    this.strResURL_big = paramString4;
    this.strResURL_small = paramString5;
    this.strResConf = paramString6;
    this.cDefaultState = paramByte1;
    this.cCanChangeState = paramByte2;
    this.uiResId = paramLong2;
    this.cStatus = paramByte3;
    this.cPush = paramByte4;
    this.iPluginType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPkgName = paramJceInputStream.readString(1, true);
    this.uiNewVer = paramJceInputStream.read(this.uiNewVer, 2, true);
    this.sResSubType = paramJceInputStream.read(this.sResSubType, 3, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 4, true);
    this.sPriority = paramJceInputStream.read(this.sPriority, 5, true);
    this.strResName = paramJceInputStream.readString(6, true);
    this.strResDesc = paramJceInputStream.readString(7, true);
    this.strResURL_big = paramJceInputStream.readString(8, true);
    this.strResURL_small = paramJceInputStream.readString(9, true);
    this.strResConf = paramJceInputStream.readString(10, true);
    this.cDefaultState = paramJceInputStream.read(this.cDefaultState, 11, true);
    this.cCanChangeState = paramJceInputStream.read(this.cCanChangeState, 12, true);
    this.uiResId = paramJceInputStream.read(this.uiResId, 13, false);
    this.cStatus = paramJceInputStream.read(this.cStatus, 14, false);
    this.cPush = paramJceInputStream.read(this.cPush, 15, false);
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPkgName, 1);
    paramJceOutputStream.write(this.uiNewVer, 2);
    paramJceOutputStream.write(this.sResSubType, 3);
    paramJceOutputStream.write(this.sLanType, 4);
    paramJceOutputStream.write(this.sPriority, 5);
    paramJceOutputStream.write(this.strResName, 6);
    paramJceOutputStream.write(this.strResDesc, 7);
    paramJceOutputStream.write(this.strResURL_big, 8);
    paramJceOutputStream.write(this.strResURL_small, 9);
    paramJceOutputStream.write(this.strResConf, 10);
    paramJceOutputStream.write(this.cDefaultState, 11);
    paramJceOutputStream.write(this.cCanChangeState, 12);
    paramJceOutputStream.write(this.uiResId, 13);
    paramJceOutputStream.write(this.cStatus, 14);
    paramJceOutputStream.write(this.cPush, 15);
    paramJceOutputStream.write(this.iPluginType, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceRespInfoV2
 * JD-Core Version:    0.7.0.1
 */