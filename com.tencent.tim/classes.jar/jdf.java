import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavSharpnessSVIPHelper.1;
import com.tencent.qphone.base.util.QLog;

public final class jdf
{
  private boolean XM;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private rwc jdField_a_of_type_Rwc;
  private final Runnable cb = new QavSharpnessSVIPHelper.1(this);
  private arhz h;
  private Activity l;
  private Handler mHandler;
  private Boolean r;
  
  public jdf(VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.l = paramAVActivity;
    this.mHandler = new Handler();
  }
  
  public void abe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "showProgress mProgressShowing:" + this.XM);
    }
    if (this.XM) {}
    do
    {
      return;
      try
      {
        if (this.h == null)
        {
          this.h = new arhz(this.l, this.l.getResources().getDimensionPixelSize(2131299627));
          this.h.setMessage(acfp.m(2131710357));
          this.h.setBackAndSearchFilter(false);
        }
        this.XM = true;
        this.h.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavSharpnessSVIPHelper", 2, "");
  }
  
  public void auo()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "promotionSVIPSuccess");
    }
    this.r = new Boolean(true);
  }
  
  public void ax(Activity paramActivity)
  {
    QLog.d("QavSharpnessSVIPHelper", 2, "launchQQPayFunction");
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Rwc == null) {
      this.jdField_a_of_type_Rwc = new rwc(paramActivity);
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this.cb);
      this.mHandler.postDelayed(this.cb, 1000L);
    }
    this.jdField_a_of_type_Rwc.a("doubleVideo", 5000L, new jdg(this, paramActivity, l1));
  }
  
  public void ay(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "doRealLaunchQQPayFuntion");
    }
    if (this.jdField_a_of_type_Rwc != null)
    {
      this.jdField_a_of_type_Rwc.onDestroy();
      this.jdField_a_of_type_Rwc = null;
    }
    aqrf.cU(this.l, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&aid=mvip.n.a.hdvcall&type=!svip&isAskFriendPay=0&isSend=0");
  }
  
  public void hideProgress()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "hideProgress  mProgressShowing:" + this.XM);
    }
    try
    {
      if (this.mHandler != null) {
        this.mHandler.removeCallbacks(this.cb);
      }
      if ((this.h != null) && (this.h.isShowing())) {
        this.h.dismiss();
      }
      this.XM = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSharpnessSVIPHelper", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void init() {}
  
  public void unInit()
  {
    this.r = null;
    this.l = null;
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.jdField_a_of_type_Rwc != null)
    {
      this.jdField_a_of_type_Rwc.onDestroy();
      this.jdField_a_of_type_Rwc = null;
    }
  }
  
  public boolean wv()
  {
    if (this.r == null)
    {
      this.r = new Boolean(false);
      this.r = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.sy());
      if (QLog.isColorLevel()) {
        QLog.w("QavSharpnessSVIPHelper", 1, "isSVIP:= " + this.r);
      }
    }
    return this.r.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdf
 * JD-Core Version:    0.7.0.1
 */