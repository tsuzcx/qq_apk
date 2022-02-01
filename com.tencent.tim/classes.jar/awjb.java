import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.smartdevice.ipc.SmartDeviceProxyService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;

public class awjb
  extends Observable
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static String TAG = "SmartDevicePluginLoader";
  private static awjb jdField_a_of_type_Awjb;
  private arhz jdField_a_of_type_Arhz;
  private aurf b = new aurf(Looper.getMainLooper(), this);
  private String cQR;
  private String cQS;
  private boolean dqz;
  private avfw.d e;
  private int eBp = 1;
  private int eBq;
  private avfw.d f;
  private Activity mActivity;
  private Context mContext;
  private PluginManagerClient mPluginManager;
  private long mStartTime;
  
  public static awjb a()
  {
    if (jdField_a_of_type_Awjb == null) {
      jdField_a_of_type_Awjb = new awjb();
    }
    return jdField_a_of_type_Awjb;
  }
  
  private void abI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[SmartDevicePluginLoader] handleFailed errCode:" + paramInt);
    }
    this.e = null;
    this.mActivity = null;
    this.f = null;
    this.mContext = null;
    acK(paramInt);
    String str = acfp.m(2131714638);
    if (-4 == paramInt) {
      str = acfp.m(2131714633);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader] handleFailed errCode:" + str);
      }
      return;
      if (-5 == paramInt) {
        str = acfp.m(2131714635);
      }
    }
  }
  
  private void acK(int paramInt)
  {
    super.setChanged();
    super.notifyObservers(Integer.valueOf(paramInt));
  }
  
  private void b(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[SmartDevicePluginLoader] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.mStartTime > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.mPluginManager.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          abI(-5);
          return;
        }
        this.b.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      abI(-1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[SmartDevicePluginLoader] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) && (System.currentTimeMillis() - this.mStartTime > 5000L))
    {
      abI(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      abI(-3);
      return;
    case -1: 
      abI(-6);
      return;
    case 0: 
      this.mPluginManager.installPlugin("qqsmartdevice.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        abI(-5);
        return;
      }
      this.b.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        abI(-5);
        return;
      }
      this.b.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader] install plugin success");
      }
      this.dqz = true;
      acK(0);
      elN();
      return;
    }
    abI(-2);
  }
  
  public static AppInterface d(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.tencent.device.app.SmartDeviceAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = getClassLoader(paramBaseApplicationImpl);
        localClass2 = localClassLoader.loadClass("com.tencent.device.app.SmartDeviceAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  private boolean dd(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:smartdevice".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void elN()
  {
    if ((this.cQS != null) && (this.cQS.compareToIgnoreCase("openActivity") == 0))
    {
      this.cQS = null;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader]  launchPluginActivity delay 2 second");
      }
      this.b.sendEmptyMessageDelayed(1002, 2000L);
    }
    if ((this.cQR != null) && (this.cQR.compareToIgnoreCase("launchService") == 0))
    {
      this.cQR = null;
      if ((this.mContext != null) && (this.f != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader]  launchPluginService:");
        }
        avfw.c(this.mContext, this.f);
        this.f = null;
        this.mContext = null;
      }
    }
  }
  
  public static ClassLoader getClassLoader(Context paramContext)
    throws Exception
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qqsmartdevice.apk");
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, Intent paramIntent, String paramString2, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, Class<? extends Activity> paramClass)
  {
    boolean bool = dd(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "launchPluingActivityForResult.isPluginInstalled end: " + bool);
    }
    paramAppRuntime = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
    if ((!bool) || (paramOnDismissListener != null))
    {
      paramAppRuntime.setMessage(acfp.m(2131714631));
      paramAppRuntime.setOnDismissListener(new awjc(this, paramOnDismissListener));
      if (bool) {
        paramAppRuntime.setOnShowListener(new awjd(this, paramAppRuntime));
      }
    }
    for (;;)
    {
      paramOnDismissListener = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((syw)paramOnDismissListener.getBusinessHandler(51)).bCb();
      paramIntent.putExtra("userQqResources", 2);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("param_plugin_gesturelock", true);
      this.e = new avfw.d(this.eBp);
      this.e.mPluginID = "qqsmartdevice.apk";
      this.e.mPluginName = PluginInfo.cKC;
      this.e.mUin = paramString1;
      this.e.cKu = paramString2;
      this.e.K = paramClass;
      this.e.mIntent = paramIntent;
      this.e.mRequestCode = paramInt;
      this.e.mDialog = paramAppRuntime;
      this.e.mTimeOut = 10000;
      this.e.cKv = null;
      this.mActivity = paramActivity;
      if (!this.dqz) {
        this.dqz = cF(paramOnDismissListener);
      }
      if (this.dqz)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader] launchPluginActivity: plugin is installed " + this.e.cKu);
        }
        if (bool)
        {
          avfw.a(this.mActivity, this.e);
          this.mActivity = null;
          this.e = null;
          return;
        }
        if (this.jdField_a_of_type_Arhz == null)
        {
          this.jdField_a_of_type_Arhz = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
          this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131714632));
        }
        this.jdField_a_of_type_Arhz.show();
        this.cQS = "openActivity";
        elN();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader] launchPluginActivity: waiting for plugin to install " + this.e.cKu);
      }
      this.cQS = "openActivity";
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
      return;
      paramAppRuntime = null;
    }
  }
  
  public boolean cF(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (avfw)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b("qqsmartdevice.apk");
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.mState == 4;
      }
    }
    return false;
  }
  
  public void eDT()
  {
    this.eBq = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((!this.dqz) && (!cF(localQQAppInterface))) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public void f(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), SmartDeviceProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", true);
    this.f = new avfw.d(this.eBp);
    this.f.mPluginID = "qqsmartdevice.apk";
    this.f.mPluginName = PluginInfo.cKC;
    this.f.mUin = paramAppRuntime.getAccount();
    this.f.cKu = "com.tencent.device.ipc.QQSmartDeviceService";
    this.f.mIntent = localIntent;
    this.f.mServiceConnection = paramServiceConnection;
    this.mContext = paramAppRuntime.getApplication();
    if (this.dqz)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader] launchPluginService directly");
      }
      avfw.c(paramAppRuntime.getApplication(), this.f);
      this.f = null;
      this.mContext = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[SmartDevicePluginLoader] launchPluginService: waiting for plugin to install ");
    }
    this.cQR = "launchService";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[SmartDevicePluginLoader]  ACTION_QUERY!");
      }
      b("qqsmartdevice.apk", this.mPluginManager.queryPlugin("qqsmartdevice.apk"));
      continue;
      acK(0);
      if ((this.mActivity != null) && (this.e != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader]  launchPluginActivity:" + this.e.cKu);
        }
        avfw.a(this.mActivity, this.e);
      }
      this.mActivity = null;
      this.e = null;
      this.b.sendEmptyMessageDelayed(1003, 600L);
      continue;
      if (this.jdField_a_of_type_Arhz != null)
      {
        this.jdField_a_of_type_Arhz.hide();
        this.jdField_a_of_type_Arhz = null;
      }
    }
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    int i = 1;
    this.mPluginManager = paramPluginManagerClient;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    }
    if (this.mPluginManager != null)
    {
      this.mStartTime = System.currentTimeMillis();
      paramPluginManagerClient = this.mPluginManager.queryPlugin("qqsmartdevice.apk");
      if (paramPluginManagerClient == null) {
        break label206;
      }
      if (paramPluginManagerClient.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader] plugin is installed");
        }
        this.dqz = true;
        acK(0);
        elN();
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.b.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded start down or install... retryCount: " + this.eBq);
      }
      int j = this.eBq;
      this.eBq = (j + 1);
      if (j < 3)
      {
        this.mPluginManager.installPlugin("qqsmartdevice.apk");
        i = 0;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[SmartDevicePluginLoader] not support networking");
        }
        this.dqz = true;
        acK(0);
        elN();
        return;
        label206:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjb
 * JD-Core Version:    0.7.0.1
 */