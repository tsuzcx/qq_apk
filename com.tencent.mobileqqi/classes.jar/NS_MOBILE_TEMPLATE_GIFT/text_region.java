package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class text_region
  extends JceStruct
{
  public int height = 0;
  public int width = 0;
  public int x = 0;
  public int y = 0;
  
  public text_region() {}
  
  public text_region(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x = paramJceInputStream.read(this.x, 0, true);
    this.y = paramJceInputStream.read(this.y, 1, true);
    this.width = paramJceInputStream.read(this.width, 2, true);
    this.height = paramJceInputStream.read(this.height, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x, 0);
    paramJceOutputStream.write(this.y, 1);
    paramJceOutputStream.write(this.width, 2);
    paramJceOutputStream.write(this.height, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.text_region
 * JD-Core Version:    0.7.0.1
 */