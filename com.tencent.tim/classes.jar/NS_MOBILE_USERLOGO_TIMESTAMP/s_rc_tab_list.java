package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_rc_tab_list
  extends JceStruct
{
  static ArrayList<s_rc_tab_info> cache_rc_tab_list = new ArrayList();
  public String rapid_comment_url = "";
  public long rc_commit_pic_size;
  public ArrayList<s_rc_tab_info> rc_tab_list;
  public String rc_zip_name = "";
  public long start_id;
  
  static
  {
    s_rc_tab_info locals_rc_tab_info = new s_rc_tab_info();
    cache_rc_tab_list.add(locals_rc_tab_info);
  }
  
  public s_rc_tab_list() {}
  
  public s_rc_tab_list(String paramString1, long paramLong1, ArrayList<s_rc_tab_info> paramArrayList, String paramString2, long paramLong2)
  {
    this.rapid_comment_url = paramString1;
    this.rc_commit_pic_size = paramLong1;
    this.rc_tab_list = paramArrayList;
    this.rc_zip_name = paramString2;
    this.start_id = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rapid_comment_url = paramJceInputStream.readString(0, false);
    this.rc_commit_pic_size = paramJceInputStream.read(this.rc_commit_pic_size, 1, false);
    this.rc_tab_list = ((ArrayList)paramJceInputStream.read(cache_rc_tab_list, 2, false));
    this.rc_zip_name = paramJceInputStream.readString(3, false);
    this.start_id = paramJceInputStream.read(this.start_id, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rapid_comment_url != null) {
      paramJceOutputStream.write(this.rapid_comment_url, 0);
    }
    paramJceOutputStream.write(this.rc_commit_pic_size, 1);
    if (this.rc_tab_list != null) {
      paramJceOutputStream.write(this.rc_tab_list, 2);
    }
    if (this.rc_zip_name != null) {
      paramJceOutputStream.write(this.rc_zip_name, 3);
    }
    paramJceOutputStream.write(this.start_id, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_list
 * JD-Core Version:    0.7.0.1
 */