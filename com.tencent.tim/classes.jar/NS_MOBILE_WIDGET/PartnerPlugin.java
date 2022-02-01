package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PartnerPlugin
  extends JceStruct
{
  public String gameurl = "";
  public String iconurl = "";
  public String text1 = "";
  public String text2 = "";
  
  public PartnerPlugin() {}
  
  public PartnerPlugin(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.gameurl = paramString1;
    this.iconurl = paramString2;
    this.text1 = paramString3;
    this.text2 = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gameurl = paramJceInputStream.readString(0, false);
    this.iconurl = paramJceInputStream.readString(1, false);
    this.text1 = paramJceInputStream.readString(2, false);
    this.text2 = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.gameurl != null) {
      paramJceOutputStream.write(this.gameurl, 0);
    }
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 1);
    }
    if (this.text1 != null) {
      paramJceOutputStream.write(this.text1, 2);
    }
    if (this.text2 != null) {
      paramJceOutputStream.write(this.text2, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.PartnerPlugin
 * JD-Core Version:    0.7.0.1
 */