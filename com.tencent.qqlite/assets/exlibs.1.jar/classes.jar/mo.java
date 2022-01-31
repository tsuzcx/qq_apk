import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class mo
  implements BusinessObserver
{
  public mo(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131362450);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_a_of_type_Int -= 1;
      if (this.a.jdField_a_of_type_Int == 0) {
        EnterpriseDetailActivity.b(this.a);
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.postDelayed(new mp(this), 1000L);
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType = 1;
          EnterpriseDetailActivity.c(this.a);
          EnterpriseDetailActivity.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          EnterpriseDetailActivity.d(this.a);
          EnterpriseQQManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
          continue;
        }
        if (paramInt == 58)
        {
          this.a.a(2131362453);
          continue;
        }
        this.a.a(2131362450);
      }
      catch (Exception paramBundle) {}
      this.a.a(2131362450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mo
 * JD-Core Version:    0.7.0.1
 */