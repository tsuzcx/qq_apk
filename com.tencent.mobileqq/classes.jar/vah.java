import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.polymerization.QCircleTagPolymerizationHeadView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class vah
  extends vbn
{
  private QCircleTagPolymerizationHeadView a;
  
  public vah(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.a = new QCircleTagPolymerizationHeadView(paramViewGroup.getContext());
    this.a.setReportBean(a());
    return this.a;
  }
  
  protected String a()
  {
    return "QCircleTagPolymerizationHeadBlock";
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() < 1) || (this.a == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      QLog.d("QCircleTagPolymerizationHeadBlock", 1, "QcircleTagPolymerizationHeadView setData i" + paramInt);
      if ((this.mDataList.get(paramInt) instanceof QQCircleFeedBase.StFeedListBusiRspData)) {
        this.a.setData(((QQCircleFeedBase.StFeedListBusiRspData)this.mDataList.get(paramInt)).tagPageData.get());
      }
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */