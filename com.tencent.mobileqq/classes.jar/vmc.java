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
import cooperation.qzone.plugin.QZoneRemotePluginHandler;
import mqq.os.MqqHandler;

public class vmc
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static int a;
  public static volatile vmc a;
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 120000L;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private volatile boolean c;
  private boolean d = true;
  
  private long a()
  {
    return LocalMultiProcConfig.getLong("sp_weishi_update_plugin", "query_plugin_last_time", -1L);
  }
  
  public static vmc a()
  {
    if (jdField_a_of_type_Vmc == null) {}
    try
    {
      if (jdField_a_of_type_Vmc == null) {
        jdField_a_of_type_Vmc = new vmc();
      }
      return jdField_a_of_type_Vmc;
    }
    finally {}
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneVerticalVideoPluginApk.2(this));
  }
  
  public void a()
  {
    b();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 01 mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
    if (jdField_a_of_type_Int == 1)
    {
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.a();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null) {
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null)
      {
        QZoneRemotePluginHandler.getInstance().setAppInterface(localQQAppInterface1);
        if (System.currentTimeMillis() - a() > 60000L) {
          jdField_a_of_type_Int = 0;
        }
      }
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall 02 mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
    if ((!this.c) && (jdField_a_of_type_Int != 1))
    {
      this.c = true;
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk preInstall OK mIsPreInstalling = " + this.c + " sPreloadPluginState = " + jdField_a_of_type_Int);
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk initPluginThreshold sInitPluginThreshold = " + b);
    if (b) {
      return;
    }
    Object localObject = vay.a();
    vmp.b("QzoneVerticalVideoPluginApk", "initPluginThreshold configBean = " + localObject);
    if ((localObject == null) || (((vay)localObject).a == null))
    {
      vmp.d("QzoneVerticalVideoPluginApk", "doDownloadWeishi : configBean is null");
      return;
    }
    localObject = ((vay)localObject).a;
    this.jdField_a_of_type_Long = (((vbb)localObject).jdField_a_of_type_Long * 1000L);
    this.d = ((vbb)localObject).jdField_a_of_type_Boolean;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "$$$$$$$$$$ QzoneVerticalVideoPluginApk mQueryPluginThreshold  = " + this.jdField_a_of_type_Long + " mIsPreloadInWsRecommend = " + this.d);
    b = true;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start");
    if (paramPluginManagerClient == null) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
    for (;;)
    {
      this.c = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
      long l1 = a();
      long l2 = System.currentTimeMillis();
      long l3 = l2 - l1;
      if ((l1 > 0L) && (l3 < this.jdField_a_of_type_Long))
      {
        this.c = false;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk ERR deltaTime < " + this.jdField_a_of_type_Long + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1 + " mIsPreInstalling = " + this.c);
        return;
      }
      QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk OK deltaTime > " + this.jdField_a_of_type_Long + " deltaTime = " + l3 + " curTime = " + l2 + " lastTime = " + l1);
      paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qzone_vertical_video_plugin.apk");
      if (paramPluginManagerClient != null)
      {
        jdField_a_of_type_Boolean = true;
        QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady start  state = " + paramPluginManagerClient.mState);
        if (paramPluginManagerClient.mState == 4)
        {
          this.c = false;
          c();
          QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk onQzonePluginClientReady installed");
          return;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qzone_vertical_video_plugin.apk", new vmd(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmc
 * JD-Core Version:    0.7.0.1
 */