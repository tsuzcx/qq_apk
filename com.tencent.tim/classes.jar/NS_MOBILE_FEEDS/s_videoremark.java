package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_videoremark
  extends JceStruct
{
  public int actiontype;
  public String actionurl = "";
  public String icondesc = "";
  public String iconurl = "";
  public int orgwebsite;
  public String remark = "";
  
  public s_videoremark() {}
  
  public s_videoremark(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.iconurl = paramString1;
    this.icondesc = paramString2;
    this.remark = paramString3;
    this.actiontype = paramInt1;
    this.actionurl = paramString4;
    this.orgwebsite = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iconurl = paramJceInputStream.readString(0, false);
    this.icondesc = paramJceInputStream.readString(1, false);
    this.remark = paramJceInputStream.readString(2, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.orgwebsite = paramJceInputStream.read(this.orgwebsite, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 0);
    }
    if (this.icondesc != null) {
      paramJceOutputStream.write(this.icondesc, 1);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 4);
    }
    paramJceOutputStream.write(this.orgwebsite, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_videoremark
 * JD-Core Version:    0.7.0.1
 */