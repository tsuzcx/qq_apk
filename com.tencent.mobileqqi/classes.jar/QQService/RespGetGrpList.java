package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetGrpList
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList cache_vGrpId;
  public int SvrGrpListStamp = 0;
  public RespHeader stHeader = null;
  public ArrayList vGrpId = null;
  
  public RespGetGrpList() {}
  
  public RespGetGrpList(RespHeader paramRespHeader, ArrayList paramArrayList, int paramInt)
  {
    this.stHeader = paramRespHeader;
    this.vGrpId = paramArrayList;
    this.SvrGrpListStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vGrpId == null)
    {
      cache_vGrpId = new ArrayList();
      cache_vGrpId.add(Long.valueOf(0L));
    }
    this.vGrpId = ((ArrayList)paramJceInputStream.read(cache_vGrpId, 1, true));
    this.SvrGrpListStamp = paramJceInputStream.read(this.SvrGrpListStamp, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vGrpId, 1);
    paramJceOutputStream.write(this.SvrGrpListStamp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetGrpList
 * JD-Core Version:    0.7.0.1
 */