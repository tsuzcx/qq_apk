import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class tzy
  implements BusinessObserver
{
  tzy(aoeg paramaoeg, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Aoeg != null) {
        this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
      }
    }
    label366:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramBoolean) {
                  break label404;
                }
                try
                {
                  paramBundle = paramBundle.getByteArray("data");
                  if (paramBundle == null) {
                    break label366;
                  }
                  mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
                  localFollowResponse.mergeFrom(paramBundle);
                  paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountUtil", 2, "followUin, retCode=" + paramInt);
                  }
                  if (paramInt != 0) {
                    break;
                  }
                  if (this.jdField_a_of_type_Aoeg != null) {
                    this.jdField_a_of_type_Aoeg.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
                  }
                  tzq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
                  return;
                }
                catch (Exception paramBundle)
                {
                  if (this.jdField_a_of_type_Aoeg != null) {
                    this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
                  }
                }
              } while (!this.jdField_a_of_type_Boolean);
              tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
              return;
              if (paramInt != 58) {
                break;
              }
              if (this.jdField_a_of_type_Aoeg != null) {
                this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
              }
            } while (!this.jdField_a_of_type_Boolean);
            tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694656);
            return;
            if (paramInt != 65) {
              break;
            }
            if (this.jdField_a_of_type_Aoeg != null) {
              this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
            }
          } while (!this.jdField_a_of_type_Boolean);
          tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694633);
          return;
          if (this.jdField_a_of_type_Aoeg != null) {
            this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        return;
        if (this.jdField_a_of_type_Aoeg != null) {
          this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
      return;
      if (this.jdField_a_of_type_Aoeg != null) {
        this.jdField_a_of_type_Aoeg.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label404:
    tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzy
 * JD-Core Version:    0.7.0.1
 */