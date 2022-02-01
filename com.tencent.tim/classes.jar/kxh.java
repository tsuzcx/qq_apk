import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class kxh
{
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("ReadInJoyResetUtils", 1, "[getSharedPreferences] return null for runtime is null");
      return null;
    }
    paramAppRuntime = "readinjoy_sp_reset_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  public static void aHI()
  {
    int i = aqmj.ax(BaseApplicationImpl.getApplication(), kxm.getAccount());
    int j = nN();
    QLog.d("ReadInJoyResetUtils", 2, "[maybeClearAllConfigs] remoteVersion=" + i + ", localVersion=" + j);
    if (i != j) {
      try
      {
        aHJ();
        kyg.aIf();
        aHM();
        aHN();
        aHO();
        pU(i);
        QLog.i("ReadInJoyResetUtils", 1, "[maybeClearAllConfigs] done resetting, update local version to " + i);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ReadInJoyResetUtils", 1, "[maybeClearAllConfigs] ", localException);
        return;
      }
    }
    QLog.d("ReadInJoyResetUtils", 2, "[maybeClearAllConfigs] won't reset");
  }
  
  public static void aHJ()
  {
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_COMMON_CONFIG - 92 to 0");
    aqmj.B(BaseApplicationImpl.getApplication(), 0, kxm.getAccount());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_MERGE_CONFIG_CMD - 79 to 0");
    aqmj.A(BaseApplicationImpl.getApplication(), 0, kxm.getAccount());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_CONFIG_CMD - 72 to 0");
    aqmj.X(BaseApplicationImpl.getApplication(), kxm.getAccount(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_SETTING_CMD - 72 to 0");
    aqmj.aI(BaseApplicationImpl.getApplication(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_SEARCH_JUMP_URL_CONFIG - 292 to 0");
    aqmj.g(BaseApplicationImpl.getApplication(), "readinjoy_search_jump_url_version", kxm.getAccount(), 0);
  }
  
  private static void aHK()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] QQSETTING_KANDIAN_DOWNLOAD_PIC_IN_WIFI_ONLY set to false");
    SettingCloneUtil.writeValue(BaseApplicationImpl.getApplication(), kxm.getAccount(), null, "qqsetting_kandian_download_pic_flag", false);
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] done");
  }
  
  public static void aHL()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP");
    c(BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP success");
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP");
    c(PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP success");
  }
  
  public static void aHM()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] ");
    Object localObject = awit.a(kxm.getAppRuntime(), true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).clear();
      if (((SharedPreferences.Editor)localObject).commit())
      {
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account related sp success");
        localObject = awit.a(kxm.getAppRuntime(), false, true);
        if (localObject == null) {
          break label136;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).clear();
        if (!((SharedPreferences.Editor)localObject).commit()) {
          break label125;
        }
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account unrelated sp success");
      }
    }
    for (;;)
    {
      aHL();
      aHK();
      return;
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account related sp");
      break;
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
      break;
      label125:
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account unrelated sp");
      continue;
      label136:
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
    }
  }
  
  public static void aHN()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase");
    try
    {
      EntityManagerFactory localEntityManagerFactory = lbz.a().getEntityManagerFactory();
      if ((localEntityManagerFactory instanceof ReadInJoyEntityManagerFactory)) {
        ((ReadInJoyEntityManagerFactory)localEntityManagerFactory).aJc();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase: ", localException);
    }
  }
  
  public static void aHO()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyLocalFiles");
    aHP();
    aHQ();
    clearRedPoint();
  }
  
  private static void aHP()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearSkinRes");
    Object localObject = new File(arug.Dh());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str = localObject[i];
            try
            {
              if (str.getName().toLowerCase().contains("readinjoy"))
              {
                str = str.getAbsolutePath();
                aqhq.delete(str, false);
                QLog.d("ReadInJoyResetUtils", 2, "[clearSkinRes] deleted " + str);
              }
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] ", localException2);
              }
            }
          }
        }
      }
    }
    try
    {
      localObject = (mfn)kxm.getAppRuntime().getManager(271);
      if (localObject != null)
      {
        ((mfn)localObject).aOY();
        QLog.d("ReadInJoyResetUtils", 2, "[clearSkinRes] successfully delete guide data in db");
        return;
      }
      QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] operation manager is null");
      return;
    }
    catch (Exception localException1)
    {
      QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] ", localException1);
    }
  }
  
  private static void aHQ()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearProteusStyles");
    npv.aZY();
  }
  
  private static void c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences != null)
    {
      List localList = mis.a(paramSharedPreferences.getAll().keySet(), new kxi());
      paramSharedPreferences = paramSharedPreferences.edit();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramSharedPreferences.remove((String)localIterator.next());
      }
      paramSharedPreferences.commit();
      QLog.d("ReadInJoyResetUtils", 2, "[removeReadInJoyKeysInSharedPreferences] removed " + localList);
    }
  }
  
  private static void clearRedPoint()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint");
    try
    {
      Object localObject = ((QQAppInterface)kxm.getAppRuntime()).b();
      ((QQMessageFacade)localObject).N(acbn.blx, 7220);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_MERGE_UIN cleared");
      ((QQMessageFacade)localObject).N(acbn.blO, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_SUBSCRIBE_UIN cleared");
      ((QQMessageFacade)localObject).N(acbn.blw, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).N(acbn.blw, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).N(acbn.blv, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: OLD_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).N(acbn.blv, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).N(acbn.blN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: WEISHI_UIN cleared");
      ((QQMessageFacade)localObject).N(acbn.blP, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_DAILY cleared");
      localObject = awit.b((QQAppInterface)kxm.getAppRuntime(), 1);
      if (localObject != null)
      {
        if (((SharedPreferences)localObject).edit().clear().commit())
        {
          QLog.d("ReadInJoyResetUtils", 2, "[clearRedPoint] clear red point in sp xml success");
          return;
        }
        QLog.d("ReadInJoyResetUtils", 2, "[clearRedPoint] clear red point in sp xml failed");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetUtils", 2, "clearRedPoint: ", localException);
    }
  }
  
  public static int nN()
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime());
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyResetUtils", 2, "[getLocalResetVersion] return 0 for sp is null");
      return 0;
    }
    return localSharedPreferences.getInt("readinjoy_local_reset_config_version", 0);
  }
  
  private static void pU(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime());
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyResetUtils", 2, "[putLocalResetVersion] sp == null");
      return;
    }
    localSharedPreferences.edit().putInt("readinjoy_local_reset_config_version", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxh
 * JD-Core Version:    0.7.0.1
 */