package NS_MOBILE_EXTRA;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetDeviceInfoRsp
  extends JceStruct
{
  static yellow_info cache_user_yellow_info;
  static ArrayList cache_vecDeviceInfo;
  public yellow_info user_yellow_info = null;
  public ArrayList vecDeviceInfo = null;
  
  public GetDeviceInfoRsp() {}
  
  public GetDeviceInfoRsp(ArrayList paramArrayList, yellow_info paramyellow_info)
  {
    this.vecDeviceInfo = paramArrayList;
    this.user_yellow_info = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecDeviceInfo == null)
    {
      cache_vecDeviceInfo = new ArrayList();
      DeviceInfo localDeviceInfo = new DeviceInfo();
      cache_vecDeviceInfo.add(localDeviceInfo);
    }
    this.vecDeviceInfo = ((ArrayList)paramJceInputStream.read(cache_vecDeviceInfo, 0, true));
    if (cache_user_yellow_info == null) {
      cache_user_yellow_info = new yellow_info();
    }
    this.user_yellow_info = ((yellow_info)paramJceInputStream.read(cache_user_yellow_info, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecDeviceInfo, 0);
    if (this.user_yellow_info != null) {
      paramJceOutputStream.write(this.user_yellow_info, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.GetDeviceInfoRsp
 * JD-Core Version:    0.7.0.1
 */