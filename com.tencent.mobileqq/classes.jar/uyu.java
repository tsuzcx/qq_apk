import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uyu
  extends uzx
{
  private QCircleTagPageHeaderView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  private zxs jdField_a_of_type_Zxs;
  
  public uyu(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  }
  
  protected String a()
  {
    return "QCircleTagPageHeaderBlock";
  }
  
  public void handleShareDataChange(String paramString, zxs paramzxs)
  {
    super.handleShareDataChange(paramString, paramzxs);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.jdField_a_of_type_Zxs = paramzxs;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Zxs);
      }
    }
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Zxs);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyu
 * JD-Core Version:    0.7.0.1
 */