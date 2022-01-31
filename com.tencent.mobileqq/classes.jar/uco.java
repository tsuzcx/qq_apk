import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class uco
  extends RecyclerView.Adapter<ucp>
{
  private int jdField_a_of_type_Int;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  tyb jdField_a_of_type_Tyb;
  
  public ucp a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ucp(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560573, paramViewGroup, false));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QQCircleDitto.StItemInfo> paramList)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Tyb != null) {
      this.jdField_a_of_type_Tyb.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void a(ucp paramucp)
  {
    super.onViewAttachedToWindow(paramucp);
    if (this.jdField_a_of_type_Tyb != null) {
      this.jdField_a_of_type_Tyb.a(paramucp);
    }
  }
  
  public void a(ucp paramucp, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      paramucp.a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      paramucp.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      paramucp.a(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_Tyb = new tyb();
    paramRecyclerView.addOnScrollListener(this.jdField_a_of_type_Tyb);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Tyb != null)
    {
      paramRecyclerView.removeOnScrollListener(this.jdField_a_of_type_Tyb);
      this.jdField_a_of_type_Tyb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uco
 * JD-Core Version:    0.7.0.1
 */