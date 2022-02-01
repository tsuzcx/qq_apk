import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import org.json.JSONObject;

class abog
  implements tzd
{
  abog(aboc paramaboc, String paramString, long paramLong, tzg paramtzg, CmGameInitParams paramCmGameInitParams) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    aboc.a(this.this$0, this.val$cmd, this.Od, paramInt);
  }
  
  public void onPermission(int paramInt)
  {
    aboc.a(this.this$0, this.val$cmd, this.Od, paramInt);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    aboc.a(this.this$0, this.Od, this.val$cmd, this.jdField_e_of_type_Tzg);
    this.jdField_e_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
    this.jdField_e_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramJSONObject;
    this.jdField_e_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abog
 * JD-Core Version:    0.7.0.1
 */