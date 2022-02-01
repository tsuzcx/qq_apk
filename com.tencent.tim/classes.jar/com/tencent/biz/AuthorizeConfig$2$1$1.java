package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import jml;
import jmm;

public class AuthorizeConfig$2$1$1
  implements Runnable
{
  public AuthorizeConfig$2$1$1(jmm paramjmm, mobileqq_mp.WebviewWhiteListResponse paramWebviewWhiteListResponse) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.version != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data.get().size() != 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data.get().toByteArray();
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("AuthorizeConfig", 2, "now read compress data, size: " + localObject2.length);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          localObject2 = jml.l(localObject1);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.i("AuthorizeConfig", 2, "use zip data to json: " + this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get());
              localObject1 = localObject2;
            }
          }
          if (TextUtils.isEmpty(localObject1)) {
            return;
          }
          this.jdField_a_of_type_Jmm.a.this$0.E(localObject1, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.version.get(), "lastVersion");
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("AuthorizeConfig", 2, "", localException);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get();
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("AuthorizeConfig", 2, "not use zip data to json: " + this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get());
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.2.1.1
 * JD-Core Version:    0.7.0.1
 */