import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.bizparts.QCirclePolyListPart.PolyListAdapter.1;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;

public class tte
  extends yhy<FeedCloudMeta.StLightInteractInfo>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  
  public tte(tsw paramtsw, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCirclePolyListPart.PolyListAdapter.1(this));
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  public ttb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ttb(this.jdField_a_of_type_Tsw, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560575, paramViewGroup, false));
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(List<FeedCloudMeta.StLightInteractInfo> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), paramList);
    a();
  }
  
  public void a(List<FeedCloudMeta.StLightInteractInfo> paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
    if (paramList != null)
    {
      this.mDataList.clear();
      a();
      this.mDataList.addAll(paramList);
      a();
    }
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getViewTypeCount()
  {
    return 0;
  }
  
  public void loadData(yii paramyii) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList.size() > paramInt) {
      ((ttb)paramViewHolder).a((FeedCloudMeta.StLightInteractInfo)this.mDataList.get(paramInt), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tte
 * JD-Core Version:    0.7.0.1
 */