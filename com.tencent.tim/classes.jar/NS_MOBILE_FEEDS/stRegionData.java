package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stRegionData
  extends JceStruct
{
  static stPoints cache_leftTopP = new stPoints();
  static stPoints cache_rightBottomP = new stPoints();
  public int actionType;
  public String actionUrl = "";
  public String backgroundImg = "";
  public stPoints leftTopP;
  public stPoints rightBottomP;
  public int urlShowType;
  
  public stRegionData() {}
  
  public stRegionData(stPoints paramstPoints1, stPoints paramstPoints2, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.leftTopP = paramstPoints1;
    this.rightBottomP = paramstPoints2;
    this.actionType = paramInt1;
    this.actionUrl = paramString1;
    this.urlShowType = paramInt2;
    this.backgroundImg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.leftTopP = ((stPoints)paramJceInputStream.read(cache_leftTopP, 0, false));
    this.rightBottomP = ((stPoints)paramJceInputStream.read(cache_rightBottomP, 1, false));
    this.actionType = paramJceInputStream.read(this.actionType, 2, false);
    this.actionUrl = paramJceInputStream.readString(4, false);
    this.urlShowType = paramJceInputStream.read(this.urlShowType, 5, false);
    this.backgroundImg = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.leftTopP != null) {
      paramJceOutputStream.write(this.leftTopP, 0);
    }
    if (this.rightBottomP != null) {
      paramJceOutputStream.write(this.rightBottomP, 1);
    }
    paramJceOutputStream.write(this.actionType, 2);
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 4);
    }
    paramJceOutputStream.write(this.urlShowType, 5);
    if (this.backgroundImg != null) {
      paramJceOutputStream.write(this.backgroundImg, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stRegionData
 * JD-Core Version:    0.7.0.1
 */