package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class template_gift_type_list_req
  extends JceStruct
{
  static int cache_type;
  public int num = 0;
  public int page = 0;
  public int type = 0;
  
  public template_gift_type_list_req() {}
  
  public template_gift_type_list_req(int paramInt1, int paramInt2, int paramInt3)
  {
    this.page = paramInt1;
    this.num = paramInt2;
    this.type = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.page = paramJceInputStream.read(this.page, 0, true);
    this.num = paramJceInputStream.read(this.num, 1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.page, 0);
    paramJceOutputStream.write(this.num, 1);
    paramJceOutputStream.write(this.type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_type_list_req
 * JD-Core Version:    0.7.0.1
 */