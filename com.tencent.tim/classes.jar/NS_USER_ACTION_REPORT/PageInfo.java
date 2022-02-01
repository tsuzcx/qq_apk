package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PageInfo
  extends JceStruct
{
  static ArrayList<ItemInfo> cache_item_infos = new ArrayList();
  public String appid = "";
  public ArrayList<ItemInfo> item_infos;
  public String page_id = "";
  
  static
  {
    ItemInfo localItemInfo = new ItemInfo();
    cache_item_infos.add(localItemInfo);
  }
  
  public PageInfo() {}
  
  public PageInfo(String paramString1, String paramString2, ArrayList<ItemInfo> paramArrayList)
  {
    this.appid = paramString1;
    this.page_id = paramString2;
    this.item_infos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, true);
    this.page_id = paramJceInputStream.readString(1, true);
    this.item_infos = ((ArrayList)paramJceInputStream.read(cache_item_infos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.page_id, 1);
    if (this.item_infos != null) {
      paramJceOutputStream.write(this.item_infos, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.PageInfo
 * JD-Core Version:    0.7.0.1
 */