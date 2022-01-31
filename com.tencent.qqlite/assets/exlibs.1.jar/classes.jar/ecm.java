import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class ecm
  implements BusinessObserver
{
  public ecm(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131362453);
    }
    for (;;)
    {
      this.a.a(this.a.c, "false");
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
          if ((localGetPublicAccountDetailInfoResponse.ret_info.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
              continue;
            }
            paramBundle = new AccountDetail(localGetPublicAccountDetailInfoResponse);
            this.a.a(localBaseActivity, paramBundle);
            StatusJsHandler.a(this.a, localBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
            return;
          }
          this.a.a(2131362453);
          continue;
        }
        this.a.a(2131362453);
      }
      catch (Exception paramBundle) {}
      this.a.a(2131362453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecm
 * JD-Core Version:    0.7.0.1
 */