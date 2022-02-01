package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stShareBody
  extends JceStruct
{
  public String desc = "";
  public String image_url = "";
  public String title = "";
  
  public stShareBody() {}
  
  public stShareBody(String paramString1, String paramString2, String paramString3)
  {
    this.title = paramString1;
    this.desc = paramString2;
    this.image_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.image_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.image_url != null) {
      paramJceOutputStream.write(this.image_url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stShareBody
 * JD-Core Version:    0.7.0.1
 */