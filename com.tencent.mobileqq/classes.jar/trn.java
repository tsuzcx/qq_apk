import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class trn
  extends yei
{
  private QCircleTagPageHeaderView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  private ydw jdField_a_of_type_Ydw;
  
  public trn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(String paramString, ydw paramydw)
  {
    super.a(paramString, paramydw);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.jdField_a_of_type_Ydw = paramydw;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Ydw);
      }
    }
  }
  
  public void a(yeb paramyeb) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Ydw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trn
 * JD-Core Version:    0.7.0.1
 */