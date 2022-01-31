package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_recomm_header
  extends JceStruct
{
  public byte btn_type = 0;
  public String left_title = "";
  public String right_title = "";
  
  public cell_recomm_header() {}
  
  public cell_recomm_header(String paramString1, byte paramByte, String paramString2)
  {
    this.left_title = paramString1;
    this.btn_type = paramByte;
    this.right_title = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.left_title = paramJceInputStream.readString(0, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 1, false);
    this.right_title = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.left_title != null) {
      paramJceOutputStream.write(this.left_title, 0);
    }
    paramJceOutputStream.write(this.btn_type, 1);
    if (this.right_title != null) {
      paramJceOutputStream.write(this.right_title, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_header
 * JD-Core Version:    0.7.0.1
 */