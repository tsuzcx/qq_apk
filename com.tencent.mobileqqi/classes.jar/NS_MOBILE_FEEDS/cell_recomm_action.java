package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_recomm_action
  extends JceStruct
{
  static s_rank cache_s_app_rank;
  static ArrayList cache_userlist;
  public int actiontype = 0;
  public int btn_type = 0;
  public String remark = "";
  public s_rank s_app_rank = null;
  public ArrayList userlist = null;
  
  public cell_recomm_action() {}
  
  public cell_recomm_action(s_rank params_rank, String paramString, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    this.s_app_rank = params_rank;
    this.remark = paramString;
    this.userlist = paramArrayList;
    this.actiontype = paramInt1;
    this.btn_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_s_app_rank == null) {
      cache_s_app_rank = new s_rank();
    }
    this.s_app_rank = ((s_rank)paramJceInputStream.read(cache_s_app_rank, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    if (cache_userlist == null)
    {
      cache_userlist = new ArrayList();
      s_user locals_user = new s_user();
      cache_userlist.add(locals_user);
    }
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.s_app_rank != null) {
      paramJceOutputStream.write(this.s_app_rank, 0);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    paramJceOutputStream.write(this.btn_type, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_action
 * JD-Core Version:    0.7.0.1
 */