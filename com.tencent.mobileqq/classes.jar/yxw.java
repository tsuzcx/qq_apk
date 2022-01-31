import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class yxw
  implements WXShareHelper.WXShareListener
{
  yxw(yxv paramyxv) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {
      return;
    }
    QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[shareResult2WXFriendOrCircle], resp.errCode:" + paramBaseResp.errCode);
    if (paramBaseResp.errCode == 0) {
      if (this.a.jdField_a_of_type_Int == 0) {
        CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 0, 2);
      }
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 0, 3);
      continue;
      if (paramBaseResp.errCode == -2)
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 2, 2);
        } else {
          CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 2, 3);
        }
      }
      else if (this.a.jdField_a_of_type_Int == 0) {
        CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 1, 2);
      } else {
        CmGameCommonShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, 1, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxw
 * JD-Core Version:    0.7.0.1
 */