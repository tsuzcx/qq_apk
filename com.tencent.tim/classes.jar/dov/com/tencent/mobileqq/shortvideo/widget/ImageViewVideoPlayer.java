package dov.com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anii;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.OnPlayerOneFrameListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import rox;

public class ImageViewVideoPlayer
  extends LinearLayout
  implements URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener, VideoDrawable.OnPlayerOneFrameListener
{
  private static ColorDrawable h = new ColorDrawable(-14342358);
  private int Ob;
  public VideoDrawable a;
  public a a;
  public b a;
  private PlayerProgressBar a;
  public URLImageView bN;
  private boolean cHZ;
  private boolean cIa;
  private boolean cIb = true;
  public boolean cIc;
  private boolean cId;
  private String ceC;
  private String ceD;
  public int dJr = 1;
  private int dJs;
  public Bitmap gl;
  public BitmapDrawable i;
  private URLDrawable k;
  public boolean mRequireAudioFocus = true;
  
  public ImageViewVideoPlayer(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public ImageViewVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  private void dRt()
  {
    if (this.k != null) {}
    try
    {
      Drawable localDrawable = this.k.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable)))
      {
        this.jdField_a_of_type_ComTencentImageVideoDrawable = ((VideoDrawable)this.k.getCurrDrawable());
        boolean bool2 = this.jdField_a_of_type_ComTencentImageVideoDrawable.isAudioPlaying();
        if ((!anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL)) && (!anii.isFoundProductFeature(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2))) {
          break label141;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "initPlayer: audioPlaying= " + bool2 + " black=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_ComTencentImageVideoDrawable.disableGlobalPause();
        }
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "checkAndGetVideoDrawable mUrlDrawable==null", localNullPointerException);
        }
        Object localObject = null;
        continue;
        label141:
        boolean bool1 = false;
      }
    }
  }
  
  private void dRu()
  {
    if (!this.cHZ)
    {
      this.cHZ = true;
      this.gl = getCurrentBitmap();
      bsT();
      releasePlayer();
      getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.3(this));
    }
  }
  
  private void initUI(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.bN = new URLImageView(paramContext);
    super.addView(this.bN, localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar = new PlayerProgressBar(paramContext);
    super.addView(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar, localLayoutParams);
    super.setVisibility(8);
    this.dJr = 1;
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
  {
    int j = (int)(paramInt1 * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "updateUISize width" + paramInt1 + "height" + j + "screenHeight=" + paramInt2);
    }
    if (j < paramInt2) {}
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.bN.setLayoutParams(localLayoutParams);
      this.cIb = paramBoolean;
      if (this.cIb)
      {
        localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt3);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setLayoutParams(localLayoutParams);
        return;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setVisibility(8);
      return;
      paramInt2 = j;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.cIc = true;
    this.ceD = paramString2;
    this.ceC = paramString3;
    return a(paramInt1, paramInt2, paramInt3, paramString1, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((!this.cIc) && (em(paramString) != 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.cIc = false;
    this.gl = null;
    this.Ob = (paramInt3 - 3);
    if (this.cIb)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.mTotalTime = paramInt1;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.cqg = paramInt2;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.aAE = paramInt3;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(0, false);
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = null;
    paramString.mLoadingDrawable = h;
    if (this.i != null) {
      paramString.mLoadingDrawable = this.i;
    }
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
    localVideoDrawableParams.mVideoRoundCorner = 0;
    localVideoDrawableParams.mRequestedFPS = -1;
    localVideoDrawableParams.mEnableAntiAlias = true;
    localVideoDrawableParams.mEnableFilter = true;
    localVideoDrawableParams.mPlayAudioFrame = this.cId;
    localVideoDrawableParams.mPlayVideoFrame = true;
    localVideoDrawableParams.mDecodeType = 1;
    localVideoDrawableParams.mAfPath = this.ceD;
    localVideoDrawableParams.mVfPath = this.ceC;
    localVideoDrawableParams.mTotalTime = paramInt2;
    localVideoDrawableParams.mVideoFrames = paramInt3;
    paramString.mExtraInfo = localVideoDrawableParams;
    if ((!this.cIa) || (!paramBoolean)) {
      paramString.mUseMemoryCache = false;
    }
    this.k = URLDrawable.getDrawable(new File(this.ceC), paramString);
    this.bN.setURLDrawableDownListener(this);
    dRt();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.cIa) {
        this.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      }
    }
    this.dJr = 2;
    this.cHZ = false;
    return true;
  }
  
  public void bsT()
  {
    if ((this.k != null) && (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.stopAudio();
    }
    Handler localHandler = super.getHandler();
    if (localHandler != null) {
      localHandler.postAtFrontOfQueue(new ImageViewVideoPlayer.1(this));
    }
    this.dJr = 4;
  }
  
  public int em(String paramString)
  {
    int j = -1;
    if (paramString == null) {
      j = -4;
    }
    File localFile;
    do
    {
      do
      {
        return j;
        localFile = new File(paramString);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), videoDir not exist");
      return -1;
      paramString = localFile.list();
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), files = null");
    return -1;
    String str = localFile.getAbsolutePath() + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(paramString) + ",filse count = " + localFile.listFiles().length);
    }
    int m = paramString.length;
    j = 0;
    while (j < m)
    {
      localFile = paramString[j];
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), current file = " + localFile);
      }
      if (localFile.endsWith(".af")) {
        this.ceD = (str + localFile);
      }
      if ((localFile.endsWith(".vf")) && (rox.getFileSize(str + localFile) > 0L)) {
        this.ceC = (str + localFile);
      }
      j += 1;
    }
    if ((this.ceC == null) || ("".equals(this.ceC))) {
      return -3;
    }
    if ((this.ceD == null) || ("".equals(this.ceD))) {
      return -2;
    }
    this.cId = false;
    if (rox.getFileSize(this.ceD) > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), mNeedPlayAudio = " + this.cId);
      }
      this.cId = true;
    }
    return 0;
  }
  
  public Bitmap getCurrentBitmap()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageVideoDrawable.getCurrentBitmap();
    }
    return null;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    dRt();
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    dRt();
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    dRt();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.mRequireAudioFocus) {
        this.jdField_a_of_type_ComTencentImageVideoDrawable.disableRequireAudioFocus();
      }
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes= " + paramInt);
    }
    if (!this.cIa)
    {
      if (this.cIb) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.dJs, true);
      }
      dRu();
      return;
    }
    this.dJs = 0;
    getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.2(this, paramInt));
  }
  
  public void oneFrameDrawed()
  {
    this.dJs += 1;
    if (this.dJs >= this.Ob) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.cIb) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.dJs, bool);
      }
      if ((bool) && (!this.cIa)) {
        dRu();
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$a.wR(this.dJs);
      }
      return;
    }
  }
  
  public void releasePlayer()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.enableGlobalPause();
      this.jdField_a_of_type_ComTencentImageVideoDrawable.removeOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(null);
    }
    this.k = null;
    this.Ob = 0;
    this.dJs = 0;
    this.dJr = 1;
  }
  
  public void resetPlay()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.resetPlay();
    }
  }
  
  public void setCyclePlay(boolean paramBoolean)
  {
    this.cIa = paramBoolean;
  }
  
  public void setIMPFrameListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$a = parama;
  }
  
  public void setIMPlayerEndListener(b paramb)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$b = paramb;
  }
  
  public void setNeedPlayAudio(boolean paramBoolean)
  {
    this.cId = paramBoolean;
  }
  
  public void startPlayer()
  {
    super.setVisibility(0);
    if (this.bN != null) {
      this.bN.setImageDrawable(this.k);
    }
    this.dJr = 3;
  }
  
  public static abstract interface a
  {
    public abstract void wR(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Nn();
    
    public abstract void No();
    
    public abstract void Np();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer
 * JD-Core Version:    0.7.0.1
 */