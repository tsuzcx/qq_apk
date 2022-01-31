package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetBatchGrpData
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ArrayList cache_vGrpId;
  public int BeginSeq = 0;
  public ReqHeader stHeader = null;
  public ArrayList vGrpId = null;
  
  public ReqGetBatchGrpData() {}
  
  public ReqGetBatchGrpData(ReqHeader paramReqHeader, ArrayList paramArrayList, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.vGrpId = paramArrayList;
    this.BeginSeq = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vGrpId == null)
    {
      cache_vGrpId = new ArrayList();
      cache_vGrpId.add(Long.valueOf(0L));
    }
    this.vGrpId = ((ArrayList)paramJceInputStream.read(cache_vGrpId, 1, true));
    this.BeginSeq = paramJceInputStream.read(this.BeginSeq, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vGrpId, 1);
    paramJceOutputStream.write(this.BeginSeq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetBatchGrpData
 * JD-Core Version:    0.7.0.1
 */