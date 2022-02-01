package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class category_info
  extends JceStruct
{
  public int categoryId;
  public String name = "";
  
  public category_info() {}
  
  public category_info(String paramString, int paramInt)
  {
    this.name = paramString;
    this.categoryId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, true);
    this.categoryId = paramJceInputStream.read(this.categoryId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.name, 0);
    paramJceOutputStream.write(this.categoryId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.category_info
 * JD-Core Version:    0.7.0.1
 */