package wf7;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import com.tencent.qqpimsecure.wificore.api.connect.d;

class cr$2
  implements Runnable
{
  cr$2(cr paramcr, long paramLong) {}
  
  public void run()
  {
    cr.a(this.hW, "syncCurrentSession run | logIdGroupId=" + this.hX);
    if (((d)ao.c().i(4)).k())
    {
      cr.a(this.hW, this.hX + " syncCurrentSession| wifimanager connecting , ignore");
      return;
    }
    Object localObject = this.hW.getActiveNetworkInfo();
    WifiInfo localWifiInfo = ca.getConnectionInfo();
    NetworkInfo.DetailedState localDetailedState = cl.a((NetworkInfo)localObject, localWifiInfo);
    cr localcr = this.hW;
    StringBuilder localStringBuilder = new StringBuilder().append("syncCurrentSession networkInfo=");
    if (localObject != null)
    {
      localObject = ((NetworkInfo)localObject).toString();
      localStringBuilder = localStringBuilder.append((String)localObject).append(", wifiInfo=");
      if (localWifiInfo == null) {
        break label180;
      }
    }
    label180:
    for (localObject = localWifiInfo.toString();; localObject = "null")
    {
      cr.a(localcr, (String)localObject);
      cr.a(this.hW, this.hX, localDetailedState, localWifiInfo);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.cr.2
 * JD-Core Version:    0.7.0.1
 */