package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CouponMobileItem
  extends JceStruct
{
  public String appid = "";
  public String card_id = "";
  public String code = "";
  public String distance = "";
  public long expire_time;
  public int field;
  public String from = "";
  public String icon_url = "";
  public int is_valid;
  public String jump_url = "";
  public String next_cardid = "";
  public int status;
  public String style_json_str = "";
  public String sub_title = "";
  public String title = "";
  public String valid_tips_format = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.card_id = paramJceInputStream.readString(0, true);
    this.code = paramJceInputStream.readString(1, true);
    this.field = paramJceInputStream.read(this.field, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, true);
    this.title = paramJceInputStream.readString(4, true);
    this.sub_title = paramJceInputStream.readString(5, true);
    this.from = paramJceInputStream.readString(6, true);
    this.valid_tips_format = paramJceInputStream.readString(7, true);
    this.expire_time = paramJceInputStream.read(this.expire_time, 8, true);
    this.icon_url = paramJceInputStream.readString(9, true);
    this.jump_url = paramJceInputStream.readString(10, true);
    this.is_valid = paramJceInputStream.read(this.is_valid, 11, true);
    this.distance = paramJceInputStream.readString(12, false);
    this.style_json_str = paramJceInputStream.readString(13, false);
    this.appid = paramJceInputStream.readString(14, false);
    this.next_cardid = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.card_id, 0);
    paramJceOutputStream.write(this.code, 1);
    paramJceOutputStream.write(this.field, 2);
    paramJceOutputStream.write(this.status, 3);
    paramJceOutputStream.write(this.title, 4);
    paramJceOutputStream.write(this.sub_title, 5);
    paramJceOutputStream.write(this.from, 6);
    paramJceOutputStream.write(this.valid_tips_format, 7);
    paramJceOutputStream.write(this.expire_time, 8);
    paramJceOutputStream.write(this.icon_url, 9);
    paramJceOutputStream.write(this.jump_url, 10);
    paramJceOutputStream.write(this.is_valid, 11);
    if (this.distance != null) {
      paramJceOutputStream.write(this.distance, 12);
    }
    if (this.style_json_str != null) {
      paramJceOutputStream.write(this.style_json_str, 13);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 14);
    }
    if (this.next_cardid != null) {
      paramJceOutputStream.write(this.next_cardid, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QCARD.CouponMobileItem
 * JD-Core Version:    0.7.0.1
 */