package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_flower
  extends JceStruct
{
  public long count = 0L;
  public String flowericonurl = "";
  public String update_desc = "";
  
  public s_flower() {}
  
  public s_flower(long paramLong, String paramString1, String paramString2)
  {
    this.count = paramLong;
    this.flowericonurl = paramString1;
    this.update_desc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.count = paramJceInputStream.read(this.count, 0, false);
    this.flowericonurl = paramJceInputStream.readString(1, false);
    this.update_desc = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.count, 0);
    if (this.flowericonurl != null) {
      paramJceOutputStream.write(this.flowericonurl, 1);
    }
    if (this.update_desc != null) {
      paramJceOutputStream.write(this.update_desc, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_flower
 * JD-Core Version:    0.7.0.1
 */