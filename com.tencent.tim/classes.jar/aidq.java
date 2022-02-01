import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import com.tencent.hydevteam.pluginframework.pluginmanager.MultiTargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.TargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class aidq
{
  private static HashMap<String, aidq> sInstanceMap = new HashMap();
  private volatile List<ProgressFuture<InstalledPlugin>> Cx;
  private long abp;
  private aidq.a jdField_b_of_type_Aidq$a;
  private final UpgradeablePluginManager jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager;
  private IVPluginDataReporter jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private String bMZ;
  private String bNf;
  private final boolean ckb;
  private volatile boolean ckc;
  private Handler.Callback g = new aidr(this);
  private Map<String, IVPluginInfo> lo;
  private String mAction;
  private final Context mAppContext;
  private String mAppName;
  private int mProgress;
  private Runnable mRunnable = new HuayangPluginNewDownloader.3(this);
  private volatile boolean mRunning;
  private long mStartTime;
  private long mTotalSize;
  private final Handler mUiHandler;
  public String mUin = "";
  
  private aidq(Context paramContext, File paramFile, String paramString)
  {
    this.mAppContext = paramContext;
    this.mUiHandler = new Handler(Looper.getMainLooper(), this.g);
    this.ckb = aida.aoS();
    this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(paramFile, paramString, this.ckb);
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment(paramString);
  }
  
  private void D(int paramInt, Object paramObject)
  {
    paramObject = Message.obtain(this.mUiHandler, paramInt, paramObject);
    this.mUiHandler.sendMessage(paramObject);
  }
  
  private void KX(boolean paramBoolean)
  {
    Intent localIntent = new Intent(aidi.lw(this.bMZ));
    int i;
    if (paramBoolean)
    {
      i = 1;
      localIntent.putExtra("key_isCache", i);
      this.mAppContext.sendBroadcast(localIntent);
      if (!paramBoolean)
      {
        if (!aidi.mU(this.bMZ)) {
          break label62;
        }
        aids.Lb("2714209");
      }
    }
    label62:
    while (!aidi.mV(this.bMZ))
    {
      return;
      i = 0;
      break;
    }
    aids.Lb("2714208");
  }
  
  public static aidq a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      aidq localaidq = (aidq)sInstanceMap.get(str);
      paramString1 = localaidq;
      if (localaidq == null)
      {
        paramString1 = new aidq(paramContext.getApplicationContext(), f(paramContext), paramString2);
        sInstanceMap.put(str, paramString1);
      }
      return paramString1;
    }
    finally {}
  }
  
  private InstalledPlugin a(ProgressFuture<InstalledPlugin> paramProgressFuture)
    throws Exception
  {
    if (!this.ckc) {
      this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 4, paramProgressFuture));
    }
    if ((!this.ckc) && (aids.ckd))
    {
      this.mUiHandler.sendMessageDelayed(Message.obtain(this.mUiHandler, 1, 30, 0), 2000L);
      this.mUiHandler.sendMessageDelayed(Message.obtain(this.mUiHandler, 1, 70, 0), 6000L);
    }
    try
    {
      paramProgressFuture = (InstalledPlugin)paramProgressFuture.get();
      if (!this.ckc) {
        this.mUiHandler.removeMessages(4);
      }
      return paramProgressFuture;
    }
    catch (Exception paramProgressFuture)
    {
      if (!this.ckc) {
        this.mUiHandler.removeMessages(4);
      }
      throw paramProgressFuture;
    }
  }
  
  private InstalledPlugin a(InstalledPlugin paramInstalledPlugin)
    throws Exception
  {
    log("HuayangPluginNewDownloader", "getPluginFromServer: 开始从服务器中获取DownloadedPluginInfo开始...");
    long l = System.currentTimeMillis();
    int i = this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.upgradeIfNeededThenInit(10L, TimeUnit.SECONDS);
    l = System.currentTimeMillis() - l;
    log("HuayangPluginNewDownloader", "upgradeIfNeededThenInit status:" + i + " time:" + l);
    VersionChecker localVersionChecker;
    Object localObject2;
    StringBuilder localStringBuilder;
    label150:
    String str;
    Object localObject1;
    if (i != -1)
    {
      e("downloadPluginManagerFinish", i, (int)l, "", "");
      if (i == 1) {
        aids.Lb("2653797");
      }
    }
    else
    {
      localVersionChecker = this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getVersionChecker();
      localObject2 = null;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "SOURCE_CGI";
      arrayOfString[1] = "SOURCE_BACKUP_STABLE";
      localStringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label1144;
      }
      str = arrayOfString[i];
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        TargetDownloadInfo localTargetDownloadInfo = localVersionChecker.checkForceUpdate(str, this.mUin, this.mAppName, this.ckb, paramInstalledPlugin);
        localObject1 = localObject2;
        if (str.equals("SOURCE_CGI"))
        {
          localObject1 = localObject2;
          aids.Lb("2653754");
          localObject1 = localObject2;
          log("HuayangPluginNewDownloader", acfp.m(2131707293) + localTargetDownloadInfo.url);
          localObject1 = localObject2;
          this.mTotalSize = localTargetDownloadInfo.size;
          localObject1 = localObject2;
          if ((localTargetDownloadInfo.forceUpdate) && (paramInstalledPlugin != null))
          {
            localObject1 = localObject2;
            b(paramInstalledPlugin);
          }
          localObject1 = localObject2;
          if (!(localTargetDownloadInfo instanceof MultiTargetDownloadInfo)) {
            continue;
          }
          localObject1 = localObject2;
          localObject4 = ((MultiTargetDownloadInfo)localTargetDownloadInfo).allSubTargets;
          if (localObject4 == null) {
            continue;
          }
          localObject1 = localObject2;
          localObject4 = ((Map)localObject4).entrySet().iterator();
          localObject1 = localObject2;
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject1 = localObject2;
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          localObject1 = localObject2;
          if (!TextUtils.equals((CharSequence)localEntry.getKey(), this.bMZ)) {
            continue;
          }
          localObject1 = localObject2;
          this.mTotalSize = ((TargetDownloadInfo)localEntry.getValue()).size;
          continue;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "从" + str + "获取插件失败。", localException1);
        }
        aide.j(localException1);
        localStringBuilder.append(localException1.toString());
        localStringBuilder.append("。");
        if ((str.equals("SOURCE_CGI")) && (this.ckc))
        {
          paramInstalledPlugin = (InstalledPlugin)localObject1;
          localObject1 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
          if (paramInstalledPlugin != null) {
            break label1138;
          }
          bool = true;
          log("HuayangPluginNewDownloader", bool);
          aids.Lb("2653760");
          if (this.ckc) {
            aids.Lb("2528856");
          }
          throw new VersionCheckException("从服务器获取InstalledPlugin失败。" + localStringBuilder.toString());
          aids.Lb("2653798");
          break;
          localObject1 = localException1;
          if (!str.equals("SOURCE_BACKUP_STABLE")) {
            continue;
          }
          localObject1 = localException1;
          aids.Lb("2653758");
          continue;
        }
      }
      catch (VersionCheckException localVersionCheckException)
      {
        localObject1 = localException1;
        if (str.equals("SOURCE_CGI"))
        {
          localObject1 = localException1;
          aids.Lb("2653755");
          localObject1 = localException1;
          throw localVersionCheckException;
        }
        localObject1 = localException1;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject1 = localException1;
        aids.Lb("2653759");
        continue;
        localObject1 = localException1;
        Object localObject4 = Message.obtain(this.mUiHandler, 0, Long.valueOf(this.mTotalSize));
        localObject1 = localException1;
        this.mUiHandler.sendMessage((Message)localObject4);
        localObject1 = localException1;
        if ("checkVersion".equals(this.mAction)) {
          return null;
        }
        localObject1 = localException1;
        if (!this.ckc)
        {
          localObject1 = localException1;
          publishProgress(10);
        }
        localObject1 = localException1;
        log("HuayangPluginNewDownloader", "updatePlugin start");
        localObject1 = localException1;
        l = System.currentTimeMillis();
        localObject1 = localException1;
        this.Cx = this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.updatePlugin(this.mAppName, localVersionCheckException, this.bMZ);
        try
        {
          localInstalledPlugin = a((ProgressFuture)this.Cx.get(0));
          localObject3 = localInstalledPlugin;
          int k = (int)(System.currentTimeMillis() - l);
          localObject3 = localInstalledPlugin;
          e("updatePlugin", localInstalledPlugin.pluginFileType, k, "", "");
          localObject3 = localInstalledPlugin;
          log("HuayangPluginNewDownloader", acfp.m(2131707307) + k);
          localObject3 = localInstalledPlugin;
          if (!str.equals("SOURCE_CGI")) {
            continue;
          }
          localObject3 = localInstalledPlugin;
          aids.Lb("2653761");
          localObject1 = localInstalledPlugin;
          localObject3 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
          if (localInstalledPlugin != null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException2)
        {
          InstalledPlugin localInstalledPlugin;
          localObject1 = localObject3;
          if (!str.equals("SOURCE_CGI")) {
            continue;
          }
          localObject1 = localObject3;
          aids.Lb("2653762");
          localObject1 = localObject3;
          throw localException2;
          localObject1 = localObject3;
          if (!str.equals("SOURCE_BACKUP_STABLE")) {
            continue;
          }
          localObject1 = localObject3;
          aids.Lb("2653766");
          continue;
          bool = false;
          continue;
        }
        localObject1 = localInstalledPlugin;
        log("HuayangPluginNewDownloader", bool);
        return localInstalledPlugin;
        localObject3 = localInstalledPlugin;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject3 = localInstalledPlugin;
        aids.Lb("2653765");
        continue;
        if (this.Cx != null)
        {
          localObject3 = this.Cx.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ((ProgressFuture)((Iterator)localObject3).next()).cancel(true);
            continue;
          }
          this.Cx = null;
        }
        i += 1;
        localObject3 = localObject1;
      }
      break label150;
      label1138:
      boolean bool = false;
      continue;
      label1144:
      paramInstalledPlugin = (InstalledPlugin)localObject3;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin)
  {
    String str2 = null;
    long l = System.currentTimeMillis();
    boolean bool = TextUtils.equals(this.mAppName, "group_video");
    try
    {
      this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.mAppContext, paramInstalledPlugin, bool).get();
      log("HuayangPluginNewDownloader", acfp.m(2131707289));
      str1 = str2;
      if (!this.ckc)
      {
        b(paramInstalledPlugin, true);
        str1 = str2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "预加载过程中出错：", localException);
        }
        if (!this.ckc) {
          D(6, localException.toString());
        }
        aide.j(localException);
        continue;
        paramInstalledPlugin = "";
      }
    }
    i = (int)(System.currentTimeMillis() - l);
    str2 = paramInstalledPlugin.toString();
    if (str1 != null)
    {
      paramInstalledPlugin = str1.getMessage();
      e("preLoadFinish", 0, i, str2, paramInstalledPlugin);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, Exception paramException, int paramInt)
  {
    if (paramInstalledPlugin != null)
    {
      e("preDownloadFinish", 1, paramInt, paramInstalledPlugin.toString(), null);
      return;
    }
    if (paramException != null) {}
    for (paramInstalledPlugin = paramException.getMessage();; paramInstalledPlugin = "")
    {
      e("preDownloadFinish", 0, paramInt, paramInstalledPlugin, null);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append(acfp.m(2131707295));
    boolean bool;
    if (paramInstalledPlugin == null)
    {
      bool = true;
      log("HuayangPluginNewDownloader", bool);
      KX(this.ckc);
      D(2, paramInstalledPlugin);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (localObject = "fromCache";; localObject = "fromServer")
    {
      a(true, paramInstalledPlugin, (String)localObject, null);
      this.mUiHandler.removeMessages(4);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean, InstalledPlugin paramInstalledPlugin, String paramString1, String paramString2)
  {
    int j = (int)(System.currentTimeMillis() - this.mStartTime);
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (paramInstalledPlugin != null) {
        break label45;
      }
    }
    label45:
    for (paramInstalledPlugin = null;; paramInstalledPlugin = paramInstalledPlugin.pluginFile.toString())
    {
      e("downloadFinish", i, j, paramInstalledPlugin, paramString2);
      return;
      i = 0;
      break;
    }
  }
  
  private void b(InstalledPlugin paramInstalledPlugin)
  {
    this.ckc = false;
    if (this.jdField_b_of_type_Aidq$a != null) {
      this.jdField_b_of_type_Aidq$a.k(10, new Object[0]);
    }
    e("doForceUpdate", 0, 0, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForConfigPluginLoader);
    Intent localIntent = new Intent("action_iv_plugin_update");
    localIntent.putExtra("plugin", paramInstalledPlugin);
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
    log("HuayangPluginNewDownloader", acfp.m(2131707309));
  }
  
  private void b(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    log("HuayangPluginNewDownloader", acfp.m(2131707297) + paramInstalledPlugin);
    paramInstalledPlugin = Message.obtain(this.mUiHandler, 5, paramInstalledPlugin);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      paramInstalledPlugin.arg1 = i;
      this.mUiHandler.sendMessage(paramInstalledPlugin);
      return;
    }
  }
  
  private void dse()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getCachedLatestPlugin(this.mAppName);
    Object localObject4;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = new ArrayList();
      localObject4 = ((List)localObject1).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject3).add(((InstalledPlugin)((Iterator)localObject4).next()).pluginVersionForPluginLoaderManage);
      }
      Collections.sort((List)localObject3);
      localObject3 = localObject3.toString();
      if ((this.bNf != null) && (!TextUtils.equals((CharSequence)localObject3, this.bNf)))
      {
        log("HuayangPluginNewDownloader", acfp.m(2131707304) + (String)localObject3 + " mPluginVersion:" + this.bNf);
        aidn.bB(this.mAppContext, this.mAppContext.getPackageName() + ":troophomework");
      }
      this.bNf = ((String)localObject3);
    }
    long l;
    if ((localObject1 != null) && (((List)localObject1).size() == 1) && (((InstalledPlugin)((List)localObject1).get(0)).pluginFileType == 0))
    {
      localObject3 = (InstalledPlugin)((List)localObject1).get(0);
      this.ckc = true;
      a((InstalledPlugin)localObject3, true);
      b((InstalledPlugin)localObject3, true);
      l = 0L;
      if (this.ckc) {
        l = System.currentTimeMillis();
      }
      if ((TextUtils.equals(this.mAction, "slientDownload")) || (!this.ckc)) {
        this.mUiHandler.sendEmptyMessage(7);
      }
      localObject1 = (IVPluginInfo)this.lo.get(this.bMZ);
      if (localObject1 == null) {
        break label553;
      }
      localObject1 = ((IVPluginInfo)localObject1).extra;
      if (localObject1 == null) {
        break label553;
      }
    }
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("preloadOnly")) {
          break label553;
        }
        bool = ((JSONObject)localObject1).getBoolean("preloadOnly");
        if ((!"huiyin".equals(this.mAppName)) || (aqiw.isWifiEnabled(this.mAppContext)) || (!bool)) {
          break label559;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject4 = ((List)localObject1).iterator();
        localObject1 = null;
        localObject3 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject3 = (InstalledPlugin)((Iterator)localObject4).next();
        if (((InstalledPlugin)localObject3).pluginPackageName.equals(this.bMZ))
        {
          this.ckc = true;
          a((InstalledPlugin)localObject3, true);
          b((InstalledPlugin)localObject3, true);
          localObject1 = localObject3;
          continue;
        }
        b((InstalledPlugin)localObject3, false);
        continue;
      }
      if (aidt.ls.get(this.mAppName) != null) {
        aids.report(String.valueOf(((aidt)aidt.ls.get(this.mAppName)).ddg));
      }
      localObject3 = null;
      break;
      label553:
      bool = false;
    }
    try
    {
      label559:
      localObject3 = a((InstalledPlugin)localObject3);
      Object localObject2 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, localException1, new Object[0]);
        }
        aide.j(localException1);
        localObject3 = null;
      }
    }
    if ("checkVersion".equals(this.mAction))
    {
      this.mRunning = false;
      return;
    }
    if (!this.ckc) {
      if (localException1 == null)
      {
        publishProgress(100);
        a((InstalledPlugin)localObject3, false);
        label645:
        if ((localObject3 == null) || (PluginRunningPath.isPreOdexFileExists(this.mAppContext, ((InstalledPlugin)localObject3).pluginPackageName, ((InstalledPlugin)localObject3).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject3).pluginFile.getName()))) {
          break label911;
        }
        log("HuayangPluginNewDownloader", acfp.m(2131707303));
        a((InstalledPlugin)localObject3);
      }
    }
    for (;;)
    {
      localObject4 = this.Cx;
      this.Cx = null;
      this.mRunning = false;
      if (localObject4 == null) {
        break;
      }
      int i = 1;
      while (i < ((List)localObject4).size())
      {
        try
        {
          localObject3 = (InstalledPlugin)((ProgressFuture)((List)localObject4).get(i)).get();
          if (localObject3 == null) {}
        }
        catch (Exception localException2)
        {
          label911:
          localObject3 = null;
        }
        try
        {
          if (!PluginRunningPath.isPreOdexFileExists(this.mAppContext, ((InstalledPlugin)localObject3).pluginPackageName, ((InstalledPlugin)localObject3).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject3).pluginFile.getName()))
          {
            bool = TextUtils.equals(this.mAppName, "group_video");
            this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.mAppContext, (InstalledPlugin)localObject3, bool).get();
          }
          if ((localObject3 != null) && (!this.ckc) && ((IVPluginInfo)this.lo.get(((InstalledPlugin)localObject3).pluginPackageName) != null))
          {
            aids.Lb("2633399");
            b((InstalledPlugin)localObject3, false);
          }
          i += 1;
        }
        catch (Exception localException3)
        {
          break label938;
        }
      }
      D(3, localException1.toString());
      a(false, null, null, localException1.toString());
      break label645;
      a((InstalledPlugin)localObject3, localException1, (int)(System.currentTimeMillis() - l));
      break label645;
      if ((localObject3 != null) && (!this.ckc)) {
        b((InstalledPlugin)localObject3, true);
      }
    }
    label938:
    aids.Lb("2633400");
    if (localObject3 == null) {}
    for (Object localObject3 = null;; localObject3 = ((InstalledPlugin)localObject3).toString())
    {
      e("loadSecondPlugin", 0, 0, (String)localObject3, localException2.toString());
      break;
    }
  }
  
  private void e(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    IVPluginDataReporter localIVPluginDataReporter = this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType(paramString1);
    if (TextUtils.isEmpty(this.mAction))
    {
      paramString1 = "null";
      paramString2 = localIVPluginDataReporter.opName(paramString1).opIn(paramInt1).opResult(paramInt2).d1(paramString2).d2(paramString3);
      if (!this.ckc) {
        break label86;
      }
    }
    label86:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString2.d3(paramString1).d4(this.bMZ).report();
      return;
      paramString1 = this.mAction;
      break;
    }
  }
  
  public static File f(Context paramContext)
  {
    return paramContext.getFilesDir();
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void publishProgress(int paramInt)
  {
    Message localMessage = Message.obtain(this.mUiHandler, 1, paramInt, 0);
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void a(aidq.a parama)
  {
    this.jdField_b_of_type_Aidq$a = parama;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map<String, IVPluginInfo> paramMap)
  {
    if (this.mRunning) {
      return;
    }
    this.mRunning = true;
    this.ckc = false;
    this.Cx = null;
    this.mAction = paramString2;
    this.bMZ = paramString3;
    this.lo = paramMap;
    this.mStartTime = System.currentTimeMillis();
    this.mAppName = paramString1;
    this.mProgress = 0;
    this.mUiHandler.removeCallbacks(this.mRunnable);
    this.abp = System.currentTimeMillis();
    this.mUiHandler.postDelayed(this.mRunnable, 40000L);
    e("startDownload", 0, 0, "", "");
    ThreadManager.postDownLoadTask(new HuayangPluginNewDownloader.2(this), 8, null, false);
  }
  
  public void cancelDownload()
  {
    if ((this.Cx != null) && (!this.Cx.isEmpty()))
    {
      aids.Lb("2597859");
      Iterator localIterator = this.Cx.iterator();
      while (localIterator.hasNext()) {
        ((ProgressFuture)localIterator.next()).cancel(true);
      }
    }
  }
  
  public void dsf()
  {
    e("cancelLauncher", 0, (int)(System.currentTimeMillis() - this.mStartTime), "", "");
  }
  
  static abstract interface a
  {
    public abstract void k(int paramInt, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidq
 * JD-Core Version:    0.7.0.1
 */