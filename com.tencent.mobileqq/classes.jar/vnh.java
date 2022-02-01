import android.content.Context;
import android.media.AudioManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;

public class vnh
  extends aabs
  implements aabg<QCircleReportBean>, bltm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected aafz a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private final RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blth jdField_a_of_type_Blth;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private QCircleTransitionLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private final HashMap<Integer, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private vlr jdField_a_of_type_Vlr;
  private final vmf jdField_a_of_type_Vmf;
  private vmw jdField_a_of_type_Vmw;
  private int b;
  
  public vnh(vmw paramvmw, blth paramblth)
  {
    this.jdField_a_of_type_Vmw = paramvmw;
    this.jdField_a_of_type_Vmf = ((vmf)this.jdField_a_of_type_Vmw.a(vmf.class));
    this.jdField_a_of_type_Blth = paramblth;
    this.jdField_a_of_type_Blth.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = paramvmw.a();
    setHasStableIds(true);
  }
  
  @Nullable
  private RecyclerView.ViewHolder a(RecyclerViewCompat paramRecyclerViewCompat)
  {
    if (paramRecyclerViewCompat != null) {
      return ((vlr)paramRecyclerViewCompat.getAdapter()).a();
    }
    return null;
  }
  
  private View a()
  {
    if ((this.jdField_a_of_type_Vmf != null) && (this.jdField_a_of_type_Vmf.a() != null) && (this.jdField_a_of_type_Vmf.a().itemView != null)) {
      return this.jdField_a_of_type_Vmf.a().itemView;
    }
    return null;
  }
  
  private RecyclerViewCompat a(Context paramContext)
  {
    RecyclerViewCompat localRecyclerViewCompat = new RecyclerViewCompat(paramContext);
    Object localObject = new RecyclerView.LayoutParams(-1, -1);
    ((RecyclerView.LayoutParams)localObject).bottomMargin = uym.c;
    localRecyclerViewCompat.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerViewCompat.setRecycledViewPool(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool);
    paramContext = new blth();
    localObject = new vlr(this.jdField_a_of_type_Vmw, paramContext);
    ((vlr)localObject).a(a());
    ((vlr)localObject).a(this);
    ((vlr)localObject).a(a());
    localRecyclerViewCompat.setAdapter((RecyclerView.Adapter)localObject);
    paramContext.a(localRecyclerViewCompat);
    return localRecyclerViewCompat;
  }
  
  private String a(String paramString)
  {
    paramString = uyn.a(paramString);
    if (paramString != null) {
      return paramString.video.playUrl.get();
    }
    return "";
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(true);
      }
    }
    else {
      return;
    }
    int j = aade.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    paramBoolean = bool;
    if (paramInt >= 1)
    {
      paramBoolean = bool;
      if (j == 0) {
        paramBoolean = false;
      }
    }
    if (this.jdField_a_of_type_Vlr == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_Vlr.getItemCount() - 1)
    {
      bool = paramBoolean;
      if (paramInt <= -1)
      {
        bool = paramBoolean;
        if (j == i) {
          bool = false;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(bool);
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((a() instanceof QCircleContentImage))
    {
      QCircleContentImage localQCircleContentImage = (QCircleContentImage)this.jdField_a_of_type_Vmf.a().itemView;
      boolean bool = localQCircleContentImage.a(paramInt1, paramInt2);
      QLog.d("QCircleContentVerticalAdapter", 4, " isVerticalDisAllowInterceptEvent isImageDisAllowIntercept" + bool);
      return localQCircleContentImage.a(paramInt1, paramInt2);
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
      {
        bool3 = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a(paramMotionEvent);
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b())
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.requestDisallowInterceptTouchEvent(bool1);
      }
    }
    return bool1;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = b(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.requestDisallowInterceptTouchEvent(bool);
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.requestDisallowInterceptTouchEvent(true);
    }
    a(paramInt1, bool);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(true);
      }
    }
    else {
      return;
    }
    int i = aade.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if ((paramInt > this.jdField_a_of_type_Int) && (i == 0))
    {
      QLog.d("QCircleContentVerticalAdapter", 1, "pull down at first");
      paramBoolean = bool;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(paramBoolean);
      return;
      if ((paramInt < -this.jdField_a_of_type_Int) && (i == getItemCount() - 1))
      {
        QLog.d("QCircleContentVerticalAdapter", 1, "pull up at bottom");
        paramBoolean = bool;
      }
      else
      {
        paramBoolean = true;
      }
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if ((a() instanceof QCircleContentImage))
    {
      i = ((FeedCloudMeta.StFeed)((QCircleContentImage)this.jdField_a_of_type_Vmf.a().itemView).a()).images.size();
      j = aade.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      if ((paramInt1 < 1.0D) || (j != 0)) {
        break label180;
      }
    }
    label180:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt1 <= -1.0D) && (j == i - 1)) {
        bool1 = true;
      }
      for (;;)
      {
        boolean bool2 = ((QCircleContentImage)this.jdField_a_of_type_Vmf.a().itemView).a(paramInt1, paramInt2);
        QLog.d("QCircleContentVerticalAdapter", 4, " isHorizontalDisAllowInterceptEvent totalPic" + i + " curPos" + j + " isbounds" + bool1 + " isImageDisAllowIntercept" + bool2);
        return (bool1) && (bool2);
        return false;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool = a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.requestDisallowInterceptTouchEvent(bool);
    }
    b(paramInt2, bool);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b();
    }
    return 0;
  }
  
  public aafz a()
  {
    return this.jdField_a_of_type_Aafz;
  }
  
  public FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.requestDisallowInterceptTouchEvent(true);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView(a(paramContext));
    paramContext = new QCircleContentOperationView(paramContext);
    paramContext.setPlayScene(this.jdField_a_of_type_Vmw.a().mPlayScene);
    paramContext.setReportBean(a());
    localFrameLayout.addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleContentVerticalAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.animate().alpha(paramInt1).setDuration(paramInt2);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(aafz paramaafz)
  {
    this.jdField_a_of_type_Aafz = paramaafz;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0));
      QLog.d("QCircleContentVerticalAdapter", 1, "onPagerChanged:call from horzontal view");
    }
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) && (paramViewHolder.getAdapterPosition() == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.getAdapterPosition()))
      {
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged: same viewholder return");
        return;
      }
      this.jdField_a_of_type_Vlr = ((vnj)paramViewHolder).jdField_a_of_type_Vlr;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((vnj)paramViewHolder).a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
      }
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramViewHolder.getAdapterPosition());
      this.jdField_a_of_type_Vmw.a().mFeed = localStFeed;
      if ((a() instanceof var))
      {
        localObject = new vas();
        ((vas)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = localStFeed;
        ((vas)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        ((vas)localObject).jdField_a_of_type_Int = 1;
        ((var)a()).a("danmaku_show", (vas)localObject);
      }
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = vnj.a((vnj)paramViewHolder);
      Object localObject = a(((vnj)paramViewHolder).jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurrentHorizontalVH((RecyclerView.ViewHolder)localObject);
      if (this.jdField_a_of_type_Vmf != null) {
        this.jdField_a_of_type_Vmf.a((RecyclerView.ViewHolder)localObject);
      }
      if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramViewHolder.hashCode())) != null) && (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramViewHolder.hashCode()))).booleanValue()))
      {
        ((vnj)paramViewHolder).a().notifyDataSetChanged();
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(false));
      }
      if ((localObject instanceof vlw)) {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(0, localStFeed.images.get());
          aaak.a().a(new QCircleFeedPicPositionEvent(localStFeed.id.get(), this.b));
          if ((i != 0) && (this.b >= 0))
          {
            this.jdField_a_of_type_Vlr.a(this.b);
            this.b = 0;
          }
          if (localStFeed.images.size() == 1) {
            this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a.setVisibility(8);
          }
        }
      }
      while (!(localObject instanceof vlx))
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged:" + paramViewHolder.hashCode());
        return;
      }
      if (((vlx)localObject).a == null)
      {
        QLog.e("QCircleContentVerticalAdapter", 1, "mQCircleVideo is null returned");
        return;
      }
      ((vlx)localObject).a.setOperationView(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
      i = j;
      if (paramViewHolder.getAdapterPosition() == 0)
      {
        i = j;
        if (this.jdField_a_of_type_Long != 0L)
        {
          i = (int)this.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = 0L;
        }
      }
      String str = a(localStFeed.id.get());
      if (TextUtils.isEmpty(str))
      {
        str = localStFeed.video.playUrl.get();
        QLog.d("QCircleContentVerticalAdapter", 1, "play net url:" + str);
      }
      for (;;)
      {
        ((vlx)localObject).a.setVideoPath(localStFeed.video, i);
        if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_AndroidMediaAudioManager != null)) {
          break;
        }
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext().getSystemService("audio"));
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
        break;
        QLog.d("QCircleContentVerticalAdapter", 1, "play local url:" + str);
      }
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleContentVerticalAdapter", paramQCircleReportBean);
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < getDataList().size())
      {
        if (((FeedCloudMeta.StFeed)getDataList().get(i)).id.get().equals(paramString))
        {
          getDataList().remove(i);
          notifyItemRemoved(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
    this.jdField_a_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext()).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new vni(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramInt);
    ((vnj)paramViewHolder).a().a(localStFeed, paramInt);
    ((vnj)paramViewHolder).a(paramInt);
    vnj.a((vnj)paramViewHolder).setExtraTypeInfo(a());
    vnj.a((vnj)paramViewHolder).setInteractor(a());
    vnj.a((vnj)paramViewHolder).setData(localStFeed);
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new vnj(this, a(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool.clear();
    if (this.jdField_a_of_type_Blth != null) {
      this.jdField_a_of_type_Blth.a(null);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b();
    }
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    this.jdField_a_of_type_Vmw = null;
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onViewAttachedToWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onViewDetachedFromWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(true));
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnh
 * JD-Core Version:    0.7.0.1
 */