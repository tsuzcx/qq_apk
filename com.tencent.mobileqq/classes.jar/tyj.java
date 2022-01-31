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
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;

public class tyj
  extends yhw
  implements biex
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bies jdField_a_of_type_Bies;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private QCircleTransitionLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private final HashMap<Integer, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private txj jdField_a_of_type_Txj;
  private final txq jdField_a_of_type_Txq;
  private txz jdField_a_of_type_Txz;
  protected ydl a;
  private int b;
  
  public tyj(txz paramtxz, bies parambies)
  {
    this.jdField_a_of_type_Txz = paramtxz;
    this.jdField_a_of_type_Txq = ((txq)this.jdField_a_of_type_Txz.a(txq.class));
    this.jdField_a_of_type_Bies = parambies;
    this.jdField_a_of_type_Bies.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = paramtxz.a();
    setHasStableIds(true);
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
  
  private View a()
  {
    if ((this.jdField_a_of_type_Txq != null) && (this.jdField_a_of_type_Txq.a() != null) && (this.jdField_a_of_type_Txq.a().itemView != null)) {
      return this.jdField_a_of_type_Txq.a().itemView;
    }
    return null;
  }
  
  private RecyclerViewCompat a(Context paramContext)
  {
    RecyclerViewCompat localRecyclerViewCompat = new RecyclerViewCompat(paramContext);
    localRecyclerViewCompat.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    localRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerViewCompat.setRecycledViewPool(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool);
    paramContext = new bies();
    txj localtxj = new txj(this.jdField_a_of_type_Txz, paramContext);
    localtxj.a(this);
    localRecyclerViewCompat.setAdapter(localtxj);
    paramContext.a(localRecyclerViewCompat);
    return localRecyclerViewCompat;
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
    int j = yiv.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    paramBoolean = bool;
    if (paramInt >= 1)
    {
      paramBoolean = bool;
      if (j == 0) {
        paramBoolean = false;
      }
    }
    if (this.jdField_a_of_type_Txj == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_Txj.getItemCount() - 1)
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
      QCircleContentImage localQCircleContentImage = (QCircleContentImage)this.jdField_a_of_type_Txq.a().itemView;
      boolean bool = localQCircleContentImage.a(paramInt1, paramInt2);
      QLog.d("QCircleContentVerticalAdapter", 4, " isVerticalDisAllowInterceptEvent isImageDisAllowIntercept" + bool);
      return localQCircleContentImage.a(paramInt1, paramInt2);
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
    {
      bool2 = bool3;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
      {
        bool2 = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a(paramMotionEvent);
        if ((!this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b()) || (bool2)) {
          bool1 = true;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.requestDisallowInterceptTouchEvent(bool1);
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(bool1);
          bool2 = bool1;
        }
      }
    }
    return bool2;
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
    int i = yiv.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if ((paramInt > 1.0F) && (i == 0))
    {
      QLog.d("QCircleContentVerticalAdapter", 1, "pull down at first");
      paramBoolean = bool;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(paramBoolean);
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
  
  private boolean b(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if ((a() instanceof QCircleContentImage))
    {
      i = ((FeedCloudMeta.StFeed)((QCircleContentImage)this.jdField_a_of_type_Txq.a().itemView).a()).images.size();
      j = yiv.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
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
        boolean bool2 = ((QCircleContentImage)this.jdField_a_of_type_Txq.a().itemView).a(paramInt1, paramInt2);
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
  
  public FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.requestDisallowInterceptTouchEvent(true);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView(a(paramContext));
    localFrameLayout.addView(new QCircleContentOperationView(paramContext), new ViewGroup.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public ydl a()
  {
    return this.jdField_a_of_type_Ydl;
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
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null)
    {
      paramViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0));
      QLog.d("TAG", 1, "onPagerChanged:call from horzontal view");
    }
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) && (paramViewHolder.getAdapterPosition() == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.getAdapterPosition()))
      {
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged: same viewholder return");
        return;
      }
      this.jdField_a_of_type_Txj = ((tyl)paramViewHolder).jdField_a_of_type_Txj;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((tyl)paramViewHolder).a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.c();
      }
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramViewHolder.getAdapterPosition());
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = tyl.a((tyl)paramViewHolder);
      RecyclerView.ViewHolder localViewHolder = a(((tyl)paramViewHolder).jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      if (this.jdField_a_of_type_Txq != null) {
        this.jdField_a_of_type_Txq.a(localViewHolder);
      }
      if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramViewHolder.hashCode())) != null) && (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramViewHolder.hashCode()))).booleanValue()))
      {
        ((tyl)paramViewHolder).a().notifyDataSetChanged();
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(false));
      }
      if ((localViewHolder instanceof txm)) {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(0, localStFeed.images.size());
          yiw.a().a(new QCircleFeedPicPositionEvent(localStFeed.id.get(), this.b));
          if ((i != 0) && (this.b >= 0))
          {
            this.jdField_a_of_type_Txj.a(this.b);
            this.b = 0;
          }
          if (localStFeed.images.size() == 1) {
            this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.d.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged:" + paramViewHolder.hashCode());
        return;
        if ((localViewHolder instanceof txn))
        {
          ((txn)localViewHolder).a.setOperationView(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
          if ((paramViewHolder.getAdapterPosition() == 0) && (this.jdField_a_of_type_Long != 0L))
          {
            ((txn)localViewHolder).a.setInitialPosition(this.jdField_a_of_type_Long);
            this.jdField_a_of_type_Long = 0L;
          }
          ((txn)localViewHolder).a.setVideoPath(localStFeed.video.fileId.get(), null, localStFeed.video.playUrl.get(), localStFeed.video.fileSize.get(), localStFeed.video.duration.get(), 0);
        }
      }
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(ydl paramydl)
  {
    this.jdField_a_of_type_Ydl = paramydl;
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new tyk(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramInt);
    ((tyl)paramViewHolder).a().a(localStFeed, paramInt);
    ((tyl)paramViewHolder).a(paramInt);
    tyl.a((tyl)paramViewHolder).setExtraTypeInfo(a());
    tyl.a((tyl)paramViewHolder).setInteractor(a());
    tyl.a((tyl)paramViewHolder).setData(localStFeed);
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new tyl(this, a(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool.clear();
    if (this.jdField_a_of_type_Bies != null) {
      this.jdField_a_of_type_Bies.a(null);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
    }
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    this.jdField_a_of_type_Txz = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyj
 * JD-Core Version:    0.7.0.1
 */