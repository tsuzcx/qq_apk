import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.util.Pair;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class avlz
{
  private static avlz jdField_a_of_type_Avlz;
  private OnPluginInstallListener.Stub jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub = new avma(this);
  private Pair<WeakReference<Context>, Integer> n;
  
  private static void W(QQAppInterface paramQQAppInterface, int paramInt)
  {
    anot.a(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  public static avlz a()
  {
    if (jdField_a_of_type_Avlz == null) {}
    try
    {
      if (jdField_a_of_type_Avlz == null) {
        jdField_a_of_type_Avlz = new avlz();
      }
      return jdField_a_of_type_Avlz;
    }
    finally {}
  }
  
  private void aZ(Context paramContext, int paramInt)
  {
    if (paramInt == 2)
    {
      gq(paramContext);
      return;
    }
    gp(paramContext);
  }
  
  private int as(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (avfw)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface == null)
    {
      avoc.d("QRPluginManager", "PluginManager is NOT ready");
      return 0;
    }
    paramQQAppInterface = paramQQAppInterface.b("qqreaderplugin.apk");
    if (paramQQAppInterface == null)
    {
      avoc.d("QRPluginManager", "ReaderPlugin is NOT found");
      return 0;
    }
    return paramQQAppInterface.mState;
  }
  
  private void checkMainProcess()
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      avoc.e("QRPluginManager", "checkMainProcess: 老插件的加载逻辑必须在主进程调用");
    }
  }
  
  private void gp(Context paramContext)
  {
    avoc.d("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("params_uin_for_reader", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("is_preload_reader_plugin", false);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqreaderplugin.apk";
    locald.mPluginName = "qqreader";
    locald.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    locald.cKu = "com.qqreader.ReaderPreloadReaderProcess";
    locald.mIntent = localIntent;
    avfw.b(paramContext, locald);
    avoc.d("QRPluginManager", "load plugin end");
  }
  
  private void gq(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    avlw.a(paramContext, localIntent, "com.qqreader.pureader.EmptyActivity", new avmb(this));
  }
  
  public boolean EU()
  {
    checkMainProcess();
    return as((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()) == 4;
  }
  
  public void aY(Context paramContext, int paramInt)
  {
    checkMainProcess();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = as(localQQAppInterface);
    avoc.u("QRPluginManager", "launchPlugin: plugin state=" + i + ", launchType=" + paramInt);
    if (i == 4)
    {
      this.n = null;
      aZ(paramContext, paramInt);
    }
    do
    {
      return;
      this.n = new Pair(new WeakReference(paramContext), Integer.valueOf(paramInt));
    } while (i == 1);
    ((avfw)localQQAppInterface.getManager(27)).installPlugin("qqreaderplugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub);
  }
  
  public void gn(Context paramContext)
  {
    aY(paramContext, 2);
  }
  
  public void go(Context paramContext)
  {
    aY(paramContext, 1);
  }
  
  public void installPlugin()
  {
    checkMainProcess();
    ((avfw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).installPlugin("qqreaderplugin.apk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlz
 * JD-Core Version:    0.7.0.1
 */