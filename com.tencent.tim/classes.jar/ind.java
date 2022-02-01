import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ind
{
  boolean SQ = false;
  imz jdField_a_of_type_Imz = null;
  ind.a jdField_a_of_type_Ind$a = null;
  
  ind()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "QavGPDownloader in QQAppInterface");
    }
    this.jdField_a_of_type_Ind$a = new ind.a();
  }
  
  public static void a(imz paramimz)
  {
    SharedPreferences localSharedPreferences = inf.getSP();
    paramimz = paramimz.MD5_zip_so;
    localSharedPreferences.edit().putString("so_zip_md5", paramimz).commit();
  }
  
  public static boolean cu()
  {
    return ina.a().a.uj();
  }
  
  public static void jg(String paramString)
  {
    if (ina.uf()) {
      ina.a().a.jh(paramString);
    }
  }
  
  static void le(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.qavgameplaysomgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private boolean uj()
  {
    QLog.d("QavGPDownloadManager", 4, "innerDownload, start");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGPDownloadManager", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_Imz == null) {
      this.jdField_a_of_type_Imz = imz.a();
    }
    localObject = this.jdField_a_of_type_Imz;
    if (localObject == null)
    {
      QLog.d("QavGPDownloadManager", 2, "downloadInfo == null");
      this.SQ = true;
      return false;
    }
    if (11 == inf.a((imz)localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        QLog.d("QavGPDownloadManager", 2, "downloadTask.start");
        return this.jdField_a_of_type_Ind$a.a((imz)localObject);
      }
      QLog.d("QavGPDownloadManager", 2, "bDownloading = false");
      return bool;
    }
  }
  
  public static void v(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "onEnterBackground");
    }
    cu();
  }
  
  void jh(String paramString)
  {
    imz localimz = null;
    if (!TextUtils.isEmpty(paramString)) {
      localimz = imz.a(paramString);
    }
    this.jdField_a_of_type_Imz = localimz;
    if (this.SQ)
    {
      QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, mNeedDownloadAfterGetConfig == true");
      this.SQ = false;
      cu();
    }
  }
  
  static class a
  {
    boolean SR = false;
    int aqn = 0;
    int aqo = 0;
    imz b = null;
    aoll d;
    
    boolean a(imz paramimz)
    {
      boolean bool;
      if (this.SR)
      {
        if ((this.b == paramimz) || (TextUtils.isEmpty(paramimz.MD5_zip_so)) || (paramimz.MD5_zip_so.equals(this.b.MD5_zip_so))) {
          break label273;
        }
        bool = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("GPsoDownloadTask, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.SR), Boolean.valueOf(bool) }));
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
                QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.d.U() }));
                ((aolm)localObject).b(this.d);
              }
            }
          }
          this.b = paramimz;
          this.d = null;
          this.aqn = 0;
          this.aqo = 0;
          if (!inf.b(this.b)) {
            this.aqn += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.b }));
          }
          if (this.aqn == 0) {
            return this.SR;
          }
          this.SR = a(this.b, 3);
          return this.SR;
          label273:
          bool = false;
        }
      }
    }
    
    boolean a(imz paramimz, int paramInt)
    {
      String str2;
      String str1;
      String str3;
      boolean bool2;
      if (!inf.b(paramimz))
      {
        str2 = paramimz.url_zip_so;
        str1 = paramimz.MD5_zip_so;
        str3 = inf.getSoDir() + str1;
        if (paramInt < 0)
        {
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramimz }));
          ind.le(-3);
          bool2 = false;
          return bool2;
        }
      }
      else
      {
        ind.le(100);
        return false;
      }
      aoll localaoll = new aoll();
      localaoll.f = new ine(this, str1, paramimz, paramInt);
      localaoll.bw(str1);
      localaoll.bZ = str2;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(str3).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      paramimz = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramimz instanceof QQAppInterface))
      {
        paramimz = ((QQAppInterface)paramimz).getNetEngine(0);
        if (paramimz != null)
        {
          this.d = localaoll;
          paramimz.a(this.d);
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (!bool1) {
          ind.le(-2);
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QavGPDownloadManager", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool1) }));
        return bool1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ind
 * JD-Core Version:    0.7.0.1
 */