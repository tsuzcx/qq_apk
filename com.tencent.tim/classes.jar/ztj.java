import android.app.Activity;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.VideoPlayController.1;
import com.tencent.mobileqq.activity.photo.VideoPlayController.2;
import com.tencent.mobileqq.activity.photo.VideoPlayController.3;
import com.tencent.mobileqq.activity.photo.VideoPlayController.4;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public abstract class ztj
{
  private final String TAG = "carverW VideoPlayController";
  zrt jdField_a_of_type_Zrt = new zrt();
  ztj.a jdField_a_of_type_Ztj$a = new ztj.a(null);
  public ztj.b a;
  public ztn a;
  private int aEt = 0;
  protected xuh b;
  FrameLayout bk;
  private boolean btd;
  private boolean bte;
  private Runnable cF = new VideoPlayController.1(this);
  protected boolean isCancel;
  private boolean isComplete;
  Activity mCurActivity;
  View videoView;
  
  private void bG(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#setupVideoView  ");
    }
    if (this.bk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "#setupVideoView  layout is null#");
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.videoView.setLayoutParams(localLayoutParams);
    this.videoView.setVisibility(0);
    this.bk.addView(this.videoView);
    bH(paramActivity);
  }
  
  private void bH(Activity paramActivity) {}
  
  private void crO()
  {
    if ((this.btd) && (this.jdField_a_of_type_Zrt != null)) {
      this.jdField_a_of_type_Zrt.pause();
    }
    if ((VersionUtils.isrFroyo()) && (this.mCurActivity != null))
    {
      Activity localActivity1 = this.mCurActivity;
      Activity localActivity2 = this.mCurActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
    if (this.mCurActivity != null) {
      this.mCurActivity.runOnUiThread(new VideoPlayController.2(this));
    }
  }
  
  private void e(ztn paramztn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#initMediaPlayVideo  ");
    }
    if (this.bk != null) {
      this.bk.setVisibility(0);
    }
    if (this.jdField_a_of_type_Zrt != null)
    {
      this.videoView = this.jdField_a_of_type_Zrt.a(this.mCurActivity, this.jdField_a_of_type_Ztj$a, paramztn, this.b);
      if (this.videoView != null)
      {
        bG(this.mCurActivity);
        paramztn = new HashMap();
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "previewVideoViewCreateSuc", true, 0L, 0L, paramztn, null);
      }
    }
  }
  
  public abstract void BW(boolean paramBoolean);
  
  public abstract void Fy(int paramInt);
  
  public abstract void Fz(int paramInt);
  
  public boolean VL()
  {
    if (this.jdField_a_of_type_Zrt != null) {
      return this.jdField_a_of_type_Zrt.VL();
    }
    return false;
  }
  
  public abstract boolean VN();
  
  public void a(View paramView, ztn paramztn)
  {
    if ((paramView == null) || (paramztn == null) || (this.jdField_a_of_type_Zrt == null)) {
      return;
    }
    pause();
    if (this.bk != null) {
      this.bk.removeAllViews();
    }
    if (paramView == null)
    {
      resetUI();
      this.bk = null;
      this.mCurActivity = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ztj$a.removeCallbacks(this.cF);
      this.bte = false;
      this.isComplete = false;
      BW(false);
      this.videoView = null;
      this.isCancel = false;
      this.jdField_a_of_type_Zrt.azR();
      this.btd = false;
      this.aEt = 0;
      this.jdField_a_of_type_Ztn = paramztn;
      if ((this.jdField_a_of_type_Ztn == null) || (paramView == null) || (paramView.getContext() == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemSelect no == " + this.jdField_a_of_type_Ztn.hashCode() + " id=" + paramztn.id);
      }
      this.mCurActivity = ((Activity)paramView.getContext());
      e(this.jdField_a_of_type_Ztn);
      return;
      initUI(paramView);
      this.bk = ((FrameLayout)paramView.findViewById(2131373582));
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Ztn != null) && (paramAIOShortVideoData.id != this.jdField_a_of_type_Ztn.id)) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data.id = " + paramAIOShortVideoData.id + " mInfo,id=" + this.jdField_a_of_type_Ztn.id);
    }
    while (this.jdField_a_of_type_Ztj$b == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data=" + paramAIOShortVideoData.id + " isNeedShowCenterBtn=" + paramBoolean2 + " isStart=" + paramBoolean1);
    }
    ztn localztn = new ztn();
    localztn.id = paramAIOShortVideoData.id;
    localztn.subid = paramAIOShortVideoData.subId;
    this.jdField_a_of_type_Ztj$b.a(localztn, paramBoolean1);
    if (paramBoolean2)
    {
      Fz(0);
      return;
    }
    Fz(8);
  }
  
  public void a(xuh paramxuh)
  {
    this.b = paramxuh;
  }
  
  public void a(ztj.b paramb)
  {
    this.jdField_a_of_type_Ztj$b = paramb;
  }
  
  public void aNX()
  {
    if (this.jdField_a_of_type_Ztn == null) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick  onItemClick mCurInfo is null");
      }
    }
    do
    {
      return;
      this.bte = true;
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick curState=" + this.aEt + " no = " + this.jdField_a_of_type_Ztn.hashCode() + " id=" + this.jdField_a_of_type_Ztn.id);
      }
      if (this.aEt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onItemClick  isComplete=" + this.isComplete);
        }
        if (this.isComplete)
        {
          if (!this.jdField_a_of_type_Ztn.btg) {
            play();
          }
          this.isComplete = false;
        }
        BW(true);
        return;
      }
      if (this.aEt == 2)
      {
        BW(true);
        return;
      }
      if (this.aEt == 3)
      {
        startPlay();
        return;
      }
      if (this.aEt == 1)
      {
        pause();
        this.aEt = 4;
        return;
      }
    } while (this.aEt != 4);
    startPlay();
  }
  
  public abstract void bB(int paramInt, String paramString);
  
  public void crM()
  {
    if (this.jdField_a_of_type_Ztn != null) {
      this.jdField_a_of_type_Ztn.bth = true;
    }
    Fz(8);
    bB(8, "");
  }
  
  public void crN() {}
  
  public void crv()
  {
    if (this.jdField_a_of_type_Zrt != null) {
      this.jdField_a_of_type_Zrt.crv();
    }
  }
  
  public long eE()
  {
    return this.jdField_a_of_type_Zrt.eE();
  }
  
  public long eF()
  {
    return this.jdField_a_of_type_Zrt.eF();
  }
  
  public long getDuration()
  {
    return this.jdField_a_of_type_Zrt.getDuration();
  }
  
  public long getProgress()
  {
    if (this.jdField_a_of_type_Zrt != null) {
      return this.jdField_a_of_type_Zrt.getProgress();
    }
    return 0L;
  }
  
  public int getVideoState()
  {
    return this.aEt;
  }
  
  void gj(int paramInt1, int paramInt2)
  {
    String str = acfp.m(2131716427);
    if (this.mCurActivity != null) {
      str = this.mCurActivity.getString(2131720261);
    }
    if (this.jdField_a_of_type_Ztj$b != null) {
      this.jdField_a_of_type_Ztj$b.a(this.jdField_a_of_type_Ztn, paramInt1, paramInt2, str);
    }
  }
  
  public abstract void initUI(View paramView);
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onDestory ");
    }
    this.jdField_a_of_type_Ztn = null;
    if (this.jdField_a_of_type_Zrt != null)
    {
      this.jdField_a_of_type_Zrt.crw();
      this.jdField_a_of_type_Zrt.azR();
      this.jdField_a_of_type_Zrt = null;
    }
    this.btd = false;
    this.mCurActivity = null;
    this.jdField_a_of_type_Ztj$a.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ztj$a = null;
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onResume mVideoState=" + this.aEt);
    }
    if ((this.btd) && (this.aEt == 1))
    {
      BW(true);
      if (this.mCurActivity != null) {
        this.mCurActivity.runOnUiThread(new VideoPlayController.3(this));
      }
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = Pasue ");
    }
    this.aEt = 4;
    crO();
  }
  
  public void pauseDownload()
  {
    if (this.jdField_a_of_type_Zrt != null) {
      this.jdField_a_of_type_Zrt.pauseDownload();
    }
  }
  
  public void play()
  {
    if ((this.jdField_a_of_type_Zrt != null) && (this.jdField_a_of_type_Ztn != null))
    {
      if (this.jdField_a_of_type_Ztn.btf) {
        break label50;
      }
      if (this.jdField_a_of_type_Ztn.playUrl != null) {
        this.jdField_a_of_type_Zrt.V(this.jdField_a_of_type_Ztn.playUrl, 0L);
      }
    }
    return;
    label50:
    String str1;
    if (this.jdField_a_of_type_Ztn.l == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_Ztn.l != null) {
        break label124;
      }
    }
    label124:
    for (String str2 = "";; str2 = this.jdField_a_of_type_Ztn.l.md5)
    {
      this.jdField_a_of_type_Zrt.a(this.jdField_a_of_type_Ztn.pY(), str1, this.jdField_a_of_type_Ztn.cJ, 0L, str2, this.mCurActivity);
      return;
      str1 = String.valueOf(this.jdField_a_of_type_Ztn.l.videoFileTime);
      break;
    }
  }
  
  public abstract void resetUI();
  
  public void seek(int paramInt)
  {
    this.jdField_a_of_type_Zrt.seek(paramInt);
  }
  
  public void setDownloadNetworkChange(int paramInt)
  {
    if (this.jdField_a_of_type_Zrt != null) {
      this.jdField_a_of_type_Zrt.setDownloadNetworkChange(paramInt);
    }
  }
  
  protected void startPlay()
  {
    if ((VersionUtils.isrFroyo()) && (!this.jdField_a_of_type_Ztn.isMute) && (this.mCurActivity != null))
    {
      Activity localActivity1 = this.mCurActivity;
      Activity localActivity2 = this.mCurActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    this.jdField_a_of_type_Zrt.start();
    if (this.mCurActivity != null) {
      this.mCurActivity.runOnUiThread(new VideoPlayController.4(this));
    }
    this.jdField_a_of_type_Ztj$a.postDelayed(this.cF, 200L);
  }
  
  public void stopPlayAudio() {}
  
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("carverW VideoPlayController", 2, "MEDIA_PREPAREING ");
                      }
                      ztj.a(ztj.this, 2);
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + ztj.this.VN());
                      }
                      if (ztj.this.jdField_a_of_type_Ztj$b != null) {
                        ztj.this.jdField_a_of_type_Ztj$b.a(ztj.this.jdField_a_of_type_Ztn, ztj.this.getDuration());
                      }
                      if (ztj.this.VN())
                      {
                        ztj.this.startPlay();
                        ztj.this.BW(false);
                        return;
                      }
                      ztj.a(ztj.this, 3);
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                      }
                    } while (ztj.this.jdField_a_of_type_Ztj$b == null);
                    ztj.this.jdField_a_of_type_Ztj$b.onSeekComplete();
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                    }
                    ztj.a(ztj.this, true);
                    ztj.this.Fy(0);
                    ztj.this.Fz(0);
                    if (ztj.this.jdField_a_of_type_Ztj$b != null) {
                      ztj.this.jdField_a_of_type_Ztj$b.c(ztj.this.jdField_a_of_type_Ztn);
                    }
                    ztj.a(ztj.this, 0);
                    return;
                  } while (!QLog.isColorLevel());
                  QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                  }
                } while ((ztj.this.jdField_a_of_type_Zrt == null) || (ztj.this.mCurActivity == null));
                ztj.this.videoView = ztj.this.jdField_a_of_type_Zrt.m(ztj.this.mCurActivity);
              } while ((ztj.this.videoView == null) || (ztj.this.mCurActivity == null));
              ztj.a(ztj.this, ztj.this.mCurActivity);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
              }
              ztj.this.gj(paramMessage.arg1, paramMessage.arg2);
              return;
            } while (ztj.this.jdField_a_of_type_Ztj$b == null);
            if (paramMessage.arg1 == 929)
            {
              ztj.this.jdField_a_of_type_Ztj$b.d(ztj.this.jdField_a_of_type_Ztn);
              ztj.this.Fz(8);
              return;
            }
          } while (paramMessage.arg1 != 92);
          ztj.this.jdField_a_of_type_Ztj$b.a(ztj.this.jdField_a_of_type_Ztn, paramMessage.arg2);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + ztj.a(ztj.this));
          }
        } while ((ztj.this.jdField_a_of_type_Ztj$b == null) || (!ztj.a(ztj.this)));
        ztj.this.jdField_a_of_type_Ztj$b.b(ztj.this.jdField_a_of_type_Ztn, paramMessage.arg1);
      } while (ztj.a(ztj.this) == 4);
      ztj.this.Fz(8);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ztn paramztn);
    
    public abstract void a(ztn paramztn, int paramInt);
    
    public abstract void a(ztn paramztn, int paramInt1, int paramInt2, String paramString);
    
    public abstract void a(ztn paramztn, long paramLong);
    
    public abstract void a(ztn paramztn, boolean paramBoolean);
    
    public abstract void b(ztn paramztn);
    
    public abstract void b(ztn paramztn, int paramInt);
    
    public abstract void c(ztn paramztn);
    
    public abstract void d(ztn paramztn);
    
    public abstract void onSeekComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztj
 * JD-Core Version:    0.7.0.1
 */