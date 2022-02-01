package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class template_gift_item
  extends JceStruct
{
  static text_region cache_textRegion;
  public String backgroundImg = "";
  public boolean canDIY = true;
  public String defaultImg = "";
  public int disableVoice;
  public String fontColor = "";
  public int fontSize;
  public long id;
  public int lineSpace;
  public String name = "";
  public String previewImg = "";
  public String remark = "";
  public text_region textRegion;
  
  public template_gift_item() {}
  
  public template_gift_item(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, text_region paramtext_region, boolean paramBoolean, int paramInt1, int paramInt2, String paramString6, int paramInt3)
  {
    this.id = paramLong;
    this.name = paramString1;
    this.remark = paramString2;
    this.previewImg = paramString3;
    this.defaultImg = paramString4;
    this.backgroundImg = paramString5;
    this.textRegion = paramtext_region;
    this.canDIY = paramBoolean;
    this.lineSpace = paramInt1;
    this.fontSize = paramInt2;
    this.fontColor = paramString6;
    this.disableVoice = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.remark = paramJceInputStream.readString(2, true);
    this.previewImg = paramJceInputStream.readString(3, true);
    this.defaultImg = paramJceInputStream.readString(4, true);
    this.backgroundImg = paramJceInputStream.readString(5, true);
    if (cache_textRegion == null) {
      cache_textRegion = new text_region();
    }
    this.textRegion = ((text_region)paramJceInputStream.read(cache_textRegion, 6, true));
    this.canDIY = paramJceInputStream.read(this.canDIY, 7, true);
    this.lineSpace = paramJceInputStream.read(this.lineSpace, 8, true);
    this.fontSize = paramJceInputStream.read(this.fontSize, 9, true);
    this.fontColor = paramJceInputStream.readString(10, true);
    this.disableVoice = paramJceInputStream.read(this.disableVoice, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.remark, 2);
    paramJceOutputStream.write(this.previewImg, 3);
    paramJceOutputStream.write(this.defaultImg, 4);
    paramJceOutputStream.write(this.backgroundImg, 5);
    paramJceOutputStream.write(this.textRegion, 6);
    paramJceOutputStream.write(this.canDIY, 7);
    paramJceOutputStream.write(this.lineSpace, 8);
    paramJceOutputStream.write(this.fontSize, 9);
    paramJceOutputStream.write(this.fontColor, 10);
    paramJceOutputStream.write(this.disableVoice, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_item
 * JD-Core Version:    0.7.0.1
 */