package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MsgBody
  extends JceStruct
{
  static ArrayList<PhotoCell> cache_vecPhotos = new ArrayList();
  static ArrayList<String> cache_vecUserAvatar;
  public String content = "";
  public String contentIcon = "";
  public String coverPicUrl = "";
  public int mediaType;
  public String title = "";
  public ArrayList<PhotoCell> vecPhotos;
  public ArrayList<String> vecUserAvatar;
  
  static
  {
    PhotoCell localPhotoCell = new PhotoCell();
    cache_vecPhotos.add(localPhotoCell);
    cache_vecUserAvatar = new ArrayList();
    cache_vecUserAvatar.add("");
  }
  
  public MsgBody() {}
  
  public MsgBody(int paramInt, String paramString1, String paramString2, ArrayList<PhotoCell> paramArrayList, ArrayList<String> paramArrayList1, String paramString3, String paramString4)
  {
    this.mediaType = paramInt;
    this.title = paramString1;
    this.content = paramString2;
    this.vecPhotos = paramArrayList;
    this.vecUserAvatar = paramArrayList1;
    this.coverPicUrl = paramString3;
    this.contentIcon = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mediaType = paramJceInputStream.read(this.mediaType, 0, false);
    this.title = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.vecPhotos = ((ArrayList)paramJceInputStream.read(cache_vecPhotos, 3, false));
    this.vecUserAvatar = ((ArrayList)paramJceInputStream.read(cache_vecUserAvatar, 4, false));
    this.coverPicUrl = paramJceInputStream.readString(5, false);
    this.contentIcon = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mediaType, 0);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    if (this.vecPhotos != null) {
      paramJceOutputStream.write(this.vecPhotos, 3);
    }
    if (this.vecUserAvatar != null) {
      paramJceOutputStream.write(this.vecUserAvatar, 4);
    }
    if (this.coverPicUrl != null) {
      paramJceOutputStream.write(this.coverPicUrl, 5);
    }
    if (this.contentIcon != null) {
      paramJceOutputStream.write(this.contentIcon, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.MsgBody
 * JD-Core Version:    0.7.0.1
 */