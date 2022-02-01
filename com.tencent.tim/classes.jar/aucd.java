import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.4;
import com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.5;
import com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.8;
import com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.9;

public class aucd
  extends aubi
  implements agld, agle, atzy.d, VideoPlayerCallback
{
  private aglf a;
  public aucv a;
  private long aag;
  private long aah;
  private long aai = ahav.d().longValue();
  private AudioManager.OnAudioFocusChangeListener b;
  private agsw c;
  private int cYP;
  private boolean cfE;
  boolean cfF = false;
  private boolean cfG;
  private boolean cfH;
  private ShareActionSheet d;
  public final Runnable eu = new VideoFilePresenter.8(this);
  Runnable fn = new VideoFilePresenter.9(this);
  protected AudioManager mAudioManager;
  private Handler mHandler;
  private View.OnLongClickListener mLongClickListener = new auce(this);
  private SeekBar.OnSeekBarChangeListener mSeekListener = new aucg(this);
  private BaseVideoView mVideoView;
  private PowerManager.WakeLock mWakeLock;
  private View.OnClickListener x = new aucf(this);
  
  public aucd(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new auci(this);
    this.jdField_a_of_type_Aucv = new aucv(paramActivity);
    this.mHandler = new Handler();
    a(this.jdField_a_of_type_Aucv);
    dkl();
  }
  
  private void cAB()
  {
    if ((this.mVideoView != null) && (!this.mVideoView.isPlaying())) {
      return;
    }
    this.mHandler.postDelayed(this.fn, 2500L);
  }
  
  private void cAv()
  {
    String str = vR();
    if ((str == null) && (this.jdField_a_of_type_Atzy.bG() == 1))
    {
      this.jdField_a_of_type_Aucv.showLoading(true);
      if (this.jdField_a_of_type_Atzy.bF() == 16)
      {
        this.jdField_a_of_type_Aucv.fR(this.jdField_a_of_type_Atzy.getFilePath(), this.mContext.getResources().getString(2131694161));
        this.jdField_a_of_type_Atzy.at(true);
        if ((this.d != null) && (this.d.isShowing())) {
          this.d.dismiss();
        }
      }
    }
    while (this.mVideoView == null)
    {
      return;
      dkk();
      this.jdField_a_of_type_Aucv.JK(true);
      aP(this.jdField_a_of_type_Atzy.k());
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mVideoPath = str;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = allh.eO(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    this.mVideoView.setVideoParam(localVideoPlayParam);
  }
  
  private void cAz()
  {
    this.mHandler.removeCallbacks(this.fn);
    this.jdField_a_of_type_Aucv.dkD();
  }
  
  private void dkk()
  {
    this.c = this.jdField_a_of_type_Atzy.a();
    if (this.c == null)
    {
      QLog.w("FileBrowserPresenterBase", 1, "get video biz, data is null!");
      return;
    }
    this.jdField_a_of_type_Aglf = agkw.a(this.c);
    this.jdField_a_of_type_Aglf.a(this);
    this.jdField_a_of_type_Aglf.a(this);
    this.jdField_a_of_type_Aglf.setPlaying(true);
    this.jdField_a_of_type_Aglf.ZE();
    this.jdField_a_of_type_Aucv.JW(false);
    this.jdField_a_of_type_Aucv.JK(true);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void dkl()
  {
    this.mContext.setRequestedOrientation(-1);
    if ((this.mAudioManager == null) || (this.mVideoView == null))
    {
      this.mAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.mWakeLock = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenterBase");
      this.mWakeLock.setReferenceCounted(false);
      this.mHandler = new Handler();
    }
  }
  
  private int hK(int paramInt)
  {
    long l2 = this.aag;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (this.mVideoView != null) {
        l1 = this.mVideoView.getVideoDurationMs();
      }
    }
    float f = paramInt / 10000.0F;
    return (int)((float)l1 * f);
  }
  
  private void pause()
  {
    if (this.mVideoView != null)
    {
      this.mWakeLock.release();
      this.mVideoView.pause();
      this.mContext.runOnUiThread(new VideoFilePresenter.4(this));
    }
  }
  
  private void rp()
  {
    this.mContext.runOnUiThread(new VideoFilePresenter.5(this));
  }
  
  private String vR()
  {
    Object localObject;
    if (ahav.isLocalFile(this.jdField_a_of_type_Atzy.getFilePath())) {
      localObject = this.jdField_a_of_type_Atzy.getFilePath();
    }
    String str;
    do
    {
      return localObject;
      if (this.c == null) {
        break;
      }
      str = this.c.vL();
      localObject = str;
    } while (audx.isLocalFile(str));
    return null;
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.mVideoView == null)
    {
      QLog.e("FileBrowserPresenterBase", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = false;
    localVideoPlayParam.mSavePath = paramSuperPlayerVideoInfo.getLocalSavePath();
    localVideoPlayParam.mFileID = paramSuperPlayerVideoInfo.getFileId();
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = allh.eO(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    localVideoPlayParam.mUrls = paramSuperPlayerVideoInfo.getPlayUrls();
    localVideoPlayParam.mCookies = paramSuperPlayerVideoInfo.getCookie();
    localVideoPlayParam.mVideoFormat = 104;
    this.mVideoView.setVideoParam(localVideoPlayParam);
    rp();
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
  }
  
  public boolean amj()
  {
    return false;
  }
  
  public boolean amk()
  {
    return false;
  }
  
  public void bp(int paramInt, String paramString) {}
  
  protected void cAt()
  {
    try
    {
      ahau.JH("0X8007426");
      audw.JH("0X8007427");
      this.jdField_a_of_type_Aucv.a(this.aai, this.mLongClickListener);
      this.jdField_a_of_type_Aucv.showLoading(true);
      if (this.mVideoView != null)
      {
        this.jdField_a_of_type_Aucv.JU(this.mVideoView.isPlaying());
        return;
      }
      this.jdField_a_of_type_Aucv.JU(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void cqt()
  {
    this.jdField_a_of_type_Aucv.dkA();
    if (this.mVideoView != null)
    {
      this.mVideoView.releasePlayer(true);
      this.mVideoView = null;
    }
    if (this.jdField_a_of_type_Aglf != null) {
      this.jdField_a_of_type_Aglf.a(null);
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this.eu);
      this.mHandler.removeCallbacks(this.fn);
      this.mHandler = null;
    }
    if (this.mAudioManager != null) {
      this.mAudioManager.abandonAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    if (this.jdField_a_of_type_Aglf != null) {
      this.jdField_a_of_type_Aglf.setPlaying(false);
    }
    super.cqt();
  }
  
  public void djE() {}
  
  public void djF() {}
  
  public void djG()
  {
    this.jdField_a_of_type_Aucv.JW(true);
    this.jdField_a_of_type_Aucv.JK(false);
  }
  
  public void djH()
  {
    if (!aueh.fileExistsAndNotEmpty(this.jdField_a_of_type_Atzy.getFilePath())) {
      return;
    }
    this.jdField_a_of_type_Aucv.JK(false);
    this.jdField_a_of_type_Aucv.JW(true);
    this.jdField_a_of_type_Aucv.JT(false);
  }
  
  protected void djX()
  {
    int i = this.jdField_a_of_type_Atzy.bK();
    if (i == 2) {
      if (this.jdField_a_of_type_Atzy.a() != null) {
        this.jdField_a_of_type_Atzy.a().iF();
      }
    }
    for (;;)
    {
      djY();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Atzy.a() != null) {
          this.jdField_a_of_type_Atzy.a().djq();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenterBase", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void djY() {}
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.cfH)
    {
      this.cfH = false;
      return;
    }
    if ((this.mWakeLock != null) && (this.mWakeLock.isHeld())) {
      this.mWakeLock.release();
    }
    pause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aucv localaucv;
    if ((this.jdField_a_of_type_Aucv != null) && (this.mVideoView != null))
    {
      localaucv = this.jdField_a_of_type_Aucv;
      if (this.mVideoView.isPlaying()) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localaucv.JU(bool);
      this.mHandler.postDelayed(this.eu, 100L);
      this.mVideoView.play();
      return;
    }
  }
  
  public void e(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenterBase", 1, "FileBrowserPresenter init: type = video");
    }
    this.jdField_a_of_type_Aucv.setOnClickListener(this.x);
    this.jdField_a_of_type_Aucv.OR(10000);
    this.jdField_a_of_type_Aucv.setSeekBarChangeListener(this.mSeekListener);
    this.jdField_a_of_type_Aucv.dkB();
    this.jdField_a_of_type_Atzy.a(this);
    this.jdField_a_of_type_Aucv.JW(false);
    cAt();
    this.mVideoView = this.jdField_a_of_type_Aucv.c();
    cAv();
    if (this.jdField_b_of_type_Atyr != null) {
      this.jdField_b_of_type_Atyr.as(true);
    }
    if ((audx.isLocalFile(this.jdField_a_of_type_Atzy.getFilePath())) && (this.jdField_a_of_type_Atzy.bL() == 2)) {
      this.jdField_a_of_type_Aucv.JW(true);
    }
    int i = this.jdField_a_of_type_Atzy.bL();
    int j = this.jdField_a_of_type_Atzy.bK();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Aucv.JK(false);
      this.jdField_a_of_type_Aucv.JW(false);
      this.jdField_a_of_type_Aucv.JT(false);
    }
    rp();
    arlc.aT(this.mContext, 53);
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("FileBrowserPresenterBase", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
    this.jdField_a_of_type_Aglf.dhB();
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
    case 3: 
    case 5: 
      this.jdField_a_of_type_Aucv.showLoading(true);
      return;
    case 4: 
      if (this.mVideoView != null) {
        this.aag = this.mVideoView.getVideoDurationMs();
      }
      this.jdField_a_of_type_Aucv.fW(this.aag);
      if (vR() != null)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label130;
        }
        this.jdField_a_of_type_Aucv.JK(false);
        this.jdField_a_of_type_Aucv.JW(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aucv.showLoading(false);
        return;
        paramInt = 0;
        break;
        label130:
        this.jdField_a_of_type_Aucv.JK(true);
        this.jdField_a_of_type_Aucv.JW(false);
      }
    }
    this.cfE = true;
    this.cYP = 0;
    this.mWakeLock.release();
    this.jdField_a_of_type_Aucv.OL(0);
    this.jdField_a_of_type_Aucv.setCurrentTime(0L);
    this.jdField_a_of_type_Aucv.JU(false);
  }
  
  public boolean requestAudioFocus()
  {
    return this.mAudioManager.requestAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  public void yd(String paramString)
  {
    this.jdField_a_of_type_Aucv.JW(true);
    this.jdField_a_of_type_Aucv.JK(false);
    this.mHandler.post(this.eu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucd
 * JD-Core Version:    0.7.0.1
 */