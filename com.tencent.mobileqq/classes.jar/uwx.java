import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class uwx
  implements BusinessObserver
{
  uwx(uwt paramuwt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
          }
          this.a.a = true;
          uwt.a(this.a);
          return;
        }
        if (paramInt == 58)
        {
          uwt.a(this.a, 2131694656);
          return;
        }
        if (paramInt == 65)
        {
          uwt.a(this.a, 2131694633);
          return;
        }
        uwt.a(this.a, 2131694659);
        return;
        uwt.a(this.a, 2131694659);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwx
 * JD-Core Version:    0.7.0.1
 */