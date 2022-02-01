import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class dau
  implements BusinessObserver
{
  public dau(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBoolean)) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
        localSetFunctionFlagResponse.mergeFrom(paramBundle);
        if ((localSetFunctionFlagResponse.ret_info.has()) && (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0) && (QLog.isColorLevel())) {
          QLog.d(PublicAccountChatActivity.e(), 2, "状态切换成功");
        }
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dau
 * JD-Core Version:    0.7.0.1
 */