package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_comment
  extends JceStruct
{
  static ArrayList cache_commments;
  static s_commment cache_main_comment;
  public ArrayList commments = null;
  public s_commment main_comment = null;
  public int num = 0;
  
  public cell_comment() {}
  
  public cell_comment(int paramInt, ArrayList paramArrayList, s_commment params_commment)
  {
    this.num = paramInt;
    this.commments = paramArrayList;
    this.main_comment = params_commment;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    if (cache_commments == null)
    {
      cache_commments = new ArrayList();
      s_commment locals_commment = new s_commment();
      cache_commments.add(locals_commment);
    }
    this.commments = ((ArrayList)paramJceInputStream.read(cache_commments, 1, false));
    if (cache_main_comment == null) {
      cache_main_comment = new s_commment();
    }
    this.main_comment = ((s_commment)paramJceInputStream.read(cache_main_comment, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.commments != null) {
      paramJceOutputStream.write(this.commments, 1);
    }
    if (this.main_comment != null) {
      paramJceOutputStream.write(this.main_comment, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comment
 * JD-Core Version:    0.7.0.1
 */