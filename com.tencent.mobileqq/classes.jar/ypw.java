import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ypw
{
  private static volatile ypw jdField_a_of_type_Ypw;
  private bcgn jdField_a_of_type_Bcgn = new ypx(this);
  private final String jdField_a_of_type_JavaLangString = "GdtDownloadReportManager";
  private ConcurrentHashMap<String, GdtAd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GdtAd> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
  
  private int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      yny.d("GdtDownloadReportManager", "compareApkFileMd5 filePath is invalid");
      return 0;
    }
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if ((!paramString1.exists()) || (!paramString2.exists()))
    {
      yny.d("GdtDownloadReportManager", "compareApkFileMd5 file not exits");
      return 0;
    }
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    yny.a("GdtDownloadReportManager", "compareApkFileMd5:md5install-" + paramString1);
    yny.a("GdtDownloadReportManager", "compareApkFileMd5:md5download-" + paramString2);
    if (TextUtils.equals(paramString1, paramString2)) {
      return 1;
    }
    return 2;
  }
  
  public static String a(File paramFile)
  {
    if (!paramFile.isFile()) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return AdHexUtil.bytes2HexString(localMessageDigest.digest());
  }
  
  private String a(String paramString)
  {
    try
    {
      Iterator localIterator = BaseApplicationImpl.getApplication().getApplicationContext().getPackageManager().getInstalledApplications(64).iterator();
      while (localIterator.hasNext())
      {
        ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
        if (((localApplicationInfo.flags & 0x1) == 0) && (paramString.equals(localApplicationInfo.packageName)))
        {
          yny.a("GdtDownloadReportManager", "getAppInfoByPackageName:" + paramString + " path:" + localApplicationInfo.sourceDir);
          paramString = localApplicationInfo.sourceDir;
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      yny.d("GdtDownloadReportManager", "getAppInfoByPackageName" + paramString.toString());
    }
    return null;
  }
  
  public static ypw a()
  {
    if (jdField_a_of_type_Ypw == null) {}
    try
    {
      if (jdField_a_of_type_Ypw == null) {
        jdField_a_of_type_Ypw = new ypw();
      }
      return jdField_a_of_type_Ypw;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  public void a()
  {
    yny.a("GdtDownloadReportManager", "registerDownloadListener: ");
    bccu.a().a(this.jdField_a_of_type_Bcgn);
  }
  
  void a(GdtAd paramGdtAd, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (!paramBoolean) {
        break label23;
      }
      yoo.a(paramGdtAd, 269);
    }
    for (;;)
    {
      yoo.a(paramGdtAd, 272);
      return;
      label23:
      yoo.a(paramGdtAd, 268);
    }
  }
  
  public void a(String paramString, GdtAd paramGdtAd)
  {
    if (TextUtils.isEmpty(paramString)) {
      yny.d("GdtDownloadReportManager", "appId isEmpty");
    }
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ypw
 * JD-Core Version:    0.7.0.1
 */