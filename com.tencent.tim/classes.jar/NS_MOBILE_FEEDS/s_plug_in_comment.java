package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_plug_in_comment
  extends JceStruct
{
  public int action_type;
  public String action_url = "";
  public int insert_index = -1;
  public String title = "";
  
  public s_plug_in_comment() {}
  
  public s_plug_in_comment(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.title = paramString1;
    this.action_type = paramInt1;
    this.action_url = paramString2;
    this.insert_index = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.action_type = paramJceInputStream.read(this.action_type, 1, false);
    this.action_url = paramJceInputStream.readString(2, false);
    this.insert_index = paramJceInputStream.read(this.insert_index, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    paramJceOutputStream.write(this.action_type, 1);
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 2);
    }
    paramJceOutputStream.write(this.insert_index, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_plug_in_comment
 * JD-Core Version:    0.7.0.1
 */