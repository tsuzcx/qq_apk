package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVideoTag
  extends JceStruct
{
  public String bgColor = "";
  public String imgUrl = "";
  public int tagId;
  public String text = "";
  public String textColor = "";
  
  public stVideoTag() {}
  
  public stVideoTag(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.tagId = paramInt;
    this.imgUrl = paramString1;
    this.text = paramString2;
    this.textColor = paramString3;
    this.bgColor = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tagId = paramJceInputStream.read(this.tagId, 0, false);
    this.imgUrl = paramJceInputStream.readString(1, false);
    this.text = paramJceInputStream.readString(2, false);
    this.textColor = paramJceInputStream.readString(3, false);
    this.bgColor = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tagId, 0);
    if (this.imgUrl != null) {
      paramJceOutputStream.write(this.imgUrl, 1);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 2);
    }
    if (this.textColor != null) {
      paramJceOutputStream.write(this.textColor, 3);
    }
    if (this.bgColor != null) {
      paramJceOutputStream.write(this.bgColor, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stVideoTag
 * JD-Core Version:    0.7.0.1
 */