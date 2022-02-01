import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class aogl
  implements View.OnClickListener
{
  aogl(aogk paramaogk) {}
  
  public void onClick(View paramView)
  {
    aogk.a(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogl
 * JD-Core Version:    0.7.0.1
 */