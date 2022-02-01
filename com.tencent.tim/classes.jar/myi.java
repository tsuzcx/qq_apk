import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.util.VersionUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class myi
  implements nbl
{
  private final String TAG = "Q.readinjoy.video.VideoPlayerWrapper<" + Integer.toHexString(hashCode()) + ">";
  private mrs.b jdField_a_of_type_Mrs$b;
  private mrs jdField_a_of_type_Mrs = new mrs();
  private myi.a jdField_a_of_type_Myi$a;
  @Nullable
  private nbm jdField_a_of_type_Nbm;
  @NotNull
  private nbn jdField_a_of_type_Nbn;
  private int aVW = 0;
  private int aVX;
  public int aVY;
  public int aVZ = -1;
  private int agm;
  public String akP;
  private boolean app;
  public boolean aqr;
  private boolean aqs;
  private boolean aqt;
  @Nullable
  private nbr b;
  public long bz;
  public boolean isRelease;
  private boolean isSeeking;
  private volatile ArrayList<Integer> lw;
  protected Context mContext;
  public long mFileSize;
  private long mLastPlayPosition;
  private final Object mLock = new Object();
  private boolean mLoopback;
  private int mPlayType = 101;
  private AtomicInteger mState = new AtomicInteger(0);
  private long mVideoDuration;
  private Object tag;
  public long vF;
  private long vG = -1L;
  private long xd;
  private long xe;
  private long xf;
  
  public myi(Context paramContext)
  {
    this.mContext = paramContext;
    this.app = mzj.a().Fa();
    initMediaPlayer();
  }
  
  private boolean ET()
  {
    boolean bool = false;
    if (nbs.a.Fg()) {
      bool = this.mState.compareAndSet(0, 1);
    }
    while ((!this.mState.compareAndSet(0, 1)) && (!this.mState.compareAndSet(7, 1)) && (!this.mState.compareAndSet(6, 1))) {
      return bool;
    }
    return true;
  }
  
  private SuperPlayerOption a(boolean paramBoolean)
  {
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.isPrePlay = paramBoolean;
    if (this.jdField_a_of_type_Nbm != null) {
      localSuperPlayerOption.enableCodecReuse = this.jdField_a_of_type_Mrs.DZ();
    }
    return localSuperPlayerOption;
  }
  
  private nbr a()
  {
    if (this.mContext == null)
    {
      QLog.d(this.TAG, 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_Nbn.a(this.mContext, VersionUtils.isIceScreamSandwich());
  }
  
  private void a(nbt paramnbt)
  {
    if (paramnbt != null)
    {
      paramnbt.pk(this.aqs);
      paramnbt.pj(this.aqt);
      paramnbt.tj(awit.Qj());
    }
  }
  
  private void aTS()
  {
    synchronized (this.mLock)
    {
      this.lw = null;
      this.agm = 0;
      this.bz = 0L;
      this.mFileSize = 0L;
      this.vG = -1L;
      return;
    }
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStartByUrl vid = " + paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + "，mState:" + myh.bA(this.mState.get()));
    }
    if (!ET())
    {
      QLog.e(this.TAG, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString1 + "，mState:" + myh.bA(this.mState.get()));
      return;
    }
    if (paramBoolean2)
    {
      paramString2 = kxv.e(paramString2);
      r(paramString2);
    }
    for (;;)
    {
      paramString1 = new nbt(paramInt1, paramString1, paramString2);
      paramString1.pi(paramBoolean3);
      paramString1.setDuration(paramInt2);
      paramString1.pl(paramBoolean1);
      paramString1.od(paramString3);
      a(paramString1);
      if ((this.mContext != null) && (this.jdField_a_of_type_Nbm != null)) {
        this.jdField_a_of_type_Nbm.a(this.mContext, paramString1, paramLong1, a(paramBoolean3));
      }
      this.xd = 0L;
      this.mVideoDuration = 0L;
      this.mLastPlayPosition = paramLong1;
      this.mPlayType = paramInt1;
      return;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString2;
      r(arrayOfString);
      paramString2 = arrayOfString;
    }
  }
  
  private void initMediaPlayer()
  {
    this.jdField_a_of_type_Nbn = nbs.a.a();
    if (this.mContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "VideoPlayerWrapper initPlayer success!");
      }
      this.jdField_a_of_type_Nbm = this.jdField_a_of_type_Nbn.a(null);
      this.jdField_a_of_type_Nbm.a(this);
      setMute(this.app);
      setLoopback(this.mLoopback);
    }
  }
  
  public boolean ER()
  {
    return this.mState.get() == 1;
  }
  
  public boolean ES()
  {
    return (this.mState.get() != 0) && (this.mState.get() != 8) && (this.mState.get() != 6) && (this.mState.get() != 7);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStart vid = " + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "#VideoPlayerWrapper# playerStart, vid:" + paramString + ", playType:" + paramInt + ", startPosition:" + paramLong + "，mState:" + myh.bA(this.mState.get()));
    }
    if (!ET())
    {
      QLog.e(this.TAG, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString + "，mState:" + myh.bA(this.mState.get()));
      return;
    }
    paramString = new nbt(paramInt, paramString);
    paramString.pi(paramBoolean);
    paramString.setPlayMode("cache_video");
    a(paramString);
    if ((this.mContext != null) && (this.jdField_a_of_type_Nbm != null)) {
      this.jdField_a_of_type_Nbm.a(this.mContext, paramString, paramLong, a(paramBoolean));
    }
    this.xd = 0L;
    this.mVideoDuration = 0L;
    this.mLastPlayPosition = paramLong;
    this.mPlayType = paramInt;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, true, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  public void a(myi.a parama)
  {
    this.jdField_a_of_type_Myi$a = parama;
  }
  
  public void a(@NotNull nbm paramnbm)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[IPlayer] onVideoPrepared(): stremDumpInfo=" + paramnbm.getStreamDumpInfo());
    }
    this.mState.set(2);
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.a(this, this.tag);
    }
    if (this.jdField_a_of_type_Nbm != null) {
      this.mVideoDuration = this.jdField_a_of_type_Nbm.getDurationMs();
    }
    if ((this.mFileSize > 0L) && (this.mVideoDuration > 0L)) {
      this.aVY = ((int)(this.mFileSize / 1024L * 8L / (this.mVideoDuration / 1000L)));
    }
    ThreadManager.post(new VideoPlayerWrapper.1(this, paramnbm), 5, null, false);
  }
  
  public void a(@NotNull nbm paramnbm, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(@NotNull nbm paramnbm, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(nbr paramnbr)
  {
    if (this.jdField_a_of_type_Nbm == null) {
      return;
    }
    this.b = paramnbr;
    this.jdField_a_of_type_Nbm.b(this.b);
    this.jdField_a_of_type_Nbm.setXYaxis(this.aVW);
  }
  
  public boolean a(@NotNull nbm paramnbm, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "VideoPlayerWrapper onError!");
    }
    this.mState.set(6);
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(@NotNull nbm paramnbm, int paramInt, @Nullable Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Myi$a != null) {
        this.jdField_a_of_type_Myi$a.a(this, paramInt, paramObject);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.isSeeking);
      }
      if (this.mState.get() != 5) {
        this.mState.set(4);
      }
      this.xe = System.currentTimeMillis();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.isSeeking);
      }
      if (this.mState.get() != 5) {
        this.mState.set(3);
      }
      if (!this.isSeeking)
      {
        this.aVX += 1;
        this.xf += System.currentTimeMillis() - this.xe;
        continue;
        if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
        {
          paramnbm = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
          this.jdField_a_of_type_Mrs.a(paramnbm);
        }
        asfe.au(new VideoPlayerWrapper.2(this));
        continue;
        if (this.jdField_a_of_type_Myi$a != null) {
          this.jdField_a_of_type_Myi$a.a(this, "");
        }
      }
    }
  }
  
  public void aTP()
  {
    if (this.b != null) {
      this.b.doCacheSurfaceTexture();
    }
  }
  
  public void aTQ()
  {
    if (this.b != null) {
      this.b.doRecoverSurfaceTexture();
    }
  }
  
  public void aTR()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.aTR();
    }
  }
  
  public void aTT()
  {
    this.xd = 0L;
    this.mLastPlayPosition = 0L;
  }
  
  public void aTU()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resetVariables: ");
    }
    this.mPlayType = 101;
    this.isRelease = false;
    this.isSeeking = false;
    this.mVideoDuration = 0L;
    this.xd = 0L;
    this.mLastPlayPosition = 0L;
    this.xe = 0L;
    this.xf = 0L;
    this.aVX = 0;
    this.vF = 0L;
    this.aVY = 0;
    this.vG = -1L;
    this.aqr = false;
    this.aVZ = -1;
    aTS();
  }
  
  public View al()
  {
    if (this.b == null) {}
    try
    {
      if (this.b == null) {
        this.b = a();
      }
      if (this.b == null) {
        return null;
      }
    }
    finally {}
    View localView = this.b.am();
    if ((localView != null) && (localView.getParent() != null))
    {
      ViewParent localViewParent = localView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(localView);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "remove scroll view parents!");
      }
    }
    return localView;
  }
  
  public nbr b()
  {
    return this.b;
  }
  
  public void b(@NotNull nbm paramnbm)
  {
    this.mState.set(7);
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.a(this);
    }
  }
  
  public long c(boolean paramBoolean)
  {
    long l2 = this.xd;
    if (paramBoolean) {}
    for (long l1 = getDuration(); l1 - this.mLastPlayPosition > 0L; l1 = dc()) {
      return l1 - this.mLastPlayPosition + l2;
    }
    return l2;
  }
  
  public void c(@NotNull nbm paramnbm)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "VideoPlayerWrapper: onSeekComplete， isPause=" + isPause());
    }
    if (this.jdField_a_of_type_Myi$a != null) {
      this.jdField_a_of_type_Myi$a.b(this);
    }
    this.isSeeking = false;
  }
  
  public long d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getDuration();
    }
    return dc();
  }
  
  public long dc()
  {
    if (this.jdField_a_of_type_Nbm == null) {
      return 0L;
    }
    return this.jdField_a_of_type_Nbm.getCurrentPositionMs();
  }
  
  public long dd()
  {
    return this.xf;
  }
  
  public long de()
  {
    return this.mLastPlayPosition;
  }
  
  public void destory()
  {
    oO(true);
  }
  
  public long df()
  {
    if (this.vG == -1L) {}
    synchronized (this.mLock)
    {
      if ((this.lw != null) && (this.lw.size() > 0))
      {
        int k = Math.min(10, this.lw.size());
        int i = 0;
        int j = 0;
        while (i < k)
        {
          j += ((Integer)this.lw.get(i)).intValue();
          i += 1;
        }
        if (k != 0) {
          this.vG = (j / k);
        }
      }
      return this.vG;
    }
  }
  
  public long dg()
  {
    long l2 = -1L;
    Object localObject1 = this.mLock;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int i;
      try
      {
        if (this.lw != null)
        {
          l1 = l2;
          if (this.lw.size() > 0)
          {
            int j = this.lw.size();
            i = 0;
            l1 = -1L;
            if (i >= j) {
              break label118;
            }
            int k = ((Integer)this.lw.get(i)).intValue();
            if (i == 0)
            {
              l1 = k;
              break label111;
            }
            l1 = Math.min(k, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      i += 1;
    }
  }
  
  public long dh()
  {
    long l2 = -1L;
    Object localObject1 = this.mLock;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int i;
      try
      {
        if (this.lw != null)
        {
          l1 = l2;
          if (this.lw.size() > 0)
          {
            int j = this.lw.size();
            i = 0;
            l1 = -1L;
            if (i >= j) {
              break label118;
            }
            int k = ((Integer)this.lw.get(i)).intValue();
            if (i == 0)
            {
              l1 = k;
              break label111;
            }
            l1 = Math.max(k, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      i += 1;
    }
  }
  
  public void e(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public long getDuration()
  {
    if (this.mVideoDuration != 0L) {
      return this.mVideoDuration;
    }
    if (this.jdField_a_of_type_Nbm != null) {
      return this.jdField_a_of_type_Nbm.getDurationMs();
    }
    return -1L;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public Properties getPlayDetailsTime()
  {
    return new Properties();
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public int getVideoHeight()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      return this.jdField_a_of_type_Nbm.getVideoHeight();
    }
    return -1;
  }
  
  public View getVideoView()
  {
    if (this.b != null) {
      return this.b.am();
    }
    return null;
  }
  
  public int getVideoWidth()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      return this.jdField_a_of_type_Nbm.getVideoWidth();
    }
    return -1;
  }
  
  public boolean isBuffering()
  {
    return this.mState.get() == 4;
  }
  
  public boolean isCompleted()
  {
    return this.mState.get() == 7;
  }
  
  public boolean isDestroyed()
  {
    return this.mState.get() == 8;
  }
  
  public boolean isIdle()
  {
    return this.mState.get() == 0;
  }
  
  public boolean isLoopback()
  {
    return this.mLoopback;
  }
  
  public boolean isMuted()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      return this.jdField_a_of_type_Nbm.getOutputMute();
    }
    return this.app;
  }
  
  public boolean isPause()
  {
    return this.mState.get() == 5;
  }
  
  public boolean isPlaying()
  {
    return (this.mState.get() == 3) || (this.mState.get() == 4);
  }
  
  public boolean isPrepared()
  {
    return this.mState.get() == 2;
  }
  
  public boolean isReady()
  {
    return this.mState.get() == 2;
  }
  
  public boolean isReusable()
  {
    boolean bool = false;
    int i = this.mState.get();
    if (nbs.a.Fg()) {
      return i == 0;
    }
    if ((i == 7) || (i == 0) || (i == 6)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSeeking()
  {
    return this.isSeeking;
  }
  
  public String ky()
  {
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        if ((this.lw != null) && (this.lw.size() > 0))
        {
          Object localObject2 = new StringBuilder();
          int j = this.lw.size();
          i = 0;
          if (i < j)
          {
            ((StringBuilder)localObject2).append(((Integer)this.lw.get(i)).intValue());
            if (i != j - 1) {
              ((StringBuilder)localObject2).append(",");
            }
          }
          else
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            return localObject2;
          }
        }
        else
        {
          return "";
        }
      }
      i += 1;
    }
  }
  
  public String kz()
  {
    return this.akP;
  }
  
  public void oN(boolean paramBoolean)
  {
    this.aqs = paramBoolean;
  }
  
  public void oO(boolean paramBoolean)
  {
    if (this.mState.get() == 8) {}
    for (;;)
    {
      return;
      this.mState.set(8);
      if (this.jdField_a_of_type_Nbm != null) {
        ThreadManager.executeOnSubThread(new VideoPlayerWrapper.3(this, this.jdField_a_of_type_Nbm));
      }
      if ((paramBoolean) && (this.b != null) && (this.b.am() != null))
      {
        ??? = this.b.am().getParent();
        if ((??? instanceof ViewGroup)) {
          ((ViewGroup)???).removeView(this.b.am());
        }
      }
      this.jdField_a_of_type_Myi$a = null;
      this.b = null;
      this.mContext = null;
      this.isRelease = true;
      synchronized (this.mLock)
      {
        this.lw = null;
        this.vG = 0L;
        this.bz = 0L;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.TAG, 2, "VideoPlayerWrapper: destory ");
        return;
      }
    }
  }
  
  public void oP(boolean paramBoolean)
  {
    this.aqt = paramBoolean;
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_Nbm != null)
    {
      if (!ES()) {
        QLog.e(this.TAG, 1, "VideoPlayerWrapper: pause failed, wrong state:" + myh.bA(this.mState.get()) + ", just return;");
      }
    }
    else {
      return;
    }
    this.mState.set(5);
    this.jdField_a_of_type_Nbm.pause();
  }
  
  public int qe()
  {
    return this.mState.get();
  }
  
  public int qf()
  {
    return this.aVX;
  }
  
  public int qg()
  {
    if ((this.mPlayType == 104) || (this.mPlayType == 102)) {
      return 1;
    }
    return 0;
  }
  
  public int qh()
  {
    if ((this.jdField_a_of_type_Nbm != null) && (this.mFileSize != 0L)) {
      return Math.round((float)this.bz / (float)this.mFileSize * (float)getDuration() / 1000.0F);
    }
    return 0;
  }
  
  public void r(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (i != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[i]);
        i += 1;
      }
    }
    this.akP = localStringBuilder.toString();
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Nbm == null) {
      return;
    }
    if (this.mState.get() == 8)
    {
      QLog.e(this.TAG, 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
      return;
    }
    this.mState.set(8);
    this.jdField_a_of_type_Nbm.release();
  }
  
  public void restart()
  {
    start();
  }
  
  public void resumeDownload()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.resumeDownload();
    }
  }
  
  public void seekTo(int paramInt)
  {
    ViolaLogUtils.d(this.TAG, "test seekTo aaa" + paramInt + ",state:" + this.mState.get());
    if ((this.jdField_a_of_type_Nbm != null) && (this.mState.get() != 0) && (this.mState.get() != 2) && (this.mState.get() != 1) && (this.mState.get() != 4) && (this.mState.get() != 8))
    {
      long l1 = dc();
      if (l1 - this.mLastPlayPosition > 0L)
      {
        long l2 = this.xd;
        this.xd = (l1 - this.mLastPlayPosition + l2);
      }
      this.mLastPlayPosition = paramInt;
      this.jdField_a_of_type_Nbm.seekTo(paramInt, 1);
      this.isSeeking = true;
    }
  }
  
  public void setHttpBufferRange(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Nbm != null) && (paramInt1 > 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_Nbm.S(paramInt1, paramInt2, awit.Qj());
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.mLoopback = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.excute(new VideoPlayerWrapper.4(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_Nbm == null) || (this.mState.get() == 6) || (this.mState.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_Nbm.setLoopback(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.app = paramBoolean;
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.setOutputMute(paramBoolean);
    }
  }
  
  public void setSpeedRatio(float paramFloat)
  {
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.setSpeedRatio(paramFloat);
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void setXYaxis(int paramInt)
  {
    this.aVW = paramInt;
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.setXYaxis(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "VideoPlayerWrapper: setXYaxis value:" + paramInt);
    }
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_Nbm == null) {}
    do
    {
      return;
      if (!ES())
      {
        QLog.e(this.TAG, 1, "VideoPlayerWrapper: start failed, wrong state:" + myh.bA(this.mState.get()) + ", just return;");
        return;
      }
      this.mState.set(3);
      this.jdField_a_of_type_Nbm.start();
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "VideoPlayerWrapper: start");
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_Nbm == null) {}
    do
    {
      return;
      if (this.mState.get() == 8)
      {
        QLog.e(this.TAG, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
        return;
      }
      this.mState.set(0);
      this.jdField_a_of_type_Nbm.stop();
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "VideoPlayerWrapper: stop ");
  }
  
  public void stopDownload()
  {
    if (this.jdField_a_of_type_Nbm != null) {
      this.jdField_a_of_type_Nbm.pauseDownload();
    }
  }
  
  public void t(ViewGroup paramViewGroup)
  {
    al();
    if ((paramViewGroup != null) && (this.b != null) && (this.b.am() != null)) {
      paramViewGroup.addView(this.b.am(), new ViewGroup.LayoutParams(-1, -1));
    }
    a(this.b);
  }
  
  public static abstract interface a
  {
    public abstract void a(myi parammyi);
    
    public abstract void a(myi parammyi, Object paramObject);
    
    public abstract void a(myi parammyi, String paramString);
    
    public abstract void a(myi parammyi, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap);
    
    public abstract boolean a(myi parammyi, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
    
    public abstract boolean a(myi parammyi, int paramInt, Object paramObject);
    
    public abstract void b(myi parammyi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myi
 * JD-Core Version:    0.7.0.1
 */