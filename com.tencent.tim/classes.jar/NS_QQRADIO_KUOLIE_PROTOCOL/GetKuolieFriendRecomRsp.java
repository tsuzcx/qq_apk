package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetKuolieFriendRecomRsp
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  static SimpleKuolieRoomInfo cache_roomInfo = new SimpleKuolieRoomInfo();
  static ArrayList<User> cache_userList = new ArrayList();
  public CommonInfo commInfo;
  public SimpleKuolieRoomInfo roomInfo;
  public ArrayList<User> userList;
  
  static
  {
    User localUser = new User();
    cache_userList.add(localUser);
  }
  
  public GetKuolieFriendRecomRsp() {}
  
  public GetKuolieFriendRecomRsp(CommonInfo paramCommonInfo, SimpleKuolieRoomInfo paramSimpleKuolieRoomInfo, ArrayList<User> paramArrayList)
  {
    this.commInfo = paramCommonInfo;
    this.roomInfo = paramSimpleKuolieRoomInfo;
    this.userList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.roomInfo = ((SimpleKuolieRoomInfo)paramJceInputStream.read(cache_roomInfo, 1, false));
    this.userList = ((ArrayList)paramJceInputStream.read(cache_userList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commInfo != null) {
      paramJceOutputStream.write(this.commInfo, 0);
    }
    if (this.roomInfo != null) {
      paramJceOutputStream.write(this.roomInfo, 1);
    }
    if (this.userList != null) {
      paramJceOutputStream.write(this.userList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFriendRecomRsp
 * JD-Core Version:    0.7.0.1
 */