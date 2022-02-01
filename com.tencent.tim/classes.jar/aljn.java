import BOSSStrategyCenter.tAdvDesc;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aljn
{
  private static volatile aljn a;
  public static final String bWI = acbn.SDCARD_PATH + "qbdownres";
  
  private void O(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      SharedPreferences localSharedPreferences = d(paramString1);
      paramString1 = localSharedPreferences.edit();
      paramString1.putString("download_url" + paramString2, paramString4);
      paramString1.putString("end_time" + paramString2, paramString3);
      paramString1.putString("trace_info" + paramString2, paramString3);
      paramString3 = new HashSet(localSharedPreferences.getStringSet("packagenames", new HashSet()));
      if (paramString3.add(paramString2)) {
        paramString1.putStringSet("packagenames", paramString3);
      }
      paramString1.apply();
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, "saveConfig2Sp exception", paramString1);
    }
  }
  
  public static aljn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aljn();
      }
      return a;
    }
    finally {}
  }
  
  private static void a(String paramString1, SoftReference<QQAppInterface> paramSoftReference, String paramString2, String paramString3)
  {
    if (paramSoftReference != null) {}
    try
    {
      paramSoftReference = (QQAppInterface)paramSoftReference.get();
      if (paramSoftReference != null)
      {
        paramSoftReference = (aopo)paramSoftReference.getManager(193);
        if (paramSoftReference.isEnable()) {
          paramSoftReference.be(paramString1, -1L);
        }
      }
      paramString1 = new HashMap();
      paramString1.put("Qboss_PreDownload_PackageName", paramString2);
      paramString1.put("Qboss_PreDownload_FailCode", paramString3);
      l("Qboss_PreDownload_Fail", paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, paramString1, new Object[0]);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (avzb.c(paramString1).booleanValue())
    {
      QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig package:" + paramString1 + " is installed");
      avyz.a().reportIntercept(paramString4, null);
      gZ(paramQQAppInterface.getAccount(), paramString1);
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("Qboss_PreDownload_PackageName", paramString1);
      l("Qboss_PreDownload_App_Installed", paramQQAppInterface);
      return false;
    }
    String str = ii(paramString3);
    if (bo(str, paramString2))
    {
      e(paramQQAppInterface, paramString1, paramString3, str, paramString4);
      return true;
    }
    QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig shouldDownloadRes return false");
    if (aljs.ob(paramString2))
    {
      gZ(paramQQAppInterface.getAccount(), paramString1);
      ahbj.deleteFile(str);
      return false;
    }
    avyz.a().reportExpose(paramString4, null);
    return false;
  }
  
  public static boolean b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null) || (paramHashMap.isEmpty())) {
      return false;
    }
    try
    {
      Object localObject = ii((String)paramHashMap.get("downloadurl"));
      if ((QzoneConfig.getInstance().getConfig("Schema", "jump_installapp_scheme_enable", 0) == 0) && (ahbj.fileExistsAndNotEmpty((String)localObject)))
      {
        QLog.i("QbossPreDownloadManager", 1, "loadPreDownloadRes installApkFile faifilePath:" + (String)localObject);
        FileProvider7Helper.installApkFile(paramContext, (String)localObject);
      }
      else
      {
        localObject = (String)paramHashMap.get("jumpurl");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("QbossPreDownloadManager", 1, "loadPreDownloadRes jumpurl is empty");
          return false;
        }
        paramHashMap = (HashMap<String, String>)localObject;
        if (!((String)localObject).contains("http://"))
        {
          paramHashMap = (HashMap<String, String>)localObject;
          if (!((String)localObject).contains("https://")) {
            paramHashMap = "https://" + (String)localObject;
          }
        }
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramHashMap);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
        paramContext.startActivity((Intent)localObject);
        QLog.i("QbossPreDownloadManager", 1, "loadPreDownloadRes jump browser url:" + paramHashMap);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QbossPreDownloadManager", 1, paramContext, new Object[0]);
    }
    return true;
  }
  
  public static SharedPreferences d(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qboss_pre_download_pref_" + paramString, 0);
  }
  
  private void gZ(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = d(paramString1);
      paramString1 = ((SharedPreferences)localObject).edit();
      paramString1.remove("download_url" + paramString2);
      paramString1.remove("end_time" + paramString2);
      paramString1.remove("trace_info" + paramString2);
      localObject = new HashSet(((SharedPreferences)localObject).getStringSet("packagenames", new HashSet()));
      if (((Set)localObject).remove(paramString2)) {
        paramString1.putStringSet("packagenames", (Set)localObject);
      }
      paramString1.apply();
      QLog.i("QbossPreDownloadManager", 1, "cleanConfig2Sp packageName:" + paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, "cleanConfig2Sp exception", paramString1);
    }
  }
  
  private static String ii(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return bWI + File.separator + mM(paramString);
  }
  
  public static void l(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
      {
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null, false);
        if (QLog.isColorLevel()) {
          QLog.i("QbossPreDownloadManager", 2, "reportQbossPreDownloadBeacon, tagName  " + paramString);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QbossPreDownloadManager", 1, paramString, new Object[0]);
    }
  }
  
  private static String mM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    return Utils.Crc64String(paramString.getHost() + paramString.getPath());
  }
  
  public void b(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    String str1;
    if ((paramQQAppInterface != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject1 = (tAdvDesc)paramArrayList.get(0);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((tAdvDesc)localObject1).res_data)))
      {
        QLog.i("QbossPreDownloadManager", 4, "handleQbossPreDownloadConfig data = " + ((tAdvDesc)localObject1).res_data);
        paramArrayList = paramQQAppInterface.getAccount();
        str1 = ((tAdvDesc)localObject1).res_traceinfo;
        localObject1 = ((tAdvDesc)localObject1).res_data;
      }
    }
    else
    {
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject2).getString("packagename");
        String str2 = ((JSONObject)localObject2).getString("endtime");
        localObject2 = ((JSONObject)localObject2).getString("apkurl");
        if (a(paramQQAppInterface, (String)localObject1, str2, (String)localObject2, str1)) {
          O(paramArrayList, (String)localObject1, str2, (String)localObject2);
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("QbossPreDownloadManager", 1, paramArrayList, new Object[0]);
        return;
      }
    }
    QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig data = null");
  }
  
  public boolean bo(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!ahbj.fileExistsAndNotEmpty(paramString1))
    {
      bool1 = bool2;
      if (!aljs.ob(paramString2)) {
        bool1 = true;
      }
    }
    QLog.i("QbossPreDownloadManager", 1, "filePath [" + paramString1 + "] shouldRequestRes result = " + bool1);
    return bool1;
  }
  
  public void dK(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = d(paramQQAppInterface.getAccount());
      Object localObject = localSharedPreferences.getStringSet("packagenames", null);
      if ((localObject != null) && (((Set)localObject).size() > 0))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = localSharedPreferences.getString("download_url" + str1, "");
            a(paramQQAppInterface, str1, localSharedPreferences.getString("end_time" + str1, ""), str2, localSharedPreferences.getString("trace_info" + str1, ""));
          }
        }
      }
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      aopo localaopo = (aopo)paramQQAppInterface.getManager(193);
      if (localaopo.isEnable())
      {
        QLog.i("QbossPreDownloadManager", 1, "downloadRes request packagename:" + paramString1);
        paramString3 = paramString3 + ".qbtemp";
        localaopo.a(10088, "vas", paramString2, 0, paramString2, paramString3, 1, 2, true, new aljo(this, paramQQAppInterface, "qboss_pre_download_res", paramString1, paramString3, paramString2, paramString4));
        return;
      }
      QLog.i("QbossPreDownloadManager", 1, "ctrl.isEnable() = false");
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QbossPreDownloadManager", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static class a
    implements aolm.b
  {
    SoftReference<QQAppInterface> A;
    String downloadurl;
    String packageName;
    String resPath;
    String traceInfo;
    
    public a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.A = new SoftReference(paramQQAppInterface);
      this.packageName = paramString1;
      this.downloadurl = paramString3;
      this.resPath = paramString2;
      this.traceInfo = paramString4;
    }
    
    public void onResp(aomh paramaomh)
    {
      try
      {
        if (paramaomh.mResult == 0)
        {
          QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
          if (TextUtils.isEmpty(this.resPath)) {
            return;
          }
          if (ahbj.fileExistsAndNotEmpty(this.resPath))
          {
            paramaomh = new File(this.resPath);
            File localFile = new File(this.resPath.substring(0, this.resPath.lastIndexOf(".")));
            if (!paramaomh.renameTo(localFile)) {
              return;
            }
            long l = localFile.length();
            paramaomh = (QQAppInterface)this.A.get();
            if (paramaomh != null)
            {
              paramaomh = (aopo)paramaomh.getManager(193);
              if (paramaomh.isEnable())
              {
                QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
                paramaomh.be(this.downloadurl, l);
              }
            }
            avyz.a().reportExpose(this.traceInfo, null);
            return;
          }
          aljn.b(this.downloadurl, this.A, this.packageName, "2");
          QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
          return;
        }
      }
      catch (Exception paramaomh)
      {
        QLog.e("QbossPreDownloadManager", 1, paramaomh, new Object[0]);
        return;
      }
      if (paramaomh.mResult == 1)
      {
        aljn.b(this.downloadurl, this.A, this.packageName, "1");
        QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljn
 * JD-Core Version:    0.7.0.1
 */