package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_persion_center_info
  extends JceStruct
{
  public long newcover = 0L;
  public long newtheme = 0L;
  public long newwidgt = 0L;
  
  public s_persion_center_info() {}
  
  public s_persion_center_info(long paramLong1, long paramLong2, long paramLong3)
  {
    this.newtheme = paramLong1;
    this.newcover = paramLong2;
    this.newwidgt = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.newtheme = paramJceInputStream.read(this.newtheme, 0, false);
    this.newcover = paramJceInputStream.read(this.newcover, 1, false);
    this.newwidgt = paramJceInputStream.read(this.newwidgt, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.newtheme, 0);
    paramJceOutputStream.write(this.newcover, 1);
    paramJceOutputStream.write(this.newwidgt, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_persion_center_info
 * JD-Core Version:    0.7.0.1
 */