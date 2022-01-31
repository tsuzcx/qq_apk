package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqPayOrder
  extends JceStruct
  implements Cloneable
{
  public String orderId = "";
  public String payChannel = "";
  public String payChannelSubId = "";
  public int subCmd = 0;
  
  public ReqPayOrder() {}
  
  public ReqPayOrder(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.subCmd = paramInt;
    this.payChannel = paramString1;
    this.payChannelSubId = paramString2;
    this.orderId = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.payChannel = paramJceInputStream.readString(1, true);
    this.payChannelSubId = paramJceInputStream.readString(2, true);
    this.orderId = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.payChannel, 1);
    paramJceOutputStream.write(this.payChannelSubId, 2);
    paramJceOutputStream.write(this.orderId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     CardPay.ReqPayOrder
 * JD-Core Version:    0.7.0.1
 */