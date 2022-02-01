package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_event_tags_req
  extends JceStruct
{
  public String content = "";
  public int count;
  public int recom_type;
  
  public mobile_event_tags_req() {}
  
  public mobile_event_tags_req(int paramInt1, String paramString, int paramInt2)
  {
    this.count = paramInt1;
    this.content = paramString;
    this.recom_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.count = paramJceInputStream.read(this.count, 0, false);
    this.content = paramJceInputStream.readString(1, false);
    this.recom_type = paramJceInputStream.read(this.recom_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.count, 0);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 1);
    }
    paramJceOutputStream.write(this.recom_type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_event_tags_req
 * JD-Core Version:    0.7.0.1
 */