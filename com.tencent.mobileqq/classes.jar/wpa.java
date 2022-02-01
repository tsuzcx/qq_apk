import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wpa
  implements View.OnClickListener
{
  public wpa(MsgTabStoryNodeView paramMsgTabStoryNodeView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.isShown()) {}
    for (int i = 1;; i = 0)
    {
      ykv.a("msg_tab", "clk_all", 0, i, new String[0]);
      bheh localbheh = bhey.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, "qqstory://qstory/open?from=msgTab");
      zdl.a(localbheh);
      if (localbheh != null) {
        localbheh.a();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpa
 * JD-Core Version:    0.7.0.1
 */