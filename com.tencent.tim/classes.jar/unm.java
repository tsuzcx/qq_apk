import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unm
  implements View.OnClickListener
{
  public unm(ChatHistory.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.b.this$0.app.bH(this.SO, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unm
 * JD-Core Version:    0.7.0.1
 */