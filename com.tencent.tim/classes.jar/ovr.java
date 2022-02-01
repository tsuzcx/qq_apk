import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ovr
  extends ryh
{
  private QCircleTagPageHeaderView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  private rxn.b jdField_a_of_type_Rxn$b;
  
  public ovr(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView;
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    super.handleShareDataChange(paramString, paramb);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.jdField_a_of_type_Rxn$b = paramb;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Rxn$b);
      }
    }
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleTagPageHeaderView.setData(this.jdField_a_of_type_Rxn$b);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovr
 * JD-Core Version:    0.7.0.1
 */