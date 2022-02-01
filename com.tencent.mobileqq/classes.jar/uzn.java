import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class uzn
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private aakb jdField_a_of_type_Aakb;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<vbc> jdField_a_of_type_JavaUtilList;
  
  public void a(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, List<vbc> paramList, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return ((vbc)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      ((uzp)paramViewHolder).a((vbc)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Int, paramInt, this.jdField_a_of_type_Aakb);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new uzp(new QCircleReplyItemView(paramViewGroup.getContext()), null);
    }
    return new uzp(new QCircleMoreReplyItemView(paramViewGroup.getContext()), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzn
 * JD-Core Version:    0.7.0.1
 */