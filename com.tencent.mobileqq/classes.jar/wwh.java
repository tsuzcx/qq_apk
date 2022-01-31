import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.qphone.base.util.QLog;

class wwh
  implements wth
{
  wwh(wwg paramwwg) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      xhb.b(SubScribeDraftItemView.b(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "delete_draft", 0, 0, new String[0]);
      paramString = new SubDraftChangeEvent();
      paramString.setDraftID(String.valueOf(this.a.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()));
      wpt.a().a(paramString);
      QLog.d(SubScribeDraftItemView.a(), 4, "delete draft success");
      return;
    }
    bcql.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), "delete failed", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwh
 * JD-Core Version:    0.7.0.1
 */