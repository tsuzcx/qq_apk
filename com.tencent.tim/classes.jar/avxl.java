import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager.4;
import cooperation.qzone.plugin.PluginRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class avxl
  extends avyr.a
{
  public static void a(Activity paramActivity, avxl.b paramb)
  {
    if (paramb.cKv != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramb.cKv, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new avxm();
    if ((paramb.mDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, paramb.mDialog, paramb.mPluginName, paramb.mPluginID, paramb.dmV, paramb.mTimeOut).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, paramb, (avxl.a)localObject);
      return;
    }
    ((avxl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramActivity, paramb, (avxl.a)localObject);
  }
  
  public static void a(Context paramContext, avxl.b paramb)
  {
    avxn localavxn = new avxn();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramb, localavxn);
      return;
    }
    ((avxl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, paramb, localavxn);
  }
  
  static void b(Activity paramActivity, avxl.b paramb)
  {
    if ((paramb == null) || (paramActivity == null) || (paramb.mIntent == null)) {}
    for (;;)
    {
      return;
      paramb.mIntent.setClass(paramActivity, paramb.K);
      if (TextUtils.isEmpty(paramb.mIntent.getStringExtra("uin")))
      {
        paramb.mIntent.putExtra("uin", paramb.mUin);
        paramb.mIntent.putExtra("qzone_uin", paramb.mUin);
      }
      paramb.mIntent.putExtra("pluginsdk_selfuin", paramb.mUin);
      paramb.mIntent.putExtra("clsUploader", anoo.class.getName());
      try
      {
        File localFile = new File(avyo.getPluginInstallDir(paramActivity), paramb.mPluginID);
        PluginProxyActivity.openActivityForResult(paramActivity, paramb.mPluginName, paramb.mPluginID, localFile.getCanonicalPath(), paramb.cKu, paramb.mIntent, paramb.mRequestCode);
        if ((paramb.mDialog != null) && ((paramb.mDialog instanceof arig)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2130772162, 2130772162);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void b(Context paramContext, avxl.b paramb)
  {
    avxo localavxo = new avxo();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramb, localavxo);
      return;
    }
    ((avxl)((QQAppInterface)localAppRuntime).getManager(175)).a(paramContext, paramb, localavxo);
  }
  
  private static void b(Context paramContext, avxl.b paramb, avxl.a parama)
  {
    avyi.a(paramContext, new avxp(paramContext, paramb, parama));
  }
  
  static void c(Context paramContext, avxl.b paramb)
  {
    if ((TextUtils.isEmpty(paramb.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramb.mUin)))
    {
      paramb.mIntent.putExtra("uin", paramb.mUin);
      paramb.mIntent.putExtra("qzone_uin", paramb.mUin);
    }
    paramb.mIntent.putExtra("pluginsdk_selfuin", paramb.mUin);
    paramb.mIntent.putExtra("clsUploader", anoo.class.getName());
    Object localObject = paramb.mPluginID;
    localObject = new File(avyo.getPluginInstallDir(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramb.mPluginName, paramb.mPluginID, ((File)localObject).getCanonicalPath(), paramb.cKu, paramb.mIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  static void d(Context paramContext, avxl.b paramb)
  {
    if ((TextUtils.isEmpty(paramb.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramb.mUin)))
    {
      paramb.mIntent.putExtra("uin", paramb.mUin);
      paramb.mIntent.putExtra("qzone_uin", paramb.mUin);
    }
    paramb.mIntent.putExtra("pluginsdk_selfuin", paramb.mUin);
    paramb.mIntent.putExtra("clsUploader", anoo.class.getName());
    Object localObject = paramb.mPluginID;
    localObject = new File(avyo.getPluginInstallDir(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (paramb.mServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, paramb.mPluginName, paramb.mPluginID, (String)localObject, paramb.cKu, paramb.mIntent, paramb.mServiceConnection);
        return;
      }
      ThreadManager.post(new IQZonePluginManager.4(paramContext, paramb, (String)localObject), 5, null, false);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PluginDebug", 2, "doLaunchPluginService", paramContext);
      }
    }
  }
  
  public abstract PluginRecord a(String paramString);
  
  public abstract void a(Context paramContext, avxl.b paramb, avxl.a parama);
  
  public abstract void a(avxq paramavxq, int paramInt)
    throws RemoteException;
  
  public abstract boolean a(String paramString, avxr paramavxr, int paramInt)
    throws RemoteException;
  
  public abstract void eCv()
    throws RemoteException;
  
  public abstract boolean isPluginInstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract boolean tB(String paramString);
  
  public abstract boolean tr(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, Context paramContext, avxl.b paramb);
  }
  
  public static class b
  {
    public Class<? extends Activity> K;
    public List<RemoteCommand> LA = new ArrayList();
    public String cKu;
    public String cKv;
    int cdu = 0;
    public boolean dmV = true;
    String mApkFilePath;
    public Dialog mDialog;
    public Intent mIntent;
    public String mPluginID;
    public String mPluginName;
    public int mRequestCode = -1;
    public ServiceConnection mServiceConnection;
    public int mTimeOut = 10000;
    public String mUin;
    
    public b(int paramInt)
    {
      this.cdu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxl
 * JD-Core Version:    0.7.0.1
 */