import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;>;
import java.util.Iterator;
import java.util.List;

public class agxa
  extends agwc
  implements agld, agle, aguk.d, VideoPlayerCallback
{
  private aglf a;
  public agyc a;
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
  public final Runnable eu = new VideoFilePresenter.10(this);
  Runnable fn = new VideoFilePresenter.11(this);
  protected AudioManager mAudioManager;
  private Handler mHandler;
  private View.OnLongClickListener mLongClickListener = new agxb(this);
  private SeekBar.OnSeekBarChangeListener mSeekListener = new agxf(this);
  private BaseVideoView mVideoView;
  private PowerManager.WakeLock mWakeLock;
  private View.OnClickListener x = new agxc(this);
  
  public agxa(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new agxh(this);
    this.jdField_a_of_type_Agyc = new agyc(paramActivity);
    this.mHandler = new Handler();
    a(this.jdField_a_of_type_Agyc);
    dkl();
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              anot.a(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
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
    if ((str == null) && (this.jdField_a_of_type_Aguk.bG() == 1))
    {
      this.jdField_a_of_type_Agyc.showLoading(true);
      if (this.jdField_a_of_type_Aguk.bF() == 16)
      {
        this.jdField_a_of_type_Agyc.fR(this.jdField_a_of_type_Aguk.getFilePath(), this.mContext.getResources().getString(2131694161));
        this.jdField_a_of_type_Aguk.at(true);
        if ((this.d != null) && (this.d.isShowing())) {
          this.d.dismiss();
        }
      }
    }
    while (this.mVideoView == null)
    {
      return;
      dkk();
      this.jdField_a_of_type_Agyc.JK(true);
      aP(this.jdField_a_of_type_Aguk.k());
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
    this.jdField_a_of_type_Agyc.dkD();
  }
  
  private void dkk()
  {
    this.c = this.jdField_a_of_type_Aguk.a();
    if (this.c == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    this.jdField_a_of_type_Aglf = agkw.a(this.c);
    this.jdField_a_of_type_Aglf.a(this);
    this.jdField_a_of_type_Aglf.a(this);
    this.jdField_a_of_type_Aglf.setPlaying(true);
    this.jdField_a_of_type_Aglf.ZE();
    this.jdField_a_of_type_Agyc.JW(false);
    this.jdField_a_of_type_Agyc.JK(true);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void dkl()
  {
    this.mContext.setRequestedOrientation(-1);
    if ((this.mAudioManager == null) || (this.mVideoView == null))
    {
      this.mAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.mWakeLock = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
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
      this.mContext.runOnUiThread(new VideoFilePresenter.6(this));
    }
  }
  
  private void rp()
  {
    this.mContext.runOnUiThread(new VideoFilePresenter.7(this));
  }
  
  private String vR()
  {
    Object localObject;
    if (ahav.isLocalFile(this.jdField_a_of_type_Aguk.getFilePath())) {
      localObject = this.jdField_a_of_type_Aguk.getFilePath();
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
    } while (ahav.isLocalFile(str));
    return null;
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.mVideoView == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
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
  
  public void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.d == null)
    {
      localObject2 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject2).context = this.mContext;
      this.d = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
    }
    this.d.setRowVisibility(0, 0, 0);
    this.d.setOnDismissListener(new agxd(this));
    if (paramArrayOfArrayList != null) {
      if (paramArrayOfArrayList.length == 1) {
        paramArrayOfArrayList = paramArrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((paramArrayOfArrayList != null) && (!paramArrayOfArrayList.isEmpty())) || ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())))
      {
        this.d.setActionSheetTitle(paramString);
        paramString = this.jdField_a_of_type_Aguk.f();
        localObject2 = this.jdField_a_of_type_Aguk.ax();
        if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          break label217;
        }
        this.d.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.d.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
        this.d.setItemClickListenerV2(new agxe(this));
        this.d.show();
        this.cfH = true;
        return;
        if (paramArrayOfArrayList.length != 2) {
          break label246;
        }
        localObject2 = paramArrayOfArrayList[0];
        localObject1 = paramArrayOfArrayList[1];
        paramArrayOfArrayList = (ArrayList<ShareActionSheetBuilder.ActionSheetItem>[])localObject2;
        break;
        label217:
        this.d.setIntentForStartForwardRecentActivity(paramString);
        this.mContext.getIntent().putExtra("big_brother_source_key", (String)localObject2);
      }
      label246:
      paramArrayOfArrayList = null;
    }
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
      ahau.JH("0X8007427");
      this.jdField_a_of_type_Agyc.a(this.aai, this.mLongClickListener);
      this.jdField_a_of_type_Agyc.showLoading(true);
      if (this.mVideoView != null)
      {
        this.jdField_a_of_type_Agyc.JU(this.mVideoView.isPlaying());
        return;
      }
      this.jdField_a_of_type_Agyc.JU(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void cqt()
  {
    this.jdField_a_of_type_Agyc.dkA();
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
    int i = 5;
    String str2 = "";
    String str1 = "4";
    String str4 = "";
    int j = this.jdField_a_of_type_Aguk.EJ();
    String str3;
    if ((j == 3) || (j == 4))
    {
      str3 = this.jdField_a_of_type_Aguk.ay();
      str1 = "3";
      i = 2;
    }
    for (;;)
    {
      Object localObject = new DecimalFormat("0.00");
      str4 = ((DecimalFormat)localObject).format(this.aag / 1000.0D);
      localObject = ((DecimalFormat)localObject).format(this.aah / 1000.0D);
      anot.a(null, "dc00898", "", str2, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", str4 + ";" + (String)localObject, str3);
      super.cqt();
      return;
      if ((j == 5) || (j == 6))
      {
        str1 = "3";
        i = 2;
        str3 = str4;
      }
      else if (j != 1)
      {
        str3 = str4;
        if (j != 2) {}
      }
      else
      {
        str1 = "3";
        str2 = this.jdField_a_of_type_Aguk.ay();
        i = 1;
        str3 = str4;
      }
    }
  }
  
  public void djE() {}
  
  public void djF() {}
  
  public void djG()
  {
    this.jdField_a_of_type_Agyc.JW(true);
    this.jdField_a_of_type_Agyc.JK(false);
    if ((this.jdField_a_of_type_Aguk != null) && ((this.jdField_a_of_type_Aguk instanceof aguc))) {
      cAv();
    }
  }
  
  public void djH()
  {
    if (!ahbj.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) {
      return;
    }
    this.jdField_a_of_type_Agyc.JK(false);
    this.jdField_a_of_type_Agyc.JW(true);
    this.jdField_a_of_type_Agyc.JT(false);
  }
  
  protected void djX()
  {
    int i = this.jdField_a_of_type_Aguk.bK();
    if (i == 2) {
      if (this.jdField_a_of_type_Aguk.a() != null) {
        this.jdField_a_of_type_Aguk.a().iF();
      }
    }
    for (;;)
    {
      djY();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Aguk.a() != null) {
          this.jdField_a_of_type_Aguk.a().djq();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void djY()
  {
    this.jdField_a_of_type_Aguk.F("0X8009D60", null);
    super.djY();
    this.mContext.overridePendingTransition(17432576, 17432577);
  }
  
  public void dka()
  {
    List localList = null;
    ArrayList[] arrayOfArrayList;
    ArrayList localArrayList;
    if (this.d != null)
    {
      arrayOfArrayList = this.jdField_a_of_type_Aguk.b();
      if (arrayOfArrayList == null) {
        break label103;
      }
      if (arrayOfArrayList.length != 1) {
        break label86;
      }
      localArrayList = arrayOfArrayList[0];
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localList != null) && (!localList.isEmpty()))) {
        this.d.setActionSheetItems(localArrayList, localList);
      }
      if (this.d.isShowing()) {
        this.d.refresh();
      }
      return;
      label86:
      if (arrayOfArrayList.length == 2)
      {
        localArrayList = arrayOfArrayList[0];
        localList = arrayOfArrayList[1];
      }
      else
      {
        label103:
        localArrayList = null;
      }
    }
  }
  
  public void doBeforeFinish()
  {
    this.mContext.overridePendingTransition(17432576, 17432577);
  }
  
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
    agyc localagyc;
    if ((this.jdField_a_of_type_Agyc != null) && (this.mVideoView != null))
    {
      localagyc = this.jdField_a_of_type_Agyc;
      if (this.mVideoView.isPlaying()) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localagyc.JU(bool);
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
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = video");
    }
    this.jdField_a_of_type_Agyc.setOnClickListener(this.x);
    this.jdField_a_of_type_Agyc.OR(10000);
    this.jdField_a_of_type_Agyc.setSeekBarChangeListener(this.mSeekListener);
    this.jdField_a_of_type_Agyc.dkB();
    this.jdField_a_of_type_Aguk.a(this);
    this.jdField_a_of_type_Agyc.JW(false);
    cAt();
    this.mVideoView = this.jdField_a_of_type_Agyc.c();
    cAv();
    if (this.jdField_b_of_type_Agsb != null) {
      this.jdField_b_of_type_Agsb.as(true);
    }
    if ((ahav.isLocalFile(this.jdField_a_of_type_Aguk.getFilePath())) && (this.jdField_a_of_type_Aguk.bL() == 2)) {
      this.jdField_a_of_type_Agyc.JW(true);
    }
    int i = this.jdField_a_of_type_Aguk.bL();
    int j = this.jdField_a_of_type_Aguk.bK();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Agyc.JK(false);
      this.jdField_a_of_type_Agyc.JW(false);
      this.jdField_a_of_type_Agyc.JT(false);
    }
    this.jdField_a_of_type_Agyc.JV(this.jdField_a_of_type_Aguk.amv());
    rp();
    arlc.aT(this.mContext, 53);
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("FileBrowserPresenter<FileAssistant>", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
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
      this.jdField_a_of_type_Agyc.showLoading(true);
      return;
    case 4: 
      if (this.mVideoView != null) {
        this.aag = this.mVideoView.getVideoDurationMs();
      }
      this.jdField_a_of_type_Agyc.fW(this.aag);
      if (vR() != null)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label130;
        }
        this.jdField_a_of_type_Agyc.JK(false);
        this.jdField_a_of_type_Agyc.JW(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Agyc.showLoading(false);
        return;
        paramInt = 0;
        break;
        label130:
        this.jdField_a_of_type_Agyc.JK(true);
        this.jdField_a_of_type_Agyc.JW(false);
      }
    }
    this.cfE = true;
    this.cYP = 0;
    this.mWakeLock.release();
    this.jdField_a_of_type_Agyc.OL(0);
    this.jdField_a_of_type_Agyc.setCurrentTime(0L);
    this.jdField_a_of_type_Agyc.JU(false);
  }
  
  public boolean requestAudioFocus()
  {
    return this.mAudioManager.requestAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  public void yd(String paramString)
  {
    this.jdField_a_of_type_Agyc.JW(true);
    this.jdField_a_of_type_Agyc.JK(false);
    this.mHandler.post(this.eu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxa
 * JD-Core Version:    0.7.0.1
 */