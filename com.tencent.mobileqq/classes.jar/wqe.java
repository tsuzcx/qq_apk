import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.observer.BusinessObserver;
import tencent.im.nearbygroup.ext.NearbyGroupExt.RspBody;

class wqe
  implements BusinessObserver
{
  wqe(wqd paramwqd) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new NearbyGroupExt.RspBody();
      }
    }
    try
    {
      ((NearbyGroupExt.RspBody)localObject).mergeFrom(paramBundle);
      paramBundle = "";
      paramInt = 0;
      if (((NearbyGroupExt.RspBody)localObject).str_wording.has()) {
        paramBundle = ((NearbyGroupExt.RspBody)localObject).str_wording.get();
      }
      if (((NearbyGroupExt.RspBody)localObject).uint32_total_num.has()) {
        paramInt = ((NearbyGroupExt.RspBody)localObject).uint32_total_num.get();
      }
      localObject = this.a.a.a.a().obtainMessage();
      ((Message)localObject).what = 106;
      ((Message)localObject).obj = paramBundle;
      ((Message)localObject).arg1 = paramInt;
      this.a.a.a.a().sendMessage((Message)localObject);
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */