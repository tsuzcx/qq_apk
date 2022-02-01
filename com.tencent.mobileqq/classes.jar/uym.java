import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class uym
  extends uzx
{
  private QCircleMessageNoticeView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  private uzl jdField_a_of_type_Uzl;
  
  public uym(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView = new QCircleMessageNoticeView(getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  }
  
  protected String a()
  {
    return "QCircleMessage_QCircleMessageNoticeBubbleBlock";
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "onBindViewHolder");
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_Uzl = ((uzl)this.mDataList.get(paramInt));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView == null) {
        break label80;
      }
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView not null");
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setData(this.jdField_a_of_type_Uzl);
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
 * Qualified Name:     uym
 * JD-Core Version:    0.7.0.1
 */