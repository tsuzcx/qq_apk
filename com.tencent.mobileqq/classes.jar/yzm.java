import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

public class yzm
  extends WtloginListener
{
  public yzm(DataMigrationService paramDataMigrationService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, WtloginHelper paramWtloginHelper) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| OnException=" + paramErrMsg + ", cmd=" + paramInt);
    }
    DataMigrationService.a(this.jdField_a_of_type_ComTencentMobileqqAppDataMigrationService, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, null, this.jdField_b_of_type_Int);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| onGetA1WithA1 ret=" + paramInt2);
    }
    if (paramInt2 != 0)
    {
      DataMigrationService.a(this.jdField_a_of_type_ComTencentMobileqqAppDataMigrationService, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, null, this.jdField_b_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| send action");
    }
    paramString = this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
    DataMigrationService.a(this.jdField_a_of_type_ComTencentMobileqqAppDataMigrationService, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, paramString, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yzm
 * JD-Core Version:    0.7.0.1
 */