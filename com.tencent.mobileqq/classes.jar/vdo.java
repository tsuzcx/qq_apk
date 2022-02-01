import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.LightInteractListAdapter.1;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;

public class vdo
  extends vbl<FeedCloudMeta.StLightInteractInfo>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  
  public vdo(vdj paramvdj, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new QCircleLightInteractListPart.LightInteractListAdapter.1(this));
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  protected String a()
  {
    return "LightInteractListAdapter";
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
  
  public int getItemViewType(int paramInt)
  {
    return vdj.a(this.jdField_a_of_type_Vdj);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList.size() > paramInt) && ((paramViewHolder instanceof vdp))) {
      ((vdp)paramViewHolder).a(this.jdField_a_of_type_Vdj.a, this.mDataList.get(paramInt), paramInt, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, vdj.a(this.jdField_a_of_type_Vdj));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 4))
    {
      paramViewGroup = new QCircleLightInteractPolyLikeWidget(getContext(), paramInt);
      paramViewGroup.setReportBeanAgent(this.jdField_a_of_type_Vdj);
      return new vdp(this.jdField_a_of_type_Vdj, paramViewGroup);
    }
    paramViewGroup = new QCircleLightInteractPushWidget(getContext(), paramInt);
    paramViewGroup.setReportBeanAgent(this.jdField_a_of_type_Vdj);
    return new vdp(this.jdField_a_of_type_Vdj, paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */