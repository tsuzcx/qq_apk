import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pwk
  implements View.OnClickListener
{
  public pwk(MsgTabStoryNodeView paramMsgTabStoryNodeView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.xc.isShown()) {}
    for (int i = 1;; i = 0)
    {
      rar.a("msg_tab", "clk_all", 0, i, new String[0]);
      aqhv localaqhv = aqik.c(QQStoryContext.a(), this.val$context, "qqstory://qstory/open?from=msgTab");
      rom.checkNotNull(localaqhv);
      if (localaqhv != null) {
        localaqhv.ace();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwk
 * JD-Core Version:    0.7.0.1
 */