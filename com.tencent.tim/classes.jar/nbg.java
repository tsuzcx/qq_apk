import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.2;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class nbg
  implements myj.a
{
  private final String TAG = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private myj jdField_a_of_type_Myj;
  private nbg.a jdField_a_of_type_Nbg$a = new nbg.a(null);
  @Nullable
  private nbg.b jdField_a_of_type_Nbg$b;
  private nbg.c jdField_a_of_type_Nbg$c = new nbg.c(this);
  @NonNull
  private ViewGroup aB;
  private int aVk;
  private int aXf = 100;
  private boolean anW = true;
  private boolean apk;
  private boolean apl;
  private boolean apr;
  private boolean aps;
  private boolean apt;
  private boolean aqY;
  private boolean aqZ;
  @NonNull
  private myi h;
  private List<nbh> jL;
  private List<nbf> jM;
  @NonNull
  private Context mContext;
  
  @UiThread
  public nbg(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Myj = new myj();
    this.jdField_a_of_type_Myj.a(this);
    this.jL = new ArrayList();
    this.aB = new FrameLayout(this.mContext);
    this.h = b(null);
    this.jM = new ArrayList();
    boolean bool = this.jdField_a_of_type_Myj.EU();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "LitePlayer: isPluginInstalled=" + bool);
    }
    if (!bool) {
      this.jdField_a_of_type_Myj.installPlugin();
    }
  }
  
  private void a(nbg.b paramb)
  {
    if (TextUtils.isEmpty(paramb.url))
    {
      f(paramb.vid, paramb.aXh, paramb.startPosition);
      return;
    }
    a(paramb.vid, paramb.url, paramb.aXh, paramb.startPosition, paramb.duration);
  }
  
  private boolean aS(long paramLong)
  {
    if ((this.jdField_a_of_type_Nbg$b != null) && (this.aqY) && (this.h.getTag() == this.jdField_a_of_type_Nbg$b))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkPreload: status=" + this.h.qe());
      }
      this.jdField_a_of_type_Nbg$b.startPosition = paramLong;
      Iterator localIterator;
      if ((isReady()) || (isPause()) || (isBuffering()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jM.iterator();
        while (localIterator.hasNext()) {
          ((nbf)localIterator.next()).pg(true);
        }
        this.h.resumeDownload();
        aVn();
        return true;
      }
      if ((isIdle()) || (ER()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "checkPreload: prePlaying, just do nothing ");
        }
        localIterator = this.jM.iterator();
        while (localIterator.hasNext()) {
          ((nbf)localIterator.next()).pg(false);
        }
        this.aqY = false;
        this.h.resumeDownload();
        this.aps = true;
        this.jdField_a_of_type_Nbg$c.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.aqY = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void aVm()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkPlayer: tag=" + this.h.getTag());
    }
    if ((this.h.getTag() != null) || (!this.h.isReusable()))
    {
      c(this.h);
      this.h = b(null);
    }
  }
  
  private void aVn()
  {
    this.aqY = false;
    this.jdField_a_of_type_Nbg$c.removeMessages(1);
    if (this.anW)
    {
      start();
      if ((this.jdField_a_of_type_Nbg$b != null) && (this.jdField_a_of_type_Nbg$b.startPosition / 1000L != this.h.dc() / 1000L)) {
        seekTo((int)(this.jdField_a_of_type_Nbg$b.startPosition / 1000L));
      }
      return;
    }
    this.apt = true;
  }
  
  private void aVo()
  {
    Object localObject = this.h;
    if (((myi)localObject).isPlaying())
    {
      long l = ((myi)localObject).dc();
      if (l >= ((myi)localObject).getDuration() - 500L) {
        this.apl = true;
      }
      for (;;)
      {
        localObject = this.jL.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((nbh)((Iterator)localObject).next()).onProgressChanged(l);
        }
        if ((l >= 0L) && (this.apl) && (((myi)localObject).isLoopback()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onVideoReplayOnLoop: pos=" + l);
          }
          this.apl = false;
          this.aVk += 1;
          ((myi)localObject).aTT();
          if (this.jL != null)
          {
            localObject = this.jL.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((nbh)((Iterator)localObject).next()).sj(this.aVk);
            }
          }
        }
      }
    }
  }
  
  @UiThread
  private myi b(myi parammyi)
  {
    myi localmyi = parammyi;
    if (parammyi == null)
    {
      localmyi = new myi(this.mContext.getApplicationContext());
      localmyi.setMute(false);
    }
    localmyi.a(this.jdField_a_of_type_Nbg$a);
    this.aB.removeAllViews();
    localmyi.t(this.aB);
    parammyi = localmyi.getVideoView();
    if (parammyi != null)
    {
      parammyi.setId(2131376720);
      this.aB.setKeepScreenOn(true);
    }
    return localmyi;
  }
  
  private void bK(String paramString1, String paramString2)
  {
    this.h.setTag(this.jdField_a_of_type_Nbg$b);
    Iterator localIterator = this.jM.iterator();
    while (localIterator.hasNext()) {
      ((nbf)localIterator.next()).a(paramString1, paramString2, this.aqY, this.aqZ);
    }
    this.aps = true;
    this.aVk = 0;
    this.jdField_a_of_type_Nbg$c.removeMessages(1);
  }
  
  private void c(myi parammyi)
  {
    if (parammyi == null) {}
    do
    {
      return;
      parammyi.aTU();
    } while ((parammyi.isReusable()) || (parammyi.isDestroyed()));
    parammyi.stopDownload();
    ThreadManager.excute(new LitePlayer.3(this, parammyi), 16, null, true);
  }
  
  static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public boolean ER()
  {
    return this.h.ER();
  }
  
  public boolean Fe()
  {
    return (this.jdField_a_of_type_Nbg$b != null) && ((ER()) || (isReady()) || (isPause()) || (isPlaying()) || (isBuffering()));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    runOnUiThread(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(nbf paramnbf)
  {
    this.jM.add(paramnbf);
  }
  
  public void a(nbh paramnbh)
  {
    this.jL.add(paramnbh);
  }
  
  public void aTP()
  {
    this.h.aTP();
  }
  
  public void aTQ()
  {
    this.h.aTQ();
  }
  
  public void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a("", paramString, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "openByUrl: url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_Nbg$a.a(null, 101, 61, 0, "url null", null);
    }
    if (aS(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Nbg$b = new nbg.b(paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Myj.EU())
    {
      this.jdField_a_of_type_Myj.installPlugin();
      return;
    }
    aVm();
    bK(paramString1, paramString2);
    this.h.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean, true, this.aqY, paramString3);
  }
  
  public void f(String paramString, int paramInt, long paramLong)
  {
    runOnUiThread(new LitePlayer.1(this, paramString, paramInt, paramLong));
  }
  
  public void g(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "openByVid: vid=" + paramString + ", playType=" + paramInt + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Nbg$a.a(null, 101, 61, 0, "vid null", null);
    }
    if (aS(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Nbg$b = new nbg.b(paramString, null, paramInt, paramLong, 0);
    if (!this.jdField_a_of_type_Myj.EU())
    {
      this.jdField_a_of_type_Myj.installPlugin();
      return;
    }
    aVm();
    bK(paramString, null);
    this.h.a(paramString, paramInt, paramLong, this.aqY);
  }
  
  public void g(myi parammyi)
  {
    if (parammyi != null) {
      c(parammyi);
    }
  }
  
  public long getCurrentPosition()
  {
    return this.h.dc();
  }
  
  public int getCurrentState()
  {
    return this.h.qe();
  }
  
  public long getDuration()
  {
    return this.h.getDuration();
  }
  
  public int getVideoHeight()
  {
    return this.h.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.h.getVideoWidth();
  }
  
  public boolean isBuffering()
  {
    return this.h.isBuffering();
  }
  
  public boolean isIdle()
  {
    return this.h.isIdle();
  }
  
  public boolean isPause()
  {
    return this.h.isPause();
  }
  
  public boolean isPlaying()
  {
    return this.h.isPlaying();
  }
  
  public boolean isPreload()
  {
    return this.aqY;
  }
  
  public boolean isReady()
  {
    return this.h.isReady();
  }
  
  public void j(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Nbg$a.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public void ns(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onInstallComplete: success=" + paramBoolean + ", mHasDestory=" + this.apk);
    }
    if (paramBoolean) {
      if (!this.apk) {}
    }
    for (;;)
    {
      return;
      this.h = b(this.h);
      if (this.jdField_a_of_type_Nbg$b != null)
      {
        a(this.jdField_a_of_type_Nbg$b);
        return;
        Iterator localIterator = this.jL.iterator();
        while (localIterator.hasNext()) {
          ((nbh)localIterator.next()).k(123, 99, null);
        }
      }
    }
  }
  
  public void oP(boolean paramBoolean)
  {
    this.h.oP(paramBoolean);
  }
  
  public void onDestroy()
  {
    this.apk = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnDestory: ");
    }
    this.apk = true;
    stop();
    this.h.destory();
    if (this.jdField_a_of_type_Myj != null) {
      this.jdField_a_of_type_Myj.destroy();
    }
    this.jdField_a_of_type_Nbg$c.removeCallbacksAndMessages(null);
    this.jL.clear();
  }
  
  public void onPause()
  {
    this.anW = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnPause() isPlaying()=" + isPlaying());
    }
    if ((isPlaying()) || (isBuffering()))
    {
      this.apr = true;
      this.aps = false;
      pause();
    }
  }
  
  public void onResume()
  {
    this.anW = true;
    if ((this.apt) && (isReady())) {
      aVn();
    }
    label79:
    for (;;)
    {
      this.apr = false;
      this.apt = false;
      return;
      if (this.apr)
      {
        AppRuntime localAppRuntime = kxm.getAppRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).bF();; bool = false)
        {
          if (bool) {
            break label79;
          }
          this.aps = true;
          restart();
          break;
        }
      }
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "pause: status=" + getCurrentState());
    }
    if ((isPlaying()) || (isBuffering()))
    {
      this.h.pause();
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((nbh)localIterator.next()).HO();
      }
    }
  }
  
  public void ph(boolean paramBoolean)
  {
    this.aqY = true;
    this.aqZ = paramBoolean;
    this.h.oN(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public void restart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "restart: status=" + getCurrentState());
    }
    if ((isPause()) || (isReady()))
    {
      this.h.restart();
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((nbh)localIterator.next()).aRq();
      }
    }
  }
  
  public void seekTo(int paramInt)
  {
    this.h.seekTo(paramInt);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.h.setLoopback(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.h.setMute(paramBoolean);
  }
  
  public void setSpeedRatio(float paramFloat)
  {
    this.h.setSpeedRatio(paramFloat);
  }
  
  public void setXYaxis(int paramInt)
  {
    this.h.setXYaxis(paramInt);
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "start: status=" + getCurrentState());
    }
    this.h.start();
    this.jdField_a_of_type_Nbg$c.removeMessages(0);
    this.jdField_a_of_type_Nbg$c.sendEmptyMessage(0);
    Iterator localIterator = this.jL.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).HN();
    }
    localIterator = this.jM.iterator();
    while (localIterator.hasNext()) {
      ((nbf)localIterator.next()).e(this.h);
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "stop: ");
    }
    Iterator localIterator = this.jL.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).onVideoStop();
    }
    localIterator = this.jM.iterator();
    while (localIterator.hasNext()) {
      ((nbf)localIterator.next()).a(this.h, this.aVk);
    }
    c(this.h);
    this.aqY = false;
    this.jdField_a_of_type_Nbg$b = null;
    this.aVk = 0;
    this.aB.setKeepScreenOn(false);
    this.jdField_a_of_type_Nbg$c.removeMessages(0);
  }
  
  public void ti(int paramInt)
  {
    this.aXf = paramInt;
  }
  
  public void u(ViewGroup paramViewGroup)
  {
    aTP();
    if ((this.aB.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.aB.getParent()).removeView(this.aB);
    }
    aTQ();
    paramViewGroup.addView(this.aB, -1, -1);
  }
  
  class a
    extends msc
  {
    private a() {}
    
    private void aVp()
    {
      if (QLog.isColorLevel()) {
        QLog.d(nbg.a(nbg.this), 2, "onPreloadFinished()");
      }
      nbg.a(nbg.this).stopDownload();
      Iterator localIterator = nbg.a(nbg.this).iterator();
      while (localIterator.hasNext()) {
        ((nbh)localIterator.next()).aRt();
      }
    }
    
    public void a(myi parammyi)
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = nbg.a(nbg.this);
        localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
        if (nbg.a(nbg.this) == null) {
          break label111;
        }
      }
      label111:
      for (parammyi = nbg.a(nbg.this).vid;; parammyi = "param null")
      {
        QLog.d(str, 2, parammyi);
        nbg.a(nbg.this).setTag(null);
        parammyi = nbg.a(nbg.this).iterator();
        while (parammyi.hasNext()) {
          ((nbh)parammyi.next()).onCompletion();
        }
      }
      parammyi = nbg.b(nbg.this).iterator();
      while (parammyi.hasNext()) {
        ((nbf)parammyi.next()).onCompletion();
      }
    }
    
    public void a(myi parammyi, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nbg.a(nbg.this), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
      }
      if ((nbg.a(nbg.this) != null) && (QLog.isColorLevel())) {
        QLog.d(nbg.a(nbg.this), 2, "播放状态回调 onVideoPrepared() vid=" + nbg.a(nbg.this).vid + ", mIsOpenedVideo = " + nbg.b(nbg.this) + ", preload=" + nbg.a(nbg.this) + ", mActivityOnResume=" + nbg.c(nbg.this));
      }
      if (nbg.a(nbg.this)) {
        aVp();
      }
      do
      {
        return;
        if (nbg.b(nbg.this)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(nbg.a(nbg.this), 2, "onVideoPrepared  return isOpenedVideo false");
      return;
      nbg.b(nbg.this, false);
      nbg.a(nbg.this).removeMessages(0);
      nbg.a(nbg.this).sendEmptyMessage(0);
      parammyi = nbg.a(nbg.this).iterator();
      while (parammyi.hasNext()) {
        ((nbh)parammyi.next()).aRp();
      }
      parammyi = nbg.b(nbg.this).iterator();
      while (parammyi.hasNext()) {
        ((nbf)parammyi.next()).f(nbg.a(nbg.this));
      }
      nbg.b(nbg.this);
    }
    
    public void a(myi parammyi, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nbg.a(nbg.this), 2, "onConnectQualityCallback json= " + paramString);
      }
      if (nbg.a(nbg.this) != null) {
        mzz.a().a(parammyi, nbg.a(nbg.this).duration, parammyi.getFileSize());
      }
      parammyi = nbg.b(nbg.this).iterator();
      while (parammyi.hasNext()) {
        ((nbf)parammyi.next()).oc(paramString);
      }
    }
    
    /* Error */
    public boolean a(myi parammyi, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
    {
      // Byte code:
      //   0: new 70	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   7: ldc 181
      //   9: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   12: iload_2
      //   13: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   16: ldc 186
      //   18: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: iload_3
      //   22: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   25: ldc 188
      //   27: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: iload 4
      //   32: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   35: ldc 190
      //   37: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: aload 5
      //   42: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: ldc 192
      //   47: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: astore 5
      //   52: aload 6
      //   54: ifnull +181 -> 235
      //   57: aload 6
      //   59: invokevirtual 195	java/lang/Object:toString	()Ljava/lang/String;
      //   62: astore_1
      //   63: aload 5
      //   65: aload_1
      //   66: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   72: astore_1
      //   73: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   76: ifeq +71 -> 147
      //   79: aload_0
      //   80: getfield 13	nbg$a:this$0	Lnbg;
      //   83: invokestatic 30	nbg:a	(Lnbg;)Ljava/lang/String;
      //   86: astore 5
      //   88: new 70	java/lang/StringBuilder
      //   91: dup
      //   92: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   95: ldc 197
      //   97: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: aload_1
      //   101: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: ldc 199
      //   106: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: astore 6
      //   111: aload_0
      //   112: getfield 13	nbg$a:this$0	Lnbg;
      //   115: invokestatic 80	nbg:a	(Lnbg;)Lnbg$b;
      //   118: ifnull +123 -> 241
      //   121: aload_0
      //   122: getfield 13	nbg$a:this$0	Lnbg;
      //   125: invokestatic 80	nbg:a	(Lnbg;)Lnbg$b;
      //   128: getfield 86	nbg$b:vid	Ljava/lang/String;
      //   131: astore_1
      //   132: aload 5
      //   134: iconst_2
      //   135: aload 6
      //   137: aload_1
      //   138: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   144: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   147: aload_0
      //   148: getfield 13	nbg$a:this$0	Lnbg;
      //   151: invokestatic 122	nbg:a	(Lnbg;)Z
      //   154: ifeq +26 -> 180
      //   157: aload_0
      //   158: getfield 13	nbg$a:this$0	Lnbg;
      //   161: aload_0
      //   162: getfield 13	nbg$a:this$0	Lnbg;
      //   165: invokestatic 39	nbg:a	(Lnbg;)Lmyi;
      //   168: invokestatic 202	nbg:a	(Lnbg;Lmyi;)V
      //   171: aload_0
      //   172: getfield 13	nbg$a:this$0	Lnbg;
      //   175: iconst_0
      //   176: invokestatic 204	nbg:a	(Lnbg;Z)Z
      //   179: pop
      //   180: iload_2
      //   181: bipush 123
      //   183: if_icmpne +63 -> 246
      //   186: iload_3
      //   187: bipush 103
      //   189: if_icmpne +3 -> 192
      //   192: aload_0
      //   193: getfield 13	nbg$a:this$0	Lnbg;
      //   196: invokestatic 47	nbg:a	(Lnbg;)Ljava/util/List;
      //   199: invokeinterface 53 1 0
      //   204: astore_1
      //   205: aload_1
      //   206: invokeinterface 58 1 0
      //   211: ifeq +73 -> 284
      //   214: aload_1
      //   215: invokeinterface 62 1 0
      //   220: checkcast 64	nbh
      //   223: iload_2
      //   224: iload_3
      //   225: ldc 206
      //   227: invokeinterface 210 4 0
      //   232: goto -27 -> 205
      //   235: ldc 206
      //   237: astore_1
      //   238: goto -175 -> 63
      //   241: aconst_null
      //   242: astore_1
      //   243: goto -111 -> 132
      //   246: iload_2
      //   247: bipush 122
      //   249: if_icmpne +20 -> 269
      //   252: iload_3
      //   253: sipush 204
      //   256: if_icmpeq -64 -> 192
      //   259: iload_3
      //   260: sipush 202
      //   263: if_icmpne -71 -> 192
      //   266: goto -74 -> 192
      //   269: iload_2
      //   270: bipush 101
      //   272: if_icmpne -80 -> 192
      //   275: iload_3
      //   276: bipush 80
      //   278: if_icmpne -86 -> 192
      //   281: goto -89 -> 192
      //   284: aload_0
      //   285: getfield 13	nbg$a:this$0	Lnbg;
      //   288: invokestatic 102	nbg:b	(Lnbg;)Ljava/util/List;
      //   291: invokeinterface 53 1 0
      //   296: astore_1
      //   297: aload_1
      //   298: invokeinterface 58 1 0
      //   303: ifeq +22 -> 325
      //   306: aload_1
      //   307: invokeinterface 62 1 0
      //   312: checkcast 104	nbf
      //   315: iload_2
      //   316: iload_3
      //   317: ldc 206
      //   319: invokevirtual 213	nbf:onError	(IILjava/lang/String;)V
      //   322: goto -25 -> 297
      //   325: iconst_0
      //   326: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	327	0	this	a
      //   0	327	1	parammyi	myi
      //   0	327	2	paramInt1	int
      //   0	327	3	paramInt2	int
      //   0	327	4	paramInt3	int
      //   0	327	5	paramString	String
      //   0	327	6	paramObject	Object
    }
    
    public boolean a(myi parammyi, int paramInt, Object paramObject)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        parammyi = nbg.b(nbg.this).iterator();
        while (parammyi.hasNext()) {
          ((nbf)parammyi.next()).i(paramInt, paramObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d(nbg.a(nbg.this), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
        }
        parammyi = nbg.a(nbg.this).iterator();
        while (parammyi.hasNext()) {
          ((nbh)parammyi.next()).aRr();
        }
        if (QLog.isColorLevel()) {
          QLog.d(nbg.a(nbg.this), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
        }
        parammyi = nbg.a(nbg.this).iterator();
        while (parammyi.hasNext()) {
          ((nbh)parammyi.next()).aRs();
        }
        if (QLog.isColorLevel())
        {
          QLog.d(nbg.a(nbg.this), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(nbg.a(nbg.this), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
          }
        }
      }
      return false;
    }
  }
  
  class b
  {
    int aXh;
    int duration;
    long startPosition;
    String url;
    String vid;
    
    b(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
    {
      this.vid = paramString1;
      this.url = paramString2;
      this.aXh = paramInt1;
      this.startPosition = paramLong;
      this.duration = paramInt2;
    }
    
    @NotNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("PlayParams{vid='").append(this.vid).append('\'').append(", url='").append(this.url).append('\'').append(", playType=");
      if (this.aXh == 101) {}
      for (String str = "VOD";; str = "LIVE") {
        return str + '}';
      }
    }
  }
  
  static class c
    extends Handler
  {
    private WeakReference<nbg> weakReference;
    
    public c(nbg paramnbg)
    {
      this.weakReference = new WeakReference(paramnbg);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (this.weakReference.get() == null);
        nbg.a((nbg)this.weakReference.get());
        nbg.a((nbg)this.weakReference.get()).sendEmptyMessageDelayed(0, nbg.a((nbg)this.weakReference.get()));
        return;
      } while (this.weakReference.get() == null);
      if (QLog.isColorLevel()) {
        QLog.d(nbg.a((nbg)this.weakReference.get()), 2, "prePlay timeout, try rePlay");
      }
      if ((((nbg)this.weakReference.get()).isReady()) && (nbg.a((nbg)this.weakReference.get()).getTag() == nbg.a((nbg)this.weakReference.get())))
      {
        nbg.b((nbg)this.weakReference.get());
        return;
      }
      nbg.a((nbg)this.weakReference.get(), false);
      ((nbg)this.weakReference.get()).g(nbg.a((nbg)this.weakReference.get()));
      nbg.a((nbg)this.weakReference.get(), nbg.a((nbg)this.weakReference.get()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbg
 * JD-Core Version:    0.7.0.1
 */