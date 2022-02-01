import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageConfig;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageController.onBarragePlaceInLine.2;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView.AppearState;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageState;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/IBarrageControl;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLineCallback;", "barrageView", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageView;", "barrageConfig", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageView;Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;)V", "animatorList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController$AnimatorState;", "Lkotlin/collections/ArrayList;", "barrageCallback", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageCallback;", "getBarrageCallback", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageCallback;", "setBarrageCallback", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageCallback;)V", "getBarrageConfig", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "barrageData", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageInfo;", "barrageHandler", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageHandler;", "barrageObserver", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController$BarrageBusinessObserver;", "barrageState", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageState;", "barrageTrack", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack;", "getBarrageView", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "playCalledButDataEmpty", "", "getPlayCalledButDataEmpty", "()Z", "setPlayCalledButDataEmpty", "(Z)V", "sessionParamsMap", "Landroid/support/v4/util/ArrayMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageHandler$SessionParams;", "changeState", "", "state", "fetchBarrageList", "articleId", "", "rowKey", "puin", "layoutBarrageItemView", "barrageItemView", "Landroid/view/View;", "barrageLine", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLine;", "notifyBarrageItemRightDistance", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView;", "distance", "", "onBarragePlaceInLine", "barrageInfo", "barrageLines", "", "pause", "pauseAllAnimators", "pauseAnimator", "animatorState", "play", "release", "resumeAllAnimators", "resumeAnimator", "startBarrageItemAnimation", "stop", "stopAllAnimators", "AnimatorState", "BarrageBusinessObserver", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uas
  implements ubm
{
  public static final uav a;
  @NotNull
  private static final Integer[] jdField_a_of_type_ArrayOfJavaLangInteger = { Integer.valueOf(28), Integer.valueOf(140), Integer.valueOf(300) };
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ArrayMap<String, ubg> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  @NotNull
  private final BarrageConfig jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig;
  private BarrageState jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState;
  @NotNull
  private final BarrageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView;
  private final ArrayList<BarrageInfo> jdField_a_of_type_JavaUtilArrayList;
  @Nullable
  private uar jdField_a_of_type_Uar;
  private final uau jdField_a_of_type_Uau;
  private final ube jdField_a_of_type_Ube;
  private final ubk jdField_a_of_type_Ubk;
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<uat> b;
  
  static
  {
    jdField_a_of_type_Uav = new uav(null);
  }
  
  public uas(@NotNull BarrageView paramBarrageView, @NotNull BarrageConfig paramBarrageConfig)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView = paramBarrageView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig = paramBarrageConfig;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView.getContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState = BarrageState.IDLE;
    this.jdField_a_of_type_Ubk = new ubk();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.b = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler((Handler.Callback)uaw.a);
    paramBarrageView = pnn.a();
    paramBarrageConfig = paramBarrageView.getBusinessHandler(BusinessHandlerFactory.VIDEO_FEEDS_BARRAGE_HANDLER);
    if (paramBarrageConfig == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageHandler");
    }
    this.jdField_a_of_type_Ube = ((ube)paramBarrageConfig);
    this.jdField_a_of_type_Uau = new uau(this);
    this.jdField_a_of_type_Ubk.a((ubm)this);
    if (paramBarrageView != null) {
      paramBarrageView.addObserver((BusinessObserver)this.jdField_a_of_type_Uau);
    }
  }
  
  private final void a(View paramView, ubl paramubl)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView.addView(paramView);
    paramView.setX(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView.getWidth());
    paramView.setY(paramubl.b());
  }
  
  private final void a(BarrageItemView paramBarrageItemView, int paramInt)
  {
    if ((paramInt > paramBarrageItemView.a()) && (paramBarrageItemView.a()))
    {
      paramBarrageItemView.setBusyInLineEntry(false);
      Iterator localIterator = paramBarrageItemView.a().iterator();
      while (localIterator.hasNext()) {
        ((ubl)localIterator.next()).a(true);
      }
      this.jdField_a_of_type_Ubk.b();
    }
    if ((paramBarrageItemView.a() == BarrageItemView.AppearState.NONE) && (paramInt > -paramBarrageItemView.getWidth())) {
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.PART);
    }
    do
    {
      do
      {
        return;
      } while ((paramBarrageItemView.a() != BarrageItemView.AppearState.PART) || (paramInt <= 0));
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.ALL);
      paramBarrageItemView = this.jdField_a_of_type_Uar;
    } while (paramBarrageItemView == null);
    paramBarrageItemView.onEventBarrageDidAppear();
  }
  
  private final void a(BarrageState paramBarrageState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BarrageController", 2, "changeState oldState:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState + " state:" + paramBarrageState);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState = paramBarrageState;
  }
  
  private final void a(uat paramuat)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramuat.a().pause();
      return;
    }
    paramuat.a(paramuat.a().getCurrentPlayTime());
    paramuat.a().cancel();
  }
  
  private final void b(uat paramuat)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramuat.a().isStarted())
      {
        paramuat.a().resume();
        return;
      }
      paramuat.a().start();
      return;
    }
    paramuat.a().start();
    paramuat.a().setCurrentPlayTime(paramuat.a());
  }
  
  private final void e()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      b((uat)localObject);
    }
  }
  
  private final void f()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      a((uat)localObject);
    }
  }
  
  private final void g()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext()) {
      ((uat)localIterator.next()).a().cancel();
    }
  }
  
  @NotNull
  public final BarrageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView;
  }
  
  @Nullable
  public final uar a()
  {
    return this.jdField_a_of_type_Uar;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.w("BarrageController", 2, "Barrage play failed for barrageData is empty.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.PLAYING)
    {
      QLog.w("BarrageController", 2, "Barrage play failed for status is PLAYING.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.PAUSE)
    {
      a(BarrageState.PLAYING);
      e();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.IDLE) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.STOPED))
    {
      a(BarrageState.PLAYING);
      this.jdField_a_of_type_Ubk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig, (List)this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ubk.a();
      return;
    }
    QLog.w("BarrageController", 2, "play ignore for state:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState);
  }
  
  public void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "puin");
    if (QLog.isColorLevel()) {
      QLog.d("BarrageController", 2, "fetchBarrageList articleId:" + paramLong + " rowKey:" + paramString1 + " puin:" + paramString2);
    }
    this.jdField_a_of_type_Ube.a(paramLong, paramString1, paramString2, (ubg)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString1));
  }
  
  public void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull List<ubl> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "barrageLines");
    Object localObject = ubd.a;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ((ubd)localObject).a(localContext, paramBarrageInfo);
    ((BarrageItemView)localObject).setBusyInLineEntry(true);
    ((BarrageItemView)localObject).setPlaceLines(paramList);
    ((BarrageItemView)localObject).setOnClickListener((View.OnClickListener)new uax(this, paramBarrageInfo));
    a((View)localObject, (ubl)paramList.get(0));
    ((BarrageItemView)localObject).a(paramBarrageInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig);
    this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new BarrageController.onBarragePlaceInLine.2(this, (BarrageItemView)localObject));
  }
  
  public final void a(@NotNull BarrageItemView paramBarrageItemView)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageItemView, "barrageItemView");
    float f = paramBarrageItemView.getX();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f, -paramBarrageItemView.getWidth() });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "ValueAnimator.ofFloat(st…ItemView.width.toFloat())");
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    localValueAnimator.setDuration((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig.a() * 1000 * (paramBarrageItemView.getWidth() + f) / f));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new uay(this, paramBarrageItemView, f));
    localValueAnimator.addListener((Animator.AnimatorListener)new uaz(this, paramBarrageItemView, localValueAnimator));
    this.b.add(new uat(this, localValueAnimator));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.PLAYING) {
      localValueAnimator.start();
    }
  }
  
  public final void a(@Nullable uar paramuar)
  {
    this.jdField_a_of_type_Uar = paramuar;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState != BarrageState.PLAYING) {
      return;
    }
    a(BarrageState.PAUSE);
    f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.STOPED) {
      return;
    }
    a(BarrageState.STOPED);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageView.removeAllViews();
    g();
    this.b.clear();
  }
  
  public final void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageState == BarrageState.IDLE) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      a(BarrageState.IDLE);
      localQQAppInterface = pnn.a();
    } while (localQQAppInterface == null);
    localQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_Uau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uas
 * JD-Core Version:    0.7.0.1
 */