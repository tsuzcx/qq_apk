import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class bql
  implements BusinessObserver
{
  public bql(PublicAccountManager paramPublicAccountManager, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = paramBundle.getByteArray("data");
          localGetPublicAccountMenuResponse = new mobileqq_mp.GetPublicAccountMenuResponse();
        }
        catch (Exception localException1)
        {
          Object localObject2;
          mobileqq_mp.GetPublicAccountMenuResponse localGetPublicAccountMenuResponse;
          long l;
          int i;
          int j;
          Object localObject1 = null;
          continue;
        }
        try
        {
          localGetPublicAccountMenuResponse.mergeFrom((byte[])localObject2);
          if (!localGetPublicAccountMenuResponse.uin.has()) {
            continue;
          }
          l = localGetPublicAccountMenuResponse.uin.get() & 0xFFFFFFFF;
          if (!localGetPublicAccountMenuResponse.seqno.has()) {
            continue;
          }
          i = localGetPublicAccountMenuResponse.seqno.get();
          localObject2 = PublicAccountManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            continue;
          }
          paramBundle.putInt("update_type", 1);
          j = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a("" + l);
          if (i == j) {
            break;
          }
        }
        catch (Exception localException2)
        {
          continue;
          j = 2;
        }
      }
      if (localGetPublicAccountMenuResponse == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, localGetPublicAccountMenuResponse);
      if (this.jdField_a_of_type_MqqObserverBusinessObserver == null) {
        break;
      }
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, paramBoolean, paramBundle);
      return;
      l = 0L;
      continue;
      i = 0;
      continue;
      if (!localGetPublicAccountMenuResponse.update_type.has()) {
        continue;
      }
      j = localGetPublicAccountMenuResponse.update_type.get();
      paramBundle.putInt("update_type", j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bql
 * JD-Core Version:    0.7.0.1
 */