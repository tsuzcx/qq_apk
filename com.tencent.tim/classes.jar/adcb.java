import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adcb
  extends aqms
{
  PromotionConfigInfo b;
  WeakReference<AppInterface> mRefApp;
  final String mUin;
  
  adcb(String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    super(paramString1);
    this.mUin = paramString2;
    this.mRefApp = new WeakReference(paramAppInterface);
  }
  
  public void innerClean()
  {
    this.b = null;
  }
  
  public boolean runOnSubThread(Resources paramResources)
  {
    this.b = aqny.a(this.mUin, null);
    QLog.w(this.TAG, 1, "ReadConfigTask,ConfigInfo[" + this.b + "]");
    adbu.adw();
    AudioHelper.m((AppInterface)this.mRefApp.get());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcb
 * JD-Core Version:    0.7.0.1
 */