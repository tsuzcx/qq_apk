package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceInPhotoRsp
  extends JceStruct
{
  static stFaceItem cache_faceitem = new stFaceItem();
  public stFaceItem faceitem;
  public String msg = "";
  public int ret;
  
  public MarkFaceInPhotoRsp() {}
  
  public MarkFaceInPhotoRsp(int paramInt, String paramString, stFaceItem paramstFaceItem)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.faceitem = paramstFaceItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.faceitem = ((stFaceItem)paramJceInputStream.read(cache_faceitem, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.faceitem != null) {
      paramJceOutputStream.write(this.faceitem, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceInPhotoRsp
 * JD-Core Version:    0.7.0.1
 */