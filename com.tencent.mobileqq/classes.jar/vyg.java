import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.QCircleRecommendAdapter.1;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class vyg
  extends RecyclerView.Adapter<vyh>
  implements zwr
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<QQCircleDitto.StItemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  vqy jdField_a_of_type_Vqy;
  private int jdField_b_of_type_Int;
  private QCircleRecommendWidget jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget;
  
  public vyg(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  private List<QQCircleDitto.StItemInfo> a(List<QQCircleDitto.StItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
        if ((localStItemInfo != null) && (localStItemInfo.buttonInfo.buttonValue.get() == 0) && (!vof.a().b(localStItemInfo.id.get()))) {
          localArrayList.add(localStItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new QCircleRecommendWidget.QCircleRecommendAdapter.1(this), 500L);
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      FeedCloudMeta.StDittoFeed localStDittoFeed = new FeedCloudMeta.StDittoFeed();
      localStDittoFeed.dittoId.set(1);
      QCircleRecommendWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget).items.set(this.jdField_a_of_type_JavaUtilList);
      localStDittoFeed.dittoData.set(ByteStringMicro.copyFrom(uxx.a(QCircleRecommendWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget)).toByteArray()));
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.dittoFeed.set(localStDittoFeed);
    }
  }
  
  public vyh a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return new vyh(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560777, paramViewGroup, false));
    case 50001: 
      return new vyh(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560776, paramViewGroup, false));
    }
    return new vyh(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560775, paramViewGroup, false));
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleRecommendWidget paramQCircleRecommendWidget)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget = paramQCircleRecommendWidget;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, List<QQCircleDitto.StItemInfo> paramList, int paramInt2)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Vqy != null) {
      this.jdField_a_of_type_Vqy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(a(paramList));
      paramStFeed = this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label99;
      }
    }
    label99:
    for (paramInt1 = 8;; paramInt1 = 0)
    {
      paramStFeed.setVisibility(paramInt1);
      a();
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    int i;
    if ((paramObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = ((QQCircleDitto.StItemInfo)paramObject).id.get();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label146;
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!(localObject instanceof QQCircleDitto.StItemInfo)) || (!((QQCircleDitto.StItemInfo)localObject).id.get().equals(paramObject))) {
        break label139;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        QLog.d("QCircleRecommendWidget", 4, "remove index: " + i);
        this.jdField_a_of_type_JavaUtilList.remove(i);
        notifyItemRemoved(i);
        b();
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget.setVisibility(8);
        }
      }
      return;
      label139:
      i += 1;
      break;
      label146:
      i = -1;
    }
  }
  
  public void a(vyh paramvyh)
  {
    super.onViewAttachedToWindow(paramvyh);
    if (this.jdField_a_of_type_Vqy != null) {
      this.jdField_a_of_type_Vqy.a(paramvyh);
    }
    zwp.a().a(this);
  }
  
  public void a(vyh paramvyh, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      paramvyh.a(this);
      paramvyh.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      paramvyh.a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_b_of_type_Int);
      paramvyh.a(this.jdField_a_of_type_Int);
      paramvyh.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget.d());
      paramvyh.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget.a());
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramvyh, paramInt, getItemId(paramInt));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vqy == null) {
      this.jdField_a_of_type_Vqy = new vqy();
    }
    this.jdField_a_of_type_Vqy.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget.d());
    this.jdField_a_of_type_Vqy.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget.a());
    paramRecyclerView.addOnScrollListener(this.jdField_a_of_type_Vqy);
    zwp.a().b(this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vqy != null)
    {
      paramRecyclerView.removeOnScrollListener(this.jdField_a_of_type_Vqy);
      this.jdField_a_of_type_Vqy.a();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mFollowStatus == 1)
      {
        QLog.d("QCircleRecommendWidget", 4, "remove from recevive: ");
        paramSimpleBaseEvent = paramSimpleBaseEvent.mUserId;
        QQCircleDitto.StItemInfo localStItemInfo = new QQCircleDitto.StItemInfo();
        localStItemInfo.id.set(paramSimpleBaseEvent);
        a(localStItemInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyg
 * JD-Core Version:    0.7.0.1
 */