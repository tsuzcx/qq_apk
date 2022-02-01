import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class iwe
{
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  iwe.a jdField_a_of_type_Iwe$a = null;
  
  iwe()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, "SoMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Iwe$a = new iwe.a();
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.getSP();
    if ((paramInt & 0x1) == 1)
    {
      String str = paramDownloadInfo.MD5_zip_so;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
    }
    if ((paramInt & 0x2) == 2)
    {
      paramDownloadInfo = paramDownloadInfo.MD5_zip_model;
      localSharedPreferences.edit().putString("model_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    iwd.a().a.b(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static boolean cu()
  {
    return iwd.a().a.uj();
  }
  
  static void le(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.somgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private static boolean x(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(alab.getFileMD5String(paramString1)))
      {
        QLog.i("QavSo", 1, "checkFileValid failed. check md5 failed. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.i("QavSo", 1, "checkFileValid failed. file is not exist. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentAvSoDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    }
    QLog.w("QavSo", 1, "handle_QAV_So_Config, configInfo[" + paramConfigInfo + "], mDownloadInfo[" + this.jdField_a_of_type_ComTencentAvSoDownloadInfo + "]");
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo.is_auto_download) {
      cu();
    }
  }
  
  boolean uj()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool2;
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavSo", 4, "innerDownload, getNetEngine 为空");
        }
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavSo", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    }
    localObject = this.jdField_a_of_type_ComTencentAvSoDownloadInfo;
    if (localObject == null) {
      return false;
    }
    if (11 == iwi.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Iwe$a.a((DownloadInfo)localObject);
    }
  }
  
  static class a
  {
    boolean SR = false;
    int aqn = 0;
    int aqo = 0;
    int auO = 0;
    DownloadInfo b = null;
    aoll d;
    
    boolean a(DownloadInfo paramDownloadInfo)
    {
      boolean bool;
      if (this.SR)
      {
        if ((this.b == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.b.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.b.MD5_zip_so))))) {
          break label348;
        }
        bool = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavSo", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.SR), Boolean.valueOf(bool) }));
        }
        if (!bool)
        {
          return this.SR;
          bool = true;
        }
        else
        {
          if (this.d != null)
          {
            Object localObject = BaseApplicationImpl.sApplication.getRuntime();
            if ((localObject instanceof AppInterface))
            {
              localObject = ((AppInterface)localObject).getNetEngine(0);
              if (localObject != null)
              {
                QLog.d("QavSo", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.d.U() }));
                ((aolm)localObject).b(this.d);
              }
            }
          }
          this.b = paramDownloadInfo;
          this.auO = 0;
          this.d = null;
          this.aqn = 0;
          this.aqo = 0;
          if (!iwi.c(this.b))
          {
            this.auO |= 0x1;
            this.aqn += 1;
          }
          if (!iwi.b(this.b))
          {
            this.auO |= 0x2;
            this.aqn += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavSo", 2, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.auO), this.b }));
          }
          if (this.aqn == 0) {
            return this.SR;
          }
          this.SR = a(this.b, 3);
          return this.SR;
          label348:
          bool = false;
        }
      }
    }
    
    boolean a(DownloadInfo paramDownloadInfo, int paramInt)
    {
      String str3;
      String str1;
      String str2;
      int i;
      if (!iwi.c(paramDownloadInfo))
      {
        str3 = paramDownloadInfo.url_zip_so;
        str1 = paramDownloadInfo.MD5_zip_so;
        str2 = iwi.getSoDir() + str1;
        i = 1;
      }
      boolean bool2;
      while (paramInt < 0)
      {
        QLog.d("QavSo", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
        iwe.le(-3);
        bool2 = false;
        return bool2;
        if ((paramDownloadInfo.enable) && (!iwi.b(paramDownloadInfo)))
        {
          str3 = paramDownloadInfo.url_zip_model;
          str1 = paramDownloadInfo.MD5_zip_model;
          str2 = iwi.getModelDir() + str1;
          i = 2;
        }
        else
        {
          iwe.le(100);
          return false;
        }
      }
      QLog.i("QavSo", 1, String.format("downloadRes. res_flag[%s], outPath[%s], info[%s]", new Object[] { Integer.valueOf(i), str2, paramDownloadInfo }));
      aoll localaoll = new aoll();
      localaoll.f = new iwf(this, str1, i, paramDownloadInfo, paramInt);
      localaoll.bw(i + "_" + str1);
      localaoll.bZ = str3;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(str2).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramDownloadInfo instanceof QQAppInterface))
      {
        paramDownloadInfo = ((QQAppInterface)paramDownloadInfo).getNetEngine(0);
        if (paramDownloadInfo != null)
        {
          this.d = localaoll;
          paramDownloadInfo.a(this.d);
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (!bool1) {
          iwe.le(-2);
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QavSo", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool1) }));
        return bool1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwe
 * JD-Core Version:    0.7.0.1
 */