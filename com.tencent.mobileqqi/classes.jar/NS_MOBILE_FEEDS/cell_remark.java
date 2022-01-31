package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_remark
  extends JceStruct
{
  static s_shoot_info cache_shoot_info;
  public String remark = "";
  public String remark_down = "";
  public String remark_up = "";
  public s_shoot_info shoot_info = null;
  public int time = 0;
  
  public cell_remark() {}
  
  public cell_remark(String paramString1, String paramString2, String paramString3, int paramInt, s_shoot_info params_shoot_info)
  {
    this.remark = paramString1;
    this.remark_up = paramString2;
    this.remark_down = paramString3;
    this.time = paramInt;
    this.shoot_info = params_shoot_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.remark = paramJceInputStream.readString(0, false);
    this.remark_up = paramJceInputStream.readString(1, false);
    this.remark_down = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    if (cache_shoot_info == null) {
      cache_shoot_info = new s_shoot_info();
    }
    this.shoot_info = ((s_shoot_info)paramJceInputStream.read(cache_shoot_info, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 0);
    }
    if (this.remark_up != null) {
      paramJceOutputStream.write(this.remark_up, 1);
    }
    if (this.remark_down != null) {
      paramJceOutputStream.write(this.remark_down, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    if (this.shoot_info != null) {
      paramJceOutputStream.write(this.shoot_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_remark
 * JD-Core Version:    0.7.0.1
 */