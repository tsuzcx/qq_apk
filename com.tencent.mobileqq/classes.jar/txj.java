import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class txj
  extends yhw
  implements biex
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private biex jdField_a_of_type_Biex;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final txq jdField_a_of_type_Txq;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public txj(tvv paramtvv, bies parambies)
  {
    parambies.a(this);
    setHasStableIds(true);
    this.jdField_a_of_type_Txq = ((txq)paramtvv.a(txq.class));
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
    FeedCloudMeta.StFeed localStFeed;
    int i;
    if ((paramViewHolder instanceof txm))
    {
      localStFeed = (FeedCloudMeta.StFeed)((txm)paramViewHolder).a.a();
      j = 1;
      i = 1;
    }
    for (;;)
    {
      if (localStFeed == null)
      {
        QLog.e("QCircleReportHelper", 1, "reportContentExpose failed！feed ==null");
        return;
        if ((paramViewHolder instanceof txn))
        {
          localStFeed = (FeedCloudMeta.StFeed)((txn)paramViewHolder).a.a();
          j = 2;
          i = 1;
        }
      }
      else
      {
        String str;
        ArrayList localArrayList;
        if ((localStFeed.type.get() == 2) && (localStFeed.images.size() > paramViewHolder.getAdapterPosition()))
        {
          str = ((FeedCloudMeta.StImage)localStFeed.images.get(paramViewHolder.getAdapterPosition())).picId.get() + "";
          localArrayList = new ArrayList();
          if (localStFeed.type.get() != 2) {
            break label354;
          }
          localArrayList.add(tzy.a("ext1", "1"));
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b != paramViewHolder.getAdapterPosition())) {
            break label276;
          }
          localArrayList.add(tzy.a("ext2", "0"));
          label211:
          localArrayList.add(tzy.a("ext3", localStFeed.images.size() + ""));
        }
        for (;;)
        {
          tzw.a(1, 1, i, j, localStFeed, 2, this.jdField_a_of_type_Int, str, localArrayList);
          return;
          str = "";
          break;
          label276:
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b > paramViewHolder.getAdapterPosition()))
          {
            localArrayList.add(tzy.a("ext2", "1"));
            break label211;
          }
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b >= paramViewHolder.getAdapterPosition())) {
            break label211;
          }
          localArrayList.add(tzy.a("ext2", "2"));
          break label211;
          label354:
          if (localStFeed.type.get() == 3) {
            localArrayList.add(tzy.a("ext1", "2"));
          }
        }
      }
      i = 0;
      localStFeed = null;
    }
  }
  
  private boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 3) && (paramStFeed.video.fileId.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.fileId.get()));
  }
  
  private boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 2) && (paramStFeed.images.size() == this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size()) && (paramStFeed.images.size() > 1) && (((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picUrl.get().equals(((FeedCloudMeta.StImage)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get(0)).picUrl.get()));
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.b = true;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().addOnPreDrawListener(new txl(this, paramInt));
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2) && ((paramViewHolder instanceof txm)))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(paramViewHolder.getAdapterPosition(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size());
        }
        localView = paramViewHolder.itemView;
        if (paramViewHolder.getAdapterPosition() < this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size()) {
          break label166;
        }
      }
    }
    label166:
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if (!this.b) {
        yiw.a().a(new QCircleFeedPicPositionEvent(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramViewHolder.getAdapterPosition()));
      }
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onPagerChanged:" + paramViewHolder.hashCode());
      if (this.jdField_a_of_type_Txq != null) {
        this.jdField_a_of_type_Txq.a(paramViewHolder);
      }
      return;
    }
  }
  
  public void a(biex parambiex)
  {
    this.jdField_a_of_type_Biex = parambiex;
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
  
  public int getItemCount()
  {
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      i = j;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2) {
        i = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size();
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
    if ((paramViewHolder instanceof txm)) {
      if (!bhrz.a(paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get()))
      {
        ((txm)paramViewHolder).a.setDataPosInList(paramInt);
        ((txm)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        ((txm)paramViewHolder).a.setVerticalPos(this.jdField_a_of_type_Int);
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
        if ((paramViewHolder instanceof txn))
        {
          if (((txn)paramViewHolder).a == null)
          {
            QCircleContentVideo localQCircleContentVideo = a(paramViewHolder.itemView.getContext());
            ((FrameLayout)paramViewHolder.itemView).addView(localQCircleContentVideo);
            ((txn)paramViewHolder).a = localQCircleContentVideo;
          }
          ((txn)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
          a(((txn)paramViewHolder).a);
          if ((paramViewHolder.itemView instanceof QCircleDoubleClickLayout))
          {
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).a();
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).setOnDoubleClickListener(new txk(this));
          }
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
      return new txm(this, paramViewGroup);
    }
    QCircleDoubleClickLayout localQCircleDoubleClickLayout = new QCircleDoubleClickLayout(paramViewGroup.getContext());
    localQCircleDoubleClickLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localQCircleDoubleClickLayout.addView(a(paramViewGroup.getContext()));
    return new txn(this, localQCircleDoubleClickLayout);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    b(paramViewHolder);
    if ((this.jdField_a_of_type_Biex != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Biex.a(null);
      this.jdField_a_of_type_Boolean = false;
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewAttachedToWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof txn)) && (((txn)paramViewHolder).a != null))
    {
      ((txn)paramViewHolder).a.h();
      ((txn)paramViewHolder).a.g();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewDetachedFromWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof txn)) && ((paramViewHolder.itemView instanceof FrameLayout)) && (((txn)paramViewHolder).a != null))
    {
      ((txn)paramViewHolder).a.a();
      ((txn)paramViewHolder).a = null;
      ((FrameLayout)paramViewHolder.itemView).removeAllViews();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txj
 * JD-Core Version:    0.7.0.1
 */