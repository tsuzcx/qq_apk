package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class send_common_gift_rsp
  extends JceStruct
{
  static ArrayList cache_failList;
  public ArrayList failList = null;
  
  public send_common_gift_rsp() {}
  
  public send_common_gift_rsp(ArrayList paramArrayList)
  {
    this.failList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_failList == null)
    {
      cache_failList = new ArrayList();
      send_gift_fail_item localsend_gift_fail_item = new send_gift_fail_item();
      cache_failList.add(localsend_gift_fail_item);
    }
    this.failList = ((ArrayList)paramJceInputStream.read(cache_failList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.failList != null) {
      paramJceOutputStream.write(this.failList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_common_gift_rsp
 * JD-Core Version:    0.7.0.1
 */