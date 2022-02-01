import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginBaseView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class aanv
  extends AccountObserver
{
  public aanv(TimLoginBaseView paramTimLoginBaseView) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    this.a.a(paramBoolean, paramInt, paramArrayOfByte);
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    QLog.d("TimLoginBaseView", 1, "onLoginFailed ret=" + paramInt1);
    if ((this.a.jdField_m_of_type_Arhz != null) && (this.a.jdField_m_of_type_Arhz.isShowing())) {
      this.a.jdField_m_of_type_Arhz.dismiss();
    }
    this.a.a(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if ((paramString2 == null) || (paramString2.equals("")))
    {
      QQToast.a(this.a.getActivity(), 2131696270, 0).show();
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      Intent localIntent = new Intent(this.a.getActivity(), NotificationActivity.class);
      localIntent.putExtra("type", 8);
      if (paramInt1 == 40)
      {
        localIntent.putExtra("msg", paramString2);
        localIntent.putExtra("errorver", paramInt2);
      }
      for (;;)
      {
        localIntent.putExtra("loginalias", paramString1);
        localIntent.putExtra("loginret", paramInt1);
        localIntent.putExtra("errorUrl", paramString3);
        localIntent.putExtra("expiredSig", paramArrayOfByte);
        this.a.startActivity(localIntent);
        return;
        localIntent.putExtra("msg", paramString2 + " " + paramString3);
      }
    }
    if (paramInt1 == 2008)
    {
      aqha.a(this.a.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 230, acfp.m(2131707957), acfp.m(2131707952), "OK", null, new aanw(this), null).show();
      QQToast.a(this.a.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 2131694440, 0).show();
      return;
    }
    aqha.a(this.a.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 230, acfp.m(2131707945), paramString2, new aanx(this), null).show();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.a.d(paramString1, paramString2, paramArrayOfByte);
    QLog.d("TimLoginBaseView", 1, "onLoginSuccess");
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("TimLoginBaseView", 1, "onLoginTimeout");
    if ((this.a.jdField_m_of_type_Arhz != null) && (this.a.jdField_m_of_type_Arhz.isShowing())) {
      this.a.jdField_m_of_type_Arhz.dismiss();
    }
    this.a.AA(paramString);
    QQToast.a(this.a.getActivity(), 2131696270, 0).show();
  }
  
  public void onUserCancel(String paramString)
  {
    if ((this.a.jdField_m_of_type_Arhz != null) && (this.a.jdField_m_of_type_Arhz.isShowing())) {
      this.a.jdField_m_of_type_Arhz.dismiss();
    }
    this.a.Az(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */