import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.DefaultConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TreeMap;
import mqq.manager.Manager;

public class adbv
  implements Manager
{
  final String TAG;
  adby jdField_a_of_type_Adby = null;
  private adcb jdField_a_of_type_Adcb;
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  adbr b = null;
  String mUin;
  
  public adbv(AppInterface paramAppInterface)
  {
    long l = AudioHelper.hG();
    this.TAG = ("ARPromotion_" + l);
    this.mUin = paramAppInterface.getAccount();
    QLog.w(this.TAG, 1, "PromotionMgr, mUin[" + this.mUin + "]");
    this.jdField_a_of_type_Adby = new adby(l);
  }
  
  void Gp(String paramString)
  {
    if (this.jdField_a_of_type_Adby != null) {
      this.jdField_a_of_type_Adby.cPV();
    }
    BusinessCommonConfig.sendConfigUpdateNotify(2, paramString);
  }
  
  public PromotionConfigInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo == null) && (AudioHelper.isDev()))
    {
      QLog.w(adca.TAG, 1, "getConfigInfo, AR配置还未初始化", new Throwable("打印调用栈"));
      throw new IllegalArgumentException("AR配置还未初始化");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a(adby.a parama)
  {
    if (this.jdField_a_of_type_Adby != null) {
      this.jdField_a_of_type_Adby.a(parama);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("onGetEntryConfig, from server, configInfo[");
    if (paramPromotionConfigInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (paramPromotionConfigInfo != null)
      {
        a(paramPromotionConfigInfo);
        if (this.jdField_a_of_type_Adcb != null)
        {
          this.jdField_a_of_type_Adcb.clean();
          this.jdField_a_of_type_Adcb = null;
        }
      }
      if (!a("onGetConfig", paramQQAppInterface, null)) {
        break;
      }
      return;
    }
    Gp(paramString);
    l(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    if (!isConfigReady()) {
      QLog.w(this.TAG, 1, "onGetResConfig, 365还没加载");
    }
    int i;
    do
    {
      return;
      paramDefaultConfigInfo = a();
      if (paramDefaultConfigInfo == null)
      {
        QLog.w(this.TAG, 1, "onGetResConfig, 365为null");
        return;
      }
      i = aqny.fn(this.mUin);
      QLog.w(this.TAG, 1, "onGetResConfig, 365已经加载了, [" + paramDefaultConfigInfo.config364Version + "], ver[" + i + "]");
      if (TextUtils.equals(paramString, "test")) {
        i = -1;
      }
    } while (i == paramDefaultConfigInfo.config364Version);
    a(null);
    a(paramQQAppInterface, null, null);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    if (paramPromotionConfigInfo == null) {}
    for (;;)
    {
      try
      {
        if (AudioHelper.isDev())
        {
          localThrowable = new Throwable("打印调用栈");
          QLog.w(this.TAG, 1, "setConfigInfo, old[" + this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo + "], new[" + paramPromotionConfigInfo + "]", localThrowable);
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
          this.jdField_a_of_type_Adcb = null;
          return;
        }
      }
      finally {}
      Throwable localThrowable = null;
    }
  }
  
  boolean a(String paramString, AppInterface paramAppInterface, adbv.a parama)
  {
    if ((isConfigReady()) && (adbu.cCc != -1)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_Adcb;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((TextUtils.isEmpty(this.mUin)) && (paramAppInterface != null)) {
        this.mUin = paramAppInterface.getCurrentAccountUin();
      }
      localObject1 = new adcb(this.TAG, this.mUin, paramAppInterface);
      this.jdField_a_of_type_Adcb = ((adcb)localObject1);
    }
    if (((adcb)localObject1).isNeedRunTask())
    {
      QLog.w(this.TAG, 1, "异步加载config[" + paramString + "]");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      aqms.requestSyncTask(null, (ArrayList)localObject2, new adbw(this, paramAppInterface, paramString, parama));
    }
    for (;;)
    {
      return true;
      QLog.w(this.TAG, 1, "异步加载config[" + paramString + "], 已经在加载中");
    }
  }
  
  public void b(adby.a parama)
  {
    if (this.jdField_a_of_type_Adby != null) {
      this.jdField_a_of_type_Adby.b(parama);
    }
  }
  
  public void d(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Adby != null) {
      if (isConfigReady())
      {
        PromotionConfigInfo localPromotionConfigInfo = a();
        this.jdField_a_of_type_Adby.c(localPromotionConfigInfo);
        this.jdField_a_of_type_Adby.a(paramAppInterface, false, paramString, 0);
      }
    }
    do
    {
      return;
      QLog.w(this.TAG, 1, "requestDownload, 配置还未初始化");
      return;
      QLog.w(this.TAG, 1, "requestDownload, 下载器为空");
    } while (!AudioHelper.isDev());
    throw new IllegalArgumentException(acfp.m(2131709982));
  }
  
  public boolean isConfigReady()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  void l(AppInterface paramAppInterface)
  {
    PromotionConfigInfo localPromotionConfigInfo1 = a();
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "requestPreDownload, PromotionConfigInfo[" + localPromotionConfigInfo1 + "], isDevicesSupport[" + adbu.adu() + "]");
    }
    if (!adbu.adu()) {}
    PromotionConfigInfo localPromotionConfigInfo2;
    do
    {
      do
      {
        return;
      } while ((localPromotionConfigInfo1 == null) || (!localPromotionConfigInfo1.mainswitch) || (localPromotionConfigInfo1.operationInfos.size() == 0));
      m(paramAppInterface);
      localPromotionConfigInfo2 = a();
    } while ((localPromotionConfigInfo2 == null) || (this.jdField_a_of_type_Adby == null));
    this.jdField_a_of_type_Adby.c(localPromotionConfigInfo2);
    this.jdField_a_of_type_Adby.a(paramAppInterface, true, localPromotionConfigInfo1.activityid, 0);
  }
  
  void m(AppInterface paramAppInterface)
  {
    anjg.axx();
    if (this.b == null) {
      this.b = new adbr();
    }
    this.b.k(paramAppInterface);
  }
  
  public void onDestroy()
  {
    QLog.w(this.TAG, 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
    if (this.jdField_a_of_type_Adcb != null)
    {
      this.jdField_a_of_type_Adcb.clean();
      this.jdField_a_of_type_Adcb = null;
    }
    if (this.jdField_a_of_type_Adby != null)
    {
      this.jdField_a_of_type_Adby.destroy();
      this.jdField_a_of_type_Adby = null;
    }
    if (this.b != null)
    {
      this.b.clean();
      this.b = null;
    }
    a(null);
  }
  
  public static abstract interface a
  {
    public abstract void b(PromotionConfigInfo paramPromotionConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbv
 * JD-Core Version:    0.7.0.1
 */