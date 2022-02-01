import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.upgrade.UpgradeController.1;
import com.tencent.mobileqq.upgrade.UpgradeController.2;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public final class aqap
  implements Handler.Callback, aqah.a, aryx, arzf, arzx.a
{
  private static aqap jdField_a_of_type_Aqap;
  private final ArrayList<aqap.c> CF = new ArrayList();
  private aqah jdField_a_of_type_Aqah;
  private aqap.a jdField_a_of_type_Aqap$a;
  private auru jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private UpgradeDetailWrapper b;
  private BaseApplicationImpl jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl;
  private DownloadInfo jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private volatile boolean cTn;
  private boolean cTo;
  public boolean cTp = true;
  private boolean cTq;
  public volatile String csg;
  private int dYk;
  private WeakReference<aqap.b> im;
  private volatile boolean mIsClose;
  
  private aqap()
  {
    reset(false);
  }
  
  public static String BI()
  {
    String str2 = "";
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((aqap)localObject).b;
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          str1 = "" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
        }
      }
    }
    return str1;
  }
  
  public static String BJ()
  {
    int j = 0;
    Object localObject = a();
    int i = j;
    if (localObject != null)
    {
      localObject = ((aqap)localObject).b;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          i = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        }
      }
    }
    return String.valueOf(i);
  }
  
  private void Xm(int paramInt)
  {
    try
    {
      accy localaccy = (accy)((QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).getBusinessHandler(4);
      String str = this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
      this.csg = (str + "_" + paramInt);
      this.dYk = paramInt;
      localaccy.g(str, paramInt, this.csg);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Xn(int paramInt)
  {
    if (this.mIsClose) {}
    aqap.b localb;
    do
    {
      do
      {
        return;
      } while (this.im == null);
      localb = (aqap.b)this.im.get();
    } while (localb == null);
    if (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
      localb.a(paramInt, this.b, this);
    }
    this.im = null;
  }
  
  private void Xo(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "invokeStateChangedToListeners:" + paramInt);
    }
    synchronized (this.CF)
    {
      Iterator localIterator = this.CF.iterator();
      if (localIterator.hasNext()) {
        ((aqap.c)localIterator.next()).a(paramInt, this);
      }
    }
  }
  
  public static aqap a()
  {
    if (jdField_a_of_type_Aqap == null) {
      jdField_a_of_type_Aqap = new aqap();
    }
    return jdField_a_of_type_Aqap;
  }
  
  private int aR(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (getDownloadState() == 4)) {
      return 0;
    }
    if ((this.b == null) || (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {
      return 1;
    }
    String str;
    Bundle localBundle;
    if ((this.b != null) && (this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a != null) && (this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csi != null))
    {
      str = this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csi;
      localBundle = new Bundle();
      localBundle.putString(aryv.PARAM_SNG_APPID, "100686848");
      localBundle.putString(aryv.PARAM_URL, this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(aryv.PARAM_TASK_PACKNAME, this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
      localBundle.putInt(aryv.PARAM_ACTIONCODE, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(aryv.PARAM_PATCH_UPDATE, true);
      }
      localBundle.putString(aryv.PARAM_VIA, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(aryv.PARAM_APPNAME, str);
      if (paramInt2 == 0) {
        break label324;
      }
      localBundle.putString(aryv.PARAM_NOTIFYKEY, "_100686848");
      localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
      i = paramInt2;
      if (paramInt1 != 5)
      {
        i = paramInt2;
        if (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 0) {}
      }
    }
    for (int i = 0;; i = paramInt2)
    {
      localBundle.putString(aryv.PARAM_TASK_APPID, "6633");
      localBundle.putInt(aryv.PARAM_TASK_VERSION, this.dYk);
      localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, true);
      localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, true);
      localBundle.putInt(aryv.PARAM_TO_PAGETYPE, 1);
      localBundle.putInt(aryv.cDB, this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      aryr.d(BaseActivity.sTopActivity, localBundle, "biz_src_jc_update", this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i);
      return 0;
      str = "新版手Q";
      break;
      label324:
      localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, true);
    }
  }
  
  private boolean bV(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = aqar.a(paramQQAppInterface);
    boolean bool2;
    boolean bool1;
    if (paramQQAppInterface.aBN())
    {
      bool2 = paramQQAppInterface.b(this.b);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeController", 2, String.format("needShowDialog needShowInstallDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.a(this.b);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("UpgradeController", 2, String.format("needShowDialog needShowDownloadDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
    return bool2;
  }
  
  public static boolean bW(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    Object localObject = a();
    boolean bool1;
    if (localObject != null)
    {
      localObject = ((aqap)localObject).b;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)) {
        if ((((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType > 0) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch == 1))
        {
          bool1 = true;
          if (!bool1) {
            break label101;
          }
          if (accy.j(paramQQAppInterface, ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp)) {
            break label96;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        bool2 = ((aizo)paramQQAppInterface.getManager(244)).aqc();
      }
      return bool2;
      bool1 = false;
      break;
      label96:
      bool1 = false;
      continue;
      label101:
      continue;
      bool1 = false;
    }
  }
  
  private static PackageInfo c(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
  }
  
  private void ecX()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = "100686848";
    localDownloadInfo.packageName = this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
    localDownloadInfo.cDG = "6633";
    localDownloadInfo.versionCode = this.dYk;
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "queryDownloadInfo:" + localDownloadInfo);
    }
    aryr.b(localArrayList, this);
  }
  
  private void eda()
  {
    try
    {
      if (!aBL())
      {
        this.jdField_a_of_type_Aqap$a = new aqap.a();
        this.jdField_a_of_type_Aqap$a.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void edb()
  {
    try
    {
      if (aBL())
      {
        this.jdField_a_of_type_Aqap$a.stop();
        this.jdField_a_of_type_Aqap$a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void edc()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "initDownloadEnv: " + this.cTo);
      }
      if (!this.cTo)
      {
        arzx.a().a(this);
        aryr.c(this);
        this.cTo = true;
      }
      return;
    }
    finally {}
  }
  
  private void edd()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + this.cTo);
      }
      if (this.cTo)
      {
        arzx.a().b(this);
        arzx.a().destroy();
        if (this.jdField_a_of_type_Aqah != null)
        {
          aryr.b(this.jdField_a_of_type_Aqah);
          this.jdField_a_of_type_Aqah = null;
        }
        this.dYk = 0;
        aryr.d(this);
        this.cTo = false;
      }
      return;
    }
    finally {}
  }
  
  private boolean isSignaturesSame(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if (paramArrayOfSignature1 == null) {}
    HashSet localHashSet;
    do
    {
      do
      {
        return false;
      } while (paramArrayOfSignature2 == null);
      localHashSet = new HashSet();
      int j = paramArrayOfSignature1.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramArrayOfSignature1[i]);
        i += 1;
      }
      paramArrayOfSignature1 = new HashSet();
      j = paramArrayOfSignature2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
        i += 1;
      }
    } while (!localHashSet.equals(paramArrayOfSignature1));
    return true;
  }
  
  private void onDownloadSuccess()
  {
    Sv(true);
    Object localObject = (QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X800716C", "0X800716C", 0, 0, "", "", "", "");
    int i = 0;
    this.cTp = false;
    if (aqiw.isWifiConnected(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      i = 1;
    }
    ((QQAppInterface)localObject).getPreferences().edit().putInt("APPID_SHOULD_DOWNLOAD", b().jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(i));
    ((HashMap)localObject).put("param_ErrMsg", "success");
    anpc.a(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  public static String pc(String paramString)
  {
    return aurr.addParameter(paramString, "nt", aqao.BG());
  }
  
  public void B(boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = this.mIsClose;
        if (bool) {
          return;
        }
        if (!paramString1.equals(this.csg)) {
          continue;
        }
        if (this.jdField_a_of_type_Aqah == null)
        {
          i = 1;
          if (!paramBoolean) {
            break label90;
          }
          if (i != 0) {
            ecX();
          }
          this.jdField_a_of_type_Aqah = new aqah(paramString2, this);
          aryr.a(this.jdField_a_of_type_Aqah);
          this.csg = null;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label90:
      if (i != 0)
      {
        this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
        this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a = null;
        Xn(-1);
      }
    }
  }
  
  public void F(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onException:" + paramInt + ", " + paramString);
    }
    Xn(0);
  }
  
  public void Sv(boolean paramBoolean)
  {
    ThreadManager.post(new UpgradeController.1(this, paramBoolean), 5, null, false);
  }
  
  public void Ui(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    Xm(this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn);
  }
  
  public void Xk(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      anpc.a(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeWritten", bool, 0L, 0L, localHashMap, "", true);
      return;
    }
  }
  
  public void a(aqap.c paramc)
  {
    if (paramc == null) {
      return;
    }
    synchronized (this.CF)
    {
      if (!this.CF.contains(paramc)) {
        this.CF.add(paramc);
      }
      return;
    }
  }
  
  public boolean a(String paramString, PackageInfo paramPackageInfo)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
    boolean bool1;
    if ((paramPackageInfo.signatures != null) && (paramPackageInfo.signatures.length > 0))
    {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), 64);
        if (((PackageInfo)localObject).packageName.equals(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
        {
          if ((((PackageInfo)localObject).signatures == null) || (((PackageInfo)localObject).signatures.length <= 0)) {
            break label177;
          }
          if (isSignaturesSame(((PackageInfo)localObject).signatures, paramPackageInfo.signatures))
          {
            if (!QLog.isColorLevel()) {
              break label236;
            }
            QLog.d("UpgradeConfigManager", 2, "target apk's signature is same with mobileqq");
            break label236;
          }
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.d("UpgradeConfigManager", 2, "target apk's signature is wrong! path=" + paramString);
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
      }
      QLog.d("UpgradeConfigManager", 2, "WTF? cannot find mobileqq in local app");
      return false;
      label177:
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeConfigManager", 2, "WTF? cannot get signature from local mobileqq");
        return false;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeConfigManager", 2, "cannot get signature from apk:" + paramString);
        return false;
        label236:
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, aqap.b paramb)
  {
    this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a = accy.a(paramUpgradeInfo);
    if ((paramb == null) || (paramUpgradeInfo == null)) {
      return false;
    }
    if (paramUpgradeInfo.iUpgradeType == 0) {
      return false;
    }
    if (this.mIsClose) {
      return false;
    }
    if ((QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime() == null) {
      return false;
    }
    edc();
    this.im = new WeakReference(paramb);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "handleUpgradeInfo packageName = " + this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ", bGray = " + paramUpgradeInfo.bGray + ", versioncode = " + this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn);
    }
    paramUpgradeInfo = new ApkUpdateParam(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), paramUpgradeInfo.bGray, this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn);
    paramb = new ArrayList();
    paramb.add(paramUpgradeInfo);
    arzx.a().no(paramb);
    return true;
  }
  
  boolean aBL()
  {
    return this.jdField_a_of_type_Aqap$a != null;
  }
  
  public boolean aBM()
  {
    String str1 = null;
    if ((getDownloadState() == 4) && (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo != null))
    {
      String str2 = this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.filePath;
      if (TextUtils.isEmpty(str2))
      {
        QLog.e("UpgradeConfigManager", 1, "checkJacking：  cannot get path to apk");
        return true;
      }
      Object localObject = this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageArchiveInfo(str2, 64);
        if (localObject == null) {
          break label251;
        }
        if (((PackageInfo)localObject).packageName.equals(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
        {
          String str3 = PluginStatic.encodeFile(str2);
          QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
          if (localQQAppInterface != null) {
            str1 = localQQAppInterface.getPreferences().getString("upgrade_check_md5", "");
          }
          if (!str3.equals(str1))
          {
            QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... md5 is different. apkMd5File=" + str3 + " apkMd5Record=" + str1);
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        PackageInfo localPackageInfo;
        for (;;)
        {
          QLog.d("UpgradeController", 1, localThrowable, new Object[0]);
          localPackageInfo = null;
        }
        if (a(str2, localPackageInfo))
        {
          if (re(str2))
          {
            QLog.d("UpgradeConfigManager", 1, "checkJacking：  success!!! i think it is safe");
            return false;
          }
          QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... dex injected");
          return true;
        }
        QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... signature is wrong.");
        return true;
      }
      QLog.d("UpgradeConfigManager", 1, "checkJacking：  package name is wrong!");
      return true;
    }
    label251:
    QLog.e("UpgradeConfigManager", 1, "checkJacking：  apk has not been downloaded or cannot get download info");
    return true;
  }
  
  public void ac(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog needDesc=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str = accy.ay(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity"))) {
      localBaseActivity.runOnUiThread(new UpgradeController.2(this, paramBoolean, paramQQAppInterface));
    }
  }
  
  public UpgradeDetailWrapper b()
  {
    return this.b;
  }
  
  public void b(aqap.c paramc)
  {
    if (paramc == null) {
      return;
    }
    synchronized (this.CF)
    {
      if (this.CF.contains(paramc)) {
        this.CF.remove(paramc);
      }
      return;
    }
  }
  
  public void bl(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onResult Status:" + this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    Xn(0);
  }
  
  public void ecY()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if ((this.b == null) || (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1)) {}
    do
    {
      return;
      if ((this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.downloadType == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "MYAPP has work, do not allow download by wifi");
        }
        accy.u(localQQAppInterface, false);
        Sv(false);
        return;
      }
    } while (this.cTn);
    startDownload(accy.b(localQQAppInterface, false));
  }
  
  public void ecZ()
  {
    if ((this.cTn) && (aBL())) {
      stopDownload();
    }
  }
  
  public void es(QQAppInterface paramQQAppInterface)
  {
    int i = getDownloadState();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog downloadState=%s", new Object[] { Integer.valueOf(i) }));
    }
    if (i == 4) {}
    for (i = 1134018;; i = 11340003)
    {
      paramQQAppInterface.getHandler(Conversation.class).obtainMessage(i).sendToTarget();
      return;
    }
  }
  
  public void ft(Context paramContext)
  {
    int j = 1;
    if ((this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.getState() != 4)) {
      return;
    }
    for (int i = j;; i = 0)
    {
      try
      {
        if (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
        {
          if (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.downloadType != 1) {
            continue;
          }
          i = j;
        }
        aR(5, i);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpgradeController", 2, "installApk:", paramContext);
      return;
    }
  }
  
  public int getDownloadState()
  {
    int j = 0;
    int i = j;
    if (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
    {
      i = j;
      switch (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.getState())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "getDownloadState: " + i);
      }
      return i;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        paramMessage = this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl;
        if (!this.cTq) {
          continue;
        }
        i = 2131696633;
        Toast.makeText(paramMessage, i, 0).show();
        paramMessage = ((QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).getHandler(Conversation.class);
        if ((paramMessage != null) && (a().getDownloadState() == 4)) {
          paramMessage.obtainMessage(1134019).sendToTarget();
        }
      }
      catch (Throwable paramMessage)
      {
        int i;
        continue;
      }
      return true;
      i = 2131696632;
    }
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public boolean mm(int paramInt)
  {
    if (paramInt == this.dYk) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.csg == null)) {
        Xm(paramInt);
      }
      return bool;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.appId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.cTn = false;
    edb();
    this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    Xo(getDownloadState());
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.appId)) {
      return;
    }
    this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.cTn = false;
    edb();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadError: " + paramInt1 + ", " + paramString);
    }
    Xo(getDownloadState());
    paramInt2 = paramInt1;
    if (aqiw.isWifiConnected(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    anpc.a(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (!"100686848".equals(paramDownloadInfo.appId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.cTn = false;
    Object localObject2 = paramDownloadInfo.filePath;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (paramDownloadInfo.downloadType == 1)
      {
        paramDownloadInfo = aryy.a().a(paramDownloadInfo);
        localObject1 = localObject2;
        if (paramDownloadInfo != null) {
          localObject1 = paramDownloadInfo.mSavePath;
        }
      }
    }
    localObject2 = c(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl, (String)localObject1);
    paramDownloadInfo = "";
    int i;
    if (localObject2 != null)
    {
      i = ((PackageInfo)localObject2).versionCode;
      paramDownloadInfo = ((PackageInfo)localObject2).packageName;
    }
    for (;;)
    {
      int k = aewh.getVersionCode(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl);
      localObject2 = PluginStatic.encodeFile((String)localObject1);
      QLog.i("UpgradeController", 1, "upgradeDownloadFinish md5=" + (String)localObject2);
      if ((this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName().equals(paramDownloadInfo)) && (k > 0) && (i >= k))
      {
        if (localQQAppInterface == null) {
          break;
        }
        Xo(getDownloadState());
        localQQAppInterface.getPreferences().edit().putLong("YELLOW_BAR_LAST_SHOW", 0L).putString("upgrade_check_md5", (String)localObject2).commit();
        onDownloadSuccess();
        edb();
        return;
      }
      boolean bool = this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.isAutoInstall;
      if (bool)
      {
        aryr.cancelNotification("_100686848");
        edb();
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new HashMap();
        if (i >= k) {
          break label449;
        }
      }
      label449:
      for (i = 101;; i = 9527)
      {
        ((HashMap)localObject1).put("param_FailCode", Integer.toString(i));
        ((HashMap)localObject1).put("param_ErrMsg", "MD5:" + (String)localObject2 + "_PN:" + paramDownloadInfo);
        anpc.a(this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject1, "", true);
        if (bool) {
          break;
        }
        this.jdField_a_of_type_Auru.sendEmptyMessage(0);
        return;
        this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.isAutoInstall = false;
        if (!aBL()) {}
        for (int j = 1;; j = 0)
        {
          aR(10, j);
          break;
        }
      }
      i = 0;
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.appId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    Xo(getDownloadState());
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.appId)) {
          this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadUpdate Status:" + this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo.getState());
      }
      Xo(getDownloadState());
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.appId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    Xo(getDownloadState());
  }
  
  public void onResult(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        if (this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn == paramArrayList.versioncode) {
          this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "onCheckUpdateSucceed:" + paramArrayList.url + " -- " + paramArrayList.updatemethod);
        }
      }
    }
    if (this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      Xm(this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      return;
    }
    Xm(this.b.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void pauseDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    if (!aBL()) {}
    for (int i = 1;; i = 0)
    {
      aR(3, i);
      return;
    }
  }
  
  /* Error */
  public boolean re(String paramString)
  {
    // Byte code:
    //   0: new 895	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 897	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 900	java/io/File:exists	()Z
    //   13: ifeq +73 -> 86
    //   16: new 946	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 949	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: iconst_2
    //   28: newarray byte
    //   30: astore 4
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 953	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: aload 4
    //   43: iconst_0
    //   44: baload
    //   45: bipush 80
    //   47: if_icmpne +14 -> 61
    //   50: aload 4
    //   52: iconst_1
    //   53: baload
    //   54: istore_2
    //   55: iload_2
    //   56: bipush 75
    //   58: if_icmpeq +20 -> 78
    //   61: aload_3
    //   62: ifnull +7 -> 69
    //   65: aload_3
    //   66: invokevirtual 956	java/io/FileInputStream:close	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 957	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 956	java/io/FileInputStream:close	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 957	java/io/IOException:printStackTrace	()V
    //   93: goto -7 -> 86
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: astore_1
    //   102: ldc 171
    //   104: iconst_1
    //   105: ldc 79
    //   107: aload 4
    //   109: invokestatic 959	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_3
    //   113: ifnull -27 -> 86
    //   116: aload_3
    //   117: invokevirtual 956	java/io/FileInputStream:close	()V
    //   120: goto -34 -> 86
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 957	java/io/IOException:printStackTrace	()V
    //   128: goto -42 -> 86
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 956	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 957	java/io/IOException:printStackTrace	()V
    //   149: goto -7 -> 142
    //   152: astore_3
    //   153: goto -19 -> 134
    //   156: astore 4
    //   158: goto -58 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	aqap
    //   0	161	1	paramString	String
    //   54	5	2	i	int
    //   24	93	3	localFileInputStream	java.io.FileInputStream
    //   131	12	3	localObject1	Object
    //   152	1	3	localObject2	Object
    //   30	21	4	arrayOfByte	byte[]
    //   96	12	4	localThrowable1	Throwable
    //   156	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   82	86	88	java/io/IOException
    //   16	25	96	java/lang/Throwable
    //   116	120	123	java/io/IOException
    //   16	25	131	finally
    //   138	142	144	java/io/IOException
    //   27	32	152	finally
    //   34	41	152	finally
    //   102	112	152	finally
    //   27	32	156	java/lang/Throwable
    //   34	41	156	java/lang/Throwable
  }
  
  public void reset(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b != null) && (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.b.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {}
    do
    {
      return;
      stopDownload();
      this.mIsClose = paramBoolean;
      this.jdField_a_of_type_Auru.removeMessages(0);
      edd();
      this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
      this.cTp = true;
    } while ((!paramBoolean) && (this.b != null));
    this.b = new UpgradeDetailWrapper(null, null);
  }
  
  public void resumeDownload()
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.jdField_c_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i = j;
    if (this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i = j;
      if (this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i = 12;
      }
    }
    if (!aBL()) {}
    for (j = 1;; j = 0)
    {
      aR(i, j);
      return;
    }
  }
  
  void start(boolean paramBoolean)
  {
    int j = 1;
    if (!this.cTn)
    {
      this.cTn = true;
      if ((this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.b.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod != 4)) {
        break label55;
      }
    }
    label55:
    for (int i = 12;; i = 2)
    {
      if (paramBoolean) {
        j = 0;
      }
      aR(i, j);
      return;
    }
  }
  
  public void startDownload(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "startDownload:" + paramBoolean + ", " + this.cTn);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_c_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (getDownloadState() == 4) {}
    while (this.cTn) {
      return;
    }
    accy.u(localQQAppInterface, paramBoolean);
    if (paramBoolean)
    {
      eda();
      return;
    }
    start(false);
  }
  
  /* Error */
  public void stopDownload()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 171
    //   10: iconst_2
    //   11: ldc_w 982
    //   14: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 203	aqap:cTn	Z
    //   21: ifeq +22 -> 43
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 203	aqap:cTn	Z
    //   29: aload_0
    //   30: invokevirtual 984	aqap:pauseDownload	()V
    //   33: aload_0
    //   34: invokespecial 838	aqap:edb	()V
    //   37: ldc_w 275
    //   40: invokestatic 893	aryr:cancelNotification	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: goto -14 -> 33
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	aqap
    //   46	1	1	localException	Exception
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	46	java/lang/Exception
    //   2	17	50	finally
    //   17	29	50	finally
    //   29	33	50	finally
    //   33	43	50	finally
  }
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
  
  public class a
    implements INetEventHandler
  {
    private Context mContext = aqap.a(aqap.this);
    
    public a() {}
    
    public void onNetChangeEvent(boolean paramBoolean)
    {
      int i = aqiw.getNetworkType(this.mContext);
      if (i == 0) {
        if (aqap.a(aqap.this)) {
          aqap.this.pauseDownload();
        }
      }
      do
      {
        return;
        if (i == 1)
        {
          if (!aqap.a(aqap.this))
          {
            aqap.this.start(true);
            return;
          }
          aqap.this.resumeDownload();
          return;
        }
      } while ((i != 0) || (!aqap.a(aqap.this)));
      aqap.this.pauseDownload();
    }
    
    /* Error */
    public void start()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 25	aqap$a:mContext	Landroid/content/Context;
      //   6: aload_0
      //   7: invokestatic 54	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerNetChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)V
      //   10: invokestatic 58	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
      //   13: ifeq +14 -> 27
      //   16: aload_0
      //   17: getfield 17	aqap$a:this$0	Laqap;
      //   20: iconst_1
      //   21: invokevirtual 43	aqap:start	(Z)V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   30: ifeq -6 -> 24
      //   33: ldc 65
      //   35: iconst_2
      //   36: ldc 67
      //   38: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   41: goto -17 -> 24
      //   44: astore_1
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: athrow
      //   49: astore_1
      //   50: goto -40 -> 10
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	a
      //   44	4	1	localObject	Object
      //   49	1	1	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   2	10	44	finally
      //   10	24	44	finally
      //   27	41	44	finally
      //   2	10	49	java/lang/Exception
    }
    
    public void stop()
    {
      try
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        label7:
        aqap.this.stopDownload();
        return;
      }
      catch (Exception localException)
      {
        break label7;
      }
      finally {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, aqap paramaqap);
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, aqap paramaqap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqap
 * JD-Core Version:    0.7.0.1
 */