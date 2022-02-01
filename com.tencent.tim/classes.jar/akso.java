import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akso
  implements View.OnClickListener
{
  akso(aksl paramaksl, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    this.b.nR(this.c.getTextId());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akso
 * JD-Core Version:    0.7.0.1
 */