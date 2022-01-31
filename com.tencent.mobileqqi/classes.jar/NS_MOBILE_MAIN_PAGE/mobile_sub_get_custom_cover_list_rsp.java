package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_get_custom_cover_list_rsp
  extends JceStruct
{
  static ArrayList cache_covers;
  public String attachInfo = "";
  public ArrayList covers = null;
  
  public mobile_sub_get_custom_cover_list_rsp() {}
  
  public mobile_sub_get_custom_cover_list_rsp(ArrayList paramArrayList, String paramString)
  {
    this.covers = paramArrayList;
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_covers == null)
    {
      cache_covers = new ArrayList();
      CustomCover localCustomCover = new CustomCover();
      cache_covers.add(localCustomCover);
    }
    this.covers = ((ArrayList)paramJceInputStream.read(cache_covers, 0, false));
    this.attachInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.covers != null) {
      paramJceOutputStream.write(this.covers, 0);
    }
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_custom_cover_list_rsp
 * JD-Core Version:    0.7.0.1
 */