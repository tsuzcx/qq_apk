import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wyp
  implements View.OnClickListener
{
  public wyp(MsgTabStoryNodeView paramMsgTabStoryNodeView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.isShown()) {}
    for (int i = 1;; i = 0)
    {
      yup.a("msg_tab", "clk_all", 0, i, new String[0]);
      bhmr localbhmr = bhni.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, "qqstory://qstory/open?from=msgTab");
      znw.a(localbhmr);
      if (localbhmr != null) {
        localbhmr.a();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyp
 * JD-Core Version:    0.7.0.1
 */