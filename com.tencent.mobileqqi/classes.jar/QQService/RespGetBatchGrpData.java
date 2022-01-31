package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetBatchGrpData
  extends JceStruct
{
  static ArrayList cache_BatchGrpData;
  static RespHeader cache_stHeader;
  public ArrayList BatchGrpData = null;
  public int EndSeq = 0;
  public int TotalNum = 0;
  public RespHeader stHeader = null;
  
  public RespGetBatchGrpData() {}
  
  public RespGetBatchGrpData(RespHeader paramRespHeader, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    this.stHeader = paramRespHeader;
    this.BatchGrpData = paramArrayList;
    this.TotalNum = paramInt1;
    this.EndSeq = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_BatchGrpData == null)
    {
      cache_BatchGrpData = new ArrayList();
      GrpData localGrpData = new GrpData();
      cache_BatchGrpData.add(localGrpData);
    }
    this.BatchGrpData = ((ArrayList)paramJceInputStream.read(cache_BatchGrpData, 1, true));
    this.TotalNum = paramJceInputStream.read(this.TotalNum, 2, true);
    this.EndSeq = paramJceInputStream.read(this.EndSeq, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.BatchGrpData, 1);
    paramJceOutputStream.write(this.TotalNum, 2);
    paramJceOutputStream.write(this.EndSeq, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetBatchGrpData
 * JD-Core Version:    0.7.0.1
 */