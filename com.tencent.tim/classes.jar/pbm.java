import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.a;
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

public class pbm
  extends rxs
  implements auwv.c
{
  private auwv jdField_a_of_type_Auwv;
  private final pat jdField_a_of_type_Pat;
  private pbc jdField_a_of_type_Pbc;
  private final RecyclerView.RecycledViewPool jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  private QCircleContentOperationView jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private QCircleTransitionLayout jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private RecyclerViewCompat jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private pao jdField_b_of_type_Pao;
  private int bgT;
  private RecyclerView.ViewHolder d;
  private final HashMap<Integer, Boolean> eX = new HashMap();
  private RecyclerView k;
  private ExtraTypeInfo mExtraTypeInfo;
  protected BaseWidgetView.a mInteractor;
  private int mTouchSlop;
  private long zq;
  
  public pbm(pbc parampbc, auwv paramauwv)
  {
    this.jdField_a_of_type_Pbc = parampbc;
    this.jdField_a_of_type_Pat = ((pat)this.jdField_a_of_type_Pbc.getViewModel(pat.class));
    this.jdField_a_of_type_Auwv = paramauwv;
    this.jdField_a_of_type_Auwv.b(this);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = parampbc.a();
    setHasStableIds(true);
  }
  
  private boolean C(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
    {
      bool2 = bool3;
      if (this.k != null)
      {
        bool2 = this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.B(paramMotionEvent);
        if ((!this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.isCollapsed()) || (bool2)) {
          bool1 = true;
        }
        this.k.requestDisallowInterceptTouchEvent(bool1);
        bool2 = bool1;
        if (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rr(bool1);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  @Nullable
  private RecyclerView.ViewHolder a(RecyclerViewCompat paramRecyclerViewCompat)
  {
    RecyclerView.ViewHolder localViewHolder = null;
    if (paramRecyclerViewCompat != null)
    {
      if (!(paramRecyclerViewCompat.getLayoutManager() instanceof LinearLayoutManager)) {
        break label46;
      }
      int j = ((LinearLayoutManager)paramRecyclerViewCompat.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
      i = j;
      if (j >= 0) {}
    }
    label46:
    for (int i = 0;; i = 0)
    {
      localViewHolder = paramRecyclerViewCompat.findViewHolderForAdapterPosition(i);
      return localViewHolder;
    }
  }
  
  private RecyclerViewCompat a(Context paramContext)
  {
    RecyclerViewCompat localRecyclerViewCompat = new RecyclerViewCompat(paramContext);
    localRecyclerViewCompat.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    localRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerViewCompat.setRecycledViewPool(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool);
    paramContext = new auwv();
    pao localpao = new pao(this.jdField_a_of_type_Pbc, paramContext);
    localpao.a(this);
    localRecyclerViewCompat.setAdapter(localpao);
    paramContext.a(localRecyclerViewCompat);
    return localRecyclerViewCompat;
  }
  
  private boolean ah(int paramInt1, int paramInt2)
  {
    if ((at() instanceof QCircleContentImage))
    {
      QCircleContentImage localQCircleContentImage = (QCircleContentImage)this.jdField_a_of_type_Pat.a().itemView;
      boolean bool = localQCircleContentImage.v(paramInt1, paramInt2);
      QLog.d("QCircleContentVerticalAdapter", 4, " isVerticalDisAllowInterceptEvent isImageDisAllowIntercept" + bool);
      return localQCircleContentImage.v(paramInt1, paramInt2);
    }
    return false;
  }
  
  private boolean ai(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if ((at() instanceof QCircleContentImage))
    {
      i = ((FeedCloudMeta.StFeed)((QCircleContentImage)this.jdField_a_of_type_Pat.a().itemView).getData()).images.size();
      j = rym.b(this.jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      if ((paramInt1 < 1.0D) || (j != 0)) {
        break label176;
      }
    }
    label176:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt1 <= -1.0D) && (j == i - 1)) {
        bool1 = true;
      }
      for (;;)
      {
        boolean bool2 = ((QCircleContentImage)this.jdField_a_of_type_Pat.a().itemView).v(paramInt1, paramInt2);
        QLog.d("QCircleContentVerticalAdapter", 4, " isHorizontalDisAllowInterceptEvent totalPic" + i + " curPos" + j + " isbounds" + bool1 + " isImageDisAllowIntercept" + bool2);
        return (bool1) && (bool2);
        return false;
      }
    }
  }
  
  private void al(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
    {
      if (paramBoolean) {
        this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rr(true);
      }
    }
    else {
      return;
    }
    int j = rym.b(this.jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    paramBoolean = bool;
    if (paramInt >= 1)
    {
      paramBoolean = bool;
      if (j == 0) {
        paramBoolean = false;
      }
    }
    if (this.jdField_b_of_type_Pao == null) {}
    for (int i = -1;; i = this.jdField_b_of_type_Pao.getItemCount() - 1)
    {
      bool = paramBoolean;
      if (paramInt <= -1)
      {
        bool = paramBoolean;
        if (j == i) {
          bool = false;
        }
      }
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rr(bool);
      return;
    }
  }
  
  private void am(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
    {
      if (paramBoolean) {
        this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rr(true);
      }
    }
    else {
      return;
    }
    int i = rym.a(this.k);
    if ((paramInt > 1.0F) && (i == 0))
    {
      QLog.d("QCircleContentVerticalAdapter", 1, "pull down at first");
      paramBoolean = bool;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rr(paramBoolean);
      return;
      if ((paramInt < -1.0F) && (i == getItemCount() - 1))
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
  
  private View at()
  {
    if ((this.jdField_a_of_type_Pat != null) && (this.jdField_a_of_type_Pat.a() != null) && (this.jdField_a_of_type_Pat.a().itemView != null)) {
      return this.jdField_a_of_type_Pat.a().itemView;
    }
    return null;
  }
  
  private void dG(int paramInt1, int paramInt2)
  {
    boolean bool = ai(paramInt1, paramInt2);
    if (this.jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.requestDisallowInterceptTouchEvent(bool);
    }
    if (this.k != null) {
      this.k.requestDisallowInterceptTouchEvent(true);
    }
    al(paramInt1, bool);
  }
  
  private void dH(int paramInt1, int paramInt2)
  {
    boolean bool = ah(paramInt1, paramInt2);
    if (this.k != null) {
      this.k.requestDisallowInterceptTouchEvent(bool);
    }
    am(paramInt2, bool);
  }
  
  public FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.requestDisallowInterceptTouchEvent(true);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView(a(paramContext));
    localFrameLayout.addView(new QCircleContentOperationView(paramContext), new ViewGroup.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  public void dI(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.animate().alpha(paramInt1).setDuration(paramInt2);
    }
  }
  
  public boolean eO(String paramString)
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
  
  public void eY(long paramLong)
  {
    this.zq = paramLong;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public BaseWidgetView.a getInteractor()
  {
    return this.mInteractor;
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
    this.k = paramRecyclerView;
    if ((this.k.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.k.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
    this.mTouchSlop = ViewConfiguration.get(this.k.getContext()).getScaledTouchSlop();
    this.k.addOnItemTouchListener(new pbn(this));
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      return this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.onBackEvent();
    }
    return false;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramInt);
    ((pbm.a)paramViewHolder).a().setFeedData(localStFeed, paramInt);
    ((pbm.a)paramViewHolder).setPos(paramInt);
    pbm.a.a((pbm.a)paramViewHolder).setExtraTypeInfo(getExtraTypeInfo());
    pbm.a.a((pbm.a)paramViewHolder).setInteractor(getInteractor());
    pbm.a.a((pbm.a)paramViewHolder).setData(localStFeed);
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new pbm.a(a(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool.clear();
    if (this.jdField_a_of_type_Auwv != null) {
      this.jdField_a_of_type_Auwv.b(null);
    }
    if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.release();
    }
    this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
    this.d = null;
    this.jdField_a_of_type_Pbc = null;
  }
  
  public void onFooterRebound() {}
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.k.getChildViewHolder(this.k.getChildAt(0));
      QLog.d("TAG", 1, "onPagerChanged:call from horzontal view");
    }
    for (int i = 1;; i = 0)
    {
      if ((this.d != null) && (paramViewHolder.getAdapterPosition() == this.d.getAdapterPosition()))
      {
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged: same viewholder return");
        return;
      }
      this.jdField_b_of_type_Pao = ((pbm.a)paramViewHolder).jdField_c_of_type_Pao;
      this.jdField_b_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((pbm.a)paramViewHolder).a();
      if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
        this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.reset();
      }
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramViewHolder.getAdapterPosition());
      this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = pbm.a.a((pbm.a)paramViewHolder);
      RecyclerView.ViewHolder localViewHolder = a(((pbm.a)paramViewHolder).jdField_c_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      if (this.jdField_a_of_type_Pat != null) {
        this.jdField_a_of_type_Pat.f(localViewHolder);
      }
      if ((this.eX.get(Integer.valueOf(paramViewHolder.hashCode())) != null) && (((Boolean)this.eX.get(Integer.valueOf(paramViewHolder.hashCode()))).booleanValue()))
      {
        ((pbm.a)paramViewHolder).a().notifyDataSetChanged();
        this.eX.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(false));
      }
      if ((localViewHolder instanceof pao.a)) {
        if (this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(0, localStFeed.images.size());
          rwv.a().a(new QCircleFeedPicPositionEvent(localStFeed.id.get(), this.bgT));
          if ((i != 0) && (this.bgT >= 0))
          {
            this.jdField_b_of_type_Pao.vn(this.bgT);
            this.bgT = 0;
          }
          if (localStFeed.images.size() == 1) {
            this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.wi.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        this.d = paramViewHolder;
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged:" + paramViewHolder.hashCode());
        return;
        if ((localViewHolder instanceof pao.b))
        {
          ((pao.b)localViewHolder).a.setOperationView(this.jdField_b_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
          i = j;
          if (paramViewHolder.getAdapterPosition() == 0)
          {
            i = j;
            if (this.zq != 0L)
            {
              i = (int)this.zq;
              this.zq = 0L;
            }
          }
          ((pao.b)localViewHolder).a.setVideoPath(localStFeed.video.fileId.get(), localStFeed.video.playUrl.get(), i);
        }
      }
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
    this.eX.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(true));
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setInteractor(BaseWidgetView.a parama)
  {
    this.mInteractor = parama;
  }
  
  public void vp(int paramInt)
  {
    this.bgT = paramInt;
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    private final QCircleContentOperationView c;
    public RecyclerViewCompat c;
    public pao c;
    private int mPos;
    
    public a(View paramView)
    {
      super();
      this$1 = (FrameLayout)paramView;
      this.jdField_c_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)pbm.this.getChildAt(0));
      this.jdField_c_of_type_Pao = ((pao)this.jdField_c_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter());
      this.jdField_c_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = ((QCircleContentOperationView)pbm.this.getChildAt(1));
      this.jdField_c_of_type_Pao.setOperationView(this.jdField_c_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
    }
    
    public RecyclerViewCompat a()
    {
      return this.jdField_c_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
    }
    
    public pao a()
    {
      return this.jdField_c_of_type_Pao;
    }
    
    public void setPos(int paramInt)
    {
      this.mPos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbm
 * JD-Core Version:    0.7.0.1
 */