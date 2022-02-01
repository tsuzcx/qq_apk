package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCategoryDetailReqItem
  extends JceStruct
{
  static int cache_type = 0;
  public String categoryid = "";
  public String page_str = "";
  public int type = 1;
  
  public GetCategoryDetailReqItem() {}
  
  public GetCategoryDetailReqItem(String paramString1, String paramString2, int paramInt)
  {
    this.categoryid = paramString1;
    this.page_str = paramString2;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.categoryid = paramJceInputStream.readString(0, false);
    this.page_str = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 0);
    }
    if (this.page_str != null) {
      paramJceOutputStream.write(this.page_str, 1);
    }
    paramJceOutputStream.write(this.type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetCategoryDetailReqItem
 * JD-Core Version:    0.7.0.1
 */