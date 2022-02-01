import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class arlq
  implements xsi.a
{
  private URLDrawable O;
  ajat.c jdField_a_of_type_Ajat$c = new arls(this);
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private ztn jdField_a_of_type_Ztn;
  private int aEt = 0;
  private long awb;
  private VideoPlayParam d;
  private WeakReference<Context> mContext;
  private int mVideoHeight;
  private BaseVideoView mVideoView;
  private int mVideoWidth;
  
  public arlq(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
  }
  
  private void ZE()
  {
    if (this.jdField_a_of_type_Ztn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "clickPlay curState:", Integer.valueOf(this.aEt), ",path:", this.jdField_a_of_type_Ztn.playUrl });
    }
    onPlay();
  }
  
  private void Zh(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onSeek === progress : " + paramInt);
    }
    if (this.mVideoView != null) {
      this.mVideoView.seekTo(paramInt);
    }
  }
  
  private VideoPlayParam b(ztn paramztn)
  {
    boolean bool = true;
    this.d = new VideoPlayParam();
    this.d.mIsMute = false;
    this.d.mSceneId = 116;
    this.d.mSceneName = allh.eO(116);
    this.d.mNeedPlayProgress = true;
    if (paramztn != null)
    {
      this.d.mStartPlayPosMs = paramztn.Lx;
      VideoPlayParam localVideoPlayParam = this.d;
      if (paramztn.btf) {
        break label116;
      }
      localVideoPlayParam.mIsLocal = bool;
      if (!this.d.mIsLocal) {
        break label121;
      }
      this.d.mVideoPath = paramztn.playUrl;
    }
    for (;;)
    {
      b(this.d);
      return this.d;
      label116:
      bool = false;
      break;
      label121:
      this.d.mUrls = paramztn.cJ;
      this.d.mSavePath = paramztn.playUrl;
    }
  }
  
  private void b(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new arlt(this);
  }
  
  private void ekn()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) && (this.mVideoView != null))
    {
      long l = this.mVideoView.getVideoDurationMs();
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "mVideoView.getVideoDurationMs = " + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoStart((int)l);
    }
  }
  
  private void gj(int paramInt1, int paramInt2)
  {
    int i = 401;
    if (paramInt1 == 1) {
      i = 402;
    }
    if (paramInt2 == 14011001) {
      i = 403;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoError(i);
    }
  }
  
  private void onCompleted()
  {
    ajat.a().abandonMediaFocus(this.jdField_a_of_type_Ajat$c);
    if ((this.mContext != null) && (this.mContext.get() != null)) {
      ((AudioManager)((Context)this.mContext.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void onPause()
  {
    ajat.a().abandonMediaFocus(this.jdField_a_of_type_Ajat$c);
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onPause ===");
    }
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    this.aEt = 6;
  }
  
  private void onPlay()
  {
    if (ajat.a().requestMediaFocus(1, this.jdField_a_of_type_Ajat$c) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "onPlay ===");
      }
      if (this.mVideoView != null) {
        this.mVideoView.play();
      }
      this.aEt = 4;
    }
  }
  
  public void a(ztn paramztn, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with mediaInfo :", paramztn.playUrl });
    }
    this.awb = paramLong1;
    this.jdField_a_of_type_Ztn = paramztn;
    this.jdField_a_of_type_Ztn.Lx = paramLong2;
    this.d = b(this.jdField_a_of_type_Ztn);
    this.mVideoView = ((BaseVideoView)allg.createBaseVideoView((Context)this.mContext.get(), 0L, this.d, null));
    xsi.a().a(this);
  }
  
  public void aR(String paramString, int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    Object localObject;
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.j(paramString);
      if (paramString != null)
      {
        paramString = paramString.toString();
        if (!TextUtils.isEmpty(paramString)) {
          localObject = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
        }
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).downloadImediatly();
      }
      if ((localObject instanceof URLDrawable)) {
        this.O = ((URLDrawable)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TVKVideoController", 2, "initCover():  getDrawable Exception, coverUrl=" + paramString, localException);
    }
  }
  
  public void byw()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener = FloatingScreenManager.getInstance().setFloatingVideoListener(new arlr(this));
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "destory!");
    }
    if ((this.mContext != null) && (this.mContext.get() != null)) {
      ((AudioManager)((Context)this.mContext.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_Ztn = null;
    this.mContext = null;
    this.O = null;
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
    this.mVideoView = null;
    ajat.a().abandonMediaFocus(this.jdField_a_of_type_Ajat$c);
    xsi.a().b(this);
  }
  
  public void fG(long paramLong)
  {
    if (this.awb == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, new Object[] { "onRecokeMsg:", Long.valueOf(paramLong) });
      }
      ThreadManager.getUIHandler().post(new TVKVideoController.2(this));
    }
  }
  
  public boolean q(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1;
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      f1 = paramInt2 / paramInt3;
      if (f1 <= 1.0F) {
        break label174;
      }
      f1 = 1.0F / f1;
    }
    label164:
    label174:
    for (;;)
    {
      if (paramInt2 > paramInt3) {}
      for (boolean bool = true;; bool = false)
      {
        FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(bool).setRatio(f1).setCanMove(true).build();
        if (FloatingScreenManager.getInstance().enterFloatingScreen(BaseApplicationImpl.getContext(), this.mVideoView, localFloatingScreenParams, arlb.kG(paramInt1)) != 1) {
          break label164;
        }
        FloatingScreenPermission.enterPermissionRequestDialog((Context)this.mContext.get());
        return false;
        float f2 = 0.5625F;
        f1 = f2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TVKVideoController", 2, "videoWidth or videoHeight Wrong. videoWidth = " + paramInt2 + " videoHeight = " + paramInt3);
        f1 = f2;
        break;
      }
      byw();
      ZE();
      return true;
    }
  }
  
  public void w(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    File localFile = new File(paramString);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      this.awb = paramLong1;
      this.jdField_a_of_type_Ztn = new ztn();
      this.jdField_a_of_type_Ztn.btf = false;
      this.jdField_a_of_type_Ztn.playUrl = paramString;
      this.jdField_a_of_type_Ztn.fileSize = l;
      this.jdField_a_of_type_Ztn.ap = l;
      this.jdField_a_of_type_Ztn.Lx = paramLong2;
      this.d = b(this.jdField_a_of_type_Ztn);
      this.mVideoView = ((BaseVideoView)allg.createBaseVideoView((Context)this.mContext.get(), 0L, this.d, null));
      xsi.a().a(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlq
 * JD-Core Version:    0.7.0.1
 */