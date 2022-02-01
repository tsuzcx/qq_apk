package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MobileCommConf
  extends JceStruct
{
  static NewMobileGlobalConf cache_new_mobile_global_conf = new NewMobileGlobalConf();
  static NewMobileUserConf cache_new_mobile_user_conf = new NewMobileUserConf();
  static ArrayList<String> cache_vecAppList = new ArrayList();
  public int maxScanNum;
  public NewMobileGlobalConf new_mobile_global_conf;
  public NewMobileUserConf new_mobile_user_conf;
  public ArrayList<String> vecAppList;
  
  static
  {
    cache_vecAppList.add("");
  }
  
  public MobileCommConf() {}
  
  public MobileCommConf(NewMobileGlobalConf paramNewMobileGlobalConf, NewMobileUserConf paramNewMobileUserConf, ArrayList<String> paramArrayList, int paramInt)
  {
    this.new_mobile_global_conf = paramNewMobileGlobalConf;
    this.new_mobile_user_conf = paramNewMobileUserConf;
    this.vecAppList = paramArrayList;
    this.maxScanNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.new_mobile_global_conf = ((NewMobileGlobalConf)paramJceInputStream.read(cache_new_mobile_global_conf, 0, false));
    this.new_mobile_user_conf = ((NewMobileUserConf)paramJceInputStream.read(cache_new_mobile_user_conf, 1, false));
    this.vecAppList = ((ArrayList)paramJceInputStream.read(cache_vecAppList, 2, false));
    this.maxScanNum = paramJceInputStream.read(this.maxScanNum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.new_mobile_global_conf != null) {
      paramJceOutputStream.write(this.new_mobile_global_conf, 0);
    }
    if (this.new_mobile_user_conf != null) {
      paramJceOutputStream.write(this.new_mobile_user_conf, 1);
    }
    if (this.vecAppList != null) {
      paramJceOutputStream.write(this.vecAppList, 2);
    }
    paramJceOutputStream.write(this.maxScanNum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_COMM_CONF.MobileCommConf
 * JD-Core Version:    0.7.0.1
 */