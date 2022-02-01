package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_adv_report_rsp
  extends JceStruct
{
  public String error_msg = "";
  public int ret_code;
  
  public mobile_adv_report_rsp() {}
  
  public mobile_adv_report_rsp(int paramInt, String paramString)
  {
    this.ret_code = paramInt;
    this.error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.error_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.error_msg != null) {
      paramJceOutputStream.write(this.error_msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ADV_REPORT.mobile_adv_report_rsp
 * JD-Core Version:    0.7.0.1
 */