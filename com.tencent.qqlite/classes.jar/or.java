import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class or
  implements BusinessObserver
{
  public or(AppInterface paramAppInterface, Context paramContext, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {}
    for (;;)
    {
      return;
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
            PublicAccountUtil.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            return;
          }
          if (paramInt == 58)
          {
            PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362456);
            return;
          }
          PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362453);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362453);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     or
 * JD-Core Version:    0.7.0.1
 */