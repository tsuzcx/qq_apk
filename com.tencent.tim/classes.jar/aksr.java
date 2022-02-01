import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aksr
  implements View.OnClickListener
{
  aksr(aksl paramaksl, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    int i = this.c.getTextId();
    this.b.nR(i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksr
 * JD-Core Version:    0.7.0.1
 */