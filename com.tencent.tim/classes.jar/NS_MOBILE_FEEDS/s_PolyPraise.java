package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_PolyPraise
  extends JceStruct
{
  public int iItemId;
  public int itype;
  public int pokeLikeCombo;
  public int resourceId;
  public String strPicUrl = "";
  public String strText = "";
  
  public s_PolyPraise() {}
  
  public s_PolyPraise(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iItemId = paramInt1;
    this.strPicUrl = paramString1;
    this.strText = paramString2;
    this.itype = paramInt2;
    this.resourceId = paramInt3;
    this.pokeLikeCombo = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strPicUrl = paramJceInputStream.readString(1, false);
    this.strText = paramJceInputStream.readString(2, false);
    this.itype = paramJceInputStream.read(this.itype, 3, false);
    this.resourceId = paramJceInputStream.read(this.resourceId, 4, false);
    this.pokeLikeCombo = paramJceInputStream.read(this.pokeLikeCombo, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strPicUrl != null) {
      paramJceOutputStream.write(this.strPicUrl, 1);
    }
    if (this.strText != null) {
      paramJceOutputStream.write(this.strText, 2);
    }
    paramJceOutputStream.write(this.itype, 3);
    paramJceOutputStream.write(this.resourceId, 4);
    paramJceOutputStream.write(this.pokeLikeCombo, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_PolyPraise
 * JD-Core Version:    0.7.0.1
 */