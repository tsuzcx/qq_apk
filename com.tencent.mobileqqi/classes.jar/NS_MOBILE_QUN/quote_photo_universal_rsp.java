package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class quote_photo_universal_rsp
  extends JceStruct
{
  static ArrayList cache_url;
  public String msg = "";
  public int ret = 0;
  public ArrayList url = null;
  
  public quote_photo_universal_rsp() {}
  
  public quote_photo_universal_rsp(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.url = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_url == null)
    {
      cache_url = new ArrayList();
      cache_url.add("");
    }
    this.url = ((ArrayList)paramJceInputStream.read(cache_url, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.quote_photo_universal_rsp
 * JD-Core Version:    0.7.0.1
 */