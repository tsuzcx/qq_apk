package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_CustomPraise
  extends JceStruct
{
  static stcustomPraise cache_customPraise = new stcustomPraise();
  public stcustomPraise customPraise;
  public int iItemId;
  public String strPraisePic = "";
  
  public s_CustomPraise() {}
  
  public s_CustomPraise(int paramInt, String paramString, stcustomPraise paramstcustomPraise)
  {
    this.iItemId = paramInt;
    this.strPraisePic = paramString;
    this.customPraise = paramstcustomPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strPraisePic = paramJceInputStream.readString(1, false);
    this.customPraise = ((stcustomPraise)paramJceInputStream.read(cache_customPraise, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strPraisePic != null) {
      paramJceOutputStream.write(this.strPraisePic, 1);
    }
    if (this.customPraise != null) {
      paramJceOutputStream.write(this.customPraise, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_CustomPraise
 * JD-Core Version:    0.7.0.1
 */