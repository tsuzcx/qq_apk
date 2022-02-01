import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class avez
{
  private static avez jdField_a_of_type_Avez;
  avez.a jdField_a_of_type_Avez$a = new avez.a();
  avez.b jdField_a_of_type_Avez$b;
  avey b;
  
  static void CV(String paramString)
  {
    SharedPreferences.Editor localEditor = getSP().edit();
    localEditor.putString("gme_sdk_download_md5", paramString);
    localEditor.commit();
  }
  
  static avez a()
  {
    if (jdField_a_of_type_Avez == null) {
      jdField_a_of_type_Avez = new avez();
    }
    return jdField_a_of_type_Avez;
  }
  
  public static String a(avey paramavey)
  {
    return getSoDir() + "gme_sdk_" + paramavey.nVersion + "_" + paramavey.MD5_zip_so + ".zip";
  }
  
  public static boolean b(avey paramavey)
  {
    String str1 = paramavey.MD5_zip_so;
    paramavey = a(paramavey);
    String str2 = rp();
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TMG_Downloader", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (aqhq.fileExists(paramavey)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("TMG_Downloader", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramavey }));
    return false;
    cFQ();
    return true;
  }
  
  public static void cFQ()
  {
    ArrayList localArrayList = aqhq.ag(getSoDir());
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        QLog.e("TMG_Downloader", 1, String.format("ListSoDirs file i=" + i + ", name=" + (String)localArrayList.get(i), new Object[0]));
        i += 1;
      }
    }
  }
  
  static SharedPreferences getSP()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.gme_sdk", 4);
  }
  
  public static String getSoDir()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = ((File)localObject).getParent() + "/txlib/gme_sdk/";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  static String rp()
  {
    return getSP().getString("gme_sdk_download_md5", null);
  }
  
  boolean a(avey paramavey)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (((QQAppInterface)localAppRuntime).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TMG_Downloader", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else if (QLog.isDevelopLevel()) {
      QLog.d("TMG_Downloader", 4, "appRuntime 不是 QQAppInterface");
    }
    this.b = paramavey;
    return this.jdField_a_of_type_Avez$a.b(paramavey, this.jdField_a_of_type_Avez$b);
  }
  
  boolean a(avey paramavey, avez.b paramb)
  {
    this.jdField_a_of_type_Avez$b = paramb;
    return a(paramavey);
  }
  
  static class a
  {
    boolean SR = false;
    avez.b a;
    avey c = null;
    aoll d;
    
    boolean a(avey paramavey, int paramInt)
    {
      String str1;
      if (!avez.b(paramavey))
      {
        String str2 = paramavey.url_zip_so;
        str1 = paramavey.MD5_zip_so;
        String str3 = avez.a(paramavey);
        aoll localaoll = new aoll();
        localaoll.f = new avfa(this, str1, paramavey);
        localaoll.bw(str1);
        localaoll.bZ = str2;
        localaoll.mHttpMethod = 0;
        localaoll.atY = new File(str3).getPath();
        localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        paramavey = abmt.getAppInterface().getNetEngine(0);
        if (paramavey == null) {
          break label206;
        }
        this.d = localaoll;
        paramavey.a(this.d);
      }
      label206:
      for (boolean bool = true;; bool = false)
      {
        if ((!bool) && (this.a != null)) {
          this.a.bT(3, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
        }
        return bool;
        if (this.a != null) {
          this.a.bT(0, "So Already Exist!!!");
        }
        return false;
      }
    }
    
    boolean b(avey paramavey, avez.b paramb)
    {
      this.a = paramb;
      boolean bool;
      if (this.SR)
      {
        if ((this.c == paramavey) || (TextUtils.isEmpty(paramavey.MD5_zip_so)) || (paramavey.MD5_zip_so.equals(this.c.MD5_zip_so))) {
          break label214;
        }
        bool = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.SR), Boolean.valueOf(bool) }));
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
            paramb = abmt.getAppInterface().getNetEngine(0);
            if (paramb != null)
            {
              QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.d.U() }));
              paramb.b(this.d);
            }
          }
          this.c = paramavey;
          this.d = null;
          if (QLog.isColorLevel()) {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.c }));
          }
          this.SR = a(this.c, 1);
          return this.SR;
          label214:
          bool = false;
        }
      }
    }
  }
  
  public static abstract class b
  {
    public abstract void Ik(int paramInt);
    
    public abstract void bT(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avez
 * JD-Core Version:    0.7.0.1
 */