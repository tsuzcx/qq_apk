package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestSetRoamMsg
  extends JceStruct
{
  static ArrayList cache_vRoamInfo;
  public byte cVerifyType = 0;
  public long lUin = 0L;
  public short shType = 0;
  public ArrayList vRoamInfo = null;
  
  public SvcRequestSetRoamMsg() {}
  
  public SvcRequestSetRoamMsg(long paramLong, byte paramByte, short paramShort, ArrayList paramArrayList)
  {
    this.lUin = paramLong;
    this.cVerifyType = paramByte;
    this.shType = paramShort;
    this.vRoamInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.shType = paramJceInputStream.read(this.shType, 2, true);
    if (cache_vRoamInfo == null)
    {
      cache_vRoamInfo = new ArrayList();
      RoamInfo localRoamInfo = new RoamInfo();
      cache_vRoamInfo.add(localRoamInfo);
    }
    this.vRoamInfo = ((ArrayList)paramJceInputStream.read(cache_vRoamInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.shType, 2);
    paramJceOutputStream.write(this.vRoamInfo, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestSetRoamMsg
 * JD-Core Version:    0.7.0.1
 */