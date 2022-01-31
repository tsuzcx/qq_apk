import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;

class yzv
  implements APICallback
{
  yzv(yzu paramyzu, CmGameInitParams paramCmGameInitParams) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.w("cmgame_process.ApolloGameActivity", 1, "[onPermission], code:" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 2;
    }
    ApolloGameActivity.a(this.jdField_a_of_type_Yzu.a, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.w("cmgame_process.ApolloGameActivity", 1, "[onFailure], code:" + paramInt + ",msg:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 2;
    }
    ApolloGameActivity.a(this.jdField_a_of_type_Yzu.a, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
  }
  
  public void a(APIParam paramAPIParam)
  {
    String str = (String)DoraemonUtil.a(paramAPIParam, "openid", "");
    paramAPIParam = (String)DoraemonUtil.a(paramAPIParam, "access_token", "");
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloGameActivity", 2, new Object[] { "[onSuccess], openId", str, ",accessToken:", paramAPIParam });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramAPIParam;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
    }
    ApolloGameActivity.a(this.jdField_a_of_type_Yzu.a, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzv
 * JD-Core Version:    0.7.0.1
 */