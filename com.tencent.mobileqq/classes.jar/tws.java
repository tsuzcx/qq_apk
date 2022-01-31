import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class tws
  extends ydn
  implements biaq
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private biaq jdField_a_of_type_Biaq;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private final twv jdField_a_of_type_Twv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public tws(tvg paramtvg, bial parambial)
  {
    parambial.a(this);
    setHasStableIds(true);
    this.jdField_a_of_type_Twv = ((twv)paramtvg.a(twv.class));
  }
  
  @NotNull
  private QCircleContentVideo a(Context paramContext)
  {
    paramContext = new QCircleContentVideo(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (paramView == null)) {}
    int j;
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    do
    {
      int k;
      do
      {
        return;
        j = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.cover.height.get();
        k = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.cover.width.get();
      } while ((j <= 0) || (k <= 0));
      i = ImmersiveUtils.a();
      float f = i / k;
      j = (int)(j * f);
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    localLayoutParams.gravity = 17;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    return (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (paramStFeed.id.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())) && ((c(paramStFeed)) || (b(paramStFeed)));
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    int i;
    if ((paramViewHolder instanceof twt))
    {
      paramViewHolder = (FeedCloudMeta.StFeed)((twt)paramViewHolder).a.a();
      j = 1;
      i = 1;
    }
    for (;;)
    {
      if (paramViewHolder == null)
      {
        QLog.e("QCircleReportHelper", 1, "reportContentExpose failed！feed ==null");
        return;
        if ((paramViewHolder instanceof twu))
        {
          paramViewHolder = (FeedCloudMeta.StFeed)((twu)paramViewHolder).a.a();
          j = 2;
          i = 1;
        }
      }
      else
      {
        tyk.a(1, 1, i, j, paramViewHolder, 2, this.jdField_a_of_type_Int + 1);
        return;
      }
      i = 0;
      paramViewHolder = null;
    }
  }
  
  private boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 3) && (paramStFeed.video.fileId.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.fileId.get()));
  }
  
  private boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 2) && (paramStFeed.images.size() == this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size());
  }
  
  public void S_() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = 0;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2) && ((paramViewHolder instanceof twt)))
      {
        if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.d != null)) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.d.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramViewHolder.getAdapterPosition() + 1), Integer.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size()) }));
        }
        View localView = paramViewHolder.itemView;
        if (paramViewHolder.getAdapterPosition() >= this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size()) {
          i = 8;
        }
        localView.setVisibility(i);
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(paramViewHolder.getAdapterPosition()));
      }
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onPagerChanged:" + paramViewHolder.hashCode());
    }
  }
  
  public void a(biaq parambiaq)
  {
    this.jdField_a_of_type_Biaq = parambiaq;
  }
  
  public void a(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = paramQCircleContentOperationView;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) && (a(paramStFeed))) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void a(HashMap<String, Integer> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public int getItemCount()
  {
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      i = j;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2) {
        i = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size() + 1;
      }
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = 0;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      paramInt = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get();
    }
    return paramInt;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {
      return;
    }
    if ((paramViewHolder instanceof twt)) {
      if (!bhns.a(paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get()))
      {
        ((twt)paramViewHolder).a.setDataPosInList(paramInt);
        ((twt)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        if (paramViewHolder.itemView.getVisibility() == 8) {
          paramViewHolder.itemView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
      return;
      if (paramViewHolder.itemView.getVisibility() == 0)
      {
        paramViewHolder.itemView.setVisibility(8);
        continue;
        if ((paramViewHolder instanceof twu))
        {
          if (((twu)paramViewHolder).a == null)
          {
            QCircleContentVideo localQCircleContentVideo = a(paramViewHolder.itemView.getContext());
            ((FrameLayout)paramViewHolder.itemView).addView(localQCircleContentVideo);
            ((twu)paramViewHolder).a = localQCircleContentVideo;
          }
          ((twu)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
          a(((twu)paramViewHolder).a);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = new QCircleContentImage(paramViewGroup.getContext());
      paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
      return new twt(this, paramViewGroup);
    }
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localFrameLayout.addView(a(paramViewGroup.getContext()));
    return new twu(this, localFrameLayout);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    b(paramViewHolder);
    if (this.jdField_a_of_type_Twv != null) {
      this.jdField_a_of_type_Twv.a(paramViewHolder);
    }
    if ((this.jdField_a_of_type_Biaq != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Biaq.a(null);
      this.jdField_a_of_type_Boolean = false;
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewAttachedToWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof twu)) && (((twu)paramViewHolder).a != null))
    {
      ((twu)paramViewHolder).a.g();
      ((twu)paramViewHolder).a.f();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewDetachedFromWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof BaseWidgetView)) {
      ((BaseWidgetView)paramViewHolder.itemView).a();
    }
    if (((paramViewHolder instanceof twu)) && ((paramViewHolder.itemView instanceof FrameLayout)) && (((twu)paramViewHolder).a != null))
    {
      ((twu)paramViewHolder).a.a();
      ((twu)paramViewHolder).a = null;
      ((FrameLayout)paramViewHolder.itemView).removeAllViews();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tws
 * JD-Core Version:    0.7.0.1
 */