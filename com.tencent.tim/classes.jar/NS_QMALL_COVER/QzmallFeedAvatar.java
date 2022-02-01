package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallFeedAvatar
  extends JceStruct
{
  static int cache_eAvatarType = 0;
  public int eAvatarType = 1;
  public int iItemId = -1;
  public String strAvatarJumpUrl = "";
  public String strAvatarUrl = "";
  
  public QzmallFeedAvatar() {}
  
  public QzmallFeedAvatar(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.iItemId = paramInt1;
    this.strAvatarUrl = paramString1;
    this.strAvatarJumpUrl = paramString2;
    this.eAvatarType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strAvatarUrl = paramJceInputStream.readString(1, false);
    this.strAvatarJumpUrl = paramJceInputStream.readString(2, false);
    this.eAvatarType = paramJceInputStream.read(this.eAvatarType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strAvatarUrl != null) {
      paramJceOutputStream.write(this.strAvatarUrl, 1);
    }
    if (this.strAvatarJumpUrl != null) {
      paramJceOutputStream.write(this.strAvatarJumpUrl, 2);
    }
    paramJceOutputStream.write(this.eAvatarType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallFeedAvatar
 * JD-Core Version:    0.7.0.1
 */