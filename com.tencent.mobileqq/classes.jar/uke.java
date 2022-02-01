import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class uke
  extends ujy
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private TVK_NetVideoInfo.DefnInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private volatile ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private ujx jdField_a_of_type_Ujx;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g = -1L;
  private long h;
  private long i;
  private long j;
  
  public uke(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private int a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramArrayList.get(paramInt)).intValue();
        return paramInt;
      }
      catch (Exception paramArrayList)
      {
        upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][getSpeedFromListCache] e:" + paramArrayList.getMessage());
      }
      paramInt = 0;
    }
    return 0;
  }
  
  private TVK_PlayerVideoInfo a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new TVK_PlayerVideoInfo(paramInt1, paramString, "");
    paramString.setPreLoad(paramBoolean2);
    if (paramLong > 0L) {
      paramString.setConfigMap("filesize", String.valueOf(paramLong));
    }
    if (paramInt2 > 0) {
      paramString.setConfigMap("duration", String.valueOf(paramInt2 / 1000));
    }
    if (this.jdField_c_of_type_Boolean) {
      paramString.setConfigMap("keep_last_frame", "true");
    }
    paramString.setConfigMap("cache_servers_type", ukd.jdField_a_of_type_JavaLangString);
    if (!paramBoolean1) {
      paramString.setConfigMap("software_play", "true");
    }
    if ((this.jdField_b_of_type_Boolean) && (paramBoolean2)) {
      paramString.setConfigMap("enable_cover_frame", "true");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_weishi_feeds");
    paramString.setReportInfoMap(localHashMap);
    return paramString;
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + ", mState:" + ukd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    if (g())
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] checkPlayerStartState return true.");
      return false;
    }
    paramString1 = a(paramString1, paramInt1, paramLong2, paramInt2, paramBoolean1, paramBoolean2);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + ", mState:" + ukd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString2, paramLong1, 0L, null, paramString1);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = paramLong1;
      return true;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        upe.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] openMediaPlayerByUrl error:" + paramString1.getMessage());
      }
    }
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      a();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        return null;
      }
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][createVideoViewScroll]: error, mContext null");
      return null;
    }
    if (VersionUtils.isIceScreamSandwich()) {
      return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean g()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][checkPlayerStartState] not idle or complete state, should't reopen media player mState:" + ukd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return true;
    }
    return false;
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)) {
      ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).doCacheSurfaceTexture();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)) {
      ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).doRecoverSurfaceTexture();
    }
  }
  
  public void OnDownloadCallback(String arg1)
  {
    super.OnDownloadCallback(???);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this, ???);
    }
    label230:
    label245:
    for (;;)
    {
      int n;
      try
      {
        JSONObject localJSONObject = new JSONObject(???);
        long l = localJSONObject.getLong("fileSize");
        int k = localJSONObject.getInt("speedKBS");
        int m = localJSONObject.getInt("offset");
        n = localJSONObject.getInt("callBackType");
        if (l > 0L) {
          this.j = l;
        }
        if (n == 2)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
            if (m > 0) {
              this.i = m;
            }
            return;
          }
        }
        if (n != 1) {
          break label230;
        }
      }
      catch (JSONException ???)
      {
        ???.printStackTrace();
        return;
      }
      this.jdField_a_of_type_JavaLangString = ???;
      String str = localObject.optString("contentType");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_b_of_type_JavaLangString = str;
      }
      if (this.jdField_a_of_type_Ujx != null)
      {
        this.jdField_a_of_type_Ujx.b(this, ???);
        continue;
        for (;;)
        {
          if (this.jdField_a_of_type_Ujx == null) {
            break label245;
          }
          this.jdField_a_of_type_Ujx.c(this);
          break;
          if (n != 7) {
            if (n != 50) {
              break;
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.jdField_b_of_type_Long;
    if (paramBoolean) {}
    for (long l1 = b(); l1 - this.jdField_d_of_type_Long > 0L; l1 = a()) {
      return l1 - this.jdField_d_of_type_Long + l2;
    }
    return l2;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    try
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = b();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(this);
        }
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    finally {}
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    l();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][initMediaPlayer] success!");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.jdField_d_of_type_Long > 0L)
      {
        long l2 = this.jdField_b_of_type_Long;
        this.jdField_b_of_type_Long = (l1 - this.jdField_d_of_type_Long + l2);
      }
      this.jdField_d_of_type_Long = paramInt;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      m();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
      n();
    }
  }
  
  public void a(IVideoViewBase paramIVideoViewBase)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {}
    while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView == null) && ((paramIVideoViewBase instanceof View))) {
      this.jdField_a_of_type_AndroidViewView = ((View)paramIVideoViewBase);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(paramIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(this.jdField_a_of_type_Int);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_b_of_type_JavaLangObject = paramObject;
  }
  
  public void a(ujx paramujx)
  {
    this.jdField_a_of_type_Ujx = paramujx;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
    }
    return -1;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      return this.jdField_a_of_type_Long;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    return a(paramBoolean) - this.jdField_c_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][start]");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(paramInt);
    }
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][setXYAxis] value:" + paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      ThreadManager.executeOnSubThread(new WSPlayerWrapper.2(this, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer));
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() != null))
    {
      ??? = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((??? instanceof ViewGroup)) {
        ((ViewGroup)???).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_Ujx = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.g = 0L;
      this.i = 0L;
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][destroy]");
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.j;
  }
  
  public String c()
  {
    for (;;)
    {
      int k;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Object localObject2 = new StringBuilder();
          int m = Math.min(20, this.jdField_a_of_type_JavaUtilArrayList.size());
          k = 0;
          if (k < m)
          {
            ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_JavaUtilArrayList, k));
            if (k != m - 1) {
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
      k += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.excute(new WSPlayerWrapper.3(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long d()
  {
    return this.h;
  }
  
  @WorkerThread
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop]");
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long e()
  {
    return this.f;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long f()
  {
    if (this.g == -1L) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int n = Math.min(10, this.jdField_a_of_type_JavaUtilArrayList.size());
        int k = 0;
        int m = 0;
        while (k < n)
        {
          m += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(k)).intValue();
          k += 1;
        }
        if (n != 0) {
          this.g = (m / n);
        }
      }
      return this.g;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.resumeDownload();
    }
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public long g()
  {
    long l1 = -1L;
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    long l2 = l1;
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l2 = l1;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int m = this.jdField_a_of_type_JavaUtilArrayList.size();
            k = 0;
            l2 = l1;
            if (k < m)
            {
              int n = a(this.jdField_a_of_type_JavaUtilArrayList, k);
              if (k == 0)
              {
                l1 = n;
                break label105;
              }
              l1 = Math.min(n, l1);
              break label105;
            }
          }
        }
        return l2;
      }
      finally {}
      label105:
      k += 1;
    }
  }
  
  public void g()
  {
    b(true);
  }
  
  public long h()
  {
    long l1 = -1L;
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    long l2 = l1;
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l2 = l1;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int m = this.jdField_a_of_type_JavaUtilArrayList.size();
            k = 0;
            l2 = l1;
            if (k < m)
            {
              int n = a(this.jdField_a_of_type_JavaUtilArrayList, k);
              if (k == 0)
              {
                l1 = n;
                break label105;
              }
              l1 = Math.max(n, l1);
              break label105;
            }
          }
        }
        return l2;
      }
      finally {}
      label105:
      k += 1;
    }
  }
  
  public void h()
  {
    this.jdField_c_of_type_Long = a(false);
  }
  
  public long i()
  {
    long l2 = 0L;
    long l3 = this.h;
    long l1 = l2;
    if (l3 > 0L)
    {
      l1 = l2;
      if (this.i > 0L) {
        l1 = this.i / l3;
      }
    }
    return l1;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Long = (a(true) + this.jdField_b_of_type_Long);
  }
  
  public void j()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = 0L;
    this.f = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = null;
    this.h = 0L;
    this.j = 0L;
    this.g = -1L;
    this.i = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    super.onCaptureImageFailed(paramTVK_IMediaPlayer, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    super.onCaptureImageSucceed(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    super.onCompletion(paramTVK_IMediaPlayer);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.onError(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    upe.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onError]!!");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    super.onInfo(paramTVK_IMediaPlayer, paramInt, paramObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ujx != null) {
        this.jdField_a_of_type_Ujx.a(this, paramInt, paramObject);
      }
      return false;
      upe.g("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] start buffering ===> isSeeking:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.e = System.currentTimeMillis();
      continue;
      upe.g("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] end buffering <=== isSeeking:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      if (this.jdField_a_of_type_Boolean) {
        continue;
      }
      this.jdField_c_of_type_Int += 1;
      this.f += System.currentTimeMillis() - this.e;
      continue;
      if (!(paramObject instanceof String)) {
        continue;
      }
      try
      {
        k = new JSONObject((String)paramObject).optInt("skipFrameCount", 1);
        if (k <= 0) {
          continue;
        }
        this.jdField_b_of_type_Int = (k + this.jdField_b_of_type_Int);
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        for (;;)
        {
          paramTVK_IMediaPlayer.printStackTrace();
          int k = 0;
        }
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    super.onNetVideoInfo(paramTVK_IMediaPlayer, paramTVK_NetVideoInfo);
    if (paramTVK_NetVideoInfo != null)
    {
      paramTVK_NetVideoInfo.getDefinitionList();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo != null) {
        upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onNetVideoInfo] 当前清晰度:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefn() + ", " + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefnName());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = paramTVK_NetVideoInfo;
      if (this.jdField_a_of_type_Ujx != null) {
        this.jdField_a_of_type_Ujx.a(paramTVK_NetVideoInfo, this);
      }
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    super.onSeekComplete(paramTVK_IMediaPlayer);
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onSeekComplete] isPause:" + c());
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.b(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    super.onVideoPrepared(paramTVK_IMediaPlayer);
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onVideoPrepared] streamDumpInfo:" + paramTVK_IMediaPlayer.getStreamDumpInfo());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_Ujx != null) {
      this.jdField_a_of_type_Ujx.a(this, this.jdField_b_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    ThreadManager.post(new WSPlayerWrapper.1(this, paramTVK_IMediaPlayer), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */