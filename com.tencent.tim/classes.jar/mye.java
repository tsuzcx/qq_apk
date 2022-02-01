import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class mye
  implements mrz, myj.a
{
  public static final String TAG = "Q.readinjoy.video." + mye.class.getSimpleName();
  private myj jdField_a_of_type_Myj;
  private mza jdField_a_of_type_Mza;
  private Set<mye.c> ag;
  private String akI;
  private boolean aps;
  private boolean aql = true;
  private boolean aqm;
  private boolean aqn;
  private msc jdField_b_of_type_Msc = new myf(this);
  private myp jdField_b_of_type_Myp;
  private mst c;
  private mye.b d;
  private mye.b e;
  private HashMap<Integer, myi> eo;
  private Map<String, WeakReference<myi>> ez;
  public mye.b f;
  private myi f;
  private mye.b g;
  private ArrayList<Pair<Integer, Bitmap>> lv;
  private volatile Activity mActivity;
  private int mPlayCount = 1;
  private AtomicInteger mState = new AtomicInteger(0);
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  private volatile boolean mVisible;
  protected int mXYaxis;
  private CopyOnWriteArrayList<mye.a> r;
  
  public mye(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Myj = new myj();
    this.jdField_a_of_type_Myj.a(this);
    this.eo = new HashMap();
    this.lv = new ArrayList();
    this.ez = new HashMap();
    this.r = new CopyOnWriteArrayList();
    mzj.a().b(this);
  }
  
  private void a(mye.b paramb, myi parammyi, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.mState.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "changeStateAndNotify(): " + myh.bA(this.mState.get()) + " ===> " + myh.bA(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramb + ", videoPlayWrapper=" + parammyi);
        }
        this.mState.set(paramInt);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label192;
        }
        if (this.r != null)
        {
          Iterator localIterator = this.r.iterator();
          while (localIterator.hasNext())
          {
            mye.a locala = (mye.a)localIterator.next();
            if (locala != null) {
              locala.a(paramb, parammyi, i, paramInt, paramObject);
            }
          }
        }
        ac(paramInt, false);
      }
    }
    finally {}
    for (;;)
    {
      return;
      label192:
      this.mUiHandler.post(new VideoPlayManager.2(this, paramb, parammyi, i, paramInt, paramObject));
    }
  }
  
  private void ac(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 3) && (!this.mVisible))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pause for not visible，isSubThread:" + paramBoolean);
      }
      pause();
    }
  }
  
  private void c(mye.b paramb)
  {
    paramb.c.bandwidth = mzs.a().getCurrentPrediction();
    paramb.c.ahD = mzz.a().kC();
  }
  
  public boolean EP()
  {
    return this.aqm;
  }
  
  public boolean EQ()
  {
    return (this.jdField_f_of_type_Myi != null) && (this.jdField_f_of_type_Myi.ER());
  }
  
  public myi a(mye.b paramb)
  {
    if (this.mActivity == null) {
      return null;
    }
    myi localmyi = new myi(this.mActivity.getApplicationContext());
    localmyi.oP(true);
    localmyi.a(this.jdField_b_of_type_Msc);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.ez.put(paramb.getInnerUniqueID(), new WeakReference(localmyi));
    return localmyi;
  }
  
  public mza a()
  {
    return this.jdField_a_of_type_Mza;
  }
  
  public void a(int paramInt, mye.b paramb)
  {
    this.g = null;
    if ((this.d != null) && (this.jdField_f_of_type_Myi != null))
    {
      if (this.jdField_f_of_type_Myi.qe() == 2) {
        this.jdField_f_of_type_Myi.start();
      }
      this.jdField_f_of_type_Myi.seekTo(paramInt);
      a(this.d, this.jdField_f_of_type_Myi, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramb == null) {
          break;
        }
        this.d = paramb;
        paramb = this.d;
        stop(1);
        paramb.xb = paramInt;
        a(paramb);
      } while (!QLog.isColorLevel());
      QLog.w(TAG, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramb.videoVid);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.mVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(mrr parammrr)
  {
    if ((parammrr == null) || (!(parammrr instanceof mye.b))) {}
    do
    {
      do
      {
        return;
        parammrr = (mye.b)parammrr;
        if (!mzj.av(this.mActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      try
      {
        this.g = null;
        this.jdField_f_of_type_Mye$b = null;
        if (this.jdField_a_of_type_Mza != null) {
          this.jdField_a_of_type_Mza.d(parammrr);
        }
        if (this.jdField_a_of_type_Myj.EU()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.d = parammrr;
        a(this.d, null, 4, null);
        this.jdField_a_of_type_Myj.installPlugin();
        return;
      }
      catch (Exception parammrr)
      {
        parammrr.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", parammrr);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "play video start ! playParams : " + parammrr.toString());
    }
    this.aps = true;
    myi localmyi = a(parammrr);
    this.jdField_f_of_type_Myi = localmyi;
    this.d = parammrr;
    a(this.d, this.jdField_f_of_type_Myi, 1, null);
    parammrr.b.removeAllViews();
    this.jdField_f_of_type_Myi.t(parammrr.b);
    nbr localnbr = this.jdField_f_of_type_Myi.b();
    if ((localnbr == null) || (localnbr.am() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "playVideo : get videoView Fail !");
      }
      a(this.d, null, 6, "videoview null");
      this.jdField_f_of_type_Myi = null;
      this.d = null;
      return;
    }
    parammrr.a = localnbr;
    localnbr.am().setId(2131376720);
    parammrr.b.setKeepScreenOn(true);
    this.jdField_f_of_type_Myi.setXYaxis(this.mXYaxis);
    this.d.c.vs = SystemClock.uptimeMillis();
    this.d.c.aSt = 0;
    this.d.c.skipFramesTotalCount = 0;
    this.d.c.aSu = 0;
    this.d.c.amF = false;
    this.d.c.amG = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.3(this, parammrr, localmyi));
  }
  
  public void a(msl parammsl)
  {
    parammsl.a(this);
  }
  
  public void a(mst parammst)
  {
    this.c = parammst;
  }
  
  public void a(mye.a parama)
  {
    if ((parama != null) && (this.r != null) && (!this.r.contains(parama))) {
      this.r.add(parama);
    }
  }
  
  public void a(mye.c paramc)
  {
    if (this.ag == null) {
      this.ag = new HashSet();
    }
    this.ag.add(paramc);
  }
  
  public void a(myp parammyp)
  {
    this.jdField_b_of_type_Myp = parammyp;
  }
  
  void aST()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "checkPlayStateAfterPhoneCall isVisible() = " + isVisible());
    }
    if (!isVisible()) {
      return;
    }
    resume();
  }
  
  public void aTM()
  {
    this.mVisible = false;
    pause(false);
  }
  
  public void aTN()
  {
    if (this.mVisible)
    {
      this.mVisible = false;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onUnVisiable() isPlaying()=" + isPlaying() + ", isOpening()=" + EQ());
      }
      if (!isPlaying()) {
        break label105;
      }
      pause();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mza != null)
      {
        this.jdField_a_of_type_Mza.doOnPause();
        this.jdField_a_of_type_Mza.oQ(false);
      }
      mzs.a().stop(this.mActivity);
      return;
      label105:
      if (EQ()) {
        stop(8);
      }
    }
  }
  
  public void aTO()
  {
    if (!this.mVisible)
    {
      this.mVisible = true;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onVisiable() isPause()=" + isPause() + ", mPausedByMannul:" + this.aqm);
      }
      if ((this.d != null) && (this.d.c != null)) {
        this.d.c.vs = SystemClock.uptimeMillis();
      }
      if ((isPause()) && (!this.aqm)) {
        resume();
      }
      if (this.jdField_a_of_type_Mza != null)
      {
        this.jdField_a_of_type_Mza.doOnResume();
        if (!(this.mActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Mza.oQ(false);
      }
    }
    for (;;)
    {
      mzs.a().start(this.mActivity);
      return;
      label152:
      this.jdField_a_of_type_Mza.oQ(true);
    }
  }
  
  public void ad(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_f_of_type_Myi != null) && (this.d != null) && (this.d.articleID == paramLong))
    {
      this.d.b.setKeepScreenOn(false);
      a(this.d, this.jdField_f_of_type_Myi, 0, null);
      this.d.c.playDuration = this.jdField_f_of_type_Myi.c(false);
      this.d.xb = cZ();
      if ((this.d.c.playDuration == 0L) && (this.d.c.vt == 0L) && (this.d.c.vs != 0L)) {
        this.d.c.vt = (SystemClock.uptimeMillis() - this.d.c.vs);
      }
      this.d.c.jB = ((float)this.d.c.playDuration / this.d.videoDuration);
      this.d.c.success = true;
      this.d.c.vD = this.jdField_f_of_type_Myi.dd();
      this.d.c.secondBufferCount = this.jdField_f_of_type_Myi.qf();
      this.d.c.videoFormat = this.jdField_f_of_type_Myi.qg();
      this.d.c.amD = this.jdField_f_of_type_Myi.aqr;
      this.d.c.mFileSize = this.jdField_f_of_type_Myi.mFileSize;
      this.d.c.vF = this.jdField_f_of_type_Myi.vF;
      this.d.c.vG = this.jdField_f_of_type_Myi.df();
      this.d.c.vH = this.jdField_f_of_type_Myi.qh();
      this.d.c.ahx = this.jdField_f_of_type_Myi.ky();
      this.d.c.vJ = this.jdField_f_of_type_Myi.dh();
      this.d.c.vK = this.jdField_f_of_type_Myi.dg();
      if ((this.d.c.playDuration == 0L) && (this.d.c.vt == 0L))
      {
        this.d.c.vt = (SystemClock.uptimeMillis() - this.d.c.vs);
        this.d.c.vv = this.d.c.vt;
      }
      this.d.c.aSq = getVideoWidth();
      this.d.c.aSr = getVideoHeight();
      if (this.e != null)
      {
        localmhu = this.d.c;
        paramInt = this.e.position;
        i = this.d.position;
        if (this.d.IH == 3)
        {
          bool = true;
          localmhu.aSw = kxm.b(paramInt, i, bool);
          this.d.c.IH = this.d.IH;
          this.jdField_f_of_type_Myi.destory();
          c(this.d);
          kxm.a(this.mActivity.getApplicationContext(), kxm.getAccount(), true, this.d.c.u());
          kbx.a(this.d.c);
          kxm.a(true, this.d.c.aiJ, this.d.c.videoFormat, this.d.c.busiType, this.d.c.vt, 56, this.d.c.errCode, this.d.c.rowkey);
          if ((this.d.xb > 0L) && (this.d.c.playDuration > 0L)) {
            ThreadManager.post(new VideoPlayManager.4(this, this.d, this.jdField_b_of_type_Myp), 5, null, true);
          }
          this.aqm = false;
          this.e = this.d;
          this.d = null;
          this.jdField_f_of_type_Myi = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        mhu localmhu;
        int i;
        return;
        boolean bool = false;
        continue;
        this.d.c.aSw = -1;
      }
    }
    QLog.w("Q.readinjoy.video", 2, "stop : current player is null or articleID is not equal!");
  }
  
  public myi b(String paramString)
  {
    paramString = (WeakReference)this.ez.get(paramString);
    if (paramString != null) {
      return (myi)paramString.get();
    }
    return null;
  }
  
  public void b(mye.a parama)
  {
    if ((parama != null) && (this.r != null)) {
      this.r.remove(parama);
    }
  }
  
  public void b(mza parammza)
  {
    this.jdField_a_of_type_Mza = parammza;
    this.jdField_a_of_type_Mza.a(this);
  }
  
  public mye.b c()
  {
    return this.d;
  }
  
  public long cZ()
  {
    if (this.jdField_f_of_type_Myi != null) {
      return this.jdField_f_of_type_Myi.dc();
    }
    return 0L;
  }
  
  public long da()
  {
    if (this.d == null) {
      return -1L;
    }
    return this.d.articleID;
  }
  
  public long db()
  {
    if (this.d == null) {
      return 0L;
    }
    return this.d.channelId;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    stop(7);
    if (this.jdField_f_of_type_Myi != null)
    {
      this.jdField_f_of_type_Myi.destory();
      this.jdField_f_of_type_Myi = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    this.jdField_a_of_type_Myj.destroy();
    this.jdField_a_of_type_Myj = null;
    try
    {
      this.mActivity = null;
      mzj.a().c(this);
      Iterator localIterator = this.ez.values().iterator();
      while (localIterator.hasNext())
      {
        myi localmyi = (myi)((WeakReference)localIterator.next()).get();
        if ((localmyi != null) && (!localmyi.isRelease))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localmyi.toString() + " not release");
          }
          localmyi.destory();
        }
      }
      this.ez.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Mza != null)
    {
      this.jdField_a_of_type_Mza.destory();
      this.jdField_a_of_type_Mza = null;
    }
    this.r.clear();
    this.r = null;
    this.aqm = false;
  }
  
  public void fK(boolean paramBoolean)
  {
    if (isPause())
    {
      if (!mzj.av(this.mActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
      }
    }
    return;
    label33:
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.aqm);
    }
    this.jdField_f_of_type_Myi.restart();
    this.aps = true;
    this.aqm = false;
    a(this.d, this.jdField_f_of_type_Myi, 3, null);
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public int getVideoHeight()
  {
    if (this.jdField_f_of_type_Myi != null) {
      return this.jdField_f_of_type_Myi.getVideoHeight();
    }
    return -1;
  }
  
  public int getVideoWidth()
  {
    if (this.jdField_f_of_type_Myi != null) {
      return this.jdField_f_of_type_Myi.getVideoWidth();
    }
    return -1;
  }
  
  public boolean isFullScreen()
  {
    if (this.jdField_a_of_type_Mza != null) {
      return this.jdField_a_of_type_Mza.EV();
    }
    return false;
  }
  
  public boolean isMute()
  {
    return (this.jdField_f_of_type_Myi != null) && (this.jdField_f_of_type_Myi.isMuted());
  }
  
  public boolean isPause()
  {
    if ((this.jdField_f_of_type_Myi == null) || (this.d == null)) {}
    do
    {
      return false;
      if (qc() == 5)
      {
        if ((!this.jdField_f_of_type_Myi.isPause()) && (QLog.isColorLevel())) {
          QLog.w(TAG, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_f_of_type_Myi.isPause()) || (!QLog.isColorLevel()));
    QLog.w(TAG, 2, "isPause(): return false. getCurPlayState is " + myh.bA(qc()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public boolean isPlaying()
  {
    return (this.jdField_f_of_type_Myi != null) && (this.jdField_f_of_type_Myi.isPlaying());
  }
  
  public boolean isReady()
  {
    return (this.jdField_f_of_type_Myi != null) && (qc() == 2);
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public String kx()
  {
    return this.akI;
  }
  
  public void nZ(String paramString)
  {
    this.akI = paramString;
  }
  
  public void ns(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "install tencent video sdk success!");
      }
      if (this.d != null) {
        a(this.d);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "install tencent video sdk fail!");
    }
    a(this.d, this.jdField_f_of_type_Myi, 6, "install failure");
    this.d = null;
  }
  
  public void oL(boolean paramBoolean)
  {
    this.aqn = paramBoolean;
  }
  
  public void oM(boolean paramBoolean)
  {
    this.aqm = paramBoolean;
  }
  
  public void pause()
  {
    pause(false);
  }
  
  public void pause(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_Myi != null) && (this.jdField_f_of_type_Myi.isPlaying()))
    {
      this.jdField_f_of_type_Myi.pause();
      this.aqm = paramBoolean;
      if (!aqiw.isWifiConnected(this.mActivity.getApplicationContext())) {
        this.jdField_f_of_type_Myi.stopDownload();
      }
      a(this.d, this.jdField_f_of_type_Myi, 5, Boolean.valueOf(this.aqm));
      this.d.xb = cZ();
      this.d.c.playDuration = this.jdField_f_of_type_Myi.c(false);
      BaseArticleInfo localBaseArticleInfo = this.d.d;
      if ((localBaseArticleInfo != null) && (knd.dh((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.d.aqp) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = jzk.aFB;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = jzk.aGs;
          i = jzk.aFx;
        }
        jzk.a(new kku.a().a(this.mActivity).a(jzk.aEO).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(jzk.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.d.xb, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.d.xb);
      }
    }
  }
  
  public int qc()
  {
    int i = 0;
    if (this.jdField_f_of_type_Myi != null) {
      i = this.jdField_f_of_type_Myi.qe();
    }
    if (i == this.mState.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + myh.bA(i) + ",mState.get()=" + myh.bA(this.mState.get()));
    }
    return this.mState.get();
  }
  
  public int qd()
  {
    return this.mXYaxis;
  }
  
  public void resume()
  {
    fK(false);
  }
  
  public void seekTo(int paramInt)
  {
    if (this.jdField_f_of_type_Myi != null) {
      this.jdField_f_of_type_Myi.seekTo(paramInt);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.d != null)
    {
      bool = paramBoolean;
      if (this.d.aqp) {
        bool = true;
      }
    }
    if (this.jdField_f_of_type_Myi != null) {
      this.jdField_f_of_type_Myi.setMute(bool);
    }
  }
  
  public void setXYaxis(int paramInt)
  {
    this.mXYaxis = paramInt;
    if (this.jdField_f_of_type_Myi != null) {
      this.jdField_f_of_type_Myi.setXYaxis(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void stop(int paramInt)
  {
    if ((this.d != null) && (this.jdField_f_of_type_Myi != null)) {
      ad(this.d.articleID, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_f_of_type_Myi != null)
      {
        a(this.d, this.jdField_f_of_type_Myi, 0, null);
        this.jdField_f_of_type_Myi.destory();
        this.jdField_f_of_type_Myi = null;
        this.d = null;
      }
      else if (this.d != null)
      {
        a(this.d, this.jdField_f_of_type_Myi, 0, null);
        this.jdField_f_of_type_Myi = null;
        this.d = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject);
  }
  
  public static class b
    extends mrr
  {
    public int IH;
    public nbr a;
    public int aDs;
    public int aKB;
    public int aKC;
    public int aVT = -1;
    public int aVU;
    public int aVV = 0;
    public String ahw;
    public String akK;
    public String akL;
    public String akM;
    public String akN;
    public long algorithmID = -1L;
    boolean aqo = false;
    public boolean aqp;
    public boolean aqq;
    public long articleID;
    public VideoViewGroup b;
    public int bottomLeftRadius;
    public int bottomRightRadius;
    public mhu c;
    public BaseArticleInfo d;
    public Map<String, Object> eA;
    public long fileSize;
    public View ma;
    public String puin;
    public int strategyId;
    public String thirdAction;
    public String thirdIcon;
    public String thirdName;
    public String thirdUin;
    public String thirdUinName;
    public int topLeftRadius;
    public int topRightRadius;
    public int videoDuration;
    public int videoHeight;
    public int videoWidth;
    public int viewHeight;
    public int viewWidth;
    public long xb;
    public long xc;
    
    public VideoInfo a()
    {
      return mrv.a(this.d);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof b)) {
        return getInnerUniqueID().equals(((b)paramObject).getInnerUniqueID());
      }
      return super.equals(paramObject);
    }
    
    public String getInnerUniqueID()
    {
      if (this.d != null) {
        return this.d.getInnerUniqueID();
      }
      return "";
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayParam[");
      localStringBuilder.append(" articleID:").append(this.articleID);
      localStringBuilder.append(", videoVid:").append(this.videoVid);
      localStringBuilder.append(", busitype:").append(this.aDs);
      localStringBuilder.append(", videoDuration:").append(this.videoDuration);
      localStringBuilder.append(", position:").append(this.position);
      if (this.d != null) {
        localStringBuilder.append(", title:").append(this.d.mTitle);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(mye.b paramb, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mye
 * JD-Core Version:    0.7.0.1
 */