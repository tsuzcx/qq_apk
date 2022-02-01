package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_gift_item
  extends JceStruct
{
  public String format = "";
  public long item_id;
  public int item_type;
  public String name = "";
  public String picUrl = "";
  public String picUrl_188 = "";
  public String pre_format = "";
  public int price;
  public String remark = "";
  public int special_type;
  public String url_audio = "";
  public String url_video = "";
  public String url_video_thumbnail = "";
  public int vip_price;
  public String warm_msg = "";
  
  public s_gift_item() {}
  
  public s_gift_item(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.item_id = paramLong;
    this.name = paramString1;
    this.price = paramInt1;
    this.vip_price = paramInt2;
    this.format = paramString2;
    this.item_type = paramInt3;
    this.remark = paramString3;
    this.special_type = paramInt4;
    this.pre_format = paramString4;
    this.picUrl = paramString5;
    this.warm_msg = paramString6;
    this.url_audio = paramString7;
    this.url_video = paramString8;
    this.url_video_thumbnail = paramString9;
    this.picUrl_188 = paramString10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item_id = paramJceInputStream.read(this.item_id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.price = paramJceInputStream.read(this.price, 2, true);
    this.vip_price = paramJceInputStream.read(this.vip_price, 3, true);
    this.format = paramJceInputStream.readString(4, true);
    this.item_type = paramJceInputStream.read(this.item_type, 5, true);
    this.remark = paramJceInputStream.readString(6, true);
    this.special_type = paramJceInputStream.read(this.special_type, 7, true);
    this.pre_format = paramJceInputStream.readString(8, false);
    this.picUrl = paramJceInputStream.readString(9, false);
    this.warm_msg = paramJceInputStream.readString(10, false);
    this.url_audio = paramJceInputStream.readString(11, false);
    this.url_video = paramJceInputStream.readString(12, false);
    this.url_video_thumbnail = paramJceInputStream.readString(13, false);
    this.picUrl_188 = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.item_id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.price, 2);
    paramJceOutputStream.write(this.vip_price, 3);
    paramJceOutputStream.write(this.format, 4);
    paramJceOutputStream.write(this.item_type, 5);
    paramJceOutputStream.write(this.remark, 6);
    paramJceOutputStream.write(this.special_type, 7);
    if (this.pre_format != null) {
      paramJceOutputStream.write(this.pre_format, 8);
    }
    if (this.picUrl != null) {
      paramJceOutputStream.write(this.picUrl, 9);
    }
    if (this.warm_msg != null) {
      paramJceOutputStream.write(this.warm_msg, 10);
    }
    if (this.url_audio != null) {
      paramJceOutputStream.write(this.url_audio, 11);
    }
    if (this.url_video != null) {
      paramJceOutputStream.write(this.url_video, 12);
    }
    if (this.url_video_thumbnail != null) {
      paramJceOutputStream.write(this.url_video_thumbnail, 13);
    }
    if (this.picUrl_188 != null) {
      paramJceOutputStream.write(this.picUrl_188, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.s_gift_item
 * JD-Core Version:    0.7.0.1
 */