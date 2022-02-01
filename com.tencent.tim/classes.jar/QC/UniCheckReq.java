package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniCheckReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList();
  public LoginInfo stLogin;
  public ArrayList<UniBusinessItem> uniBusinessItemList;
  
  static
  {
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    cache_uniBusinessItemList.add(localUniBusinessItem);
  }
  
  public UniCheckReq() {}
  
  public UniCheckReq(LoginInfo paramLoginInfo, ArrayList<UniBusinessItem> paramArrayList)
  {
    this.stLogin = paramLoginInfo;
    this.uniBusinessItemList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.uniBusinessItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusinessItemList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.uniBusinessItemList != null) {
      paramJceOutputStream.write(this.uniBusinessItemList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.UniCheckReq
 * JD-Core Version:    0.7.0.1
 */