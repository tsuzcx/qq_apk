import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class wem
  extends RecyclerView.Adapter<wej>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<wel> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public wem(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter.1(this), 500L);
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  public wej a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wej(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleTimeLineFeedItemView, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560723, paramViewGroup, false));
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<wel> paramList)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      a();
    }
  }
  
  public void a(wej paramwej, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      paramwej.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      paramwej.a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwej, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wem
 * JD-Core Version:    0.7.0.1
 */