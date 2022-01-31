package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class send_gift_info
  extends JceStruct
{
  public boolean isTiming = true;
  public long receiver = 0L;
  public String sendTime = "";
  
  public send_gift_info() {}
  
  public send_gift_info(long paramLong, boolean paramBoolean, String paramString)
  {
    this.receiver = paramLong;
    this.isTiming = paramBoolean;
    this.sendTime = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.receiver = paramJceInputStream.read(this.receiver, 0, true);
    this.isTiming = paramJceInputStream.read(this.isTiming, 1, true);
    this.sendTime = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.receiver, 0);
    paramJceOutputStream.write(this.isTiming, 1);
    if (this.sendTime != null) {
      paramJceOutputStream.write(this.sendTime, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_gift_info
 * JD-Core Version:    0.7.0.1
 */