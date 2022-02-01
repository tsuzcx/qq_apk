import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.1;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public abstract class vae
  extends RecyclerView.Adapter
{
  protected int a;
  protected RecyclerView a;
  protected QCircleBaseWidgetView a;
  protected FeedCloudMeta.StFeed a;
  protected List<QQCircleDitto.StItemInfo> a;
  protected QQCircleDitto.StItemContainer a;
  
  public vae()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new QCircleRecommendBaseAdapter.1(this), 500L);
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer != null))
    {
      FeedCloudMeta.StDittoFeed localStDittoFeed = new FeedCloudMeta.StDittoFeed();
      localStDittoFeed.dittoId.set(paramInt);
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.set(this.jdField_a_of_type_JavaUtilList);
      localStDittoFeed.dittoData.set(ByteStringMicro.copyFrom(uzg.a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer).toByteArray()));
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.dittoFeed.set(localStDittoFeed);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView = paramQCircleBaseWidgetView;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    int i;
    if ((paramObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = ((QQCircleDitto.StItemInfo)paramObject).id.get();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label150;
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!(localObject instanceof QQCircleDitto.StItemInfo)) || (!((QQCircleDitto.StItemInfo)localObject).id.get().equals(paramObject))) {
        break label143;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        QLog.d("QCircleTagPageRecommendWidget", 1, "remove data is " + i);
        notifyItemRemoved(i);
        a(paramInt);
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView.setVisibility(8);
        }
      }
      return;
      label143:
      i += 1;
      break;
      label150:
      i = -1;
    }
  }
  
  public void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer = paramStItemContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vae
 * JD-Core Version:    0.7.0.1
 */