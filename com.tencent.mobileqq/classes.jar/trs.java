import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class trs
  extends yiu
{
  private QCircleTagPageHeaderView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  private yif jdField_a_of_type_Yif;
  
  public trs(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  }
  
  public void handleShareDataChange(String paramString, yif paramyif)
  {
    super.handleShareDataChange(paramString, paramyif);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.jdField_a_of_type_Yif = paramyif;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Yif);
      }
    }
  }
  
  public void loadData(yii paramyii) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Yif);
    }
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trs
 * JD-Core Version:    0.7.0.1
 */