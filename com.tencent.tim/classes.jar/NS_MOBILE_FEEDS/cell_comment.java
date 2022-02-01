package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_comment
  extends JceStruct
{
  static ArrayList<s_commment> cache_commments = new ArrayList();
  static s_commment cache_main_comment = new s_commment();
  static s_plug_in_comment cache_plug_in_info = new s_plug_in_comment();
  public int actiontype;
  public ArrayList<s_commment> commments;
  public int displayflag;
  public int iRealCount;
  public s_commment main_comment;
  public int num;
  public s_plug_in_comment plug_in_info;
  public int unreadCnt;
  
  static
  {
    s_commment locals_commment = new s_commment();
    cache_commments.add(locals_commment);
  }
  
  public cell_comment() {}
  
  public cell_comment(int paramInt1, ArrayList<s_commment> paramArrayList, s_commment params_commment, int paramInt2, int paramInt3, int paramInt4, int paramInt5, s_plug_in_comment params_plug_in_comment)
  {
    this.num = paramInt1;
    this.commments = paramArrayList;
    this.main_comment = params_commment;
    this.unreadCnt = paramInt2;
    this.actiontype = paramInt3;
    this.iRealCount = paramInt4;
    this.displayflag = paramInt5;
    this.plug_in_info = params_plug_in_comment;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.commments = ((ArrayList)paramJceInputStream.read(cache_commments, 1, false));
    this.main_comment = ((s_commment)paramJceInputStream.read(cache_main_comment, 2, false));
    this.unreadCnt = paramJceInputStream.read(this.unreadCnt, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.iRealCount = paramJceInputStream.read(this.iRealCount, 5, false);
    this.displayflag = paramJceInputStream.read(this.displayflag, 6, false);
    this.plug_in_info = ((s_plug_in_comment)paramJceInputStream.read(cache_plug_in_info, 7, false));
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
    paramJceOutputStream.write(this.unreadCnt, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    paramJceOutputStream.write(this.iRealCount, 5);
    paramJceOutputStream.write(this.displayflag, 6);
    if (this.plug_in_info != null) {
      paramJceOutputStream.write(this.plug_in_info, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comment
 * JD-Core Version:    0.7.0.1
 */