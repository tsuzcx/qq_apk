import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

public class ykz
  implements View.OnClickListener
{
  public ykz(SubScribeDraftItemView paramSubScribeDraftItemView, SubscribeDraftBean paramSubscribeDraftBean) {}
  
  public void onClick(View paramView)
  {
    yvu.b(SubScribeDraftItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "clk_delete_draft", 0, 0, new String[0]);
    yho.a().a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), SubScribeDraftItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), String.valueOf(this.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()), 2131720479, new yla(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykz
 * JD-Core Version:    0.7.0.1
 */