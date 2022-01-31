import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import java.util.ArrayList;

public class trf
  extends yei
{
  private QCircleMessageNoticeView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  private trt jdField_a_of_type_Trt;
  
  public trf(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView = new QCircleMessageNoticeView(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(yeb paramyeb) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Trt = ((trt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setData(this.jdField_a_of_type_Trt);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMessageNoticeView.setAdapterListener(new trg(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trf
 * JD-Core Version:    0.7.0.1
 */