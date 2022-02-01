import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahhz
  implements Handler.Callback, wvs
{
  private aqju ar;
  private boolean cha;
  private boolean chb;
  private boolean chc;
  private boolean chd;
  private Activity mActivity;
  private QQAppInterface mApp;
  private String mAppId;
  private BaseChatPie mBaseChatPie;
  private String mOpenId;
  private SessionInfo sessionInfo = new SessionInfo();
  
  public ahhz(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, " init ");
    }
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      this.mActivity = this.mBaseChatPie.mActivity;
      if (this.mActivity != null) {
        this.mApp = ((QQAppInterface)((BaseActivity)this.mActivity).getAppInterface());
      }
    }
  }
  
  private void Kq(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.chb) {
        if (this.mApp.getCurrentAccountUin().equals(this.sessionInfo.aTl)) {
          a(this.mActivity.getString(2131701792)).show();
        }
      }
    }
    while (!this.chd)
    {
      return;
      anot.a(this.mApp, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.mApp, this.mActivity, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.aTn, this.sessionInfo.phoneNum, true, "", true, true, null, "from_internal", null);
      return;
      if (this.chc)
      {
        if (this.mApp.getCurrentAccountUin().equals(this.sessionInfo.aTl))
        {
          a(this.mActivity.getString(2131701792)).show();
          return;
        }
        anot.a(this.mApp, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.mApp, this.mActivity, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.aTn, this.sessionInfo.phoneNum, false, "", true, true, null, "from_internal", null);
        return;
      }
      anot.a(this.mApp, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
      return;
    }
    dog();
  }
  
  private aqju a(String paramString)
  {
    return aqha.a(this.mActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.mActivity.getString(2131691042), new ahia(this));
  }
  
  private void onDestory()
  {
    if (this.ar != null) {
      this.ar.dismiss();
    }
  }
  
  public int[] C()
  {
    return new int[] { 6, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      return;
      onDestory();
    } while (!QLog.isColorLevel());
    QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState DESTROY =");
  }
  
  public void c(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, "handleForwordIM");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      this.cha = paramIntent.getBoolean("thridparty_pull_aio", false);
    } while (!this.cha);
    this.chd = paramBoolean;
    this.chb = paramIntent.getBoolean("pull_aio_audio", false);
    this.chc = paramIntent.getBoolean("pull_aio_video", false);
    this.mOpenId = paramIntent.getString("openid", "");
    this.mAppId = paramIntent.getString("appid", "");
    this.sessionInfo.aTl = paramIntent.getString("uin");
    this.sessionInfo.cZ = paramIntent.getInt("uintype");
    this.sessionInfo.phoneNum = paramIntent.getString("phonenum");
    this.sessionInfo.aTn = paramIntent.getString("uinname", "");
    Kq(true);
  }
  
  protected void dog()
  {
    if ((this.ar != null) && (!this.ar.isShowing()) && (!this.mActivity.isFinishing())) {
      this.ar.show();
    }
    do
    {
      return;
      this.ar = aqha.a(this.mActivity, 230);
      this.ar.setMessage(2131697425);
      this.ar.setTitle(2131721048);
      ahib localahib = new ahib(this);
      this.ar.setNegativeButton(2131721058, localahib);
      this.ar.setPositiveButton(2131697395, localahib);
    } while (this.mActivity.isFinishing());
    this.ar.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhz
 * JD-Core Version:    0.7.0.1
 */