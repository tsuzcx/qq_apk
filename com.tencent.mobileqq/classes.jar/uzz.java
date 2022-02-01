import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.polymerization.QCirclePatSamePolymerizationHeadView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class uzz
  extends vbn
{
  private QCirclePatSamePolymerizationHeadView a;
  
  public uzz(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.a = new QCirclePatSamePolymerizationHeadView(paramViewGroup.getContext());
    this.a.setReportBean(a());
    return this.a;
  }
  
  protected String a()
  {
    return "QCirclePatSamePolymerizationHeadBlock";
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.size() < 1) || (this.a == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      QLog.d("QCirclePatSamePolymerizationHeadBlock", 1, "QCirclePatSamePolymerizationHeadBlock setData i" + paramInt);
      if ((this.mDataList.get(paramInt) instanceof QQCircleFeedBase.StFeedListBusiRspData)) {
        this.a.setData(((QQCircleFeedBase.StFeedListBusiRspData)this.mDataList.get(paramInt)).fashionCopyPageData.get());
      }
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzz
 * JD-Core Version:    0.7.0.1
 */