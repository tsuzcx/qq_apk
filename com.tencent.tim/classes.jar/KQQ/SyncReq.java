package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SyncReq
  extends JceStruct
{
  static UserData cache_userData;
  static ArrayList<InfoItem> cache_vecReqPkg;
  public UserData userData;
  public ArrayList<InfoItem> vecReqPkg;
  
  public SyncReq() {}
  
  public SyncReq(ArrayList<InfoItem> paramArrayList, UserData paramUserData)
  {
    this.vecReqPkg = paramArrayList;
    this.userData = paramUserData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqPkg == null)
    {
      cache_vecReqPkg = new ArrayList();
      InfoItem localInfoItem = new InfoItem();
      cache_vecReqPkg.add(localInfoItem);
    }
    this.vecReqPkg = ((ArrayList)paramJceInputStream.read(cache_vecReqPkg, 0, true));
    if (cache_userData == null) {
      cache_userData = new UserData();
    }
    this.userData = ((UserData)paramJceInputStream.read(cache_userData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqPkg, 0);
    if (this.userData != null) {
      paramJceOutputStream.write(this.userData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.SyncReq
 * JD-Core Version:    0.7.0.1
 */