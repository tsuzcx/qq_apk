package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class send_gift_fail_item
  extends JceStruct
{
  public String name = "";
  public String reason = "";
  public long uin = 0L;
  
  public send_gift_fail_item() {}
  
  public send_gift_fail_item(long paramLong, String paramString1, String paramString2)
  {
    this.uin = paramLong;
    this.name = paramString1;
    this.reason = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.reason = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.reason, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_gift_fail_item
 * JD-Core Version:    0.7.0.1
 */