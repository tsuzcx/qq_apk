import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class ywk
  implements WXShareHelper.WXShareListener
{
  ywk(ywj paramywj) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ApolloGameShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare) == null) || (!ApolloGameShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameShare", 1, "[shareResult2WXFriendOrCircle], resp.errCode:" + paramBaseResp.errCode);
    } while (paramBaseResp.errCode != 0);
    paramBaseResp = this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare.a();
    int j;
    int i;
    if (paramBaseResp == null)
    {
      j = -1;
      if (1 != this.a.jdField_a_of_type_Int) {
        break label159;
      }
      i = 3;
    }
    for (;;)
    {
      VipUtils.a(ApolloGameShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare), "cmshow", "Apollo", "share_url_succeed", j, i, new String[] { Integer.toString(ApolloGameShare.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare)) });
      return;
      j = ApolloUtil.b(paramBaseResp.a.jdField_a_of_type_Int);
      break;
      label159:
      if (2 == this.a.jdField_a_of_type_Int) {
        i = 4;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywk
 * JD-Core Version:    0.7.0.1
 */