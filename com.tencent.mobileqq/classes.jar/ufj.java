import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.QCircleRecommendAdapter.1;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class ufj
  extends RecyclerView.Adapter<ufk>
  implements yiy
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<QQCircleDitto.StItemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  tzn jdField_a_of_type_Tzn;
  private QCircleRecommendWidget b;
  
  public ufj(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
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
      localStDittoFeed.dittoData.set(ByteStringMicro.copyFrom(tra.a(QCircleRecommendWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget)).toByteArray()));
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.dittoFeed.set(localStDittoFeed);
    }
  }
  
  public ufk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ufk(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560589, paramViewGroup, false));
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleRecommendWidget paramQCircleRecommendWidget)
  {
    this.b = paramQCircleRecommendWidget;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QQCircleDitto.StItemInfo> paramList)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Tzn != null) {
      this.jdField_a_of_type_Tzn.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      paramStFeed = this.b;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label89;
      }
    }
    label89:
    for (paramInt = 8;; paramInt = 0)
    {
      paramStFeed.setVisibility(paramInt);
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
          this.b.setVisibility(8);
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
  
  public void a(ufk paramufk)
  {
    super.onViewAttachedToWindow(paramufk);
    if (this.jdField_a_of_type_Tzn != null) {
      this.jdField_a_of_type_Tzn.a(paramufk);
    }
    yiw.a().a(this);
  }
  
  public void a(ufk paramufk, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      paramufk.a(this);
      paramufk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      paramufk.a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      paramufk.a(this.jdField_a_of_type_Int);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramufk.itemView.getLayoutParams();
      if ((paramInt > 0) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size() - 1)) {
        localLayoutParams.setMargins(azkz.a(-10.0F), 0, 0, 0);
      }
      paramufk.itemView.setLayoutParams(localLayoutParams);
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
    this.jdField_a_of_type_Tzn = new tzn();
    paramRecyclerView.addOnScrollListener(this.jdField_a_of_type_Tzn);
    yiw.a().b(this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Tzn != null)
    {
      paramRecyclerView.removeOnScrollListener(this.jdField_a_of_type_Tzn);
      this.jdField_a_of_type_Tzn.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufj
 * JD-Core Version:    0.7.0.1
 */