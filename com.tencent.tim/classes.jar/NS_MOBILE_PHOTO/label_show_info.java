package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class label_show_info
  extends JceStruct
{
  static ArrayList<String> cache_labelids = new ArrayList();
  public String label = "";
  public ArrayList<String> labelids;
  
  static
  {
    cache_labelids.add("");
  }
  
  public label_show_info() {}
  
  public label_show_info(String paramString, ArrayList<String> paramArrayList)
  {
    this.label = paramString;
    this.labelids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.label = paramJceInputStream.readString(0, false);
    this.labelids = ((ArrayList)paramJceInputStream.read(cache_labelids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 0);
    }
    if (this.labelids != null) {
      paramJceOutputStream.write(this.labelids, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.label_show_info
 * JD-Core Version:    0.7.0.1
 */