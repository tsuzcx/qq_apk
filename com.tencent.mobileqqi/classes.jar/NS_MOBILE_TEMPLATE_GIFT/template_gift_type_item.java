package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class template_gift_type_item
  extends JceStruct
{
  static ArrayList cache_diy_gift_list;
  public ArrayList diy_gift_list = null;
  public long item_type_id = 0L;
  public String name = "";
  public int total = 0;
  
  public template_gift_type_item() {}
  
  public template_gift_type_item(long paramLong, String paramString, ArrayList paramArrayList, int paramInt)
  {
    this.item_type_id = paramLong;
    this.name = paramString;
    this.diy_gift_list = paramArrayList;
    this.total = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item_type_id = paramJceInputStream.read(this.item_type_id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    if (cache_diy_gift_list == null)
    {
      cache_diy_gift_list = new ArrayList();
      template_gift_item localtemplate_gift_item = new template_gift_item();
      cache_diy_gift_list.add(localtemplate_gift_item);
    }
    this.diy_gift_list = ((ArrayList)paramJceInputStream.read(cache_diy_gift_list, 2, true));
    this.total = paramJceInputStream.read(this.total, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.item_type_id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.diy_gift_list, 2);
    paramJceOutputStream.write(this.total, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_type_item
 * JD-Core Version:    0.7.0.1
 */