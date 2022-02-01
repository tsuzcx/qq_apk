package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_join_list
  extends JceStruct
{
  static ArrayList<s_user> cache_users = new ArrayList();
  public int actionType;
  public String actionUrl = "";
  public String desc = "";
  public int isjoined;
  public int num;
  public ArrayList<s_user> users;
  
  static
  {
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public s_join_list() {}
  
  public s_join_list(int paramInt1, int paramInt2, ArrayList<s_user> paramArrayList, String paramString1, String paramString2, int paramInt3)
  {
    this.num = paramInt1;
    this.isjoined = paramInt2;
    this.users = paramArrayList;
    this.desc = paramString1;
    this.actionUrl = paramString2;
    this.actionType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isjoined = paramJceInputStream.read(this.isjoined, 1, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 2, false));
    this.desc = paramJceInputStream.readString(3, false);
    this.actionUrl = paramJceInputStream.readString(4, false);
    this.actionType = paramJceInputStream.read(this.actionType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isjoined, 1);
    if (this.users != null) {
      paramJceOutputStream.write(this.users, 2);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 3);
    }
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 4);
    }
    paramJceOutputStream.write(this.actionType, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_join_list
 * JD-Core Version:    0.7.0.1
 */