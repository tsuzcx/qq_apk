package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_pic_text
  extends JceStruct
{
  static ArrayList<st_pic_text> cache_data_list = new ArrayList();
  public ArrayList<st_pic_text> data_list;
  public int data_num;
  
  static
  {
    st_pic_text localst_pic_text = new st_pic_text();
    cache_data_list.add(localst_pic_text);
  }
  
  public cell_pic_text() {}
  
  public cell_pic_text(int paramInt, ArrayList<st_pic_text> paramArrayList)
  {
    this.data_num = paramInt;
    this.data_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data_num = paramJceInputStream.read(this.data_num, 0, false);
    this.data_list = ((ArrayList)paramJceInputStream.read(cache_data_list, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data_num, 0);
    if (this.data_list != null) {
      paramJceOutputStream.write(this.data_list, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_pic_text
 * JD-Core Version:    0.7.0.1
 */