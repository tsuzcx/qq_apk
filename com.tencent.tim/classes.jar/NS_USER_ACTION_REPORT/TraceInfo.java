package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TraceInfo
  extends JceStruct
{
  public String trace_detail = "";
  public String trace_id = "";
  public String trace_index = "";
  public long trace_num;
  
  public TraceInfo() {}
  
  public TraceInfo(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    this.trace_id = paramString1;
    this.trace_num = paramLong;
    this.trace_detail = paramString2;
    this.trace_index = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.trace_id = paramJceInputStream.readString(0, true);
    this.trace_num = paramJceInputStream.read(this.trace_num, 1, true);
    this.trace_detail = paramJceInputStream.readString(2, false);
    this.trace_index = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.trace_id, 0);
    paramJceOutputStream.write(this.trace_num, 1);
    if (this.trace_detail != null) {
      paramJceOutputStream.write(this.trace_detail, 2);
    }
    if (this.trace_index != null) {
      paramJceOutputStream.write(this.trace_index, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.TraceInfo
 * JD-Core Version:    0.7.0.1
 */