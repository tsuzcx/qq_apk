import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager.onNetWifi2None.1;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "TAG", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "hasVideoPlayTaskRunning", "", "inPlayArea", "isNetChangeAutoPlaySwitchOpen", "mediaPlayListenerAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "playState", "Ljava/util/concurrent/atomic/AtomicInteger;", "rect", "Landroid/graphics/Rect;", "stateCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "uiHandler", "Landroid/os/Handler;", "videoContainer", "Ljava/lang/ref/SoftReference;", "Landroid/widget/RelativeLayout;", "videoModule", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "videoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "createPlayerObserver", "doVideoReport", "", "state", "", "getCurrentPos", "", "getPlayState", "initVideoPlayer", "isPlaying", "isSameData", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "netChange", "onCreate", "onDestroy", "onInitOrBeforeReplay", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "onPause", "onResume", "onScrollStateChange", "scrollState", "pauseVideo", "releasePlayer", "setStateCallback", "url", "callback", "setVideoData", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "startVideo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class txq
  implements INetInfoHandler
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static SoftReference<RelativeLayout> jdField_a_of_type_JavaLangRefSoftReference;
  private static WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private static ConcurrentHashMap<String, txt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static volatile rst jdField_a_of_type_Rst;
  private static sdj jdField_a_of_type_Sdj;
  private static txp jdField_a_of_type_Txp;
  public static final txq a;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_Txq = new txq();
    jdField_a_of_type_Txp = new txp();
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private final rst a()
  {
    return (rst)new txr();
  }
  
  private final void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramContext == null) {
      return;
    }
    if (jdField_a_of_type_Sdj != null) {
      h();
    }
    paramContext = new sdj(paramContext);
    paramContext.a((ViewGroup)paramRelativeLayout, true);
    paramContext.b(2);
    if (jdField_a_of_type_Rst == null) {
      jdField_a_of_type_Rst = jdField_a_of_type_Txq.a();
    }
    paramContext.a((sdk)jdField_a_of_type_Rst);
    paramContext.c(true);
    jdField_a_of_type_Sdj = paramContext;
  }
  
  private final void b(int paramInt)
  {
    trn localtrn;
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      localObject2 = obb.a(jdField_a_of_type_Txp.a().a(), jdField_a_of_type_Txp.a().g(), 0, 1, jdField_a_of_type_Txp.a().e(), jdField_a_of_type_Txp.a().f(), jdField_a_of_type_Txp.a().g(), obb.aO, 0);
      twp.a("VideoPlayerWrapper_AD", "complete videoJson = " + localObject2);
      localtrn = new trn();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        obb.a(localtrn.a((Context)localObject1).a(obb.f).b(obb.M).a(jdField_a_of_type_Txp.a()).a((JSONObject)localObject2).a());
        jdField_a_of_type_Txp.a().a(0);
        jdField_a_of_type_Txp.a().b(jdField_a_of_type_Txp.a().g());
        jdField_a_of_type_Txp.a().d(0);
        jdField_a_of_type_Txp.a().c(1);
        return;
      }
    case 5: 
      jdField_a_of_type_Txp.a().b((int)a());
      localObject2 = obb.a(jdField_a_of_type_Txp.a().a(), jdField_a_of_type_Txp.a().b(), jdField_a_of_type_Txp.a().c(), jdField_a_of_type_Txp.a().d(), jdField_a_of_type_Txp.a().e(), jdField_a_of_type_Txp.a().f(), jdField_a_of_type_Txp.a().g(), obb.aO, 0);
      twp.a("VideoPlayerWrapper_AD", "pause videoJson = " + localObject2);
      localtrn = new trn();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        obb.a(localtrn.a((Context)localObject1).a(obb.f).b(obb.M).a(jdField_a_of_type_Txp.a()).a((JSONObject)localObject2).a());
        jdField_a_of_type_Txp.a().a(jdField_a_of_type_Txp.a().b());
        jdField_a_of_type_Txp.a().c(0);
        return;
      }
    }
    Object localObject2 = new trn();
    Object localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null) {}
    for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
    {
      obb.a(((trn)localObject2).a((Context)localObject1).a(obb.f).b(obb.M).a(jdField_a_of_type_Txp.a()).a(obb.a(0, 0, 0, 0, 0, 0, jdField_a_of_type_Txp.a().g(), obb.aO, 2)).a());
      return;
    }
  }
  
  private final void h()
  {
    twp.a("VideoPlayerWrapper_AD", "releasePlayer");
    sdj localsdj = jdField_a_of_type_Sdj;
    if (localsdj != null) {
      localsdj.g();
    }
    localsdj = jdField_a_of_type_Sdj;
    if (localsdj != null) {
      localsdj.h();
    }
    localsdj = jdField_a_of_type_Sdj;
    if (localsdj != null) {
      localsdj.a(null);
    }
    jdField_a_of_type_Sdj = (sdj)null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_Boolean = false;
  }
  
  private final void i()
  {
    if (c)
    {
      e();
      return;
    }
    f();
  }
  
  public final int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public final long a()
  {
    sdj localsdj = jdField_a_of_type_Sdj;
    if (localsdj != null) {
      return localsdj.a();
    }
    return 0L;
  }
  
  public final void a()
  {
    twp.a("VideoPlayerWrapper_AD", "onCreate");
    h();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject == null) {
        break label34;
      }
    }
    label34:
    for (Object localObject = (RelativeLayout)((SoftReference)localObject).get();; localObject = null)
    {
      b = tws.a((View)localObject, jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
  }
  
  public final void a(@Nullable Context paramContext, @Nullable RelativeLayout paramRelativeLayout, @Nullable oar paramoar, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject = null;
    label58:
    do
    {
      for (;;)
      {
        try
        {
          if (jdField_a_of_type_Boolean)
          {
            QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData but hasVideoPlayTaskRunning");
            return;
          }
          if (paramContext == null)
          {
            QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty context");
            continue;
          }
          if (paramoar == null) {
            break label58;
          }
        }
        finally {}
        if ((paramAdvertisementInfo == null) || (paramProteusBannerVideoItemData == null))
        {
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty data");
        }
        else
        {
          if (paramRelativeLayout != null) {
            break;
          }
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty videoContainer");
        }
      }
    } while (a(paramProteusBannerVideoItemData));
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    jdField_a_of_type_Txp.a(paramoar);
    jdField_a_of_type_Txp.a(paramProteusBannerVideoItemData);
    jdField_a_of_type_Txp.a(paramAdvertisementInfo);
    paramAdvertisementInfo = jdField_a_of_type_Txp.a();
    paramProteusBannerVideoItemData = jdField_a_of_type_Txp.a();
    paramoar = jdField_a_of_type_JavaLangRefWeakReference;
    if (paramoar != null) {}
    for (paramoar = (Context)paramoar.get();; paramoar = null)
    {
      c = twq.a(paramAdvertisementInfo, paramProteusBannerVideoItemData, paramoar, 2);
      jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramRelativeLayout);
      a(paramContext, paramRelativeLayout);
      twp.a("VideoPlayerWrapper_AD", "ready to playerStartByUrl");
      paramRelativeLayout = jdField_a_of_type_Sdj;
      if (paramRelativeLayout != null)
      {
        paramoar = jdField_a_of_type_Txp.a();
        paramContext = localObject;
        if (paramoar != null) {
          paramContext = paramoar.o;
        }
        paramRelativeLayout.a(null, paramContext, 3, 1L, 0L, 0);
      }
      jdField_a_of_type_Boolean = true;
      break;
    }
  }
  
  public final void a(@Nullable String paramString, @Nullable txt paramtxt)
  {
    if (paramString != null) {
      ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(paramString, paramtxt);
    }
  }
  
  public final boolean a()
  {
    sdj localsdj = jdField_a_of_type_Sdj;
    if (localsdj != null) {
      return localsdj.f();
    }
    return false;
  }
  
  public final boolean a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject2 = null;
    Object localObject1 = jdField_a_of_type_Txp.a();
    if (localObject1 != null)
    {
      localObject1 = ((ProteusBannerVideoItemData)localObject1).o;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label93;
      }
      ProteusBannerVideoItemData localProteusBannerVideoItemData = jdField_a_of_type_Txp.a();
      localObject1 = localObject2;
      if (localProteusBannerVideoItemData != null) {
        localObject1 = localProteusBannerVideoItemData.o;
      }
      if (paramProteusBannerVideoItemData == null) {
        break label86;
      }
      paramProteusBannerVideoItemData = paramProteusBannerVideoItemData.o;
      if (paramProteusBannerVideoItemData == null) {
        break label86;
      }
    }
    for (;;)
    {
      if (!Intrinsics.areEqual(localObject1, paramProteusBannerVideoItemData)) {
        break label93;
      }
      QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with same data");
      return true;
      localObject1 = null;
      break;
      label86:
      paramProteusBannerVideoItemData = "";
    }
    label93:
    return false;
  }
  
  public final void b()
  {
    e();
  }
  
  public final void c()
  {
    f();
  }
  
  public final void d()
  {
    twp.a("VideoPlayerWrapper_AD", "onDestroy");
    h();
    jdField_a_of_type_Rst = (rst)null;
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_Txp.a();
    jdField_a_of_type_JavaLangRefSoftReference = (SoftReference)null;
    b = false;
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
  }
  
  public final void e()
  {
    Object localObject2 = new StringBuilder().append("startVideo: inPlayArea = ").append(b).append("  isPlaying = ");
    Object localObject1 = jdField_a_of_type_Sdj;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((sdj)localObject1).f());
      twp.a("VideoPlayerWrapper_AD", localObject1 + "  playState = " + a());
      if (b) {
        break label84;
      }
      f();
    }
    label84:
    do
    {
      return;
      localObject1 = null;
      break;
      localObject1 = jdField_a_of_type_Sdj;
    } while ((localObject1 == null) || (((sdj)localObject1).f()) || (a() < 2));
    localObject1 = jdField_a_of_type_Sdj;
    if (localObject1 != null) {
      ((sdj)localObject1).d();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      txt localtxt = (txt)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (localtxt != null)
      {
        localObject1 = jdField_a_of_type_Txp.a();
        if (localObject1 == null) {
          break label200;
        }
      }
      label200:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localtxt.a((String)localObject1);
        break;
      }
    }
    twp.a("VideoPlayerWrapper_AD", "startVideo");
  }
  
  public final void f()
  {
    Object localObject1 = jdField_a_of_type_Sdj;
    if ((localObject1 != null) && (((sdj)localObject1).f() == true) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5))
    {
      localObject1 = jdField_a_of_type_Sdj;
      if (localObject1 != null) {
        ((sdj)localObject1).f();
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      jdField_a_of_type_Txp.a().e(2);
      localObject1 = jdField_a_of_type_Txp.a();
      Object localObject2 = jdField_a_of_type_Sdj;
      int i;
      label98:
      txt localtxt;
      if (localObject2 != null)
      {
        i = (int)((sdj)localObject2).a();
        ((txs)localObject1).b(i);
        localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label168;
        }
        localtxt = (txt)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localtxt != null)
        {
          localObject1 = jdField_a_of_type_Txp.a();
          if (localObject1 == null) {
            break label163;
          }
        }
      }
      label163:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localtxt.b((String)localObject1);
        break label98;
        i = -1;
        break;
      }
      label168:
      b(5);
      jdField_a_of_type_Txp.a().a(jdField_a_of_type_Txp.a().b());
      jdField_a_of_type_Txp.a().c(0);
      twp.a("VideoPlayerWrapper_AD", "pauseVideo");
    }
  }
  
  public final void g()
  {
    twp.a("VideoPlayerWrapper_AD", "onInitOrBeforeReplay");
    h();
    jdField_a_of_type_Txp.a();
    jdField_a_of_type_Txp.a().c(1);
    jdField_a_of_type_Txp.a().d(0);
  }
  
  public void onNetMobile2None()
  {
    f();
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetWifi2None()
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.postDelayed((Runnable)FastWebVideoPlayManager.onNetWifi2None.1.a, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */