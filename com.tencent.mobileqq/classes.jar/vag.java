import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vag
  extends vbn
{
  private aabn jdField_a_of_type_Aabn;
  private QCircleTagPageHeaderView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  
  public vag(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  }
  
  protected String a()
  {
    return "QCircleTagPageHeaderBlock";
  }
  
  public void handleShareDataChange(String paramString, aabn paramaabn)
  {
    super.handleShareDataChange(paramString, paramaabn);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.jdField_a_of_type_Aabn = paramaabn;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Aabn);
      }
    }
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Aabn);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vag
 * JD-Core Version:    0.7.0.1
 */