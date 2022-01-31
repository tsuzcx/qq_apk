import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class edq
  implements BusinessObserver
{
  public edq(AppLaucherHelper paramAppLaucherHelper, long paramLong, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AppLaucherHelper", 2, "t=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, "onReceive");
    }
    new Bundle();
    localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (paramBoolean) {
      localObject2 = paramBundle.getByteArray("data");
    }
    for (;;)
    {
      try
      {
        paramBundle = new FastAuthorize.AuthorizeResponse();
        paramBundle.mergeFrom((byte[])localObject2);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaLangString);
        if ((paramBundle.ret.get().equals("0")) && (paramBundle.apk_name.has()))
        {
          if (paramBundle.access_token.has())
          {
            localObject2 = paramBundle.access_token.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$AT$", (CharSequence)localObject2);
          }
          if (paramBundle.pay_token.has())
          {
            localObject2 = paramBundle.pay_token.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$PT$", (CharSequence)localObject2);
          }
          if (paramBundle.openid.has())
          {
            localObject2 = paramBundle.openid.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$OPID$", (CharSequence)localObject2);
          }
          if (paramBundle.pfkey.has())
          {
            localObject2 = paramBundle.pfkey.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$PF$", (CharSequence)localObject2);
          }
          if (paramBundle.encrykey.has())
          {
            localObject2 = paramBundle.encrykey.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$ESK$", (CharSequence)localObject2);
          }
          paramBundle = paramBundle.apk_name.get();
          if ((TextUtils.isEmpty(paramBundle)) || (!paramBundle.contains(this.jdField_a_of_type_JavaLangString)))
          {
            AppLaucherHelper.jdField_a_of_type_Boolean = false;
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, "cant't start app pkg invalide");
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
      try
      {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 4, "pkg=" + paramBundle);
        localObject1 = AppLaucherHelper.a(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
        }
        AppUtil.a(this.jdField_a_of_type_AndroidContentContext, paramBundle, (Bundle)localObject1, this.jdField_a_of_type_Int);
        AppLaucherHelper.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent = null;
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          localObject1 = paramBundle;
        }
      }
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 4, "start without login state");
      paramBundle = (Bundle)localObject1;
      continue;
      paramBundle = (Bundle)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, localInvalidProtocolBufferMicroException1.getMessage());
        paramBundle = (Bundle)localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     edq
 * JD-Core Version:    0.7.0.1
 */