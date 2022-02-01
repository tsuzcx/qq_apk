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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class pao
  extends rxs
  implements auwv.c
{
  private auwv.c jdField_a_of_type_Auwv$c;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private final pat jdField_a_of_type_Pat;
  private boolean azf = true;
  private boolean azg;
  private int bgQ;
  private FeedCloudMeta.StFeed mFeed;
  private RecyclerView mRecyclerView;
  
  public pao(rxk paramrxk, auwv paramauwv)
  {
    paramauwv.b(this);
    setHasStableIds(true);
    this.jdField_a_of_type_Pat = ((pat)paramrxk.getViewModel(pat.class));
  }
  
  @NotNull
  private QCircleContentVideo a(Context paramContext)
  {
    paramContext = new QCircleContentVideo(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  private void dF(View paramView)
  {
    if ((this.mFeed == null) || (paramView == null)) {}
    int j;
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    do
    {
      int k;
      do
      {
        return;
        j = this.mFeed.cover.height.get();
        k = this.mFeed.cover.width.get();
      } while ((j <= 0) || (k <= 0));
      i = ImmersiveUtils.getScreenWidth();
      float f = i / k;
      j = (int)(j * f);
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    localLayoutParams.gravity = 17;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    FeedCloudMeta.StFeed localStFeed;
    int i;
    if ((paramViewHolder instanceof pao.a))
    {
      localStFeed = (FeedCloudMeta.StFeed)((pao.a)paramViewHolder).a.getData();
      j = 1;
      i = 1;
    }
    for (;;)
    {
      if (localStFeed == null)
      {
        QLog.e("QCircleReportHelper", 1, "reportContentExpose failed！feed ==null");
        return;
        if ((paramViewHolder instanceof pao.b))
        {
          localStFeed = (FeedCloudMeta.StFeed)((pao.b)paramViewHolder).a.getData();
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
          localArrayList.add(pcr.a("ext1", "1"));
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.bgS != paramViewHolder.getAdapterPosition())) {
            break label276;
          }
          localArrayList.add(pcr.a("ext2", "0"));
          label211:
          localArrayList.add(pcr.a("ext3", localStFeed.images.size() + ""));
        }
        for (;;)
        {
          pcp.a(1, 1, i, j, localStFeed, 2, this.bgQ, str, localArrayList);
          return;
          str = "";
          break;
          label276:
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.bgS > paramViewHolder.getAdapterPosition()))
          {
            localArrayList.add(pcr.a("ext2", "1"));
            break label211;
          }
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.bgS >= paramViewHolder.getAdapterPosition())) {
            break label211;
          }
          localArrayList.add(pcr.a("ext2", "2"));
          break label211;
          label354:
          if (localStFeed.type.get() == 3) {
            localArrayList.add(pcr.a("ext1", "2"));
          }
        }
      }
      i = 0;
      localStFeed = null;
    }
  }
  
  private boolean e(FeedCloudMeta.StFeed paramStFeed)
  {
    return (this.mFeed != null) && (paramStFeed.id.get().equals(this.mFeed.id.get())) && ((g(paramStFeed)) || (f(paramStFeed)));
  }
  
  private boolean f(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 3) && (paramStFeed.video.fileId.get().equals(this.mFeed.video.fileId.get()));
  }
  
  private boolean g(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 2) && (paramStFeed.images.size() == this.mFeed.images.size()) && (paramStFeed.images.size() > 1) && (((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picUrl.get().equals(((FeedCloudMeta.StImage)this.mFeed.images.get(0)).picUrl.get()));
  }
  
  public void a(auwv.c paramc)
  {
    this.jdField_a_of_type_Auwv$c = paramc;
  }
  
  public int getItemCount()
  {
    int j = 1;
    int i = j;
    if (this.mFeed != null)
    {
      i = j;
      if (this.mFeed.type.get() == 2) {
        i = this.mFeed.images.size();
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
    if (this.mFeed != null) {
      paramInt = this.mFeed.type.get();
    }
    return paramInt;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.mRecyclerView = paramRecyclerView;
    if ((this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.mRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mFeed == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    if ((paramViewHolder instanceof pao.a)) {
      if (!auqt.b(paramInt, this.mFeed.images.get()))
      {
        ((pao.a)paramViewHolder).a.setDataPosInList(paramInt);
        ((pao.a)paramViewHolder).a.setData(this.mFeed);
        ((pao.a)paramViewHolder).a.setVerticalPos(this.bgQ);
        if (paramViewHolder.itemView.getVisibility() == 8) {
          paramViewHolder.itemView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
      break;
      if (paramViewHolder.itemView.getVisibility() == 0)
      {
        paramViewHolder.itemView.setVisibility(8);
        continue;
        if ((paramViewHolder instanceof pao.b))
        {
          if (((pao.b)paramViewHolder).a == null)
          {
            QCircleContentVideo localQCircleContentVideo = a(paramViewHolder.itemView.getContext());
            ((FrameLayout)paramViewHolder.itemView).addView(localQCircleContentVideo);
            ((pao.b)paramViewHolder).a = localQCircleContentVideo;
          }
          ((pao.b)paramViewHolder).a.setData(this.mFeed, this.bgQ);
          dF(((pao.b)paramViewHolder).a);
          if ((paramViewHolder.itemView instanceof QCircleDoubleClickLayout))
          {
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).reset();
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).setOnDoubleClickListener(new pap(this));
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
      return new pao.a(paramViewGroup);
    }
    QCircleDoubleClickLayout localQCircleDoubleClickLayout = new QCircleDoubleClickLayout(paramViewGroup.getContext());
    localQCircleDoubleClickLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localQCircleDoubleClickLayout.addView(a(paramViewGroup.getContext()));
    return new pao.b(localQCircleDoubleClickLayout);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
  }
  
  public void onFooterRebound() {}
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView;
    if (this.mFeed != null) {
      if ((this.mFeed.type.get() == 2) && ((paramViewHolder instanceof pao.a)))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(paramViewHolder.getAdapterPosition(), this.mFeed.images.size());
        }
        localView = paramViewHolder.itemView;
        if (paramViewHolder.getAdapterPosition() < this.mFeed.images.size()) {
          break label166;
        }
      }
    }
    label166:
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if (!this.azg) {
        rwv.a().a(new QCircleFeedPicPositionEvent(this.mFeed.id.get(), paramViewHolder.getAdapterPosition()));
      }
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onPagerChanged:" + paramViewHolder.hashCode());
      if (this.jdField_a_of_type_Pat != null) {
        this.jdField_a_of_type_Pat.f(paramViewHolder);
      }
      return;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    e(paramViewHolder);
    if ((this.jdField_a_of_type_Auwv$c != null) && (this.azf))
    {
      this.jdField_a_of_type_Auwv$c.onPagerChanged(null);
      this.azf = false;
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewAttachedToWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof pao.b)) && (((pao.b)paramViewHolder).a != null))
    {
      ((pao.b)paramViewHolder).a.stop();
      ((pao.b)paramViewHolder).a.showCover();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewDetachedFromWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof pao.b)) && ((paramViewHolder.itemView instanceof FrameLayout)) && (((pao.b)paramViewHolder).a != null))
    {
      ((pao.b)paramViewHolder).a.release();
      ((pao.b)paramViewHolder).a = null;
      ((FrameLayout)paramViewHolder.itemView).removeAllViews();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.mFeed = paramStFeed;
    this.bgQ = paramInt;
    if ((paramInt == 0) && (e(paramStFeed))) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void setOperationView(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = paramQCircleContentOperationView;
  }
  
  public void vn(int paramInt)
  {
    if (this.mRecyclerView != null)
    {
      this.azg = true;
      this.mRecyclerView.getViewTreeObserver().addOnPreDrawListener(new paq(this, paramInt));
    }
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    QCircleContentImage jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage;
    
    public a(View paramView)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage = ((QCircleContentImage)paramView);
    }
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    QCircleContentVideo jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo;
    
    public b(View paramView)
    {
      super();
      this$1 = ((FrameLayout)paramView).getChildAt(0);
      if ((pao.this instanceof QCircleContentVideo))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentVideo = ((QCircleContentVideo)pao.this);
        return;
      }
      ((FrameLayout)paramView).removeAllViews();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pao
 * JD-Core Version:    0.7.0.1
 */