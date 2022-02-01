import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper.GetLoginKeyDataListener.1;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.proxyinner.plugin.loader.QTProxyService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;

public class aidf
  implements PluginProcessKiller
{
  private static HashMap<String, aidf> lj = new HashMap();
  private List<aidf.a> Cv = new ArrayList();
  private aidq.a jdField_a_of_type_Aidq$a = new aidg(this);
  private aidq jdField_a_of_type_Aidq;
  private long abl;
  private long abm;
  private aica jdField_b_of_type_Aica = new aica();
  private IVPluginDataReporter jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private String bMZ;
  private volatile boolean isNeedStop;
  private Map<String, IVPluginInfo> lo;
  private String mAction;
  private Context mAppContext;
  private String mAppName;
  private String mUin;
  private String mUri;
  
  private aidf(Context paramContext, String paramString1, String paramString2)
  {
    this.mAppContext = paramContext.getApplicationContext();
    this.bMZ = paramString1;
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment(paramString2);
    this.jdField_a_of_type_Aidq = aidq.a(paramContext, paramString1, paramString2);
  }
  
  public static aidf a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      aidf localaidf2 = (aidf)lj.get(str);
      aidf localaidf1 = localaidf2;
      if (localaidf2 == null)
      {
        localaidf1 = new aidf(paramContext, paramString1, paramString2);
        lj.put(str, localaidf1);
      }
      return localaidf1;
    }
    finally {}
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    IVPluginInfo localIVPluginInfo = (IVPluginInfo)this.lo.get(paramInstalledPlugin.pluginPackageName);
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "开始拉取AI票据：" + localIVPluginInfo.authType);
    }
    paramInstalledPlugin = new aidf.a(this.bMZ, localIVPluginInfo, paramInstalledPlugin, paramBoolean, paramLong);
    this.Cv.add(paramInstalledPlugin);
    if (localIVPluginInfo.authType == 1)
    {
      this.abl = System.currentTimeMillis();
      this.jdField_b_of_type_Aica.a(this.mUin, localIVPluginInfo.bMH, localIVPluginInfo.mPackageName, localIVPluginInfo.bMI, paramInstalledPlugin, true, localIVPluginInfo.mSign);
    }
    while (localIVPluginInfo.authType != 2) {
      return;
    }
    this.abm = System.currentTimeMillis();
    AppInterface localAppInterface = (AppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
    this.jdField_b_of_type_Aica.a(localAppInterface, localIVPluginInfo.bMH, this.mAppContext, localIVPluginInfo.bMI, paramInstalledPlugin);
  }
  
  private void dsb()
  {
    Iterator localIterator = this.Cv.iterator();
    while (localIterator.hasNext()) {
      ((aidf.a)localIterator.next()).dsc();
    }
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "setStop");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, IVPluginInfo> paramMap)
  {
    this.isNeedStop = false;
    this.jdField_a_of_type_Aidq.mUin = paramString2;
    if (!paramString2.equals(this.mUin)) {
      this.jdField_b_of_type_Aica.drW();
    }
    aids.ckd = TextUtils.equals(paramString1, "hy_sixgod");
    this.mUin = paramString2;
    this.mUri = paramString3;
    this.mAction = paramString4;
    this.mAppName = paramString1;
    this.lo = paramMap;
    this.Cv.clear();
    this.jdField_a_of_type_Aidq.a(this.jdField_a_of_type_Aidq$a);
    this.jdField_a_of_type_Aidq.a(paramString1, paramString4, this.bMZ, paramMap);
  }
  
  public void dsa()
  {
    this.jdField_a_of_type_Aidq.a(null);
    this.Cv.clear();
    this.mUin = null;
    this.mUri = null;
    this.mAction = null;
    if (!aqiw.isWifiEnabled(this.mAppContext)) {
      this.jdField_a_of_type_Aidq.cancelDownload();
    }
    this.jdField_a_of_type_Aidq.dsf();
  }
  
  public void onKillPluginProcess()
  {
    int i = 1;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new RuntimeException(acfp.m(2131707287));
    }
    this.isNeedStop = true;
    Intent localIntent = new Intent(this.mAppContext, QTProxyService.class);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    long l = System.currentTimeMillis();
    QLog.i("HuayangPluginNewDownloader", 2, "bindService ");
    this.mAppContext.bindService(localIntent, new aidh(this, localCountDownLatch), 1);
    for (;;)
    {
      try
      {
        if (localCountDownLatch.await(3L, TimeUnit.SECONDS)) {
          continue;
        }
        if (i != 0)
        {
          QLog.e("HuayangPluginNewDownloader", 2, "onKillPluginProcess timeout");
          aidn.bB(this.mAppContext, this.mAppContext.getPackageName() + ":troophomework");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      QLog.i("HuayangPluginNewDownloader", 2, "onKillPluginProcess end costTime:" + (System.currentTimeMillis() - l));
      return;
      i = 0;
    }
  }
  
  public class a
    implements aica.b
  {
    private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
    private final IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
    private final long abn;
    private final String bNa;
    private final boolean cjW;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private volatile boolean mStop;
    
    public a(String paramString, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
    {
      this.bNa = paramString;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
      this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
      this.cjW = paramBoolean;
      this.abn = paramLong;
    }
    
    private void ce(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (!paramBoolean2))
      {
        aidf.a(aidf.this).k(5, new Object[] { "" });
        return;
      }
      if (paramBoolean1) {}
      for (long l = 0L;; l = 2000L)
      {
        if (!this.mStop) {
          break label66;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HuayangPluginNewDownloader", 2, "需要stop");
        return;
      }
      label66:
      this.mHandler.postDelayed(new HuayangDowanloadHelper.GetLoginKeyDataListener.1(this, paramBoolean1, paramBoolean2), l);
    }
    
    public void dsc()
    {
      this.mStop = true;
      this.mHandler.removeCallbacksAndMessages(null);
    }
    
    public void l(String paramString, boolean paramBoolean, int paramInt)
    {
      int j = 1;
      long l1;
      label99:
      String str;
      if (paramBoolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.authType == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mExtras = aidf.a(aidf.this).a().ac.getExtras();
          if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.bMH)) {
            aids.Lb("2653752");
          }
          ce(this.cjW, paramBoolean);
          long l2 = System.currentTimeMillis();
          if (!"Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.bMH)) {
            break label422;
          }
          l1 = aidf.a(aidf.this);
          l1 = l2 - l1;
          if (QLog.isColorLevel()) {
            QLog.d("HuayangPluginNewDownloader", 2, "拉取票据完成 耗时：" + l1 + "appId = " + paramString + " isSuccess =  " + paramBoolean + " code = " + paramInt);
          }
          if (!aids.ckd) {
            break label434;
          }
          str = "huayang";
          label175:
          if (!paramBoolean) {
            break label442;
          }
          i = 1;
          label182:
          rar.a(str, "getLoginKey", i, (int)l1, new String[] { aidf.c(aidf.this), paramInt + "", paramString, "3.4.4" });
          paramString = aidf.a(aidf.this).opName(aidf.a(aidf.this)).opType("getLoginKey");
          if (!paramBoolean) {
            break label448;
          }
        }
      }
      label422:
      label434:
      label442:
      label448:
      for (int i = j;; i = 0)
      {
        paramString.opIn(i).opResult(paramInt).report();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.authType != 2) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mExtras = aigu.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, aidf.a(aidf.this));
        if (!"Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.bMH)) {
          break;
        }
        aids.Lb("2691711");
        break;
        if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.bMH)) {
          aids.Lb("2653753");
        }
        for (;;)
        {
          Toast.makeText(aidf.a(aidf.this), acfp.m(2131707288) + paramInt, 0).show();
          break;
          if ("Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.bMH)) {
            aids.Lb("2691712");
          }
        }
        l1 = aidf.b(aidf.this);
        break label99;
        str = "group_video";
        break label175;
        i = 0;
        break label182;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidf
 * JD-Core Version:    0.7.0.1
 */