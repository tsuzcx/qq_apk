package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_rc_tab_info
  extends JceStruct
{
  static ArrayList<Long> cache_expression_list;
  public ArrayList<Long> expression_list;
  public String tab_icon_url = "";
  public long tab_id;
  public String zip_md5_value = "";
  
  public s_rc_tab_info() {}
  
  public s_rc_tab_info(long paramLong, String paramString1, ArrayList<Long> paramArrayList, String paramString2)
  {
    this.tab_id = paramLong;
    this.tab_icon_url = paramString1;
    this.expression_list = paramArrayList;
    this.zip_md5_value = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tab_id = paramJceInputStream.read(this.tab_id, 0, false);
    this.tab_icon_url = paramJceInputStream.readString(1, false);
    if (cache_expression_list == null)
    {
      cache_expression_list = new ArrayList();
      cache_expression_list.add(Long.valueOf(0L));
    }
    this.expression_list = ((ArrayList)paramJceInputStream.read(cache_expression_list, 2, false));
    this.zip_md5_value = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tab_id, 0);
    if (this.tab_icon_url != null) {
      paramJceOutputStream.write(this.tab_icon_url, 1);
    }
    if (this.expression_list != null) {
      paramJceOutputStream.write(this.expression_list, 2);
    }
    if (this.zip_md5_value != null) {
      paramJceOutputStream.write(this.zip_md5_value, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_info
 * JD-Core Version:    0.7.0.1
 */