import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class uzw
  extends vbn
{
  private QCircleMessageNoticeView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  private vbb jdField_a_of_type_Vbb;
  
  public uzw(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView = new QCircleMessageNoticeView(getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  }
  
  protected String a()
  {
    return "QCircleMessage_QCircleMessageNoticeBubbleBlock";
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "onBindViewHolder");
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_Vbb = ((vbb)this.mDataList.get(paramInt));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView == null) {
        break label80;
      }
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView not null");
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setData(this.jdField_a_of_type_Vbb);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label80:
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView is null");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzw
 * JD-Core Version:    0.7.0.1
 */