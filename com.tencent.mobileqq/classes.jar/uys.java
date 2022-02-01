import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;

public class uys
  extends uzx
{
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private QQCircleDitto.StCircleDittoDataNew jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew;
  private vtz jdField_a_of_type_Vtz;
  
  public uys(Bundle paramBundle)
  {
    super(paramBundle);
    a(false);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    paramViewGroup = new QCirclePushRankTopView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    return paramViewGroup;
  }
  
  protected String a()
  {
    return "QCircleRankTopBlock";
  }
  
  public void a(vtz paramvtz, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Vtz = paramvtz;
    this.jdField_a_of_type_Vtz.a().observe(paramLifecycleOwner, new uyt(this));
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((a() != null) && ((a() instanceof QCirclePushRankTopView)))
    {
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiReport != null)) {
        ((QCirclePushRankTopView)a()).setReportInfo(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiReport.get().toByteArray());
      }
      ((QCirclePushRankTopView)a()).setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uys
 * JD-Core Version:    0.7.0.1
 */