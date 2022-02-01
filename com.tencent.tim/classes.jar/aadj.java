import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aadj
{
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      localSharedPreferences.edit().putString("url_md5" + paramString1, paramString2).apply();
    }
  }
  
  public static List<aadj.a> G(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if (str.startsWith("url_last_use_time")) {
          localArrayList.add(new aadj.a(str.substring("url_last_use_time".length(), str.length()), ((Long)localEntry.getValue()).longValue(), paramInt));
        }
      }
    }
    return localArrayList;
  }
  
  public static int T(String paramString, int paramInt)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = a(paramInt);
    paramInt = i;
    if (localSharedPreferences != null)
    {
      paramInt = i;
      if (!TextUtils.isEmpty(paramString)) {
        paramInt = localSharedPreferences.getInt("url_abnormal_retry_times" + paramString, 0);
      }
    }
    return paramInt;
  }
  
  public static long a(String paramString, long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    long l = paramLong;
    if (localSharedPreferences != null)
    {
      l = paramLong;
      if (!TextUtils.isEmpty(paramString)) {
        l = localSharedPreferences.getLong("url_doneTime" + paramString, paramLong);
      }
    }
    return l;
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (paramInt == 1) {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_utilinner", 4);
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_util", 4);
    }
    return null;
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ResourceInfo localResourceInfo = new ResourceInfo();
    localResourceInfo.url = paramString;
    String str = aacl.X(paramString, paramInt2);
    if (!TextUtils.isEmpty(str))
    {
      localResourceInfo.filePath = str;
      localResourceInfo.fileMd5 = i(paramString, str, paramInt2);
      localResourceInfo.doneTime = a(paramString, 0L, paramInt2);
      if ((paramBoolean) || (PreloadResource.isNeedAutoUnzip(paramString, paramInt1)))
      {
        paramString = PreloadResource.getFolderPathByMD5AndUrl(localResourceInfo.fileMd5, paramString, paramInt2);
        if (PreloadResource.checkFolderAndUnzip(localResourceInfo.filePath, paramString)) {
          localResourceInfo.folderPath = paramString;
        }
      }
    }
    return localResourceInfo;
  }
  
  public static void a(int paramInt, PreloadConfig paramPreloadConfig)
  {
    if (paramPreloadConfig == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTimeMillis();
      if (l1 - y(paramInt) >= 86400000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ResUtil", 2, "removeSurplusRes already Check Today:" + paramInt);
    return;
    Object localObject = aacl.cT(paramInt);
    long l2 = System.currentTimeMillis();
    long l3 = aqhq.getFileOrFolderSize((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ResUtil", 2, "resFolderPathSize:" + l3 + "|" + 209715200L + "|" + (System.currentTimeMillis() - l2));
    }
    if (l3 > 209715200L)
    {
      localObject = G(paramInt).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aadj.a locala = (aadj.a)((Iterator)localObject).next();
        if ((locala != null) && (!TextUtils.isEmpty(locala.url)) && (l1 - locala.lastUseTime > 2592000000L) && (!paramPreloadConfig.isUrlInConfig(locala.url)))
        {
          ResourceInfo localResourceInfo = a(locala.url, false, 0, locala.filePos);
          if (localResourceInfo != null)
          {
            cU(locala.url, locala.filePos);
            aagd.delete(localResourceInfo.filePath);
            aagd.delete(localResourceInfo.folderPath);
            aadi.W(locala.url, 8, locala.filePos);
          }
        }
      }
    }
    ak(l1, paramInt);
  }
  
  public static void ak(long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("check_surplus_res_time", paramLong).apply();
    }
  }
  
  public static void cT(String paramString, int paramInt)
  {
    int i = T(paramString, paramInt);
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putInt("url_abnormal_retry_times" + paramString, i + 1).putLong("url_abnormal_retry_last_time" + paramString, NetConnInfoCenter.getServerTimeMillis()).apply();
    }
  }
  
  public static void cU(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      localSharedPreferences.edit().remove("url_doneTime" + paramString);
      localSharedPreferences.edit().remove("url_md5" + paramString);
      localSharedPreferences.edit().remove("url_last_use_time" + paramString);
      localSharedPreferences.edit().remove("url_abnormal_retry_times" + paramString).apply();
    }
  }
  
  public static void d(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    B(paramString1, paramString2, paramInt);
    i(paramString1, paramLong, paramInt);
    w(paramString1, paramInt, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static long h(String paramString, int paramInt)
  {
    long l2 = 0L;
    SharedPreferences localSharedPreferences = a(paramInt);
    long l1 = l2;
    if (localSharedPreferences != null)
    {
      l1 = l2;
      if (!TextUtils.isEmpty(paramString)) {
        l1 = localSharedPreferences.getLong("url_abnormal_retry_last_time" + paramString, 0L);
      }
    }
    return l1;
  }
  
  public static String h(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    String str = paramString2;
    if (localSharedPreferences != null)
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        str = localSharedPreferences.getString("url_md5" + paramString1, paramString2);
      }
    }
    return str;
  }
  
  public static String i(String paramString1, String paramString2, int paramInt)
  {
    String str2 = h(paramString1, "", paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = str2;
        if (new File(paramString2).exists())
        {
          str1 = MD5Coding.encodeFile2HexStr(paramString2);
          B(paramString1, str1, paramInt);
        }
      }
    }
    return str1;
  }
  
  public static void i(String paramString, long paramLong, int paramInt)
  {
    int i = 1;
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null)
    {
      paramInt = 1;
      if (TextUtils.isEmpty(paramString)) {
        break label73;
      }
    }
    for (;;)
    {
      if ((paramInt & i) != 0) {
        localSharedPreferences.edit().putLong("url_doneTime" + paramString, paramLong).apply();
      }
      return;
      paramInt = 0;
      break;
      label73:
      i = 0;
    }
  }
  
  public static void w(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putLong("url_last_use_time" + paramString, paramLong).apply();
    }
  }
  
  public static long y(int paramInt)
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("check_surplus_res_time", 0L);
    }
    return l;
  }
  
  public static class a
  {
    public int filePos;
    public long lastUseTime;
    public String url;
    
    public a(String paramString, long paramLong, int paramInt)
    {
      this.url = paramString;
      this.lastUseTime = paramLong;
      this.filePos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadj
 * JD-Core Version:    0.7.0.1
 */