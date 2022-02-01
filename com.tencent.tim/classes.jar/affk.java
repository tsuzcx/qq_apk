import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class affk
  extends afeu
{
  public affk(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  @TargetApi(9)
  public static boolean R(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + AVSoUtils.getLibActualName(paramString));
      File localFile = new File(AVSoUtils.getTxlibPath() + AVSoUtils.getLibActualName(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QavSoDownloadHandlerBase", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, Boolean paramBoolean)
  {
    return (imm.getCpuArchitecture() > 2) || ((R(paramContext, "traeimp-armeabi")) && (R(paramContext, "TcVpxDec-armeabi")) && (R(paramContext, "TcVpxEnc-armeabi")));
  }
  
  public void HO(String paramString)
  {
    Object localObject1 = b();
    Object localObject2;
    SharedPreferences localSharedPreferences;
    String str2;
    if (localObject1 != null)
    {
      localObject2 = "QAVSOMD5__" + ((XmlData)localObject1).getSharedPreferencesName();
      localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      str2 = localSharedPreferences.getString((String)localObject2, null);
      String str1 = arwv.encodeFileHexStr(paramString);
      if ((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (!((XmlData)localObject1).MD5.equalsIgnoreCase(str1)))
      {
        localObject2 = new StringBuilder().append("download success but check md5 failed. config zip file md5 = ");
        if (!TextUtils.isEmpty(((XmlData)localObject1).MD5)) {}
        for (localObject1 = ((XmlData)localObject1).MD5;; localObject1 = "null")
        {
          QLog.e("QavSoDownloadHandlerBase", 1, (String)localObject1 + ", realZipFileMd5 = " + str1);
          paramString = new File(paramString);
          if (paramString.exists()) {
            paramString.delete();
          }
          return;
        }
      }
      QLog.d("QavSoDownloadHandlerBase", 1, "download success: " + paramString + "|" + str2 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      if (((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (((XmlData)localObject1).MD5.equalsIgnoreCase(str2))) && (b(this.app.getApp().getApplicationContext(), Boolean.valueOf(true)))) {}
    }
    try
    {
      aqhq.W(paramString, AVSoUtils.getTxlibPath(), false);
      localSharedPreferences.edit().putString((String)localObject2, ((XmlData)localObject1).MD5).commit();
      QLog.d("QavSoDownloadHandlerBase", 1, "uncompressZip success: " + paramString + "|" + str2 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      super.HO(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.e("QavSoDownloadHandlerBase", 1, "uncompressZip qavso failed.");
        File localFile = new File(paramString);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public void f(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoData)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoData");
      }
      super.f(paramXmlData);
      return;
    }
    super.f(paramXmlData);
  }
  
  public int getBusinessId()
  {
    return 10048;
  }
  
  public String un()
  {
    return "qavDownloadSoDuration";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affk
 * JD-Core Version:    0.7.0.1
 */