import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ashb
  implements View.OnClickListener
{
  ashb(asha paramasha) {}
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.this$0.getSystemService("clipboard")).setText(this.a.cEN);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashb
 * JD-Core Version:    0.7.0.1
 */