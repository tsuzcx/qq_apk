package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CustomAlbumTemplate
  extends JceStruct
{
  static MaterialFile cache_stTmpBgImageLarge = new MaterialFile();
  static MaterialFile cache_stTmpBgImageMiddle = new MaterialFile();
  static MaterialFile cache_stTmpBgImageSmall = new MaterialFile();
  static ArrayList<CustomAlbumItem> cache_vecItems = new ArrayList();
  static ArrayList<PhotoFrameView> cache_vecPhotoFrameView;
  public MaterialFile stTmpBgImageLarge;
  public MaterialFile stTmpBgImageMiddle;
  public MaterialFile stTmpBgImageSmall;
  public ArrayList<CustomAlbumItem> vecItems;
  public ArrayList<PhotoFrameView> vecPhotoFrameView;
  
  static
  {
    Object localObject = new CustomAlbumItem();
    cache_vecItems.add(localObject);
    cache_vecPhotoFrameView = new ArrayList();
    localObject = new PhotoFrameView();
    cache_vecPhotoFrameView.add(localObject);
  }
  
  public CustomAlbumTemplate() {}
  
  public CustomAlbumTemplate(MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, MaterialFile paramMaterialFile3, ArrayList<CustomAlbumItem> paramArrayList, ArrayList<PhotoFrameView> paramArrayList1)
  {
    this.stTmpBgImageLarge = paramMaterialFile1;
    this.stTmpBgImageMiddle = paramMaterialFile2;
    this.stTmpBgImageSmall = paramMaterialFile3;
    this.vecItems = paramArrayList;
    this.vecPhotoFrameView = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stTmpBgImageLarge = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageLarge, 0, false));
    this.stTmpBgImageMiddle = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageMiddle, 1, false));
    this.stTmpBgImageSmall = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageSmall, 2, false));
    this.vecItems = ((ArrayList)paramJceInputStream.read(cache_vecItems, 3, false));
    this.vecPhotoFrameView = ((ArrayList)paramJceInputStream.read(cache_vecPhotoFrameView, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stTmpBgImageLarge != null) {
      paramJceOutputStream.write(this.stTmpBgImageLarge, 0);
    }
    if (this.stTmpBgImageMiddle != null) {
      paramJceOutputStream.write(this.stTmpBgImageMiddle, 1);
    }
    if (this.stTmpBgImageSmall != null) {
      paramJceOutputStream.write(this.stTmpBgImageSmall, 2);
    }
    if (this.vecItems != null) {
      paramJceOutputStream.write(this.vecItems, 3);
    }
    if (this.vecPhotoFrameView != null) {
      paramJceOutputStream.write(this.vecPhotoFrameView, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomAlbumTemplate
 * JD-Core Version:    0.7.0.1
 */