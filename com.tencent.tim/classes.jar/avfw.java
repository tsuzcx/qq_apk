import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.6;
import cooperation.plugin.PluginInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public abstract class avfw
  extends RemotePluginManager.Stub
  implements Manager
{
  private static ConcurrentLinkedQueue<avfw.e> S = new ConcurrentLinkedQueue();
  private static PluginManagerHelper.OnPluginManagerLoadedListener a;
  public static long azv;
  private static volatile PluginManagerClient b;
  
  public static avfw a(QQAppInterface paramQQAppInterface)
  {
    return new avgl(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, avfw.d paramd)
  {
    a(paramContext, paramd, null);
  }
  
  public static void a(Context paramContext, avfw.d paramd, avfw.a parama)
  {
    Object localObject;
    if (paramd.cKv != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramd.cKv, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    paramd.mIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    parama = new avfx(parama);
    if (((paramContext instanceof Activity)) && (paramd.mDialog != null) && (!((Activity)paramContext).isFinishing())) {
      new SplashDialogWrapper(paramContext, paramd.mDialog, paramd.mPluginName, paramd.mPluginID, paramd.dmV, paramd.mTimeOut).show();
    }
    if (paramd.a != null) {
      if (TextUtils.equals(paramd.a.mPluginId, paramd.mPluginID))
      {
        paramd.a.dqV();
        paramd.a.end();
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        break;
      }
      a(paramContext, paramd, parama);
      return;
      ahyg.KO(paramd.mPluginID);
    }
    ((avfw)((QQAppInterface)localObject).getManager(27)).c(paramContext, paramd, parama);
  }
  
  private static void a(Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    if ((a != null) && (System.currentTimeMillis() - azv < 500L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "handleOtherProcessWait");
      }
      azv = System.currentTimeMillis();
      S.add(new avfw.e(paramContext, paramd, paramb));
      return;
    }
    azv = 0L;
    if ((b == null) || (!b.useful()))
    {
      S.add(new avfw.e(paramContext, paramd, paramb));
      if (a == null) {
        a = new avfy();
      }
      PluginManagerHelper.getPluginInterface(paramContext, a);
      return;
    }
    b(paramContext, paramd, paramb);
  }
  
  public static void b(Context paramContext, avfw.d paramd)
  {
    avga localavga = new avga();
    paramd.mIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramd.a != null) {
      paramd.a.begin();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      a(paramContext, paramd, localavga);
      return;
    }
    ((avfw)((QQAppInterface)localAppRuntime).getManager(27)).c(paramContext, paramd, localavga);
  }
  
  private static void b(Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    if (b == null) {
      paramb.a(false, paramContext, paramd);
    }
    PluginBaseInfo localPluginBaseInfo;
    do
    {
      return;
      localPluginBaseInfo = b.queryPlugin(paramd.mPluginID);
      if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4)) {
        break;
      }
    } while (paramb == null);
    paramd.mApkFilePath = localPluginBaseInfo.mInstalledPath;
    paramd.a(localPluginBaseInfo);
    paramb.a(true, paramContext, paramd);
    return;
    if (QLog.isDevelopLevel())
    {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + b.useful());
      QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
    }
    b.installPlugin(paramd.mPluginID, new avfz(paramb, paramd, paramContext));
  }
  
  public static void c(Context paramContext, avfw.d paramd)
  {
    avgb localavgb = new avgb();
    paramd.mIntent.putExtra("launchTimeStart", System.currentTimeMillis());
    if (paramd.a != null) {
      paramd.a.begin();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      a(paramContext, paramd, localavgb);
      return;
    }
    ((avfw)((QQAppInterface)localAppRuntime).getManager(27)).c(paramContext, paramd, localavgb);
  }
  
  static void d(Context paramContext, avfw.d paramd)
  {
    if (paramContext == null) {}
    label222:
    do
    {
      for (;;)
      {
        return;
        ou(paramd.LA);
        paramd.mIntent.setClass(paramContext, paramd.K);
        if (TextUtils.isEmpty(paramd.mIntent.getStringExtra("uin")))
        {
          paramd.mIntent.putExtra("uin", paramd.mUin);
          paramd.mIntent.putExtra("qzone_uin", paramd.mUin);
        }
        paramd.mIntent.putExtra("pluginsdk_selfuin", paramd.mUin);
        paramd.mIntent.putExtra("clsUploader", anoo.class.getName());
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        paramd.ezN();
        if ((paramContext instanceof Activity)) {
          PluginProxyActivity.openActivityForResult((Activity)paramContext, paramd.mPluginName, paramd.mPluginID, paramd.mApkFilePath, paramd.cKu, paramd.mIntent, paramd.mRequestCode);
        }
        while ((paramContext instanceof Activity))
        {
          if (!paramd.mIntent.getBooleanExtra("extra_is_from_p2v_edit", false)) {
            break label222;
          }
          ((Activity)paramContext).overridePendingTransition(2130772009, 2130772013);
          return;
          PluginProxyActivity.openActivity(paramContext, paramd.mPluginName, paramd.mPluginID, paramd.mApkFilePath, paramd.cKu, paramd.mIntent);
        }
      }
      if ((paramd.mDialog != null) && ((paramd.mDialog instanceof arig)))
      {
        ((Activity)paramContext).overridePendingTransition(2130772162, 2130772162);
        return;
      }
    } while ((paramd.ewU <= 0) || (paramd.ewV <= 0));
    ((Activity)paramContext).overridePendingTransition(paramd.ewU, paramd.ewV);
  }
  
  static void e(Context paramContext, avfw.d paramd)
  {
    ou(paramd.LA);
    paramd.ezN();
    if ((TextUtils.isEmpty(paramd.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramd.mUin)))
    {
      paramd.mIntent.putExtra("uin", paramd.mUin);
      paramd.mIntent.putExtra("qzone_uin", paramd.mUin);
    }
    paramd.mIntent.putExtra("pluginsdk_selfuin", paramd.mUin);
    paramd.mIntent.putExtra("clsUploader", anoo.class.getName());
    PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramd.mPluginName, paramd.mPluginID, paramd.mApkFilePath, paramd.cKu, paramd.mIntent);
  }
  
  static void f(Context paramContext, avfw.d paramd)
  {
    ou(paramd.LA);
    paramd.ezN();
    if ((TextUtils.isEmpty(paramd.mIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramd.mUin)))
    {
      paramd.mIntent.putExtra("uin", paramd.mUin);
      paramd.mIntent.putExtra("qzone_uin", paramd.mUin);
    }
    paramd.mIntent.putExtra("pluginsdk_selfuin", paramd.mUin);
    paramd.mIntent.putExtra("clsUploader", anoo.class.getName());
    if (paramd.mServiceConnection != null)
    {
      PluginProxyService.bindService(paramContext, paramd.mPluginName, paramd.mPluginID, paramd.mApkFilePath, paramd.cKu, paramd.mIntent, paramd.mServiceConnection);
      return;
    }
    ThreadManager.post(new IPluginManager.6(paramContext, paramd), 5, null, false);
  }
  
  public static void jo(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains(acfp.m(2131707481))) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), acfp.m(2131707483) + paramString2 + acfp.m(2131707482), 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + acfp.m(2131707484), 0).show();
  }
  
  static void ou(List<RemoteCommand> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RemoteCommand localRemoteCommand = (RemoteCommand)paramList.get(i);
        if ((localRemoteCommand != null) && (!localPluginCommunicationHandler.containsCmd(localRemoteCommand.getCmd()))) {
          localPluginCommunicationHandler.register((RemoteCommand)paramList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public abstract void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract PluginInfo b(String paramString);
  
  public abstract void c(Context paramContext, avfw.d paramd, avfw.b paramb);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void ezM();
  
  public abstract void installPlugin(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
  
  public static abstract interface a
  {
    public abstract void Wz(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, Context paramContext, avfw.d paramd);
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, PluginInfo paramPluginInfo, avfw paramavfw);
  }
  
  public static class d
  {
    public Class<? extends Activity> K;
    public List<RemoteCommand> LA = new ArrayList();
    public ahyh a;
    PluginBaseInfo a;
    public boolean aqY;
    public String cKu;
    public String cKv;
    int cdu = 0;
    public boolean dmV = true;
    public int ewU;
    public int ewV;
    public String mApkFilePath;
    public Dialog mDialog;
    public Intent mIntent;
    public String mPluginID;
    public String mPluginName;
    public int mRequestCode = -1;
    public ServiceConnection mServiceConnection;
    public int mTimeOut = 10000;
    public String mUin;
    
    public d(int paramInt)
    {
      this.cdu = paramInt;
    }
    
    public void a(PluginBaseInfo paramPluginBaseInfo)
    {
      this.a = paramPluginBaseInfo;
    }
    
    public void ezN()
    {
      if ((this.mIntent != null) && (this.a != null))
      {
        QLog.d("plugin_tag", 1, "pluginStartupAttachInfo dex2Oat " + this.a.costDex2Oat + "lib " + this.a.costLib + "download " + this.a.costDownload + "apk " + this.a.costApk);
        if ((this.a.costDex2Oat != 0L) || (this.a.costLib != 0L) || (this.a.costDownload != 0L) || (this.a.costApk != 0L))
        {
          this.mIntent.putExtra("pluginOatCost", this.a.costDex2Oat);
          this.mIntent.putExtra("pluginLibCost", this.a.costLib);
          this.mIntent.putExtra("pluginDownloadCost", this.a.costDownload);
          this.mIntent.putExtra("pluginApkCost", this.a.costApk);
          this.a.costDex2Oat = 0L;
          this.a.costLib = 0L;
          this.a.costDownload = 0L;
          this.a.costApk = 0L;
        }
      }
    }
  }
  
  static final class e
  {
    avfw.b jdField_b_of_type_Avfw$b;
    avfw.d jdField_b_of_type_Avfw$d;
    Context context;
    
    e(Context paramContext, avfw.d paramd, avfw.b paramb)
    {
      this.context = paramContext;
      this.jdField_b_of_type_Avfw$d = paramd;
      this.jdField_b_of_type_Avfw$b = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfw
 * JD-Core Version:    0.7.0.1
 */