import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjp
  implements View.OnClickListener
{
  public sjp(SubScribeDraftItemView paramSubScribeDraftItemView, SubscribeDraftBean paramSubscribeDraftBean) {}
  
  public void onClick(View paramView)
  {
    if (!sox.fY("subscribe_draft_click"))
    {
      boolean bool = SubScribeDraftItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView);
      Intent localIntent = new Intent();
      localIntent.putExtra("postUin", SubScribeDraftItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView));
      localIntent.putExtra("has_shop", bool);
      localIntent.putExtra("subscribeDraftID", String.valueOf(this.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()));
      avpw.i((Activity)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), localIntent, 0);
      sqn.c(SubScribeDraftItemView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "clk_draftclk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjp
 * JD-Core Version:    0.7.0.1
 */