import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginBaseView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.wxapi.WXApiHelper.a;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;

public class aanu
  implements WXApiHelper.a
{
  public aanu(TimLoginBaseView paramTimLoginBaseView) {}
  
  public void b(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TimLoginBaseView", 2, "onWXApiResp errCode = " + paramBaseResp.errCode);
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      if ((this.a.jdField_m_of_type_Arhz != null) && (this.a.jdField_m_of_type_Arhz.isShowing())) {
        this.a.jdField_m_of_type_Arhz.dismiss();
      }
      QQToast.a(this.a.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 2131695507, 0).show();
    }
    int i;
    do
    {
      return;
      paramBaseResp = ByteStringMicro.copyFromUtf8(((SendAuth.Resp)paramBaseResp).code).toByteArray();
      WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
      localQuickLoginParam.sigMap = 4160;
      localQuickLoginParam.userSigInfo = new WUserSigInfo();
      localQuickLoginParam.appid = 16L;
      localQuickLoginParam.userAccount = "";
      TimLoginBaseView.a(this.a).SetMsfTransportFlag(1);
      aqnu localaqnu = this.a.a;
      aqnu.eeu();
      this.a.a.b(localQuickLoginParam.userSigInfo);
      i = TimLoginBaseView.a(this.a).quickLoginByWeChat("wx4c9797ab3fd1e003".getBytes(), paramBaseResp, localQuickLoginParam, 0);
    } while (!QLog.isColorLevel());
    QLog.d("TimLoginBaseView", 2, new Object[] { "quickLoginByWeChat ret :", Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanu
 * JD-Core Version:    0.7.0.1
 */