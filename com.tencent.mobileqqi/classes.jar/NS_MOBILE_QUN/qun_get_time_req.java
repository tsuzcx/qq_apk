package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_get_time_req
  extends JceStruct
{
  public String qunid = "";
  
  public qun_get_time_req(String paramString)
  {
    this.qunid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qunid != null) {
      paramJceOutputStream.write(this.qunid, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_time_req
 * JD-Core Version:    0.7.0.1
 */