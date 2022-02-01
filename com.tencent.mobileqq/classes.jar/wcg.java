import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class wcg
  extends vae
{
  public wcg(QCircleTagRecommendWidget paramQCircleTagRecommendWidget) {}
  
  public wch a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wch(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560813, paramViewGroup, false));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QQCircleDitto.StItemInfo> paramList)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(vwk.b(paramList));
      paramStFeed = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseWidgetView;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label140;
      }
    }
    label140:
    for (paramInt = 8;; paramInt = 0)
    {
      paramStFeed.setVisibility(paramInt);
      a();
      QLog.d("QCircleTagPageRecommendWidget", 4, "stItemInfos size = " + paramList.size());
      QLog.d("QCircleTagPageRecommendWidget", 4, "mDatas size = " + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > paramInt) && ((paramViewHolder instanceof wch)))
    {
      Object localObject = (wch)paramViewHolder;
      ((wch)localObject).a(this);
      ((wch)localObject).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      ((wch)localObject).a(this.jdField_a_of_type_Int);
      ((wch)localObject).b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagRecommendWidget.d());
      ((wch)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagRecommendWidget.a());
      ((wch)localObject).a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      localObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(vtt.a("ext1", ((QQCircleDitto.StItemInfo)localObject).name.get()));
      localArrayList.add(vtt.a("ext2", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()));
      localArrayList.add(vtt.a("ext3", (String)((QQCircleDitto.StItemInfo)localObject).des.get().get(0)));
      localArrayList.add(vtt.a("ext4", ((QQCircleDitto.StItemInfo)localObject).id.get()));
      vtn.a(((QQCircleDitto.StItemInfo)localObject).id.get(), 3, 3, 96, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, localArrayList, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagRecommendWidget.d(), -1);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcg
 * JD-Core Version:    0.7.0.1
 */