import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adcc
  extends adbv
{
  static PromotionConfigInfo c;
  final String TAG = "SubProcessPromotionMgr_" + AudioHelper.hG();
  
  public adcc(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    f(paramAppInterface);
    QLog.w(this.TAG, 1, "SubProcessPromotionMgr, sProcessId[" + BaseApplicationImpl.sProcessId + "], processName[" + BaseApplicationImpl.processName + "]");
  }
  
  void Gq(String paramString)
  {
    try
    {
      paramString = aqny.a(this.mUin, paramString);
      a(paramString);
      QLog.w(this.TAG, 1, "reloadConfigInfo, Uin[" + this.mUin + "] configInfo[" + paramString + "]");
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, adbv.a parama)
  {
    if (a("snycGetConfig", paramAppInterface, parama)) {
      return;
    }
    parama.b(a());
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    super.a(paramPromotionConfigInfo);
    try
    {
      c = paramPromotionConfigInfo;
      return;
    }
    finally {}
  }
  
  public void d(AppInterface paramAppInterface, String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(2, paramString, 0);
  }
  
  boolean f(AppInterface paramAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.qq.to.subprocess");
    return paramAppInterface.getApp().registerReceiver(new adcd(this), localIntentFilter) != null;
  }
  
  void l(AppInterface paramAppInterface) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcc
 * JD-Core Version:    0.7.0.1
 */