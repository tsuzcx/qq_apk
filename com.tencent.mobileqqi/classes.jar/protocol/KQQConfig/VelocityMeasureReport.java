package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VelocityMeasureReport
  extends JceStruct
{
  static ArrayList cache_vLinkInfo;
  public ArrayList vLinkInfo = null;
  
  public VelocityMeasureReport() {}
  
  public VelocityMeasureReport(ArrayList paramArrayList)
  {
    this.vLinkInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vLinkInfo == null)
    {
      cache_vLinkInfo = new ArrayList();
      MeasureReportInfo localMeasureReportInfo = new MeasureReportInfo();
      cache_vLinkInfo.add(localMeasureReportInfo);
    }
    this.vLinkInfo = ((ArrayList)paramJceInputStream.read(cache_vLinkInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vLinkInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.VelocityMeasureReport
 * JD-Core Version:    0.7.0.1
 */