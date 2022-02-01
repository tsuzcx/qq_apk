import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "TAG", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "hasVideoPlayTaskRunning", "", "inPlayArea", "isNetChangeAutoPlaySwitchOpen", "mediaPlayListenerAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "playState", "Ljava/util/concurrent/atomic/AtomicInteger;", "rect", "Landroid/graphics/Rect;", "stateCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "uiHandler", "Landroid/os/Handler;", "videoContainer", "Ljava/lang/ref/SoftReference;", "Landroid/widget/RelativeLayout;", "videoModule", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "videoPauseType", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ReportConstants$VideoEndType;", "videoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "createPlayerObserver", "doVideoReport", "", "state", "", "getCurrentPos", "", "getPlayState", "initVideoPlayer", "isPlaying", "isSameData", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "netChange", "onCreate", "onDestroy", "onInitOrBeforeReplay", "isReplay", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "onPause", "onResume", "pauseVideo", "releasePlayer", "setStateCallback", "url", "callback", "setVideoData", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setVideoPauseType", "videoEndTYpe", "startVideo", "startVideoWhenScroll", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ulm
  implements INetInfoHandler
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private static SoftReference<RelativeLayout> jdField_a_of_type_JavaLangRefSoftReference;
  private static WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private static ConcurrentHashMap<String, ulp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static volatile sfi jdField_a_of_type_Sfi;
  private static spn jdField_a_of_type_Spn;
  private static ull jdField_a_of_type_Ull;
  public static final ulm a;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_Ulm = new ulm();
    jdField_a_of_type_Ull = new ull();
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final sfi a()
  {
    return (sfi)new uln();
  }
  
  private final void a(int paramInt)
  {
    ufy localufy;
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      localObject2 = ois.a(jdField_a_of_type_Ull.a().a(), jdField_a_of_type_Ull.a().g(), 0, 1, jdField_a_of_type_Ull.a().e(), jdField_a_of_type_Ull.a().f(), jdField_a_of_type_Ull.a().g(), 1, 0, jdField_a_of_type_Ull.a().h(), ReportConstants.VideoEndType.NORMAL_COMPLETE, jdField_a_of_type_Ull.a().a(), false);
      ukq.a("VideoPlayerWrapper_AD", "complete videoJson = " + localObject2);
      localufy = new ufy();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        ois.a(localufy.a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_Ull.a()).a((JSONObject)localObject2).a());
        jdField_a_of_type_Ull.a().a(0);
        jdField_a_of_type_Ull.a().b(jdField_a_of_type_Ull.a().g());
        jdField_a_of_type_Ull.a().d(0);
        jdField_a_of_type_Ull.a().c(1);
        return;
      }
    case 5: 
      jdField_a_of_type_Ull.a().b((int)a());
      localObject2 = ois.a(jdField_a_of_type_Ull.a().a(), jdField_a_of_type_Ull.a().b(), jdField_a_of_type_Ull.a().c(), jdField_a_of_type_Ull.a().d(), jdField_a_of_type_Ull.a().e(), jdField_a_of_type_Ull.a().f(), jdField_a_of_type_Ull.a().g(), 1, 0, jdField_a_of_type_Ull.a().h(), jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType, jdField_a_of_type_Ull.a().a(), false);
      ukq.a("VideoPlayerWrapper_AD", "pause videoJson = " + localObject2);
      localufy = new ufy();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        ois.a(localufy.a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_Ull.a()).a((JSONObject)localObject2).a());
        jdField_a_of_type_Ull.a().a(jdField_a_of_type_Ull.a().b());
        jdField_a_of_type_Ull.a().c(0);
        jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
        return;
      }
    }
    Object localObject2 = new ufy();
    Object localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null) {}
    for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
    {
      ois.a(((ufy)localObject2).a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_Ull.a()).a(ois.a(0, 0, 0, 0, 0, 0, jdField_a_of_type_Ull.a().g(), 1, 2, jdField_a_of_type_Ull.a().h(), ReportConstants.VideoEndType.OTHER, jdField_a_of_type_Ull.a().a(), false)).a());
      return;
    }
  }
  
  private final void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramContext == null) {
      return;
    }
    if (jdField_a_of_type_Spn != null) {
      h();
    }
    paramContext = new spn(paramContext);
    paramContext.a((ViewGroup)paramRelativeLayout, true);
    paramContext.b(2);
    if (jdField_a_of_type_Sfi == null) {
      jdField_a_of_type_Sfi = jdField_a_of_type_Ulm.a();
    }
    paramContext.a((spo)jdField_a_of_type_Sfi);
    paramContext.c(true);
    jdField_a_of_type_Spn = paramContext;
  }
  
  private final void h()
  {
    ukq.a("VideoPlayerWrapper_AD", "releasePlayer");
    spn localspn = jdField_a_of_type_Spn;
    if (localspn != null) {
      localspn.g();
    }
    localspn = jdField_a_of_type_Spn;
    if (localspn != null) {
      localspn.h();
    }
    localspn = jdField_a_of_type_Spn;
    if (localspn != null) {
      localspn.a(null);
    }
    jdField_a_of_type_Spn = (spn)null;
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
    g();
  }
  
  public final int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public final long a()
  {
    spn localspn = jdField_a_of_type_Spn;
    if (localspn != null) {
      return localspn.a();
    }
    return 0L;
  }
  
  public final void a()
  {
    ukq.a("VideoPlayerWrapper_AD", "onCreate");
    h();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public final void a(@Nullable Context paramContext, @Nullable RelativeLayout paramRelativeLayout, @Nullable ohr paramohr, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
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
          if (paramohr == null) {
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
    jdField_a_of_type_Ull.a(paramohr);
    jdField_a_of_type_Ull.a(paramProteusBannerVideoItemData);
    jdField_a_of_type_Ull.a(paramAdvertisementInfo);
    paramAdvertisementInfo = jdField_a_of_type_Ull.a();
    paramProteusBannerVideoItemData = jdField_a_of_type_Ull.a();
    paramohr = jdField_a_of_type_JavaLangRefWeakReference;
    if (paramohr != null) {}
    for (paramohr = (Context)paramohr.get();; paramohr = null)
    {
      c = ukr.a(paramAdvertisementInfo, paramProteusBannerVideoItemData, paramohr, 2);
      jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramRelativeLayout);
      a(paramContext, paramRelativeLayout);
      ukq.a("VideoPlayerWrapper_AD", "ready to playerStartByUrl");
      paramRelativeLayout = jdField_a_of_type_Spn;
      if (paramRelativeLayout != null)
      {
        paramohr = jdField_a_of_type_Ull.a();
        paramContext = localObject;
        if (paramohr != null) {
          paramContext = paramohr.o;
        }
        paramRelativeLayout.a(null, paramContext, 3, 1L, 0L, 0);
      }
      jdField_a_of_type_Boolean = true;
      break;
    }
  }
  
  public final void a(@NotNull ReportConstants.VideoEndType paramVideoEndType)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoEndType, "videoEndTYpe");
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public final void a(@Nullable String paramString, @Nullable ulp paramulp)
  {
    if (paramString != null) {
      ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(paramString, paramulp);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    ukq.a("VideoPlayerWrapper_AD", "onInitOrBeforeReplay");
    h();
    jdField_a_of_type_Ull.a();
    jdField_a_of_type_Ull.a().c(1);
    jdField_a_of_type_Ull.a().d(0);
    jdField_a_of_type_Ull.a().a(paramBoolean);
    if (paramBoolean)
    {
      ulo localulo = jdField_a_of_type_Ull.a();
      localulo.h(localulo.h() + 1);
      return;
    }
    jdField_a_of_type_Ull.a().h(0);
  }
  
  public final boolean a()
  {
    spn localspn = jdField_a_of_type_Spn;
    if (localspn != null) {
      return localspn.f();
    }
    return false;
  }
  
  public final boolean a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject2 = null;
    Object localObject1 = jdField_a_of_type_Ull.a();
    if (localObject1 != null)
    {
      localObject1 = ((ProteusBannerVideoItemData)localObject1).o;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label93;
      }
      ProteusBannerVideoItemData localProteusBannerVideoItemData = jdField_a_of_type_Ull.a();
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
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  }
  
  public final void c()
  {
    g();
  }
  
  public final void d()
  {
    ukq.a("VideoPlayerWrapper_AD", "onDestroy");
    h();
    jdField_a_of_type_Sfi = (sfi)null;
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_Ull.a();
    jdField_a_of_type_JavaLangRefSoftReference = (SoftReference)null;
    b = false;
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
  }
  
  public final void e()
  {
    Object localObject2 = new StringBuilder().append("startVideo: inPlayArea = ").append(b).append("  isPlaying = ");
    Object localObject1 = jdField_a_of_type_Spn;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((spn)localObject1).f());
      ukq.a("VideoPlayerWrapper_AD", localObject1 + "  playState = " + a());
      if (b) {
        break label84;
      }
      g();
    }
    label84:
    do
    {
      return;
      localObject1 = null;
      break;
      localObject1 = jdField_a_of_type_Spn;
    } while ((localObject1 == null) || (((spn)localObject1).f()) || (a() < 2));
    localObject1 = jdField_a_of_type_Spn;
    if (localObject1 != null) {
      ((spn)localObject1).d();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      ulp localulp = (ulp)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (localulp != null)
      {
        localObject1 = jdField_a_of_type_Ull.a();
        if (localObject1 == null) {
          break label200;
        }
      }
      label200:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localulp.a((String)localObject1);
        break;
      }
    }
    ukq.a("VideoPlayerWrapper_AD", "startVideo");
  }
  
  public final void f()
  {
    Object localObject = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null) {}
    for (localObject = (RelativeLayout)((SoftReference)localObject).get();; localObject = null)
    {
      b = ukt.a((View)localObject, jdField_a_of_type_AndroidGraphicsRect);
      e();
      return;
    }
  }
  
  public final void g()
  {
    Object localObject1 = jdField_a_of_type_Spn;
    if ((localObject1 != null) && (((spn)localObject1).f() == true) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5))
    {
      b = false;
      localObject1 = jdField_a_of_type_Spn;
      if (localObject1 != null) {
        ((spn)localObject1).f();
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      jdField_a_of_type_Ull.a().e(2);
      localObject1 = jdField_a_of_type_Ull.a();
      Object localObject2 = jdField_a_of_type_Spn;
      int i;
      label102:
      ulp localulp;
      if (localObject2 != null)
      {
        i = (int)((spn)localObject2).a();
        ((ulo)localObject1).b(i);
        localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label172;
        }
        localulp = (ulp)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localulp != null)
        {
          localObject1 = jdField_a_of_type_Ull.a();
          if (localObject1 == null) {
            break label167;
          }
        }
      }
      label167:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localulp.b((String)localObject1);
        break label102;
        i = -1;
        break;
      }
      label172:
      a(5);
      jdField_a_of_type_Ull.a().a(jdField_a_of_type_Ull.a().b());
      jdField_a_of_type_Ull.a().c(0);
      ukq.a("VideoPlayerWrapper_AD", "pauseVideo");
    }
  }
  
  public void onNetMobile2None()
  {
    g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulm
 * JD-Core Version:    0.7.0.1
 */