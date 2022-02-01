import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
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

public class vjn
  extends zxx<FeedCloudMeta.StFeed>
  implements bksj, zxl<QCircleReportBean>
{
  private int jdField_a_of_type_Int;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bksj jdField_a_of_type_Bksj;
  private QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final vkb jdField_a_of_type_Vkb;
  private vks jdField_a_of_type_Vks;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public vjn(vks paramvks, bkse parambkse)
  {
    parambkse.a(this);
    setHasStableIds(true);
    this.jdField_a_of_type_Vkb = ((vkb)paramvks.a(vkb.class));
    this.jdField_a_of_type_Vks = paramvks;
  }
  
  @NotNull
  private QCircleContentVideo a(Context paramContext)
  {
    paramContext = new QCircleContentVideo(paramContext);
    paramContext.setPlayScene(this.jdField_a_of_type_Vks.a().mPlayScene);
    paramContext.setReportBean(a());
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
    if ((paramViewHolder instanceof vjs))
    {
      localStFeed = (FeedCloudMeta.StFeed)((vjs)paramViewHolder).a.a();
      j = 1;
      i = 1;
    }
    for (;;)
    {
      if (localStFeed == null)
      {
        QLog.e("QCircleReportHelper", 1, "reportContentExpose failed！feed ==null");
        return;
        if ((paramViewHolder instanceof vjt))
        {
          localStFeed = (FeedCloudMeta.StFeed)((vjt)paramViewHolder).a.a();
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
            break label437;
          }
          localArrayList.add(vri.a("ext1", "1"));
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b != paramViewHolder.getAdapterPosition())) {
            break label358;
          }
          localArrayList.add(vri.a("ext2", "0"));
          label211:
          localArrayList.add(vri.a("ext3", localStFeed.images.size() + ""));
          label250:
          if (!QCircleContentImmersiveEvent.isImmersive()) {
            break label468;
          }
        }
        label437:
        label468:
        for (paramViewHolder = "2";; paramViewHolder = "1")
        {
          localArrayList.add(vri.a("ext4", paramViewHolder));
          vrg.a(1, 1, i, j, localStFeed, this.jdField_a_of_type_Vks.a().mPlayScene, this.jdField_a_of_type_Int, str, localArrayList, b());
          vrr.a().a(new vrt().a("content").b("impression").a(localStFeed).a(a()).a(this.jdField_a_of_type_Int));
          return;
          str = "";
          break;
          label358:
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b > paramViewHolder.getAdapterPosition()))
          {
            localArrayList.add(vri.a("ext2", "1"));
            break label211;
          }
          if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.b >= paramViewHolder.getAdapterPosition())) {
            break label211;
          }
          localArrayList.add(vri.a("ext2", "2"));
          break label211;
          if (localStFeed.type.get() != 3) {
            break label250;
          }
          localArrayList.add(vri.a("ext1", "2"));
          break label250;
        }
      }
      i = 0;
      localStFeed = null;
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 3) && (paramStFeed.video.fileId.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.fileId.get()));
  }
  
  private boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 2) && (paramStFeed.images.size() == this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.size()) && (paramStFeed.images.size() > 1) && (((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picUrl.get().equals(((FeedCloudMeta.StImage)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get(0)).picUrl.get()));
  }
  
  protected int a()
  {
    return QCircleReportBean.getPageId("QCircleContentHorizontalAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public RecyclerView.ViewHolder a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleContentHorizontalAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.b = true;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().addOnPreDrawListener(new vjr(this, paramInt));
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2) && ((paramViewHolder instanceof vjs)))
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.setCurPicPos(paramViewHolder.getAdapterPosition(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get());
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
        zwp.a().a(new QCircleFeedPicPositionEvent(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramViewHolder.getAdapterPosition()));
      }
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onPagerChanged:" + paramViewHolder.hashCode());
      if (this.jdField_a_of_type_Vkb != null) {
        this.jdField_a_of_type_Vkb.a(paramViewHolder);
      }
      return;
    }
  }
  
  public void a(bksj parambksj)
  {
    this.jdField_a_of_type_Bksj = parambksj;
  }
  
  public void a(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = paramQCircleContentOperationView;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleContentHorizontalAdapter", paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if ((paramInt == 0) && (a(paramStFeed)))
    {
      b(paramStFeed, paramInt);
      return;
    }
    b(paramStFeed, paramInt);
    notifyDataSetChanged();
  }
  
  protected int b()
  {
    return QCircleReportBean.getParentPageId("QCircleContentHorizontalAdapter", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
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
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    if ((paramViewHolder instanceof vjs)) {
      if (!bkfj.a(paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get()))
      {
        ((vjs)paramViewHolder).a.setDataPosInList(paramInt);
        ((vjs)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        ((vjs)paramViewHolder).a.setVerticalPos(this.jdField_a_of_type_Int);
        if (paramViewHolder.itemView.getVisibility() == 8) {
          paramViewHolder.itemView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onBindViewHolder:" + paramViewHolder.hashCode());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
      break;
      if (paramViewHolder.itemView.getVisibility() == 0)
      {
        paramViewHolder.itemView.setVisibility(8);
        continue;
        if ((paramViewHolder instanceof vjt))
        {
          if (((vjt)paramViewHolder).a == null)
          {
            QCircleContentVideo localQCircleContentVideo = a(paramViewHolder.itemView.getContext());
            ((FrameLayout)paramViewHolder.itemView).addView(localQCircleContentVideo);
            ((vjt)paramViewHolder).a = localQCircleContentVideo;
          }
          ((vjt)paramViewHolder).a.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
          a(((vjt)paramViewHolder).a);
          if ((paramViewHolder.itemView instanceof QCircleDoubleClickLayout))
          {
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).a();
            ((QCircleDoubleClickLayout)paramViewHolder.itemView).setOnDoubleClickListener(new vjq(this));
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
      paramViewGroup.setPlayScene(this.jdField_a_of_type_Vks.a().mPlayScene);
      paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
      paramViewGroup.setReportBean(a());
      return new vjs(this, paramViewGroup);
    }
    QCircleDoubleClickLayout localQCircleDoubleClickLayout = new QCircleDoubleClickLayout(paramViewGroup.getContext());
    localQCircleDoubleClickLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localQCircleDoubleClickLayout.setOnTapClickListener(new vjo(this));
    localQCircleDoubleClickLayout.setOnLongClickListener(new vjp(this, paramViewGroup));
    localQCircleDoubleClickLayout.addView(a(paramViewGroup.getContext()));
    return new vjt(this, localQCircleDoubleClickLayout);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = null;
    paramRecyclerView.removeCallbacks(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    b(paramViewHolder);
    if ((this.jdField_a_of_type_Bksj != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Bksj.a(null);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewAttachedToWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof vjt)) && (((vjt)paramViewHolder).a != null))
    {
      ((vjt)paramViewHolder).a.k();
      ((vjt)paramViewHolder).a.j();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewDetachedFromWindow:" + paramViewHolder.hashCode());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if (((paramViewHolder instanceof vjt)) && ((paramViewHolder.itemView instanceof FrameLayout)) && (((vjt)paramViewHolder).a != null))
    {
      ((vjt)paramViewHolder).a.b();
      ((vjt)paramViewHolder).a = null;
      ((FrameLayout)paramViewHolder.itemView).removeAllViews();
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "QCircleContentHorizontalAdapter onViewRecycled:" + paramViewHolder.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjn
 * JD-Core Version:    0.7.0.1
 */