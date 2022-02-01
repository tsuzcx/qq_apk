package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportItem
  extends JceStruct
  implements Cloneable, Comparable<ReportItem>
{
  public long costTime;
  public long createTime;
  public String failReason = "";
  public boolean isNormalEnd;
  public String params = "";
  public int result;
  public long seqno;
  public String step = "";
  
  public int compareTo(ReportItem paramReportItem)
  {
    if (this.createTime < paramReportItem.createTime) {
      return -1;
    }
    if (this.createTime == paramReportItem.createTime) {
      return 0;
    }
    return 1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.step = paramJceInputStream.readString(0, false);
    this.costTime = paramJceInputStream.read(this.costTime, 1, false);
    this.params = paramJceInputStream.readString(2, false);
    this.result = paramJceInputStream.read(this.result, 3, false);
    this.failReason = paramJceInputStream.readString(4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.step).append("|").append(this.result).append("|").append(this.createTime).append("|").append(this.costTime).append("|").append(this.isNormalEnd).append("|").append(this.params).append("|").append(this.failReason);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.step != null) {
      paramJceOutputStream.write(this.step, 0);
    }
    paramJceOutputStream.write(this.costTime, 1);
    if (this.params != null) {
      paramJceOutputStream.write(this.params, 2);
    }
    paramJceOutputStream.write(this.result, 3);
    if (this.failReason != null) {
      paramJceOutputStream.write(this.failReason, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VACDReport.ReportItem
 * JD-Core Version:    0.7.0.1
 */