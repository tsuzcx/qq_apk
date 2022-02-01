import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiqh
  implements View.OnClickListener
{
  public aiqh(BaseListenTogetherPanel.6 param6) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.h.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqh
 * JD-Core Version:    0.7.0.1
 */