package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_title
  extends JceStruct
{
  static s_user cache_user;
  static ArrayList cache_userlist;
  public int actiontype = 0;
  public String title = "";
  public String titleurl = "";
  public s_user user = null;
  public int useractiontype = 0;
  public ArrayList userlist = null;
  public int usernum = 0;
  
  public cell_title() {}
  
  public cell_title(String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, s_user params_user, int paramInt3)
  {
    this.title = paramString1;
    this.titleurl = paramString2;
    this.userlist = paramArrayList;
    this.usernum = paramInt1;
    this.actiontype = paramInt2;
    this.user = params_user;
    this.useractiontype = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.titleurl = paramJceInputStream.readString(1, false);
    if (cache_userlist == null)
    {
      cache_userlist = new ArrayList();
      s_user locals_user = new s_user();
      cache_userlist.add(locals_user);
    }
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.usernum = paramJceInputStream.read(this.usernum, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 5, false));
    this.useractiontype = paramJceInputStream.read(this.useractiontype, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.titleurl != null) {
      paramJceOutputStream.write(this.titleurl, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.usernum, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 5);
    }
    paramJceOutputStream.write(this.useractiontype, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_title
 * JD-Core Version:    0.7.0.1
 */