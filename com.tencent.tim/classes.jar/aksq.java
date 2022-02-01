import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aksq
  implements View.OnClickListener
{
  aksq(aksl paramaksl, AutoReplyText paramAutoReplyText, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (aksl.a(this.b) != null) {
      aksl.a(this.b).b(this.c, this.val$isChecked);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksq
 * JD-Core Version:    0.7.0.1
 */