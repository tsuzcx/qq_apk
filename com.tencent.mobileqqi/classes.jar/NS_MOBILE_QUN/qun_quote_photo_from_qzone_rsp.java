package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_quote_photo_from_qzone_rsp
  extends JceStruct
{
  static ArrayList cache_url;
  public ArrayList url = null;
  
  public qun_quote_photo_from_qzone_rsp() {}
  
  public qun_quote_photo_from_qzone_rsp(ArrayList paramArrayList)
  {
    this.url = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_url == null)
    {
      cache_url = new ArrayList();
      cache_url.add("");
    }
    this.url = ((ArrayList)paramJceInputStream.read(cache_url, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_quote_photo_from_qzone_rsp
 * JD-Core Version:    0.7.0.1
 */