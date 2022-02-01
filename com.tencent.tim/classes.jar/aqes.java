import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class aqes
  implements Handler.Callback, HttpDownloadUtil.b
{
  private FriendListHandler a;
  private volatile WeakReference<aqes.a> bd;
  private volatile boolean cTM;
  private WeakReference<QQAppInterface> mApp;
  private volatile String mCurrentUin;
  private volatile boolean mDestroy;
  private MqqHandler mUIHandler;
  
  private void Uv(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      paramString = new BitmapDrawable(getApp().getApp().getResources(), paramString);
      Message localMessage = this.mUIHandler.obtainMessage(1);
      localMessage.obj = paramString;
      localMessage.sendToTarget();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar getDrawable " + paramString.toString());
        }
        paramString = null;
      }
    }
  }
  
  private void Uw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile ");
    }
    paramString = getApp().getCustomFaceFilePath(1, paramString, 0);
    if (new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile exist");
      }
      Uv(paramString);
    }
  }
  
  private QQAppInterface getApp()
  {
    if (this.mApp.get() != null) {
      return (QQAppInterface)this.mApp.get();
    }
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public void cm(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "onHttpStart " + paramString + " " + paramInt);
    }
  }
  
  public void cn(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "onHttpEnd " + paramString + " " + paramInt);
    }
  }
  
  public void e(Setting paramSetting)
  {
    boolean bool1 = false;
    Object localObject;
    if ((paramSetting == null) || (TextUtils.isEmpty(paramSetting.uin)) || (TextUtils.isEmpty(paramSetting.url))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("downloadFHDAvatar return ");
        if (paramSetting == null) {
          break label71;
        }
        paramSetting = paramSetting.toString();
        QLog.i("QQAvatarFHDDecoder", 2, paramSetting);
      }
    }
    for (;;)
    {
      return;
      label71:
      paramSetting = "";
      break;
      localObject = aqep.pf(paramSetting.uin);
      if (ahbj.isFileExists((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar already exist " + (String)localObject);
        }
        Uv((String)localObject);
        return;
      }
      paramSetting = FaceDownloader.a(paramSetting.url, paramSetting.bFaceFlags);
      File localFile1 = new File((String)localObject);
      File localFile2 = new File(localFile1.getPath() + System.currentTimeMillis());
      if (HttpDownloadUtil.a(getApp(), new afka(MsfSdkUtils.insertMtype("friendlist", paramSetting), localFile2, 0), this) == 0) {
        bool1 = true;
      }
      boolean bool2;
      if (bool1)
      {
        if (localFile2.exists()) {
          bool1 = localFile2.renameTo(localFile1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar suc " + bool1 + " " + (String)localObject);
        }
        bool2 = bool1;
        if (bool1)
        {
          Uv((String)localObject);
          bool2 = bool1;
        }
      }
      while (!bool2)
      {
        Uw(this.mCurrentUin);
        return;
        bool2 = bool1;
        if (localFile2.exists())
        {
          localFile2.delete();
          bool2 = bool1;
        }
      }
    }
  }
  
  public void h(String paramString, long paramLong1, long paramLong2) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    if ((paramMessage.obj instanceof Drawable)) {}
    for (paramMessage = (Drawable)paramMessage.obj;; paramMessage = null)
    {
      aqes.a locala;
      String str;
      if (this.bd != null)
      {
        locala = (aqes.a)this.bd.get();
        if (locala != null)
        {
          str = this.mCurrentUin;
          if (paramMessage == null) {
            break label105;
          }
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        locala.a(str, bool, paramMessage);
        this.bd = null;
        this.cTM = false;
        this.mCurrentUin = null;
        return true;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, boolean paramBoolean, Drawable paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqes
 * JD-Core Version:    0.7.0.1
 */