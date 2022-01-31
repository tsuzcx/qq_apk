import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
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

public class txk
  extends ydn
  implements biaq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bial jdField_a_of_type_Bial;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final twv jdField_a_of_type_Twv;
  private txe jdField_a_of_type_Txe;
  private final HashMap<Integer, Boolean> b = new HashMap();
  
  public txk(txe paramtxe, bial parambial)
  {
    this.jdField_a_of_type_Txe = paramtxe;
    this.jdField_a_of_type_Twv = ((twv)this.jdField_a_of_type_Txe.a(twv.class));
    this.jdField_a_of_type_Bial = parambial;
    this.jdField_a_of_type_Bial.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
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
  
  private RecyclerViewCompat a(Context paramContext)
  {
    RecyclerViewCompat localRecyclerViewCompat = new RecyclerViewCompat(paramContext);
    localRecyclerViewCompat.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    localRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerViewCompat.setRecycledViewPool(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool);
    localRecyclerViewCompat.addOnItemTouchListener(new txm(this));
    paramContext = new bial();
    tws localtws = new tws(this.jdField_a_of_type_Txe, paramContext);
    localtws.a(this);
    localtws.a(this.jdField_a_of_type_JavaUtilHashMap);
    localRecyclerViewCompat.setAdapter(localtws);
    paramContext.c(1);
    paramContext.a(localRecyclerViewCompat);
    return localRecyclerViewCompat;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)) {
      if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b()) && ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a == null) || (!this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a.b()))) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.getParent() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.getParent().getParent() != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.getParent().getParent().requestDisallowInterceptTouchEvent(bool);
      }
      return false;
    }
  }
  
  public void S_() {}
  
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
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      paramViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) && (paramViewHolder.getAdapterPosition() == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.getAdapterPosition()))
      {
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged: same viewholder return");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.c();
      }
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)b().get(paramViewHolder.getAdapterPosition());
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = txn.a((txn)paramViewHolder);
      RecyclerView.ViewHolder localViewHolder = a(((txn)paramViewHolder).a);
      if (this.jdField_a_of_type_Twv != null) {
        this.jdField_a_of_type_Twv.a(localViewHolder);
      }
      if ((this.b.get(Integer.valueOf(paramViewHolder.hashCode())) != null) && (((Boolean)this.b.get(Integer.valueOf(paramViewHolder.hashCode()))).booleanValue()))
      {
        ((txn)paramViewHolder).a().notifyDataSetChanged();
        this.b.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(false));
      }
      if ((localViewHolder instanceof twt)) {
        if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.d != null)) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.d.setText(String.format("1/%s", new Object[] { Integer.valueOf(localStFeed.images.size()) }));
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
        QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onPagerChanged:" + paramViewHolder.hashCode());
        return;
        if ((localViewHolder instanceof twu))
        {
          ((twu)localViewHolder).a.setOperationView(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
          if ((paramViewHolder.getAdapterPosition() == 0) && (this.jdField_a_of_type_Long != 0L))
          {
            ((twu)localViewHolder).a.setInitialPosition(this.jdField_a_of_type_Long);
            this.jdField_a_of_type_Long = 0L;
          }
          ((twu)localViewHolder).a.setVideoPath(localStFeed.video.fileId.get(), null, localStFeed.video.playUrl.get(), localStFeed.video.fileSize.get(), localStFeed.video.duration.get(), 0);
        }
      }
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
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
      if (i < b().size())
      {
        if (((FeedCloudMeta.StFeed)b().get(i)).id.get().equals(paramString))
        {
          b().remove(i);
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
    return c();
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new txl(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)b().get(paramInt);
    ((txn)paramViewHolder).a().a(localStFeed, paramInt);
    txn.a((txn)paramViewHolder).setExtraTypeInfo(a());
    txn.a((txn)paramViewHolder).setData(localStFeed);
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new txn(this, a(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (this.jdField_a_of_type_Bial != null) {
      this.jdField_a_of_type_Bial.a(null);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
    }
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    this.jdField_a_of_type_Txe = null;
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
    this.b.put(Integer.valueOf(paramViewHolder.hashCode()), Boolean.valueOf(true));
    QLog.d("QCircleContentVerticalAdapter", 1, "QCircleContentVerticalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txk
 * JD-Core Version:    0.7.0.1
 */