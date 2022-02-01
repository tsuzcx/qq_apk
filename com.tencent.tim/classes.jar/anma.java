import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anma
{
  private static SharedPreferences Y;
  
  private static String Ad()
  {
    if (anmb.is64Bit()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  static anmj a(LoadParam.LoadItem paramLoadItem, SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    Object localObject = a(paramLoadItem, paramSoDetailInfo.url);
    String str = ((anmj)localObject).mSoPath;
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).filePos = 1;
      ((DownloadParam)localObject).url = paramSoDetailInfo.url;
      ((DownloadParam)localObject).md5ForChecked = paramSoDetailInfo.md5;
      paramSoDetailInfo = PreloadManager.a((DownloadParam)localObject);
      if ((paramSoDetailInfo != null) && (paramSoDetailInfo.folderPath != null))
      {
        paramLoadItem = new File(paramSoDetailInfo.folderPath, paramLoadItem.soFileName).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.i("SoDataUtil", 2, "[getLocalInfoFromCacheOrConfig] return info from sync method");
        }
        paramLoadItem = new anmj(paramLoadItem);
      }
    }
    do
    {
      return paramLoadItem;
      paramLoadItem = "";
      break;
      paramLoadItem = (LoadParam.LoadItem)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("SoDataUtil", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
    return localObject;
  }
  
  static anmj a(LoadParam.LoadItem paramLoadItem, String paramString)
  {
    try
    {
      paramLoadItem = anmj.a(getPref().getString(a(paramLoadItem), ""));
      boolean bool = TextUtils.equals(paramString, paramLoadItem.mUrl);
      if (bool) {
        return paramLoadItem;
      }
    }
    catch (Throwable paramLoadItem)
    {
      QLog.e("SoDataUtil", 1, paramLoadItem, new Object[0]);
    }
    return new anmj();
  }
  
  private static String a(LoadParam.LoadItem paramLoadItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_local_info_").append(paramLoadItem.name);
    if (!anmb.is64Bit()) {}
    for (paramLoadItem = "_32";; paramLoadItem = "_64") {
      return paramLoadItem;
    }
  }
  
  static void a(LoadParam.LoadItem paramLoadItem)
  {
    SharedPreferences localSharedPreferences = getPref();
    paramLoadItem = a(paramLoadItem);
    localSharedPreferences.edit().remove(paramLoadItem).apply();
  }
  
  static void a(LoadParam.LoadItem paramLoadItem, String paramString)
  {
    try
    {
      getPref().edit().putString("key_last_succ_" + paramLoadItem.name + Ad(), paramString).apply();
      return;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
  }
  
  static void a(LoadParam.LoadItem paramLoadItem, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences localSharedPreferences = getPref();
      String str = a(paramLoadItem);
      anmj localanmj = a(paramLoadItem, paramString3);
      if ((TextUtils.equals(localanmj.mSoPath, paramString2)) && (localanmj.amg != -1L)) {
        return;
      }
      long l = IOUtil.getCRC32Value(new File(paramString2));
      paramLoadItem = new anmj(paramString1, paramLoadItem.name, paramString2, l, paramString3);
      localSharedPreferences.edit().putString(str, paramLoadItem.encode()).commit();
      return;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
  }
  
  static String b(LoadParam.LoadItem paramLoadItem)
  {
    try
    {
      paramLoadItem = getPref().getString("key_last_succ_" + paramLoadItem.name + Ad(), "");
      return paramLoadItem;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
    return "";
  }
  
  private static SharedPreferences getPref()
  {
    if (Y == null) {
      Y = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 4);
    }
    return Y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anma
 * JD-Core Version:    0.7.0.1
 */