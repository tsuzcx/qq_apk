package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FeedNavi
  extends JceStruct
{
  public int iItemId = -1;
  public String strFeedNaviUrl = "";
  public String strTextColor = "";
  
  public FeedNavi() {}
  
  public FeedNavi(int paramInt, String paramString1, String paramString2)
  {
    this.iItemId = paramInt;
    this.strFeedNaviUrl = paramString1;
    this.strTextColor = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strFeedNaviUrl = paramJceInputStream.readString(1, false);
    this.strTextColor = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strFeedNaviUrl != null) {
      paramJceOutputStream.write(this.strFeedNaviUrl, 1);
    }
    if (this.strTextColor != null) {
      paramJceOutputStream.write(this.strTextColor, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.FeedNavi
 * JD-Core Version:    0.7.0.1
 */