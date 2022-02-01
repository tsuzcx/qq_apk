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
    Object localObject1 = this.hW;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("syncCurrentSession run | logIdGroupId=");
    ((StringBuilder)localObject2).append(this.hX);
    cr.a((cr)localObject1, ((StringBuilder)localObject2).toString());
    if (((d)ao.c().i(4)).k())
    {
      localObject1 = this.hW;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.hX);
      ((StringBuilder)localObject2).append(" syncCurrentSession| wifimanager connecting , ignore");
      cr.a((cr)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = this.hW.getActiveNetworkInfo();
    WifiInfo localWifiInfo = ca.getConnectionInfo();
    NetworkInfo.DetailedState localDetailedState = cl.a((NetworkInfo)localObject1, localWifiInfo);
    cr localcr = this.hW;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("syncCurrentSession networkInfo=");
    localObject2 = "null";
    if (localObject1 != null) {
      localObject1 = ((NetworkInfo)localObject1).toString();
    } else {
      localObject1 = "null";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", wifiInfo=");
    localObject1 = localObject2;
    if (localWifiInfo != null) {
      localObject1 = localWifiInfo.toString();
    }
    localStringBuilder.append((String)localObject1);
    cr.a(localcr, localStringBuilder.toString());
    cr.a(this.hW, this.hX, localDetailedState, localWifiInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cr.2
 * JD-Core Version:    0.7.0.1
 */