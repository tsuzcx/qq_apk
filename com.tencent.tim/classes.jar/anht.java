import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anht
{
  boolean SQ = false;
  anht.a jdField_a_of_type_Anht$a = null;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  
  anht()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Anht$a = new anht.a();
  }
  
  public static void Qx(String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putString("key_so_version_" + paramString, AppSetting.getRevision()).commit();
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.getSP();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.MD5_zip_so;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      Qx(paramDownloadInfo.so_name);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.MD5_zip_model;
      localSharedPreferences.edit().putString("model_zip_md5", str).commit();
    }
    if ((paramInt & 0x3) == 3)
    {
      paramDownloadInfo = paramDownloadInfo.MD5_zip_gamemodel;
      localSharedPreferences.edit().putString("gamemodel_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    anhs.a().a.d(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static boolean cu()
  {
    return anhs.a().a.uj();
  }
  
  static void le(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.gesturemgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void v(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "onEnterBackground");
    }
    cu();
  }
  
  void d(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    }
    QLog.w("QavGesture", 1, "handle_QAG_Gesture_Config, configInfo[" + paramConfigInfo + "], mDownloadInfo[" + this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo + "]");
    if (this.SQ)
    {
      this.SQ = false;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo != null) {
        cu();
      }
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
        QLog.d("QavGesture", 1, "innerDownload, getNetEngine 为空");
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      QLog.d("QavGesture", 1, "appRuntime 不是 QQAppInterface");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo;
    if (localObject == null)
    {
      this.SQ = true;
      return false;
    }
    if (11 == anhx.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Anht$a.a((DownloadInfo)localObject);
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
          break label382;
        }
        bool = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.SR), Boolean.valueOf(bool) }));
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
                QLog.d("QavGesture", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.d.U() }));
                ((aolm)localObject).b(this.d);
              }
            }
          }
          this.b = paramDownloadInfo;
          this.auO = 0;
          this.d = null;
          this.aqn = 0;
          this.aqo = 0;
          if (!anhx.e(this.b))
          {
            this.auO |= 0x1;
            this.aqn += 1;
          }
          if (!anhx.d(this.b))
          {
            this.auO |= 0x2;
            this.aqn += 1;
          }
          if ((anhx.b(this.b)) && (!anhx.c(this.b)))
          {
            this.auO |= 0x3;
            this.aqn += 1;
          }
          QLog.d("QavGesture", 1, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.auO), this.b }));
          if (this.aqn == 0) {
            return this.SR;
          }
          this.SR = a(this.b, 3);
          return this.SR;
          label382:
          bool = false;
        }
      }
    }
    
    boolean a(DownloadInfo paramDownloadInfo, int paramInt)
    {
      String str2;
      String str1;
      int i;
      if (!anhx.e(paramDownloadInfo))
      {
        str2 = paramDownloadInfo.url_zip_so;
        str1 = paramDownloadInfo.MD5_zip_so;
        i = 1;
      }
      String str3;
      boolean bool2;
      for (;;)
      {
        str3 = anhx.getSoDir() + str1;
        if (paramInt >= 0) {
          break label154;
        }
        QLog.d("QavGesture", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
        anht.le(-3);
        bool2 = false;
        return bool2;
        if ((paramDownloadInfo.enable) && (!anhx.d(paramDownloadInfo)))
        {
          str2 = paramDownloadInfo.url_zip_model;
          str1 = paramDownloadInfo.MD5_zip_model;
          i = 2;
        }
        else
        {
          if ((!anhx.b(paramDownloadInfo)) || (anhx.c(paramDownloadInfo))) {
            break;
          }
          str2 = paramDownloadInfo.url_zip_gamemodel;
          str1 = paramDownloadInfo.MD5_zip_gamemodel;
          i = 3;
        }
      }
      anht.le(100);
      return false;
      label154:
      aoll localaoll = new aoll();
      localaoll.f = new anhu(this, str1, paramDownloadInfo, i, paramInt);
      localaoll.bw(i + "_" + str1);
      localaoll.bZ = str2;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(str3).getPath();
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
          anht.le(-2);
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool1) }));
        return bool1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anht
 * JD-Core Version:    0.7.0.1
 */