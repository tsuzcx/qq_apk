import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class tzz
  implements BusinessObserver
{
  tzz(aoeg paramaoeg, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Aoeg != null) {
        this.jdField_a_of_type_Aoeg.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
      }
    }
    label220:
    label374:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label412;
          }
          for (;;)
          {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle == null) {
                break label374;
              }
              mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
              localUnFollowResponse.mergeFrom(paramBundle);
              if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
                break label336;
              }
              if (this.jdField_a_of_type_JavaLangObject == null) {
                break label220;
              }
              paramBundle = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
              if (paramBundle != null) {
                paramBundle.a(this.jdField_a_of_type_JavaLangObject);
              }
              if (this.jdField_a_of_type_Aoeg == null) {
                break;
              }
              this.jdField_a_of_type_Aoeg.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
              return;
            }
            catch (Exception paramBundle)
            {
              if (this.jdField_a_of_type_Aoeg != null) {
                this.jdField_a_of_type_Aoeg.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
              }
            }
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
            return;
            paramBundle = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
            paramBundle.b(this.jdField_a_of_type_JavaLangString);
            paramBundle.a(this.jdField_a_of_type_JavaLangString);
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1008);
            twk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle.a());
            tug.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            paramBundle = (oek)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
            if (paramBundle != null) {
              paramBundle.a(this.jdField_a_of_type_JavaLangString, "unfollow");
            }
          }
          if (this.jdField_a_of_type_Aoeg != null) {
            this.jdField_a_of_type_Aoeg.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        return;
        if (this.jdField_a_of_type_Aoeg != null) {
          this.jdField_a_of_type_Aoeg.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
      return;
      if (this.jdField_a_of_type_Aoeg != null) {
        this.jdField_a_of_type_Aoeg.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label336:
    tzq.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
    label412:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzz
 * JD-Core Version:    0.7.0.1
 */