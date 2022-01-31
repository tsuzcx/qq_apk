package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_mainpage_req
  extends JceStruct
{
  public String qunid = "";
  public long uin = 0L;
  
  public qun_mainpage_req() {}
  
  public qun_mainpage_req(String paramString, long paramLong)
  {
    this.qunid = paramString;
    this.uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.uin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_mainpage_req
 * JD-Core Version:    0.7.0.1
 */