package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetGrpOffLMsg
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList cache_vOffLMsg;
  public long GrpId = 0L;
  public long OffMsgSeek = 0L;
  public RespHeader stHeader = null;
  public ArrayList vOffLMsg = null;
  
  public RespGetGrpOffLMsg() {}
  
  public RespGetGrpOffLMsg(RespHeader paramRespHeader, long paramLong1, long paramLong2, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHeader;
    this.GrpId = paramLong1;
    this.OffMsgSeek = paramLong2;
    this.vOffLMsg = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    this.OffMsgSeek = paramJceInputStream.read(this.OffMsgSeek, 2, true);
    if (cache_vOffLMsg == null)
    {
      cache_vOffLMsg = new ArrayList();
      OffLMsg localOffLMsg = new OffLMsg();
      cache_vOffLMsg.add(localOffLMsg);
    }
    this.vOffLMsg = ((ArrayList)paramJceInputStream.read(cache_vOffLMsg, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.OffMsgSeek, 2);
    paramJceOutputStream.write(this.vOffLMsg, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetGrpOffLMsg
 * JD-Core Version:    0.7.0.1
 */