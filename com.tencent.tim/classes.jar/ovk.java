import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ovk
  extends ryh
{
  private QCircleMessageNoticeView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  private ovy jdField_a_of_type_Ovy;
  
  public ovk(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView = new QCircleMessageNoticeView(getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "onBindViewHolder");
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_Ovy = ((ovy)this.mDataList.get(paramInt));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView == null) {
        break label95;
      }
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView not null");
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setData(this.jdField_a_of_type_Ovy);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setAdapterListener(new ovl(this));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label95:
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView is null");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovk
 * JD-Core Version:    0.7.0.1
 */