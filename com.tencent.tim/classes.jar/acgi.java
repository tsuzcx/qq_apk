import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatShare.2;
import com.tencent.mobileqq.app.HotChatShare.3;
import com.tencent.mobileqq.app.HotChatShare.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;

public class acgi
{
  public arhz N;
  private acfd a;
  public BaseActivity a;
  public QQAppInterface app;
  public String boq = null;
  public int currentState = 0;
  public HotChatInfo e;
  String ownerNickname = null;
  
  public acgi(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    this.jdField_a_of_type_Acfd = new acgj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.app = paramQQAppInterface;
    this.e = paramHotChatInfo;
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    ThreadManager.post(new HotChatShare.2(this, paramQQAppInterface), 8, null, true);
  }
  
  private void cJp()
  {
    int i;
    if (this.e.joinUrl != null)
    {
      i = this.e.joinUrl.indexOf("hotnamecode=");
      if (i == -1) {}
    }
    for (String str1 = this.e.joinUrl.substring(i + 12);; str1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleHotChatShare.mTroop.joinUrl=" + this.e.joinUrl + ",hotnamecode=" + str1);
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str3 = acfx.ad(str1, this.e.userCreate);
      if (this.e.userCreate != 1)
      {
        acfx.a(2, this.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.e.name, this.e.troopUin, str3, str1, acfp.m(2131707256) + this.e.name + acfp.m(2131707251), acfp.m(2131707253), null, null);
        return;
      }
      String str2 = acfp.m(2131707250);
      if (!TextUtils.isEmpty(this.ownerNickname)) {
        str2 = acfp.m(2131707254) + this.ownerNickname + acfp.m(2131707255);
      }
      String str4 = this.app.getCustomFaceFilePath(32, this.e.ownerUin, 200);
      acfx.a(2, this.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.e.name, this.e.troopUin, str3, str1, acfp.m(2131707249) + this.e.name + acfp.m(2131707252), str2, this.boq, str4);
      return;
    }
  }
  
  public void abe()
  {
    try
    {
      if (this.N == null)
      {
        this.N = new arhz(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.N.setMessage(2131696693);
      }
      this.N.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
  
  public void b(HotChatInfo paramHotChatInfo)
  {
    this.e = paramHotChatInfo;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.info=" + paramHotChatInfo);
    }
    if (this.e.userCreate != 1)
    {
      cJp();
      return;
    }
    this.currentState = 0;
    this.ownerNickname = aqgv.G(this.app, this.e.ownerUin);
    if (!TextUtils.isEmpty(this.ownerNickname)) {
      this.currentState = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.ownerNickname=" + this.ownerNickname);
    }
    if (!TextUtils.isEmpty(this.boq))
    {
      if (this.currentState != 0) {
        break label193;
      }
      this.currentState = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleShare.ownerHeadUrl=" + this.boq);
      }
      if (this.currentState != 3) {
        break;
      }
      cJp();
      return;
      label193:
      if (this.currentState == 1) {
        this.currentState = 3;
      }
    }
    abe();
    ThreadManager.post(new HotChatShare.3(this), 8, null, false);
    new Handler().postDelayed(new HotChatShare.4(this), 30000L);
  }
  
  public void hideProgress()
  {
    try
    {
      if ((this.N != null) && (this.N.isShowing())) {
        this.N.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
  
  public void onDestroy()
  {
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Acfd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgi
 * JD-Core Version:    0.7.0.1
 */