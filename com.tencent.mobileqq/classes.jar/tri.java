import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tri
  extends yiu
{
  private QCircleMessageNoticeView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  private try jdField_a_of_type_Try;
  
  public tri(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView = new QCircleMessageNoticeView(getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  }
  
  public void loadData(yii paramyii) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleAdapter", 1, "onBindViewHolder");
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_Try = ((try)this.mDataList.get(paramInt));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView != null)
      {
        QLog.d("QCircleMessage_QCircleMessageNoticeBubbleAdapter", 1, "mMessageNoticeView not null");
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setData(this.jdField_a_of_type_Try);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setAdapterListener(new trj(this));
      }
    }
    else
    {
      return;
    }
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleAdapter", 1, "mMessageNoticeView is null");
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tri
 * JD-Core Version:    0.7.0.1
 */