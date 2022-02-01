package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomVip
  extends JceStruct
{
  static int cache_eCustomVipType = 0;
  public int eCustomVipType;
  public int iItemId = -1;
  public String strGuestJumpUrl = "";
  public String strMasterJumpUrl = "";
  public String strSrcUrl = "";
  
  public QzmallCustomVip() {}
  
  public QzmallCustomVip(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.iItemId = paramInt1;
    this.strSrcUrl = paramString1;
    this.strMasterJumpUrl = paramString2;
    this.strGuestJumpUrl = paramString3;
    this.eCustomVipType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strSrcUrl = paramJceInputStream.readString(1, false);
    this.strMasterJumpUrl = paramJceInputStream.readString(2, false);
    this.strGuestJumpUrl = paramJceInputStream.readString(3, false);
    this.eCustomVipType = paramJceInputStream.read(this.eCustomVipType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strSrcUrl != null) {
      paramJceOutputStream.write(this.strSrcUrl, 1);
    }
    if (this.strMasterJumpUrl != null) {
      paramJceOutputStream.write(this.strMasterJumpUrl, 2);
    }
    if (this.strGuestJumpUrl != null) {
      paramJceOutputStream.write(this.strGuestJumpUrl, 3);
    }
    paramJceOutputStream.write(this.eCustomVipType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomVip
 * JD-Core Version:    0.7.0.1
 */