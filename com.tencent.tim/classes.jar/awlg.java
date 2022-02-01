import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.util.VipARUtils.3;
import cooperation.vip.ar.util.VipARUtils.4;
import cooperation.vip.ar.util.VipARUtils.5;
import java.io.File;

public class awlg
{
  private static awlg a;
  private static String cRe = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine.jar", "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar");
  private static String cRf = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine_md5", "3c4cd9ff849e9b6576ffa6d8fe60bcaa");
  private static String cRg = QzoneConfig.getInstance().getConfig("QZoneSetting", "libTar.so", "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so");
  private static String cRh = QzoneConfig.getInstance().getConfig("QZoneSetting", "lib_tar_so_md5", "3a0222c4b9d441a4cf4a3ac620f5dfbc");
  private static long iu;
  private static long ka;
  private boolean dqR;
  private boolean dqS;
  
  public static awlg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awlg();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean aF(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("VipARUtils", 1, "buildModel is empty");
        return false;
      }
      QZLog.d("VipARUtils", 1, " current device buildModel is '" + str + "'");
      if ((paramString == null) || (paramString.length() == 0)) {
        break label144;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("VipARUtils", 1, "device in black list");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label144:
    return false;
  }
  
  private static boolean aNf()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("vip_tar_engine.jar");
    QZLog.i("VipARUtils", 4, new Object[] { "isTarEngineJarExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  private static boolean aNg()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("libTar.so");
    QZLog.i("VipARUtils", 4, new Object[] { "isTarEngineSoExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.executeOnSubThread(new VipARUtils.5(paramString1, paramString2, paramString3, paramInt));
  }
  
  public static boolean bZ(int paramInt)
  {
    boolean bool = true;
    ka = System.currentTimeMillis();
    QLog.i("VipARPreDownload", 1, " offest = " + (ka - iu));
    if (ka - iu > paramInt) {}
    for (;;)
    {
      iu = ka;
      return bool;
      bool = false;
    }
  }
  
  private static boolean cx(String paramString1, String paramString2)
  {
    paramString1 = LocalMultiProcConfig.getString(paramString1, null);
    if (TextUtils.isEmpty(paramString1)) {}
    while (!paramString1.equalsIgnoreCase(paramString2)) {
      return true;
    }
    return false;
  }
  
  private void eEp()
  {
    QZLog.i("VipARUtils", "loadTarEngineJarModule");
    if (aNf())
    {
      QZLog.i("VipARUtils", 4, new Object[] { "tarEngineJarPath =", QzoneModuleManager.getInstance().getModuleFilePath("vip_tar_engine.jar") });
      this.dqR = QzoneModuleManager.getInstance().loadModule("vip_tar_engine.jar", getClass().getClassLoader(), true, true);
      if (this.dqR) {
        QZLog.i("VipARUtils", "loadTarEngineJarModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("VipARUtils", "loadTarEngineJarModule fail");
  }
  
  private void eEq()
  {
    QZLog.i("VipARUtils", "loadTarEngineSoModule");
    String str;
    if (aNg()) {
      str = QzoneModuleManager.getInstance().getModuleFilePath("libTar.so");
    }
    try
    {
      System.load(str);
      this.dqS = true;
      if (this.dqS)
      {
        QZLog.i("VipARUtils", "loadTarEngineSoModule success");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.dqS = false;
        QZLog.i("VipARUtils", 4, new Object[] { "loadTarEngineSoModule =", str });
      }
      QZLog.i("VipARUtils", "loadTarEngineSoModule fail");
    }
  }
  
  public static void jF(String paramString1, String paramString2)
  {
    b("vip_ar_gift", paramString1, paramString2, 0);
  }
  
  public void a(awlg.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.dqR)
    {
      parama.bX(this.dqR);
      return;
    }
    if ((cx("VipARUtils_JAR_md5", cRf)) || (!aNf())) {}
    for (int i = 1; i == 0; i = 0)
    {
      eEp();
      parama.bX(this.dqR);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("vip_tar_engine.jar", new awlh(this, parama));
  }
  
  public void b(awlg.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.dqS)
    {
      parama.bX(this.dqS);
      return;
    }
    if ((cx("VipARUtils_SO_md5", cRh)) || (!aNg())) {}
    for (int i = 1; i == 0; i = 0)
    {
      eEq();
      parama.bX(this.dqS);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("libTar.so", new awli(this, parama));
  }
  
  public void eEn()
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new VipARUtils.3(this));
  }
  
  public void eEo()
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new VipARUtils.4(this));
  }
  
  public static abstract interface a
  {
    public abstract void bX(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlg
 * JD-Core Version:    0.7.0.1
 */