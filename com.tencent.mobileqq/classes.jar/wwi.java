import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

public class wwi
  implements View.OnClickListener
{
  public wwi(SubScribeDraftItemView paramSubScribeDraftItemView, SubscribeDraftBean paramSubscribeDraftBean) {}
  
  public void onClick(View paramView)
  {
    if (!xeq.a("subscribe_draft_click"))
    {
      boolean bool = SubScribeDraftItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView);
      paramView = new Intent();
      paramView.putExtra("postUin", SubScribeDraftItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView));
      paramView.putExtra("has_shop", bool);
      paramView.putExtra("subscribeDraftID", String.valueOf(this.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()));
      bgxy.a((Activity)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), paramView, 0);
      xhe.b(SubScribeDraftItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "clk_draftclk", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwi
 * JD-Core Version:    0.7.0.1
 */