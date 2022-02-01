package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReportReq
  extends JceStruct
  implements Cloneable
{
  static ArrayList<ReportInfo> cache_reports;
  public ArrayList<ReportInfo> reports;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_reports == null)
    {
      cache_reports = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      cache_reports.add(localReportInfo);
    }
    this.reports = ((ArrayList)paramJceInputStream.read(cache_reports, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reports, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VACDReport.ReportReq
 * JD-Core Version:    0.7.0.1
 */