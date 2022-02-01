import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class amhi
  implements BusinessObserver
{
  public amhi(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.this$0.mActivity.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.this$0.Bm(2131697432);
      this.this$0.hk(this.this$0.cae, "false");
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        if ((!localFollowResponse.ret_info.has()) || (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has())) {
          break label321;
        }
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.this$0.a.followType = 1;
          this.this$0.a(localBaseActivity, this.this$0.a);
          ((PublicAccountHandler)localBaseActivity.app.getBusinessHandler(11)).bb(this.this$0.a);
          kaw.a().a(localBaseActivity.getApplicationContext(), localBaseActivity.app, this.this$0.a.uin, null, true);
          this.this$0.hk(this.this$0.cae, "true");
          return;
        }
        if (paramInt == 58)
        {
          this.this$0.Bm(2131697429);
          break;
        }
        if (paramInt == 65)
        {
          this.this$0.Bm(2131697402);
          break;
        }
        this.this$0.Bm(2131697432);
      }
      catch (Exception paramBundle) {}
      break;
      label321:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhi
 * JD-Core Version:    0.7.0.1
 */