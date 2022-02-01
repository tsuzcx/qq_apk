package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFollowFeedsReq
  extends JceStruct
{
  public String attatch_info = "";
  public boolean is_first = true;
  public boolean is_refresh = true;
  public String push_info = "";
  public int scene;
  
  public stFollowFeedsReq() {}
  
  public stFollowFeedsReq(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    this.attatch_info = paramString1;
    this.is_refresh = paramBoolean1;
    this.is_first = paramBoolean2;
    this.push_info = paramString2;
    this.scene = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attatch_info = paramJceInputStream.readString(0, false);
    this.is_refresh = paramJceInputStream.read(this.is_refresh, 1, false);
    this.is_first = paramJceInputStream.read(this.is_first, 2, false);
    this.push_info = paramJceInputStream.readString(3, false);
    this.scene = paramJceInputStream.read(this.scene, 4, false);
  }
  
  public String toString()
  {
    return "stFollowFeedsReq{attatch_info='" + this.attatch_info + '\'' + ", is_refresh=" + this.is_refresh + ", is_first=" + this.is_first + ", push_info='" + this.push_info + '\'' + ", scene=" + this.scene + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attatch_info != null) {
      paramJceOutputStream.write(this.attatch_info, 0);
    }
    paramJceOutputStream.write(this.is_refresh, 1);
    paramJceOutputStream.write(this.is_first, 2);
    if (this.push_info != null) {
      paramJceOutputStream.write(this.push_info, 3);
    }
    paramJceOutputStream.write(this.scene, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stFollowFeedsReq
 * JD-Core Version:    0.7.0.1
 */