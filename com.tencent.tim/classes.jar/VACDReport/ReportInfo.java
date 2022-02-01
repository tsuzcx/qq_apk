package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportInfo
  extends JceStruct
  implements Cloneable
{
  static ReportBody cache_body;
  static ReportHeader cache_header;
  public ReportBody body;
  public ReportHeader header;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_header == null) {
      cache_header = new ReportHeader();
    }
    this.header = ((ReportHeader)paramJceInputStream.read(cache_header, 0, true));
    if (cache_body == null) {
      cache_body = new ReportBody();
    }
    this.body = ((ReportBody)paramJceInputStream.read(cache_body, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.header, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VACDReport.ReportInfo
 * JD-Core Version:    0.7.0.1
 */