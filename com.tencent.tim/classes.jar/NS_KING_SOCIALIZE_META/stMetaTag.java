package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaTag
  extends JceStruct
{
  public String iconUrl = "";
  public String jumpurl = "";
  public int tag_type;
  public String title = "";
  
  public stMetaTag() {}
  
  public stMetaTag(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.title = paramString1;
    this.jumpurl = paramString2;
    this.tag_type = paramInt;
    this.iconUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.jumpurl = paramJceInputStream.readString(1, false);
    this.tag_type = paramJceInputStream.read(this.tag_type, 2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
  }
  
  public String toString()
  {
    return "{title='" + this.title + '\'' + ", jumpurl='" + this.jumpurl + '\'' + ", tag_type=" + this.tag_type + ", iconUrl='" + this.iconUrl + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 1);
    }
    paramJceOutputStream.write(this.tag_type, 2);
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaTag
 * JD-Core Version:    0.7.0.1
 */