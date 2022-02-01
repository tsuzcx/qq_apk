package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_corner_adv
  extends JceStruct
  implements Cloneable
{
  static s_picdata cache_adv_info = new s_picdata();
  static s_picdata cache_feedback_info;
  static s_picdata cache_gif_info = new s_picdata();
  public int actiontype;
  public String actionurl = "";
  public int adv_appear_time;
  public int adv_hold_time;
  public s_picdata adv_info;
  public int feedback_appear_time;
  public s_picdata feedback_info;
  public s_picdata gif_info;
  public int min_video_time;
  public boolean show_corner_adv = true;
  
  static
  {
    cache_feedback_info = new s_picdata();
  }
  
  public cell_corner_adv() {}
  
  public cell_corner_adv(s_picdata params_picdata1, s_picdata params_picdata2, s_picdata params_picdata3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, boolean paramBoolean)
  {
    this.gif_info = params_picdata1;
    this.feedback_info = params_picdata2;
    this.adv_info = params_picdata3;
    this.feedback_appear_time = paramInt1;
    this.adv_appear_time = paramInt2;
    this.adv_hold_time = paramInt3;
    this.min_video_time = paramInt4;
    this.actiontype = paramInt5;
    this.actionurl = paramString;
    this.show_corner_adv = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gif_info = ((s_picdata)paramJceInputStream.read(cache_gif_info, 0, false));
    this.feedback_info = ((s_picdata)paramJceInputStream.read(cache_feedback_info, 1, false));
    this.adv_info = ((s_picdata)paramJceInputStream.read(cache_adv_info, 2, false));
    this.feedback_appear_time = paramJceInputStream.read(this.feedback_appear_time, 3, false);
    this.adv_appear_time = paramJceInputStream.read(this.adv_appear_time, 4, false);
    this.adv_hold_time = paramJceInputStream.read(this.adv_hold_time, 5, false);
    this.min_video_time = paramJceInputStream.read(this.min_video_time, 6, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 7, false);
    this.actionurl = paramJceInputStream.readString(8, false);
    this.show_corner_adv = paramJceInputStream.read(this.show_corner_adv, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.gif_info != null) {
      paramJceOutputStream.write(this.gif_info, 0);
    }
    if (this.feedback_info != null) {
      paramJceOutputStream.write(this.feedback_info, 1);
    }
    if (this.adv_info != null) {
      paramJceOutputStream.write(this.adv_info, 2);
    }
    paramJceOutputStream.write(this.feedback_appear_time, 3);
    paramJceOutputStream.write(this.adv_appear_time, 4);
    paramJceOutputStream.write(this.adv_hold_time, 5);
    paramJceOutputStream.write(this.min_video_time, 6);
    paramJceOutputStream.write(this.actiontype, 7);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 8);
    }
    paramJceOutputStream.write(this.show_corner_adv, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_corner_adv
 * JD-Core Version:    0.7.0.1
 */