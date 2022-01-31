import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class ecn
  implements BusinessObserver
{
  public ecn(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject == null) || (((BaseActivity)localObject).isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.a.a(2131362453);
      this.a.a(this.a.c, "false");
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break;
        }
        localObject = new mobileqq_mp.FollowResponse();
        ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
        if ((!((mobileqq_mp.FollowResponse)localObject).ret_info.has()) || (!((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.has())) {
          break label251;
        }
        paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
          this.a.a(this.a.c, "true");
          return;
        }
        if (paramInt == 58)
        {
          this.a.a(2131362456);
          break;
        }
        this.a.a(2131362453);
      }
      catch (Exception paramBundle) {}
      this.a.a(2131362453);
      break;
      break;
      label251:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecn
 * JD-Core Version:    0.7.0.1
 */