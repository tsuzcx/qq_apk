package NS_FAMOUS_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SchoolSingleGameItem
  extends JceStruct
{
  public String app_class1 = "";
  public String app_class2 = "";
  public String app_icon = "";
  public String app_name = "";
  public long appid;
  public long click_time;
  public long create_time;
  public String detail_url = "";
  public int flag;
  public long online_time;
  
  public SchoolSingleGameItem() {}
  
  public SchoolSingleGameItem(long paramLong1, String paramString1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this.appid = paramLong1;
    this.app_name = paramString1;
    this.create_time = paramLong2;
    this.online_time = paramLong3;
    this.click_time = paramLong4;
    this.app_icon = paramString2;
    this.detail_url = paramString3;
    this.flag = paramInt;
    this.app_class1 = paramString4;
    this.app_class2 = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, true);
    this.app_name = paramJceInputStream.readString(1, false);
    this.create_time = paramJceInputStream.read(this.create_time, 2, false);
    this.online_time = paramJceInputStream.read(this.online_time, 3, false);
    this.click_time = paramJceInputStream.read(this.click_time, 4, false);
    this.app_icon = paramJceInputStream.readString(5, false);
    this.detail_url = paramJceInputStream.readString(6, false);
    this.flag = paramJceInputStream.read(this.flag, 7, false);
    this.app_class1 = paramJceInputStream.readString(8, false);
    this.app_class2 = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    if (this.app_name != null) {
      paramJceOutputStream.write(this.app_name, 1);
    }
    paramJceOutputStream.write(this.create_time, 2);
    paramJceOutputStream.write(this.online_time, 3);
    paramJceOutputStream.write(this.click_time, 4);
    if (this.app_icon != null) {
      paramJceOutputStream.write(this.app_icon, 5);
    }
    if (this.detail_url != null) {
      paramJceOutputStream.write(this.detail_url, 6);
    }
    paramJceOutputStream.write(this.flag, 7);
    if (this.app_class1 != null) {
      paramJceOutputStream.write(this.app_class1, 8);
    }
    if (this.app_class2 != null) {
      paramJceOutputStream.write(this.app_class2, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_FAMOUS_BASE.SchoolSingleGameItem
 * JD-Core Version:    0.7.0.1
 */