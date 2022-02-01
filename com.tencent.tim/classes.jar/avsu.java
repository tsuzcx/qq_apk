import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class avsu
{
  private static avsx a;
  private static Object gd;
  private static HashMap<String, Boolean> isStorageReallyCanwriteMap = new HashMap();
  private static volatile boolean mHasLoadSDCardName;
  private static HashMap<String, String> mSDCardName2PathMap;
  private static String maxAvailableSizePath = "";
  private static final HashMap<String, avsw> sFileCacheService = new HashMap();
  private static String storeRootPath;
  
  static
  {
    gd = new Object();
    mSDCardName2PathMap = new HashMap();
  }
  
  public static final String Gi()
  {
    return d().sD();
  }
  
  public static String Gj()
  {
    return getCacheDir("video");
  }
  
  public static String Gk()
  {
    return getCacheDir("rapid_comment");
  }
  
  public static String Gl()
  {
    return getCacheDir("gift_fullscreen");
  }
  
  public static String Gm()
  {
    return getCacheDir("passive_praise");
  }
  
  public static String Gn()
  {
    return getCacheDir("dehaze_pic");
  }
  
  public static String Go()
  {
    return getCacheDir("plus_operation");
  }
  
  public static String Gp()
  {
    return getCacheDir("plus_decorate");
  }
  
  public static String Gq()
  {
    return getCacheDir("moodlistIcons");
  }
  
  public static String Gr()
  {
    return getCacheDir("head_drop_operaion");
  }
  
  public static String Gs()
  {
    return getCacheDir("surprise");
  }
  
  public static String Gt()
  {
    return getCacheDir("smart_beautify");
  }
  
  public static String Gu()
  {
    File localFile = BaseApplicationImpl.getContext().getCacheDir();
    if (localFile != null) {
      return localFile.getAbsolutePath() + File.separator + "qzone";
    }
    return null;
  }
  
  public static String Gv()
  {
    return aqul.getSDKPrivatePath(acbn.oM + UUID.randomUUID().toString() + ".jpg");
  }
  
  public static String Gw()
  {
    if (storeRootPath == null) {}
    try
    {
      if (storeRootPath == null) {
        WL(false);
      }
      return storeRootPath;
    }
    finally {}
  }
  
  static void WL(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        storeRootPath = Gu();
        File localFile = new File(storeRootPath);
        if ((!localFile.exists()) && (!localFile.mkdirs()) && (QLog.isColorLevel())) {
          QLog.w("CacheManager", 2, "Unable to create external cache directory");
        }
        if (!localFile.exists()) {
          return;
        }
        localFile = new File(storeRootPath, ".nomedia");
        if (localFile.exists()) {
          return;
        }
        localFile.createNewFile();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("CacheManager", 1, "", localException);
      }
      storeRootPath = avtc.cNo;
    }
  }
  
  public static avsw a()
  {
    return a("audio", 104857600, 41943040);
  }
  
  public static avsw a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      AssertUtil.assertTrue(bool);
      synchronized (sFileCacheService)
      {
        avsw localavsw2 = (avsw)sFileCacheService.get(paramString);
        avsw localavsw1 = localavsw2;
        if (localavsw2 == null)
        {
          localavsw1 = new avsw(paramString, 1, paramInt1, paramInt2);
          localavsw1.a(a());
          sFileCacheService.put(paramString, localavsw1);
        }
        return localavsw1;
      }
      bool = false;
    }
  }
  
  public static avsx a()
  {
    synchronized (gd)
    {
      if (a == null) {
        a = new avsx(new avsv());
      }
      return a;
    }
  }
  
  public static String aW(String paramString, int paramInt)
  {
    return getCacheDir(paramString);
  }
  
  public static String av(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = qg(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i = paramString.hashCode();
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        paramContext = avtc.cNA;
        if (paramContext != null) {
          break label96;
        }
      }
      label96:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i))
      {
        return paramContext;
        paramContext = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "image";
        break;
      }
      paramString = str;
    }
  }
  
  public static avsw b()
  {
    return a("offline", 104857600, 20971520);
  }
  
  public static avsw c()
  {
    return a("zip_cache", 104857600, 20971520);
  }
  
  private static final String calcCapUnit(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + countToUnit(paramInt);
    }
    return calcCapUnit(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static final String calcCapUnit(long paramLong)
  {
    return calcCapUnit(0, (float)paramLong);
  }
  
  public static void clearFileCache(Context paramContext)
  {
    paramContext = avtc.cNA;
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
    ahbj.deleteFile(avtc.cND);
    paramContext = avtc.cNB;
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
    ahbj.deleteFile(avtc.cNC);
    paramContext = avtc.cNE;
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
    paramContext = avtc.cNF;
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
    paramContext = Gw();
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
    paramContext = Gu();
    if (paramContext != null) {
      ahbj.deleteFile(paramContext);
    }
  }
  
  private static String countToUnit(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  public static avsw d()
  {
    return a("personalise_font", 104857600, 41943040);
  }
  
  public static avsw e()
  {
    return a("qzone_widgetai", 104857600, 20971520);
  }
  
  public static void eBN()
  {
    isStorageReallyCanwriteMap.clear();
    mHasLoadSDCardName = false;
    WL(false);
  }
  
  public static void eBO()
  {
    a();
    f();
    b();
    d();
    h();
    a().eBQ();
  }
  
  public static avsw f()
  {
    return a("avatar", 52428800, 20971520);
  }
  
  public static avsw g()
  {
    return a("personality_canvas", 2097152, 1048576);
  }
  
  public static String getCacheDir(String paramString)
  {
    String str = Gw();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static final long getSDCardCapability()
  {
    if (!isExternalAvailable()) {
      return -1L;
    }
    Object localObject = Gw();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static final String getSDCardCapabilityForDisplay()
  {
    long l = getSDCardCapability();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static final long getSDCardRemain()
  {
    if (!isExternalAvailable()) {
      return -1L;
    }
    Object localObject = Gw();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static final String getSDCardRemainForDisplay()
  {
    long l = getSDCardRemain();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static String getVideoPlayCacheDir()
  {
    Object localObject = avtc.cNo;
    if (localObject != null)
    {
      File localFile = new File((String)localObject);
      if (localFile.isFile()) {
        FileUtils.delete(localFile);
      }
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    localObject = new File((String)localObject + File.separator + "video_cache");
    if (((File)localObject).isFile()) {
      FileUtils.delete((File)localObject);
    }
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  public static avsw h()
  {
    return a("batch_image", 104857600, 62914560);
  }
  
  public static boolean isExternalAvailable()
  {
    return SDCardMountMonitorReceiver.a().aLB();
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (!URLUtil.isNetworkUrl(paramString));
    return true;
  }
  
  public static boolean isStorageReallyCanwrite(String paramString)
  {
    localObject = (Boolean)isStorageReallyCanwriteMap.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CacheManager", 1, "", localThrowable);
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      isStorageReallyCanwriteMap.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  public static void nI(long paramLong)
  {
    nJ(paramLong);
  }
  
  private static void nJ(long paramLong)
  {
    String str1 = LocalMultiProcConfig.getString("qua", "");
    String str2 = avpq.getQUA3();
    if (!str1.equals(str2))
    {
      LocalMultiProcConfig.putString4Uin("getMapLastGetTime", "", paramLong);
      LocalMultiProcConfig.putString("qua", str2);
    }
  }
  
  public static String qg(String paramString)
  {
    String str = paramString;
    if (isNetworkUrl(paramString))
    {
      int k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      int i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      str = paramString.substring(k + 1, i);
    }
    return str;
  }
  
  public static String rS(String paramString)
  {
    String str = Gu();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static boolean tz(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsu
 * JD-Core Version:    0.7.0.1
 */