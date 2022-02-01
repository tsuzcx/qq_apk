package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class get_app_info_list
  extends JceStruct
{
  static ArrayList<s_app_info> cache_applist;
  public ArrayList<s_app_info> applist;
  public int serial;
  
  public get_app_info_list() {}
  
  public get_app_info_list(ArrayList<s_app_info> paramArrayList, int paramInt)
  {
    this.applist = paramArrayList;
    this.serial = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_applist == null)
    {
      cache_applist = new ArrayList();
      s_app_info locals_app_info = new s_app_info();
      cache_applist.add(locals_app_info);
    }
    this.applist = ((ArrayList)paramJceInputStream.read(cache_applist, 0, true));
    this.serial = paramJceInputStream.read(this.serial, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.applist, 0);
    paramJceOutputStream.write(this.serial, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.get_app_info_list
 * JD-Core Version:    0.7.0.1
 */