package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_detail_actshuoshuo_req
  extends JceStruct
{
  public String act_id = "";
  public String busi_param = "";
  
  public mobile_detail_actshuoshuo_req() {}
  
  public mobile_detail_actshuoshuo_req(String paramString1, String paramString2)
  {
    this.act_id = paramString1;
    this.busi_param = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.act_id = paramJceInputStream.readString(0, false);
    this.busi_param = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.act_id != null) {
      paramJceOutputStream.write(this.act_id, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_actshuoshuo_req
 * JD-Core Version:    0.7.0.1
 */