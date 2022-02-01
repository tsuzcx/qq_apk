package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class session_report
  extends JceStruct
{
  static ArrayList<feed_report_info> cache_vecFeedReportInfo = new ArrayList();
  public String strSession = "";
  public int uReqId;
  public ArrayList<feed_report_info> vecFeedReportInfo;
  
  static
  {
    feed_report_info localfeed_report_info = new feed_report_info();
    cache_vecFeedReportInfo.add(localfeed_report_info);
  }
  
  public session_report() {}
  
  public session_report(int paramInt, ArrayList<feed_report_info> paramArrayList, String paramString)
  {
    this.uReqId = paramInt;
    this.vecFeedReportInfo = paramArrayList;
    this.strSession = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uReqId = paramJceInputStream.read(this.uReqId, 0, false);
    this.vecFeedReportInfo = ((ArrayList)paramJceInputStream.read(cache_vecFeedReportInfo, 1, false));
    this.strSession = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uReqId, 0);
    if (this.vecFeedReportInfo != null) {
      paramJceOutputStream.write(this.vecFeedReportInfo, 1);
    }
    if (this.strSession != null) {
      paramJceOutputStream.write(this.strSession, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.session_report
 * JD-Core Version:    0.7.0.1
 */