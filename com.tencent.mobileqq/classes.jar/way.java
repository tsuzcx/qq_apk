import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePYMKRecommendWidget;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class way
  extends vae
  implements aaam
{
  protected vtj a;
  private int b;
  
  public way(QCirclePYMKRecommendWidget paramQCirclePYMKRecommendWidget) {}
  
  public waz a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (this.b)
    {
    default: 
      return new waz(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560802, paramViewGroup, false));
    case 50001: 
      return new waz(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560801, paramViewGroup, false));
    }
    return new waz(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560800, paramViewGroup, false));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, List<QQCircleDitto.StItemInfo> paramList, int paramInt2)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (this.jdField_a_of_type_Vtj == null) {
      this.jdField_a_of_type_Vtj = new vtj();
    }
    this.jdField_a_of_type_Vtj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Vtj.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePYMKRecommendWidget.d());
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(vwk.a(paramList));
      paramStFeed = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label130;
      }
    }
    label130:
    for (paramInt1 = 8;; paramInt1 = 0)
    {
      paramStFeed.setVisibility(paramInt1);
      a();
      return;
    }
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
    if (this.jdField_a_of_type_Vtj == null) {
      this.jdField_a_of_type_Vtj = new vtj();
    }
    paramRecyclerView.addOnScrollListener(this.jdField_a_of_type_Vtj);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > paramInt) && ((paramViewHolder instanceof waz)))
    {
      waz localwaz = (waz)paramViewHolder;
      localwaz.a(this);
      localwaz.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      localwaz.a(this.jdField_a_of_type_Int);
      localwaz.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePYMKRecommendWidget.a());
      localwaz.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePYMKRecommendWidget.d());
      localwaz.a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.b);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vtj != null)
    {
      paramRecyclerView.removeOnScrollListener(this.jdField_a_of_type_Vtj);
      this.jdField_a_of_type_Vtj.a();
    }
    aaak.a().b(this);
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
        a(localStItemInfo, 1);
      }
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((this.jdField_a_of_type_Vtj != null) && ((paramViewHolder instanceof waz))) {
      this.jdField_a_of_type_Vtj.a((waz)paramViewHolder);
    }
    aaak.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     way
 * JD-Core Version:    0.7.0.1
 */