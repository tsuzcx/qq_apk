package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CollectCouponReq
  extends JceStruct
{
  public String appid = "";
  public String card_id = "";
  public int field;
  public long uin;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.field = paramJceInputStream.read(this.field, 1, true);
    this.appid = paramJceInputStream.readString(2, true);
    this.card_id = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.field, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.card_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QCARD.CollectCouponReq
 * JD-Core Version:    0.7.0.1
 */