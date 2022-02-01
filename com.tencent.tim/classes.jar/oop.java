import com.tencent.biz.pubaccount.weishi_new.util.QzoneVerticalVideoPluginApk.2;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.os.MqqHandler;

public class oop
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static volatile oop a;
  public static boolean axR;
  public static boolean axT;
  public static int bfx;
  private PluginManagerClient a;
  private volatile boolean axS;
  private boolean axU = true;
  private long zh = 120000L;
  
  public static oop a()
  {
    if (jdField_a_of_type_Oop == null) {}
    try
    {
      if (jdField_a_of_type_Oop == null) {
        jdField_a_of_type_Oop = new oop();
      }
      return jdField_a_of_type_Oop;
    }
    finally {}
  }
  
  private void bfU()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneVerticalVideoPluginApk.2(this));
  }
  
  private long ds()
  {
    return LocalMultiProcConfig.getLong("sp_weishi_update_plugin", "query_plugin_last_time", -1L);
  }
  
  public boolean Hd()
  {
    return this.axU;
  }
  
  public void bfT()
  {
    bfV();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 01 mIsPreInstalling = " + this.axS + " sPreloadPluginState = " + bfx);
    if (bfx == 1)
    {
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.c();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null) {
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null)
      {
        avyq.a().setAppInterface(localQQAppInterface1);
        if (System.currentTimeMillis() - ds() > 60000L) {
          bfx = 0;
        }
      }
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 02 mIsPreInstalling = " + this.axS + " sPreloadPluginState = " + bfx);
    if ((!this.axS) && (bfx != 1))
    {
      this.axS = true;
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall OK mIsPreInstalling = " + this.axS + " sPreloadPluginState = " + bfx);
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public void bfV()
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk initPluginThreshold sInitPluginThreshold = " + axT);
    if (axT) {
      return;
    }
    Object localObject = oia.a();
    ooz.d("QzoneVerticalVideoPluginApk", "initPluginThreshold configBean = " + localObject);
    if ((localObject == null) || (((oia)localObject).a == null))
    {
      ooz.e("QzoneVerticalVideoPluginApk", "doDownloadWeishi : configBean is null");
      return;
    }
    localObject = ((oia)localObject).a;
    this.zh = (((oid)localObject).yP * 1000L);
    this.axU = ((oid)localObject).axp;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk mQueryPluginThreshold  = " + this.zh + " mIsPreloadInWsRecommend = " + this.axU);
    axT = true;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start");
    if (paramPluginManagerClient == null) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
    for (;;)
    {
      this.axS = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
      long l1 = ds();
      long l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      if ((l1 > 0L) && (l3 < this.zh))
      {
        this.axS = false;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk ERR deltaTime < " + this.zh + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1 + " mIsPreInstalling = " + this.axS);
        return;
      }
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk OK deltaTime > " + this.zh + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1);
      paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qzone_vertical_video_plugin.apk");
      if (paramPluginManagerClient != null)
      {
        axR = true;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start  state = " + paramPluginManagerClient.mState);
        if (paramPluginManagerClient.mState == 4)
        {
          this.axS = false;
          bfU();
          QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady installed");
          return;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qzone_vertical_video_plugin.apk", new ooq(this));
        }
        catch (Exception paramPluginManagerClient)
        {
          QLog.e("QzoneVerticalVideoPluginApk", 1, paramPluginManagerClient, new Object[0]);
        }
      }
      else
      {
        QLog.d("QzoneVerticalVideoPluginApk", 1, "record is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oop
 * JD-Core Version:    0.7.0.1
 */