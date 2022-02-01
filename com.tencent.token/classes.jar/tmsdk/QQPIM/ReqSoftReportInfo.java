package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqSoftReportInfo
  extends JceStruct
{
  static ArrayList<SoftReportInfo> eF;
  public ArrayList<SoftReportInfo> vecReportSofts = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (eF == null)
    {
      eF = new ArrayList();
      SoftReportInfo localSoftReportInfo = new SoftReportInfo();
      eF.add(localSoftReportInfo);
    }
    this.vecReportSofts = ((ArrayList)paramJceInputStream.read(eF, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReportSofts, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ReqSoftReportInfo
 * JD-Core Version:    0.7.0.1
 */