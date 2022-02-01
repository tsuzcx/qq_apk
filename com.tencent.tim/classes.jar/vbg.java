import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.1;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.3;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.utils.HttpDownloadUtil.b;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.os.MqqHandler;

public class vbg
  extends vbi
  implements Handler.Callback, HttpDownloadUtil.b
{
  public boolean SR = false;
  String aNo;
  public boolean aWM = false;
  public boolean aWN = false;
  int bHk;
  public MqqHandler g = new aqgw(Looper.getMainLooper(), this);
  private acfd j = new vbh(this);
  public URL l = null;
  
  public vbg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public vbi.b a(int paramInt)
  {
    return this.c;
  }
  
  public void a(BaseActivity paramBaseActivity, vbi.b paramb)
  {
    paramb.fileKey = null;
    paramb.thumbnail = this.app.a(false, this.toUin);
    paramb.filePath = aqep.pf(this.toUin);
    f(paramb);
    this.c = paramb;
  }
  
  void a(String paramString1, byte paramByte, String paramString2)
  {
    this.aWM = false;
    this.c.showProgress = true;
    g(this.c);
    if (this.SR)
    {
      if (ajrk.isDevelopLevel()) {
        ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.4(this, paramString1, paramByte, paramString2), 5, null, true);
  }
  
  void a(vbi.b paramb, boolean paramBoolean)
  {
    int i = paramb.state;
    if ((paramBoolean) && (!this.aWM) && ((paramb.state == 0) || (paramb.state == 3)))
    {
      this.aWM = true;
      ThreadManager.postImmediately(new FriendProfileImageAvatar.1(this, paramb), null, false);
    }
    if (paramb.state == 0) {
      paramb.state = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "load: uin=" + paramb.toUin + ",state=" + paramb.state + ", bState=" + i + ", bGetHeadInfo=" + this.aWM + ", isFromClickEvent=" + paramBoolean);
      }
      return;
      if ((!paramBoolean) && (paramb.state == 3))
      {
        paramb.state = 4;
        if (this.g != null) {
          this.g.sendEmptyMessageDelayed(4, 400L);
        }
      }
    }
  }
  
  public Drawable am()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.app != null)
    {
      localObject1 = localObject2;
      if (this.c != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.c.toUin)) {
          localObject1 = aqdj.a(this.app, 1, this.c.toUin);
        }
      }
    }
    return localObject1;
  }
  
  public void cm(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "onHttpStart() url = " + paramString);
    }
    if ((this.l != null) && (this.l.toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      if (this.g != null) {
        this.g.sendMessage(paramString);
      }
    }
  }
  
  public void cn(String paramString, int paramInt) {}
  
  public void d(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.removeObserver(this.j);
    if (this.g != null) {
      this.g.removeCallbacksAndMessages(null);
    }
    this.g = null;
  }
  
  public void e(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.addObserver(this.j);
  }
  
  public void e(vbi.b paramb)
  {
    this.c = paramb;
  }
  
  void f(vbi.b paramb)
  {
    for (;;)
    {
      try
      {
        int i = paramb.state;
        if (ahbj.isFileExists(paramb.filePath))
        {
          paramb.state = 6;
          paramb.showProgress = false;
          if (this.g != null) {
            this.g.removeMessages(4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "updateState: uin=" + paramb.toUin + ",state=" + paramb.state + ", beforeState=" + i);
          }
          return;
        }
        if (ahbj.isFileExists(paramb.thumbnail)) {
          paramb.state = 3;
        } else {
          paramb.state = 0;
        }
      }
      finally {}
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public void h(String paramString, long paramLong1, long paramLong2)
  {
    if ((this.l != null) && (this.l.toString().equals(paramString)))
    {
      if ((this.g != null) && (this.g.hasMessages(1))) {
        this.g.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      if (this.g != null) {
        this.g.sendMessage(paramString);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Setting localSetting = null;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "refresh progress : " + paramMessage.arg1);
        }
        this.c.progress = paramMessage.arg1;
        g(this.c);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "start progress : " + paramMessage.arg1);
        }
        this.c.progress = 0;
        g(this.c);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "end result : " + paramMessage.arg1);
        }
        this.c.progress = 100;
        this.c.showProgress = false;
        f(this.c);
        if (paramMessage.arg1 == 1)
        {
          g(this.c);
          return true;
        }
        this.c.state = 5;
        g(this.c);
      } while (this.bHk >= 3);
      this.bHk += 1;
      this.aNo = null;
      return true;
      vB(this.toUin);
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof Setting)) {
        localSetting = (Setting)paramMessage.obj;
      }
      if ((localSetting != null) && (!localSetting.url.equals(this.aNo)))
      {
        this.aNo = localSetting.url;
        a(localSetting.uin, localSetting.bFaceFlags, localSetting.url);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR | has download path = " + this.aNo);
    return true;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 0) {
      i = 0;
    }
    this.index = i;
    this.c = a(i);
    if (this.c != null)
    {
      a(this.c, true);
      g(this.c);
    }
  }
  
  void vB(String paramString)
  {
    if (QLog.isColorLevel()) {
      ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar", new Object[] { paramString });
    }
    if (this.aWN)
    {
      if (ajrk.isDevelopLevel()) {
        ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.3(this, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbg
 * JD-Core Version:    0.7.0.1
 */