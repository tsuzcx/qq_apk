package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomAlbumItem
  extends JceStruct
{
  static MaterialFile cache_stBgImage = new MaterialFile();
  static MaterialFile cache_stBgImageClick = new MaterialFile();
  static MaterialFile cache_stH5BgImage = new MaterialFile();
  static MaterialFile cache_stLeftImage = new MaterialFile();
  static MaterialFile cache_stRightImage = new MaterialFile();
  public int iAlignment;
  public int iContentWidth;
  public int iDiameter;
  public int iItemType;
  public int iLargeFontSize;
  public int iMarginTop;
  public int iMiddleFontSize;
  public int iSmallFontSize;
  public long iTextColor;
  public long iTextColorClick;
  public MaterialFile stBgImage;
  public MaterialFile stBgImageClick;
  public MaterialFile stH5BgImage;
  public MaterialFile stLeftImage;
  public MaterialFile stRightImage;
  
  public CustomAlbumItem() {}
  
  public CustomAlbumItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, int paramInt6, MaterialFile paramMaterialFile3, MaterialFile paramMaterialFile4, int paramInt7, int paramInt8, MaterialFile paramMaterialFile5)
  {
    this.iItemType = paramInt1;
    this.iAlignment = paramInt2;
    this.iLargeFontSize = paramInt3;
    this.iMiddleFontSize = paramInt4;
    this.iSmallFontSize = paramInt5;
    this.iTextColor = paramLong1;
    this.iTextColorClick = paramLong2;
    this.stBgImage = paramMaterialFile1;
    this.stBgImageClick = paramMaterialFile2;
    this.iMarginTop = paramInt6;
    this.stLeftImage = paramMaterialFile3;
    this.stRightImage = paramMaterialFile4;
    this.iDiameter = paramInt7;
    this.iContentWidth = paramInt8;
    this.stH5BgImage = paramMaterialFile5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemType = paramJceInputStream.read(this.iItemType, 0, true);
    this.iAlignment = paramJceInputStream.read(this.iAlignment, 1, false);
    this.iLargeFontSize = paramJceInputStream.read(this.iLargeFontSize, 2, false);
    this.iMiddleFontSize = paramJceInputStream.read(this.iMiddleFontSize, 3, false);
    this.iSmallFontSize = paramJceInputStream.read(this.iSmallFontSize, 4, false);
    this.iTextColor = paramJceInputStream.read(this.iTextColor, 5, false);
    this.iTextColorClick = paramJceInputStream.read(this.iTextColorClick, 6, false);
    this.stBgImage = ((MaterialFile)paramJceInputStream.read(cache_stBgImage, 7, false));
    this.stBgImageClick = ((MaterialFile)paramJceInputStream.read(cache_stBgImageClick, 8, false));
    this.iMarginTop = paramJceInputStream.read(this.iMarginTop, 9, false);
    this.stLeftImage = ((MaterialFile)paramJceInputStream.read(cache_stLeftImage, 10, false));
    this.stRightImage = ((MaterialFile)paramJceInputStream.read(cache_stRightImage, 11, false));
    this.iDiameter = paramJceInputStream.read(this.iDiameter, 12, false);
    this.iContentWidth = paramJceInputStream.read(this.iContentWidth, 13, false);
    this.stH5BgImage = ((MaterialFile)paramJceInputStream.read(cache_stH5BgImage, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemType, 0);
    paramJceOutputStream.write(this.iAlignment, 1);
    paramJceOutputStream.write(this.iLargeFontSize, 2);
    paramJceOutputStream.write(this.iMiddleFontSize, 3);
    paramJceOutputStream.write(this.iSmallFontSize, 4);
    paramJceOutputStream.write(this.iTextColor, 5);
    paramJceOutputStream.write(this.iTextColorClick, 6);
    if (this.stBgImage != null) {
      paramJceOutputStream.write(this.stBgImage, 7);
    }
    if (this.stBgImageClick != null) {
      paramJceOutputStream.write(this.stBgImageClick, 8);
    }
    paramJceOutputStream.write(this.iMarginTop, 9);
    if (this.stLeftImage != null) {
      paramJceOutputStream.write(this.stLeftImage, 10);
    }
    if (this.stRightImage != null) {
      paramJceOutputStream.write(this.stRightImage, 11);
    }
    paramJceOutputStream.write(this.iDiameter, 12);
    paramJceOutputStream.write(this.iContentWidth, 13);
    if (this.stH5BgImage != null) {
      paramJceOutputStream.write(this.stH5BgImage, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomAlbumItem
 * JD-Core Version:    0.7.0.1
 */